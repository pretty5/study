<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/8/20
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--导入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//设置一些值
    request.setAttribute("key","hello");
    session.setAttribute("user","jack");
    String name="abc";
%>
<c:set var="name" value="abc"></c:set>
<html>
<head>
    <title></title>
</head>
<body>
key:${requestScope["key"]}<br>
key:<%=request.getAttribute("key")%><br>
name:${name}<br>
name:<c:out value="${name}"></c:out><br>
user:${sessionScope["user"]}<br>
user:<%=session.getAttribute("user")%><br>
user:${user}<br>
pageContext:${pageContext}<br>
param:${param["age"]}<br>
params:${paramValues["hobby"]}<br>
<%--判断字符串是否为空--%>
isempty:${empty "abc"}<br>
isempty:${empty ""}<br>
</body>
</html>
