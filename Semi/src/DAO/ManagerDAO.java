package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.Manager;

public class ManagerDAO {
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "food";
	private final String password = "escape";
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public ManagerDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean isManager(Manager dto) {
		String id = dto.getID();
		String pw = dto.getPassword();
		String sql = "SELECT*FROM MANAGER WHERE id = ? AND pw = ?";
		
		System.out.println(id);
		System.out.println(pw);
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			
			if ( rs.next() ) {
				return true;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
			
	}
	
	

}
