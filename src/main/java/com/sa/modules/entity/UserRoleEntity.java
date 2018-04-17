package com.sa.modules.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户角色实体类
 */
public class UserRoleEntity implements Serializable {
	
	private Long id;
	private Long userId;
	private Long roleId;
	private Long createUserId;
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
