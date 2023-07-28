<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo APP</title>
    <link rel="stylesheet" href= "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <h2 style="text-align: center">Welcome Todo App</h2>
        <div class="container text-center">
            <a class="btn btn-success" href="login.jsp">Login</a>
            <a class="btn btn-secondary" href="register.jsp">Register</a>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>