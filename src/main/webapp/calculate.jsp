<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/26/2020
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculate" method="post">
    <label for="period">Введите период (в днях):
        <input type="text" id="period" name="period" />
    </label>  <br />
    <label>
        Сумма к оплате за введенный период: ${calculatedFee}
    </label> <br />
    <input type="hidden" name="id" value="${faculty.id}" />
    <input type="submit" value="Рассчитать" />
</form>
</body>
</html>
