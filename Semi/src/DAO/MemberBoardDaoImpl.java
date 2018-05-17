package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.Member;
import Service.Paging;

public class MemberBoardDaoImpl implements BoardDao {

	// DB 정보
		private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		private String username = "food";
		private String password = "escape";
  
		private Connection conn = null;

		public MemberBoardDaoImpl() {
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

			String sql="SELECT COUNT(*) FROM USERS";

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

			List<Member> list = new ArrayList<>();
			
			String sql =
					"SELECT * FROM ("
					+ " SELECT rownum rnum, b.* FROM ("
					+ " 	SELECT u_no, u_name, u_id_no, u_addr, u_p_no, email, nick, gender, grade, id, pw"
					+ " 	FROM USERS"
					+ " 	ORDER BY u_no DESC"
					+ " ) b"
					+ " ORDER BY rnum"
					+ ") WHERE rnum BETWEEN ? AND ?";
						
			try {
				pst = conn.prepareStatement(sql);

				pst.setInt(1, paging.getStartNo());
				pst.setInt(2, paging.getEndNo());
				
				rs = pst.executeQuery();
				
				while(rs.next()) {
					Member board = new Member();
					
					System.out.println( rs.getInt("u_no") );
					
					board.setID( String.valueOf(rs.getInt("u_no")) );
					board.setuName( rs.getString("u_name") );
					board.setuId( rs.getString("u_id_no") );
					board.setuAddr( rs.getString("u_addr") );
					board.setuPNo( rs.getString("u_p_no") );
					board.setuEmail( rs.getString("email") );
					board.setuNick( rs.getString("nick") );
					board.setuGender( rs.getInt("gender") );
					board.setuGrade( rs.getInt("grade") );
					board.setuId( rs.getString("id") );
					board.setPassword( rs.getString("pw") ); 
					
					
					
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
