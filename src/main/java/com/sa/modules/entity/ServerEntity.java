package com.sa.modules.entity;

import com.wuwenze.poi.annotation.ExportConfig;

import java.util.Date;

public class ServerEntity {


  private long serverId;
  @ExportConfig("服务器名")
  private String serverName;
  @ExportConfig("网络情况")
  private String serNet;
  @ExportConfig("部署情况")
  private String depSituation;
  @ExportConfig("设备类型")
  private String type;
  @ExportConfig("设备型号")
  private String model;
  @ExportConfig("机房位置")
  private String generator;
  @ExportConfig("楼层房间号")
  private String houseHumber;
  @ExportConfig("机柜位置编号")
  private String cabinetHumber;
  @ExportConfig("机柜")
  private String cabinet;
  @ExportConfig("设备资产编号")
  private String propertyNumber;
  @ExportConfig("设备购买时间")
  private String equipmentBuyTime;
  @ExportConfig("设备年限")
  private String equipmentAgeLimit;
  @ExportConfig("设备领料人")
  private String leader;
  @ExportConfig("硬件主要配置")
  private String hardwareConfiguration;
  @ExportConfig("操作系统")
  private String os;
  @ExportConfig("计算机名称")
  private String pcName;
  @ExportConfig("ip地址")
  private String serverIp;
  @ExportConfig("服务器管理账号")
  private String serverAdmin;
  @ExportConfig("服务器管理密码")
  private String serverPas;
  @ExportConfig("杀毒软件及安装位置")
  private String shaduSoft;
  @ExportConfig("系统初始配置")
  private String beginConfig;
  @ExportConfig("备注相关信息")
  private String serverContent;
  @ExportConfig("管理口")
  private String managementPort;
  private long userId;
  @ExportConfig("运维人员")
  private String userName;
  private long createUserId;
  private Date createTime;
  private Date updateTime;

  public long getServerId() {
    return serverId;
  }

  public void setServerId(long serverId) {
    this.serverId = serverId;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public String getSerNet() {
    return serNet;
  }

  public void setSerNet(String serNet) {
    this.serNet = serNet;
  }

  public String getDepSituation() {
    return depSituation;
  }

  public void setDepSituation(String depSituation) {
    this.depSituation = depSituation;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }

  public String getHouseHumber() {
    return houseHumber;
  }

  public void setHouseHumber(String houseHumber) {
    this.houseHumber = houseHumber;
  }

  public String getCabinetHumber() {
    return cabinetHumber;
  }

  public void setCabinetHumber(String cabinetHumber) {
    this.cabinetHumber = cabinetHumber;
  }

  public String getCabinet() {
    return cabinet;
  }

  public void setCabinet(String cabinet) {
    this.cabinet = cabinet;
  }

  public String getPropertyNumber() {
    return propertyNumber;
  }

  public void setPropertyNumber(String propertyNumber) {
    this.propertyNumber = propertyNumber;
  }

  public String getEquipmentBuyTime() {
    return equipmentBuyTime;
  }

  public void setEquipmentBuyTime(String equipmentBuyTime) {
    this.equipmentBuyTime = equipmentBuyTime;
  }

  public String getEquipmentAgeLimit() {
    return equipmentAgeLimit;
  }

  public void setEquipmentAgeLimit(String equipmentAgeLimit) {
    this.equipmentAgeLimit = equipmentAgeLimit;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public String getHardwareConfiguration() {
    return hardwareConfiguration;
  }

  public void setHardwareConfiguration(String hardwareConfiguration) {
    this.hardwareConfiguration = hardwareConfiguration;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getPcName() {
    return pcName;
  }

  public void setPcName(String pcName) {
    this.pcName = pcName;
  }

  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }

  public String getServerAdmin() {
    return serverAdmin;
  }

  public void setServerAdmin(String serverAdmin) {
    this.serverAdmin = serverAdmin;
  }

  public String getServerPas() {
    return serverPas;
  }

  public void setServerPas(String serverPas) {
    this.serverPas = serverPas;
  }

  public String getShaduSoft() {
    return shaduSoft;
  }

  public void setShaduSoft(String shaduSoft) {
    this.shaduSoft = shaduSoft;
  }

  public String getBeginConfig() {
    return beginConfig;
  }

  public void setBeginConfig(String beginConfig) {
    this.beginConfig = beginConfig;
  }

  public String getServerContent() {
    return serverContent;
  }

  public void setServerContent(String serverContent) {
    this.serverContent = serverContent;
  }

  public String getManagementPort() {
    return managementPort;
  }

  public void setManagementPort(String managementPort) {
    this.managementPort = managementPort;
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
