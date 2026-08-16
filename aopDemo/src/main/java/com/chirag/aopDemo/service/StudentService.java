package com.chirag.aopDemo.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent(){
        System.out.println("Student Saved");
        return "Student Saved";
    }
}
