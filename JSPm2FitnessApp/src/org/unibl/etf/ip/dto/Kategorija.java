package org.unibl.etf.ip.dto;

public class Kategorija {

	public int id;
	public String nazivKategorije;
	public String opisKategorije;
	
	public Kategorija() {
		
	}
	
	public Kategorija(int id, String nazivKategorije, String opisKategorije) {
		super();
		this.id = id;
		this.nazivKategorije = nazivKategorije;
		this.opisKategorije = opisKategorije;
	}

	public Kategorija(String nazivKategorije, String opisKategorije) {
		super();
		this.nazivKategorije = nazivKategorije;
		this.opisKategorije = opisKategorije;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}
	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}
	public String getOpisKategorije() {
		return opisKategorije;
	}
	public void setOpisKategorije(String opisKategorije) {
		this.opisKategorije = opisKategorije;
	}
}
