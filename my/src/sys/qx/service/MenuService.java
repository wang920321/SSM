package sys.qx.service;

import java.util.List;

import sys.qx.model.Menu;

public interface MenuService {
	public Menu getMenu(String menuId);
	public List<Menu> getAllMenu();
	public int deleteMenu(String id);
	public int addMenu(Menu menu);
	public int updateMenu(Menu menu);
	public List<Menu> getAllMenuSort();
	public List<Menu> getMenusByPid(String id);
	public boolean getMenuIsExist(String menuname);
	
}
