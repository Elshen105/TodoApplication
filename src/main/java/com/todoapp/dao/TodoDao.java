package com.todoapp.dao;

import com.todoapp.model.Todo;

import java.util.List;

public interface TodoDao {
    void insertTodo(Todo todo);

    List<Todo> selectAllTodos(String username);

    Todo getTodo(int id);

    void updateTodo (Todo todo);

    void deleteTodo(int id);
}
