<%@page import="com.jsp.model.User"%>
<%@page import="java.util.List"%>
<%@page import="org.w3c.dom.stylesheets.LinkStyle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<h2>User Table</h2>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		List<User> list = (List<User>) request.getAttribute("list");
		%>
		<%
		for (User u : list) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getContact()%></td>
			<td><%=u.getAddress()%></td>
			<td>
				<form action="edit" method="post">
					<input type="hidden" name="id" value="<%=u.getId()%>"> 
					<input type="submit" name="action" value="edit">
				</form>
			</td>
			<td>
				<form action="delete" method="post">
					<input type="hidden" name="id" value="<%=u.getId()%>"> 
					<input type="submit" name="action" value="delete">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>

