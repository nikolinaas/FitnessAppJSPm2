package org.unibl.etf.ip.beans;

import java.util.ArrayList;

import org.unibl.etf.ip.dao.LogoviDAO;
import org.unibl.etf.ip.dto.Logovi;

public class LogoviBean {

	public LogoviBean() {
		
	}
	
	public ArrayList<Logovi> getAllLogs(){
		return LogoviDAO.getAll();
	}
}
