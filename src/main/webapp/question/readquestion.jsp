<%@include file="../headers/questionHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Leggi Domanda</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/questionMenu.jsp"%>
<br>

<div class="main">
<%QuestionDTO q = (QuestionDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Args</th>
		<th>Quest</th>
		<th>Ans1</th>
		<th>Ans2</th>
		<th>Ans3</th>
		<th>Ans4</th>
	</tr>
	<tr>
		<td><%=q.getArgs()%></td>
		<td> <%=q.getQuest()%></td>
		<td> <%=q.getAns1()%></td>
		<td> <%=q.getAns2()%></td>
		<td> <%=q.getAns3()%></td>
		<td> <%=q.getAns4()%></td>
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
</html>tml>