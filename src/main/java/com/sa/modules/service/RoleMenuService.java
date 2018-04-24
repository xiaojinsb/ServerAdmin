package com.sa.modules.service;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/24
 * @Description: 角色模块server接口
 */
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
