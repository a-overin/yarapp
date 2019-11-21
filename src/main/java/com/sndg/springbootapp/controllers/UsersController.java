package com.sndg.springbootapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sndg.springbootapp.model.User;
import com.sndg.springbootapp.repository.UsersReportsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersReportsitory usersReportsitory;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        List<User> listUser = usersReportsitory.findAll();
        return listUser;
    }

    @GetMapping("")
    public User getUsers(@RequestParam(value="telegramid") Long telegramId){
        User user = usersReportsitory.findByTelegramId(telegramId);
        return user;
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public User registrUser(@RequestBody String params) throws JsonProcessingException {
        HashMap<String, Object> paramsList = new ObjectMapper().readValue(params, HashMap.class);
        User user = null;
        HttpStatus status;
        if (paramsList.get("id") != null){
            Optional<User> optionalUser = usersReportsitory.findById(Long.parseLong(paramsList.get("id").toString()));
            if (optionalUser.isPresent()){
                user = optionalUser.get();
            }
        }else if (paramsList.get("telegramId") != null){
            user = usersReportsitory.findByTelegramId(Long.parseLong(paramsList.get("telegramId").toString()));
        }
        if (user == null && paramsList.get("id") != null){
            user = new User(paramsList.get("id").toString(), paramsList.get("telegramId").toString());
            usersReportsitory.save(user);
        }
        if (user!= null) {
            return user;
        }
        else {
            throw new RuntimeException("required param: \"id\"");
        }
    }
}
