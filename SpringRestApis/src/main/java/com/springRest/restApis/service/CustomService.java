package com.springRest.restApis.service;

import com.springRest.restApis.dao.BookDao;
import com.springRest.restApis.dao.CourseDao;
import com.springRest.restApis.entities.Book;
import com.springRest.restApis.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private BookDao bookDao;

    public void addCourseAndBook() {
        // saving course first
        Course cs = new Course();
        cs.setTitle("DSA");
        cs.setProfessor("Rohan");
        courseDao.save(cs);


        // saving Book
        Book book = new Book();
        book.setName("Atomic Habits");
        book.setAuthor("James Clear");
        bookDao.save(book);
    }
}
