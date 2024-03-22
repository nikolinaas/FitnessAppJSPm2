package org.unibl.etf.ip.dto;

import java.io.Serializable;

public class Administrator implements Serializable{

	public String name;
	public String surname;
	public String Email;
	public String PhoneNumber;
	public String username;
	public String password;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrator() {
		super();
	}
	
	public Administrator(String n, String s, String e, String p, String usern, String pass) {
		this.name = n;
		this.surname = s;
		this.Email = e;
		this.PhoneNumber = p;
		this.username = usern;
		this.password = pass;
		
	}
}
