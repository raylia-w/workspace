package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.PaymentDTO;
import Service.Paging;

public class MyPayBoardDaoImpl implements BoardDao{
	// DB 정보
		private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		private String username = "food";
		private String password = "escape";

		private Connection conn = null;

		public MyPayBoardDaoImpl() {
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
	public int getTotal(String name) {
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;

		String sql="SELECT COUNT(*) FROM payment WHERE buyer_name=?";

		int total = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			
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

	@Override
	public List getList(Paging paging, String s) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<PaymentDTO> list = new ArrayList<>();
		
		String sql =
				"SELECT * FROM ("
				+ " SELECT rownum rnum, b.* FROM ("
				+ " 	SELECT  imp_uid" 
				+ "    , merchant_uid" 
				+ "    , amount" 
				+ "    , pg" 
				+ "    , buyer_name" 
				+ "    , buyer_tel" 
				+ "    , paid_at" 
				+ "    , status"  
				+ "    , pay_method"
				+ "    , s_name"	
				+ "    , res_id"
				+ " 	FROM payment"
				+ "		WHERE buyer_name=?"	
				+ " 	ORDER BY paid_at DESC"
				+ " ) b"
				+ " ORDER BY rnum"
				+ ") WHERE rnum BETWEEN ? AND ?";
					
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, s);
			pst.setInt(2, paging.getStartNo());
			pst.setInt(3, paging.getEndNo());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				PaymentDTO dto = new PaymentDTO();
				
				dto.setImp_uid(rs.getString("imp_uid"));
				dto.setMerchant_uid(rs.getString("merchant_uid"));
				dto.setAmount(rs.getBigDecimal("amount"));
				dto.setBuyer_name(rs.getString("buyer_name"));
				dto.setBuy_tel(rs.getString("buyer_tel"));
				dto.setPaid_at(rs.getDate("paid_at"));
				dto.setStatus(rs.getString("status"));
				dto.setPay_method(rs.getString("pay_method"));
				dto.setRes_id(rs.getString("res_id"));
				dto.setS_name(rs.getString("s_name"));
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
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTotal(int uno) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List getList(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List getList(Paging paging, int uno) {
		// TODO Auto-generated method stub
		return null;
	}

}
