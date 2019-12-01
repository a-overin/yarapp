package com.sndg.springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloControllerImpl implements HelloController{
    @GetMapping("/")
    public ResponseEntity<String> getHello() {

        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }
}
