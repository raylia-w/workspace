package Service;

import java.util.ArrayList;

import DAO.ManagerDAO;
import DAO.MemberDAO;
import DAO.MemberDAOImpl;
import DTO.Manager;
import DTO.Member;

public class MemberService implements MemberCommand{
	
	MemberDAO mMember = new MemberDAOImpl();
	ManagerDAO Manager_dao = new ManagerDAO();
	
	@Override
	public ArrayList<Member> selectMember(){
		ArrayList<Member> list = new ArrayList<>();
		list = mMember.selectMember();
		return list;
	}
	
	@Override
	public Member selectMember(String id){
		Member m = new Member();
		m = mMember.selectMember(id);
		return m;
	}
	
	@Override
	public Member selectMember(String name, String pno) {
		Member m = new Member();
		m = mMember.selectMember(name, pno);
		return m;
	}
	
	@Override
	public Member selectMember(String id, String name, String pno) {
		Member m = new Member();
		m = mMember.selectMember(id, name, pno);
		return m;
	}
	
	@Override
	public int deleteMember(int uno) {
		return mMember.deleteMember(uno);
	}
	
	@Override
	public int updateMember(int membership, String id) {
		return mMember.updateMember(membership, id);
	}
	
	@Override
	public int updateMember(String id, String pw, String name, String nick, String pno, String email, String addr) {
		return mMember.updateMember(id, pw, name, nick, pno, email, addr);
	}
	
	public Boolean isNew(Member m) {
		boolean flag = mMember.isNew(m);
		
		return flag;
	}
	
	public void addMember(Member m) {
		mMember.addMember(m);
	}
	
	public boolean isMember(Member m) {
		boolean flag = mMember.isMember(m);
		return flag;
	}
	
	public boolean isManager(Manager dto) {
		boolean flag = Manager_dao.isManager(dto);
		return flag;		
	}

	@Override
	public int memberDiscount(String id) {
		return mMember.memberDiscount(id);
	}

	
}
