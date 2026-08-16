package com.chirag.aopIntroductionDemo.controller;

import com.chirag.aopIntroductionDemo.dto.Student;
import com.chirag.aopIntroductionDemo.service.StudentService;
import com.chirag.aopIntroductionDemo.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    public StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }
}
