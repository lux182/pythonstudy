<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
function Update()
{ 
	var x=document.getElementById("name").value;
	var y=document.getElementById("grade").value;
  if (x==""||!isNaN(x)&&y==""||isNaN(y))
  {
   alert("请输入数字");
window.history.back(-1);
  }
else
  {
  alert("执行修改!!!");
  document.forms[0].submit();
  }
}
</script>

</head>
<body>
 <a href="chaxun.jsp">点击返回查询页面</a>
<%
  String xuehao=request.getParameter("xuehao");
  String name=request.getParameter("name");
  String grade=request.getParameter("grade");
 %>
	
<form action="mystruts/update" method="get">

<%-- 原学号:${param.xuehao}<br/>
原姓名:${requestScope.name}<br/>
原班级:${requestScope.grade}<br/> --%>
<table border="0">
			<tr>
				<td width="100">原学号</td>
				<td width="200">原姓名</td>
				<td width="150">原班级</td>

			</tr>

			<c:forEach var="ha" items="${ListAll}" varStatus="status">

				<tr>
					<td>${ha.xuehao}</td>
					<td>${ha.name}</td>
					<td>${ha.grade}</td>
				</tr>

			</c:forEach>

		</table>
	</form>

<input type= "hidden" name="xuehao" value="<%=xuehao%>"/>

姓名:<input type="text" name="name" id="name"><br/>
班级:<input type="text" name="grade" id="grade" ><br/>
<input type="button" onclick="Update()" value="修改"/>
<input type="reset" value="重置"/>

</body>
</html>