package org.unibl.etf.ip.beans;

import java.util.ArrayList;

import org.unibl.etf.ip.dao.KorisnikDAO;
import org.unibl.etf.ip.dto.Korisnik;

public class KorisnikBean {

	private Korisnik korisnik = new Korisnik();

	public KorisnikBean() {

	}

	public ArrayList<Korisnik> getAllUsers() {

		return KorisnikDAO.getAll();
	}

	public boolean createUser(String jmbg, String ime, String prezime, String email, String brtelefona, String adresa,
			String korIme, String lozinka) {

		return KorisnikDAO.createUser(new Korisnik(jmbg, ime, prezime, email, brtelefona, adresa), korIme, lozinka);

	}

	public Korisnik getUserById(String jmbg) {

		return KorisnikDAO.getUserById(jmbg);

	}
	
	public boolean editUser(String jmbg, Korisnik kor) {
		return KorisnikDAO.updateUser(jmbg, kor);
	}
	
	public boolean deleteUser(String id) {
		return KorisnikDAO.deleteUser(id);
	}

}
