package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PageDTO;
import DTO.PostDTO;

public class PostDAO {
	
	private final static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String username = "food";
	private final static String password = "escape";

	private Connection conn = null; // connection : DB연결권한
	private PreparedStatement pst = null;
	private Statement st = null; // Statement : CRUD SQL 연결
	private ResultSet rs = null; // ResultSet : 데이터 담을 객체
	
	public PostDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	// 리뷰 작성
	public void write(String p_name, String p_main, int uNo) {
		
		// 여기가 문제 지금 DB구조에서 작성자를 어떻게 처리할 것인가?
		String sql = "INSERT INTO POST(p_no, u_no, p_name, p_main, p_date, p_score)" 
				+ " VALUES(SEQ_QUESTION_NO.nextval, ?, ?, ?, sysdate, 0)";
		try {
			pst = conn.prepareStatement(sql);
			
			//작성자 정보를 어디서 어떻게 얻어오는가?
			pst.setInt(1, uNo);
			pst.setString(2, p_name);
			pst.setString(3, p_main);

			int update = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if( pst != null ) pst.close();
				if( conn != null ) conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} // write END
	
	public void write(String p_name, String p_main, int uNo, int s_id_no) {

		// 여기가 문제 지금 DB구조에서 작성자를 어떻게 처리할 것인가?
		String sql = "INSERT INTO POST(p_no, u_no, s_id_no, p_name, p_main, p_date, p_score)" 
				+ " VALUES(SEQ_P_NO.nextval, ?, ?, ?, ?, sysdate, 0)";
		try {
			pst = conn.prepareStatement(sql);
			//작성자 정보를 어디서 어떻게 얻어오는가?
			pst.setInt(1, uNo);
			pst.setInt(2, s_id_no);
			pst.setString(3, p_name);
			pst.setString(4, p_main);

			int update = pst.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if( pst != null ) pst.close();
				if( conn != null ) conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} // write END
	// 상세리뷰 페이지용
public PostDTO postDetail( int pno ) {
		
		PostDTO data = new PostDTO();
		String sql = "SELECT p.p_no, u.id, p.p_name, p.p_main, to_char(p_date, 'YYYY/MM/DD') p_date, p.p_score"
				+ " FROM POST p, users u WHERE p_no=?";
			try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pno);
			rs = pst.executeQuery();
			
			if( rs.next() ) {
				int p_no = rs.getInt( "p_no" );
				String id = rs.getString("id");
				String p_name = rs.getString( "p_name" );
				String p_main = rs.getString( "p_main" );
				String p_date = rs.getString( "p_date" );
				
				data.setP_no(p_no);
				data.setId(id);
				data.setP_name(p_name);
				data.setP_main(p_main);
				data.setP_date(p_date);
			} // if END
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if( rs != null ) rs.close();
				if( pst != null ) pst.close();
//				if( conn != null ) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	} // postDetail END
	
	
	// POST 테이블의 row를 반환하는 메소드(페이지 전환을 위한 준비)
	public int totalPost() {
		
		int cnt = 0;
		// POST 테이블의 row를 카운트한다.
		String sql = "SELECT count(*) FROM POST";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(rs != null) rs.close();
				if(pst != null) pst.close();
//				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} // totalPost END
	

	// 리뷰 목록의 페이지 전환
	public PageDTO Postpage( int curPage ) {
		
		PageDTO pto = new PageDTO();
		int totalPost = totalPost();
		
		ArrayList<PostDTO> list = new ArrayList<PostDTO>();
						
		String sql = "SELECT p_no, u_no, p_name, p_main, to_char( p_date, 'YYYY/MM/DD') p_date, p_score FROM POST ORDER BY p_no desc";
		try {
			pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pst.executeQuery();
			
			int perPage = pto.getPerPage();
			int skip = ( curPage -1 ) * perPage;
			
				if( skip > 0 ) {
					rs.absolute(skip);
				}
			
				for(int i=0; i<perPage && rs.next(); i++) {
					int p_no = rs.getInt("p_no");
					int u_no = rs.getInt("u_no");
					String p_name = rs.getString("p_name");
					String p_main = rs.getString("p_main");
					String p_date = rs.getString("p_date");
					int p_score = rs.getInt("p_score");
					
					PostDTO data = new PostDTO();
					data.setP_no(p_no);
					data.setU_no(u_no);
					data.setP_name(p_name);
					data.setP_main(p_main);
					data.setP_date(p_date);
					data.setP_score(p_score);
					
					list.add(data);
				} // for END
				
					pto.setList(list);
					pto.setTotalPost(totalPost);
					pto.setCurPage(curPage);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(rs != null) rs.close();
				if(pst != null) pst.close();
//				if(conn != null) conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pto;
	} // Postpage END
	
	
	// 게시물 검색(게시물 제목, 게시물 번호 -> 기타 검색옵션은 추후에 추가 예정), (검색구분 없이 통합검색 형태로 이뤄지기 때문에 다른 종류의 sql문 필요)
	// ***** 음식점 이름, 음식 이름으로 검색 *****
	public ArrayList<PostDTO> search(String searchName, String searchValue) {
	
		ArrayList<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "SELECT p_no, u_no, p_name, p_main, to_char(p_date, 'YYYY/MM/DD') p_date, p_score FROM POST";
		try {
			if(searchName.equals("shopSearch")) {
				
				sql += " WHERE s_id_no = (SELECT s_id_no FROM SHOP WHERE s_name LIKE ?)";
				
			} else if(searchName.equals("foodSearch")){
				
				sql += " WHERE f_no = (SELECT f_no FROM food WHERE f_name LIKE ?)";
			}
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+searchValue+"%");
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int p_no = rs.getInt("p_no");
				int u_no = rs.getInt("u_no");
				String p_name = rs.getString("p_name");
				String p_main = rs.getString("p_main");
				String p_date = rs.getString("p_date");
				int p_score = rs.getInt("p_score");
				
				PostDTO pto = new PostDTO();
				pto.setP_no(p_no);
				pto.setU_no(u_no);
				pto.setP_name(p_name);
				pto.setP_main(p_main);
				pto.setP_date(p_date);
				pto.setP_score(p_score);
				list.add(pto);
			} // while END
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(pst != null)	pst.close();
//				if(conn != null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	// search END
	
	public ArrayList<PostDTO> mainSearch(String searchName, String searchValue) {
		
		ArrayList<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "SELECT p.p_no, p.u_no, u.id, p.p_name, p.p_main, to_char(p_date, 'YYYY/MM/DD') p_date, p.p_score FROM post p," + 
				" users u where p.u_no = u.u_no";
		try {
			if("shopSearch".equals(searchName)) {
				
				sql += " AND s_id_no = (SELECT s_id_no FROM SHOP WHERE s_name LIKE '%' || ? || '%' )";
				
			} else if("foodSearch".equals(searchName)){
				
				sql += " AND s_id_no = ANY (SELECT s_id_no FROM food WHERE f_name LIKE '%' || ? || '%' )";
			}
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, searchValue);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int p_no = rs.getInt("p_no");
				int u_no = rs.getInt("u_no");
				String id = rs.getString("id");
				String p_name = rs.getString("p_name");
				String p_main = rs.getString("p_main");
				String p_date = rs.getString("p_date");
				int p_score = rs.getInt("p_score");
				
				PostDTO pto = new PostDTO();
				pto.setP_no(p_no);
				pto.setU_no(u_no);
				pto.setId(id);
				pto.setP_name(p_name);
				pto.setP_main(p_main);
				pto.setP_date(p_date);
				pto.setP_score(p_score);
				list.add(pto);
			} // while END
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(pst != null)	pst.close();
//				if(conn != null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	// search END

	// 게시물 수정
	public void postAlter(String pno, String pname, String pmain) {
		PostDTO pto = new PostDTO();

		String sql = "UPDATE post SET p_name=?, p_main=? WHERE p_no=?";
		try {	
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, pname);
			pst.setString(2, pmain);
			pst.setInt(3, Integer.parseInt(pno) );
			
			pst.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null) pst.close();
//				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} // postAlter END
	
	// 목록 보기
	public ArrayList<PostDTO> list() {
		
		ArrayList<PostDTO> list = new ArrayList<PostDTO>();

		String sql = "SELECT p_no, u_no, p_name, p_main, to_char(p_date, 'YYYY/MM/DD') p_date, p_score"
						+ " FROM POST ORDER BY p_no";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {

				int p_no = rs.getInt( "p_no" );
				int u_no = rs.getInt( "u_no" );
				String p_name = rs.getString( "p_name" );
				String p_main = rs.getString( "p_main" );
				String p_date = rs.getString( "p_date" );
				int p_score = rs.getInt( "p_score" );
				
				PostDTO bto = new PostDTO();
				bto.setP_no(p_no);
				bto.setU_no(u_no);
				bto.setP_name(p_name);
				bto.setP_main(p_main);
				bto.setP_date(p_date);
				bto.setP_score(p_score);
				
				list.add(bto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(pst!=null) pst.close();
				if(rs!=null) rs.close();
//					if(conn!=null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	} // list END
		
	public ArrayList<PostDTO> list(int s_id_no) {
		
		ArrayList<PostDTO> list = new ArrayList<PostDTO>();

		String sql = "SELECT p_no, u_no, p_name, p_main, to_char(p_date, 'YYYY/MM/DD') p_date, p_score"
						+ " FROM POST WHERE s_id_no=?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_id_no);
			rs = pst.executeQuery();
			while(rs.next()) {

				int p_no = rs.getInt( "p_no" );
				int u_no = rs.getInt( "u_no" );
				String p_name = rs.getString( "p_name" );
				String p_main = rs.getString( "p_main" );
				String p_date = rs.getString( "p_date" );
				int p_score = rs.getInt( "p_score" );
				
				PostDTO bto = new PostDTO();
				bto.setP_no(p_no);
				bto.setU_no(u_no);
				bto.setP_name(p_name);
				bto.setP_main(p_main);
				bto.setP_date(p_date);
				bto.setP_score(p_score);
				
				list.add(bto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(pst!=null) pst.close();
				if(rs!=null) rs.close();
//					if(conn!=null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	} // list END
	public PostDTO deletePost(int i) {
		PostDTO dto = new PostDTO();
		PreparedStatement pst = null;
		String sql = "DELETE FROM POST WHERE p_no = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, i);
			pst.executeUpdate();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
//				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public PostDTO PostShopDt(int sidno) {
	      
	      PostDTO sData = new PostDTO();

	      String sql = "SELECT p.p_no, u.id, p.p_name, p.p_main, to_char(p_date, 'YYYY/MM/DD') p_date, p.p_score"
					+ " FROM POST p, users u WHERE p.u_no=u.u_no AND p_no=?";
	      
	      try {
	         pst = conn.prepareStatement(sql);
	         pst.setInt(1, sidno);
	         rs = pst.executeQuery();
	         
	         if( rs.next() ) {
	            int p_no = rs.getInt("p_no");
	            String id = rs.getString("id");
	            String p_name = rs.getString( "p_name" );
	            String p_main = rs.getString( "p_main" );
	            String p_date = rs.getString( "p_date" );

	            sData.setId(id);
	            sData.setP_no(p_no);
	            sData.setP_name(p_name);
	            sData.setP_main(p_main);
	            sData.setP_date(p_date);
	         } // if END
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         
	         try {
	            if( rs != null ) rs.close();
	            if( pst != null ) pst.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         
	      }
	      return sData;
	   } // PostShopDt END
	
} // class END
