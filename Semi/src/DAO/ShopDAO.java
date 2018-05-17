package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.ShopDTO;

public class ShopDAO {

//  private final String driver="oracle.jdbc.driver.OraleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "food";
	private final String password = "escape";

	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;	

	public ShopDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
								
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}		
	
	public boolean isNew(ShopDTO s) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "SELECT count(*) FROM SHOP WHERE id=?";
		String id = s.getS_name();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			rs.next();
			
			int res = rs.getInt(1);
			if(res>0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addShop(ShopDTO s) {
		PreparedStatement pst = null;		
		String sql = "INSERT INTO SHOP (s_id_no, s_name, s_addr, s_p_no, s_type, s_price, op_time, cl_time, res_poss, s_holiday)"
					+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setString(2, s.getS_name());
			pst.setString(3, s.getS_addr());
			pst.setString(4, s.getS_p_no());
			pst.setString(5, s.getS_type());
			pst.setInt(6, s.getS_price());
			pst.setString(7, s.getOp_time());
			pst.setString(8, s.getCl_time());
			pst.setString(9, s.getRes_poss());
			pst.setString(10, s.getS_holiday());
			
			pst.executeUpdate();			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ShopDTO deleteShop(int s) {
		ShopDTO dto = new ShopDTO();
		PreparedStatement pst = null;
		String sql = "DELETE FROM SHOP WHERE s_id_no=?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s);
			pst.executeUpdate();
			conn.commit();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null) pst.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public ShopDTO selectShop(int s_id_no) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ShopDTO dto = new ShopDTO();
//		ArrayList<Shop> list = new ArrayList<>();

		String sql = "SELECT*FROM SHOP WHERE s_id_no = ?";
	
		try {
						
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_id_no);
			rs = pst.executeQuery();
			
			if ( rs.next() ) {				
				dto.setS_id_no(rs.getInt("s_id_no"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_addr(rs.getString("s_addr"));
				dto.setS_p_no(rs.getString("s_p_no"));
				dto.setS_type(rs.getString("s_type"));
				dto.setS_price(rs.getInt("s_price"));
				dto.setOp_time(rs.getString("op_time"));
				dto.setCl_time(rs.getString("cl_time"));
				dto.setRes_poss(rs.getString("res_poss"));
							
//				list.add(dto);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		return list;
		return dto;
	}
	
	public ArrayList<ShopDTO> selectShopList(String type) {
		ArrayList<ShopDTO> sl = new ArrayList<>();
		String sql ="SELECT s_name, s_addr, s_id_no, s_p_no FROM shop WHERE s_type=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, type);
			rs = pst.executeQuery();
			while(rs.next()) {
				ShopDTO s = new ShopDTO();
				s.setS_name(rs.getString("s_name"));
				s.setS_addr(rs.getString("s_addr"));
				s.setS_id_no(rs.getInt("s_id_no"));
				s.setS_p_no(rs.getString("s_p_no"));
				sl.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sl;
	}
	
	public ShopDTO updateShop(int s) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ShopDTO dto = new ShopDTO();
//		ArrayList<Shop> list = new ArrayList<>();

		String sql = "SELECT*FROM SHOP WHERE s_id_no = ?";
				
		try {
						
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s);
			rs = pst.executeQuery();
			
			if ( rs.next() ) {				
				dto.setS_id_no(rs.getInt("s_id_no"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_addr(rs.getString("s_addr"));
				dto.setS_p_no(rs.getString("s_p_no"));
				dto.setS_type(rs.getString("s_type"));
				dto.setS_price(rs.getInt("s_price"));
				dto.setOp_time(rs.getString("op_time"));
				dto.setCl_time(rs.getString("cl_time"));
//				dto.setS_score(rs.getString("s_score"));
				dto.setRes_poss(rs.getString("res_poss"));
				dto.setS_holiday(rs.getString("s_holiday"));
//				list.add(dto);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		return list;
		return dto;
	}
	
	public void updateShopExe(ShopDTO s) {
		PreparedStatement pst = null;		
		String sql = "UPDATE SHOP SET s_name=?" 
				+ ", s_addr=?" 
				+ ", s_p_no=?" 
				+ ", s_type=?" 
				+ ", s_price=?" 
				+ ", op_time=?" 
				+ ", cl_time=?" 
				+ ", res_poss=?"
				+ "WHERE s_id_no=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, s.getS_name());
			pst.setString(2, s.getS_addr());
			pst.setString(3, s.getS_p_no());
			pst.setString(4, s.getS_type());
			pst.setInt(5, s.getS_price());
			pst.setString(6, s.getOp_time());
			pst.setString(7, s.getCl_time());
			pst.setString(8, s.getRes_poss());
			pst.setInt(9, s.getS_id_no());
						
			pst.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null) pst.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	
	
}