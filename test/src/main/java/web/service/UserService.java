package web.service;

import web.dto.User;

public interface UserService {
	public void memberJoin(User user);
	public User isMember(User user);
	public int isNew(User user);
}
