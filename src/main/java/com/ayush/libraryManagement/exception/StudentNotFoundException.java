package com.ayush.libraryManagement.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException (String message) {
        super(message);
    }
}
