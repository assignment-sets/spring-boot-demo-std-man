package com.personal.studentmanagement.repository;

import com.personal.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
