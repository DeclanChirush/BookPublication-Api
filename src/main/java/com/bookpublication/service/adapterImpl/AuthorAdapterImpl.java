package com.bookpublication.service.adapterImpl;

import com.bookpublication.dal.model.Author;
import com.bookpublication.dal.model.Book;
import com.bookpublication.dal.repository.AuthorRepository;import com.bookpublication.dal.repository.BookRepository;
import com.bookpublication.dto.AuthorDto;
import com.bookpublication.service.adapter.AuthorAdapter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * This class is the AuthorAdapterImpl class
 * It is used to implement CRUD operations on the Author entity
 */

@Component
public class AuthorAdapterImpl implements AuthorAdapter {

    //Initialize logger
    private static final Logger logger = Logger.getLogger(AuthorAdapterImpl.class.getName());
    public final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public AuthorAdapterImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public String saveAuthor(AuthorDto authorDto) {

        //Check if authorDto is null
        if (authorDto == null) {
            logger.severe("Author should not be null");
            return "Author should not be null";
        }

        //Set authorDto to author
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setEmail(authorDto.getEmail());
        author.setContactNumber(authorDto.getContactNumber());

        //Check author firstname and lastname contains only letters
        if (!author.getFirstName().matches("[a-zA-Z]+") || !author.getLastName().matches("[a-zA-Z]+")) {
            return "Author firstname and lastname should contain only letters";
        }

        try {
            //Save author
            authorRepository.save(author);
        } catch (Exception e) {
            logger.severe("Author not saved : " + e.getMessage());
            return "Author not saved : " + e.getMessage();
        }

        //check if author is saved
        if (authorRepository.existsById(author.getId())) {
            logger.info("Author saved successfully");
            return "Author saved successfully";
        } else {
            logger.severe("Author not saved");
            return "Author not saved";
        }

    }

    @Override
    public Author getAuthor(Long id) {
        //Check if author exists
        if (authorRepository.existsById(id)) {
            logger.info("Author found");
            return authorRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public String updateAuthorById(Long id, AuthorDto authorDto) {

        //Check if author is null
        if (authorDto == null) {
            logger.severe("Author should not be null");
            return "Author should not be null";
        } else {

            //Set authorDto to author
            Author author = new Author();
            author.setFirstName(authorDto.getFirstName());
            author.setLastName(authorDto.getLastName());
            author.setEmail(authorDto.getEmail());
            author.setContactNumber(authorDto.getContactNumber());

            //Check author firstname and lastname contains only letters
            if (!author.getFirstName().matches("[a-zA-Z]+") || !author.getLastName().matches("[a-zA-Z]+")) {
                return "Author firstname and lastname should contain only letters";
            }

            try {
                //Find and update author
                Author authorToUpdate = authorRepository.findById(id).get();
                authorToUpdate.setFirstName(author.getFirstName());
                authorToUpdate.setLastName(author.getLastName());
                authorToUpdate.setEmail(author.getEmail());
                authorToUpdate.setContactNumber(author.getContactNumber());

                authorRepository.save(authorToUpdate);
                logger.info("Author updated successfully");

            } catch (Exception e) {
                logger.severe("Author not updated : " + e.getMessage());
                return "Author not updated : " + e.getMessage();
            }

            return "Author updated successfully";

        }

    }

    @Override
    @Transactional
    public String deleteAuthor(Long id) {
        //Check if author exists
        if (authorRepository.existsById(id)) {
            try {
                //Delete associated all books first
                bookRepository.deleteByAuthorId(id);

                //Delete author
                authorRepository.deleteById(id);
                logger.info("Author deleted successfully");
            } catch (Exception e) {
                logger.severe("Author not deleted : " + e.getMessage());
                return "Author not deleted : " + e.getMessage();
            }

            return "Author deleted successfully";

        } else {
            logger.severe("Author not found");
            return "Author not found";
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        logger.info("Authors found");
        return authorRepository.findAll();
    }

    @Override
    public void generateLikeCountReport() {

        //Get all authors
        List<Author> authors = authorRepository.findAll();

        //Check if authors is empty
        if (authors.isEmpty()) {
            logger.severe("No authors found");
            return;
        }

        //Iterate through authors
        for (Author author : authors) {

                //Get all books by author
                List<Book> books = bookRepository.findByAuthorId(author.getId());

                //Iterate through books
                for (Book book : books) {

                    //Get book likes
                    int likes = book.getLikeCount();

                    //print logger
                    logger.info("Author : " + author.getFirstName() + " " + author.getLastName() + ", Book : " + book.getTitle() + ", Likes : " + likes);
                }

        }
    }


}
