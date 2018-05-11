package com.sa.modules.dao;

import com.sa.modules.entity.ParsesEntity;

import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 上传Dao
 */
public interface ParsesDao extends BaseDao<ParsesEntity> {
    /**
     * 查询文件
     */
    List<ParsesEntity> queryFile(String fileName, long fileId,String fileClassify);

}
