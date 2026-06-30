package com.chirag.crudSpringBootDemo.service;

import com.chirag.crudSpringBootDemo.entity.Student;
import com.chirag.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        System.out.println("Inside Student Service");
        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student Service");
        return studentResp;
    }
}
