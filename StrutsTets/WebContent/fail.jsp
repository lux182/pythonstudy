<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
 <title>My JSP 'fail.jsp' starting page</title>
    
  </head>
<body>
   发生错误<br/>
 <form action="mystruts/select">
  <input type="submit" value="点击返回查询页面">
  </form>
</body>
</html>
