package com.ayush.libraryManagement.service;

import com.ayush.libraryManagement.model.Book;
import com.ayush.libraryManagement.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.ayush.libraryManagement.exception.BookNotFoundException;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id));
    }
    public void deleteBook(Long id){

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id));

        bookRepository.delete(book);
    }
    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());

        return bookRepository.save(existingBook);
    }
}
