package com.example.demo_mapper.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo_mapper.controller.dto.StudentForm;
import com.example.demo_mapper.domain.Student;
import com.example.demo_mapper.repository.StudentEntity;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

    private final LocalDate date = LocalDate.of(2000, 1, 1);
    private final String name = "test name";

    @Test
    void formToStudent() {
        // given
        StudentForm studentForm = new StudentForm(name, date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        // when
        Student student = StudentMapper.INSTANCE.formToStudent(studentForm);
        // then
        assertThat(date).isEqualTo(student.birthDate());
        assertThat(name).isEqualTo(student.name());
    }

    @Test
    void entityToStudent() {
        // given
        StudentEntity entity = new StudentEntity(1L, name, date);
        // when
        Student student = StudentMapper.INSTANCE.entityToStudent(entity);
        // then
        assertThat(date).isEqualTo(student.birthDate());
        assertThat(name).isEqualTo(student.name());
    }

    @Test
    void studentToEntity() {
        // given
        Student student = new Student(1L, name, date);
        // when
        StudentEntity entity = StudentMapper.INSTANCE.studentToEntity(student);
        // then
        assertThat(1L).isEqualTo(entity.getId());
        assertThat(date).isEqualTo(entity.getBirthDate());
        assertThat(name).isEqualTo(entity.getName());
    }
}