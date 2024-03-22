package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.Administrator;


public class AdministratorDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL_ACCOUNTS = "SELECT * FROM administrator JOIN nalog on nalog_idnalog=idnalog";
	
	
	public static ArrayList<Administrator> getAll(){
		
		ArrayList<Administrator> res = new ArrayList<>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		
		try {
			connection = connectionPool.checkOut();
			
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL_ACCOUNTS, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				res.add(new Administrator(rs.getString("ime"), rs.getString("prezime"), rs.getString("email"),rs.getString("broj_telefona"), rs.getString("korisnicko_ime"), rs.getString("lozinka")));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
	}
	
	public static boolean AreCredentialsValid(String usern, String pass) {
		System.out.println("=========== " );
		for(Administrator a : getAll()){
			System.out.println("=========== " + a.name);
			if(a.username.equals(usern) && a.password.equals(pass)) {
				return true;
			}
			
		}
		
		return false;
	}
}
