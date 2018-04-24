package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.RoleDao;
import com.sa.modules.entity.RoleEntity;
import com.sa.modules.service.RoleMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private RoleDao roleDao;
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
        int total = roleDao.queryTotal(params);
        List<RoleEntity> userList = roleDao.queryList(query);

        return R.ok().put("count",total).put("data", userList);
    }

    /**
     * 新建角色
     */
    @RequestMapping("/add")
//    @RequiresPermissions("role:add")
    public R add(RoleEntity roleEntity) {

        //获取时间，角色关联，角色名，创建人id
        roleEntity.setCreateTime(getTime());
        List<Long> menuIdList = roleEntity.getMenuIdList();
        String roleName = roleEntity.getRoleName();
        roleEntity.setCreateUserId(getUserId());

        System.out.println("新建的角色权限>>"+menuIdList);
        System.out.println("新建的角色name>>"+roleName);

        if (roleDao.queryByRoleName(roleName) == null){
            roleDao.add(roleEntity);
            //加入角色关联
            roleMenuService.saveOrUpdate(roleDao.queryByRoleName(roleName).getRoleId(),menuIdList);
        }else {
            return R.error("角色已经存在");
        }

        return R.ok();
    }
}
