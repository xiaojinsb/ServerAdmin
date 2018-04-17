package com.sa.modules.serviceimpl;

import com.sa.modules.dao.UserRoleDao;
import com.sa.modules.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户角色实现类
 */
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if(roleIdList.size() == 0){
            return ;
        }

        //保存用户和角色的关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        userRoleDao.add(map);
    }

    @Override
    public int delete(long id) {
        return userRoleDao.delete(id);
    }
}
