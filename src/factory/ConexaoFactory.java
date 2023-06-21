package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String url = "jdbc:mysql://localhost:3306/poo3";
    private static final String user = "root";
    private static final String password = "anna2001";
    private static Connection conn;

    public static Connection getConexaoFactory() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        return null;
    }

    public static void closeConnection(Connection conexao) {
    }
}
