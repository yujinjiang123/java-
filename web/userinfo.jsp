<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2019/4/4
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<c:choose>
    <c:when test="${empty user.schoolName}">
        <p>姓名</p>${user.username}
        <a href="/addUserInfo1.jsp">完善个信息</a>
    </c:when>
    <c:otherwise>
        <table class=" table table-bordered" style="margin: auto;">
            <tr style="background-color:#eef0f4">
                <th>姓名</th>
                <th>学校</th>
                <th>专业</th>
                <th>掌握技术</th>
            </tr>
            <tr>
                <td>${user.username}</td>
                <td>${user.schoolName}</td>
                <td>${user.profession}</td>
                <td>${user.technologyList}</td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
