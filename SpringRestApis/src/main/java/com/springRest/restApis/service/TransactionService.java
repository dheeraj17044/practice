package com.springRest.restApis.service;

import com.springRest.restApis.dao.BookDao;
import com.springRest.restApis.dao.CourseDao;
import com.springRest.restApis.entities.Book;
import com.springRest.restApis.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TransactionService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private MainService mainService;


    @Transactional
    public void transferMoney(Integer amount) {
        try {
            mainService.creditAccount(amount); // 1st save (Book)
        } catch (Exception e) {
            System.out.println("******* exception while crediting ********");
            System.out.println();
            e.printStackTrace();
        }

        debitAccount(amount); // 2nd save (Course)
        System.out.println("amount credited");
    }

    @Transactional
    public void debitAccount(Integer amount) {

        // saving course
        try {
            Course cs = new Course(21, "DSA", "Rohan");
            courseDao.save(cs);
        } catch (Exception e){
            System.out.println("********* exception while debiting *********");
            System.out.println();
            e.printStackTrace();
        }
    }

}
