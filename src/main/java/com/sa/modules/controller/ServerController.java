package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.*;
import com.sa.modules.entity.DataBaseEntity;
import com.sa.modules.entity.MiddlewareEntity;
import com.sa.modules.entity.ServerEntity;
import com.sa.modules.entity.SystemEntity;
import com.wuwenze.poi.ExcelKit;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
    @Autowired
    private SystemDao systemDao;
    @Autowired
    private DataBaseDao dataBaseDao;
    @Autowired
    private MiddlewareDao middlewareDao;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
    @RequiresPermissions("server:list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != 1){
            params.put("orUser",getUserId());
        }
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = serverDao.queryTotal(params);
        List<ServerEntity> list = serverDao.queryList(query);
        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @RequiresPermissions("server:add")
    public R add(ServerEntity server) {

        //赋值运维人员id 创造者 创造时间
        if (server.getUserName() != "") {
            server.setUserId(userDao.queryByUserName(server.getUserName()).getUserId());
        }
        server.setCreateUserId(getUserId());
        server.setCreateTime(getTime());

        int count = serverDao.add(server);
        return R.ok().put("id",server.getServerId());
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
    @RequiresPermissions("server:edit")
    public R edit(ServerEntity server) {

        //赋值运维人员id 更新时间
        if (server.getUserName() != "")
            server.setUserId(userDao.queryByUserName(server.getUserName()).getUserId());
        server.setUpdateTime(getTime());
        serverDao.edit(server);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("server:del")
    public R delete(long id) {
        List<SystemEntity> slist= systemDao.queryByQuoteAll(id,1);
        List<DataBaseEntity> dlist = dataBaseDao.queryByServerAll(id);
        List<MiddlewareEntity> mlist = middlewareDao.queryByServerAll(id);

        if (slist.size() !=0||dlist.size()!=0||mlist.size()!=0){
            return R.error("这台服务器被引用了 无法删除");
        }else {
            serverDao.delete(id);
        }

        return R.ok();
    }

    /**
     * 列出所有查询到的服务器
     */
    @RequestMapping("/queryAllServer")
    public Object info(long[] id) {
        List<ServerEntity> list = serverDao.queryAllServer(id);
        return R.ok().put("data", list);
    }


    /**
     * 导出excel
     */
    @RequestMapping("/excel")
    @RequiresPermissions("server:excel")
    public void excel(HttpServletResponse response,long[] id){

        List<ServerEntity> list = new ArrayList<ServerEntity>();
        if (id[0]==0){
            list = serverDao.queryAll();
        }else {
            list = serverDao.queryAllServer(id);
        }

        // 生成Excel并使用浏览器下载
        ExcelKit.$Export(ServerEntity.class, response).toExcel(list, "服务器");
    }

}
