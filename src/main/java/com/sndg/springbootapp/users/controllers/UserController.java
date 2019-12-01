package com.sndg.springbootapp.users.controllers;

import com.sndg.springbootapp.users.controllers.models.UserResponse;

import java.util.HashMap;
import java.util.List;

public interface UserController {

    UserResponse getUser(HashMap<String, String> params);

    List<UserResponse> getAllUsers();

    UserResponse createUser(HashMap<String, String> params);

    UserResponse editUser(HashMap<String, String> params);

    UserResponse loginUser(HashMap<String, String> params);
}
