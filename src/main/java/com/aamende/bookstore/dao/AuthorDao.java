package com.aamende.bookstore.dao;

import com.aamende.bookstore.domain.Author;

import java.util.List;

public interface AuthorDao {
    void insert(Author author);
    Author getByName(String name);
    List<Author> getAll();
    void updateName(Long id, String newFirstName, String newSurname);
}
