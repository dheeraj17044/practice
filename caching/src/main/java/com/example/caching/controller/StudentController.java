package com.example.caching.controller;


import com.example.caching.dto.StudentRequestDto;
import com.example.caching.entities.Student;
import com.example.caching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{roll}")
    public ResponseEntity<Student> getStudent(@PathVariable String roll) {
        Student student = studentService.getStudent(Integer.parseInt(roll));
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.saveStudent(studentRequestDto);
        return new ResponseEntity<>("added successfully",HttpStatus.OK);
    }

}