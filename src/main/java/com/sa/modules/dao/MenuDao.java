package com.sa.modules.dao;

import com.sa.modules.entity.MenuEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 模块Dao
 */
public interface MenuDao extends BaseDao<MenuEntity>{
    /**
     * 根据父菜单，查询子菜单
     */
    List<MenuEntity> queryListParentId(Long parentId);

    /**
     * 列出所有权限 type为2
     */
    List<MenuEntity> queryAllPowers();

    /**
     * 列出所有目录
     */
    List<MenuEntity> queryAllCatalog(Integer type);

    /**
     * 根据名字查询角色
     */
    MenuEntity queryByMenuName(String menuNmae);

    /**
     * 列出模块 无权限
     */
    List<MenuEntity> menuAllList();
}
