<%@ page import="it.contrader.dto.JobDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Job Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Job Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/job/getall">Lavoro</a> <a href="/job/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<JobDTO> list = (List<JobDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (JobDTO u : list) {
			%>
			<tr>
				<td><a href="/job/read?id=<%=u.getId()%>"> <%=u.getName()%>
				</a></td>
				<td><%=u.getDescription()%></td>
				<td><a href="/job/preupdate?id=<%=u.getId()%>">Update</a></td>


				<td><a href="/job/delete?id=<%=u.getId()%>">Cancella</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/job/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="job">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="job" name="name"
						placeholder="inserisci il nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="description"
						placeholder="inserisci la descrizione">
				</div>
			</div>
			<button type="submit">Inserisci</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>