package com.example.lab3v2.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(int id) {
        super("Could not find book with id = " + id);
    }
}