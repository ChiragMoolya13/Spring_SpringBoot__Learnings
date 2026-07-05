package com.chirag.controller;

import com.chirag.entity.Student;
import com.chirag.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp = studentService.createStudent(studentReq);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentResp = studentService.getAllStudent();

        return ResponseEntity.ok(studentResp);
    }
}
