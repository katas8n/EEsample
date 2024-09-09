package com.controller;

//model, service, util

import com.model.User;
import com.service.UserService;
import com.util.DatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseUtil.getConnection();
            userService = new UserService(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("login".equals(action)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            try {
                User user = userService.loginUser(username, password);

                if (user == null) {
                    req.setAttribute("errorMessage", "Invalid username or password.");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
                    dispatcher.forward(req, res);
                    return;
                }

                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                res.sendRedirect("dashboard.jsp");

            } catch (SQLException e) {
                throw new ServletException("Login error", e);
            }

        } else if ("register".equals(action)) {
            User user = new User(req.getParameter("id"),
                    req.getParameter("username"),
                    req.getParameter("password"));

            try {
                userService.registerUser(user);
            } catch (SQLException e) {
                throw new ServletException("Registration error", e);
            }

            res.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        System.out.println(page);

        if (page == null || page.isEmpty()) {
            page = "login"; // Default to login page
        }
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/" + page + ".jsp");
//        dispatcher.forward(request, response);
    }
}
