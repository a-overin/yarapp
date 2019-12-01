package com.sndg.springbootapp.users.controllers.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sndg.springbootapp.users.models.User;

@JsonSerialize
public class UserResponse {

    private Long id;

    public UserResponse() {
    }

    public UserResponse(final User user) {
        this.id = user != null ? user.getId(): null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
