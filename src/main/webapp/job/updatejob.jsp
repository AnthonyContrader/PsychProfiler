<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.JobDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Job Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Job</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/job/getall">Jobs</a>
  <a href="/job/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%JobDTO j = (JobDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/job/update" method="post">
  
  <div class="row">
    <div class="col-25">
      <label for="job">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="job" name="name" value=<%=j.getName()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="desc">Descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="desc" name="description" value=<%=j.getDescription()%>> 
    </div>
    	<input type="hidden" name="id" value =<%=j.getId() %>>
  </div>
  
      <button type="submit" >Update</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>