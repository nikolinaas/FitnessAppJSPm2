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

	public boolean createUser(String ime, String prezime, String email, String brtelefona, String adresa,
			String korIme, String lozinka) {

		return KorisnikDAO.createUser(new Korisnik(ime, prezime, email, brtelefona, adresa), korIme, lozinka);

	}

	public Korisnik getUserById(Integer id) {

		return KorisnikDAO.getUserById(id);

	}
	
	public boolean editUser(Integer id, Korisnik kor) {
		return KorisnikDAO.updateUser(id, kor);
	}
	
	public boolean deleteUser(Integer id) {
		return KorisnikDAO.deleteUser(id);
	}

}
