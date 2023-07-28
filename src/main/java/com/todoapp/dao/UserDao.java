package com.todoapp.dao;

import com.todoapp.model.User;

public interface UserDao {
    void register(User user);

    User getUser(String username, String password);
}
