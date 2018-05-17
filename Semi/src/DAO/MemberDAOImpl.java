package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Member;

public class MemberDAOImpl implements MemberDAO{	
	
	private final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "food";
	private final String password = "escape";
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public MemberDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isMember(Member m) {
		String id = m.getID();
		String pw = m.getPassword();
		String sql = "SELECT * FROM users WHERE id = ? AND pw = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean isNew(Member m) {
		String sql = "SELECT count(*) FROM USERS WHERE id=?";
		String id = m.getID();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			rs.next();
			int res = rs.getInt(1);
			if(res>0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null) pst.close();
				if(st!=null) st.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void addMember(Member m) {
		String sql = "INSERT INTO USERS (u_no, u_name, u_id_no, u_addr, u_p_no, email, nick, gender, grade, id, pw)"
					+"VALUES (SEQ_U_NO.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
//			pst.setInt(1, 0);
			pst.setString(1, m.getuName());
			pst.setString(2, m.getuId());
			pst.setString(3, m.getuAddr());
			pst.setString(4, m.getuPNo());
			pst.setString(5, m.getuEmail());
			pst.setString(6, m.getuNick());
			pst.setInt(7, m.getuGender());
			pst.setInt(8, 1);
			pst.setString(9, m.getID());
			pst.setString(10, m.getPassword());
			
			pst.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null) pst.close();
				if(st!=null) st.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	public ArrayList<Member> selectMember() {
//		Member m = new Member();
		ArrayList<Member> list = new ArrayList<>();
		String sql = "SELECT * FROM users";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setuName(rs.getString(2));
				m.setID(rs.getString(10));
				m.setuAddr(rs.getString(4));
				m.setuPNo(rs.getString(5));
				m.setuEmail(rs.getString(6));
				m.setuNick(rs.getString(7));
				m.setuGender(rs.getInt(8));
				m.setuGrade(rs.getInt(9));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(st!=null) st.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public Member selectMember(String id) {
		Member m = new Member();
		String sql = "SELECT u_name, u_addr, u_p_no, email, nick, u_no FROM users WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				
				m.setuName(rs.getString(1));
				m.setuAddr(rs.getString(2));
				m.setuPNo(rs.getString(3));
				m.setuEmail(rs.getString(4));
				m.setuNick(rs.getString(5));
				m.setuNo(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(st!=null) st.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	public Member selectMember(String name, String pno) {
		Member m = new Member();
		String sql = "SELECT id FROM users WHERE u_name=? AND u_p_no=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pno);
			rs = pst.executeQuery();
			while(rs.next()) {
				m.setID(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}
	public Member selectMember(String id, String name, String pno) {
		Member m = new Member();
		String sql = "SELECT pw FROM users WHERE u_name=? AND u_p_no=? AND id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pno);
			pst.setString(3, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				m.setPassword(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(st!=null) st.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}
	public Member selectMemberIdNo(String id) {
		Member m = new Member();
		String sql = "SELECT u_id_no FROM users WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			rs.next();
			m.setuId(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public int selectMemberNo(String id) {
		int uNo;
		String sql = "SELECT u_no FROM users WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			rs.next();
			uNo=rs.getInt(1);
			return uNo;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int updateMember(int changeclass, String id) {
		String sql = "UPDATE USERS SET grade=? WHERE u_no=?";
		try {
			int result;
			pst = conn.prepareStatement(sql);
			pst.setInt(1, changeclass);
			pst.setString(2, id);
			result = pst.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pst!=null) pst.close();
//					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}
	
	public int updateMember(String id, String pw, String name, String nick, String pno, String email, String addr) {
		String sql = "UPDATE users SET pw=?, u_name=?, nick=?, u_p_no=?, email=?, u_addr=? WHERE id=?";
		try {
			int result;
			pst = conn.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, name);
			pst.setString(3, nick);
			pst.setString(4, pno);
			pst.setString(5, email);
			pst.setString(6, addr);
			pst.setString(7, id);
			result = pst.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pst =conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		return 0;
	}
	
	public int deleteMember(int uno) {
		String sql = "DELETE FROM USERS WHERE u_no=?";
		try {
			int result;
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uno);
			result = pst.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst!=null) pst.close();
//				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public String selectMemberId(int uno) {
		String id = null;
		String sql = "SELECT id FROM users WHERE u_no=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uno);
			rs = pst.executeQuery();
			rs.next();
			id=rs.getString(1);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int memberDiscount(String id) {
		int discount;
		String sql = "SELECT grade FROM users WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			rs.next();
			discount = rs.getInt("grade");
			return discount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
