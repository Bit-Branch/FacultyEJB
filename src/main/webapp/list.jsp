<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/24/2020
  Time: 12:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список факультетов</title>
</head>
<body>

<h3>Все факультеты:</h3>(<a href="add">добавить</a> <a href="filter">фильтровать</a>)
<ol>
    <c:forEach items="${faculties}" var="faculty">
        <li>
                ${faculty.name} ${faculty.numberOfPeople} - ${faculty.semesterFee}
            <a href="add?edit=${faculty.id}">редактировать</a> | <a href="delete?id=${faculty.id}">удалить</a>
                    | <a href="calculate?id=${faculty.id}">рассчитать оплату за период</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>