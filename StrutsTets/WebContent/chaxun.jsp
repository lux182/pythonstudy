<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName

			() + ":" + request.getServerPort() + path + "/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>查询显示页面</title>
<script type="text/javascript">
	function Delete() {
		var r = confirm("确认删除?");
		if (r == true) {
			document.forms[1].submit();
		} else {
			window.history.back(-1);
		}
	}

	function update() {
		
		var sel = document.getElementsByName("Sxh");
		var seleteNum = "";
		var n = 0;
		for ( var i = 0; i < sel.length; i++)

		{
			if (sel[i].checked) {
				seleteNum += sel[i].value;
				n += 1;
			}
		}
		if (seleteNum == "") {
			alert("您还没有选择要修改的内容！");
		} else if (n > 1) {
			alert("只能选择一条记录修改");
		} else {
			window.location.href = "update.jsp?xuehao=" + seleteNum;
			window.location.href = "mystruts/SelectWithParam!execute.action?xuehao="+xuehao;
		}

	}
</script>

</head>

<body>
	<center>
		<font color="red" size="20">信息查询</font> <br>
		<form action="mystruts/select" method="post">
			请输入学号:<input type="text" name="xuehao"> <input type="submit"
				value="查询" />
		</form>
	</center>


	<form action="mystruts/Delete">
		<input type="button" onclick="Delete()" value="删除"> <input
			type="button" onclick="update()" value="修改">
		<table border="0">
			<tr>
				<td width="100">学号</td>
				<td width="200">姓名</td>
				<td width="150">班级</td>

			</tr>

			<c:forEach var="ha" items="${ListAll}" varStatus="status">

				<tr>
					<td><input type="checkbox" name="Sxh" value="${ha.xuehao}">${ha.xuehao}</td>
					<td>${ha.name}</td>
					<td>${ha.grade}</td>
				</tr>

			</c:forEach>

		</table>
	</form>
	<a href="insert.jsp">添加数据</a>
</body>
</html>
