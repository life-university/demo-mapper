package com.example.demo_mapper.repository;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @Transactional
    void saveStudent() {
        // given
        StudentEntity student = new StudentEntity(null, "test name", LocalDate.of(2000, 1, 1));

        // when
        StudentEntity saved = studentRepository.save(student);
        var findSavedId = studentRepository.findById(saved.getId()).get().getId();

        // then
        assertEquals(1, findSavedId);
    }

}
