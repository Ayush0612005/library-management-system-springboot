package com.ayush.libraryManagement.repository;

import com.ayush.libraryManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
