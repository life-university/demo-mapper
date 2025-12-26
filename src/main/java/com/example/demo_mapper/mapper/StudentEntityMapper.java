package com.example.demo_mapper.mapper;

import com.example.demo_mapper.domain.Student;
import com.example.demo_mapper.repository.StudentEntity;

public class StudentEntityMapper {

    public static StudentEntity fromStudent(Student student) {
        return new StudentEntity(
            student.id(),
            student.name(),
            student.birthDate()
        );
    }

}
