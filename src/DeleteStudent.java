import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {

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
            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            // 4. SQL Delete Query
            String sql = "DELETE FROM student WHERE id = ?";

            // 5. Prepare Statement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            // 6. Execute Delete
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(rows + "Student record deleted successfully");
            } else {
                System.out.println(id + "Student ID not found");
            }

            // 7. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
