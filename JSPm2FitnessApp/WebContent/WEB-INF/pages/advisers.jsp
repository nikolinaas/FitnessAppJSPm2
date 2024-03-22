<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Savjetnici</title>
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
  <li class="nav-item"><a href="?action=korisnici"
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
<div class="row horizontalline justify-content-center">
<label class="labelhorizontal justify-content-center" style="color:aliceblue;
	font-size:20px;">Savjetnici</label>
</div>
</div>
</body>
</html>