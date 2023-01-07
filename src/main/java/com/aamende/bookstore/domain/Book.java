package com.aamende.bookstore.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {
    private Long id;
    private String title;
    // плохая практика, лучше использовать объект Author тут,
    // т к это доменная область
    private Long authorId;
    private Long genreId;

    public Book(Long id, String title, Long authorId, Long genreId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public Book(String title, Long authorId, Long genreId) {
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
    }
}
