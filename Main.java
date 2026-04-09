import model.Student;
import service.StudentService;
import exception.StudentNotFoundException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                
                        int id = service.getAllStudents()
                                .stream()
                                .mapToInt(Student::getId)
                                .max()
                                .orElse(0) + 1;

                        service.addStudent(new Student(id, name, age, course));
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        List<Student> students_delete = service.getAllStudents();

                        if (students_delete.isEmpty()) {
                            System.out.println("No ID to delete !");
                            break;
                        } else {
                            for (Student s : students_delete) {
                                System.out.println(s);
                            }
                            System.out.print("Enter ID to delete: ");
                            int deleteId = sc.nextInt();

                            service.deleteStudent(deleteId);
                            System.out.println("Student deleted!");
                            break;
                        }

                    case 3:
                        List<Student> students = service.getAllStudents();

                        if (students.isEmpty()) {
                            System.out.println("No ID to update");
                            break;

                        } else {
                            for (Student s : students) {
                                System.out.println(s);
                            }
                            System.out.print("Enter ID to update: ");
                            int updateId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter New Age: ");
                            int newAge = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Course: ");
                            String newCourse = sc.nextLine();

                            service.updateStudent(updateId, newName, newAge, newCourse);
                            System.out.println("Student updated!");
                            break;

                        }

                    case 4:
                        List<Student> students2 = service.getAllStudents();

                        if (students2.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            for (Student s : students2) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter valid numeric input!");
                sc.nextLine(); // clear buffer

            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}