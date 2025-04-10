package com.example.onboarding.exceptions;

public class InvalidCSVRead extends RuntimeException {
    public InvalidCSVRead(String message) {
        super(message);
    }
}
