<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.unibl.etf.ip.beans.SavjetnikBean"%>
<%@ page import="org.unibl.etf.ip.dto.Savjetnik"%>
<jsp:useBean id="savjetnikBean"
	type="org.unibl.etf.ip.beans.SavjetnikBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Savjetnici</title>
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
				class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Kategorije</a>
			</li>
			<li class="nav-item"><a href="?action=korisnici"
				class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Korisnici</a>
			</li>
			<li class="nav-item"><a href="?action=savjetnici"
				class="nav-link active"
				style="color: white; text-decoration: none; display: flex;">Savjetnici</a>
			</li>
			<li class="nav-item"><a href="?action=logovi" class="nav-link "
				style="color: white; text-decoration: none; display: flex;">Statistika</a>
			</li>
		</ul>
	</div>

	<div id="logovi" class="col-10 main">
		<div class="row" style="height: 10%;"></div>
		<div
			class="row horizontalline justify-content-center justify-content-center align-items-center">
			<label class="labelhorizontal justify-content-center"
				style="color: aliceblue; font-size: 20px; align-items: 'center''">Savjetnici</label>
		</div>
		<div class="row" style="height: 15%;">
			<div class="col-6"></div>
			<div class="col-6 py-2 " style="display: flex;  justify-content: flex-end;">
				<a class="btn btnhover " href="?action=DodajSavjetnika">Dodaj</a>
			</div>
		</div>
			<div class="row justify-content-center">
			
			<div data-spy="scroll" class="divtable p-1 justify-content-center table-responsive">
			<form id="myForm" action="?action=IzmijeniSavjetnika" method="post">
				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<th>Ime</th>
						<th>Prezime</th>
						<th>Email</th>
						<th>Broj telefona</th>
						<th>Adresa</th>
						<th>Korisni&ccaron;ko ime</th>
						<th>Lozinka</th>
					</tr>
					<%
					for (Savjetnik savjetnik : savjetnikBean.getAllAdvisors()) {
					%>
					<tr class="trclass" id="tablerowUser" onclick="selectRow(this)">
						<%
						out.println("<td>" + savjetnik.getId() + "</td>");
						out.println("<td>" + savjetnik.getIme() + "</td>");
						out.println("<td>" + savjetnik.getPrezime() + "</td>");
						out.println("<td>" + savjetnik.getEmail() + "</td>");
						out.println("<td>" + savjetnik.getBrtelefona() + "</td>");
						out.println("<td>" + savjetnik.getAdresa() + "</td>");
						out.println("<td>" + savjetnik.getNalog().getKorisnickoIme() + "</td>");
						out.println("<td>" + savjetnik.getNalog().getLozinka() + "</td>");
						%>
					
						<td><a class="btn btnhover" href="?action=obrisiSavjetnika-<%=savjetnik.getId()%>">Obri&scaron;i</a></td>
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