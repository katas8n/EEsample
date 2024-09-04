package com.service;

import com.model.User;
import com.dao.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;


public class UserService {
    private UserDAO userDAO;
    public UserService(Connection connection) {
        this.userDAO = new UserDAO(connection);
    }

    public void registerUser(User user) throws SQLException {
        this.userDAO.registerUser(user);
    }

    public void loginUser(String username, String password) throws SQLException {
        this.userDAO.loginUser(username, password);
    }
}
