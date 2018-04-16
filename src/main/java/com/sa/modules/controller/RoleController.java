package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.entity.RoleEntity;
import com.sa.modules.service.RoleMenuService;
import com.sa.modules.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2017/12/18 19:54
 * @Description: 角色管理
 */
@RestController
@RequestMapping("/role")
public class RoleController extends AbstractController{

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 列出所有角色
     */
    @RequestMapping("/list")
//    @RequiresPermissions("role:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        //条数和数据
        int total = roleService.queryTotal(params);
        List<RoleEntity> userList = roleService.queryList(query);


        return R.ok().put("count",total).put("data", userList);
    }

    /**
     * 列出角色拥有的权限
     */
    @RequestMapping("/info")
//    @RequiresPermissions("role:info")
    public R info(Integer id) {
        List<Integer> roleList = roleService.roleQueryList(id);
        return R.ok().put("roleList",roleList);
    }


    /**
     * 新建角色
     */
    @RequestMapping("/add")
//    @RequiresPermissions("role:add")
    public R add(RoleEntity roleEntity) {

        //获取时间，角色关联，角色名，创建人id
        roleEntity.setCreateTime(new Date());
        List<Long> menuIdList = roleEntity.getMenuIdList();
        String rolename = roleEntity.getRoleName();
        roleEntity.setCreateUserId(getUserId());

        System.out.println("新建的角色权限>>"+menuIdList);
        System.out.println("新建的角色name>>"+rolename);

        if (roleService.queryByRoleName(rolename) == null){
            roleService.add(roleEntity);
            //加入角色关联
            roleMenuService.saveOrUpdate(roleService.queryByRoleName(rolename).getRoleId(),menuIdList);
        }else {
            return R.error("角色已经存在");
        }

        return R.ok();
    }

    /**
     * 修改角色
     */
    @RequestMapping("/update")
//    @RequiresPermissions("role:update")
    public R update(RoleEntity roleEntity) {

        //角色关联，角色名，角色id
        List<Long> menuIdList = roleEntity.getMenuIdList();

        roleService.update(roleEntity);

        //删除之前角色的关联
        roleMenuService.delete(roleEntity.getRoleId());

        //加入角色关联
        roleMenuService.saveOrUpdate(roleEntity.getRoleId(),menuIdList);

        return R.ok();
    }

    /**
     * 删除角色
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("sys:user:delete")
    public R delete(long id) {

        roleService.delete(id);

        return R.ok();
    }



}
