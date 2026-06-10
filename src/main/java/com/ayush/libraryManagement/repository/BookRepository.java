package com.ayush.libraryManagement.repository;

import com.ayush.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
