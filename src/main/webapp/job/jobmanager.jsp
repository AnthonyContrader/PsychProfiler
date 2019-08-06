<%@include file="../headers/jobHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Job Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%@include file="../menu/jobMenu.jsp"%>
<div class="main">
	<%
	List<JobDTO> list = (List<JobDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th></th>
			<th></th>
		</tr>
 		<%
			for (JobDTO j : list) {
		%>
		<tr>
			<td><a href=JobServlet?mode=read&id=<%=j.getId()%>>
					<%=j.getName()%>
			</a></td>
			<td><%=j.getDescription()%></td>
			<td><a href=JobServlet?mode=read&update=true&id=<%=j.getId()%>>Edit</a>
			</td>
			<td><a href=JobServlet?mode=delete&id=<%=j.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="JobServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="job">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="job" name="name" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" placeholder="inserisci descrizione"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>