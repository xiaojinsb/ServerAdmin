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
        List<MenuEntity> menuList = menuService.getUserMenuList(getUserId());
        return menuList;
    }

    /**
     * 列出所有模块
     */
    @RequestMapping("/list")
    @RequiresPermissions("menu:list")
    public R list(@RequestParam Map<String, Object> params) {

        //查询列表数据
        Query query = new Query(params);

        //条数和数据
        int total = menuService.queryTotal(params);
        List<MenuEntity> userList = menuService.queryList(query);

        return R.ok().put("count", total).put("data", userList);
    }

    /**
     * 新增模块
     */
    @RequestMapping("/add")
    @RequiresPermissions("menu:add")
    public R add(MenuEntity menuEntity) {
        menuService.add(menuEntity);
        return R.ok();
    }

    /**
     * 更新模块
     */
    @RequestMapping("/update")
    @RequiresPermissions("menu:update")
    public R update(MenuEntity menuEntity) {
        menuService.update(menuEntity);
        return R.ok();
    }

    /**
     * 删除模块
     */
    @RequestMapping("/delete")
    @RequiresPermissions("menu:delete")
    public R delete(long id) {
        menuService.delete(id);
        return R.ok();
    }

    /**
     * 列出一级二级菜单
     */
    @RequestMapping("/onetwo")
    public R oneortwoMenu(Integer type) {

        if (type == 0) {
            List<MenuEntity> menulist = menuService.oneMenu();
            return R.ok().put("data", menulist);
        } else if (type == 1) {
            List<MenuEntity> menulist = menuService.twoMenu();
            return R.ok().put("data", menulist);
        }

        return R.ok();
    }

}
