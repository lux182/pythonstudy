<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<script type="text/javascript">
function show()
{
	var x=document.getElementById("xuehao").value;
	var y=document.getElementById("grade").value;
if(x==""||isNaN(x)&&y==""||isNaN(y))
  {
   alert("请输入数字");
window.history.back(-1);
  }
else{
  var r=confirm("确认添加?");
  if (r==true){
   alert("确定");
document.forms[0].submit();
	}
 	else{
  alert("取消");
  return false;
  }
  }

}
</script>
</head>
  
  <body>
    <a href="chaxun.jsp">点击返回查询页面</a>
	<h1>添加页面</h1>   
<form action="mystruts/insert"> 
	学号:<input type="text" name="xuehao"  id="xuehao"><br/>
	姓名:<input type="text" name="name"><br/>
	班级:<input type="text" name="grade" id="grade"><br/>
<input type="button" onclick="show()" value="点击添加"/>
<form>

  </body>
</html>
