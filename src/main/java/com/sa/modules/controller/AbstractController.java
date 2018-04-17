package com.sa.modules.controller;

import com.sa.modules.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: moe
 * @Date: 2017/12/17 20:36
 * @Description: Controller公共组件
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected UserEntity getUser() {
		return (UserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected String getUserNname(){
		return getUser().getUsername();
	}
}
