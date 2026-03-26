# Student Management System

This is a simple console-based Student Management System developed using Java and MySQL with JDBC connectivity. The system allows users to perform CRUD operations (Create, Read, Update, Delete) on student records stored in a MySQL database.

## 🚀 Features
- Add new student
- View all students
- Update student details
- Delete student records
- MySQL database integration using JDBC
- Console-based menu system

## 🛠 Technologies Used
- Java
- JDBC (Java Database Connectivity)
- MySQL
- OOP (Object-Oriented Programming)

## 📂 Project Structure
Main.java – Handles user menu and input  
Student.java – Student model class with attributes  
StudentManager.java – Handles database operations (CRUD)

## 🗄 Database Setup

Create database and table in MySQL:

```sql
CREATE DATABASE university;

USE university;

CREATE TABLE students (
    roll_no VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    age INT
);
