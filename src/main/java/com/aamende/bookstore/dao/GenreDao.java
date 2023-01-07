package com.aamende.bookstore.dao;

import com.aamende.bookstore.domain.Genre;

import java.util.List;

public interface GenreDao {
    void insert(Genre genre);
    List<Genre> getAll();
}
