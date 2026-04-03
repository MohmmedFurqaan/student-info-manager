# 📄 Product Requirements Document (PRD)

## 🧾 Project Title: Student Management System (CLI-Based)

---

## 1. 📌 Overview

The **Student Management System** is a command-line interface (CLI) based Java application that allows users to manage student records using CRUD operations. The system stores data persistently in a text file, acting as a mini database.

This project demonstrates core Java concepts including:

* Object-Oriented Programming (OOP)
* File Handling
* Exception Handling
* Collections Framework

---

## 2. 🎯 Objectives

* To build a functional CLI-based application using Java
* To implement CRUD operations on student data
* To simulate a basic database using text files
* To apply OOP principles in a real-world scenario
* To handle runtime errors using exception handling

---

## 3. 👥 Target Users

* Students (for learning purposes)
* Faculty (for evaluation of programming concepts)

---

## 4. ⚙️ Functional Requirements

### 4.1 Add Student

* User can add a new student with:

  * ID (Integer, unique)
  * Name (String)
  * Age (Integer)
  * Course (String)
* Data is stored in a text file (`students.txt`)

---

### 4.2 View Students

* Display all stored student records
* Format should be readable in CLI

---

### 4.3 Update Student (Optional / Advanced)

* User can update student details using ID
* If ID not found → show error message

---

### 4.4 Delete Student

* User can delete a student using ID
* If ID not found → show appropriate exception

---

### 4.5 Exit Application

* Gracefully terminate the program

---

## 5. 🧠 Non-Functional Requirements

* CLI-based (no GUI)
* Fast response for file operations
* Simple and user-friendly menu interface
* Code should be modular and maintainable
* Proper exception handling must be implemented

---

## 6. 🏗️ System Design

### 6.1 Architecture

The system follows a layered structure:

* **Presentation Layer**

  * CLI (Main.java)

* **Business Logic Layer**

  * StudentService.java

* **Data Layer**

  * FileHandler.java
  * students.txt

* **Model Layer**

  * Student.java

---

### 6.2 Data Storage Format

Each student record is stored as a line in the text file:

```
ID,Name,Age,Course
```

Example:

```
101,John Doe,20,Computer Science
102,Jane Smith,21,Electronics
```

---

## 7. 📂 File Structure

```
StudentManagementSystem/
│
├── Main.java
├── model/
│   └── Student.java
│
├── service/
│   └── StudentService.java
│
├── util/
│   └── FileHandler.java
│
├── exception/
│   └── StudentNotFoundException.java
│
└── data/
    └── students.txt
```

---

## 8. ⚠️ Error Handling

* Invalid input (non-integer ID/age)
* File not found or inaccessible
* Student ID not found during delete/update
* Duplicate ID (optional validation)

All errors must be handled using try-catch blocks.

---

## 9. 🧪 Testing Requirements

| Test Case          | Expected Result       |
| ------------------ | --------------------- |
| Add student        | Student saved in file |
| View students      | All records displayed |
| Delete existing ID | Student removed       |
| Delete invalid ID  | Error message shown   |
| Restart app        | Data persists         |

---

## 10. 🚀 Future Enhancements

* Search student by ID or name
* Sorting (by name/age)
* GUI version (JavaFX/Swing)
* Database integration (MySQL)
* Login system

---

## 11. 📅 Timeline (Suggested)

| Task                | Duration |
| ------------------- | -------- |
| Design & Planning   | 1 Day    |
| Core Development    | 2–3 Days |
| Testing & Debugging | 1 Day    |
| Documentation       | 1 Day    |

---

## 12. 🏁 Conclusion

This project serves as a foundational implementation of Java programming concepts through a real-world use case. It demonstrates how file-based storage can simulate database behavior and how structured programming improves scalability and maintainability.

---
