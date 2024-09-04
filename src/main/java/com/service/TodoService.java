package com.service;

import com.dao.TodoDAO;
import com.model.Todo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoService {
    private TodoDAO todoDAO;

    public TodoService(Connection connection) {
        this.todoDAO = new TodoDAO(connection);
    }

    public void createTodo(Todo todo) throws SQLException {
        this.todoDAO.createTodo(todo);
    }

    public void updateTodoStatus(String status, int id) throws SQLException {
        this.todoDAO.updateTodoStatus(status, id);
    }

    public ArrayList<Todo> getTodosByUserID(int id) throws SQLException {
        return this.todoDAO.getTodosByUserID(id);
    }

    public Todo getTodoById(int id) throws SQLException {
        return this.todoDAO.getTodoById(id);
    }
}
