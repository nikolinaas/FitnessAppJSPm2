<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.unibl.etf.ip.beans.KategorijaBean"%>
<%@page import="org.unibl.etf.ip.dto.Kategorija"%>
<jsp:useBean id="kategorijaBean"
	type="org.unibl.etf.ip.beans.KategorijaBean" scope="session"></jsp:useBean>
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
			document.getElementById('fromKategorije').submit();
		}
	</script>
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
			<li class="nav-item"><a href="?action=savjetnici"
				class="nav-link"
				style="color: white; text-decoration: none; display: flex;">Savjetnici</a>
			</li>
			<li class="nav-item"><a href="?action=logovi" class="nav-link "
				style="color: white; text-decoration: none; display: flex;">Statistika</a>
			</li>
		</ul>
	</div>
	<div id="kategorije" class="col-10 main">
		<div class="row" style="height: 10%;"></div>
		<div class="row horizontalline justify-content-center align-items-center">
			<label class="labelhorizontal justify-content-center"
				style="color: aliceblue; font-size: 20px;">Kategorije</label>
		</div>
		<div class="row" style="height: 15%;">
			<div class="col-6"></div>
			<div class="col-6 py-2">
				<a class="btn btnhover align-right" href="?action=DodajKategoriju">Dodaj</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-1"></div>
			<div data-spy="scroll" class="col-10 divtable">
				<form id="fromKategorije" action="?action=IzmijeniKategoriju"
					method="post">

					<table class="table table-bordered">
						<tr>
							<th>ID</th>
							<th>Naziv kategorije</th>
							<th>Opis kategorije</th>
						</tr>
						<%
						for (Kategorija kat : kategorijaBean.GetAllCategories()) {
						%>
						<tr id="tablerowUser" onclick="selectRow(this)" class='trclass'>
							<%
							out.println("<td>" + kat.getId() + "</td>");
							out.println("<td>" + kat.getNazivKategorije() + "</td>");
							out.println("<td>" + kat.getOpisKategorije() + "</td>");
							%>

							<td><a class="btn btnhover"  href="?action=obrisiKategoriju-<%=kat.getId()%>">Obri&scaron;i</a></td>
						</tr>
						<%
						}
						%>

					</table>
					<input type="hidden" id="selectedId" name="selectedId">
				</form>
			</div>
			<div class="col-1"></div>
		</div>
	</div>

</body>
</html>