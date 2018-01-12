package com.ngkj.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ngkj.bean.RoleResource;
import com.ngkj.dao.RoleResourceMapper;
import com.ngkj.service.IRoleResourceService;

import org.springframework.stereotype.Service;

/**
 * RoleResource 表数据服务层接口实现类
 */
@Service
public class RoleResourceServiceImpl extends SuperServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {

}