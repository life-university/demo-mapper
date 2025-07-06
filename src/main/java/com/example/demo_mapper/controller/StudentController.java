package com.example.demo_mapper.controller;

import com.example.demo_mapper.controller.dto.StudentForm;
import com.example.demo_mapper.domain.Student;
import com.example.demo_mapper.service.StudentService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/student/new")
    public String newStudent(@Valid StudentForm form) {

        LocalDate birthDate = LocalDate.of(
            form.birthYear(),
            form.birthMonth(),
            form.birthDays()
        );

        // todo here we convert the StudentForm to a Student domain object
        Student student = new Student(null, form.name(), birthDate);
        studentService.save(student);

        return "success";

    }

}
