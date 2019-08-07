<%@include file="../headers/questionHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Question Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%@include file="../menu/questionMenu.jsp"%>
<div class="main">
	<%
	List<QuestionDTO> list = (List<QuestionDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Args</th>
			<th>Quest</th>
			<th>Ans1</th>
			<th>Ans2</th>
			<th>Ans3</th>
			<th>Ans4</th>
			<th></th>
			<th></th>
		</tr>
 		<%
			for (QuestionDTO q : list) {
		%>
		<tr>
			<td><a href=QuestionServlet?mode=read&id=<%=q.getId()%>>
			<%=q.getArgs()%></a>
			</td>
			<td><%=q.getQuest()%></td>
			<td><%=q.getAns1()%></td>
			<td><%=q.getAns2()%></td>
			<td><%=q.getAns3()%></td>
			<td><%=q.getAns4()%></td>
			<td><a href=QuestionServlet?mode=read&update=true&id=<%=q.getId()%>>Edit</a>
			</td>
			<td><a href=QuestionServlet?mode=delete&id=<%=q.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="QuestionServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="args">Args</label>
    </div>
    <div class="col-75">
      <input type="text" id="args" name="args" placeholder="inserisci argomento">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="quest">Quest</label>
    </div>
    <div class="col-75">
      <input type="text" id="quest" name="quest" placeholder="inserisci domanda"> 
    </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="ans1">Ans1</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans1" name="ans1" placeholder="inserisci risposta 1"> 
    </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="ans2">Ans2</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans2" name="ans2" placeholder="inserisci risposta 2"> 
    </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="ans3">Ans3</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans3" name="ans3" placeholder="inserisci risposta 3"> 
    </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="ans4">Ans4</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans4" name="ans4" placeholder="inserisci risposta 4"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>