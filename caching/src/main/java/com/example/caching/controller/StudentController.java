package com.example.caching.controller;


import com.example.caching.dto.StudentRequestDto;
import com.example.caching.entities.Student;
import com.example.caching.service.MyCacheService;
import com.example.caching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    private final StudentService studentService;
    private final MyCacheService myCacheService;

    @Autowired
    public StudentController(StudentService studentService, MyCacheService myCacheService){
        this.studentService = studentService;
        this.myCacheService = myCacheService;
    }


    @GetMapping("/student/{roll}")
    public ResponseEntity<Student> getStudent(@PathVariable String roll) {
        Student student = studentService.getStudent(Integer.parseInt(roll));
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/course/{roll}")
    public ResponseEntity<Student> getCourse(@PathVariable String roll) {
        Student student = studentService.getCourse(Integer.parseInt(roll));
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.saveStudent(studentRequestDto);
        return new ResponseEntity<>("added successfully",HttpStatus.OK);
    }

    @PostMapping("add/student/manual/")
    public ResponseEntity<Object> addStudentInCache() {
        Student st = new Student(1,"Dheeraj","Delhi");
        myCacheService.addDataInCache(1,st);
        return new ResponseEntity<>("added successfully",HttpStatus.OK);
    }

    @GetMapping("get/student/manual/")
    public ResponseEntity<Student> getDataFromCache() {
        Student student = myCacheService.getDataFromCache(1);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping("delete/student/manual/")
    public ResponseEntity<Object> deleteDataFromCache() {
        myCacheService.deleteDataFromCache(1);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

}