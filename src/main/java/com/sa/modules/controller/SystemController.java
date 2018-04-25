package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.SystemDao;
import com.sa.modules.entity.SystemEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 应用系统管理
 */
@RestController
@RequestMapping("/sys")
public class SystemController extends AbstractController {
    @Autowired
    private SystemDao systemDao;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
//    @RequiresPermissions("sys:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = systemDao.queryTotal(params);
        List<SystemEntity> list = systemDao.queryList(query);
        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("sys:delete")
    public R delete(long id) {
        systemDao.delete(id);
        return R.ok();
    }
}