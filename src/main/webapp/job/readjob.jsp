<%@include file="../headers/jobHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Leggi Lavoro</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/jobMenu.jsp"%>
<br>

<div class="main">
<%JobDTO j = (JobDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Description</th>
	</tr>
	<tr>
		<td><%=j.getName()%></td>
		<td> <%=j.getDescription()%></td>
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