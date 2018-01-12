package sys.qx.model;

import java.util.ArrayList;
import java.util.List;

public class RoleInfo {
	private Role role;
	private List<Menu> menus = new ArrayList<Menu>();
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public RoleInfo(Role role) {
		super();
		this.role = role;
	}
	public RoleInfo() {
		super();
	}
	
}
