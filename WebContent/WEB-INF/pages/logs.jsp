<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.unibl.etf.ip.beans.LogoviBean" %>
     <%@ page import="org.unibl.etf.ip.dto.Logovi" %>
    <jsp:useBean id="logoviBean" type="org.unibl.etf.ip.beans.LogoviBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="styles/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="col-2 sidenav " >
<ul class="nav flex-column" >
<li >
    <img alt="logo" src="logo.png" width="20px" height="20px">
  </li>
   <li class="nav-item">
    <a href="?action=kategorije" class="nav-link"  style="color: white;
	text-decoration: none; display: flex;">Kategorije</a>
  </li>
  <li class="nav-item">
    <a href="?action=korisnici" class="nav-link" style="color: white;
	text-decoration: none; display: flex;">Korisnici</a>
  </li>
  <li class="nav-item"><a href="?action=savjetnici"
				class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Savjetnici</a>
			</li>
  <li class="nav-item">
    <a href="?action=logovi" class="nav-link active" style="color: white;
	text-decoration: none; display: flex;">Statistika</a>
  </li>
</ul>
</div>

<div id="logovi" class="col-10 main" >
<div class="row" style="height:10%;"></div>
<div class="row horizontalline justify-content-center align-items-center">
<label class="labelhorizontal justify-content-center align-items-center" style="color:aliceblue;
	font-size:20px;">Statistika</label>
</div>
	<div id="poruke"
			class="container justify-content-center align-items-center">
			<div class="col-1"></div>
			<div class="col-10" data-spy="scroll"
				style="justify-content: center; width: 100%; padding: 10px; overflow-y: auto; width: 100%; height: 100%; max-height: 65%; position: absolute; left: 10%;">
				<%
				for (Logovi log : logoviBean.getAllLogs()) {
					
				%>
				<div class="card  mb-1 card-read" style="width: 100%;">
				
					<div class="card-body">
					<div class="naslov-class"><%=log.getDatum()%></div>
						<%=log.getInfo()%>
					</div>
				</div>
				<%
				
				}
				%>


			</div>
			<div class="col-1"></div>
		</div>
</div>
</body>
</html>