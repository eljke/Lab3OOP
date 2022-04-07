package com.example.lab3v2.controller;

import com.example.lab3v2.model.Book;
import com.example.lab3v2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/books")
    public Book insert(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping(value = "/books")
    public List<Book> selectAll() {
        return bookService.selectAll();
    }

    @GetMapping(value = "/books/{id}")
    public Book select(@PathVariable(name = "id") int id) {
        return bookService.select(id);
    }

    @PutMapping(value = "/books/{id}")
    public Book update(@PathVariable(name = "id") int id, @RequestBody Book book) {
        return bookService.update(book, id);
    }

    @DeleteMapping(value = "/books/{id}")
    public void delete(@PathVariable(name = "id") int id) {
      bookService.delete(id);
    }

    @DeleteMapping(value = "/books")
    public void deleteAll() {
        bookService.deleteAll();
    }
}