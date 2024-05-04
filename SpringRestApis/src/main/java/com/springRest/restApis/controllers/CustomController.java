package com.springRest.restApis.controllers;

import com.springRest.restApis.service.CheckRollback;
import com.springRest.restApis.service.MainService;
import com.springRest.restApis.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @Autowired
    private MainService mainService;

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CheckRollback checkRollback;

    @GetMapping("/transact")
    public ResponseEntity<Object> getHome() throws Exception {
        mainService.addCourseAndBook();
        return new ResponseEntity<>("exploring the transactional working", HttpStatus.OK);
    }


    @GetMapping("/transact/working/{amount}")
    public ResponseEntity<Object> getTransact(@PathVariable Integer amount) throws Exception {
        try
        {
            checkRollback.rollbackSection(amount);
        }
        catch (Exception ex)
        {
            System.out.println("Caught the final Exception");
            System.out.println();
            System.out.println();
            System.out.println();
            ex.printStackTrace();


        }

        return new ResponseEntity<>("Transactional Propagation Working", HttpStatus.OK);
    }
}
