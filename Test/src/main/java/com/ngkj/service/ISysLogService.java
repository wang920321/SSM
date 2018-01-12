package com.ngkj.service;

import com.baomidou.framework.service.ISuperService;
import com.ngkj.bean.SysLog;
import com.ngkj.commons.utils.PageInfo;

/**
 * SysLog 表数据服务层接口
 */
public interface ISysLogService extends ISuperService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}