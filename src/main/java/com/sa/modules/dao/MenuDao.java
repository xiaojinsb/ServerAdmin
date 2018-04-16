package com.sa.modules.dao;

import com.sa.modules.entity.MenuEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2017/12/17 17:50
 * @Description:
 */
//@Mapper
public interface MenuDao extends BaseDao<MenuEntity>{
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<MenuEntity> queryListParentId(Long parentId);

    /**
     *列出所有1级菜单
     */
    List<MenuEntity> oneMenu();

    /**
     *列出所有不是三级菜单的
     */
    List<MenuEntity> twoMenu();
}
