package com.sa.modules.dao;

import com.sa.modules.entity.RoleEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户Dao
 */
public interface RoleDao extends BaseDao<RoleEntity> {
    /**
     * 根据名字查询角色
     */
    RoleEntity queryByRoleName(String roleNmae);

    /**
     * 查询角色拥有的权限
     */
    List<Integer> roleQueryList(Integer id);
}
