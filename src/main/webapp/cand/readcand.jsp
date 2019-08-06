<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CandDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Leggi Candidato</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/candMenu.jsp" %>
<br>

<div class="main">
<%CandDTO c = (CandDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Surname</th>
		<th>Age</th>
		<th>Experience</th>
	</tr>
	<tr>
		<td><%=c.getName()%></td>
		<td> <%=c.getSurname()%></td>
		<td> <%=c.getAge()%></td>
		<td> <%=c.getExperience()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>