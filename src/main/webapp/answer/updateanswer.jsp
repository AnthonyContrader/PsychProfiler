<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="it.contrader.dto.AnswerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="answer Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Answer</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/answer/getall">Answer</a>
  <a href="/answer/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%AnswerDTO a = (AnswerDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/answer/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="Cand">Cand</label>
    </div>
    <div class="col-75">
      <input type="text" id="answer" name="cand" value=<%=a.getCand().getId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="quest">Quest</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="answer" name="quest" value=<%=a.getQuest().getId()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ans">Ans</label>
    </div>
        <div class="col-75">
      <input
			type="text" id="answer" name="ans" value=<%=a.getAns()%>> 
    </div>

    	<input type="hidden" name="id" value =<%=a.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>