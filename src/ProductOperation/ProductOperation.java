package ProductOperation;
import java.sql.*;
import java.util.Scanner;

public class ProductOperation {

    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "system";
    String password = "Yograj@2004";

    // a) CREATE TABLE
    public void createTable() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE product (" +
                    "id NUMBER PRIMARY KEY, " +
                    "name VARCHAR2(50), " +
                    "price NUMBER(10,2), " +
                    "quantity NUMBER)";

            stmt.execute(sql);
            System.out.println("Product table created successfully");

            con.close();
        } catch (Exception e) {
            System.out.println("Table already exists OR error occurred");
        }
    }

    // b) INSERT PRODUCT
    public void insertProduct() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);

            String sql = "INSERT INTO product VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Product ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Enter Product Name: ");
            ps.setString(2, sc.next());

            System.out.print("Enter Price: ");
            ps.setDouble(3, sc.nextDouble());

            System.out.print("Enter Quantity: ");
            ps.setInt(4, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Product inserted successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // c) UPDATE PRODUCT QUANTITY
    public void updateQuantity() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);

            String sql = "UPDATE product SET quantity = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Product ID: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Enter New Quantity: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Product quantity updated");
            else
                System.out.println("Product not found");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // d) DELETE PRODUCT
    public void deleteProduct() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);

            String sql = "DELETE FROM product WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Product ID: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Product deleted successfully");
            else
                System.out.println("Product not found");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
