package com.sa.modules.service;

import com.sa.modules.entity.MenuEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 模块server接口
 */
public interface MenuService {

    /**
     * 获取模块菜单列表
     */
    List<MenuEntity> queryUserMenuList(Long userId);

    /**
     * 查询模块列表
     */
    List<MenuEntity> queryList(Map<String, Object> map);

    /**
     * 删除模块
     */
    int delete(long id);

    /**
     * 更新模块
     */
    int update(MenuEntity menuEntity);

    /**
     * 根据父菜单，查询子菜单
     */
    List<MenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     */
    List<MenuEntity> queryListParentId(Long parentId);

    /**
     * 获取模块权限列表
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 查询模块列表 数
     */

    int queryTotal(Map<String, Object> map);

    /**
     * 新增模块
     */
    void add(MenuEntity menuEntity);

    /**
     *列出所有1级菜单
     */
    List<MenuEntity> oneMenu();

    /**
     *列出所有不是三级菜单的
     */
    List<MenuEntity> twoMenu();

}
