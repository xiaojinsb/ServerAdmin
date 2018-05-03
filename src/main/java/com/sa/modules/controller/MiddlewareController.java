package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.MiddlewareDao;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.MiddlewareEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 中间件管理
 */
@RestController
@RequestMapping("/midd")
public class MiddlewareController extends AbstractController {
    @Autowired
    private MiddlewareDao middlewareDao;
    @Autowired
    private UserDao userDao;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
//    @RequiresPermissions("midd:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = middlewareDao.queryTotal(params);
        List<MiddlewareEntity> list = middlewareDao.queryList(query);
        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
//    @RequiresPermissions("midd:add")
    public R add(MiddlewareEntity midd) {

        //赋值运维人员id 创造者 创造时间
        if (midd.getUserName() != "")
            midd.setUserId(userDao.queryByUserName(midd.getUserName()).getUserId());
        midd.setCreateUserId(getUserId());
        midd.setCreateTime(getTime());

        middlewareDao.add(midd);
        return R.ok();
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
//    @RequiresPermissions("midd:edit")
    public R edit(MiddlewareEntity midd) {

        middlewareDao.edit(midd);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("midd:delete")
    public R delete(long id) {
        middlewareDao.delete(id);
        return R.ok();
    }

    /**
     * 列出所有查询到的服务器
     */
    @RequestMapping("/queryAllMidd")
    public Object info(long[] id) {
        List<MiddlewareEntity> list = middlewareDao.queryAllMidd(id);
        return R.ok().put("data", list);
    }
}
