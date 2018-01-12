package com.yb2g.ssm.service;

import java.util.List;

import com.yb2g.ssm.po.ActiveUser;
import com.yb2g.ssm.po.SysPermission;
import com.yb2g.ssm.po.SysUser;

/**
 * 
 * @ClassName: SysService 
 * @Description: 认证授权服务接口
 * @author: Administrator
 * @date: 2017年12月7日 下午2:41:26
 */
public interface SysService {
	
	//根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
	//根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode)throws Exception;
	
	//根据用户id查询权限范围的菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	//根据用户id查询权限范围的url
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
