package com.bookpublication.controller;

import com.bookpublication.api.BookApi;
import com.bookpublication.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the BookController class
 * It is used to create, get, update and delete book
 *
 */

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class BookController {

    private final BookApi bookApi;

    @Autowired
    public BookController(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    //Create a new book
    @PostMapping("/saveBook")
    public ResponseEntity saveBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookApi.saveBook(bookDto));
    }
}
