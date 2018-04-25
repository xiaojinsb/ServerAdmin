package com.sa.modules.dao;

import com.sa.modules.entity.UserEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户Dao
 */
public interface UserDao extends BaseDao<UserEntity>{
    /**
     * 根据用户名，查询系统用户
     */
    UserEntity queryByUserName(String username);

    /**
     * 查询用户的所有权限
     */
    List<String> queryUserPowers(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 查询用户拥有的角色
     */
    List<Integer> userRoleList(Integer id);

    /**
     * 列出所有用户的id和姓名
     */
    List<UserEntity> queryAllUser();

}
