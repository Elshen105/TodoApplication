package com.todoapp.controller;

import javax.servlet.*;

import com.todoapp.dao.TodoDao;
import com.todoapp.dao.TodoDaoImpl;
import com.todoapp.model.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "TodoController", value = "/user/todo/actions")
public class TodoController extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, jakarta.servlet.ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("/todo-form.jsp").forward(request, response);
        } else {

            try {

                switch (action) {
                    case "new":
                        request.getRequestDispatcher("/todo-form.jsp").forward(request, response);
                        break;
                    case "insert":
                        insertTodo(request, response);
                        break;
                    case "update":
                        updateTodo(request, response);
                        break;
                    case "edit":
                        showEditTodo(request, response);
                        break;
                    case "delete":
                        deleteTodo(request, response);
                    default:
                        response.sendRedirect("login.jsp");
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }


    private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        String todoName = request.getParameter("todoName");
        String todoDesc = request.getParameter("todoDesc");
        String status = request.getParameter("status");

        String date = request.getParameter("targetDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate targetDate = LocalDate.parse(date, formatter);

        Todo todo = new Todo();
        todo.setTodoName(todoName);
        todo.setTodoDesc(todoDesc);
        todo.setStatus(status);
        todo.setTargetDate(targetDate);
        todo.setUsername(username);

        todoDao.insertTodo(todo);
        response.sendRedirect(request.getContextPath() + "/user/todo");

    }


    private void showEditTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Todo todo = todoDao.getTodo(id);
        request.setAttribute("todo", todo);
        request.getRequestDispatcher("/todo-form.jsp").forward(request, response);
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String todoName = request.getParameter("todoName");
        String todoDesc = request.getParameter("todoDesc");
        String status = request.getParameter("status");

        String date = request.getParameter("targetDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate targetDate = LocalDate.parse(date, formatter);

        Todo todo = todoDao.getTodo(id);
        todo.setTodoName(todoName);
        todo.setTodoDesc(todoDesc);
        todo.setStatus(status);
        todo.setTargetDate(targetDate);

        todoDao.updateTodo(todo);
        response.sendRedirect(request.getContextPath() + "/user/todo");


    }


    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoDao.deleteTodo(id);
        response.sendRedirect(request.getContextPath() + "/user/todo");
    }

}