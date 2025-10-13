package lab_06;

import java.sql.*;

public class Postgres {
    private static final String URL = "jdbc:postgresql://localhost:5432/cs401";
    private static final String USER = "root";
    private static final String PASSWORD = "root_123";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
