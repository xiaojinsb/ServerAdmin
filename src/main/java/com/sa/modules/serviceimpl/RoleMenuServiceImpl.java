package com.sa.modules.serviceimpl;

import com.sa.modules.dao.RoleMenuDao;
import com.sa.modules.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/24
 * @Description: 角色模块实现类
 */
@Service("RoleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {

        if(menuIdList.size() == 0){
            return ;
        }

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("menuIdList", menuIdList);
        roleMenuDao.add(map);
    }

    @Override
    public int delete(long id) {
        return roleMenuDao.delete(id);
    }
}
