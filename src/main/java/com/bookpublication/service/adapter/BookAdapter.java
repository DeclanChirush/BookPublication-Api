package com.bookpublication.service.adapter;

import com.bookpublication.dal.model.Book;
import com.bookpublication.dto.BookDto;

import java.util.List;

/**
 * This class is the BookAdapter class
 * It is used to perform CRUD operations on the Book entity
 *
 */

public interface BookAdapter {
     String saveBook(BookDto bookDto);
     Book getBook(Long id);
     String updateBookById(Long id, BookDto bookDto);
     String deleteBook(Long id);
     List<Book> getAllBooks();
     Book getBookByIsbn(String isbn);
}
