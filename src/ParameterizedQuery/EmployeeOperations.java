package ParameterizedQuery;
import java.sql.*;
import java.util.Scanner;

public class EmployeeOperations {
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "system";
    String password = "Yograj@2004";

    // INSERT EMPLOYEE
    public void insertEmployee() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);

            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Enter Employee Name: ");
            ps.setString(2, sc.next());

            System.out.print("Enter City: ");
            ps.setString(3, sc.next());

            System.out.print("Enter Contact Number: ");
            ps.setLong(4, sc.nextLong());

            ps.executeUpdate();
            System.out.println("Employee inserted successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE CONTACT
    public void updateContact() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);

            String sql = "UPDATE employee SET contact = ? WHERE emp_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Enter New Contact Number: ");
            ps.setLong(1, sc.nextLong());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Contact updated successfully");
            else
                System.out.println("Employee not found");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DISPLAY EMPLOYEE BY CITY
    public void displayByCity() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);

            String sql = "SELECT * FROM employee WHERE city = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter City: ");
            ps.setString(1, sc.next());

            ResultSet rs = ps.executeQuery();

            System.out.println("ID\tName\tCity\tContact");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + "\t" +
                                rs.getString("emp_name") + "\t" +
                                rs.getString("city") + "\t" +
                                rs.getLong("contact")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
