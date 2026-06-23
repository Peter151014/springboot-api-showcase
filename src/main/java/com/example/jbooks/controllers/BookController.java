package com.example.jbooks.controllers;

import com.example.jbooks.BookInput;
import com.example.jbooks.entities.Book;
import com.example.jbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book createBook(@Argument BookInput book){
        return bookService.createBook(book);
    }

    @QueryMapping("allBooks")
    public List<Book> getBooks(){
        return bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book getBookById(@Argument("bookId") long id){
        return bookService.getBookById(id);
    }
}
