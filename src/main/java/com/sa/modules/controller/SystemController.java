package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.*;
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
    @Autowired
    private UserDao userDao;
//    @Autowired
//    private ServerDao serverDao;
//    @Autowired
//    private DataBaseDao dataBaseDao;
//    @Autowired
//    private MiddlewareDao middlewareDao;

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

        //根据服务器id 数据库id 中间件id 得到名字
//        for (int i = 0; i < list.size(); i++) {
//            String sid = list.get(i).getServerId();
//            String did =  list.get(i).getDbId();
//            String mid = list.get(i).getMiddlewareId();
//            String[] sids = sid.split(",");
//            String[] dids = did.split(",");
//            String[] mids = mid.split(",");
//
////            list.get(i).setServerName();
//            System.out.println(serverDao.queryAllServer(sids[i]));
//            System.out.println(sids[i]);
//        }

        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
//    @RequiresPermissions("sys:add")
    public R add(SystemEntity sys) {

        //赋值运维人员id 创造者 创造时间
        if (sys.getUserName() != "")
            sys.setUserId(userDao.queryByUserName(sys.getUserName()).getUserId());
        sys.setCreateUserId(getUserId());
        sys.setCreateTime(getTime());

        systemDao.add(sys);
        return R.ok();
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
//    @RequiresPermissions("sys:edit")
    public R edit(SystemEntity sys) {

        //赋值运维人员id 创造者 创造时间
        if (sys.getUserName() != "")
            sys.setUserId(userDao.queryByUserName(sys.getUserName()).getUserId());
        sys.setUpdateTime(getTime());

        systemDao.edit(sys);
        return R.ok();
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
