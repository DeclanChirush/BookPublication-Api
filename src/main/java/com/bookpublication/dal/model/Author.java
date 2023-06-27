package com.bookpublication.dal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to represent the Author entity.
 * It is used to map the Author entity to the authors table in the database.
 *
 */
@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String contactNumber;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
