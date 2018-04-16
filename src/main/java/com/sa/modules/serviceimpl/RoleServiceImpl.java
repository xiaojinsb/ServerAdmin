package com.sa.modules.serviceimpl;

import com.sa.modules.dao.RoleDao;
import com.sa.modules.entity.RoleEntity;
import com.sa.modules.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public int queryTotal(Map<String, Object> map) {
        return roleDao.queryTotal(map);
    }

    @Override
    public List<RoleEntity> queryList(Map<String, Object> map) {
        return roleDao.queryList(map);
    }

    @Override
    public List<Integer> roleQueryList(Integer id) {
        return roleDao.roleQueryList(id);
    }

    @Override
    public void add(RoleEntity roleEntity) {
        roleDao.add(roleEntity);
    }

    @Override
    public RoleEntity queryByRoleName(String roleNmae) {
        return roleDao.queryByRoleName(roleNmae);
    }

    @Override
    public int update(RoleEntity t) {
        return roleDao.update(t);
    }

    @Override
    public int delete(long id) {
        return roleDao.delete(id);
    }
}
