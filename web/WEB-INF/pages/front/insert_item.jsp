<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sjk
  Date: 17-2-10
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        #header_links #link_new {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="row">
    <%@ include file="select_header.jsp"%>

    <div class="col-md-6 col-md-offset-3">
        <form class="form-horizontal" method="POST"
              action="${pageContext.request.contextPath}/doItem">

            <%--隐藏域，用来说明method参数--%>
            <input type="hidden" name="method" value="INSERT">

            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">商品名</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputName" name="name">
                </div>
            </div>

            <div class="form-group">
                <label for="inputPrice" class="col-sm-2 control-label">单价</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputPrice" name="price">
                </div>
            </div>

            <div class="form-group">
                <label for="inputAmount" class="col-sm-2 control-label">数量</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputAmount" name="amount">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">类别</label>
                <div class="col-sm-8">
                    <select class="form-control" name="catId">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-2 control-label" style="visibility: hidden;"></label>
                <div class="col-sm-8">
                    <button type="submit" class="btn btn-warning">确认添加</button>
                </div>
            </div>
        </form>
    </div>

</div>
</body>
</html>
