package com.chirag.aopDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(String com.chirag.aopDemo.service.StudentService.createStudent())")
    public void logBeforeMethod(){
        System.out.println("Student is going to be saved");
    }

    @AfterReturning("execution(String com.chirag.aopDemo.service.StudentService.createStudent())")
    public void logAfterReturningMethod(JoinPoint joinPoint){
        System.out.println("logAfterReturningMethod called");
    }
}
