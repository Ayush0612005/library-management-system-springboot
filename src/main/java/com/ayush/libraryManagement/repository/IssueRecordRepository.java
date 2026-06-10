package com.ayush.libraryManagement.repository;

import com.ayush.libraryManagement.model.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRecordRepository extends JpaRepository<IssueRecord, Long> {
}
