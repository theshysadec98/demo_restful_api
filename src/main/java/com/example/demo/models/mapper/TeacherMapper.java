package com.example.demo.models.mapper;

import com.example.demo.models.entity.Teacher;
import com.example.demo.models.request.TeacherRequest;
import com.example.demo.models.response.TeacherResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);
    Teacher toEntity(TeacherRequest request);

    TeacherResponse toDto(Teacher entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Teacher entity, TeacherRequest request);
}
