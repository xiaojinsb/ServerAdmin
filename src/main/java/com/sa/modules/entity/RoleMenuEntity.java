package com.sa.modules.entity;



/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 角色模块实体类
 */
public class RoleMenuEntity{

	private Long rmId;
	private Long roleId;
	private Long menuId;

	public Long getRmId() {
		return rmId;
	}

	public void setRmId(Long rmId) {
		this.rmId = rmId;
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
}
