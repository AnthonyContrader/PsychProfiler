<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.AnswerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%@include file="../menu/answerMenu.jsp" %>
<div class="main">
	<%
		List<AnswerDTO> list = (List<AnswerDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>id_ans</th>
			<th>id_cand</th>
			<th>id_quest</th>
			<th>ans</th>
			<th></th>
		</tr>
		<%
			for (AnswerDTO a : list) {
		%>
		<tr>
			<td><a href=AnswerServlet?mode=read&id=<%=a.getId_ans()%>>
					<%=a.getId_cand()%>
			</a></td>
			<td><%=a.getId_quest()%></td>
			<td><%=a.getAns()%></td>
			<td><a href=AnswerServlet?mode=read&update=true&id=<%=a.getId_ans()%>>Edit</a>
			</td>
			<td><a href=AnswerServlet?mode=delete&id=<%=a.getId_ans()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="AnswerServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="id_cand">Id_cand</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_cand" name="id_cand" placeholder="inserisci id_cand">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="id_quest">Id_quest</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_quest" name="id_quest" placeholder="inserisci id_quest"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ans">Ans</label>
    </div>
   		 <div class="col-75">
		<input type="number" id="ans" name="ans" placeholder="inserisci il numero della risp corretta"> 
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>