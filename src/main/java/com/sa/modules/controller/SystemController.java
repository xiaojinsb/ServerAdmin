package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.*;
import com.sa.modules.entity.SystemEntity;
import com.wuwenze.poi.ExcelKit;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    /**
     * 列出所有应用
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != 1){
            params.put("orUser",getUserId());
        }
        //查询列表数据
        Query query = new Query(params);

        //条数和数据
        int total = systemDao.queryTotal(params);
        List<SystemEntity> list = systemDao.queryList(query);

        return R.ok().put("count", total).put("data", list);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @RequiresPermissions("sys:add")
    public R add(SystemEntity sys) {

        //赋值运维人员id 创造者 创造时间
        if (sys.getUserName() != ""){
            sys.setUserId(userDao.queryByUserName(sys.getUserName()).getUserId());
        }
        sys.setCreateUserId(getUserId());
        sys.setCreateTime(getTime());

        systemDao.add(sys);
        return R.ok().put("id",sys.getSystemId());
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
    @RequiresPermissions("sys:edit")
    public R edit(SystemEntity sys) {

        //赋值运维人员id 创造者 创造时间
        if (sys.getUserName() != "") {
            sys.setUserId(userDao.queryByUserName(sys.getUserName()).getUserId());
        }
        sys.setUpdateTime(getTime());

        systemDao.edit(sys);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:del")
    public R delete(long id) {
        systemDao.delete(id);
        return R.ok();
    }

    /**
     * 列出所有查询到的服务器
     */
    @RequestMapping("/queryAllsys")
    public Object info(long[] id) {
        List<SystemEntity> list = systemDao.queryAllsys(id);
        return R.ok().put("data", list);
    }

    /**
     * 根据所在服务器查询
     */
    @RequestMapping("/queryByServerAll")
    public Object queryByServerAll(long id) {
        List<SystemEntity> list = systemDao.queryByQuoteAll(id,1);
        return R.ok().put("data", list);
    }

    /**
     * 导出excel
     */
    @RequestMapping("/excel")
    @RequiresPermissions("sys:excel")
    public void excel(HttpServletResponse response, long[] id){

        List<SystemEntity> list = new ArrayList<SystemEntity>();
        if (id[0]==0){
            list = systemDao.queryAll();
        }else {
            list = systemDao.queryAllsys(id);
        }

        // 生成Excel并使用浏览器下载
        ExcelKit.$Export(SystemEntity.class, response).toExcel(list, "应用系统");
    }
}
