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
import org.unibl.etf.ip.beans.NalogBean;
import org.unibl.etf.ip.dao.AdministratorDAO;
import org.unibl.etf.ip.dao.KorisnikDAO;
import org.unibl.etf.ip.dao.NalogDAO;
import org.unibl.etf.ip.dto.Kategorija;
import org.unibl.etf.ip.dto.Korisnik;
import org.unibl.etf.ip.dto.Nalog;

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
			if (adminBean.LogIn(username, password)) {
				session.setAttribute("adminBean", adminBean);
				session.setAttribute("kategorijaBean", kategorijaBean);
				session.setAttribute("korisnikBean", korisnikBean);
				session.setAttribute("nalogBean", nalogBean);
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
		}  else if (action.equals("DodajKategoriju")) {
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
			String jmbg = request.getParameter("jmbg");
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String email = request.getParameter("emailKorisnika");
			String brTelefona = request.getParameter("brTelefona");
			String adresa = request.getParameter("adresaKorisnika");
			String korIme = request.getParameter("korImeKorisnika");
			String lozinka = request.getParameter("lozinkaKorisnika");
			if (korisnikBean.createUser(jmbg, ime, prezime, email, brTelefona, adresa, korIme, lozinka)) {
				address = "/WEB-INF/pages/users.jsp";
			} else {
				System.out.println("nije proslooooooooo");
			}
		} else if (action.equals("IzmijeniKorisnika")) {
			
			address = "/WEB-INF/pages/updateUser.jsp";
		} else if (action.equals("IzmijeniKategoriju")) {
			address = "/WEB-INF/pages/updateCategory.jsp";
		}else if (action.equals("updateCategory")) {
			KategorijaBean kategorijaBean = (KategorijaBean) session.getAttribute("kategorijaBean");
			String categoryName = request.getParameter("nazivKategorije");
			String categoryDescription = request.getParameter("opisKategorije");
			Kategorija kateg = new Kategorija(categoryName, categoryDescription);
			System.out.println("++++++++++++" + request.getParameter("selectedId"));
			if(kategorijaBean.updateCategory(Integer.parseInt(request.getParameter("selectedId")), kateg))
			address = "/WEB-INF/pages/start.jsp";
			else System.out.println("nije proslooooooooooooo");
		}else if (action.equals("updateUser")) {
			KorisnikBean korisnikBean = (KorisnikBean) session.getAttribute("korisnikBean");
			NalogBean nalogBean  = (NalogBean) session.getAttribute("nalogBean");
			String jmbg = request.getParameter("jmbg");
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String email = request.getParameter("emailKorisnika"); 
			String brTelefona = request.getParameter("brTelefona");
			String adresa = request.getParameter("adresaKorisnika");
			String korIme = request.getParameter("korImeKorisnika");
			String lozinka = request.getParameter("lozinkaKorisnika");
			Nalog nalog = KorisnikDAO.getUserById(jmbg).getNalog();
			Korisnik kor = new Korisnik(jmbg, ime,prezime,email,brTelefona,adresa,nalog);
			if(korisnikBean.editUser(jmbg, kor) && nalogBean.EditAccount(nalog.getId(), new Nalog(korIme, lozinka))) {
				address = "/WEB-INF/pages/users.jsp";
			}
		}else if(action.startsWith("obrisiKorisnika")) {
			KorisnikBean korisnikBean = (KorisnikBean) session.getAttribute("korisnikBean");
			String stringId = action.split("-")[1];
			System.out.println(action);
			if(korisnikBean.deleteUser(stringId)) {
				
				address = "/WEB-INF/pages/users.jsp";
			}else {
				System.out.println("niej prosloooooooooooooooooo");
			}
		}else if(action.startsWith("obrisiKategoriju")) {
			KategorijaBean katBean = (KategorijaBean) session.getAttribute("kategorijaBean");
			String stringId = action.split("-")[1];
			if(katBean.deleteCategory(Integer.parseInt(stringId))){
				address = "/WEB-INF/pages/start.jsp";
			}
		}
 
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
