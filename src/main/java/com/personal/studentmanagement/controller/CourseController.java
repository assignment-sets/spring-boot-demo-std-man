package com.personal.studentmanagement.controller;

import com.personal.studentmanagement.model.Course;
import com.personal.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses") // Base URL for all course related operations
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create or Update a course (POST)
    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    // Get all courses (GET)
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    // Get a course by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a course by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
