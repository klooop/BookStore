package com.aamende.bookstore.shell;

import com.aamende.bookstore.domain.Author;
import com.aamende.bookstore.domain.Book;
import com.aamende.bookstore.domain.Genre;
import com.aamende.bookstore.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class ApplicationLibraryCommands {
    LibraryService libraryService;

    @Autowired
    public ApplicationLibraryCommands(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @ShellMethod(value = "Select all authors", key = "sa")
    public String getAllAuthors() {
        List<Author> allAuthors = libraryService.getAllAuthors();
        StringBuilder returnString = new StringBuilder();
        allAuthors.forEach(a->returnString.append(a.toString()).append("\n"));
        return returnString.toString();
    }
    @ShellMethod(value = "Select all genres", key = "sg")
    public String getAllGenres() {
        List<Genre> allGenres = libraryService.getAllGenres();
        StringBuilder returnString = new StringBuilder();
        allGenres.forEach(a->returnString.append(a.toString()).append("\n"));
        return returnString.toString();
    }
    @ShellMethod(value = "Select all books", key = "sb")
    public String getAllBooks() {
        List<Book> allBooks = libraryService.getAllBooks();
        StringBuilder returnString = new StringBuilder();
        allBooks.forEach(a->returnString.append(a.toString()).append("\n"));
        return returnString.toString();
    }
    @ShellMethod(value = "Create author", key = "ca")
    public String createAuthor(String firstName, String secondName) {
        libraryService.createAuthor(firstName, secondName);
        return String.format("Created author: %s %s", firstName, secondName);
    }

    @ShellMethod(value = "Create genre", key = "cg")
    public String createGenre(String genre) {
        libraryService.createGenre(genre);
        return String.format("Created genre: %s", genre);
    }
    @ShellMethod(value = "Create book", key = "cb")
    public String createBook(String title, Long authorId, Long genreId) {
        libraryService.createBook(title, authorId, genreId);
        return String.format("Created book: %s", title);
    }
    @ShellMethod(value = "Update authors name", key = "ua")
    public String updateAuthorsName(Long id, String newFirstName, String newSurname) {
        libraryService.updateAuthorNameAndSurname(id, newFirstName, newSurname);
        return String.format("Updated author's name with id %d to -->> %s %s",id, newFirstName, newSurname);
    }

    @ShellMethod(value = "Update book's name", key = "ub")
    public String updateBooksName(String oldName, String newName) {
        return String.format("Updated book's name from %s to -->> %s", oldName, newName);
    }

    @ShellMethod(value = "Delete book", key = "db")
    public String deleteBookFromAuthor(String name) {
        return String.format("Deleted author's book named: %s", name);
    }

    @ShellMethod(value = "Delete author with books", key = "da")
    public String deleteAuthorWithBooks(String name) {
        return String.format("Deleted author's book named: %s", name);
    }


}
