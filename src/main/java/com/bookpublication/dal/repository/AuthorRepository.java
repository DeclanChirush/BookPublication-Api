package com.bookpublication.dal.repository;

import com.bookpublication.dal.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is the AuthorRepository class
 * It is used to perform CRUD operations on the Author entity
 *
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
