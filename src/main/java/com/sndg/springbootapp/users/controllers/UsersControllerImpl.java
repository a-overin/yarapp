package com.sndg.springbootapp.users.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sndg.springbootapp.users.controllers.models.UserRequest;
import com.sndg.springbootapp.users.controllers.models.UserResponse;
import com.sndg.springbootapp.users.models.User;
import com.sndg.springbootapp.users.repository.UsersRepository;
import com.sndg.springbootapp.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersControllerImpl implements UserController{

    private UserService userService;

    public UsersControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping(consumes = "application/json")
    public UserResponse getUser(@RequestBody HashMap<String, String> params) {
        UserRequest userRequest = new UserRequest(params);
        User user = userService.getUser(userRequest);
        return new UserResponse(user);
    }

    @Override
    @GetMapping("/all")
    public List<UserResponse> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return userList.stream()
                .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserResponse createUser(@RequestBody HashMap<String, String> params) {
        UserRequest userRequest = new UserRequest(params);
        User user = userService.createUser(userRequest);
        return new UserResponse(user);
    }

    @Override
    @PutMapping(consumes = "application/json")
    public UserResponse editUser(@RequestBody HashMap<String, String> params) {
        UserRequest userRequest = new UserRequest(params);
        User user = userService.editUser(userRequest);
        return new UserResponse(user);
    }

    @Override
    @PostMapping(value = "/login",consumes = "application/json")
    public UserResponse loginUser(@RequestBody HashMap<String, String> params) {
        UserRequest userRequest = new UserRequest(params);
        User user = userService.loginUser(userRequest);
        return new UserResponse(user);
    }

}
