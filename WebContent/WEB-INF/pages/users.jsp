<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.unibl.etf.ip.beans.KorisnikBean"%>
<%@page import="org.unibl.etf.ip.dto.Korisnik"%>
<jsp:useBean id="korisnikBean"
	type="org.unibl.etf.ip.beans.KorisnikBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="styles/style.css" type="text/css" rel="stylesheet">
</head>
<body>
 <script>
     
        function selectRow(row) {
       var id = row.cells[0].textContent;

            document.getElementById('selectedId').value = id;

            sessionStorage.setItem('attributeId', id);
            console.log("====" + id);
            document.getElementById('myForm').submit(); 
        }
    </script>
    
    
	<div class="col-2 sidenav ">
		<ul class="nav flex-column">
			<li><img alt="logo" src="logo.png" width="20px" height="20px">
			</li>
			<li class="nav-item"><a href="?action=kategorije"
				class="nav-link "
				style="color: white; text-decoration: none; display: flex;">Kategorije</a>
			</li>
			<li class="nav-item"><a href="?action=korisnici"
				class="nav-link active"
				style="color: white; text-decoration: none; display: flex;">Korisnici</a>
			</li>
			<li class="nav-item"><a href="?action=savjetnici"
				class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Savjetnici</a>
			</li>
			<li class="nav-item"><a href="?action=logovi" class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Statistika</a>
			</li>
		</ul>
	</div>
	<div id="korisnici" class="col-10 main">
		<div class="row" style="height: 10%;"></div>
		<div class="row horizontalline justify-content-center align-items-center">
			<label class="labelhorizontal justify-content-center"
				style="color: aliceblue; font-size: 20px;">Korisnici</label>
		</div>
		<div class="row" style="height: 15%;">
			<div class="col-6"></div>
			<div class="col-6 py-2 " style="display: flex;  justify-content: flex-end;">
				<a class="btn btnhover " href="?action=DodajKorisnika">Dodaj</a>
			</div>
		</div>
		<div class="row justify-content-center">
			
			<div data-spy="scroll" class="divtable p-1 justify-content-center table-responsive">
			<form id="myForm" action="?action=IzmijeniKorisnika" method="post">
				<table class="table table-bordered">
					<tr>
						<th>JMBG</th>
						<th>Ime</th>
						<th>Prezime</th>
						<th>Email</th>
						<th>Broj telefona</th>
						<th>Adresa</th>
						<th>Korisni&ccaron;ko ime</th>
						<th>Lozinka</th>
					</tr>
					<%
					for (Korisnik korisnik : korisnikBean.getAllUsers()) {
					%>
					<tr class="trclass" id="tablerowUser" onclick="selectRow(this)">
						<%
						out.println("<td>" + korisnik.getJMBG() + "</td>");
						out.println("<td>" + korisnik.getIme() + "</td>");
						out.println("<td>" + korisnik.getPrezimme() + "</td>");
						out.println("<td>" + korisnik.getEmail() + "</td>");
						out.println("<td>" + korisnik.getBrojTelefona() + "</td>");
						out.println("<td>" + korisnik.getAdresa() + "</td>");
						out.println("<td>" + korisnik.getNalog().getKorisnickoIme() + "</td>");
						out.println("<td>" + korisnik.getNalog().getLozinka() + "</td>");
						%>
					
						<td><a class="btn btnhover" href="?action=obrisiKorisnika-<%=korisnik.getJMBG()%>">Obri&scaron;i</a></td>
					</tr>
					
					<%
					}
					%>
				</table>
				<input type="hidden" id="selectedId" name="selectedId">
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>