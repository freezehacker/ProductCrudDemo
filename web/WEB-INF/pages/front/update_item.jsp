<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sjk
  Date: 17-2-9
  Time: 下午1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <%@ include file="select_header.jsp"%>

    <div class="col-md-6 col-md-offset-3">
        <form class="form-horizontal" method="POST"
              action="${pageContext.request.contextPath}/doItem">

            <%--隐藏域，用来说明method参数--%>
            <input type="hidden" name="method" value="UPDATE">

            <div class="form-group">
                <label for="inputId" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-8">
                    <input type="text" readonly class="form-control" id="inputId" name="id"
                           value="${product.id}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">商品名</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputName" name="name"
                           value="${product.name}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputPrice" class="col-sm-2 control-label">单价</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputPrice" name="price"
                           value="${product.price}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputAmount" class="col-sm-2 control-label">数量</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputAmount" name="amount"
                           value="${product.amount}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">类别</label>
                <div class="col-sm-8">
                    <select class="form-control" name="catId">
                        <c:forEach items="${categoryList}" var="category">
                            <c:choose>
                                <c:when test="${product.category.id == category.id}">
                                    <option value="${category.id}" selected>${category.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${category.id}">${category.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-2 control-label" style="visibility: hidden;"></label>
                <div class="col-sm-8">
                    <button type="submit" class="btn btn-warning">确认修改</button>
                </div>
            </div>
        </form>
    </div>

</div>
</body>
</html>
