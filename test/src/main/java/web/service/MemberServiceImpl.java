package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.MemberDAO;
import web.dto.Member;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDAO memberDao;
	
	@Override
	public List getMembers() {
		// DAO를 통해 조회된 DB정보 반환
		return memberDao.selectAll();
	}

	@Override
	public void insert(Member member) {
		memberDao.insert(member);
	}

	@Override
	public void delete(Member member) {
		memberDao.delete(member);
	}

	@Override
	public void update(Member member) {
		memberDao.update(member);
		
	}

	@Override
	public Member getOneMember(Member member) {
		return memberDao.selectMember(member);
	}

}










