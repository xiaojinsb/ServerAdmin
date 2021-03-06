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

    /**
     * 根据所在服务器查询
     */
    List<MiddlewareEntity> queryByServerAll(long id);

    /**
     * 查询出所有数据
     */
    List<MiddlewareEntity> queryAll();
}
