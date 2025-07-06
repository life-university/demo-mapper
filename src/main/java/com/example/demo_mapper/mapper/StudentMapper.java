package com.example.demo_mapper.mapper;

import com.example.demo_mapper.controller.dto.StudentForm;
import com.example.demo_mapper.domain.Student;
import com.example.demo_mapper.repository.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    // Convert from StudentForm to Student
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "birthDate", expression = "java(MapperUtil.toLocalDate(form.birthYear(), form.birthMonth(), form.birthDays()))")
    Student formToStudent(StudentForm form);

    // Convert from StudentEntity to Student
    Student entityToStudent(StudentEntity entity);

    // Convert from Student to StudentEntity
    StudentEntity studentToEntity(Student student);

}
