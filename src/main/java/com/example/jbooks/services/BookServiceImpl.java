package com.example.jbooks.services;

import com.example.jbooks.entities.Book;
import com.example.jbooks.BookInput;
import com.example.jbooks.repositories.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookInput book) {
        Book bookEntity = new Book();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setPages(book.getPages());

        return bookRepository.save(bookEntity);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book with id " + id + " not found"));
    }

    @Override
    public List<Book> getBooksByAuthor(long id) {
        return List.of();
    }
}
