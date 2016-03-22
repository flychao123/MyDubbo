<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8081/DemoTwo/test/add.do">
	<span>姓名:</span><input name="name" type="text">
	<span>密码：</span><input name="password" type="text">
	<span>年龄：</span><input name="age" type="text">
	<input type="submit" value="插入">
</form>
<br>
<form action="http://localhost:8081/DemoTwo/test/query.do">
	<span>输入查询的name:</span><input name="name" type="text">
	<input type="submit" value="查询">
</form>
<br>
<form action="http://localhost:8081/DemoTwo/test/delete.do">
	<span>输入删除的id:</span><input name="id" type="text">
	<input type="submit" value="删除">
</form>
</body>
</html>