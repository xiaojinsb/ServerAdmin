package com.sa.modules.entity;


import java.util.Date;

public class DataBaseEntity {

  private long dbId;
  private String dbName;
  private String dbType;
  private String dbAdmin;
  private String dbPas;
  private String dbAddress;
  private String dbTool;
  private String dbContent;
  private long userId;
  private String userName;
  private long serverId;
  private Date createTime;
  private Date updateTime;

  public long getDbId() {
    return dbId;
  }

  public void setDbId(long dbId) {
    this.dbId = dbId;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public String getDbType() {
    return dbType;
  }

  public void setDbType(String dbType) {
    this.dbType = dbType;
  }

  public String getDbAdmin() {
    return dbAdmin;
  }

  public void setDbAdmin(String dbAdmin) {
    this.dbAdmin = dbAdmin;
  }

  public String getDbPas() {
    return dbPas;
  }

  public void setDbPas(String dbPas) {
    this.dbPas = dbPas;
  }

  public String getDbAddress() {
    return dbAddress;
  }

  public void setDbAddress(String dbAddress) {
    this.dbAddress = dbAddress;
  }

  public String getDbTool() {
    return dbTool;
  }

  public void setDbTool(String dbTool) {
    this.dbTool = dbTool;
  }

  public String getDbContent() {
    return dbContent;
  }

  public void setDbContent(String dbContent) {
    this.dbContent = dbContent;
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

  public long getServerId() {
    return serverId;
  }

  public void setServerId(long serverId) {
    this.serverId = serverId;
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
