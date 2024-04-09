<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje korisnika</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="styles/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="col-2 sidenav ">
		<ul class="nav flex-column">
			<li><img alt="logo" src="logo.png" width="20px" height="20px">
			</li>
			<li class="nav-item"><a href="?action=kategorije"
				class="nav-link active" style="color: white; text-decoration: none;">Kategorije</a>
			</li>
			<li class="nav-item"><a href="?action=korisnici"
				class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Korisnici</a>
			</li>
			<li class="nav-item"><a href="?action=logovi" class="nav-link "
				style="color: white; text-decoration: none; display: flex;">Logovi</a>
			</li>
		</ul>
	</div>
	<div id="kategorije" class="col-10 main">
		<div class="row" style="height: 10%;"></div>
		<div class="row horizontalline justify-content-center">
			<label class="labelhorizontal justify-content-center"
				style="color: aliceblue; font-size: 20px;">Dodavanje novog korisnika</label>
				
		</div>
		<div class="row" style="height: 5%;">
		
		</div>
		<div class="row justify-content-center">
			<div class="col-1"></div>
			<div class="col-10 info-div">
				<form method="post" action="?action=saveUser">
				<label>Ime</label>
				<input type="text" class="form-control" name="imeKorisnika" id="imeKorisnika"> 
				<br/>
				<label>Prezime</label>
				<input type="text" class="form-control" name="prezimeKorisnika" id="preimeKorisnika"> 
				<br/>
				<label>Email</label>
				<input type="text" class="form-control" name="emailKorisnika" id="emailKorisnika"> 
				<br/>
				<label>Broj telefona</label>
				<input type="text" class="form-control" name="brTelefona" id="brTelefona"> 
				<br/>
				<label>Adresa</label>
				<input type="text" class="form-control" name="adresaKorisnika" id="adresaKorisnika"> 
				<br/>
				<label>Korisničko ime</label>
				<input type="text" class="form-control" name="korImeKorisnika" id="korImeKorisnika"> 
				<br/>
				<label>Lozinka</label>
				<input type="text" class="form-control" name="lozinkaKorisnika" id="lozinkaKorisnika"> 
				<br/>
				<input class="btn btnhover" type="submit" value="Sačuvaj">
				</form>
			</div>
			<div class="col-1"></div>
		</div>
	</div>

</body>
</html>