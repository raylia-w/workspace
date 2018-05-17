package Service;

import java.util.ArrayList;
import DTO.Member;

public interface MemberCommand {
	
	public ArrayList<Member> selectMember();
	
	public Member selectMember(String id);
	
	public Member selectMember(String name, String pno);
	
	public Member selectMember(String id, String name, String pno);
	
	public int deleteMember(int uno);
	
	public int updateMember(int membership, String id);
	
	public int updateMember(String id, String pw, String name, String nick, String pno, String email, String addr);
	
	public Boolean isNew(Member m);
	
	public void addMember(Member m);
	
	public boolean isMember(Member m);
	
	public int memberDiscount(String id);

}
