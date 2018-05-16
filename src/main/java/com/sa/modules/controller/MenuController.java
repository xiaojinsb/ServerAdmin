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
    @RequiresPermissions("menu:list")
    public R list(@RequestParam Map<String, Object> params) {
        //条数和数据
        int total = menuService.queryTotal(params);
        List<MenuEntity> list = menuService.queryList(params);

        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增模块
     */
    @RequestMapping("/add")
    @RequiresPermissions("menu:add")
    public R add(MenuEntity menuEntity) {
        //赋值创造者 创造时间
        menuEntity.setCreateUserID(getUserId());
        menuEntity.setCreateTime(getTime());

        if (menuEntity.getType() == 0){
            long parentId = 0;
            menuEntity.setParentId(parentId);
        }

        //根据名字查询信息 看是否存在
        MenuEntity ismenu = menuService.queryByMenuName(menuEntity.getMenuName());

        if (ismenu == null){
            menuService.add(menuEntity);
        }else {
            return R.error("模块已经存在");
        }
        return R.ok();
    }
    /**
     * 更新角色
     */
    @RequestMapping("/edit")
    @RequiresPermissions("menu:edit")
    public R edit(MenuEntity menuEntity) {

        //根据名字查询信息 看是否存在
        MenuEntity ismenu = menuService.queryByMenuName(menuEntity.getMenuName());

        //如果为空 那就是目录
        if (menuEntity.getParentId() == null){
            long id = 0;
            menuEntity.setParentId(id);
        }

        if (ismenu == null){
            menuService.edit(menuEntity);
        }else {
            if (ismenu.getMenuId().equals(menuEntity.getMenuId()) ){
                menuService.edit(menuEntity);
            }else {
                return R.error("模块已经存在");
            }
        }
        return R.ok();
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    @RequiresPermissions("menu:del")
    public R delete(long id) {
        menuService.delete(id);
        return R.ok();
    }

    /**
     * 列出指定类型目录
     */
    @RequestMapping("/catalog")
//    @RequiresPermissions("menu:info")
    public Object info(Integer type) {
        List<MenuEntity> menuList = menuService.queryAllCatalog(type);
        return menuList;
    }

    /**
     * 列出所有模块 无权限
     */
    @RequestMapping("/menuAllList")
    public R menuAllList() {

        List<MenuEntity> list = menuService.menuAllList();

        return R.ok().put("data", list);
    }
}
