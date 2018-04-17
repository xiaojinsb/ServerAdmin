package com.sa.modules.service;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户角色server接口
 */
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
