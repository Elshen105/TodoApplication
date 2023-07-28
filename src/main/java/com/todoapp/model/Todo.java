package com.todoapp.model;

import java.time.LocalDate;
import java.util.Locale;

public class Todo {
    private int id;
    private String todoName;
    private String todoDesc;
    private String status;
    private LocalDate targetDate;
    private String username;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Todo() {
    }

    public Todo(int id, String todoName, String todoDesc, String status, LocalDate targetDate, String username, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.todoName = todoName;
        this.todoDesc = todoDesc;
        this.status = status;
        this.targetDate = targetDate;
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoDesc() {
        return todoDesc;
    }

    public void setTodoDesc(String todoDesc) {
        this.todoDesc = todoDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
