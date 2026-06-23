package com.example.jbooks.services;

import com.example.jbooks.BookInput;
import com.example.jbooks.entities.Book;

import org.springframework.graphql.data.method.annotation.Argument;
import java.util.List;

public interface BookService {
    Book createBook(BookInput book);

    List<Book> getBooksByAuthor(@Argument long id);

    Book getBookById(@Argument long id);

    List<Book> getAll();


}
