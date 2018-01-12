package sys.qx.service;

import java.util.List;

import sys.qx.model.User;

public interface UserService {
	
	public int addUser(User user);
	
	public User getUser(String id);
	
	public boolean getUserIsExist(String username);
	
	public User getUser(String username, String password);
	
	public int delUser(String id);
	
	public int updateUser(User user);
	
	public List<User> getAllUsers();
	
}
