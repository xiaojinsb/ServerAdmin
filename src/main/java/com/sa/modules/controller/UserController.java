package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.UserEntity;
import com.sa.modules.shiro.ShiroUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2017/12/18 19:54
 * @Description: 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    private UserDao userDao;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = userDao.queryTotal(params);
        List<UserEntity> userList = userDao.queryList(query);
        return R.ok().put("count", total).put("data", userList);
    }

    /**
     * 返回当前登录用户名
     */
    @RequestMapping("/getUserName")
    public R username() {
        return R.ok().put("name", getUserNname());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/add")
    @RequiresPermissions("user:add")
    public R add(UserEntity user) {

        //sha256加密
        user.setPassword("123456");
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), salt));
        //赋值 创建者 创建时间
        user.setCreateUserId(getUserId());
        user.setCreateTime(getTime());

        if (user.getUsername() != "" && user.getPassword() != "" ) {
        if (userDao.queryByUserName(user.getUsername()) == null){
            userDao.add(user);
        }else {
            return R.error(1,"用户名以及存在");
        } } else {
            return R.error(1,"用户名密码不能为空 请刷新浏览器 重试");
        }
        return R.ok();
    }

    /**
     * 更新用户
     */
    @RequestMapping("/edit")
    @RequiresPermissions("user:edit")
    public R edit(UserEntity user) {

        //赋值
        user.setLockingTime(getTime());

        //判断是否要重置密码
        if (user.getPassword() == "1"){
            userDao.edit(user);
        }else {
            userDao.edit(user);
            //密码重置
            String pas = "123456";
            String salt = RandomStringUtils.randomAlphanumeric(20);
            System.out.println(ShiroUtils.sha256(pas, salt));
            System.out.println(salt);
            userDao.editUserPas(ShiroUtils.sha256(pas, salt),salt,user.getUsername());
        }

        return R.ok();
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:del")
    public R delete(long id) {
        userDao.delete(id);
        return R.ok();
    }

    /**
     * 列出所有用户id和姓名
     */
    @RequestMapping("/queryAllUser")
//    @RequiresPermissions("menu:info")
    public Object info() {
        List<UserEntity> list = userDao.queryAllUser();
        return list;
    }

    /**
     * 修改密码
     */
    @PostMapping("/editUserPas")
    public R editUserPas(String username,String pas, String newpas, String isnewpas) {
        UserEntity user = userDao.queryByUserName(username);

        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, pas);
            subject.login(token);

            if (newpas.equals(isnewpas)){
                //sha256加密
                String salt = RandomStringUtils.randomAlphanumeric(20);
                System.out.println(ShiroUtils.sha256(newpas, salt));
                System.out.println(salt);
                userDao.editUserPas(ShiroUtils.sha256(newpas, salt),salt,username);
            }
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error("原密码不正确");
        }


        return R.ok();
    }

}
