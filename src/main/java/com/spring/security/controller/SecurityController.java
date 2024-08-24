package com.spring.security.controller;

import com.spring.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SecurityController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Ram", 34),
            new Student(2, "Priya", 29),
            new Student(3, "Vedanti", 1)));


    @GetMapping("/")
    public String login(HttpServletRequest request) {
        return "You are in safe hand ):" + request.getSession().getId();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/token")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addStudent")
    public List<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return students;
    }
}
