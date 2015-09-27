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
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		function goPage(pageIndex){
			document.forms[0].action="search.action?pageIndex="+pageIndex;
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
  <form action="search.action" method="post">
  房屋租金：<input name="startPrice" size="5" value="${param.startPrice }"/>~<input name="endPrice" size="5" value="${param.endPrice }"/>
  发布日期：<input name="startPubdate" size="5" value="${param.startPubdate }"/>~<input name="endPubdate" size="5" value="${ param.endPubdate}"/>(2013-6-6)
  标题：<input name="title" size="5" value="${param.title }"/>
  <input type="submit" value="查询"/>
  </form>
	<c:forEach items="${requestScope.pageInfo.pageList }" var="house">
		${house.id }~~${house.title }~~${house.pubdate }~~${house.price }<br/>
	</c:forEach><br/>
	总记录数：${requestScope.pageInfo.count}&nbsp;&nbsp;&nbsp;&nbsp;
	当前页/总页数：${requestScope.pageInfo.pageIndex }/${requestScope.pageInfo.totalPages }&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${requestScope.pageInfo.pageIndex>1}">
		<a href="javascript:goPage(${requestScope.pageInfo.pageIndex-1 })">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${requestScope.pageInfo.pageIndex<requestScope.pageInfo.totalPages}">
		<a href="javascript:goPage(${requestScope.pageInfo.pageIndex+1 })">下一页</a>
	</c:if>
  </body>
</html>
