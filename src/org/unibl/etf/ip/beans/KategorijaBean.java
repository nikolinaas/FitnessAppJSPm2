package org.unibl.etf.ip.beans;

import java.util.ArrayList;

import org.unibl.etf.ip.dao.KategorijaDAO;
import org.unibl.etf.ip.dto.Kategorija;

public class KategorijaBean {

	private Kategorija kategorija = new Kategorija();

	public KategorijaBean() {

	}

	public ArrayList<Kategorija> GetAllCategories() {

		ArrayList<Kategorija> kategorije = new ArrayList<Kategorija>();

		for (Kategorija kat : KategorijaDAO.getAll()) {
			kategorije.add(kat);
		}
		return kategorije;
	}
	
	public boolean addCategory(String name, String descript) {
		
		return KategorijaDAO.addCategory(new Kategorija(name,descript));
		
	}
	
	public Kategorija getCategoryByID(int id) {
		return KategorijaDAO.getCategoryByID(id);
	}
	
	public boolean updateCategory(int id, Kategorija kat) {
		return KategorijaDAO.editCategory(id, kat);
	}
	
	public boolean deleteCategory(int id) {
		return KategorijaDAO.deleteCategory(id);
	}
}
