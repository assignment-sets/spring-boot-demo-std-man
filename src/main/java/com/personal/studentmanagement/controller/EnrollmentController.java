package com.personal.studentmanagement.controller;

import com.personal.studentmanagement.model.Enrollment;
import com.personal.studentmanagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments") // Base URL for all enrollment related operations
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Create or Update an enrollment (POST)
    @PostMapping
    public ResponseEntity<Enrollment> saveEnrollment(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(enrollmentService.saveEnrollment(enrollment), HttpStatus.CREATED);
    }

    // Get all enrollments (GET)
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return new ResponseEntity<>(enrollmentService.getAllEnrollments(), HttpStatus.OK);
    }

    // Get an enrollment by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable int id) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(id);
        return enrollment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete an enrollment by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable int id) {
        enrollmentService.deleteEnrollment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
