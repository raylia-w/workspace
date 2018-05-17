package mvc.DAO;

import java.util.List;

import mvc.DTO.Member;

public interface MemberDAO {

	public List getMemberList();
	
	public Member getMemberInfo();
	
	public void joinMember();
	
	public void secessionMember();
	
}
