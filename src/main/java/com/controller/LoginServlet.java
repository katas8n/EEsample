package com.controller;

//model, service, util

import com.model.User;
import com.service.UserService;
import com.util.DatabaseUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() {
        try {
            Connection connection = DatabaseUtil.getConnection();
            userService = new UserService(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(0 ,username, password);

        try {
            userService.loginUser(user.getUsername(), user.getPassword());
            res.sendRedirect("view/dashboard.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
