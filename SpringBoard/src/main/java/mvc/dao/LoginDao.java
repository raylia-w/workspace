package mvc.dao;

import mvc.dto.User;

public interface LoginDao {
	public User login(User user);
	public void join(User user);
}
