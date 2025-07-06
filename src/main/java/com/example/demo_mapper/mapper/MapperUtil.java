package com.example.demo_mapper.mapper;

import java.time.LocalDate;

public class MapperUtil {

    public static LocalDate toLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

}
