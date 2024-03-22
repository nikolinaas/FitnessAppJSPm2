<%@page import="org.unibl.etf.ip.beans.AdministratorBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"
	content="width=device-width, height=device-height, initial-scale=1, shrink-to-fit=yes">
<title>LogIn</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link href="styles/style.css" type="text/css" rel="stylesheet">


</head>
<body>
<section>
	<div
		class="container py-3 d-flex justify-content-center align-items-center" style="flex-direction: column;">
		
		<div class="row justify-content-center align-items-center">
			
		<div class="col-md-6 col-sm-7 justify-content-center align-items-center" style=" width: 100%;">
			<div class=" bg-color card  text-white justify-content-center align-items-center"
				style="border-radius: 5px; width: 100%;">
				<div class="card-header justify-content-center align-items-center">
				<div class="justify-content-center align-items-center"><label>FitnessApp-ADMIN</label></div>
				
				</div>
				<div class="card-header justify-content-center align-items-center">
				<div class="justify-content-center align-items-center"><label> Prijava</label></div>
				
				</div>
				<div class="card-body py-1 text-center justify-content-center">

					<form class="formopacity" method="POST" action="?action=login">
					<div class="form-group">
						<label class="form-label">Korisni&ccaron;ko ime</label> <input
							type="text" id="username" name="username" class="form-control " />
							</div>
						<div class="form-group">
						<label class="form-label">Lozinka</label> <input type="password"
							name="password" id="password" class="form-control " />
							</div>
						<div class="py-2">
							<input class="btn btn-outline-light btn-lg" value="Prijavi se"
								type="submit" />
						</div>

					</form>

					<div>
						<%=session.getAttribute("notification") != null
		? "<div style='background-color: aliceblue; color: red; border-radius: 5px;'><span class='popuptext' id='myPopup'>"
				+ session.getAttribute("notification").toString() + "</span></div>"
		: ""%>

					</div>
				</div>
			</div>	

		</div>
	
		</div>


	</div>


</section>
</body>
</html>