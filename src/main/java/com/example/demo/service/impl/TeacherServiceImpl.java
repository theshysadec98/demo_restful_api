package com.example.demo.service.impl;

import com.example.demo.exceptions.ValidateException;
import com.example.demo.models.entity.Teacher;
import com.example.demo.models.mapper.TeacherMapper;
import com.example.demo.models.request.TeacherRequest;
import com.example.demo.models.response.TeacherResponse;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    @Transactional(readOnly = true)
    public TeacherResponse getTeacherById(Long id) {
        return TeacherMapper.INSTANCE.toDto(getTeacher(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherResponse createTeacher(TeacherRequest request) {
        return TeacherMapper.INSTANCE.toDto(TeacherMapper.INSTANCE.toEntity(request));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherResponse updateTeacherById(Long id, TeacherRequest request) {
        Teacher teacher = getTeacher(id);
        TeacherMapper.INSTANCE.partialUpdate(teacher, request);
        teacher.setUpdateDate(Instant.now());
        teacher.setUpdateBy("system");
        return TeacherMapper.INSTANCE.toDto(teacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeTeacherById(Long id) {
        Teacher teacher = getTeacher(id);
        teacherRepository.delete(teacher);
    }

    private Teacher getTeacher(Long id){
        return teacherRepository.findById(id).orElseThrow(()-> new ValidateException("Teacher not exist"));
    }
}
