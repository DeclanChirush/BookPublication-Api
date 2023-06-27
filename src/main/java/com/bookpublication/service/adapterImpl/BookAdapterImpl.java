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

/**
 * This class is the BookAdapterImpl class
 * It is used to implement CRUD operations on the Book entity
 */

@Component
public class BookAdapterImpl implements BookAdapter {

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
        } catch (Exception e) {
            return "Error saving book";
        }

        return "Book saved successfully";
    }

    @Override
    public Book getBook(Long id) {
        //Retrieve the book entity using the id from the request
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        return book;
    }

    @Override
    public String updateBookById(Long id, BookDto bookDto) {

        //check if isbn exists
        if (bookRepository.existsByIsbn(bookDto.getIsbn())) {
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
        } catch (Exception e) {
            return "Error updating book";
        }

        return "Book updated successfully";

    }

    @Override
    public String deleteBook(Long id) {

        //check if book exists
        if (!bookRepository.existsById(id)) {
            return "Book not found";
        }else{
            //Retrieve the book entity using the id from the request
            Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

            try {
                //Delete the book entity
                bookRepository.delete(book);
            } catch (Exception e) {
                return "Error deleting book";
            }
        }
        return "Book deleted successfully";
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
