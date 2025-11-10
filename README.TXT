NAME:COLIN ONUOSA
SN:101239755

Description:
This Java program connects to a PostgreSQL database and performs Create, Read, Update, and Delete (CRUD) operations on a "students" table using JDBC.

Database Schema:

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);


Sample Data:

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');


Requirements:

Java JDK 17 or higher
PostgreSQL installed
PostgreSQL JDBC driver (e.g., postgresql-42.7.3.jar)


Database Setup Steps:

Open PostgreSQL or pgAdmin.
Create a database:
CREATE DATABASE students;
Connect to the database:
\c students
Run the schema and sample data above.

Usage:

getAllStudents(): View all students

addStudent(): Add new students

updateStudentEmail(): Update student info

deleteStudent(): Delete students by ID

Run:

To run the code make sure to put in the appropriate function and parameters, then hit run on your compiler.

LINK TO VIDEO DEMONSTRATION: https://www.youtube.com/watch?v=x9MyFI2kBLw

