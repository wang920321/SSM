package sys.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.dao.UserMapper;
import sys.qx.model.User;
import sys.qx.model.UserExample;
import sys.qx.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUser(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getUser(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(example);
		if(users == null && users.size() < 1)
			return null;
		return users.get(0);
	}

	@Override
	public int delUser(String id) {		
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateUser(User user) {
		UserExample example = new UserExample();
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> getAllUsers() {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public int addUser(User user) {	
		return userMapper.insert(user);
	}

	@Override
	public boolean getUserIsExist(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(example);
		if(users == null || users.size() <= 0)
			return false;
		return true;
	}
	
}
