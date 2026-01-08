import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsetStudent {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "Yograj@2004";

        Scanner sc = new Scanner(System.in);

        try {
            // 1. Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Input from user
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Student Name: ");
            String name = sc.next();

            System.out.print("Enter Student Age: ");
            int age = sc.nextInt();

            // 4. SQL Query
            String sql = "INSERT INTO student VALUES (?, ?, ?)";

            // 5. Prepare Statement
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            // 6. Execute Query
            int rows = ps.executeUpdate();


            System.out.println( rows +" : Student record inserted successfully");


            // 7. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

