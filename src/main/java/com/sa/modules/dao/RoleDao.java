package com.sa.modules.dao;


import com.sa.modules.entity.RoleEntity;

import java.util.List;

public interface RoleDao extends BaseDao<RoleEntity> {

    /**
     * 查询角色拥有的权限
     */
    List<Integer> roleQueryList(Integer id);

    /**
     * 根据名字查询角色
     */
    RoleEntity queryByRoleName(String roleNmae);
}
