package com.bookpublication.api;

import com.bookpublication.dal.model.Book;
import com.bookpublication.dto.BookDto;
import com.bookpublication.service.adapter.BookAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
