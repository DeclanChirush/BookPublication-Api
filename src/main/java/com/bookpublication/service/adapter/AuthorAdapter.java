package com.bookpublication.service.adapter;

import com.bookpublication.dal.model.Author;
import com.bookpublication.dto.AuthorDto;

import java.util.List;

/**
 * This class is the AuthorAdapter class
 * It is used to perform CRUD operations on the Author entity
 *
 */

public interface AuthorAdapter {
    String saveAuthor(AuthorDto authorDto);

    Author getAuthor(Long id);

    String updateAuthorById(Long id, AuthorDto authorDto);

    String deleteAuthor(Long id);

    List<Author> getAllAuthors();

}
