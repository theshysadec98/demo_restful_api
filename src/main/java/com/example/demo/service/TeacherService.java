package com.example.demo.service;

import com.example.demo.models.request.TeacherRequest;
import com.example.demo.models.response.TeacherResponse;

public interface TeacherService {
    TeacherResponse getTeacherById(Long id);

    TeacherResponse createTeacher(TeacherRequest request);

    TeacherResponse updateTeacherById(Long id,TeacherRequest request);

    void removeTeacherById(Long id);
}
