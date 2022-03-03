<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctx",request.getContextPath());
%>
<body>
<form action="${ctx}/submit" method="post">
    <input type="submit" value="提交">
</form>
</body>
</html>
