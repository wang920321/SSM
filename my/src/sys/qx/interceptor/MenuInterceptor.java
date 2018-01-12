package sys.qx.interceptor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sys.qx.annotation.MenuCtrl;
import sys.qx.model.Menu;
import sys.qx.model.RoleInfo;
import sys.qx.model.UserInfo;
import sys.qx.test.UserRoleTest;
import sys.qx.util.Const;

public class MenuInterceptor implements HandlerInterceptor{

	private static final Logger logger = Logger.getLogger(MenuInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		if(arg2 instanceof HandlerMethod){
			HandlerMethod hm = (HandlerMethod) arg2;
			MenuCtrl menuCtrl = hm.getMethodAnnotation(MenuCtrl.class);
			if(null == menuCtrl){
				return true;
			}
			HttpSession session = req.getSession();
			List<RoleInfo> roleInfos = (List<RoleInfo>) session.getAttribute(Const.ROLEINFO);
			logger.info(roleInfos);
			Set<Menu> menus = new HashSet<Menu>();
			boolean flag = false;			
			if(roleInfos == null || roleInfos.size() < 1){
				return false;
			}else{
				for(RoleInfo roleInfo : roleInfos){
					List<Menu> m = roleInfo.getMenus();
					if(m != null && m.size() > 0){
						for(Menu menu : m){
							if(menu.getCode() != null && menu.getCode().length()>0){
								if(menu.getCode().equals(menuCtrl.value())){
									flag = true;
									break;
								}
							}
						}
					}
				}
				if(!flag){
					resp.sendRedirect(req.getContextPath() + "/error.do");
				}else{
					return true;
				}
			}
		}
		return false;
	}

}
