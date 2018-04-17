package com.sa.modules.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 角色模块实体类
 */
public class RoleMenuEntity implements Serializable {

	private Long id;
	private Long roleId;
	private Long menuId;
	private Long createUserId;
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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
