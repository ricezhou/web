<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <table border="1">
    <c:forEach items="${requestScope.list }" var="info">
  <tr>
  	<td>${info.name }</td>
  	<td>${info.quantity }</td>
  </tr>
    </c:forEach>
    
    <c:forEach items="${requestScope.slist }" var="street">
  <tr>
  	<td>${street.id }</td>
  	<td>${street.name }</td>
  </tr>
    </c:forEach>
    </table>
    <a href="enter.jsp">返回</a>
  </body>
</html>
