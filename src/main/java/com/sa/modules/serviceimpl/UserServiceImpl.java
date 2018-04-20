package com.sa.modules.serviceimpl;

import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.UserEntity;
import com.sa.modules.service.UserService;
import com.sa.modules.shiro.ShiroUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户实现类
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return userDao.queryAllMenuId(userId);
    }

    @Override
    public List<Integer> userRoleList(Integer id) {
        return userDao.userRoleList(id);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }
}
