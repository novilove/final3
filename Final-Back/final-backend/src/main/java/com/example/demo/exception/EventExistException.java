package com.example.demo.exception;

public class EventExistException extends Exception {
    private String message;

    public EventExistException(String message){
        super(message);
    }
}
