package sys.qx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sys.qx.annotation.MenuCtrl;
import sys.qx.model.Role;
import sys.qx.model.RoleInfo;
import sys.qx.model.RoleMenu;
import sys.qx.service.RoleInfoService;
import sys.qx.service.RoleMenuService;
import sys.qx.service.RoleService;
import sys.qx.util.AjaxResult;
import sys.qx.util.Message;
import sys.qx.util.RoleInfoJSON;
import sys.qx.util.StringUtils;

@Controller
@RequestMapping("/roleMenu/")
public class RoleMenuController {
	
	@Autowired
	private RoleMenuService roleMenuService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	@RequestMapping("getRoleMenus.do")
	@ResponseBody
	@MenuCtrl("roleMenu/list")
	public List<RoleInfoJSON> getRoleMenus(){
		List<Role> roles = roleService.getAllRole();
		if(!StringUtils.isNotNull(roles))
			return null;
		List<RoleInfo> roleInfos = roleInfoService.getRoleInfos(roles);
		if(!StringUtils.isNotNull(roleInfos)){
			return null;
		}
		//包装json
		List<RoleInfoJSON> roleInfoJSONs = new ArrayList<RoleInfoJSON>();
		for(RoleInfo roleInfo : roleInfos){
			RoleInfoJSON roleInfoJSON = new RoleInfoJSON();
			roleInfoJSON.setId(roleInfo.getRole().getId());
			roleInfoJSON.setRoleName(roleInfo.getRole().getRolename());
			roleInfoJSON.setMenuName(roleInfo.getMenus());
			roleInfoJSONs.add(roleInfoJSON);
		}
		return roleInfoJSONs;
	}
	
	@RequestMapping("update.do")
	@ResponseBody
	@MenuCtrl("roleMenu/update")
	public AjaxResult update(@RequestParam(value="ids", required = false) String[] menuIds,@RequestParam(value = "id", required = true) String roleId){
		roleMenuService.delRoleMenuByRoleId(roleId);
		int result = insertRoleMenu(menuIds, roleId);
		if(result >= 0 ){
			return new AjaxResult(true);
		}else{
			return new AjaxResult(Message.SUCCESS.getMessage());
		}
	}
	
	
	public int insertRoleMenu(String[] menuIds, String roleId){
		int result = 0;
		if(StringUtils.isNotNull(menuIds)){
			for(String menuid : menuIds){
				RoleMenu roleMenu = new RoleMenu(menuid, roleId);
				result = roleMenuService.addRoleMenu(roleMenu);
				if(result <= 0){
					return result;
				}
			}
		}
		return result;
	}
	
	@RequestMapping("list.do")
	@MenuCtrl("roleMenu/list")
	public String list(){
		return "roleMenu/list";
	}
}
