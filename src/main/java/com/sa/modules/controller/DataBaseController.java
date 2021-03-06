package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.DataBaseDao;
import com.sa.modules.dao.SystemDao;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.DataBaseEntity;
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
 * @Description: 数据库管理
 */
@RestController
@RequestMapping("/data")
public class DataBaseController extends AbstractController {
    @Autowired
    private DataBaseDao dataBaseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SystemDao systemDao;

    /**
     * 列出所有数据库
     */
    @RequestMapping("/list")
    @RequiresPermissions("data:list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != 1){
            params.put("orUser",getUserId());
        }
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
    @RequiresPermissions("data:add")
    public R add(DataBaseEntity data) {

        //赋值运维人员id 创造者 创造时间
        if (data.getUserName() != "")
            data.setUserId(userDao.queryByUserName(data.getUserName()).getUserId());
        data.setCreateUserId(getUserId());
        data.setCreateTime(getTime());

        dataBaseDao.add(data);
        return R.ok().put("id",data.getDbId());
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
    @RequiresPermissions("data:edit")
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
    @RequiresPermissions("data:del")
    public R delete(long id) {
        List<SystemEntity> slist= systemDao.queryByQuoteAll(id,2);
        if (slist.size() != 0){
            return R.error("这台数据库被应用引用了 无法删除");
        }else {
            dataBaseDao.delete(id);
        }
        return R.ok();
    }

    /**
     * 列出所有查询到的服务器
     */
    @RequestMapping("/queryAllData")
    public Object queryAllData(long[] id) {
        List<DataBaseEntity> list = dataBaseDao.queryAllData(id);
        return R.ok().put("data", list);
    }

    /**
     * 根据所在服务器查询
     */
    @RequestMapping("/queryByServerAll")
    public Object queryByServerAll(long id) {
        List<DataBaseEntity> list = dataBaseDao.queryByServerAll(id);
        return R.ok().put("data", list);
    }

    /**
     * 导出excel
     */
    @RequestMapping("/excel")
    @RequiresPermissions("data:excel")
    public void excel(HttpServletResponse response, long[] id){

        List<DataBaseEntity> list = new ArrayList<DataBaseEntity>();
        if (id[0]==0){
            list = dataBaseDao.queryAll();
        }else {
            list = dataBaseDao.queryAllData(id);
        }

        // 生成Excel并使用浏览器下载
        ExcelKit.$Export(DataBaseEntity.class, response).toExcel(list, "数据库");
    }
}
