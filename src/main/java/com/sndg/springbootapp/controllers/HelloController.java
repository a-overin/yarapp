package com.sndg.springbootapp.controllers;

import com.sndg.springbootapp.model.User;
import com.sndg.springbootapp.repository.UsersReportsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping("/")
    public ResponseEntity<String> getPerson() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }
}
