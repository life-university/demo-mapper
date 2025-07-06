package com.example.demo_mapper.domain;

import java.time.LocalDate;

public record Student(
    Long id,
    String name,
    LocalDate birthDate
) {

}
