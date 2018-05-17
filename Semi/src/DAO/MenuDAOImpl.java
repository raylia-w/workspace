package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.MenuDTO;

public class MenuDAOImpl implements MenuDAO{
	private final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "food";
	private final String password = "escape";
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public MenuDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MenuDTO> menuList(int s_id_no) {
		
		ArrayList<MenuDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM food WHERE s_id_no=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_id_no);
			rs = pst.executeQuery();
			while(rs.next()) {
				MenuDTO menu = new MenuDTO();
				menu.setF_name(rs.getString("f_name"));
				menu.setF_price(rs.getInt("f_price"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
