package com.todoapp.dao;

import com.todoapp.model.Todo;
import com.todoapp.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao{
    @Override
    public void insertTodo(Todo todo) {
        String TODO_INSERT_SQL = "INSERT INTO todo(todo_name, todo_desc, status, target_date, username) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(TODO_INSERT_SQL);

            preparedStatement.setString(1, todo.getTodoName());
            preparedStatement.setString(2, todo.getTodoDesc());
            preparedStatement.setString(3, todo.getStatus());
            preparedStatement.setDate(4, Date.valueOf( todo.getTargetDate()));
            preparedStatement.setString(5, todo.getUsername());

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Todo> selectAllTodos(String username) {
        String SELECT_All_TODOS_SQL = "SELECT id, todo_name, todo_desc, status, target_date, username FROM todo WHERE username = ?";

        List<Todo> todos = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_All_TODOS_SQL);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTodoName(resultSet.getString("todo_name"));
                todo.setTodoDesc(resultSet.getString("todo_desc"));
                todo.setStatus(resultSet.getString("status"));
                todo.setTargetDate(resultSet.getDate("target_date").toLocalDate());
                todo.setUsername(resultSet.getString("username"));

                todos.add(todo);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return todos;
    }

    @Override
    public Todo getTodo(int id) {
        String GET_TODO_SQL = "SELECT id, todo_name, todo_desc, status, target_date, username FROM todo WHERE id = ?";

        Todo todo = null;

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TODO_SQL);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                todo = new Todo();

                todo.setId(resultSet.getInt("id"));
                todo.setTodoName(resultSet.getString("todo_name"));
                todo.setTodoDesc(resultSet.getString("todo_desc"));
                todo.setStatus(resultSet.getString("status"));
                todo.setTargetDate(resultSet.getDate("target_date").toLocalDate());
                todo.setUsername(resultSet.getString("username"));


            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return todo;
    }

    @Override
    public void updateTodo(Todo todo) {
        String UPDATE_TODO_SQL = "UPDATE todo SET todo_name = ?, todo_desc = ?, status = ?, target_date = ? WHERE id = ?";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TODO_SQL);

            preparedStatement.setString(1, todo.getTodoName());
            preparedStatement.setString(2, todo.getTodoDesc());
            preparedStatement.setString(3, todo.getStatus());
            preparedStatement.setDate(4, Date.valueOf( todo.getTargetDate()));
            preparedStatement.setInt(5, todo.getId());

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteTodo(int id) {

        String DELETE_TODO_SQL = "DELETE FROM todo WHERE id = ?";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TODO_SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
