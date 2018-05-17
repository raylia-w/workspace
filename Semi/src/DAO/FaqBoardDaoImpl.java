package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.PostDTO;
import Service.Paging;

public class FaqBoardDaoImpl implements BoardDao {

	// DB 정보
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "food";
	private String password = "escape";

	private Connection conn = null;

	public FaqBoardDaoImpl() {
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

		String sql="SELECT COUNT(*) FROM POST";

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

		List<PostDTO> list = new ArrayList<>();
		
		String sql =
				"SELECT * FROM ("
				+ " SELECT rownum rnum, b.* FROM ("
				+ " 	SELECT p_no, u_no, p_name, p_main, p_date, p_score"
				+ " 	FROM POST"
				+ "		WHERE p_no>=5000"
				+ " 	ORDER BY p_no DESC"
				+ " ) b"
				+ " ORDER BY rnum"
				+ ") WHERE rnum BETWEEN ? AND ?";
					
		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, paging.getStartNo());
			pst.setInt(2, paging.getEndNo());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				PostDTO board = new PostDTO();
				
				board.setP_no( rs.getInt("p_no") );
				board.setU_no( rs.getInt("u_no") );
				board.setP_name( rs.getString("p_name") );
				board.setP_main( rs.getString("p_main") );
				board.setP_date( String.valueOf(rs.getDate("p_date")) );
				board.setP_score( rs.getInt("p_score") );
								
				list.add(board);
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
