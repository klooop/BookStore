package com.aamende.bookstore.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class Author {
    private Long id;
    private String firstName;
    private String surname;

    public Author(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Author(Long id, String firstName, String surname) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }
}
