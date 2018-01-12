package sys.qx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.model.Menu;
import sys.qx.model.Role;
import sys.qx.model.RoleInfo;
import sys.qx.model.RoleMenu;
import sys.qx.service.MenuService;
import sys.qx.service.RoleInfoService;
import sys.qx.service.RoleMenuService;
import sys.qx.util.StringUtils;

@Service("roleInfoService")
public class RoleInfoServiceInfo implements RoleInfoService{

	private RoleMenuService roleMenuService;	
	
	private MenuService menuService;	
	
	public MenuService getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public RoleMenuService getRoleMenuService() {
		return roleMenuService;
	}
	
	@Autowired
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	
	@Override
	public RoleInfo getRoleInfo(Role role) {
		RoleInfo roleInfo = new RoleInfo(role);
		List<RoleMenu> roleMenus = roleMenuService.getRoleMenuByRoleId(role.getId());
		if(roleMenus != null){			
			for(RoleMenu roleMenu : roleMenus){
				Menu menu = menuService.getMenu(roleMenu.getMenid());
				if(menu != null){
					roleInfo.getMenus().add(menu);
				}
			}
		}
		return roleInfo;
	}

	
	
	@Override
	public List<RoleInfo> getRoleInfos(List<Role> roles) {
		if(!StringUtils.isNotNull(roles)){
			return null;
		}
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
		for(Role role : roles){
			RoleInfo roleInfo = getRoleInfo(role);
			if(roleInfo != null){
				roleInfos.add(roleInfo);
			}
		}
		return roleInfos;
	}
	
}
