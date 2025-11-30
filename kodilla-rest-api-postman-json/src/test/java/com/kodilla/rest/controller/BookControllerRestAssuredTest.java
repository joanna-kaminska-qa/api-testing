package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@ExtendWith(MockitoExtension.class)
class BookControllerRestAssuredTest {

    BookDto book1;
    BookDto book2;

    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(bookController);
        book1 = new BookDto("Title 1", "Author 1");
        book2 = new BookDto("Title 2", "Author 2");
    }

    @Test
    void shouldFetchBooks() {
        // given
        Mockito.when(bookService.getBooks())
                .thenReturn(List.of(book1, book2));
        // when then
        given().
        when()
                .get("/books")
        .then()
                .body("$.size()", Matchers.equalTo(2))
                .body("[0].title", Matchers.equalTo("Title 1"))
                .body("[0].author", Matchers.equalTo("Author 1"))
                .body("[1].title", Matchers.equalTo("Title 2"))
                .body("[1].author", Matchers.equalTo("Author 2"))
                .status(HttpStatus.OK);
    }

    @Test
    void shouldAddBooks() {
        // given

        Mockito.when(bookService.addBook(book1))
                .thenReturn(book1);
        // when then
        given()
                .contentType(ContentType.JSON)
                .body(book1)
        .when()
                .post("/books")
        .then()
                .status(HttpStatus.CREATED)
                .body("title", Matchers.equalTo("Title 1"))
                .body("author", Matchers.equalTo("Author 1"));
    }

}