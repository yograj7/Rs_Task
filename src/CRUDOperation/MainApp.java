package CRUDOperation;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentOperations op = new StudentOperations();

        while (true) {
            System.out.println("\n===== STUDENT DATABASE MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    op.insertStudent();
                    break;

                case 2:
                    op.updateStudent();
                    break;

                case 3:
                    op.deleteStudent();
                    break;

                case 4:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);

                default:
                    System.out.println(choice + "Is invalid choice. Try again.");
            }
        }
    }
}

