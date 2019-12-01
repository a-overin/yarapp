package com.sndg.springbootapp.controllers;

import org.springframework.http.ResponseEntity;

public interface HelloController {
    public ResponseEntity<String> getHello();
}
