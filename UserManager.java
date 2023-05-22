import java.sql.*;

public class UserManager {

    public void registerUser(User user) {
        Connection connection = DatabaseConnection.connect();
        String sql = "INSERT INTO users(username,password) VALUE(?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginUser(String username, String password) {
        Connection connection = DatabaseConnection.connect();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() | password.equals(resultSet)) {
                System.out.println("Success");
                return true;
            } else
                System.out.println("Failed");
                return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delectUser(String username) {
        Connection connection = DatabaseConnection.connect();
        String sql = "DELETE FROM users WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
