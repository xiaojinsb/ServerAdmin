package com.sa.modules.entity;


import com.wuwenze.poi.annotation.ExportConfig;

import java.util.Date;

public class SystemEntity {

  private long systemId;
  @ExportConfig("应用系统名")
  private String systemName;
  @ExportConfig("应用系统ip")
  private String systemIp;
  @ExportConfig("应用系统域名")
  private String systemDomain;
  @ExportConfig("应用系统管理地址")
  private String systemUrl;
  @ExportConfig("应用系统管理账号")
  private String systemAdmin;
  @ExportConfig("应用系统管理密码")
  private String systemPas;
  @ExportConfig("应用系统部署情况")
  private String systemDeployment;
  private long userId;
  @ExportConfig("运维人员")
  private String userName;
  private String serverId;
  @ExportConfig("服务器")
  private String serverName;
  private String dbId;
  @ExportConfig("数据库")
  private String dbName;
  private String middlewareId;
  @ExportConfig("中间件")
  private String middlewareName;
  private long createUserId;
  private Date createTime;
  private Date updateTime;

  public long getSystemId() {
    return systemId;
  }

  public void setSystemId(long systemId) {
    this.systemId = systemId;
  }

  public String getSystemName() {
    return systemName;
  }

  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }

  public String getSystemIp() {
    return systemIp;
  }

  public void setSystemIp(String systemIp) {
    this.systemIp = systemIp;
  }

  public String getSystemDomain() {
    return systemDomain;
  }

  public void setSystemDomain(String systemDomain) {
    this.systemDomain = systemDomain;
  }

  public String getSystemUrl() {
    return systemUrl;
  }

  public void setSystemUrl(String systemUrl) {
    this.systemUrl = systemUrl;
  }

  public String getSystemAdmin() {
    return systemAdmin;
  }

  public void setSystemAdmin(String systemAdmin) {
    this.systemAdmin = systemAdmin;
  }

  public String getSystemPas() {
    return systemPas;
  }

  public void setSystemPas(String systemPas) {
    this.systemPas = systemPas;
  }

  public String getSystemDeployment() {
    return systemDeployment;
  }

  public void setSystemDeployment(String systemDeployment) {
    this.systemDeployment = systemDeployment;
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

  public String getDbId() {
    return dbId;
  }

  public void setDbId(String dbId) {
    this.dbId = dbId;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public String getMiddlewareId() {
    return middlewareId;
  }

  public void setMiddlewareId(String middlewareId) {
    this.middlewareId = middlewareId;
  }

  public String getMiddlewareName() {
    return middlewareName;
  }

  public void setMiddlewareName(String middlewareName) {
    this.middlewareName = middlewareName;
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
    return "SystemEntity{" +
            "systemId=" + systemId +
            ", systemName='" + systemName + '\'' +
            ", systemIp='" + systemIp + '\'' +
            ", systemDomain='" + systemDomain + '\'' +
            ", systemUrl='" + systemUrl + '\'' +
            ", systemAdmin='" + systemAdmin + '\'' +
            ", systemPas='" + systemPas + '\'' +
            ", systemDeployment='" + systemDeployment + '\'' +
            ", userId=" + userId +
            ", userName='" + userName + '\'' +
            ", serverId='" + serverId + '\'' +
            ", serverName='" + serverName + '\'' +
            ", dbId='" + dbId + '\'' +
            ", dbName='" + dbName + '\'' +
            ", middlewareId='" + middlewareId + '\'' +
            ", middlewareName='" + middlewareName + '\'' +
            ", createUserId=" + createUserId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
