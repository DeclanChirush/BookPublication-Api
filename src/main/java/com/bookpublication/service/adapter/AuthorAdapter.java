package com.bookpublication.service.adapter;

import com.bookpublication.dal.model.Author;

import java.util.List;

/**
 * This class is the AuthorAdapter class
 * It is used to perform CRUD operations on the Author entity
 *
 */

public interface AuthorAdapter {
    String saveAuthor(Author author);

    Author getAuthor(Long id);

    String updateAuthorById(Long id, Author author);

    String deleteAuthor(Long id);

    List<Author> getAllAuthors();

}
