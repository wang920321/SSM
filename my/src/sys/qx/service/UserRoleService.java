package sys.qx.service;

import java.util.List;

import sys.qx.model.UserRole;

public interface UserRoleService {
	
	public List<UserRole> getUserRoleByUserId(String userId);
	
	public List<UserRole> getUserRoleByRoleId(String roleId);

	public int deleteByUserId(String id);
	
	public int deleteByRoleId(String id);

	public int addUserRole(UserRole userRole);
}
