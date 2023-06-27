package com.bookpublication.dal.repository;

import com.bookpublication.dal.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is the BookRepository class
 * It is used to perform CRUD operations on the Book entity
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
    Book findByIsbn(String isbn);
}
