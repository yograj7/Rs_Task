package ParameterizedQuery;

import java.util.Scanner;

public class EmployeeApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeOperations op = new EmployeeOperations();

        while (true) {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee Contact");
            System.out.println("3. Display Employees by City");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    op.insertEmployee();
                    break;

                case 2:
                    op.updateContact();
                    break;

                case 3:
                    op.displayByCity();
                    break;

                case 4:
                    System.out.println("Exiting application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
