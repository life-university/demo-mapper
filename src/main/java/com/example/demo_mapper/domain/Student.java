package com.example.demo_mapper.domain;

import com.example.demo_mapper.controller.dto.StudentForm;
import com.example.demo_mapper.repository.StudentEntity;
import java.time.LocalDate;

public record Student(
    Long id,
    String name,
    LocalDate birthDate
) {

    public static Student fromEntity(StudentEntity entity) {
        return new Student(
            entity.getId(),
            entity.getName(),
            entity.getBirthDate()
        );
    }

    public static Student fromForm(StudentForm form) {
        LocalDate birthDate = LocalDate.of(
            form.birthYear(),
            form.birthMonth(),
            form.birthDays()
        );

        return new Student(
            null,
            form.name(),
            birthDate
        );
    }

}
