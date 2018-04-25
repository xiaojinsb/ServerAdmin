package com.sa.modules.serviceimpl;

import com.sa.modules.dao.MenuDao;

import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.MenuEntity;
import com.sa.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 模块实现类
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<MenuEntity> queryUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if(userId == 1){
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = userDao.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }


    /**
     * 获取所有菜单列表
     */
    private List<MenuEntity> getAllMenuList(List<Long> menuIdList){
        //查询根菜单列表
        List<MenuEntity> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<MenuEntity> getMenuTreeList(List<MenuEntity> menuList, List<Long> menuIdList){
        List<MenuEntity> subMenuList = new ArrayList<MenuEntity>();

        for(MenuEntity entity : menuList){
            if(entity.getType() == 0){//目录
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }

//    根据父菜单，查询子菜单

    @Override
    public List<MenuEntity> queryListParentId(Long parentId) {
        return menuDao.queryListParentId(parentId);
    }

    @Override
    public List<MenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<MenuEntity> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<MenuEntity> userMenuList = new ArrayList<>();
        for(MenuEntity menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<MenuEntity> queryList(Map<String, Object> map) {
        return menuDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return menuDao.queryTotal(map);
    }

    @Override
    public List<MenuEntity> queryAllCatalog(Integer type) {
        return menuDao.queryAllCatalog(type);
    }

    @Override
    public void add(MenuEntity menuEntity) {
        menuDao.add(menuEntity);
    }

    @Override
    public int edit(MenuEntity menuEntity) {
        return menuDao.edit(menuEntity);
    }

    @Override
    public int delete(long id) {
        return menuDao.delete(id);
    }
}
