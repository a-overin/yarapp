package com.sndg.springbootapp.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sndg.springbootapp.model.Users;
import com.sndg.springbootapp.repository.UsersReportsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersReportsitory usersReportsitory;

    @GetMapping("/users")
    public List<Users> getUsers(){
        List<Users> userList = usersReportsitory.findAll();
        return userList;
    }
}
