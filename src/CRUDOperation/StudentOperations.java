package CRUDOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentOperations {

    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "system";
    String password = "root";

    // INSERT
    public void insertStudent() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);

            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Enter Name: ");
            ps.setString(2, sc.next());

            System.out.print("Enter Age: ");
            ps.setInt(3, sc.nextInt());

            System.out.print("Enter Marks: ");
            ps.setInt(4, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Student inserted successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateStudent() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);

            String sql = "UPDATE student SET marks = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Student ID: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Enter New Marks: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student updated successfully");
            else
                System.out.println("Student not found");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteStudent() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner sc = new Scanner(System.in);

            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Student ID: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student deleted successfully");
            else
                System.out.println("Student not found");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

