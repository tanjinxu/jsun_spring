<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/Login" method="post" id="form">
			用户名：<input type="text" name="name" id="name"/> <br><br>
			密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pass" id="pass"><br>
		</form><br>
		<button type="button" onclick="fun()">登录</button>
	</center>
</body>
<script type="text/javascript">
	function fun(){
		var name = document.getElementById("name");
		var pass = document.getElementById("pass");
		var form = document.getElementById("form");
		if(name.value == "" || pass.value == ""){
			alert("请输入用户名密码");
		}else{
			form.submit();
		}
	}
</script>
</html>