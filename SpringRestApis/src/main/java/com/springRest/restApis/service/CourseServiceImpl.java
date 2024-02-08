package com.springRest.restApis.service;

import com.springRest.restApis.dao.CourseDao;
import com.springRest.restApis.dto.AddCourseRequestDto;
import com.springRest.restApis.dto.UpdateCourseRequestDto;
import com.springRest.restApis.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
//        return courseDao.getCourses();
    }

    @Override
    public Course getCourse(String courseId) {
        int csId = Integer.parseInt(courseId);
        Optional<Course> c = courseDao.findById(csId);
        if(c.isPresent())return c.get();
        return null;
    }

    @Override
    public void addCourse(AddCourseRequestDto course) {
        Course cs = new Course();
        cs.setTitle(course.getTitle());
        cs.setProfessor(course.getProfessor());
        courseDao.save(cs);
//        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        int csId = Integer.parseInt(courseId);
        courseDao.deleteById(csId);
//        return courseDao.deleteCourse(csId);
    }

    @Override
    public int updateCourse(UpdateCourseRequestDto course) {
        Optional<Course> courseDb = courseDao.findById(course.getId());
        if(courseDb.isPresent()){
            Course cs = courseDb.get();
            cs.setTitle(course.getTitle());
            cs.setProfessor(course.getProfessor());
            courseDao.save(cs);
            return cs.getId();
        }
        return -1;
    }

    @Override
    public List<Course> getCourseByTitle(String title) {
        return courseDao.findByTitle(title);
    }

    @Override
    public Course getCoursesByTitleAndProfessor(String courseTitle, String courseProfessor) {
        return courseDao.findByTitleAndProfessor(courseTitle,courseProfessor);
    }

    @Override
    public List<Course> getCoursesByTitleWithPattern(String courseTitleWithPattern) {
        return courseDao.findByTitleLike(courseTitleWithPattern);
    }

    @Override
    public List<Course> getAllCoursesByNativeQuery() {
        return courseDao.getAllCourse();
    }

}
