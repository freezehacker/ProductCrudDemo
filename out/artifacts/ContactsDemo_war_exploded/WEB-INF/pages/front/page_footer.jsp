<%--
  Created by IntelliJ IDEA.
  User: sjk
  Date: 17-2-13
  Time: 下午12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="text-align: center;">
    <c:if test="${pager.recordList != null and pager.recordList.size() != 0}">
        <a href="${pager.url}?pageSize=${pager.pageSize}&pageIndex=0">首页</a>

        <c:choose>
            <c:when test="${pager.pageIndex > 0}">
                <a href="${pager.url}?pageSize=${pager.pageSize}&pageIndex=${pager.pageIndex - 1}">上页</a>
            </c:when>
            <c:otherwise>
                <a>上页</a>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="0" end="${pager.pageCount - 1}" var="idx">
            <a href="${pager.url}?pageSize=${pager.pageSize}&pageIndex=${idx}">${idx + 1}</a>
        </c:forEach>

        <c:choose>
            <c:when test="${pager.pageIndex < pager.pageCount - 1}">
                <a href="${pager.url}?pageSize=${pager.pageSize}&pageIndex=${pager.pageIndex + 1}">下页</a>
            </c:when>
            <c:otherwise>
                <a>下页</a>
            </c:otherwise>
        </c:choose>

        <a href="${pager.url}?pageSize=${pager.pageSize}&pageIndex=${pager.pageCount - 1}">尾页</a>
    </c:if>
</body>
</html>
