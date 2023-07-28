<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Todo APP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2 style="text-align: center">List of Todos</h2>
    <div class="container text-left">
        <a href="<%=request.getContextPath()%>/user/todo/actions?action=new" class="btn btn-success">Add Todo</a>
    </div>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Todo Name</th>
            <th>Todo Desc</th>
            <th>Target Date</th>
            <th>Todo Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${todos}">
            <tr>
                <td><c:out value="${todo.todoName}" /></td>
                <td><c:out value="${todo.todoDesc}" /></td>
                <td><c:out value="${todo.status}" /></td>
                <td><c:out value="${todo.targetDate}" /></td>

                <td>
                    <a href="<%=request.getContextPath()%>/user/todo/actions?action=edit&id=<c:out value='${todo.id}'/>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<%=request.getContextPath()%>/user/todo/actions?action=delete&id=<c:out value='${todo.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>