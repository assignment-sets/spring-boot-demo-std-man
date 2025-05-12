package com.personal.studentmanagement.service;

import com.personal.studentmanagement.model.Student;
import com.personal.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create or Update a student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by id
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // Delete a student
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
