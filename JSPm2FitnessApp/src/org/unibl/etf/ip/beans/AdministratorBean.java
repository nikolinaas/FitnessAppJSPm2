package org.unibl.etf.ip.beans;

import java.io.Serializable;

import org.unibl.etf.ip.dao.AdministratorDAO;
import org.unibl.etf.ip.dto.Administrator;

public class AdministratorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Administrator admin = new Administrator();
	private boolean isLoggedIn = false;
	
	public AdministratorBean() {
		
	}
	public boolean LogIn(String username, String pass) {
		
		if(AdministratorDAO.AreCredentialsValid(username, pass))
		{
			isLoggedIn=true;
			return true;
		}
	
		return false;
	}
}
