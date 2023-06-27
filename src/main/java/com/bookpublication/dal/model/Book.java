package com.bookpublication.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is used to represent the Book entity.
 * It is used to map the Book entity to the books table in the database.
 *
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String category;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore // Ignore the author field during serialization
    private Author author;

}
