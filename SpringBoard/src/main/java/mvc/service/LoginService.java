package mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.LoginDao;
import mvc.dto.User;

@Service
public class LoginService {
	
	@Autowired LoginDao loginDao;
	
	public User login(User user) {
		return loginDao.login(user);
	}
	
	public void join(User user) {
		loginDao.join(user);
	}

}
