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
     * 根据父菜单，查询子菜单
     */
    List<MenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     */
    List<MenuEntity> queryListParentId(Long parentId);

    /**
     * 查询模块列表 数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 列出所有目录
     */
    List<MenuEntity> queryAllCatalog(Integer type);

    /**
     * 新增模块
     */
    void add(MenuEntity menuEntity);

    /**
     * 更新模块
     */
    int edit(MenuEntity menuEntity);

    /**
     * 删除模块
     */
    int delete(long id);

    /**
     * 根据名字查询角色
     */
    MenuEntity queryByMenuName(String menuNmae);

    /**
     * 列出模块 无权限
     */
    List<MenuEntity> menuAllList();
}
