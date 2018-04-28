package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.DataBaseDao;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.DataBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2018/04/25
 * @Description: 数据库管理
 */
@RestController
@RequestMapping("/data")
public class DataBaseController extends AbstractController {
    @Autowired
    private DataBaseDao dataBaseDao;
    @Autowired
    private UserDao userDao;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
//    @RequiresPermissions("data:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = dataBaseDao.queryTotal(params);
        List<DataBaseEntity> list = dataBaseDao.queryList(query);
        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
//    @RequiresPermissions("data:add")
    public R add(DataBaseEntity data) {

        //赋值运维人员id 创造者 创造时间
        if (data.getUserName() != "")
            data.setUserId(userDao.queryByUserName(data.getUserName()).getUserId());
        data.setCreateUserId(getUserId());
        data.setCreateTime(getTime());

        dataBaseDao.add(data);
        return R.ok();
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
//    @RequiresPermissions("data:edit")
    public R edit(DataBaseEntity data) {
        //赋值运维人员id 更新时间
        if (data.getUserName() != "")
            data.setUserId(userDao.queryByUserName(data.getUserName()).getUserId());
        data.setUpdateTime(getTime());

        dataBaseDao.edit(data);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("data:delete")
    public R delete(long id) {
        dataBaseDao.delete(id);
        return R.ok();
    }

    /**
     * 列出所有查询到的服务器
     */
    @RequestMapping("/queryAllData")
    public Object info(long[] id) {
        List<DataBaseEntity> list = dataBaseDao.queryAllData(id);
        return R.ok().put("data", list);
    }
}
