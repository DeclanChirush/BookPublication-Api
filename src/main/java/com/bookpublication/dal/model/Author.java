package com.bookpublication.dal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
