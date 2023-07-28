<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: orangered">
        <div>
            <a href="#" class="navbar-brand">TodoApp</a>
        </div>
        <c:set var="name" scope="session" value="${name}"/>
        <c:if test="${name != null}">
            <ul class="navbar-nav navbar-collapse justify-content-end">
                <li><h1 style="...">${name}</h1></li>
                <li><a href="<%= request.getContextPath()%>/logout" class="nav-link">Logout</a></li>
            </ul>
        </c:if>

    </nav>
</header>