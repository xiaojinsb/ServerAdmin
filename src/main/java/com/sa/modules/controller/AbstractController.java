package com.sa.modules.controller;

import com.sa.modules.entity.UserEntity;
import org.apache.shiro.SecurityUtils;

/**
 * @Author: moe
 * @Date: 2017/12/17 20:36
 * @Description: Controller公共组件
 */
public abstract class AbstractController {

	/**
	 * 从用户实体类中得到当前用户信息
	 */
	protected UserEntity getUser() {
		return (UserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 得到当前登录用户id
	 */
	protected Long getUserId() {
		return getUser().getUserId();
	}

	/**
	 * 得到当前登录用户名字
	 */
	protected String getUserNname(){
		return getUser().getUsername();
	}
}
