package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.DAO.GroupDAO;
import mvc.DTO.Board;
import mvc.DTO.Groups;

public class GroupServiceImpl implements GroupService{

	@Autowired GroupDAO groupDao;
	

	@Override
	public List getGroupList() {
		return groupDao.getGroupList();
	}
	
	@Override
	public Groups getGroupInfo() {
		return groupDao.getGroupInfo();
	}

	@Override
	public void memberRegistration() {
		groupDao.memberRegistration();
	}

	@Override
	public void memberSecession() {
		groupDao.memberSecession();
	}

	@Override
	public void createGroup() {
		groupDao.createGroup();
	}

	@Override
	public void deleteGroup() {
		groupDao.deleteGroup();
	}

}
