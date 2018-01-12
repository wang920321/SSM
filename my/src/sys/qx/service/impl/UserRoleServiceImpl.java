package sys.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.dao.RoleMapper;
import sys.qx.dao.UserRoleMapper;
import sys.qx.model.UserRole;
import sys.qx.model.UserRoleExample;
import sys.qx.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{

	private UserRoleMapper userRoleMapper;
	
	public UserRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}
	
	@Autowired
	public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	@Override
	public List<UserRole> getUserRoleByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUseridEqualTo(userId);
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		return userRoles;
	}

	@Override
	public List<UserRole> getUserRoleByRoleId(String roleId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleidEqualTo(roleId);
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		if(userRoles == null || userRoles.size() < 1){
			return null;
		}
		return userRoles;
	}

	@Override
	public int deleteByUserId(String id) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUseridEqualTo(id);	
		return userRoleMapper.deleteByExample(example);
	}

	@Override
	public int deleteByRoleId(String id) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleidEqualTo(id);
		return userRoleMapper.deleteByExample(example);
	}

	@Override
	public int addUserRole(UserRole userRole) {
		return userRoleMapper.insert(userRole);
	}

}
