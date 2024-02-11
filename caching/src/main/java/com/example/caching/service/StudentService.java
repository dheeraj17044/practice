package com.example.caching.service;

import com.example.caching.dao.StudentDao;
import com.example.caching.dto.StudentRequestDto;
import com.example.caching.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public Student saveStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setRollNumber(studentRequestDto.getRollNumber());
        student.setCity(studentRequestDto.getCity());
        student.setName(studentRequestDto.getName());
        return studentDao.save(student);
    }

    @Cacheable(value = "student", key = "#roll")
    public Student getStudent(int roll){
        return studentDao.findById(roll).orElse(null);
    }

    @Cacheable(value = "course", key = "#roll")
    public Student getCourse(int roll){
        return studentDao.findById(roll).orElse(null);
    }
}
