package com.chirag.aopIntroductionDemo.repository;

import com.chirag.aopIntroductionDemo.dto.Student;

public class StudentRepository {

    public void save (Student student){
        System.out.println("Student Saved");
    }
}
