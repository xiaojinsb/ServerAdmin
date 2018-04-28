/*
Navicat MySQL Data Transfer

Source Server         : moe
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : server_admin

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-04-28 18:03:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sa_data_base
-- ----------------------------
DROP TABLE IF EXISTS `sa_data_base`;
CREATE TABLE `sa_data_base` (
  `db_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `db_name` varchar(50) DEFAULT NULL COMMENT '数据库名',
  `db_type` varchar(50) DEFAULT NULL COMMENT '数据库类型',
  `db_ip` varchar(50) DEFAULT NULL COMMENT '数据库id',
  `db_address` varchar(50) DEFAULT NULL COMMENT '数据库安装路径',
  `db_tool` varchar(50) DEFAULT NULL COMMENT '数据库连接工具',
  `db_admin` varchar(50) DEFAULT NULL COMMENT '数据库管理账号',
  `db_pas` varchar(50) DEFAULT NULL COMMENT '数据库管理密码',
  `db_content` varchar(1000) DEFAULT NULL COMMENT '数据库备注',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '运维名',
  `server_id` varchar(50) DEFAULT NULL COMMENT '服务器id',
  `server_name` varchar(255) DEFAULT NULL COMMENT '服务器名',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '数据库创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '数据库修改时间',
  PRIMARY KEY (`db_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='数据库管理';

-- ----------------------------
-- Records of sa_data_base
-- ----------------------------
INSERT INTO `sa_data_base` VALUES ('8', '132', '', '', '123', '', '', '', '', '0', '', '', '', '1', '2018-04-27 10:00:29', null);
INSERT INTO `sa_data_base` VALUES ('6', '1', 'Oracle', '3', null, '4', '5', '6', '7', '2', 'one', null, '2', '1', '2018-04-27 09:49:16', null);
INSERT INTO `sa_data_base` VALUES ('7', '123', '', '', '', '', '', '', '', '0', '', '19', '213', '1', '2018-04-27 10:00:10', null);
INSERT INTO `sa_data_base` VALUES ('9', '213', 'Oracle', '123', '123', '132', '123', '123', '123', '2', 'one', '19', '213', '1', '2018-04-27 10:06:32', '2018-04-27 10:09:16');

-- ----------------------------
-- Table structure for sa_menu
-- ----------------------------
DROP TABLE IF EXISTS `sa_menu`;
CREATE TABLE `sa_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父模块ID，一级模块为0',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '模块名称',
  `url` varchar(200) DEFAULT NULL COMMENT '模块URL',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：权限',
  `icon` varchar(50) DEFAULT NULL COMMENT '模块图标',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `menu_name` (`menu_name`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='模块管理';

-- ----------------------------
-- Records of sa_menu
-- ----------------------------
INSERT INTO `sa_menu` VALUES ('1', '0', '系统管理', '', '0', 'fa fa-gear', '1', '2018-04-17 11:45:38');
INSERT INTO `sa_menu` VALUES ('2', '1', '用户管理', 'son/sys/user.html', '1', 'fa fa-users', '1', '2018-04-17 13:49:22');
INSERT INTO `sa_menu` VALUES ('3', '1', '角色管理', 'son/sys/role.html', '1', 'fa fa-user-secret', '1', '2018-04-17 13:49:26');
INSERT INTO `sa_menu` VALUES ('4', '1', '模块管理', 'son/sys/menu.html', '1', 'fa fa-th-list', '1', '2018-04-17 13:49:28');
INSERT INTO `sa_menu` VALUES ('5', '0', '基础管理', '', '0', 'fa fa-cogs', '1', '2018-04-17 15:19:29');
INSERT INTO `sa_menu` VALUES ('6', '5', '服务器管理', 'son/server/server.html', '1', 'fa fa-cloud', '1', '2018-04-17 15:19:32');
INSERT INTO `sa_menu` VALUES ('7', '5', '应用系统管理', 'son/server/system.html', '1', 'fa fa-desktop', '1', '2018-04-17 15:19:34');
INSERT INTO `sa_menu` VALUES ('8', '5', '数据库管理', 'son/server/data.html', '1', 'fa fa-database', '1', '2018-04-17 15:19:37');
INSERT INTO `sa_menu` VALUES ('9', '5', '中间件管理', 'son/server/middleware.html', '1', 'fa fa-tasks', '1', '2018-04-17 15:19:39');
INSERT INTO `sa_menu` VALUES ('10', '2', '查看', 'user:list', '2', 'fa fa-laptop', '1', '2018-04-24 11:03:04');
INSERT INTO `sa_menu` VALUES ('11', '2', '新增', 'user:add', '2', 'fa fa-plus-square-o', '1', '2018-04-24 11:04:55');
INSERT INTO `sa_menu` VALUES ('12', '2', '修改', 'user:edit', '2', 'fa fa-edit', '1', '2018-04-24 11:04:57');
INSERT INTO `sa_menu` VALUES ('13', '2', '删除', 'user:del', '2', 'fa fa-trash-o', '1', '2018-04-24 11:05:00');

-- ----------------------------
-- Table structure for sa_middleware
-- ----------------------------
DROP TABLE IF EXISTS `sa_middleware`;
CREATE TABLE `sa_middleware` (
  `middleware_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `middleware_name` varchar(50) DEFAULT NULL COMMENT '中间名',
  `middleware_edition` varchar(50) DEFAULT NULL COMMENT '中间名版本',
  `middleware_url` varchar(50) DEFAULT NULL COMMENT '中间名管理地址',
  `middleware_admin` varchar(50) DEFAULT NULL COMMENT '中间名管理账号',
  `middleware_pas` varchar(50) DEFAULT NULL COMMENT '中间名管理密码',
  `middleware_medium` varchar(50) DEFAULT NULL COMMENT '中间名介质位置',
  `middleware_content` varchar(50) DEFAULT NULL COMMENT '中间名备注',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL,
  `server_id` bigint(20) DEFAULT NULL COMMENT '服务器id',
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '数据库创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '数据库修改时间',
  PRIMARY KEY (`middleware_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='中间件管理';

-- ----------------------------
-- Records of sa_middleware
-- ----------------------------
INSERT INTO `sa_middleware` VALUES ('2', '1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sa_middleware` VALUES ('3', '2', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sa_role
-- ----------------------------
DROP TABLE IF EXISTS `sa_role`;
CREATE TABLE `sa_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sa_role
-- ----------------------------
INSERT INTO `sa_role` VALUES ('1', '运维工程师', '运维', '1', '2018-04-19 17:20:48');

-- ----------------------------
-- Table structure for sa_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sa_role_menu`;
CREATE TABLE `sa_role_menu` (
  `rm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色模块表ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '模块ID',
  PRIMARY KEY (`rm_id`)
) ENGINE=MyISAM AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='角色模块关联表';

-- ----------------------------
-- Records of sa_role_menu
-- ----------------------------
INSERT INTO `sa_role_menu` VALUES ('64', '1', '1');
INSERT INTO `sa_role_menu` VALUES ('65', '1', '2');
INSERT INTO `sa_role_menu` VALUES ('66', '1', '10');
INSERT INTO `sa_role_menu` VALUES ('67', '1', '11');
INSERT INTO `sa_role_menu` VALUES ('68', '1', '12');
INSERT INTO `sa_role_menu` VALUES ('69', '1', '13');
INSERT INTO `sa_role_menu` VALUES ('70', '1', '3');
INSERT INTO `sa_role_menu` VALUES ('71', '1', '4');

-- ----------------------------
-- Table structure for sa_server
-- ----------------------------
DROP TABLE IF EXISTS `sa_server`;
CREATE TABLE `sa_server` (
  `server_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `server_name` varchar(50) DEFAULT NULL COMMENT '服务器名',
  `serNet` varchar(400) DEFAULT NULL COMMENT '网络情况',
  `depSituation` varchar(500) DEFAULT NULL COMMENT '部署情况',
  `type` varchar(100) DEFAULT NULL COMMENT '设备类型',
  `model` varchar(200) DEFAULT NULL COMMENT '设备型号',
  `generator` varchar(200) DEFAULT NULL COMMENT '机房位置',
  `house_humber` varchar(100) DEFAULT NULL COMMENT '楼层房间号',
  `cabinet_humber` varchar(200) DEFAULT NULL COMMENT '机柜位置编号',
  `cabinet` varchar(200) DEFAULT NULL COMMENT '机柜',
  `property_number` varchar(500) DEFAULT NULL COMMENT '设备资产编号',
  `equipment_buy_time` varchar(50) DEFAULT NULL COMMENT '设备购买时间',
  `equipment_age_limit` varchar(50) DEFAULT NULL COMMENT '设备年限',
  `leader` varchar(200) DEFAULT NULL COMMENT '设备领料人',
  `hardware_configuration` varchar(1000) DEFAULT NULL COMMENT '硬件主要配置',
  `os` varchar(500) DEFAULT NULL COMMENT '操作系统',
  `pc_name` varchar(200) DEFAULT NULL COMMENT '计算机名称',
  `server_ip` varchar(500) DEFAULT NULL COMMENT 'ip地址',
  `server_admin` varchar(50) DEFAULT NULL COMMENT '应用系统管理账号',
  `server_pas` varchar(50) DEFAULT NULL COMMENT '应用系统密码',
  `shadu_soft` varchar(500) DEFAULT NULL COMMENT '杀毒软件及安装位置',
  `begin_config` varchar(500) DEFAULT NULL COMMENT '系统初始配置',
  `server_content` varchar(1000) DEFAULT NULL COMMENT '备注相关信息',
  `management_port` varchar(100) DEFAULT NULL COMMENT '管理口 物理机',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '运维r人员名字',
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '应用系统创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '应用系统修改时间',
  PRIMARY KEY (`server_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='服务器管理';

-- ----------------------------
-- Records of sa_server
-- ----------------------------
INSERT INTO `sa_server` VALUES ('19', '213', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2', 'one', '1', '2018-04-27 09:51:57', null);
INSERT INTO `sa_server` VALUES ('20', '123', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0', '', '1', '2018-04-28 03:16:12', null);

-- ----------------------------
-- Table structure for sa_system
-- ----------------------------
DROP TABLE IF EXISTS `sa_system`;
CREATE TABLE `sa_system` (
  `system_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `system_name` varchar(50) DEFAULT NULL COMMENT '应用系统名',
  `system_ip` varchar(50) DEFAULT NULL COMMENT '应用系统ip',
  `system_domain` varchar(50) DEFAULT NULL COMMENT '应用系统域名',
  `system_url` varchar(50) DEFAULT NULL COMMENT '应用系统管理地址',
  `system_admin` varchar(50) DEFAULT NULL COMMENT '应用系统管理账号',
  `system_pas` varchar(50) DEFAULT NULL COMMENT '应用系统密码',
  `system_deployment` varchar(50) DEFAULT NULL COMMENT '应用系统部署情况',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL,
  `server_id` varchar(100) DEFAULT NULL COMMENT '服务器id',
  `server_name` varchar(255) DEFAULT NULL,
  `db_id` varchar(100) DEFAULT NULL COMMENT '数据库id',
  `db_name` varchar(255) DEFAULT NULL,
  `middleware_id` varchar(100) DEFAULT NULL COMMENT '中间件id',
  `middleware_name` varchar(255) DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '应用系统创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '应用系统修改时间',
  PRIMARY KEY (`system_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='应用系统管理';

-- ----------------------------
-- Records of sa_system
-- ----------------------------
INSERT INTO `sa_system` VALUES ('10', '123', '123', '123', '123', '123', '13', '123', '2', 'one', '19,20', '213,123', '8,6,7,9', '132,1,123,213', '2,3', '1,2', '1', '2018-04-28 10:01:43', null);
INSERT INTO `sa_system` VALUES ('9', '213123', '123', '123', '123', '123', '123', '123', '2', 'one', '15,16', '11,123', '2', '1', '2,3', '1,2', '1', '2018-04-27 08:41:12', '2018-04-27 08:54:42');

-- ----------------------------
-- Table structure for sa_user
-- ----------------------------
DROP TABLE IF EXISTS `sa_user`;
CREATE TABLE `sa_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(20) NOT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `locking_time` datetime DEFAULT NULL COMMENT '锁定时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sa_user
-- ----------------------------
INSERT INTO `sa_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', null, null, '1', '1', null, null, null);
INSERT INTO `sa_user` VALUES ('2', 'one', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'xiaojinsb@outlook.com', '13271550279', '1', '1', '2000-01-01 00:00:00', '2018-04-18 11:12:41', '2018-04-23 06:01:02');
INSERT INTO `sa_user` VALUES ('15', '123', 'a8ea38c8587faa58cc75a75452efa75f3863d4e9e5aece534d3f990eebb8b5d0', 'lKBa18yx2YbCOhxFQv10', '123@qq.com', '123123123', '1', '1', '2018-04-23 08:41:24', null, null);

-- ----------------------------
-- Table structure for sa_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sa_user_role`;
CREATE TABLE `sa_user_role` (
  `ur_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色表ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sa_user_role
-- ----------------------------
INSERT INTO `sa_user_role` VALUES ('4', '2', '1');
