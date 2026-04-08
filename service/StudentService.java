package service;

import model.Student;
import util.FileHandler;
import exception.StudentNotFoundException;

import java.io.IOException;
import java.util.List;

public class StudentService {

    // ➕ Add Student
    public void addStudent(Student student) throws IOException {
        List<Student> students = FileHandler.readAll();

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                throw new RuntimeException("Student with this ID already exists!");
            }
        }

        students.add(student);
        FileHandler.writeAll(students);
    }

    // 📖 Get All Students
    public List<Student> getAllStudents() throws IOException {
        return FileHandler.readAll();
    }

    // ❌ Delete Student
    public void deleteStudent(int id) throws IOException, StudentNotFoundException {
        List<Student> students = FileHandler.readAll();

        boolean removed = students.removeIf(s -> s.getId() == id);

        if (!removed) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        FileHandler.writeAll(students);
    }

    // ✏️ Update Student
    public void updateStudent(int id, String name, int age, String course)
            throws IOException, StudentNotFoundException {

        List<Student> students = FileHandler.readAll();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        FileHandler.writeAll(students);
    }
}