<%@ page import="it.contrader.dto.AnswerDTO" import="it.contrader.dto.CandDTO"
		 import="it.contrader.dto.QuestDTO" import="java.util.*" 
	language="java" contentType="text/html; charset=ISO-8859-1"
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
<title>Answer Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/answer/getall">Answer</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<AnswerDTO> list = (List<AnswerDTO>) request.getSession().getAttribute("list");
			List<CandDTO> Candlist = (List<CandDTO>)request.getSession().getAttribute("Candlist");
			List<QuestDTO> Questlist = (List<QuestDTO>)request.getSession().getAttribute("Questlist");

		%>

		<br>

		<table>
			<tr>
				<th>Cand</th>
				<th>Quest</th>
				<th>ans</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (AnswerDTO a : list) {
			%>
			<tr>
		
				<td>		<a href="/answer/read?id=<%=a.getId()%>"> <%=a.getCand().getId()%></a></td>
				<td> <%=a.getQuest().getId()%></td>
				<td><%=a.getAns()%></td>
				<td><a href="/answer/preupdate?id=<%=a.getId()%>">Edit</a></td>


				<td><a href="/answer/delete?id=<%=a.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/answer/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="Cand">Cand</label>
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
					<label for="quest">Quest</label>
				</div>
				<div class="col-75">
								<select id="Cands" name="cand">
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
					<label for="ans">ans</label>
				</div>
				<div class="col-75">
					<input type="number" id="ans" name="ans"
						placeholder="inserisci ans">
				</div>
				
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>