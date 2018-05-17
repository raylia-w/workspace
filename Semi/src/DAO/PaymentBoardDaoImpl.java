package DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.PaymentDTO;
import Service.Paging;

public class PaymentBoardDaoImpl implements BoardDao {

	// DB 정보
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "food";
	private String password = "escape";

	private Connection conn = null;

	public PaymentBoardDaoImpl() {
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

		String sql="SELECT COUNT(*) FROM payment";

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

		List<PaymentDTO> list = new ArrayList<>();
		
		String sql =
				"SELECT * FROM ("
				+ " SELECT rownum rnum, b.* FROM ("
				+ "		SELECT  imp_UID" 
				+ "    , 		merchant_uid" 
				+ "    , 		amount" 
				+ "    , 		pay_amount" 
				+ "    , 		pay_method" 
				+ "    , 		pg" 
				+ "    , 		apply_num" 
				+ "    , 		buyer_name" 
				+ "    , 		buyer_tel" 
				+ "    , 		paid_at"
				+ "    , 		status"
				+ "    , 		s_name"
				+ "    , 		res_id"
				+ " 	FROM payment"
				+ " 	ORDER BY imp_UID DESC"
				+ " ) b"
				+ " ORDER BY rnum"
				+ ") WHERE rnum BETWEEN ? AND ?";
					
		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, paging.getStartNo());
			pst.setInt(2, paging.getEndNo());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				PaymentDTO dto = new PaymentDTO();
				
				System.out.println("UID: " + rs.getString("imp_UID"));
				System.out.println("merchant: " + rs.getString("merchant_uid"));
				
				
				dto.setImp_uid( rs.getString("imp_UID") );
				dto.setMerchant_uid( rs.getString("merchant_uid") );
				dto.setAmount( rs.getBigDecimal("amount") );
				dto.setPay_amount( rs.getInt("pay_amount") );
				dto.setPay_method( rs.getString("pay_method") );
				dto.setPg( rs.getString("pg") );
				dto.setApply_num( rs.getString("apply_num") );
				dto.setBuyer_name( rs.getString("buyer_name") );
				dto.setBuy_tel( rs.getString("buyer_tel") );
				dto.setPaid_at( rs.getDate("paid_at") );
				dto.setStatus(rs.getString("status"));
				dto.setS_name(rs.getString("s_name"));
				dto.setRes_id(rs.getString("res_id"));
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
