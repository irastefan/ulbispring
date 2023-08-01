package com.example.ulbispring.exception;

public class UserAlreadyExists extends Exception{
    public UserAlreadyExists(String message) {
        super(message);
    }
}
