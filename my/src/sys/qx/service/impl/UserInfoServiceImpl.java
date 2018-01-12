package sys.qx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.dao.RoleMapper;
import sys.qx.dao.UserRoleMapper;
import sys.qx.model.Role;
import sys.qx.model.User;
import sys.qx.model.UserInfo;
import sys.qx.model.UserRole;
import sys.qx.model.UserRoleExample;
import sys.qx.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	
	private UserRoleMapper userRoleMapper;
	
	private RoleMapper roleMapper;
	
	public UserRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}

	@Autowired
	public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public UserInfo getUserInfo(User user){
		if(user == null)
			return null;
		UserInfo userInfo = new UserInfo(user);
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUseridEqualTo(user.getId());
		List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
		if(userRoles != null || userRoles.size() > 0){
			for(UserRole userRole : userRoles){
				Role role = roleMapper.selectByPrimaryKey(userRole.getRoleid());
				userInfo.getRoles().add(role);
			}
		}
		return userInfo;
	}
	
	@Override
	public List<UserInfo> getUserInfos(List<User> users) {	
		if(users == null || users.size() <= 0){
			return null;
		}
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for(User u : users){
			UserInfo userInfo = getUserInfo(u);
			if(userInfo != null)
				userInfos.add(userInfo);
		}
		return userInfos;
	}
	

}
