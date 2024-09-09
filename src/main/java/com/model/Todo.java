package com.model;

public class Todo {
    private int id;
    private int user_id;
    private String title;
    private String description;
    private String status;

    public Todo(int id, int user_id, String title, String description, String status) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Todo(int user_id, String title, String description, String status) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
