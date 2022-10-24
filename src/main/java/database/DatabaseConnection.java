package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://ec2-54-77-40-202.eu-west-1.compute.amazonaws.com:5432/dd69aa0lk9lb14";
    private static final String username = "eajcvkgnnhmxcd";
    private static final String password = "9e63bc9d92d640f736e44a93fa43659942c0940efb519cb916898c2060a658ee";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
