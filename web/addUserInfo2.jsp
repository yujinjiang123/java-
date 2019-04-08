<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2019/4/4
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
%>
<c:set value="${param.schoolName}" var="schoolName" scope="session"/>
<c:set value="${param.profession}" var="profession" scope="session"/>
<body>
<form action="/addUserInfo" method="post">
    <input type="checkbox" name="technology" value="android">android
    <input type="checkbox" name="technology" value="java web">java web
    <input type="checkbox" name="technology" value="c#">c#
    <input type="submit">
</form>
</body>
</html>
