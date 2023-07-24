import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    
     DatabaseConnection s=new DatabaseConnection();
   
    public boolean checkUsernameExists(String username) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS count FROM users WHERE username = ?")) {

            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return false;
    }

    // Method to create a new user in the database
    public boolean createUser(String username, String password, String email) {
        try (Connection connection = s.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, emailid) VALUES (?, ?, ?)")) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            //statement.setString(4, email);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return false;
    }
}
