package com.ayush.libraryManagement.controller;

import com.ayush.libraryManagement.dto.IssueRequest;
import com.ayush.libraryManagement.model.IssueRecord;
import com.ayush.libraryManagement.service.IssueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public IssueRecord issueBook(@RequestBody IssueRequest request) {
        return issueService.issueBook(request);
    }
    @PutMapping("/{id}/return")
    public IssueRecord returnBook(@PathVariable Long id) {
        return issueService.returnBook(id);
    }
}