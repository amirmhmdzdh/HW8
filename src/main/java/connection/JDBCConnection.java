package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {


    private static Connection connection = null;

    private JDBCConnection() {
    }

    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Amir");
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return connection;
    }

}
