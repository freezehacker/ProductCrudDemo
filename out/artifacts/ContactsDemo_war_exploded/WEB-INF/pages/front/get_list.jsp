<%--
  Created by IntelliJ IDEA.
  User: sjk
  Date: 17-2-8
  Time: 下午3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        #header_links #link_all {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="row">
    <%@ include file="select_header.jsp"%>

    <div class="col-md-6 col-md-offset-3">
        <c:choose>
            <c:when test="${productList != null && productList.size() != 0}">
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
                                    <form method="POST" action="${pageContext.request.contextPath}/doItem" style="display: inline-block;">
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
            </c:when>
            <c:otherwise>
                <h3>Nothing in the list~</h3>
            </c:otherwise>
        </c:choose>
    </div>

</div>
</body>
</html>
