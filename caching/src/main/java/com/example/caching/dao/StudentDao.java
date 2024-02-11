package com.example.caching.dao;

import com.example.caching.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {


//    ********** Derived Query methods *************


//    List<Course> findByTitle(String title);
//    Course findByTitleAndProfessor(String title, String professor);
//
//    List<Course> findByTitleLike(String likePattern);



//    *********** Custom Finder Methods ************

//    @Query(value="select * from course",nativeQuery = true)
//    List<Course> getAllCourse();

//    List<Course> getCourses();
//    Course getCourse(int courseId);
//    void addCourse(Course course);
//
//    Course deleteCourse(int csId);
//
//    int updateCourse(Course course);
}