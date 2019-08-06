<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CandDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel=stylesheet>
<title>Edit Cand</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/candMenu.jsp" %>
<br>
<div class="main">

<%CandDTO c = (CandDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CandServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="cand">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="cand" name="name" value=<%=c.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="surname">Surname</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="Surname" name="surname" value=<%=c.getSurname()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="Age">Age</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="Age" name="age" value=<%=c.getAge()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="Experience">Experience</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="Experience" name="Expericence" value=<%=c.getExperience()%>> 
    </div>
  </div>
    
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>