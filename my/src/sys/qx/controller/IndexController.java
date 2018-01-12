package sys.qx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sys.qx.model.Menu;
import sys.qx.model.Role;
import sys.qx.model.RoleInfo;
import sys.qx.model.User;
import sys.qx.model.UserInfo;
import sys.qx.service.MenuService;
import sys.qx.service.RoleInfoService;
import sys.qx.service.UserInfoService;
import sys.qx.service.UserService;
import sys.qx.util.Const;
import sys.qx.util.StringUtils;
import sys.qx.util.TreeNode;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RoleInfoService roleInfoService;	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("login.do")
	public String login(){
		return "login";
	}
	
	@RequestMapping("dologin.do")
	public String doLogin(String username, String password, HttpServletRequest request){
		if(!StringUtils.isNotNull(username) || !StringUtils.isNotNull(password)){
			return "redirect:login.do";
		}
		User user = userService.getUser(username, password);
		if(user == null){
			return "redirect:login.do";
		}
		UserInfo userInfo = userInfoService.getUserInfo(user);
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
		if(userInfo.getRoles() != null && userInfo.getRoles().size() > 0){
			for(Role role : userInfo.getRoles()){
				RoleInfo roleInfo = roleInfoService.getRoleInfo(role);
				if(roleInfo!=null)
					roleInfos.add(roleInfo);
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute(Const.USERINFO, userInfo);
		session.setAttribute(Const.ROLEINFO, roleInfos);
		return "redirect:index.do";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:login.do";
	}
	
	@RequestMapping("getTreeNode.do")
	@ResponseBody
	public List<TreeNode> getTreeNode(HttpServletRequest request){
		List<RoleInfo> infos = (List<RoleInfo>) request.getSession().getAttribute(Const.ROLEINFO);
		List<TreeNode> treeNodes = null;
		Map<String, Menu> menuMap = new HashMap<String, Menu>();
		if(StringUtils.isNotNull(infos)){
			treeNodes = new ArrayList<TreeNode>();
			for(RoleInfo roleInfo : infos){
				for(Menu menu : roleInfo.getMenus()){
					menuMap.put(menu.getId(), menu);
				}
			}
			String pid = "0";
			for(Map.Entry<String, Menu> entry : menuMap.entrySet()){
				if("0".equals(entry.getValue().getPid())) {
					pid = entry.getKey();
					Menu menu = entry.getValue();
					TreeNode treeNode = new TreeNode();
					treeNode.setId(menu.getId());
					treeNode.setText(menu.getMenuname());
					treeNode.setAttributes(null);
					for(Map.Entry<String, Menu> e : menuMap.entrySet()){
						if(pid.equals(e.getValue().getPid())){
							Menu m = e.getValue();
							if(m.getCode().indexOf("list") >= 0){
								TreeNode t = new TreeNode();
								t.setId(m.getId());
								t.setText(m.getMenuname());
								t.setChildren(null);
								Map<String, Object> url = new HashMap<String, Object>();
								url.put("url", m.getCode()+".do");
								t.setAttributes(url);
								treeNode.getChildren().add(t);
								break;
							}
						}
					}
					treeNodes.add(treeNode);
				}
			}
		}
		return treeNodes;
	}
	
	@RequestMapping("index.do")
	public String index(){
		return "index";
	}
	
	@RequestMapping("error.do")
	public String error(){
		return "error";
	}
	
}
