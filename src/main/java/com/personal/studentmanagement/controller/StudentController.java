package com.personal.studentmanagement.controller;

import com.personal.studentmanagement.model.Student;
import com.personal.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students") // Base URL for all student related operations
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create or Update a student (POST)
    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    // Get all students (GET)
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    // Get a student by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a student by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
