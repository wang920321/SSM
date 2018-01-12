package com.ngkj.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ngkj.bean.UserRole;
import com.ngkj.dao.UserRoleMapper;
import com.ngkj.service.IUserRoleService;

import org.springframework.stereotype.Service;

/**
 * UserRole 表数据服务层接口实现类
 */
@Service
public class UserRoleServiceImpl extends SuperServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}