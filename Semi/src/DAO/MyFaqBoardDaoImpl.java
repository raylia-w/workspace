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
import DTO.PostDTO;
import Service.Paging;

public class MyFaqBoardDaoImpl implements BoardDao{
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "food";
	private String password = "escape";

	private Connection conn = null;

	public MyFaqBoardDaoImpl() {
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
	return 0;
}

public int getTotal(int uno) {
	PreparedStatement pst = null;
	Statement st = null;
	ResultSet rs = null;
	String sql="SELECT COUNT(*) FROM post WHERE u_no=? AND p_no>=5000";

	int total = 0;
	try {
		pst = conn.prepareStatement(sql);
		pst.setInt(1, uno);
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
public List getList(Paging paging, int uno) {
	PreparedStatement pst = null;
	ResultSet rs = null;

	List<PostDTO> list = new ArrayList<>();
	
	String sql =
			"SELECT * FROM ("
			+ " SELECT rownum rnum, b.* FROM ("
			+ " 	SELECT  p_no" 
			+ "    , u_no" 
			+ "    , p_name" 
			+ "    , p_main" 
			+ "    , p_date" 
			+ " 	FROM post"
			+ "		WHERE u_no =? AND p_no>=5000"	
			+ " 	ORDER BY p_date DESC"
			+ " ) b"
			+ " ORDER BY rnum"
			+ ") WHERE rnum BETWEEN ? AND ?";
				
	try {
		pst = conn.prepareStatement(sql);

		pst.setInt(1, uno);
		pst.setInt(2, paging.getStartNo());
		pst.setInt(3, paging.getEndNo());
		
		rs = pst.executeQuery();
		
		while(rs.next()) {
			PostDTO dto = new PostDTO();
			
			dto.setP_no(rs.getInt("p_no"));
			dto.setU_no(rs.getInt("u_no"));
			dto.setP_name(rs.getString("p_name"));
			dto.setP_main(rs.getString("p_main"));
			dto.setP_date(rs.getString("p_date"));
			
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
public List getList(Paging paging, String s) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List getList(Paging paging) {
	// TODO Auto-generated method stub
	return null;
}

}
