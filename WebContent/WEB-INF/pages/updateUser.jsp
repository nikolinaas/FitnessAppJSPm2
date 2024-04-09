<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.unibl.etf.ip.beans.KorisnikBean"%>
<%@page import="org.unibl.etf.ip.dto.Korisnik"%>
<jsp:useBean id="korisnikBean"
	type="org.unibl.etf.ip.beans.KorisnikBean" scope="session"></jsp:useBean>
	<jsp:useBean id="nalogBean"
	type="org.unibl.etf.ip.beans.NalogBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izmijeni korisnika</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="styles/style.css" type="text/css" rel="stylesheet">
</head>
<%
String selectedId = request.getParameter("selectedId");

System.out.println("Selected Row ID: " + selectedId);
Korisnik kor = korisnikBean.getUserById(Integer.parseInt(selectedId));
System.out.println(kor.getIme());
%>
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
		<div class="row horizontalline justify-content-center align-items-center">
			<label class="labelhorizontal justify-content-center"
				style="color: aliceblue; font-size: 20px;">Izmjena podataka
				korisnika</label>

		</div>
		<div class="row" style="height: 5%;"></div>
		<div class="row justify-content-center">
			<div class="col-1"></div>
			<div class="col-10 info-div">
				<form method="post" action="?action=updateUser-<%=selectedId%>">
				<label>Ime</label>
					<input type="text" class="form-control" name="imeKorisnika"
						id="imeKorisnika" value="<%=kor.getIme()%>"> <br /> <label>Prezime</label>
					<input type="text" class="form-control" name="prezimeKorisnika"
						id="preimeKorisnika" value="<%=kor.getPrezimme()%>"> <br />
					<label>Email</label> <input type="text" class="form-control"
						name="emailKorisnika" id="emailKorisnika"
						value="<%=kor.getEmail()%>"> <br /> <label>Broj
						telefona</label> <input type="text" class="form-control" name="brTelefona"
						id="brTelefona" value="<%=kor.getBrojTelefona()%>"> <br />
					<label>Adresa</label> <input type="text" class="form-control"
						name="adresaKorisnika" id="adresaKorisnika"
						value="<%=kor.getAdresa()%>"> <br /> <label>Korisni&ccaron;ko
						ime</label> <input type="text" class="form-control" name="korImeKorisnika"
						id="korImeKorisnika"
						value="<%=kor.getNalog().getKorisnickoIme()%>"> <br /> <label>Lozinka</label>
					<input type="text" class="form-control" name="lozinkaKorisnika"
						id="lozinkaKorisnika" value="<%=kor.getNalog().getLozinka()%>">
					<br /> <input class="btn btnhover" type="submit"
						value="Sa&ccaron;uvaj"> <input type="hidden"
						id="selectedId" name="selectedId" value="<%=selectedId%>">
				</form>
			</div>
			<div class="col-1"></div>
		</div>
	</div>

</body>
</html>