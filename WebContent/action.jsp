<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<form action="" method="post" id="form">
					<input type="hidden" name="id" value="${stu.id }" id="stu_id">
					<td>姓名：</td>
					<td><input type="text" name="name" value="${stu.name }"> </td>
				
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" name="sex" value="${stu.sex }"></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" value="${stu.age }"> </td>
			</tr>
			</form>
		</table><br>
		<button type="button" id="submit"></button>
	</center>
</body>
<script type="text/javascript">
	if($("#stu_id").val() != ""){
		$("#form").attr("action","editStu");
		$("#submit").html("修改");
		
	}
	else{
		$("#form").attr("action","addStu");
		$("#submit").html("添加");
	}
	
	$("#submit").click(function(){
		$("#form").submit();
	});
</script>
</html>