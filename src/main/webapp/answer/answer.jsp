<%@ page import="it.contrader.dto.AnswerDTO"
	import="it.contrader.dto.CandDTO" import="it.contrader.dto.QuestDTO"
	import="java.util.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Answer Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/answer/getall">Risposta</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<AnswerDTO> list = (List<AnswerDTO>) request.getSession().getAttribute("list");
			List<CandDTO> Candlist = (List<CandDTO>) request.getSession().getAttribute("Candlist");
			List<QuestDTO> Questlist = (List<QuestDTO>) request.getSession().getAttribute("Questlist");
		%>

		<br>

		<table>
			<tr>
				<th>Candidato</th>
				<th>Domanda</th>
				<th>Risposta</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (AnswerDTO a : list) {
			%>
			<tr>

				<td><a href="/answer/read?id=<%=a.getId()%>"> <%=a.getCand().getName()%></a></td>
				<td><%=a.getQuest().getQuest()%></td>
				<td><%=a.getAns()%></td>
				<td><a href="/answer/preupdate?id=<%=a.getId()%>">Update</a></td>


				<td><a href="/answer/delete?id=<%=a.getId()%>">Cancella</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/answer/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="Cand">Candidato</label>
				</div>
				<div class="col-75">
					<select id="Cands" name="cand">
						<%
							for (CandDTO c : Candlist) {
						%>
						<option value=<%=c.getId()%>><%=c.getName()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="quest">Domanda</label>
				</div>
				<div class="col-75">
					<select id="Quest" name="quest">
						<%
							for (QuestDTO q : Questlist) {
						%>
						<option value=<%=q.getId()%>><%=q.getQuest()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="ans">Risposta</label>
				</div>
				<div class="col-75">
					<input type="number" id="ans" name="ans"
						placeholder="inserisci ans">
				</div>

			</div>
			<button type="submit">Inserisci</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>