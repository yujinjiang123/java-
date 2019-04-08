<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2018/12/23
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生列表</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .login{
            width:400px;
            height: 250px;
            margin:150px auto 0;
            background-color: white;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }
        .container{
            width: 100%;
            height: 100%;
            background-color: #f8f8f9;
        }
        .column{
            display: flex;
            align-content: space-between;
            flex-direction: column;
        }
        .column *{
            margin: 10px auto;
            width: 350px;
        }
    </style>
</head>
<body>
<c:if test="${message!=null }" >
    <script type="text/javascript">
        alert("${message}");
    </script>
    <c:remove var="message" scope="session"/>
</c:if>
<div class="container">
    <form action="/login" method="post" class="form-horizontal login">
        <div class="column">
            <input name="username" type="text" class="form-control" style="margin-top:54px" placeholder="学号">
            <input name="password" type="password" class="form-control"  placeholder="密码">
            <button type="submit" class="btn btn-success" style="height:30px;">登录</button>
        </div>
    </form>
</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
