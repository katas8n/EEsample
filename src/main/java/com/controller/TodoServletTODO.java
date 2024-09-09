package com.controller;


import com.model.User;
import com.model.Todo;
import com.service.TodoService;
import com.util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/todos")
public class TodoServletTODO extends HttpServlet {
    TodoService todoService;
    @Override
    public void init() {
        try {
            Connection connection = DatabaseUtil.getConnection();
            todoService = new TodoService(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        // TODO: LOGIN COULD EXIST or DOESN'T EXIST
        if(user == null) { res.sendRedirect("bank-app/WEB-INF/view/dashboard.jsp"); return; }

        try {
            ArrayList<Todo> todos = todoService.getTodosByUserID(Integer.parseInt(user.getId()));
            req.setAttribute("todos", todos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("dashboard.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        // TODO: LOGIN COULD EXIST or DOESN'T EXIST
        if(user == null) { res.sendRedirect("login.jsp"); return; }

       String action = req.getParameter("action");
        if(action.equals("create")) {
            Todo todo = new Todo(Integer.parseInt(user.getId()), req.getParameter("title"),
                    req.getParameter("description"), req.getParameter("status"));

        }
    }
}
