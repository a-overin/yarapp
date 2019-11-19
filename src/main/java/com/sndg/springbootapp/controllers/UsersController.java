package com.sndg.springbootapp.controllers;

import com.sndg.springbootapp.model.User;
import com.sndg.springbootapp.repository.UsersReportsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersReportsitory usersReportsitory;

    @GetMapping("/users")
    public User getUsers(@RequestParam(value="telegramid") Long telegramId){
        User user = usersReportsitory.findByTelegramId(telegramId);
        return user;
    }

    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    public User registrUser(@RequestBody User tempUser){
        User user = usersReportsitory.findByTelegramId(tempUser.getTelegramId());
        if (user == null){
            user = new User(tempUser.getId(), tempUser.getTelegramId());
            usersReportsitory.save(user);
        }
        return user;
    }
}
