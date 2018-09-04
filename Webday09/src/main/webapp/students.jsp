<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--导入标签包--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-striped">

<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
    out.println("<th>\n" +
            "        <td>id</td>\n" +
            "        <td>cid</td>\n" +
            "        <td>name</td>\n" +
            "    </th>");
    for (Student student:studentList) {
        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td>"+student.getId()+"</td>");
        out.println("<td>"+student.getCid()+"</td>");
        out.println("<td>"+student.getName()+"</td>");
        out.println("</tr>");
    }
%>
</table>

<%--<table class="table table-striped">
    <th>
        <td>id</td>
        <td>cid</td>
        <td>name</td>
    </th>
<c:forEach items="${studentList}" var="student">
    <tr>
        <td></td>
        <td>${student.id}</td>
        <td>${student.cid}</td>
        <td>${student.name}</td>
    </tr>
</c:forEach>
</table>--%>
</body>
</html>
