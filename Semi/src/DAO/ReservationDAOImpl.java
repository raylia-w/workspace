package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.ReservationDTO;
import DTO.ShopDTO;
import Service.Paging;

public class ReservationDAOImpl implements ReservationDAO {
	private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "food";
	private final String password = "escape";
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public ReservationDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 음식점 정보 보기
	public ShopDTO s_list(String shop) {
//		ArrayList<ShopDTO> s_list = new ArrayList<ShopDTO>();
		ShopDTO s = new ShopDTO();
		
		try {			
			String sql = "SELECT s_id_no, s_name, s_addr, s_p_no, s_type, s_price, op_time, cl_time, s_holiday"
					+ " FROM shop WHERE s_name=? ORDER BY s_id_no";
			
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			pst.setString(1, shop);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				s.setS_id_no(rs.getInt("s_id_no"));
				s.setS_name(rs.getString("s_name"));
				s.setS_addr(rs.getString("s_addr"));
				s.setS_p_no(rs.getString("s_p_no"));
				s.setS_type(rs.getString("s_type"));
				s.setS_price(rs.getInt("s_price"));
				s.setOp_time(rs.getString("op_time"));
				s.setCl_time(rs.getString("cl_time"));
				s.setS_holiday(rs.getString("s_holiday"));
				
//				s_list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
				try {
					if(rs != null)	rs.close();
					if(pst != null)	pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
//		System.out.println(s_list);
		return s;
	}
	
	// 음식점 정보 보기
		public ShopDTO shopList(String shop) {
//			ArrayList<ShopDTO> s_list = new ArrayList<ShopDTO>();
			ShopDTO s = new ShopDTO();
			
			try {			
				String sql = "SELECT s_id_no, s_name, s_addr, s_p_no, s_type, s_price, op_time, cl_time,  s_holliday"
						+ " FROM shop WHERE s_id_no=? ORDER BY s_id_no";
				
				st = conn.createStatement();
				pst = conn.prepareStatement(sql);
				pst.setString(1, shop);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					
					s.setS_id_no(rs.getInt("s_id_no"));
					s.setS_name(rs.getString("s_name"));
					s.setS_addr(rs.getString("s_addr"));
					s.setS_p_no(rs.getString("s_p_no"));
					s.setS_type(rs.getString("s_type"));
					s.setS_price(rs.getInt("s_price"));
					s.setOp_time(rs.getString("op_time"));
					s.setCl_time(rs.getString("cl_time"));
					s.setS_holiday(rs.getString("s_holiday"));
					
//					s_list.add(s);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
					try {
						if(rs != null)	rs.close();
						if(pst != null)	pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
//			System.out.println(s_list);
			return s;
		}


	@Override
	public ReservationDTO resList(String res) {
//		ArrayList<ReservationDTO> resList = new ArrayList<ReservationDTO>();
		ReservationDTO r = new ReservationDTO();
		
		try {			
			String sql = "SELECT res_id, u_id, s_id_no, res_time, res_person, res_date"
					+ " FROM shop ORDER BY res_id";
			
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
//			pst.setString(1, res.getU_id());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				r.setRes_id(rs.getString("res_id"));
				r.setU_id(rs.getString("u_id"));
				r.setS_id_no(rs.getString("s_id_no"));
				r.setRes_time(rs.getString("res_time"));
				r.setRes_person(rs.getString("res_person"));
				r.setRes_date(rs.getString("res_date"));
				
//				resList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(pst!=null)	pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	public void insertRes(ReservationDTO res) {
		
		String sql = "INSERT INTO RESERVATION(res_id, u_id, s_id_no, res_time, res_person, res_date)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, res.getRes_id());
			pst.setString(2, res.getU_id());
			pst.setInt(3, Integer.parseInt(res.getS_id_no()));
			pst.setString(4, res.getRes_time());
			pst.setInt(5, Integer.parseInt(res.getRes_person()));
			pst.setString(6, res.getRes_date());
			pst.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 총 게시물 수 반환
	@Override
	public int getTotal() {
		String sql="SELECT COUNT(*) FROM reservation";

		int total = 0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			rs.next();
			
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	// 페이징 처리하여 게시물 리스트 가져오기
	@Override
	public List getList(Paging paging, String id) {
		List<ReservationDTO> resList = new ArrayList<>();
		
		String sql =
				"SELECT * FROM ("
				+ " SELECT rownum rnum, b.* FROM ("
				+ " 	SELECT res_id, u_id, s_id_no, res_time, res_person, res_date"
				+ "			, (SELECT s_name FROM shop SS WHERE SS.s_id_no = RR.s_id_no) s_name"
				+ " 	FROM reservation RR"
				+ "		WHERE u_id=?"
				+ " 	ORDER BY res_id DESC"
				+ " ) b"
				+ " ORDER BY rnum"
				+ ") WHERE rnum BETWEEN ? AND ?";
					
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, id);
			pst.setInt(2, paging.getStartNo());
			pst.setInt(3, paging.getEndNo());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ReservationDTO res = new ReservationDTO();
				res.setRes_id(rs.getString("res_id"));
				res.setU_id(rs.getString("u_id"));
				res.setS_id_no(rs.getString("s_id_no"));
				res.setRes_time(rs.getString("res_time"));
				res.setRes_person(rs.getString("res_person"));
				res.setS_name(rs.getString("s_name"));
				res.setRes_date(rs.getString("res_date"));
				
				resList.add(res);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(pst!=null)	pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resList;			
	}

	@Override
	public void deleteRes(String res_id) {
		String sql = "DELETE FROM reservation WHERE res_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, res_id);
			pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(pst!=null)	pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
