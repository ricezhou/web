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
 <a href="find1.action?price=3000">统计各个街道房屋的租金高于3000元的房屋信息的条数</a><br/>

 <a href="find2.action?price=2000&typeid=1000">统计各个街道一室一厅、租金低于2000元的房屋信息的条数</a> <br/>

 <a href="find3.action?count=50">列出房屋信息条数大于50条的所有街道</a> <br/>
 <a href="search.action">查询房屋信息</a> <br/>
  </body>
</html>






