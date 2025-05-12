package com.personal.studentmanagement.repository;

import com.personal.studentmanagement.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
