package com.chirag.crudDtoDemo.repository;

import com.chirag.crudDtoDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public class StudentRepository extends JpaRepository<Student, Long>{
}
