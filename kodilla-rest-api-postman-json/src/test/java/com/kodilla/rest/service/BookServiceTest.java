package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class BookServiceTest {

    private BookService bookService;
    private BookDto book1;
    private BookDto book2;

    @BeforeEach
    void setUp() {
        // Inicjalizacja BookService i przykładowych obiektów BookDto
        bookService = new BookService();
        book1 = new BookDto("Title1", "Author1");
        book2 = new BookDto("Title2", "Author2");
    }

    @Test
    void testAddBook() {
        // Dodajemy książkę do serwisu
        BookDto addedBook = bookService.addBook(book1);

        // Sprawdzamy, czy książka została dodana
        List<BookDto> books = bookService.getBooks();
        assertEquals(1, books.size());
        assertTrue(books.contains(addedBook));
    }

    @Test
    void testRemoveBook() {
        // Dodajemy książki
        bookService.addBook(book1);
        bookService.addBook(book2);

        // Usuwamy książkę
        bookService.removeBook(book1);

        // Sprawdzamy, czy książka została usunięta
        List<BookDto> books = bookService.getBooks();
        assertEquals(1, books.size());
        assertFalse(books.contains(book1));  // Sprawdzamy, że książka została usunięta
        assertTrue(books.contains(book2));   // Sprawdzamy, że druga książka jest nadal w liście
    }

    @Test
    void testGetBooks() {
        // Dodajemy książki
        bookService.addBook(book1);
        bookService.addBook(book2);

        // Sprawdzamy, czy zwrócone książki są zgodne z oczekiwaniami
        List<BookDto> books = bookService.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }
}
