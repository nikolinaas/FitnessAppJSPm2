package org.unibl.etf.ip.dto;

public class Logovi {

	private int id;
	private String info;
	private String datum;
	
	
	public Logovi() {
		
	}
	
	public Logovi(int id, String info, String datum) {
		super();
		this.id = id;
		this.info = info;
		this.datum = datum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	
	
	
}
