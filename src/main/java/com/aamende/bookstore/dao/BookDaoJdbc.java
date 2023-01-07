package com.aamende.bookstore.dao;


import com.aamende.bookstore.domain.Book;
import com.aamende.bookstore.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {
    private static final String SELECT_QUERY = "select * from books";
    private static final String INSERT_QUERY = "insert into books (title, author_id, genre_id)" +
            " values (:title, :authorId, :genreId)";
    private NamedParameterJdbcOperations jdbc;

    @Autowired
    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public void insert(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", book.getTitle());
        params.put("authorId", book.getAuthorId());
        params.put("genreId", book.getGenreId());
        jdbc.update(INSERT_QUERY, params);
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query(SELECT_QUERY, new BookRowMapper());
    }

    @Override
    public Book getByTitle(String name) {
        return null;
    }

    @Override
    public List<Book> getAllBooksByAuthorId(Long id) {
        return null;
    }

    private static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            Long authorId = rs.getLong("author_id");
            Long genreId = rs.getLong("genre_id");
            return new Book(id, title, authorId, genreId);
        }
    }
}
