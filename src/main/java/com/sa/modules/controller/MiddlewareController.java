package com.sa.modules.controller;

import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.dao.MiddlewareDao;
import com.sa.modules.dao.SystemDao;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.MiddlewareEntity;
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
 * @Description: 中间件管理
 */
@RestController
@RequestMapping("/midd")
public class MiddlewareController extends AbstractController {
    @Autowired
    private MiddlewareDao middlewareDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SystemDao systemDao;

    /**
     * 列出所有中间件
     */
    @RequestMapping("/list")
    @RequiresPermissions("midd:list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != 1){
            params.put("orUser",getUserId());
        }
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
    @RequiresPermissions("midd:add")
    public R add(MiddlewareEntity midd) {

        //赋值运维人员id 创造者 创造时间
        if (midd.getUserName() != "")
            midd.setUserId(userDao.queryByUserName(midd.getUserName()).getUserId());
        midd.setCreateUserId(getUserId());
        midd.setCreateTime(getTime());

        middlewareDao.add(midd);
        return R.ok().put("id",midd.getMiddlewareId());
    }

    /**
     * 更新
     */
    @RequestMapping("/edit")
    @RequiresPermissions("midd:edit")
    public R edit(MiddlewareEntity midd) {

        middlewareDao.edit(midd);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("midd:del")
    public R delete(long id) {
        List<SystemEntity> slist= systemDao.queryByQuoteAll(id,3);
        if (slist.size() != 0){
            return R.error("这台中间件被应用引用了 无法删除");
        }else {
            middlewareDao.delete(id);
        }
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

    /**
     * 根据所在服务器查询
     */
    @RequestMapping("/queryByServerAll")
    public Object queryByServerAll(long id) {
        List<MiddlewareEntity> list = middlewareDao.queryByServerAll(id);
        return R.ok().put("data", list);
    }

    /**
     * 导出excel
     */
    @RequestMapping("/excel")
    @RequiresPermissions("midd:excel")
    public void excel(HttpServletResponse response, long[] id){

        List<MiddlewareEntity> list = new ArrayList<MiddlewareEntity>();
        if (id[0]==0){
            list = middlewareDao.queryAll();
        }else {
            list = middlewareDao.queryAllMidd(id);
        }

        // 生成Excel并使用浏览器下载
        ExcelKit.$Export(MiddlewareEntity.class, response).toExcel(list, "中间件");
    }
}
