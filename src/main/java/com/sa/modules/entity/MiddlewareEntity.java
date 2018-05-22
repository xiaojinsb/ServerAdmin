package com.sa.modules.entity;


import com.wuwenze.poi.annotation.ExportConfig;

import java.util.Date;

public class MiddlewareEntity {

  private long middlewareId;
  @ExportConfig("中间件名")
  private String middlewareName;
  @ExportConfig("中间件版本")
  private String middlewareEdition;
  @ExportConfig("中间件管理地址")
  private String middlewareUrl;
  @ExportConfig("中间件安装地址")
  private String middlewareInstallUrl;
  @ExportConfig("中间件管理账号")
  private String middlewareAdmin;
  @ExportConfig("中间件管理密码")
  private String middlewarePas;
  @ExportConfig("中间件介质位置")
  private String middlewareMedium;
  @ExportConfig("中间件备注")
  private String middlewareContent;
  private long userId;
  @ExportConfig("运维人员")
  private String userName;
  private String serverId;
  @ExportConfig("服务器")
  private String serverName;
  private long createUserId;
  private Date createTime;
  private Date updateTime;

  public long getMiddlewareId() {
    return middlewareId;
  }

  public void setMiddlewareId(long middlewareId) {
    this.middlewareId = middlewareId;
  }

  public String getMiddlewareName() {
    return middlewareName;
  }

  public void setMiddlewareName(String middlewareName) {
    this.middlewareName = middlewareName;
  }

  public String getMiddlewareEdition() {
    return middlewareEdition;
  }

  public void setMiddlewareEdition(String middlewareEdition) {
    this.middlewareEdition = middlewareEdition;
  }

  public String getMiddlewareUrl() {
    return middlewareUrl;
  }

  public void setMiddlewareUrl(String middlewareUrl) {
    this.middlewareUrl = middlewareUrl;
  }

  public String getMiddlewareInstallUrl() {
    return middlewareInstallUrl;
  }

  public void setMiddlewareInstallUrl(String middlewareInstallUrl) {
    this.middlewareInstallUrl = middlewareInstallUrl;
  }

  public String getMiddlewareAdmin() {
    return middlewareAdmin;
  }

  public void setMiddlewareAdmin(String middlewareAdmin) {
    this.middlewareAdmin = middlewareAdmin;
  }

  public String getMiddlewarePas() {
    return middlewarePas;
  }

  public void setMiddlewarePas(String middlewarePas) {
    this.middlewarePas = middlewarePas;
  }

  public String getMiddlewareMedium() {
    return middlewareMedium;
  }

  public void setMiddlewareMedium(String middlewareMedium) {
    this.middlewareMedium = middlewareMedium;
  }

  public String getMiddlewareContent() {
    return middlewareContent;
  }

  public void setMiddlewareContent(String middlewareContent) {
    this.middlewareContent = middlewareContent;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getServerId() {
    return serverId;
  }

  public void setServerId(String serverId) {
    this.serverId = serverId;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
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

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "MiddlewareEntity{" +
            "middlewareId=" + middlewareId +
            ", middlewareName='" + middlewareName + '\'' +
            ", middlewareEdition='" + middlewareEdition + '\'' +
            ", middlewareUrl='" + middlewareUrl + '\'' +
            ", middlewareInstallUrl='" + middlewareInstallUrl + '\'' +
            ", middlewareAdmin='" + middlewareAdmin + '\'' +
            ", middlewarePas='" + middlewarePas + '\'' +
            ", middlewareMedium='" + middlewareMedium + '\'' +
            ", middlewareContent='" + middlewareContent + '\'' +
            ", userId=" + userId +
            ", userName='" + userName + '\'' +
            ", serverId='" + serverId + '\'' +
            ", serverName='" + serverName + '\'' +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
