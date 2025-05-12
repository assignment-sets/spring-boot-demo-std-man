package com.personal.studentmanagement.repository;

import com.personal.studentmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
