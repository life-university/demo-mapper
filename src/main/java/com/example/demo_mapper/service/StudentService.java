package com.example.demo_mapper.service;

import com.example.demo_mapper.domain.Student;
import com.example.demo_mapper.repository.StudentEntity;
import com.example.demo_mapper.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow();
        // todo here we convert the StudentEntity to a Student domain object
        return new Student(
            studentEntity.getId(),
            studentEntity.getName(),
            studentEntity.getBirthDate()
        );
    }

    @Transactional
    public Student save(Student student) {
        // validate student data if necessary
        if (student == null || student.name() == null || student.birthDate() == null) {
            throw new IllegalArgumentException("Invalid student data");
        }

        // todo here we convert the Student to a StudentEntity domain object
        StudentEntity studentEntity = new StudentEntity(student.id(), student.name(), student.birthDate());
        StudentEntity savedEntity = studentRepository.save(studentEntity);

        // todo here we convert the StudentEntity to a Student domain object
        return new Student(
            savedEntity.getId(),
            savedEntity.getName(),
            savedEntity.getBirthDate()
        );
    }

}
