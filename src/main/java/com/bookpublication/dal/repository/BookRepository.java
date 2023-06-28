package com.bookpublication.dal.repository;

import com.bookpublication.dal.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class is the BookRepository class
 * It is used to perform CRUD operations on the Book entity
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
    Book findByIsbn(String isbn);
    void deleteByAuthorId(Long id);
    List<Book> findByAuthorId(Long id);
}
