package com.sa.modules.dao;

import com.sa.modules.entity.SystemEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 系统管理Dao
 */
public interface SystemDao extends BaseDao<SystemEntity> {
    /**
     * 列出应用的id和名字
     */
    List<SystemEntity> queryAllsys(long id);
}
