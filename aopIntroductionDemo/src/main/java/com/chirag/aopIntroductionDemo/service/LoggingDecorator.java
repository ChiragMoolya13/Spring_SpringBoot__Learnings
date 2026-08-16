package com.chirag.aopIntroductionDemo.service;

import com.chirag.aopIntroductionDemo.dto.Student;

public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentServiceimpl;

    public LoggingDecorator(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }

    @Override
    public void createStudent(Student student) {
        // Logging related logic

        LoggingServiceUtil.logStart(
                "StudentServiceImpl", "createStudent");

        studentServiceimpl.createStudent(student);

        LoggingServiceUtil.logEnd(
                "StudentServiceImpl", "createStudent");


    }
}
