package DAO;

import java.util.ArrayList;

import DTO.Member;

public interface MemberDAO {
	public boolean isMember(Member m);
	public boolean isNew(Member m);
	public void addMember(Member m);
	public ArrayList<Member> selectMember();
	public Member selectMember(String id);
	public Member selectMember(String name, String pno);
	public Member selectMember(String id, String name, String pno);
	public Member selectMemberIdNo(String id);
	public String selectMemberId(int uno);
	public int selectMemberNo(String id);
	public int updateMember(int changeclass, String id);
	public int updateMember(String id, String pw, String name, String nick, String pno, String email, String addr);
	public int deleteMember(int uno);
	public int memberDiscount(String id);
}

