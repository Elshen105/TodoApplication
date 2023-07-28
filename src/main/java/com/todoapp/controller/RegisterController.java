package com.todoapp.controller;

import com.todoapp.dao.UserDaoImpl;
import com.todoapp.model.User;
 import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    private UserDaoImpl userDaoImp;

    @Override
    public void init() {
        userDaoImp = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        register(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setPassword(password);
//        user.setId((int)(Math.random() * 100));

        try {
            userDaoImp.register(user);

            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("username", username);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        response.sendRedirect("user/todo");
    }
}