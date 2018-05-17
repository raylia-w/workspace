package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.UserDao;
import web.dto.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserDao userDao;
	
	public void memberJoin(User user) {
		userDao.memberJoin(user);
	}

	@Override
	public User isMember(User user) {
		return userDao.isMember(user);
	}

	@Override
	public int isNew(User user) {
		return userDao.isNew(user);
	}
	
}
