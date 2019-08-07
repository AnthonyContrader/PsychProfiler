<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AnswerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Leggi Risposta</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/answerMenu.jsp" %>
<br>

<div class="main">
<%AnswerDTO a = (AnswerDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>id_cand</th>
		<th>id_quest</th>
		<th>Ans</th>
		<th></th>
	</tr>
	<tr>
		<td><%=a.getId_cand()%></td>
		<td> <%=a.getId_quest()%></td>
		<td> <%=a.getAns()%></td>
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