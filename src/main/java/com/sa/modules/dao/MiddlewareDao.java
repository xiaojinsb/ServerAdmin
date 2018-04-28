package com.sa.modules.dao;

import com.sa.modules.entity.MiddlewareEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 中间件管理Dao
 */
public interface MiddlewareDao extends BaseDao<MiddlewareEntity> {

    /**
     * 列出中间件的id和名字
     */
    List<MiddlewareEntity> queryAllMidd(long[] id);
}
