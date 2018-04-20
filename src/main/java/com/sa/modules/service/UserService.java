package com.sa.modules.service;

import com.sa.modules.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户server接口
 */
public interface UserService {

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 查询用户拥有的角色
     */
    List<Integer> userRoleList(Integer id);


    /**
     * 查询用户列表 数
     */

    int queryTotal(Map<String, Object> map);

    /**
     * 查询用户列表
     */
    List<UserEntity> queryList(Map<String, Object> map);

}
