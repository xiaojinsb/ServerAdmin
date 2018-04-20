package com.sa.modules.entity;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户角色实体类
 */
public class UserRoleEntity {
	
	private Long urId;
	private Long userId;
	private Long roleId;

	public Long getUrId() {
		return urId;
	}

	public void setUrId(Long urId) {
		this.urId = urId;
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
}
