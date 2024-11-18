package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/sqldb";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "root";

    public Connection getConnection() {

        Connection connection;
        try {
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Не удалось подключиться к базе данных");
            }

        return connection;
    }
}

