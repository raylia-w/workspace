package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PaymentDTO;

public class PaymentDAOImpl implements PaymentDAO{
	private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "food";
	private final String password = "escape";

	private Connection conn = null; // connection : DB연결권한
	private PreparedStatement pst = null;
	private Statement st = null; // Statement : CRUD SQL 연결
	private ResultSet rs = null; // ResultSet : 데이터 담을 객체

	public PaymentDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PaymentDTO> selectPayment(String u_name, String u_pno) {
		ArrayList<PaymentDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM payment WHERE buyer_name=? AND buyer_tel=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, u_name);
			pst.setString(2, u_pno);
			rs = pst.executeQuery();
			while(rs.next()) {
				PaymentDTO p = new PaymentDTO();
				p.setImp_uid(rs.getString(1));
				p.setMerchant_uid(rs.getString(2));
				p.setAmount(rs.getBigDecimal(3));
				p.setPay_amount(rs.getInt(4));
				p.setPay_method(rs.getString(5));
				p.setPg(rs.getString(6));
				p.setApply_num(rs.getString(7));
				p.setBuyer_name(rs.getString(8));
				p.setBuy_tel(rs.getString(9));
				p.setPaid_at(rs.getDate(10));
				p.setStatus(rs.getString(11));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(st!=null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void updatePayment(String uid) {
		String sql = "UPDATE payment SET status=? WHERE imp_uid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "환불요청");
			pst.setString(2, uid);
			pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void insertPayment(PaymentDTO p) {
		System.out.println("insert query");
		String sql = "INSERT INTO payment (imp_uid, merchant_uid, amount, pay_method, pg, apply_num, buyer_name, buyer_tel, paid_at, status, res_id, s_name) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, p.getImp_uid());
			pst.setString(2, p.getMerchant_uid());
			pst.setBigDecimal(3, p.getAmount());
			pst.setString(4, p.getPay_method());
			pst.setString(5, p.getPg());
			pst.setString(6, p.getApply_num());
			pst.setString(7, p.getBuyer_name());
			pst.setString(8, p.getBuy_tel());
			pst.setDate(9, p.getPaid_at());
			pst.setString(10, "결제완료");
			pst.setString(11, p.getRes_id());
			pst.setString(12, p.getS_name());
			pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refundReqPayment(String uid) {
		String sql = "UPDATE payment SET status=? WHERE imp_uid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "환불요청");
			pst.setString(2, uid);
			pst.executeQuery();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refundPayment(String uid) {
		String sql = "DELETE FROM payment WHERE imp_uid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, uid);
			pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
