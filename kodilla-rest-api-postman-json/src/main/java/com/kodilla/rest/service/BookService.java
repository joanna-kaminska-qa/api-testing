package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<BookDto> books = new ArrayList<>();

    public List<BookDto> getBooks() {
        return books;
    }

    public BookDto addBook(BookDto bookDto) {
        books.add(bookDto);
        return bookDto;
    }

    public void removeBook(BookDto bookDto) {
        books.remove(bookDto);
    }
}