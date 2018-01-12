package sys.qx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.dao.MenuMapper;
import sys.qx.model.Menu;
import sys.qx.model.MenuExample;
import sys.qx.service.MenuService;
import sys.qx.util.StringUtils;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	private MenuMapper menuMapper;
	
	public MenuMapper getMenuMapper() {
		return menuMapper;
	}

	@Autowired
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	@Override
	public Menu getMenu(String menuId) {	
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public List<Menu> getAllMenu() {
		MenuExample example = new MenuExample();
		return menuMapper.selectByExample(example);
	}

	@Override
	public int deleteMenu(String id) {
		return menuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int addMenu(Menu menu) {
		return menuMapper.insert(menu);
	}

	@Override
	public int updateMenu(Menu menu) {
		return menuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public List<Menu> getAllMenuSort() {
		List<Menu> pMenu = this.getMenusByPid("0");
		List<Menu> sortMenu = new ArrayList<Menu>();
		if(pMenu != null || pMenu.size() > 0){
			for(Menu menu : pMenu){
				sortMenu.add(menu);
				List<Menu> m = getMenusByPid(menu.getId());
				if(StringUtils.isNotNull(m)){
					sortMenu.addAll(m);
				}
			}
		}
		return sortMenu;
	}

	@Override
	public List<Menu> getMenusByPid(String id) {
		MenuExample example = new MenuExample();
		example.createCriteria().andPidEqualTo(id);
		return menuMapper.selectByExample(example);
	}

	@Override
	public boolean getMenuIsExist(String menuname) {
		MenuExample example = new MenuExample();
		example.createCriteria().andMenunameEqualTo(menuname);
		List<Menu> menus = menuMapper.selectByExample(example);
		return StringUtils.isNotNull(menus);
	}
}
