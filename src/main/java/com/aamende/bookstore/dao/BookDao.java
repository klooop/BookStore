package com.aamende.bookstore.dao;

import com.aamende.bookstore.domain.Author;
import com.aamende.bookstore.domain.Book;

import java.util.List;

public interface BookDao {
    void insert(Book book);

    List<Book> getAll();
    Book getByTitle(String name);
    List<Book> getAllBooksByAuthorId(Long id);
}
