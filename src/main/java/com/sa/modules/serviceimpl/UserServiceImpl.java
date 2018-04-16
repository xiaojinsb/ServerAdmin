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
 * @Date: 2017/12/17 18:01
 * @Description:
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity queryByUserName(String username) {
        return userDao.queryByUserName(username);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return userDao.queryAllMenuId(userId);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public void add(UserEntity user) {

        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));

        userDao.add(user);
    }

    @Override
    public int update(UserEntity user) {
        return userDao.update(user);
    }

    @Override
    public int delete(long id) {
        return userDao.delete(id);
    }

    @Override
    public List<Integer> userRoleList(Integer id) {
        return userDao.userRoleList(id);
    }
}
