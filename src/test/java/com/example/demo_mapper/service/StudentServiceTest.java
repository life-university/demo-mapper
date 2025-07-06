package com.example.demo_mapper.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo_mapper.domain.Student;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    @Transactional
    void save() {
        // given
        Student student = new Student(null, "test name", LocalDate.of(2000, 1, 1));

        // when
        studentService.save(student);

        // then
        Student findStudent = studentService.getStudentById(1L);
        assertThat(findStudent.name()).isEqualTo(student.name());
    }
}
