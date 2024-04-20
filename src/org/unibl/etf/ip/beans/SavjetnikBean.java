package org.unibl.etf.ip.beans;

import java.util.ArrayList;

import org.unibl.etf.ip.dao.KorisnikDAO;
import org.unibl.etf.ip.dao.NalogDAO;
import org.unibl.etf.ip.dao.SavjetnikDAO;
import org.unibl.etf.ip.dto.Korisnik;
import org.unibl.etf.ip.dto.Nalog;
import org.unibl.etf.ip.dto.Savjetnik;

public class SavjetnikBean {

	
	public SavjetnikBean() {
		
	}
	
	public ArrayList<Savjetnik> getAllAdvisors(){
		return SavjetnikDAO.getAllAdvisors();
	}
	
	public boolean createUser(String ime, String prezime, String email, String brtelefona, String adresa,
			String korIme, String lozinka) {

		if(isUserNameUnique(korIme)) {
			System.out.println("jedinstvenooooooooooo");
			return KorisnikDAO.createUser(new Korisnik(ime, prezime, email, brtelefona, adresa), korIme, lozinka);
		}else {
			return false;
		}
	

	}
	
	public Savjetnik getAdvisorById(Integer id) {
		return SavjetnikDAO.getUserById(id);
	}
	
	public boolean editAdvisor(Integer id, Savjetnik savjetnik) {
		return SavjetnikDAO.updateUser(id, savjetnik);
	}
	
	public boolean deleteAdvisor(Integer id) {
		return SavjetnikDAO.deleteUser(id);
	}
	
	private boolean isUserNameUnique(String username) {
		for(Nalog nalog : NalogDAO.getAll()) {
			if(nalog.getKorisnickoIme().equals(username)) {
				return false;
			}
		}
		return true;
	}
}
