package web.dao;

import java.util.List;

import web.dto.Member;


public interface MemberDAO {
	public List<Member> selectAll();
	public void insert(Member member);
	public void delete(Member member);
	public void update(Member member);
	public Member selectMember(Member member);
}
