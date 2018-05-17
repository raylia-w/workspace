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
import Service.Paging;

public class ShopBoardDaoImpl implements BoardDao {

	// DB 정보
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "food";
	private String password = "escape";

	private Connection conn = null;

	public ShopBoardDaoImpl() {
		try {
			// Oracle jdbc Driver 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection 객체 생성
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// 총 게시물 수 반환
	@Override
	public int getTotal() {
		Statement st = null;
		ResultSet rs = null;

		String sql="SELECT COUNT(*) FROM SHOP";

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
	public List getList(Paging paging) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<ShopDTO> list = new ArrayList<>();
		
		String sql =
				"SELECT * FROM ("
				+ " SELECT rownum rnum, b.* FROM ("
				+ " 	SELECT  s_id_no" 
				+ "    , s_name" 
				+ "    , s_addr" 
				+ "    , s_p_no" 
				+ "    , s_type" 
				+ "    , s_price" 
				+ "    , op_time" 
				+ "    , cl_time" 
				+ "    , res_poss"
				+ "    , s_holiday" 
				+ " 	FROM SHOP"
				+ " 	ORDER BY s_id_no DESC"
				+ " ) b"
				+ " ORDER BY rnum"
				+ ") WHERE rnum BETWEEN ? AND ?";
					
		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, paging.getStartNo());
			pst.setInt(2, paging.getEndNo());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ShopDTO dto = new ShopDTO();
				
				dto.setS_id_no(rs.getInt("s_id_no"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_addr(rs.getString("s_addr"));
				dto.setS_p_no(rs.getString("s_p_no"));
				dto.setS_type(rs.getString("s_type"));
				dto.setS_price(rs.getInt("s_price"));
				dto.setOp_time(rs.getString("op_time"));
				dto.setCl_time(rs.getString("cl_time"));
				dto.setRes_poss(rs.getString("res_poss"));
				dto.setS_holiday(rs.getString("s_holiday"));
				
				list.add(dto);
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

		return list;			
	}


	@Override
	public int getTotal(String s) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getTotal(int uno) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List getList(Paging paging, String s) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List getList(Paging paging, int uno) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
