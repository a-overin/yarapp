package com.sndg.springbootapp.users.controllers.models;

import java.util.HashMap;

public class UserRequest {

    private Long id;

    private String password;

    private HashMap<String, String> otherProp;

    public UserRequest() {
    }

    public UserRequest(HashMap<String, String> params) {
        this.id = params.containsKey("id") ? Long.parseLong(params.get("id")) : null;
        this.password = params.getOrDefault("password", null);
        this.otherProp = new HashMap<String, String>();
        for (HashMap.Entry<String, String> param: params.entrySet()){
            if (param.getKey() != "id" && param.getKey() != "password"){
                this.otherProp.put(param.getKey(), param.getValue());
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<String, String> getOtherProp() {
        return otherProp;
    }

    public void setOtherProp(HashMap<String, String> otherProp) {
        this.otherProp = otherProp;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", otherProp=" + otherProp +
                '}';
    }
}
