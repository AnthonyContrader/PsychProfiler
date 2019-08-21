<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="it.contrader.dto.QuestDTO"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Quest Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Quest</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/quest/getall">Quest</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%QuestDTO q = (QuestDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/quest/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="args">Args</label>
    </div>
    <div class="col-75">
      <input type="text" id=quest name="args" value=<%=q.getArgs()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="Quest">quest</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quest" name="quest" value=<%=q.getQuest()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="ans1">ans1</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quest" name="ans1" value=<%=q.getAns1()%>> 
    </div>
  </div>  <div class="row">
    <div class="col-25">
     <label for="Quest">quest</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quest" name="ans2" value=<%=q.getAns2()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="ans3">ans3</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quest" name="ans3" value=<%=q.getAns3()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="ans4">ans4</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quest" name="ans4" value=<%=q.getAns4()%>> 
    </div>
   <input type="hidden" name="id" value =<%=q.getId() %>> 
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>