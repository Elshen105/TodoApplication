package com.todoapp.controller;

import com.todoapp.dao.UserDaoImpl;
import com.todoapp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    private UserDaoImpl userDaoImp;
    @Override
    public void init() {
        userDaoImp = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkUser(request, response);
    }

    public void checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDaoImp.getUser(username, password);

        if (user != null) {
            request.getSession().setAttribute("name", user.getName());
            request.getSession().setAttribute("username", user.getUsername());
            response.sendRedirect("user/todo");
        } else {
            request.setAttribute("loginError", "Username or Password is Incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}