//package com.springRest.restApis.dao;
//
//import com.springRest.restApis.entities.Course;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class CourseDaoImpl implements CourseDao{
//



        /*  ---------------- ---------------- WORKING WITH STATIC DATA -------------------  ------------------- */




//    private static List<Course> courses = new ArrayList<>();
//
//    static{
//        courses.add(new Course(1,"Introduction To Programing","Vikram Goyal"));
//        courses.add(new Course(2,"DSA","Rahul Purandere"));
//        courses.add(new Course(3,"Advance Programming","Vivek Kumar"));
//    }
//
//    @Override
//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    @Override
//    public Course getCourse(int courseId) {
//        for(Course course:courses){
//            if(course.getId()==courseId){
//                return course;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addCourse(Course course) {
//        courses.add(course);
//
//    }
//
//    @Override
//    public Course deleteCourse(int csId) {
//        for(int i=0;i<courses.size();i++){
//            Course course = courses.get(i);
//            if(course.getId()==csId){
//                courses.remove(course);
//                return course;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int updateCourse(Course course) {
//        for(Course cs:courses){
//            if(cs.getId()==course.getId()){
//                cs.setTitle(course.getTitle());
//                cs.setProfessor(course.getProfessor());
//                return cs.getId();
//            }
//        }
//        return -1;
//    }
//}
