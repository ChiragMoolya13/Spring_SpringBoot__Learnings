package com.chirag.crudSpringBootDemo.repository;

import com.chirag.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){
        System.out.println("Inside Student Repository");
        System.out.println("Exiting Student Repository");
        Student s1 = new Student();
        s1.setName("Chirag");
        s1.setAge(30);
        s1.setEmail("chirag@gmail.com");
        s1.setRollNo(101);
        s1.setSubject("Spring Framework");

        return s1;
    }
}
