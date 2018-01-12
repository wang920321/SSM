package sys.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.dao.RoleMenuMapper;
import sys.qx.model.RoleMenu;
import sys.qx.model.RoleMenuExample;
import sys.qx.service.RoleMenuService;

@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService{

	private RoleMenuMapper roleMenuMapper;
		
	public RoleMenuMapper getRoleMenuMapper() {
		
		return roleMenuMapper;
	}

	@Autowired
	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper) {
		
		this.roleMenuMapper = roleMenuMapper;
	}

	@Override
	public List<RoleMenu> getRoleMenuByRoleId(String roldId) {
		RoleMenuExample example = new RoleMenuExample();
		example.createCriteria().andRoleidEqualTo(roldId);
		List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(example);
		if(roleMenus == null || roleMenus.size() < 1)
			return null;
		return roleMenus;
	}

	@Override
	public List<RoleMenu> getRoleMenuByMenuId(String menuId) {
		RoleMenuExample example = new RoleMenuExample();
		example.createCriteria().andMenidEqualTo(menuId);
		List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(example);
		if(roleMenus == null || roleMenus.size() < 1)
			return null;
		return roleMenus;
	}

	@Override
	public int delRoleMenuByRoleId(String id) {
		RoleMenuExample example = new RoleMenuExample();
		example.createCriteria().andRoleidEqualTo(id);
		return roleMenuMapper.deleteByExample(example);
	}

	@Override
	public int delRoleMenuByMenuId(String id) {
		RoleMenuExample example = new RoleMenuExample();
		example.createCriteria().andMenidEqualTo(id);
		return roleMenuMapper.deleteByExample(example);
	}

	@Override
	public int addRoleMenu(RoleMenu roleMenu) {
		return roleMenuMapper.insert(roleMenu);
	}

}
