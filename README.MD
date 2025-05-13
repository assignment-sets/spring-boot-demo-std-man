# Student Management System Design

## Database Schema

```sql
-- Enrollments Table
CREATE TABLE enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

-- Courses Table
CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Students Table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## Project Structure

```
com.personal.studentmanagement
├── controller     # Handle HTTP requests (API endpoints)
├── service        # Business logic
├── repository     # Database access (JPA Repositories)
├── model          # Entity classes (Student, Course, Enrollment)
├── dto            # (Optional) Clean request/response data
└── exception      # Global error handling
```

---

## Implementation Steps

### 1. Create JPA Entity Classes

- **Student**
- **Course**
- **Enrollment**

> These classes live in the `model` package and map directly to the DB tables.

---

### 2. Create JPA Repositories

Use Spring Data JPA interfaces to interact with the DB.

```java
public interface StudentRepository extends JpaRepository<Student, Integer> {}
```

---

### 3. Create Services

Add business logic, such as:

- Add a student
- Enroll a student in a course
- Fetch students or courses

---

### 4. Create Controllers

REST endpoints for your entities.

---

### 5. (Optional) Add DTOs

DTOs help separate internal DB entities from request/response payloads.

---

### 6. (Optional) Global Exception Handling

Use `@ControllerAdvice` for handling bad requests, not founds, etc.

---

## API Endpoints

### 1. StudentController

#### Create a Student

- **POST** `/students`
- **Body (JSON):**
    ```json
    {
        "firstName": "rashid",
        "lastName": "khan",
        "email": "khan.rashid@example.com",
        "dateOfBirth": "2000-01-01"
    }
    ```

#### Get All Students

- **GET** `/students`

#### Get a Student by ID

- **GET** `/students/{id}`

#### Delete a Student by ID

- **DELETE** `/students/{id}`

---

### 2. CourseController

#### Create a Course

- **POST** `/courses`
- **Body (JSON):**
    ```json
    {
        "courseName": "Mathematics 101",
        "description": "An introductory course to Mathematics."
    }
    ```

#### Get All Courses

- **GET** `/courses`

#### Get a Course by ID

- **GET** `/courses/{id}`

#### Delete a Course by ID

- **DELETE** `/courses/{id}`

---

### 3. EnrollmentController

#### Create an Enrollment

- **POST** `/enrollments`
- **Body (JSON):**
    ```json
    {
        "studentId": 1,
        "courseId": 1
    }
    ```

#### Get All Enrollments

- **GET** `/enrollments`

#### Get an Enrollment by ID

- **GET** `/enrollments/{id}`

#### Delete an Enrollment by ID

- **DELETE** `/enrollments/{id}`

---
