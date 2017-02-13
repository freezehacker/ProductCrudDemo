<%--
  Created by IntelliJ IDEA.
  User: sjk
  Date: 17-2-11
  Time: 下午2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            font-size: 16px;
        }
    </style>
</head>
<body style="text-align: center">
    <h3>商品管理系统</h3>
    <div id="header_links" style="margin: 20px auto 30px">
        <a href="/list" id="link_all">所有商品</a>
        &emsp;|&emsp;
        <a href="/item?method=INSERT" id="link_new">新增商品</a>
        &emsp;|&emsp;
        <a href="/items" id="link_search">搜索商品</a>
    </div>
</body>
</html>
