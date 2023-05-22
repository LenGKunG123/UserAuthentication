import java.sql.*;

public class DatabaseConnection {
    public static Connection connect() {

        String url = "jdbc:mysql://localhost:3306/accountmanage";
        String username = "root";
        String password = "ะฟททฟจึจต";
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
