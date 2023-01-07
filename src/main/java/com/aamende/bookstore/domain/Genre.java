package com.aamende.bookstore.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Genre {
    private Long id;
    private String title;

    public Genre(String title) {
        this.title = title;
    }

    public Genre(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
