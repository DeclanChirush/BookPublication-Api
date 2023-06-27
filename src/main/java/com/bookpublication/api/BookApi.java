package com.bookpublication.api;

import com.bookpublication.dal.model.Book;
import com.bookpublication.dto.BookDto;
import com.bookpublication.service.adapter.BookAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is the BookApi class
 * It is used to perform CRUD operations on the Book entity
 */

@Service
public class BookApi {
    private final BookAdapter bookAdapter;

    @Autowired
    public BookApi(BookAdapter bookAdapter) {
        this.bookAdapter = bookAdapter;
    }

    //Create a new book
    public String saveBook(BookDto bookDto){
        return bookAdapter.saveBook(bookDto);
    }

    //Get a book
    public Book getBook(Long id){
        return bookAdapter.getBook(id);
    }

    //Update a book
    public String updateBookById(Long id, BookDto bookDto){
        return bookAdapter.updateBookById(id, bookDto);
    }

    //Delete a book
    public String deleteBook(Long id){
        return bookAdapter.deleteBook(id);
    }

    //Get all books
    public List<Book> getAllBooks(){
        return bookAdapter.getAllBooks();
    }

    //Get book by isbn
    public Book getBookByIsbn(String isbn){
        return bookAdapter.getBookByIsbn(isbn);
    }

}
