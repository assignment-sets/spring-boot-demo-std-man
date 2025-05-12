package com.personal.studentmanagement.service;

import com.personal.studentmanagement.model.Enrollment;
import com.personal.studentmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Create or Update an enrollment
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Get enrollment by id
    public Optional<Enrollment> getEnrollmentById(int id) {
        return enrollmentRepository.findById(id);
    }

    // Delete an enrollment
    public void deleteEnrollment(int id) {
        enrollmentRepository.deleteById(id);
    }
}
