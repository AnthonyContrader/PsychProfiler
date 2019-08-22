<%@ page import="it.contrader.dto.CandDTO"  import="it.contrader.dto.UserDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cand Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Cand Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/cand/getall">Cands</a> <a href="/cand/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CandDTO> list = (List<CandDTO>) request.getSession().getAttribute("list");
		    List<UserDTO> Userlist = (List<UserDTO>) request.getSession().getAttribute("Userlist");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Age</th>
				<th>Experience</th>
				<th>User</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (CandDTO c : list) {
			%>
			<tr>
				<td><a href="/cand/read?id=<%=c.getId()%>"> <%=c.getName()%>
				</a></td>
				<td><%=c.getSurname()%></td>
				<td><%=c.getAge()%></td>
				<td><%=c.getExperience()%></td>
				<td><%=c.getUser().getId()%></td>
				<td><a href="/cand/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/cand/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/cand/insert" method="post">
			
			<div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci il nome">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="surn">Surname</label>
				</div>
				<div class="col-75">
					<input type="text" id="surn" name="surname"
						placeholder="inserisci surname">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="age">Age</label>
				</div>
				<div class="col-75">
					<input type="text" id="age" name="age"
						placeholder="inserisci l'età">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="expe">Experience</label>
				</div>
				<div class="col-75">
					<input type="text" id="expe" name="experience"
						placeholder="inserisci esperienza">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="user">User</label>
				</div>
				<div class="col-75">
					<select id ="User" name ="user" >
					<%
					  for (UserDTO u : Userlist) {
					%>
					<option value=<%=u.getId()%>><%=u.getUsername()%></option>
					<%
					}
					%>
					</select>
						
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>