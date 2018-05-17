package web.dao;

import web.dto.User;

public interface UserDao {
	public void memberJoin(User user);
	public User isMember(User user);
	public int isNew(User user);
}
