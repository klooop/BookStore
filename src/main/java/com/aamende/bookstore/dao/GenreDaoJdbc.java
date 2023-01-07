package com.aamende.bookstore.dao;

import com.aamende.bookstore.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {
    private static final String SELECT_QUERY = "select * from genre";
    private static final String INSERT_QUERY = "insert into genre (title) values (:title)";
    private NamedParameterJdbcOperations jdbc;

    @Autowired
    public GenreDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Genre genre) {
        Map<String, Object> params = Collections.singletonMap("title", genre.getTitle());
        jdbc.update(INSERT_QUERY, params);
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query(SELECT_QUERY, new GenreRowMapper());
    }

    private static class GenreRowMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            return new Genre(id, title);
        }
    }
}
