<%@include file="../headers/jobHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Job</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@include file="../menu/jobMenu.jsp"%>
<br>
<div class="main">

<%JobDTO j = (JobDTO) request.getAttribute("dto");%>


<form id="floatleft" action="JobServlet?mode=update&id=<%=j.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="job">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=j.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="description" name="description" value=<%=j.getDescription()%>> 
    </div>
  </div>

      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>