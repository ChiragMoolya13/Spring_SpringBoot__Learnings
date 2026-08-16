package com.chirag;

import com.chirag.model.Student;
import com.chirag.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.createStudent(new Student("Pushpa", "pushpa@gmail.com", 40));
//        studentRepository.updateStudent(new Student("Prayag Moolya", "prayagM@gmail.com", 21),2L);
//        studentRepository.deleteStudent(2L);
//        studentRepository.getStudentById(3L);
        studentRepository.getStudent();

    }
}

//jdbc:mysql://localhost:3306/