<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="it.contrader.dto.AnswerDTO"
    import="it.contrader.dto.CandDTO" import="it.contrader.dto.QuestDTO" import= "java.util.*"%>
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
  <a class="active" href="/answer/getall">Risposta</a>
  <a href="/answer/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%
AnswerDTO a = (AnswerDTO) request.getSession().getAttribute("dto");
List<CandDTO> Candlist = (List<CandDTO>)request.getSession().getAttribute("Candlist");
List<QuestDTO> Questlist = (List<QuestDTO>)request.getSession().getAttribute("Questlist");

%>


<form id="floatleft" action="/answer/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="Cand">Candidato</label>
    </div>
    <div class="col-75">
     <select id="Cands" name="cand">
						<%
							for (CandDTO c : Candlist) {
						%>
						<option value=<%=c.getId()%>><%=c.getName()%></option>
						<%
							}
						%>
				</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="quest">Domanda</label>
    </div>
    <div class="col-75">
	<select id="Quests" name="quest">
						<%
							for (QuestDTO q : Questlist) {
						%>
						
						<option value=<%=q.getId()%>><%=q.getQuest()%></option>
						
						<%
							}
						%>
				</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ans">Risposta</label>
    </div>
        <div class="col-75">
      <input
			type="text" id="answer" name="ans" value=<%=a.getAns()%>> 
    </div>

    	<input type="hidden" name="id" value =<%=a.getId() %>>
  </div>
      <button type="submit" >Update</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>