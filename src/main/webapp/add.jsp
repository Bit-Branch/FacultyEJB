<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/24/2020
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="add" method="post">
    <label for="name">Введите название:
        <input type="text" id="name" value="${faculty.name}" name="name" />
    </label>  <br />
    <label for="numberOfPeople">Введите кол-во человек:
        <input type="text" id="numberOfPeople" value="${faculty.numberOfPeople}" name="numberOfPeople" />
    </label>  <br />
    <label for="semesterFee">Введите плату за семестр:
        <input type="text" id="semesterFee" value="${faculty.semesterFee}" name="semesterFee" />
    </label>  <br />
    <input type="hidden" name="id" value="${faculty.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>
