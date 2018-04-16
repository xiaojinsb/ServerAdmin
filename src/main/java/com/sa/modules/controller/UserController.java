package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.entity.UserEntity;
import com.sa.modules.service.UserRoleService;
import com.sa.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
//    @RequiresPermissions("user:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        //条数和数据
        int total = userService.queryTotal(params);
        List<UserEntity> userList = userService.queryList(query);


        return R.ok().put("count", total).put("data", userList);
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info() {
        return R.ok().put("user", getUser());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/add")
//    @RequiresPermissions("sys:user:add")
    public R add(UserEntity user) {
        user.setCreateUserId(getUserId());

        userService.add(user);
        return R.ok();
    }

    /**
     * 更新用户
     */
    @RequestMapping("/update")
//    @RequiresPermissions("sys:user:update")
    public R update(UserEntity user, Integer status1) {

        user.setStatus(status1);
        userService.update(user);

        //获取角色关联权限 用户id
        List<Long> roleList = user.getRoleIdList();
        long userId = user.getUserId();

        //先删除
        userRoleService.delete(userId);

        //再更新
        userRoleService.saveOrUpdate(userId, roleList);

        return R.ok();
    }

    /**
     * 列出用户拥有的权限
     */
    @RequestMapping("/userRoleList")
//    @RequiresPermissions("role:info")
    public R userRoleList1(Integer id) {
        List<Integer> roleList = userService.userRoleList(id);
        return R.ok().put("roleList", roleList);
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("sys:user:delete")
    public R delete(long id) {

        userService.delete(id);

        return R.ok();
    }

    //返回用户名
    @RequestMapping("/username")
//    @RequiresPermissions("sys:user:delete")
    public R username() {
        return R.ok().put("name",getUserNname());
    }

}
