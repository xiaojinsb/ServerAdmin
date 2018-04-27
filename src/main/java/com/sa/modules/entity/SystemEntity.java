package com.sa.modules.entity;


import java.util.Date;

public class SystemEntity {

  private long systemId;
  private String systemName;
  private String systemIp;
  private String systemDomain;
  private String systemUrl;
  private String systemAdmin;
  private String systemPas;
  private String systemDeployment;
  private long userId;
  private String userName;
  private String serverId;
  private String serverName;
  private String dbId;
  private String dbName;
  private String middlewareId;
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
}
