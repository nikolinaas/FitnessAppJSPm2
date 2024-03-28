package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.Administrator;
import org.unibl.etf.ip.dto.Kategorija;
import org.unibl.etf.ip.dto.Korisnik;



public class KategorijaDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_CATEGORY_BY_ID = "SELECT * FROM kategorija WHERE idkategorija = ?";
	private static final String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM kategorija";
	private static final String SQL_INSERT_IN_CATEGORY = "INSERT INTO kategorija (naziv_kategorija, opis_kategorije) VALUES (?,?)";
	private static final String SQL_UPDATE_CATEGORY = "UPDATE kategorija SET naziv_kategorija = ?, opis_kategorije = ? WHERE (idkategorija = ?)";
	private static final String SQL_DELETE_CATEGORY = "DELETE FROM kategorija WHERE (idkategorija = ?)";

	public static ArrayList<Kategorija> getAll() {
		ArrayList<Kategorija> res = new ArrayList<Kategorija>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();

			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL_CATEGORIES, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				res.add(new Kategorija(rs.getInt("idkategorija"),rs.getString("naziv_kategorija"), rs.getString("opis_kategorije")));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
	}

	public static boolean addCategory(Kategorija kat) {

		boolean result = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		Object values[] = { kat.getNazivKategorije(), kat.getOpisKategorije() };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT_IN_CATEGORY, true, values);
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if (pstmt.getUpdateCount() > 0) {
				result = true;
			}
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;

	}
	
	public static Kategorija getCategoryByID(int id) {
		
		Kategorija res = null;
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {id};
		try {
			connection = connectionPool.checkOut();

			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_CATEGORY_BY_ID, false, values);
			rs = pstmt.executeQuery();
			if (rs.next()){
				
			res = new Kategorija(rs.getInt("idkategorija"),rs.getString("naziv_kategorija"), rs.getString("opis_kategorije")); 
			
			}

			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
		
	}
	
	public static boolean editCategory(int id, Kategorija kat) {
		
	boolean res = false;
	
	Connection connection = null;
	ResultSet generatedKeys = null;
	Object values[] = { id , kat.getNazivKategorije()};
	try {
		connection = connectionPool.checkOut();
		
		PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_UPDATE_CATEGORY, true);
		  pstmt.setInt(3, id);
          pstmt.setString(1, kat.getNazivKategorije());
          pstmt.setString(2, kat.getOpisKategorije());
		pstmt.executeUpdate();
		generatedKeys = pstmt.getGeneratedKeys();
		if (pstmt.getUpdateCount() > 0) {
			res = true;
		}
		
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		connectionPool.checkIn(connection);
	}
	
	return  res;
		
	}
	
	public static boolean deleteCategory(int id) {
		
		boolean res = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		
		try {
			connection = connectionPool.checkOut();
			
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_DELETE_CATEGORY, true);
			  pstmt.setInt(1, id);
	      
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if (pstmt.getUpdateCount() > 0) {
				res = true;
			}
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
		
	}
}
