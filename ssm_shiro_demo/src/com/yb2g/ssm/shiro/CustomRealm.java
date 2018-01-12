package com.yb2g.ssm.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.yb2g.ssm.po.ActiveUser;
import com.yb2g.ssm.po.SysPermission;
import com.yb2g.ssm.po.SysUser;
import com.yb2g.ssm.service.SysService;

/**
 * 
 * @ClassName: CustomRealm
 * @Description: 自定义realm
 * @author: Administrator
 * @date: 2017年12月8日 下午2:25:56
 */
public class CustomRealm extends AuthorizingRealm {

	// 注入service
	@Autowired
	private SysService sysService;

	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// 用于认证
	/*
	 * @Override protected AuthenticationInfo
	 * doGetAuthenticationInfo(AuthenticationToken token) throws
	 * AuthenticationException { // TODO Auto-generated method stub //
	 * token是用户输入的 // 第一步从token中取出身份信息 String userCode = (String)
	 * token.getPrincipal();
	 * 
	 * // 第二步：根据用户输入的userCode从数据库查询 // ....
	 * 
	 * // 如果查询不到返回null // 数据库中用户账号是zhangsansan
	 * 
	 * if(!userCode.equals("zhangsansan")){// return null; }
	 * 
	 * 
	 * // 模拟从数据库查询到密码 String password = "111111";
	 * 
	 * // 如果查询到返回认证信息AuthenticationInfo
	 * 
	 * // activeUser就是用户身份信息 ActiveUser activeUser = new ActiveUser();
	 * 
	 * activeUser.setUserid("zhangsan"); activeUser.setUsercode("zhangsan");
	 * activeUser.setUsername("zhangsan"); // ..
	 * 
	 * // 根据用户id取出菜单 // 通过service取出菜单 List<SysPermission> menus = null; try {
	 * menus = sysService.findMenuListByUserId("zhangsan"); } catch (Exception
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } // 将用户菜单
	 * 设置到activeUser activeUser.setMenus(menus);
	 * 
	 * // 如果查询到返回认证信息AuthenticationInfo
	 * 
	 * SimpleAuthenticationInfo simpleAuthenticationInfo = new
	 * SimpleAuthenticationInfo(activeUser, password, this.getName());
	 * 
	 * return simpleAuthenticationInfo; }
	 */

	// realm的认证方法，从数据库查询用户信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// token是用户输入的
		// 第一步从token中取出身份信息
		String userCode = (String) token.getPrincipal();

		// 第二步：根据用户输入的userCode从数据库查询
		// ....
		SysUser sysUser = null;
		try {
			sysUser = sysService.findSysUserByUserCode(userCode);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 如果查询不到返回null
		// 数据库中用户账号是zhangsansan
		if (sysUser == null) {
			return null;
		}

		// 模拟从数据库查询到密码
		String password = sysUser.getPassword();

		// 盐
		String salt = sysUser.getSalt();

		// 如果查询到返回认证信息AuthenticationInfo

		// activeUser就是用户身份信息
		ActiveUser activeUser = new ActiveUser();

		activeUser.setUserid(sysUser.getId());
		activeUser.setUsercode(sysUser.getUsercode());
		activeUser.setUsername(sysUser.getUsername());
		// ..
		// ..

		// 根据用户id取出菜单
		// 通过service取出菜单
		List<SysPermission> menus = null;
		try {
			menus = sysService.findMenuListByUserId(sysUser.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将用户菜单 设置到activeUser
		activeUser.setMenus(menus);

		// 如果查询到返回认证信息AuthenticationInfo

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password,
				ByteSource.Util.bytes(salt), this.getName());

		return simpleAuthenticationInfo;
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		// 从 principals获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

		// 根据身份信息获取权限信息
		// 从数据库获取到权限数据
		List<SysPermission> permissionList = null;
		try {
			permissionList = sysService.findPermissionListByUserId(activeUser.getUserid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 单独定一个集合对象
		List<String> permissions = new ArrayList<String>();
		if (permissionList != null) {
			for (SysPermission sysPermission : permissionList) {
				// 将数据库中的权限标签 符放入集合
				permissions.add(sysPermission.getPercode());
			}
		}

		// 根据身份信息获取权限信息
		// 连接数据库...
		// 模拟从数据库获取到数据
		/*
		 * List<String> permissions = new ArrayList<String>();
		 * permissions.add("user:create");// 用户的创建
		 * permissions.add("item:add");// 商品添加权限
		 * permissions.add("item:query");// 商品查询权限
		 * permissions.add("item:edit");// 商品修改权限
		 */ // ....

		// 查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

	//清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
