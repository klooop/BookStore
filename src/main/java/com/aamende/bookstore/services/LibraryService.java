package com.aamende.bookstore.services;

import com.aamende.bookstore.domain.Author;
import com.aamende.bookstore.domain.Book;
import com.aamende.bookstore.domain.Genre;

import java.util.List;

public interface LibraryService {
    void createAuthor(String firstName, String secondName);
    void createGenre(String title);
    void createBook(String title, Long authorId, Long bookId);
    List<Author> getAllAuthors();
    List<Genre> getAllGenres();
    List<Book> getAllBooks();
    void updateAuthorNameAndSurname(Long id, String newFirstName, String newSurname);
}
