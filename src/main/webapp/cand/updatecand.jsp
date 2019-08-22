<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CandDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cand Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Cand</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/cand/getall">Cand</a>
  <a href="/cand/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CandDTO c = (CandDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/cand/update" method="post">
  
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=c.getName()%>>
    </div>
    </div>
    
  <div class="row">
    <div class="col-25">
    <label for="surn">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surn" name="surname" value=<%=c.getSurname()%>>
    </div>
     </div>
     
  <div class="row">
    <div class="col-25">
    <label for="age">Age</label>
    </div>
    <div class="col-75">
      <input type="text" id="age" name="age" value=<%=c.getAge()%>>
    </div>
    </div>
    
  <div class="row">
    <div class="col-25">
    <label for="expe">Experience</label>
    </div>
    <div class="col-75">
      <input type="text" id="expe" name="experience" value=<%=c.getExperience()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="user">User</label>
    </div>
   		 <div class="col-75">
   		  <input
			type="text" id="user" name="user" value=<%=c.getUser().getId()%>>
    	</div>
    	<input type="hidden" name="id" value =<%=c.getId() %>>
    	</div>
    	
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>