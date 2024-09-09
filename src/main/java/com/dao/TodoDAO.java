package com.dao;

import com.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDAO {
    private Connection connection;

    public TodoDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTodo(Todo todo) throws SQLException {
        String query = "INSERT INTO todos (user_id,  title, description, status) VALUES (?, ?, ?, ?)";

        PreparedStatement state = connection.prepareStatement(query);
        state.setInt(1, todo.getUser_id());
        state.setString(2, todo.getTitle());
        state.setString(3, todo.getDescription());
        state.setString(4, todo.getStatus());

        state.executeUpdate();
    }

    public Todo getTodoById(int id) throws SQLException {
        String query = "SELECT * FROM todos WHERE id= ?";

        PreparedStatement state = connection.prepareStatement(query);
        state.setInt(1, id);

        ResultSet result = state.executeQuery();

        if(!result.next()) return null;
        return new Todo(
                result.getInt("id"),
                result.getInt("user_id"),
                result.getString("title"),
                result.getString("description"),
                result.getString("status")
        );
    }

    public ArrayList<Todo> getTodosByUserID(int user_id) throws SQLException {
        ArrayList<Todo> todos = new ArrayList<Todo>();

        String query = "SELECT * FROM todos WHERE user_id= ?";

        PreparedStatement state = connection.prepareStatement(query);
        state.setInt(1, user_id);

        ResultSet result = state.executeQuery();

        if(!result.next()) return null;

        while (result.next()) {
            todos.add(
                    new Todo(
                        result.getInt("id"),
                        result.getInt("user_id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("status")
                )
            );
        }

        return todos;
    }


    public void updateTodoStatus(String status, int id) throws SQLException {
        String query = "UPDATE todos SET status = ? WHERE id = ?";

        PreparedStatement state = connection.prepareStatement(query);
        state.setString(1, status);
        state.setInt(2, id);

        state.executeUpdate();
    }

    public void removeTodo(int id) throws SQLException {
        String query = "DELETE FROM todos WHERE id = ?";

        PreparedStatement state = connection.prepareStatement(query);
        state.setInt(1, id);

        state.executeUpdate();
    }

}
