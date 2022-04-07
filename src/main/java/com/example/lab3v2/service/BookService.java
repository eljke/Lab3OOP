package com.example.lab3v2.service;

import com.example.lab3v2.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> selectAll();

    Book select(int id);

    Book update(Book book, int id);

    void delete(int id);

    void deleteAll();
}