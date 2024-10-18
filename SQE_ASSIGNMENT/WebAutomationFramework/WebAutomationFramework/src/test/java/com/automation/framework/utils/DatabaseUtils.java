package com.automation.framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    
    private Connection connection;

    public DatabaseUtils(String jdbcUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
