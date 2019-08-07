<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AnswerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Answer</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/adminMenu.jsp" %>
<br>
<div class="main">

<%AnswerDTO a = (AnswerDTO) request.getAttribute("dto");%>


<form id="floatleft" action="AnswerServlet?mode=update&id=<%=a.getId_ans()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="id_cand">id_cand</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_cand" name="id_cand" value=<%=a.getId_cand()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="id_quest">id_quest</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_quest" name="id_quest" value=<%=a.getId_quest()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ans">Ans</label>
    </div>
   		 <div class="col-75">
 			  <input type="number" id="ans" name="ans" value=<%=a.getAns()%>> 
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>