package com.bookpublication.api;

import com.bookpublication.dal.model.Author;
import com.bookpublication.dto.AuthorDto;
import com.bookpublication.service.adapter.AuthorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is the AuthorApi class
 * It is used to create, get, update and delete author
 *
 */
@Service
public class AuthorApi{

    private final AuthorAdapter authorAdapter;

    @Autowired
    public AuthorApi(AuthorAdapter authorAdapter){
        this.authorAdapter = authorAdapter;
    }

    //Create a new author
    public String saveAuthor(AuthorDto authorDto){
        //Set authorDto to author
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setEmail(authorDto.getEmail());
        author.setContactNumber(authorDto.getContactNumber());

        return authorAdapter.saveAuthor(author);
    }

    //Get author by id
    public Author getAuthor(Long id){
        return authorAdapter.getAuthor(id);
    }

    //Update author by id
    public String updateAuthorById(Long id, AuthorDto authorDto){
        //Set authorDto to author
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setEmail(authorDto.getEmail());
        author.setContactNumber(authorDto.getContactNumber());

        return authorAdapter.updateAuthorById(id, author);
    }

    //Delete author by id
    public String deleteAuthor(Long id){
        return authorAdapter.deleteAuthor(id);
    }

    //Get all authors
    public List<Author> getAllAuthors(){
        return authorAdapter.getAllAuthors();
    }

}
