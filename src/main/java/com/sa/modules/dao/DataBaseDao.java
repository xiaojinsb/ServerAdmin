package com.sa.modules.dao;

import com.sa.modules.entity.DataBaseEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 服务器管理Dao
 */
public interface DataBaseDao extends BaseDao<DataBaseEntity> {

    /**
     * 列出数据库的id和名字
     */
    List<DataBaseEntity> queryAllData(long[] id);

    /**
     * 根据所在服务器查询
     */
    List<DataBaseEntity> queryByServerAll(long id);

    /**
     * 查询出所有数据
     */
    List<DataBaseEntity> queryAll();
}
