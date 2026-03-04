package com.transport.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static String url = "jdbc:mysql://localhost:3306/transport_db?allowPublicKeyRetrieval=true&useSSL=false";

    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "admin"; // Replace with your MySQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error establishing connection!");
            e.printStackTrace();
        }
        return conn;
    }
}
