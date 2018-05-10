package com.sa.modules.dao;

import com.sa.modules.entity.ServerEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 服务器管理Dao
 */
public interface ServerDao extends BaseDao<ServerEntity> {

    /**
     * 列出服务器的id和名字
     */
    List<ServerEntity> queryAllServer(long[] id);

    /**
     * 查询出所有数据
     */
    List<ServerEntity> queryAll();
}
