package org.unibl.etf.ip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.ip.beans.AdministratorBean;
import org.unibl.etf.ip.beans.KategorijaBean;
import org.unibl.etf.ip.beans.KorisnikBean;
import org.unibl.etf.ip.beans.LogoviBean;
import org.unibl.etf.ip.beans.NalogBean;
import org.unibl.etf.ip.beans.SavjetnikBean;
import org.unibl.etf.ip.dao.AdministratorDAO;
import org.unibl.etf.ip.dao.KorisnikDAO;
import org.unibl.etf.ip.dao.NalogDAO;
import org.unibl.etf.ip.dao.SavjetnikDAO;
import org.unibl.etf.ip.dto.Kategorija;
import org.unibl.etf.ip.dto.Korisnik;
import org.unibl.etf.ip.dto.Nalog;
import org.unibl.etf.ip.dto.Savjetnik;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/login.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("notification", "");

		if (action == null || action.equals("")) {

			address = "/WEB-INF/pages/login.jsp";
		} else if (action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			AdministratorBean adminBean = new AdministratorBean();
			KategorijaBean kategorijaBean = new KategorijaBean();
			KorisnikBean korisnikBean = new KorisnikBean();
			NalogBean nalogBean = new NalogBean();
			LogoviBean logoviBean= new LogoviBean();
			SavjetnikBean savjetnikBean = new SavjetnikBean();
			if (adminBean.LogIn(username, password)) {
				session.setAttribute("savjetnikBean", savjetnikBean);
				session.setAttribute("adminBean", adminBean);
				session.setAttribute("kategorijaBean", kategorijaBean);
				session.setAttribute("korisnikBean", korisnikBean);
				session.setAttribute("nalogBean", nalogBean);
				session.setAttribute("logoviBean", logoviBean);
				session.setAttribute("notification", "");
				address = "/WEB-INF/pages/start.jsp";
			} else {
				session.setAttribute("notification", "Pogresni kredencijali, pokusajte ponovo!");
			}

		} else if (action.equals("korisnici")) {
			address = "/WEB-INF/pages/users.jsp";
		} else if (action.equals("logovi")) {
			address = "/WEB-INF/pages/logs.jsp";
		} else if (action.equals("kategorije")) {
			address = "/WEB-INF/pages/start.jsp";
		} else if (action.equals("savjetnici")) {
			address = "/WEB-INF/pages/advisers.jsp";
		} else if (action.equals("DodajKategoriju")) {
			address = "/WEB-INF/pages/addCategory.jsp";
		} else if (action.equals("DodajKorisnika")) {
			address = "/WEB-INF/pages/addUser.jsp";

		} else if (action.equals("saveCategory")) {
			KategorijaBean kategorijaBean = (KategorijaBean) session.getAttribute("kategorijaBean");
			String categoryName = request.getParameter("nazivKategorije");
			String categoryDescription = request.getParameter("opisKategorije");
			if (kategorijaBean.addCategory(categoryName, categoryDescription)) {
				address = "/WEB-INF/pages/start.jsp"; 

			} else {
				System.out.println("nije prosloooo");
			}

		} else if (action.equals("saveUser")) {
			KorisnikBean korisnikBean = (KorisnikBean) session.getAttribute("korisnikBean");
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String email = request.getParameter("emailKorisnika");
			String brTelefona = request.getParameter("brTelefona");
			String adresa = request.getParameter("adresaKorisnika");
			String korIme = request.getParameter("korImeKorisnika");
			String lozinka = request.getParameter("lozinkaKorisnika");
			if (korisnikBean.createUser(ime, prezime, email, brTelefona, adresa, korIme, lozinka)) {
				session.setAttribute("notificationUser", "");
				address = "/WEB-INF/pages/users.jsp";
			} else {
				session.setAttribute("notificationUser", "Korisnicko ime nije jedinstveno, pokusajte ponovo");
				address = "/WEB-INF/pages/addUser.jsp";
				System.out.println("nije proslooooooooo");
			}
		}
		else if (action.equals("saveAdvisor")) {
			SavjetnikBean savjetnikbean = (SavjetnikBean) session.getAttribute("savjetnikBean");
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String email = request.getParameter("emailKorisnika");
			String brTelefona = request.getParameter("brTelefona");
			String adresa = request.getParameter("adresaKorisnika");
			String korIme = request.getParameter("korImeKorisnika");
			String lozinka = request.getParameter("lozinkaKorisnika");
			if (savjetnikbean.createUser(ime, prezime, email, brTelefona, adresa, korIme, lozinka)) {
				session.setAttribute("notificationUser", "");
				address = "/WEB-INF/pages/users.jsp";
			} else {
				session.setAttribute("notificationUser", "Korisnicko ime nije jedinstveno, pokusajte ponovo");
				address = "/WEB-INF/pages/addUser.jsp";
				System.out.println("nije proslooooooooo");
			}
		}else if (action.equals("IzmijeniKorisnika")) {

			address = "/WEB-INF/pages/updateUser.jsp";
		} else if (action.equals("IzmijeniKategoriju")) {
			address = "/WEB-INF/pages/updateCategory.jsp";
		} else if (action.equals("updateCategory")) {
			KategorijaBean kategorijaBean = (KategorijaBean) session.getAttribute("kategorijaBean");
			String categoryName = request.getParameter("nazivKategorije");
			String categoryDescription = request.getParameter("opisKategorije");
			Kategorija kateg = new Kategorija(categoryName, categoryDescription);
			System.out.println("++++++++++++" + request.getParameter("selectedId"));
			if (kategorijaBean.updateCategory(Integer.parseInt(request.getParameter("selectedId")), kateg))
				address = "/WEB-INF/pages/start.jsp";
			else
				System.out.println("nije proslooooooooooooo");
		} else if (action.startsWith("updateUser")) {
			System.out.println(action);
			String stringId = action.split("-")[1];
			System.out.println(stringId);
			KorisnikBean korisnikBean = (KorisnikBean) session.getAttribute("korisnikBean");
			System.out.println(korisnikBean.toString());
			NalogBean nalogBean = (NalogBean) session.getAttribute("nalogBean");
			Integer id =Integer.parseInt(stringId);
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String email = request.getParameter("emailKorisnika");
			String brTelefona = request.getParameter("brTelefona");
			String adresa = request.getParameter("adresaKorisnika");
			String korIme = request.getParameter("korImeKorisnika");
			String lozinka = request.getParameter("lozinkaKorisnika");
			Nalog nalog = KorisnikDAO.getUserById(id).getNalog();
			Korisnik kor = new Korisnik( ime, prezime, email, brTelefona, adresa, nalog);
			if (korisnikBean.editUser(id, kor) && nalogBean.EditAccount(nalog.getId(), new Nalog(korIme, lozinka))) {
				address = "/WEB-INF/pages/users.jsp";
			}

		}  else if (action.startsWith("updateAdvisor")) {
			System.out.println(action);
			String stringId = action.split("-")[1];
			System.out.println(stringId);
			SavjetnikBean savjetnikBean = (SavjetnikBean) session.getAttribute("savjetnikBean");
			System.out.println(savjetnikBean.toString());
			NalogBean nalogBean = (NalogBean) session.getAttribute("nalogBean");
			Integer id =Integer.parseInt(stringId);
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String email = request.getParameter("emailKorisnika");
			String brTelefona = request.getParameter("brTelefona");
			String adresa = request.getParameter("adresaKorisnika");
			String korIme = request.getParameter("korImeKorisnika");
			String lozinka = request.getParameter("lozinkaKorisnika");
			Nalog nalog = SavjetnikDAO.getUserById(id).getNalog();
			Savjetnik savjetnik = new Savjetnik( ime, prezime, email, brTelefona, adresa, nalog);
			if (savjetnikBean.editAdvisor(id, savjetnik) && nalogBean.EditAccount(nalog.getId(), new Nalog(korIme, lozinka))) {
				address = "/WEB-INF/pages/users.jsp";
			}

		}else if (action.startsWith("obrisiKorisnika")) {
			KorisnikBean korisnikBean = (KorisnikBean) session.getAttribute("korisnikBean");
			String stringId = action.split("-")[1];
			System.out.println(action);
		
			  if(korisnikBean.deleteUser(Integer.parseInt(stringId))) {
			  
			  address = "/WEB-INF/pages/users.jsp"; }else {
			  System.out.println("niej prosloooooooooooooooooo"); }
			 
		} else if (action.startsWith("obrisiKategoriju")) {
			KategorijaBean katBean = (KategorijaBean) session.getAttribute("kategorijaBean");
			String stringId = action.split("-")[1];
			if (katBean.deleteCategory(Integer.parseInt(stringId))) {
				address = "/WEB-INF/pages/start.jsp";
			}
		} else if (action.equals("IzmijeniSavjetnika")) {
			address = "/WEB-INF/pages/updateAdvisor.jsp";
			
			

		} else if (action.equals("obrisiSavjetnika")) {
			SavjetnikBean savjetnikBean = (SavjetnikBean) session.getAttribute("savjetnikBean");
			String stringId = action.split("-")[1];
			System.out.println(action);
		
			  if(savjetnikBean.deleteAdvisor(Integer.parseInt(stringId))) {
			  
			  address = "/WEB-INF/pages/advisers.jsp"; }else {
			  System.out.println("niej prosloooooooooooooooooo"); }
			 

		}  else if (action.equals("DodajSavjetnika")) {
			address = "/WEB-INF/pages/addAdvisor.jsp";

		} 

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
