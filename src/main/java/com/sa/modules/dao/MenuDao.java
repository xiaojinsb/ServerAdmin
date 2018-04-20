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
}
