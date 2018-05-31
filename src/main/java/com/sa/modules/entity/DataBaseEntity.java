package com.sa.modules.entity;


import com.wuwenze.poi.annotation.ExportConfig;

import java.util.Date;

public class DataBaseEntity {

  private long dbId;
  @ExportConfig("数据库名")
  private String dbName;
  @ExportConfig("数据库类型")
  private String dbType;
  @ExportConfig("ip地址")
  private String dbIp;
  @ExportConfig("数据库安装路径")
  private String dbAddress;
  @ExportConfig("数据库连接工具")
  private String dbTool;
  @ExportConfig("数据库管理账号")
  private String dbAdmin;
  @ExportConfig("数据库管理密码")
  private String dbPas;
  @ExportConfig("数据库备注")
  private String dbContent;
  private long userId;
  @ExportConfig("运维人员")
  private String userName;
  private String serverId;
  @ExportConfig("服务器")
  private String serverName;
  private long createUserId;
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

  public String getDbIp() {
    return dbIp;
  }

  public void setDbIp(String dbIp) {
    this.dbIp = dbIp;
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
    return "DataBaseEntity{" +
            "dbId=" + dbId +
            ", dbName='" + dbName + '\'' +
            ", dbType='" + dbType + '\'' +
            ", dbIp='" + dbIp + '\'' +
            ", dbAddress='" + dbAddress + '\'' +
            ", dbTool='" + dbTool + '\'' +
            ", dbAdmin='" + dbAdmin + '\'' +
            ", dbPas='" + dbPas + '\'' +
            ", dbContent='" + dbContent + '\'' +
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
