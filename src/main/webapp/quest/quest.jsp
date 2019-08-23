<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	 import="it.contrader.dto.QuestDTO" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Quest Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/quest/getall">Domanda</a> <a href="/quest/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<QuestDTO> list = (List<QuestDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Argomento</th>
				<th>Domanda</th>
				<th>Risposta 1</th>
				<th>Risposta 2</th>
				<th>Risposta 3</th>
				<th>Risposta 4</th>
			</tr>
			<%
				for (QuestDTO q : list) {
			%>
			<tr>
				<td><a href="/quest/read?id=<%=q.getId()%>"> <%=q.getArgs()%>
				</a></td>
				<td><%=q.getQuest()%></td>
				<td><%=q.getAns1()%></td>
				<td><%=q.getAns2()%></td>
				<td><%=q.getAns3()%></td>
				<td><%=q.getAns4()%></td>
				<td><a href="/quest/preupdate?id=<%=q.getId()%>">Update</a></td>


				<td><a href="/quest/delete?id=<%=q.getId()%>">Cancella</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/quest/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="args">Argomento</label>
				</div>
				<div class="col-75">
					<input type="text" id="quest" name="args"
						placeholder="inserisci args">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="quest">Domanda</label>
				</div>
				<div class="col-75">
					<input type="text" id="quest" name="quest"
						placeholder="inserisci quest">
				</div>
			</div>
						<div class="row">
				<div class="col-25">
					<label for="ans1">Risposta 1</label>
				</div>
				<div class="col-75">
					<input type="text" id="quest" name="ans1"
						placeholder="inserisci ans1">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="ans2">Risposta 2</label>
				</div>
				<div class="col-75">
					<input type="text" id="quest" name="ans2"
						placeholder="inserisci ans2">
				</div>
			</div>
						<div class="row">
				<div class="col-25">
					<label for="ans3">Risposta 3</label>
				</div>
				<div class="col-75">
					<input type="text" id="quest" name="ans3"
						placeholder="inserisci ans3">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="ans4">Risposta 4</label>
				</div>
				<div class="col-75">
					<input type="text" id="quest" name="ans4"
						placeholder="inserisci ans4">
				</div>

	
  </div>

			<button type="submit">Inserisci</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>