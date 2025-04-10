package com.example.onboarding.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping
    public ResponseEntity<String> HelloWorld() {
        return new ResponseEntity<>("Hello", HttpStatusCode.valueOf(200));
    }
}
