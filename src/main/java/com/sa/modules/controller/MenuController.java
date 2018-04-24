package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.entity.MenuEntity;
import com.sa.modules.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2017/12/17 20:36
 * @Description: 模块管理
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends AbstractController {
    @Autowired
    private MenuService menuService;

    /**
     * 列出导航栏 根据用户角色
     */
    @RequestMapping("/nav")
    public Object nav() {
        List<MenuEntity> menuList = menuService.queryUserMenuList(getUserId());
        return menuList;
    }

    /**
     * 列出所有模块
     */
    @RequestMapping("/list")
//    @RequiresPermissions("menu:list")
    public R list(@RequestParam Map<String, Object> params) {

        //条数和数据
        int total = menuService.queryTotal(params);
        List<MenuEntity> userList = menuService.queryList(params);

        return R.ok().put("count", total).put("data", userList);
    }
}
