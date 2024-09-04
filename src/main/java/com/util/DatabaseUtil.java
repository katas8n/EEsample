package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class DatabaseUtil {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(DatabaseUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("db.url");
//        String user = properties.getProperty("db.username");
        return DriverManager.getConnection(url);
    }
}
