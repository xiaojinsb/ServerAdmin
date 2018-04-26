package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.ServerDao;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.ServerEntity;
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
 * @Description: 服务器管理
 */
@RestController
@RequestMapping("/server")
public class ServerController extends AbstractController {

    @Autowired
    private ServerDao serverDao;
    @Autowired
    private UserDao userDao;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
//    @RequiresPermissions("server:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = serverDao.queryTotal(params);
        List<ServerEntity> list = serverDao.queryList(query);
        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增用户
     */
    @RequestMapping("/add")
//    @RequiresPermissions("server:add")
    public R add(ServerEntity server) {

        if (server.getUserName() != "")
            server.setUserId(userDao.queryByUserName(server.getUserName()).getUserId());
        server.setCreateUserId(getUserId());
        server.setCreateTime(getTime());

        serverDao.add(server);
        return R.ok();
    }

    /**
     * 更新用户
     */
    @RequestMapping("/edit")
//    @RequiresPermissions("server:edit")
    public R edit(ServerEntity server) {

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("server:delete")
    public R delete(long id) {
        serverDao.delete(id);
        return R.ok();
    }
}
