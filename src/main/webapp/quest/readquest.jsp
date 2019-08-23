<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.QuestDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Quest Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Quest</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/quest/getall">Quest</a> <a href="/quest/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			QuestDTO q = (QuestDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Argomento</th>
				<th>Domanda</th>
				<th>Risposta 1</th>
				<th>Risposta 2</th>
				<th>Risposta 3</th>
				<th>Risposta 4</th>
			</tr>
			<tr>
				<td><%=q.getId()%></td>
				<td><%=q.getArgs()%></td>
				<td><%=q.getQuest()%></td>
				<td><%=q.getAns1()%></td>
				<td><%=q.getAns2()%></td>
				<td><%=q.getAns3()%></td>
				<td><%=q.getAns4()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>