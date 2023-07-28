package com.todoapp.servlets;

import com.todoapp.dao.TodoDaoImpl;
import com.todoapp.model.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "TodoServlet", value = "/user/todo")
public class TodoServlet extends HttpServlet {

    private TodoDaoImpl todoDao;
    @Override
    public void init() throws ServletException {
        todoDao = new TodoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        List<Todo> todos = todoDao.selectAllTodos(username);
        request.setAttribute("todos", todos);
        request.getRequestDispatcher("/todo.jsp").forward(request, response);
    }
}