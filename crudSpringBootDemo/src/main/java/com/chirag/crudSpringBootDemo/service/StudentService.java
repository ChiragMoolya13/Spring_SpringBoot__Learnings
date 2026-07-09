package com.chirag.crudSpringBootDemo.service;

import com.chirag.crudSpringBootDemo.dto.CreateStudentRequestDto;
import com.chirag.crudSpringBootDemo.dto.CreateStudentResponseDto;
import com.chirag.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import com.chirag.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import com.chirag.crudSpringBootDemo.entity.Student;
import com.chirag.crudSpringBootDemo.exception.ResourceNotFoundException;
import com.chirag.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReqDto){
       Student student = mapToEntity(studentReqDto);

       if(emailExists(student)){
            throw new DuplicateFormatFlagsException("Student with email " + student.getEmail() + "already exists")
       }
       Student studentResp = studentRepository.save(student);

       return mapToDto(studentResp);
    }


    public CreateStudentResponseDto getStudent(Long id){
        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResolutionException("Student with id " + id + " not found"));

        return mapToDto(studentResp);

    }

    public List<CreateStudentResponseDto> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList.stream().map(this::mapToDto).toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id " + id + " not found"));

        existingStudent.setName(studentReq.getName());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);

        return mapToUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id " + id + " not found"));
        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student with id " + id + " not found"));

        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDto studentReqDto){
        Student student = new Student();
        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setRollNo(studentReqDto.getRollNo());
        student.setSubject(studentReqDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student saved successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return  responseDto;

    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student updated successfully");
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return  responseDto;
    }

    private boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}
