package com.sndg.springbootapp.users.services;

import com.sndg.springbootapp.users.controllers.models.UserRequest;
import com.sndg.springbootapp.users.models.User;

import java.util.List;

public interface UserService {

    User getUser(UserRequest userRequest);

    User createUser(UserRequest userRequest);

    User editUser(UserRequest userRequest);

    User loginUser(UserRequest userRequest);

    List<User> getAllUsers();
}
