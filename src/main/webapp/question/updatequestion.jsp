<%@include file="../headers/questionHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Job</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/questionMenu.jsp"%>
<br>
<div class="main">

<%QuestionDTO q = (QuestionDTO) request.getAttribute("dto");%>


<form id="floatleft" action="QuestionServlet?mode=update&id=<%=q.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="args">Args</label>
    </div>
    <div class="col-75">
      <input type="text" id="args" name="args" value=<%=q.getArgs()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="quest">Quest</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="quest" name="quest" value=<%=q.getQuest()%>> 
    </div>
    <div class="row">
    <div class="col-25">
      <label for="ans1">Ans1</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans1" name="ans1" value=<%=q.getAns1()%>>
    </div>
    <div class="row">
    <div class="col-25">
      <label for="ans2">Ans2</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans2" name="ans2" value=<%=q.getAns2()%>>
    </div>
    <div class="row">
    <div class="col-25">
      <label for="ans3">Ans3</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans3" name="ans3" value=<%=q.getAns3()%>>
    </div>
    <div class="row">
    <div class="col-25">
      <label for="ans4">Ans4</label>
    </div>
    <div class="col-75">
      <input type="text" id="ans4" name="ans4" value=<%=q.getAns4()%>>
    </div>
  </div>

      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>