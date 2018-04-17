package com.sa.modules.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.sa.common.utils.Query;
import com.sa.common.utils.R;
import com.sa.modules.entity.UserEntity;
import com.sa.modules.service.UserRoleService;
import com.sa.modules.service.UserService;
import com.sa.modules.shiro.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: moe
 * @Date: 2017/12/18 19:54
 * @Description: 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列出所有用户
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //条数和数据
        int total = userService.queryTotal(params);
        List<UserEntity> userList = userService.queryList(query);
        return R.ok().put("count", total).put("data", userList);
    }

    /**
     * 新增用户
     */
    @RequestMapping("/add")
    @RequiresPermissions("sys:user:add")
    public R add(UserEntity user) {
        user.setCreateUserId(getUserId());

        userService.add(user);
        return R.ok();
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:update")
    public R update(UserEntity user, Integer status1) {

        user.setStatus(status1);
        userService.update(user);

        //获取角色关联权限 用户id
        List<Long> roleList = user.getRoleIdList();
        long userId = user.getUserId();

        //先删除
        userRoleService.delete(userId);

        //再更新
        userRoleService.saveOrUpdate(userId, roleList);

        return R.ok();
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info() {
        return R.ok().put("user", getUser());
    }

    /**
     * 列出用户拥有的权限
     */
    @RequestMapping("/userRoleList")
    public R userRoleList1(Integer id) {
        List<Integer> roleList = userService.userRoleList(id);
        return R.ok().put("roleList", roleList);
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:delete")
    public R delete(long id) {
        userService.delete(id);
        return R.ok();
    }

    /**
     * 返回用户名
     */
    @RequestMapping("/username")
    public R username() {
        return R.ok().put("name", getUserNname());
    }


    @Autowired
    private Producer producer;

    @RequestMapping("captcha")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public R login(String username, String password, String captcha) throws IOException {
//        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//        if(!captcha.equalsIgnoreCase(kaptcha)){
//            return R.error("验证码不正确");
//        }
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error("账号或密码不正确");
        } catch (LockedAccountException e) {
            return R.error("账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }
}
