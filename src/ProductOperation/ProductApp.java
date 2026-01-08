package ProductOperation;
import java.util.Scanner;

public class ProductApp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            ProductOperation op = new ProductOperation();

            while (true) {
                System.out.println("\n===== PRODUCT MENU =====");
                System.out.println("1. Create Product Table");
                System.out.println("2. Insert Product");
                System.out.println("3. Update Product Quantity");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        op.createTable();
                        break;
                    case 2:
                        op.insertProduct();
                        break;
                    case 3:
                        op.updateQuantity();
                        break;
                    case 4:
                        op.deleteProduct();
                        break;
                    case 5:
                        System.out.println("Exiting application...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        }


}
