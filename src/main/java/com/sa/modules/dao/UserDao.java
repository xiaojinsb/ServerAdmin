package com.sa.modules.dao;

import com.sa.modules.entity.UserEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2017/12/17 17:49
 * @Description:
 */
//@Mapper
public interface UserDao extends BaseDao<UserEntity>{
    /**
     * 根据用户名，查询系统用户
     */
    UserEntity queryByUserName(String username);

    /**
     * 查询用户的所有权限
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 查询用户拥有的角色
     */
    List<Integer> userRoleList(Integer id);

}
