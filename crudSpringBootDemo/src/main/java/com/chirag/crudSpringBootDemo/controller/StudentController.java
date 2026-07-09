package com.chirag.crudSpringBootDemo.controller;

import com.chirag.crudSpringBootDemo.dto.CreateStudentRequestDto;
import com.chirag.crudSpringBootDemo.dto.CreateStudentResponseDto;
import com.chirag.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import com.chirag.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import com.chirag.crudSpringBootDemo.entity.Student;
import com.chirag.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid  @RequestBody CreateStudentRequestDto studentRequestDto){
        CreateStudentResponseDto createdStudent = studentService.createStudent(studentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //read student
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id){
        CreateStudentResponseDto studentResp = studentService.getStudent(id);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent(){
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);
    }

    //update student
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentRequestDto studentReq){
        UpdateStudentRequestDto studentResp = studentService.updateStudent(id, studentReq);
        return ResponseEntity.ok(studentResp);
    }

    //delete student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.noContent().build();
    }
}
