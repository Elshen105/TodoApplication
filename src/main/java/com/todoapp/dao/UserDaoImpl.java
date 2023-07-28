package com.todoapp.dao;

import com.todoapp.model.User;
import com.todoapp.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao{


    @Override
    public void register(User user) {
        String USER_INSERT_SQL = "INSERT INTO user(name, surname, username, password) values (?, ?, ?, ?);";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(USER_INSERT_SQL);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public User getUser(String username, String password) {
        String GET_USER_SQL = "SELECT id, name, surname, username, password FROM user WHERE username = ? AND password = ?;";
        User user = null;
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_SQL);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }


}
