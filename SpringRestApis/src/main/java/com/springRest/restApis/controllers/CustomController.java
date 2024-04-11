package com.springRest.restApis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springRest.restApis.service.CustomService;

@RestController
public class CustomController {

    @Autowired
    private CustomService customService;

    @GetMapping("/transact")
    public ResponseEntity<Object> getHome(){
        customService.addCourseAndBook();
        return new ResponseEntity<>("exploring the transactional working", HttpStatus.OK);
    }
}
