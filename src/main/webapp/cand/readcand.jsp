<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CandDTO" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cand Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Cand</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/cand/getall">cands</a> <a href="/cand/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			CandDTO c = (CandDTO) request.getSession().getAttribute("Canddto");


		%>


		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Age</th>
				<th>Experience</th>
				<th>User</th>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getSurname()%></td>
				<td><%=c.getAge()%></td>
				<td><%=c.getExperience()%></td>
				<td><%=c.getUser().getId()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>