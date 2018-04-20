package com.sa.modules.entity;

import java.util.Date;
import java.util.List;

/**
 * @Author: moe
 * @Date: 2018/04/17
 * @Description: 用户实体类
 */
public class UserEntity{

  private long userId;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String mobile;
  private Integer status;
  private List<Long> roleIdList;
  private long createUserId;
  private Date createTime;
  private Date lastLoginTime;
  private Date lockingTime;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public List<Long> getRoleIdList() {
    return roleIdList;
  }

  public void setRoleIdList(List<Long> roleIdList) {
    this.roleIdList = roleIdList;
  }

  public long getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(long createUserId) {
    this.createUserId = createUserId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public Date getLockingTime() {
    return lockingTime;
  }

  public void setLockingTime(Date lockingTime) {
    this.lockingTime = lockingTime;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
            "userId=" + userId +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", email='" + email + '\'' +
            ", mobile='" + mobile + '\'' +
            ", status=" + status +
            ", roleIdList=" + roleIdList +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
            ", lastLoginTime=" + lastLoginTime +
            ", lockingTime=" + lockingTime +
            '}';
  }
}
