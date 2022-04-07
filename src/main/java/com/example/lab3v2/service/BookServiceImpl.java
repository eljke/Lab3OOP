package com.example.lab3v2.service;

import com.example.lab3v2.exception.BookNotFoundException;
import com.example.lab3v2.model.Book;
import com.example.lab3v2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

//    // Хранилище книг
//    private static final Map<Integer, Book> BOOK_REPOSITORY_MAP = new HashMap<>();
//
//    // Переменная для генерации ID книги
//    private static final AtomicInteger BOOK_ID_HOLDER = new AtomicInteger();

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> selectAll() {
        return repository.findAll();
    }

    @Override
    public Book select(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book update(Book book, int id) {
        return repository.findById(id)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setPublishDate(book.getPublishDate());
                    return repository.save(b);
                })
                .orElseGet(() -> {
                    book.setId(id);
                    return repository.save(book);
                });
    }

    @Override
    public void delete(int id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}