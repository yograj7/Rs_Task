import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudent {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "root";

        try {
            // 1. Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            String query = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Display Data
            System.out.println("ID\tName\tAge");
            System.out.println("-------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + "\t" + name + "\t" + age);
            }

            // 6. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
