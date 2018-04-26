package com.sa.modules.entity;


import java.util.Date;

public class MiddlewareEntity {

  private long middlewareId;
  private String middlewareName;
  private String middlewareEdition;
  private String middlewareUrl;
  private String middlewareAdmin;
  private String middlewarePas;
  private String middlewareMedium;
  private String middlewareContent;
  private long userId;
  private String userName;
  private long serverId;
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

  public long getServerId() {
    return serverId;
  }

  public void setServerId(long serverId) {
    this.serverId = serverId;
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
