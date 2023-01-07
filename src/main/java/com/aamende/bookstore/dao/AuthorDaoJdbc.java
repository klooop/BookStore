package com.aamende.bookstore.dao;

import com.aamende.bookstore.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {
    final String INSERT_QUERY = "insert into authors(firstname, surname) values (:firstname, :surname)";
    final String UPDATE_QUERY = "update authors set firstname=:firstname, surname =:surname where id=:id";
    final String SELECT_QUERY = "select * from authors";

    private NamedParameterJdbcOperations jdbc;
    @Autowired
    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Author author) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", author.getFirstName());
        params.put("surname", author.getSurname());
        jdbc.update(INSERT_QUERY, params);
    }

    @Override
    public Author getByName(String name) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query(SELECT_QUERY, new AuthorRowMapper());
    }

    @Override
    public void updateName(Long id, String newFirstName, String newSurname) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("firstname", newFirstName);
        params.put("surname", newSurname);
        jdbc.update(UPDATE_QUERY, params);
    }

    private static class AuthorRowMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String firstName = rs.getString("firstname");
            String surname = rs.getString("surname");
            return new Author(id, firstName, surname);
        }
    }

}
