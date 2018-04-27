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
    List<DataBaseEntity> queryAllData(long id);
}
