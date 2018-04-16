package com.sa.modules.service;

import com.sa.modules.entity.RoleEntity;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**
     * 查询角色列表 数
     */

    int queryTotal(Map<String, Object> map);

    /**
     * 查询角色列表
     */
    List<RoleEntity> queryList(Map<String, Object> map);

    /**
     * 查询角色拥有的权限
     */
    List<Integer> roleQueryList(Integer id);

    /**
     * 保存角色
     */
    void add(RoleEntity roleEntity);

    /**
     * 根据名字查询角色
     */
    RoleEntity queryByRoleName(String roleNmae);

    /**
     * 修改角色
     */
    int update(RoleEntity t);

    /**
     * 删除角色
     */
    int delete(long id);

}
