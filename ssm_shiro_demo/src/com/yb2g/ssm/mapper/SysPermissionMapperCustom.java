package com.yb2g.ssm.mapper;

import java.util.List;

import com.yb2g.ssm.po.SysPermission;

/**
 * 
 * @ClassName: SysPermissionMapperCustom 
 * @Description: 权限mapper
 * @author: Administrator
 * @date: 2017年12月7日 下午2:45:19
 */
public interface SysPermissionMapperCustom {
	
	//根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询权限url
	public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;

}
