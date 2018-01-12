package sys.qx.service;

import java.util.List;

import sys.qx.model.Role;

public interface RoleService {
	public Role getRole(String roleId);
	
	public int addRole(Role role);
	
	public int delRole(String id);
	
	public List<Role> getAllRole();
	
	public int update(Role role);

	public boolean getRoleIsExist(String rolename);
}
