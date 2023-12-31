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

    //Get book by id
    @GetMapping("/getBookById/{id}")
    public ResponseEntity getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookApi.getBook(id));
    }

    //Update book by id
    @PutMapping("/updateBookById/{id}")
    public ResponseEntity updateBookById(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookApi.updateBookById(id, bookDto));
    }

    //Delete book by id
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookApi.deleteBook(id));
    }

    //Get all books
    @GetMapping("/getAllBooks")
    public ResponseEntity getAllBooks() {
        return ResponseEntity.ok(bookApi.getAllBooks());
    }

    //Get book by isbn
    @GetMapping("/getBookByIsbn/{isbn}")
    public ResponseEntity getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(bookApi.getBookByIsbn(isbn));
    }

    //Add like count
    @PutMapping("/addLikeCount/{id}")
    public ResponseEntity addLikeCount(@PathVariable Long id) {
        return ResponseEntity.ok(bookApi.addLikeCount(id));
    }

    //Remove like count
    @PutMapping("/removeLikeCount/{id}")
    public ResponseEntity removeLikeCount(@PathVariable Long id) {
        return ResponseEntity.ok(bookApi.removeLikeCount(id));
    }

    //Get like count
    @GetMapping("/getLikeCount/{id}")
    public ResponseEntity getLikeCount(@PathVariable Long id) {
        return ResponseEntity.ok(bookApi.getLikeCount(id));
    }
}
