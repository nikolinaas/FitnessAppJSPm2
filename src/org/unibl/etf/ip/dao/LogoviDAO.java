package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.Korisnik;
import org.unibl.etf.ip.dto.Logovi;

public class LogoviDAO {


	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL_LOGS = "SELECT * FROM logovi";
	
	
	public static ArrayList<Logovi> getAll(){
		
		ArrayList<Logovi> res = new ArrayList<Logovi>();
		
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();

			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL_LOGS, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				res.add(new Logovi(rs.getInt("id"),rs.getString("info"), rs.getString("datum")));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return res;
		
	}
	
}
