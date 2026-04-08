import model.Student;
import service.StudentService;
import exception.StudentNotFoundException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

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
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        service.addStudent(new Student(id, name, age, course));
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();

                        service.deleteStudent(deleteId);
                        System.out.println("Student deleted!");
                        break;

                    case 3:
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

                    case 4:
                        List<Student> students = service.getAllStudents();

                        if (students.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            for (Student s : students) {
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