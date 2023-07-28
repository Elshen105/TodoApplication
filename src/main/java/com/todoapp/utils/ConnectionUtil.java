package com.todoapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/todo_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}
