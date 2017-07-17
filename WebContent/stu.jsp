<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  import="cn.itcast.bean.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
<title>Insert title here</title>
</head>
<body onload="onLoad()">
	<%
		User user = (User)request.getSession().getAttribute("user");
	%>
	欢迎：
	<%=user.getName() %>
	<c:if test="${empty stuList && empty search}">
		无客户信息:
		<a href="${pageContext.request.contextPath }/action.jsp">添加</a>
	</c:if>


	<c:if test="${not empty stuList || not empty search}">
		<center>
		<h2>学生信息</h2>
		<a href="${pageContext.request.contextPath }/action.jsp">添加</a>
		<hr width="70%">
		<form action="${pageContext.request.contextPath }/getList" method="post" id="search">
			<input type="text" name="search" id="t_search" value="${search }">
		</form>
		<button type="button" onclick="doSearch()">搜索</button>
		</center>
		<form action="${pageContext.request.contextPath}/delAll" method="post" id="f2">
			<table border="1" align="center" width="65%">
				<tr>
					<td style="width:100px;">&nbsp;</td><td>ID</td><td>姓名</td><td>年龄</td><td>性别</td><td>操作</td>
				</tr>
				<c:forEach items="${stuList}" var="c">
					<tr>
						<td><input type="checkbox" name="id" value="${c.id}"></td>
						<td>${c.id }</td>
						<td>${c.name}</td>
						<td>${c.age}</td>
						<td>${c.sex}</td>
						<td>
						
						<a href="${pageContext.request.contextPath}/findById?id=${c.id}">编辑</a>
						
						&nbsp;&nbsp;&nbsp; <%-- <a href="javascript:void(0)"
							onclick="del('${c.id}')">删除</a> --%>
							<a href="#" onclick="if(window.confirm('是否删除？')){del('${c.id}')}">删除</a>
							</td>
					</tr>
				</c:forEach>
				<tr>
				<td><button onlick="delAdll()">删除选中</button></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
<script type="text/javascript">
	function del(id){
		$.ajax({
			url:"delStuById",
			type:"post",
			dataType:"json",
			data:{id:id},
			success:function(){
				alert("删除陈功！~");
				location.reload();
			},
			error:function(){
				alert("请稍候再试");
			}
		});
	}
	function delAdll(){
		$("#f2").submit();
	}
	function onLoad(){
		var trList = document.getElementsByTagName("tr");
		for(var i = 0; i < trList.length; i++){
			
			trList[i].onmouseover=function(){
				this.style.backgroundColor = "#D1EEEE";
			}
			trList[i].onmouseout=function(){
				this.style.backgroundColor = "white";
			}
		}
	}
		function doSearch(){
			if($("#t_search").val() == ""){
				alert("搜索条件为空！～");
				return;
			}
			$("#search").submit();
		}
</script>
</html>