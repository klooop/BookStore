package com.aamende.bookstore.services;

import com.aamende.bookstore.dao.AuthorDao;
import com.aamende.bookstore.dao.BookDao;
import com.aamende.bookstore.dao.GenreDao;
import com.aamende.bookstore.domain.Author;
import com.aamende.bookstore.domain.Book;
import com.aamende.bookstore.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private AuthorDao authorDao;
    private GenreDao genreDao;
    private BookDao bookDao;

    @Autowired

    public LibraryServiceImpl(AuthorDao authorDao, GenreDao genreDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.bookDao = bookDao;
    }
    @Override
    public void createAuthor(String firstName, String surname) {
        Author author = new Author(firstName, surname);
        authorDao.insert(author);
    }

    @Override
    public void createGenre(String title) {
        genreDao.insert(new Genre(title));
    }

    @Override
    public void createBook(String title, Long authorId, Long genreId) {
        bookDao.insert(new Book(title, authorId, genreId));
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public void updateAuthorNameAndSurname(Long id, String newFirstName, String newSurname) {
        authorDao.updateName(id, newFirstName, newSurname);
    }
}
