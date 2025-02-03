import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myProjectDb1";
        String user = "root";
        String password = "wanyika_1234?";

        String query = "INSERT INTO Users VALUES (?, ?, ?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, 000002);
            stmt.setString(2, "John");
            stmt.setString(3, "Doe");
            stmt.setString(4, "John123");
            stmt.setString(5, "Organisation");
            stmt.setString(6, "Ghana");
            stmt.setString(7, "johnDoe@example.com");

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
