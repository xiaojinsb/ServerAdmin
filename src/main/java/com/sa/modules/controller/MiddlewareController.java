package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.MiddlewareDao;
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
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("midd:delete")
    public R delete(long id) {
        middlewareDao.delete(id);
        return R.ok();
    }
}