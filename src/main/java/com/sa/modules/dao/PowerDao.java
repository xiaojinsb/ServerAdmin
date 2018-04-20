package com.sa.modules.dao;

import com.sa.modules.entity.PowerEntity;

import java.util.List;

public interface PowerDao{
    /**
     * 列出所有权限
     */
    List<PowerEntity> queryAllPowers();
}
