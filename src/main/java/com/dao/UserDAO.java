package com.dao;

import com.model.User;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void registerUser(User user) throws SQLException {
        String query = "INSERT INTO users(username, password) VALUES(?, ?)";

        PreparedStatement state = connection.prepareStatement(query);
        state.setString(1, user.getUsername());
        state.setString(2, user.getPassword());

        state.executeUpdate();
    }

    public User loginUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        PreparedStatement state = connection.prepareStatement(query);
        state.setString(1, username);
        state.setString(2, password);

        ResultSet result = state.executeQuery();

        if(!result.next()) return null;
//
        return new User(result.getInt("id") ,result.getString("username"), result.getString("password"));
    }
}
