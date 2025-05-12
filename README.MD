CREATE TABLE enrollments (
id INT AUTO_INCREMENT PRIMARY KEY,
student_id INT NOT NULL,
course_id INT NOT NULL,
enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

CREATE TABLE courses (
id INT AUTO_INCREMENT PRIMARY KEY,
course_name VARCHAR(100) NOT NULL,
description TEXT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE students (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
date_of_birth DATE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


1. Design your Packages (Folders)
   We'll follow a layered architecture to keep things organized and scalable.

plaintext
Copy
Edit
com.personal.studentmanagement
├── controller     -> Handle HTTP requests (API endpoints)
├── service        -> Business logic
├── repository     -> Database access (JPA Repositories)
├── model          -> Your Entity classes (Student, Course, Enrollment)
├── dto            -> Optional: Clean request/response data
└── exception      -> Handle errors globally
2. Create JPA Entity Classes
   We'll create three entities to match your database:

Student

Course

Enrollment

These will live in the model package and map directly to the DB tables.

3. Create JPA Repositories
   Use Spring Data JPA interfaces to interact with the DB (no manual SQL required).
   Example:

java
Copy
Edit
public interface StudentRepository extends JpaRepository<Student, Integer> {}
4. Create Services
   Add business logic like:

Add a student

Enroll a student in a course

Fetch students or courses

These will go in the service package.

5. Create Controllers
   These are your REST endpoints.
   Example:

POST /students

GET /courses

POST /enrollments

6. (Optional) Add DTOs
   DTOs help you cleanly separate internal DB entities from request/response payloads.

7. (Optional) Global Exception Handling
   Use @ControllerAdvice for handling bad requests, not founds, etc.









1. StudentController (Student-related endpoints)
   Create a Student (POST):

URL: http://localhost:8081/students

Body (JSON):

json
Copy
Edit
{
"firstName": "rashid",
"lastName": "khan",
"email": "khan.rashid@example.com",
"dateOfBirth": "2000-01-01"
}
Get All Students (GET):

URL: http://localhost:8081/students

Get a Student by ID (GET):

URL: http://localhost:8081/students/{id} (replace {id} with the student's ID, for example, 1).

Delete a Student by ID (DELETE):

URL: http://localhost:8081/students/{id} (replace {id} with the student's ID, for example, 1).

2. CourseController (Course-related endpoints)
   Create a Course (POST):

URL: http://localhost:8081/courses

Body (JSON):

json
Copy
Edit
{
"courseName": "Mathematics 101",
"description": "An introductory course to Mathematics."
}
Get All Courses (GET):

URL: http://localhost:8081/courses

Get a Course by ID (GET):

URL: http://localhost:8081/courses/{id} (replace {id} with the course's ID, for example, 1).

Delete a Course by ID (DELETE):

URL: http://localhost:8081/courses/{id} (replace {id} with the course's ID, for example, 1).

3. EnrollmentController (Enrollment-related endpoints)
   Create an Enrollment (POST):

URL: http://localhost:8081/enrollments

Body (JSON):

json
Copy
Edit
{
"studentId": 1,
"courseId": 1
}
Get All Enrollments (GET):

URL: http://localhost:8081/enrollments

Get an Enrollment by ID (GET):

URL: http://localhost:8081/enrollments/{id} (replace {id} with the enrollment's ID, for example, 1).

Delete an Enrollment by ID (DELETE):

URL: http://localhost:8081/enrollments/{id} (replace {id} with the enrollment's ID, for example, 1).

