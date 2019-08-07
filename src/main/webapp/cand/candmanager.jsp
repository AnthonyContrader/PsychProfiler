<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import= "it.contrader.dto.CandDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Cand Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/candMenu.jsp" %>
<div class="main">
	<%
		List<CandDTO> list = (List<CandDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Age</th>
			<th>Experience</th>
			<th></th>
		</tr>
		<%
			for (CandDTO c : list) {
		%>
		<tr>
			<td><a href=CandServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getSurname()%></td>
			<td><%=c.getAge()%></td>
			<td><%=c.getExperience()%></td>
			<td><a href=CandServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CandServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="CandServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="Cand">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="Cand" name="name" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="surname">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" placeholder="inserisci cognome"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="age">Age</label>
    </div>
    <div class="col-75">
      <input type="number" id="age" name="age" placeholder="inserisci età"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="experience">Experience</label>
    </div>
    <div class="col-75">
      <input type="text" id="experience" name="experience" placeholder="inserisci esperienza"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>