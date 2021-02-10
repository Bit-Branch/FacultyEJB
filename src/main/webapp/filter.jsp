<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/25/2020
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>

<body>
<form action="filter" method="post">
<input type="submit" value="Фильтровать"/>
</form>
<ol>
    <c:forEach items="${faculties}" var="faculty">
        <li>
                ${faculty.name} ${faculty.numberOfPeople} - ${faculty.semesterFee}
        </li>
    </c:forEach>
</ol>

</body>
</html>
