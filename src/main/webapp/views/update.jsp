<%@page import="com.jsp.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adduser" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" value="${u.id }"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${u.name }"></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact" value="${u.contact }"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="${u.address }"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="update"></td>
			</tr>
		</table>
	</form>
</body>
</html>