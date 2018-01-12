package com.ngkj.service;

import com.baomidou.framework.service.ISuperService;
import com.ngkj.bean.Resource;
import com.ngkj.bean.User;
import com.ngkj.commons.result.Tree;

import java.util.List;

/**
 * Resource 表数据服务层接口
 */
public interface IResourceService extends ISuperService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllTree();

    List<Tree> selectAllTrees();

    List<Tree> selectTree(User currentUser);

}