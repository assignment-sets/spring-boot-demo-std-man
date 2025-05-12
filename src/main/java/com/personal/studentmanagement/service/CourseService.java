package com.personal.studentmanagement.service;

import com.personal.studentmanagement.model.Course;
import com.personal.studentmanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create or Update a course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by id
    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    // Delete a course
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
