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
        return null;
    }

    @Override
    public String updateBookById(Long id, BookDto bookDto) {
        return null;
    }

    @Override
    public String deleteBook(Long id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }
}
