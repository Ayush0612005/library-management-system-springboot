package com.ayush.libraryManagement.controller;

import com.ayush.libraryManagement.model.Book;
import com.ayush.libraryManagement.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book updatedBook){

        return bookService.updateBook(id, updatedBook);
    }
}
