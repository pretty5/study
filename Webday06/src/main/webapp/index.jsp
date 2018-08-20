<%@ page import="java.util.*" %>
<%@ page contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@page errorPage="error.jsp" %>

<%--是否忽略el表达式--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.html" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    out.println("this is a jsp page");
    out.println("hello world hello henan");
    for (int i = 0; i < 5; i++) {
        out.println("<p>this is a article</p>");
    }
%>
<%
    Date date = new Date();
    out.println("now is " + date);
%>
<%
    //out.println("1/0 = "+1/0);
%>

<%@ include file="footer.html" %>

<%--c:set设置变量的值  c:out 输出--%>
<c:set var="browser"  value="1234"/>
<c:out value="${browser}"></c:out>
<c:out value='${browser}' default="123"></c:out>
<c:out value="${header['User-Agent']}"></c:out>
<%--页面跳转--%>
<jsp:forward page="error.jsp">
    <jsp:param name="user" value="1234"/>
    <jsp:param name="abc" value="123"></jsp:param>
</jsp:forward>

</body>
</html>
