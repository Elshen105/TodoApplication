<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo Management APP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <div class="card mt-4">
                <div class="card-body">
                    <c:if test="${todo != null}">
                    <form action="${pageContext.request.contextPath}/user/todo/actions?action=update&id=<c:out value='${todo.id}'/>" method="post">
                        </c:if>
                        <c:if test="${todo == null}">
                        <form action="${pageContext.request.contextPath}/user/todo/actions?action=insert" method="post">
                            </c:if>
                            <caption>
                                <h2>
                                    <c:if test="${todo != null}">
                                        Edit Todo
                                    </c:if>
                                    <c:if test="${todo == null}">
                                        Add New Todo
                                    </c:if>
                                </h2>
                            </caption>

                            <fieldset class="form-group">
                                <label>Todo Name</label>
                                <input type="text" value="<c:out value='${todo.todoName}'/>" class="form-control"
                                       name="todoName" required="required" minlength="5">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Todo Description</label>
                                <input type="text" value="<c:out value='${todo.todoDesc}' />" class="form-control"
                                       name="todoDesc" minlength="5">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Todo Status</label>
                                <select class="form-control" name="status">
                                    <option value="IN_PROGRESS">In Progress</option>
                                    <option value="COMPLETE">Complete</option>
                                </select>
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Target Date</label>
                                <input type="date" value="<c:out value='${todo.targetDate}' />" class="form-control"
                                       name="targetDate" required="required">
                            </fieldset>

                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                </div>
            </div>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>