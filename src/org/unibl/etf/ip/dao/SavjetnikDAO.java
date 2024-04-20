package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.ip.beans.NalogBean;
import org.unibl.etf.ip.dto.Korisnik;
import org.unibl.etf.ip.dto.Nalog;
import org.unibl.etf.ip.dto.Savjetnik;

public class SavjetnikDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL_ACCOUNTS = "SELECT * FROM savjetnik JOIN nalog on nalog_idnalog=idnalog";
	private static final String SQL_INSERT_IN_USER = "INSERT INTO savjetnik (ime, prezime, email, br_telefona, adresa, nalog_idnalog) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE_USER = "UPDATE savjetnik SET ime = ?, prezime = ?, email = ?, br_telefona = ?, adresa = ? WHERE (id = ?)";
	private static final String SQL_DELETE_USER = "DELETE FROM savjetnik WHERE (id = ?)";
	private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM savjetnik WHERE id = ?";
	public static ArrayList<Savjetnik> getAllAdvisors(){
		ArrayList<Savjetnik> res = new ArrayList<>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		
		try {
			connection = connectionPool.checkOut();
			
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL_ACCOUNTS, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				res.add(new Savjetnik(rs.getInt("id"), rs.getString("ime"),rs.getString("prezime"), rs.getString("br_telefona"),rs.getString("adresa"), rs.getString("email"), NalogDAO.getAccountById(rs.getInt("nalog_idnalog"))));
				
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
		
		
	}
	
	
	public static boolean createUser(Savjetnik korisnik, String userName, String loz) {
		boolean res = false;
		NalogBean nalogBean = new NalogBean();
		Nalog n = nalogBean.createAccount(new Nalog(userName,loz));
		Connection connection = null;
		ResultSet generatedKeys = null;
		Object values[] = { korisnik.getIme(), korisnik.getPrezime(), korisnik.getEmail(), korisnik.getBrtelefona(),korisnik.getAdresa(),n.getId()};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT_IN_USER , true, values);
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
	
	public static Savjetnik getUserById(Integer id) {
		
		Savjetnik res = null;
		
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {id};
		try {
			connection = connectionPool.checkOut();

			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_USER_BY_ID, false, values);
			rs = pstmt.executeQuery();
			if (rs.next()){
				
			res = new Savjetnik(rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("br_telefona"), rs.getString("adresa"), NalogDAO.getAccountById(rs.getInt("nalog_idnalog"))); 
			
			}

			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;

	}
	
	public static boolean updateUser(Integer id, Savjetnik kor) {
		
		boolean res = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		
		try {
			connection = connectionPool.checkOut();
			
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_UPDATE_USER, true);
			  pstmt.setInt(6, id);
	          pstmt.setString(1, kor.getIme());
	          pstmt.setString(2, kor.getPrezime());
	          pstmt.setString(3, kor.getEmail());
	          pstmt.setString(4, kor.getBrtelefona());
	          pstmt.setString(5, kor.getAdresa());
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
	
	public static boolean deleteUser(Integer id) {
		
		boolean res = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		
		try {
		connection = connectionPool.checkOut();
		Nalog kor = KorisnikDAO.getUserById(id).getNalog();
		System.out.println("-----------------" + kor.getId());
		
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_DELETE_USER, true);
			
			  pstmt.setInt(1, id);
	      
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if (pstmt.getUpdateCount() > 0) {
				res = true;
			}
			
			pstmt.close();
		if(res) {
			NalogDAO.deleteAccount(kor.getId());
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
	}
	
}
