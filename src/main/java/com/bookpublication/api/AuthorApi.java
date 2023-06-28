package com.bookpublication.api;

import com.bookpublication.dal.model.Author;
import com.bookpublication.dto.AuthorDto;
import com.bookpublication.service.adapter.AuthorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is the AuthorApi class
 * It is used to create, get, update and delete author
 *
 */
@Service
@EnableScheduling
public class AuthorApi{

    private final AuthorAdapter authorAdapter;

    @Autowired
    public AuthorApi(AuthorAdapter authorAdapter){
        this.authorAdapter = authorAdapter;
    }

    //Create a new author
    public String saveAuthor(AuthorDto authorDto){
        return authorAdapter.saveAuthor(authorDto);
    }

    //Get author by id
    public Author getAuthor(Long id){
        return authorAdapter.getAuthor(id);
    }

    //Update author by id
    public String updateAuthorById(Long id, AuthorDto authorDto){
        return authorAdapter.updateAuthorById(id, authorDto);
    }

    //Delete author by id
    public String deleteAuthor(Long id){
        return authorAdapter.deleteAuthor(id);
    }

    //Get all authors
    public List<Author> getAllAuthors(){
        return authorAdapter.getAllAuthors();
    }

    //Generate like count report
    @Scheduled(fixedRate = 300000) // Run every 5 minutes (300,000 milliseconds)
    public void generateLikeCountReport(){
        authorAdapter.generateLikeCountReport();
    }
}
