package com.chirag.crudDtoDemo.service;

import com.chirag.crudDtoDemo.entity.Student;
import com.chirag.crudDtoDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        return studentRepository.save(studentReq);
    }
}
