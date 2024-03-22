package org.unibl.etf.ip.beans;

import org.unibl.etf.ip.dao.NalogDAO;
import org.unibl.etf.ip.dto.Nalog;

public class NalogBean {

	Nalog nalog = new Nalog();

	public NalogBean() {

	}

	public Nalog createAccount(Nalog n) {

		return NalogDAO.createAcc(n);
	}
	
	public  boolean EditAccount(int id,Nalog nalog) {
		
		return NalogDAO.editAccount(id, nalog);
	}
}
