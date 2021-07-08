package com.nepshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
    public static Connection getConnection() {
        String connUrl = "jdbc:mysql://localhost:3306/nepshop?useSSL=false";
        String connUsername = "root";
        String connPassword = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connUrl, connUsername, connPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
