package com.bookpublication.service.adapterImpl;

import com.bookpublication.dal.model.Author;
import com.bookpublication.dal.model.Book;
import com.bookpublication.dal.repository.AuthorRepository;
import com.bookpublication.dal.repository.BookRepository;
import com.bookpublication.dto.BookDto;
import com.bookpublication.service.adapter.BookAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * This class is the BookAdapterImpl class
 * It is used to implement CRUD operations on the Book entity
 */

@Component
public class BookAdapterImpl implements BookAdapter {

    //Initialize logger
    private static final Logger logger = Logger.getLogger(AuthorAdapterImpl.class.getName());
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookAdapterImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public String saveBook(BookDto bookDto) {

        //check if isbn exists
        if (bookRepository.existsByIsbn(bookDto.getIsbn())) {
            logger.severe("Book with isbn " + bookDto.getIsbn() + " already exists");
            return "Book with isbn " + bookDto.getIsbn() + " already exists";
        }

        //Extract the bookDto data and save it in the book entity
        Book book = new Book();
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setCategory(bookDto.getCategory());

        //Retrieve the Author entity using the authorId from the request
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);

        try {
            //Save the book entity
            bookRepository.save(book);
            logger.info("Book saved successfully");
        } catch (Exception e) {
            logger.severe("Error saving book : " + e.getMessage());
            return "Error saving book";
        }

        return "Book saved successfully";
    }

    @Override
    public Book getBook(Long id) {
        //If book is not found, show error message
       if(bookRepository.existsById(id)){
           logger.info("Book found");
           return bookRepository.findById(id).get();
         }else{
           logger.severe("Book not found");
           return null;
       }
    }

    @Override
    public String updateBookById(Long id, BookDto bookDto) {

        //check if isbn exists
        if (bookRepository.existsByIsbn(bookDto.getIsbn())) {
            logger.severe("Book with isbn " + bookDto.getIsbn() + " already exists");
            return "Book with isbn " + bookDto.getIsbn() + " already exists";
        }

        //Retrieve the book entity using the id from the request
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        //Extract the bookDto data and save it in the book entity
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setCategory(bookDto.getCategory());

        //Retrieve the Author entity using the authorId from the request
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);

        try {
            //Save the book entity
            bookRepository.save(book);
            logger.info("Book updated successfully");
        } catch (Exception e) {
            logger.severe("Error updating book : " + e.getMessage());
            return "Error updating book";
        }

        return "Book updated successfully";

    }

    @Override
    public String deleteBook(Long id) {

        //check if book exists
        if (!bookRepository.existsById(id)) {
            logger.severe("Book not found");
            return "Book not found";
        }else{
            try {
                //Delete the book entity
                bookRepository.deleteById(id);
                logger.info("Book deleted successfully");
            } catch (Exception e) {
                return "Error deleting book";
            }
        }
        return "Book deleted successfully";
    }

    @Override
    public List<Book> getAllBooks() {
        logger.info("Books retrieved successfully");
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        //If book is not found, show error message
        if(bookRepository.existsByIsbn(isbn)){
            logger.info("Book found");
            //Retrieve the book entity using the isbn from the request
            return bookRepository.findByIsbn(isbn);

        }else{
            logger.severe("Book not found");
            return null;
        }
    }
}
