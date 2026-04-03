import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // the main enter of the file

    public static void main(String[] args) {

        // for input from the user
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {

            // available lit shows until the user press the right option...
            System.out.println("1. Add student details ");
            System.out.println("2. Delete Student Details");
            System.out.println("3. Update Student details");
            System.out.println("4. View Student details");
            System.out.println("5. exit from the system");
            System.out.println();
            System.out.println("Below are the options you can do press the number to proceed: ");

            

            // handling the exception for unknown input
            // Exception include:
            // 1.
            try {

                // to capture the input from the user
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("under progrees for add");
                        break;

                    case 2:
                        System.out.println("under progress dor Delete student");
                        break;

                    case 3:
                        System.out.println("under progress for Update student");
                        break;

                    case 4:
                        System.out.println("under progress for view student");
                        break;

                    case 5:
                        System.out.println("Exiting the system !");
                        System.exit(0);

                    default:
                        System.out.println("Enter the option given in the list !");
                        System.out.println();

                }
            } catch (InputMismatchException e) {
                System.out.println("Enter the Number not the string");
                sc.nextLine();
            } 
            
            // close the opened resources
            finally {
                sc.close();
            }

            

        }

    }
}