package sys.qx.service;

import java.util.List;

import sys.qx.model.RoleMenu;

public interface RoleMenuService {
	public List<RoleMenu> getRoleMenuByRoleId(String roldId);
	
	public List<RoleMenu> getRoleMenuByMenuId(String menuId);
	
	public int delRoleMenuByRoleId(String id);
	
	public int delRoleMenuByMenuId(String id);

	public int addRoleMenu(RoleMenu roleMenu);
}
