import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDBConnection {

    public static void main(String[] args) {

        // Database details
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "root";

        try {
            // Step 1: Load Driver
            Class.forName(driver);

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Check Connection
            if (con != null) {
                System.out.println("Database connection successful");
            }

            // Step 4: Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
}
