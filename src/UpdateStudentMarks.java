import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class UpdateStudentMarks {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        try {
            // 1. Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Take input
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Marks: ");
            int marks = sc.nextInt();

            // 4. SQL Update Query
            String sql = "UPDATE student SET marks = ? WHERE id = ?";

            // 5. Prepare Statement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, marks);
            ps.setInt(2, id);

            // 6. Execute Update
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(rows + ": Student marks updated successfully");
            } else {
                System.out.println( id +":Student ID not found");
            }

            // 7. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
