package com.bookpublication.controller;

import com.bookpublication.api.AuthorApi;
import com.bookpublication.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the AuthorController class
 * It is used to create, get, update and delete author
 *
 */

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class AuthorController {

    private final AuthorApi authorApi;

    @Autowired
    public AuthorController(AuthorApi authorApi){
        this.authorApi = authorApi;
    }

    //Create a new author
    @PostMapping("/saveAuthor")
    public ResponseEntity saveAuthor(@RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorApi.saveAuthor(authorDto));
    }

    //Get author by id
    @GetMapping("/getAuthorById/{id}")
    public ResponseEntity getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorApi.getAuthor(id));
    }

    //Update author by id
    @PutMapping("/updateAuthorById/{id}")
    public ResponseEntity updateAuthorById(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorApi.updateAuthorById(id, authorDto));
    }

    //Delete author by id
    @DeleteMapping("/deleteAuthorById/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        return ResponseEntity.ok(authorApi.deleteAuthor(id));
    }

    //Get all authors
    @GetMapping("/getAllAuthors")
    public ResponseEntity getAllAuthors(){
        return ResponseEntity.ok(authorApi.getAllAuthors());
    }
}
