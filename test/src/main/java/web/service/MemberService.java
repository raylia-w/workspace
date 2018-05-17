package web.service;

import java.util.List;

import web.dto.Member;

public interface MemberService {
	public List<Member> getMembers();
	public void insert(Member member);
	public void delete(Member member);
	public void update(Member member);
	public Member getOneMember(Member member);
}
