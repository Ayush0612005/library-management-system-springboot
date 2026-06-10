package com.ayush.libraryManagement.service;

import com.ayush.libraryManagement.model.Book;
import com.ayush.libraryManagement.repository.BookRepository;
import org.springframework.stereotype.Service;

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
        return bookRepository.findById(id).orElse(null);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = bookRepository.findById(id).orElse(null);

        if(existingBook == null){
            return null;
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());

        return bookRepository.save(existingBook);
    }
}
