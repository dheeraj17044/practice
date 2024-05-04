package com.springRest.restApis.service;

import com.springRest.restApis.dao.BookDao;
import com.springRest.restApis.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainService {

    @Autowired
    CustomService service;

    @Autowired
    BookDao bookDao;

    @Transactional
    public void addCourseAndBook() throws Exception {

        service.addCourseAndBook();
    }

    @Transactional
    public void creditAccount(Integer amount) {
        // saving Book
        Book book = new Book("22","Atomic Habits","James Clear");
        bookDao.save(book);
    }
}
