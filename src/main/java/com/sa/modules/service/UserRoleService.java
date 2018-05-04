package com.sa.modules.service;

import java.util.List;

public interface UserRoleService {

    /**
     * 新建用户管理角色
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 删除用户角色关联
     */
    int delete(long id);

}
