package com.controller;


import com.service.TodoService;
import com.util.DatabaseUtil;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.SQLException;

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
}
