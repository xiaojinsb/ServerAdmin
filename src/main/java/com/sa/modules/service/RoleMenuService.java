package com.sa.modules.service;

import java.util.List;

public interface RoleMenuService {

    /**
     * 新建角色关联模块
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 删除角色关联
     */
    int delete(long id);

}
