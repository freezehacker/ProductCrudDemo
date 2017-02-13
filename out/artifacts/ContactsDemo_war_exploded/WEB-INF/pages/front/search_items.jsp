<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sjk
  Date: 17-2-11
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        #header_links #link_search {
            font-weight: bold;
        }
    </style>
</head>
<body>
<%@include file="select_header.jsp" %>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form action="/items" method="GET" class="form-horizontal">
            <input type="text" name="name" class="form-control">
            <button type="submit"
                    class="glyphicon glyphicon-search"></button>
        </form>
    </div>
</div>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <c:choose>
            <c:when test="${productList == null || productList.size() == 0}">
                <h5>暂无商品，请重新搜索</h5>
            </c:when>
            <c:otherwise>
                <table class="table table-striped table-hover">
                    <tbody>
                    <c:forEach items="${productList}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.category.name}</td>
                            <td>${product.price}</td>
                            <td>${product.amount}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/item?method=UPDATE&&id=${product.id}">
                                    <button type="button" class="btn btn-warning">修改</button>
                                </a>
                                <a>
                                    <form method="POST" action="${pageContext.request.contextPath}/doItem"
                                          style="display: inline-block;">
                                        <input type="hidden" name="method" value="DELETE">
                                        <input type="hidden" name="id" value="${product.id}">
                                        <button type="submit" class="btn btn-danger">删除</button>
                                    </form>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>名字</th>
                        <th>分类</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
