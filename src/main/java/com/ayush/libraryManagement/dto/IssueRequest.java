package com.ayush.libraryManagement.dto;

public class IssueRequest {

    private Long studentId;
    private Long bookId;

    public IssueRequest() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}