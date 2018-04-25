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
  private long dbId;
  private long middlewareId;
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

  public long getDbId() {
    return dbId;
  }

  public void setDbId(long dbId) {
    this.dbId = dbId;
  }

  public long getMiddlewareId() {
    return middlewareId;
  }

  public void setMiddlewareId(long middlewareId) {
    this.middlewareId = middlewareId;
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
