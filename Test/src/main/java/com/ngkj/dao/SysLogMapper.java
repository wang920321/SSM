package com.ngkj.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.ngkj.bean.Role;
import com.ngkj.bean.SysLog;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysLog 表数据库控制层接口
 */
@Repository
public interface SysLogMapper extends AutoMapper<SysLog> {

    List<Role> selectSysLogList(Pagination page);

}