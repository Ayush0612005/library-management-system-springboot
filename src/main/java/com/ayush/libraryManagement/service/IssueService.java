package com.ayush.libraryManagement.service;

import com.ayush.libraryManagement.dto.IssueRequest;
import com.ayush.libraryManagement.exception.BookNotAvailableException;
import com.ayush.libraryManagement.exception.BookNotFoundException;
import com.ayush.libraryManagement.exception.IssueRecordNotFoundException;
import com.ayush.libraryManagement.exception.StudentNotFoundException;
import com.ayush.libraryManagement.model.Book;
import com.ayush.libraryManagement.model.IssueRecord;
import com.ayush.libraryManagement.model.Student;
import com.ayush.libraryManagement.repository.BookRepository;
import com.ayush.libraryManagement.repository.IssueRecordRepository;
import com.ayush.libraryManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IssueService {

    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final IssueRecordRepository issueRecordRepository;

    public IssueService(BookRepository bookRepository,
                        StudentRepository studentRepository,
                        IssueRecordRepository issueRecordRepository) {

        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.issueRecordRepository = issueRecordRepository;
    }


    public IssueRecord issueBook(IssueRequest request) {

        Student student = studentRepository
                .findById(request.getStudentId())
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: "
                                        + request.getStudentId()));

        Book book = bookRepository
                .findById(request.getBookId())
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: "
                                        + request.getBookId()));

        if (!book.isAvailable()) {
            throw new BookNotAvailableException(
                    "Book is already issued");
        }

        IssueRecord issueRecord = new IssueRecord();

        issueRecord.setStudent(student);
        issueRecord.setBook(book);

        issueRecord.setIssueDate(LocalDate.now());

        book.setAvailable(false);

        bookRepository.save(book);

        return issueRecordRepository.save(issueRecord);
    }
    public IssueRecord returnBook(Long issueId){

        IssueRecord issueRecord = issueRecordRepository
                .findById(issueId)
                .orElseThrow(() ->
                        new IssueRecordNotFoundException(
                                "Issue record not found with id: " + issueId));
        Book book = issueRecord.getBook();

        issueRecord.setReturnDate(LocalDate.now());

        book.setAvailable(true);

        bookRepository.save(book);

        return issueRecordRepository.save(issueRecord);
    }
}
