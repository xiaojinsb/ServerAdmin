SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 用户表
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
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户';

INSERT INTO `sa_user` VALUES ('1', 'admin', 'c1c4cca01334113c2c7df5a04ec2769104291a85a2f2cf6bce59c74eaaac3c42', '7XTLwljtQ9DzlNPryT5c', null, null, '1', '1', null, null, null);
-- ----------------------------
-- 用户角色关联表
-- ----------------------------
DROP TABLE IF EXISTS `sa_user_role`;
CREATE TABLE `sa_user_role` (
  `ur_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色表ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- 角色表
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
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色管理';

-- ----------------------------
-- 角色模块关联表
-- ----------------------------
DROP TABLE IF EXISTS `sa_role_menu`;
CREATE TABLE `sa_role_menu` (
  `rm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色模块表ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '模块ID',
  PRIMARY KEY (`rm_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色模块关联表';

-- ----------------------------
-- 模块表
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
  PRIMARY KEY (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='模块管理';

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
INSERT INTO `sa_menu` VALUES ('22', '3', '查看', 'role:list', '2', 'fa fa-laptop', '1', '2018-05-04 17:20:16');
INSERT INTO `sa_menu` VALUES ('23', '3', '新增', 'role:add', '2', 'fa fa-plus-square-o', '1', '2018-05-04 17:20:19');
INSERT INTO `sa_menu` VALUES ('24', '3', '修改', 'role:edit', '2', 'fa fa-edit', '1', '2018-05-04 17:20:21');
INSERT INTO `sa_menu` VALUES ('25', '3', '删除', 'role:del', '2', 'fa fa-trash-o', '1', '2018-05-04 17:20:23');
INSERT INTO `sa_menu` VALUES ('26', '4', '查看', 'menu:list', '2', 'fa fa-laptop', '1', '2018-04-24 11:03:04');
INSERT INTO `sa_menu` VALUES ('27', '4', '新增', 'menu:add', '2', 'fa fa-plus-square-o', '1', '2018-04-24 11:04:55');
INSERT INTO `sa_menu` VALUES ('28', '4', '修改', 'menu:edit', '2', 'fa fa-edit', '1', '2018-04-24 11:04:57');
INSERT INTO `sa_menu` VALUES ('29', '4', '删除', 'menu:del', '2', 'fa fa-trash-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('30', '6', '查看', 'server:list', '2', 'fa fa-laptop', '1', '2018-04-24 11:03:04');
INSERT INTO `sa_menu` VALUES ('31', '6', '新增', 'server:add', '2', 'fa fa-plus-square-o', '1', '2018-04-24 11:04:55');
INSERT INTO `sa_menu` VALUES ('32', '6', '修改', 'server:edit', '2', 'fa fa-edit', '1', '2018-04-24 11:04:57');
INSERT INTO `sa_menu` VALUES ('33', '6', '删除', 'server:del', '2', 'fa fa-trash-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('34', '6', '导出', 'server:excel', '2', 'fa fa-file-excel-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('35', '7', '查看', 'sys:list', '2', 'fa fa-laptop', '1', '2018-04-24 11:03:04');
INSERT INTO `sa_menu` VALUES ('36', '7', '新增', 'sys:add', '2', 'fa fa-plus-square-o', '1', '2018-04-24 11:04:55');
INSERT INTO `sa_menu` VALUES ('37', '7', '修改', 'sys:edit', '2', 'fa fa-edit', '1', '2018-04-24 11:04:57');
INSERT INTO `sa_menu` VALUES ('38', '7', '删除', 'sys:del', '2', 'fa fa-trash-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('39', '7', '导出', 'sys:excel', '2', 'fa fa-file-excel-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('40', '8', '查看', 'data:list', '2', 'fa fa-laptop', '1', '2018-04-24 11:03:04');
INSERT INTO `sa_menu` VALUES ('41', '8', '新增', 'data:add', '2', 'fa fa-plus-square-o', '1', '2018-04-24 11:04:55');
INSERT INTO `sa_menu` VALUES ('42', '8', '修改', 'data:edit', '2', 'fa fa-edit', '1', '2018-04-24 11:04:57');
INSERT INTO `sa_menu` VALUES ('43', '8', '删除', 'data:del', '2', 'fa fa-trash-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('44', '8', '导出', 'data:excel', '2', 'fa fa-file-excel-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('45', '9', '查看', 'midd:list', '2', 'fa fa-laptop', '1', '2018-04-24 11:03:04');
INSERT INTO `sa_menu` VALUES ('46', '9', '新增', 'midd:add', '2', 'fa fa-plus-square-o', '1', '2018-04-24 11:04:55');
INSERT INTO `sa_menu` VALUES ('47', '9', '修改', 'midd:edit', '2', 'fa fa-edit', '1', '2018-04-24 11:04:57');
INSERT INTO `sa_menu` VALUES ('48', '9', '删除', 'midd:del', '2', 'fa fa-trash-o', '1', '2018-04-24 11:05:00');
INSERT INTO `sa_menu` VALUES ('49', '9', '导出', 'midd:excel', '2', 'fa fa-file-excel-o', '1', '2018-04-24 11:05:00');


-- ----------------------------
-- 服务器表
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
  `server_admin` varchar(50) DEFAULT NULL COMMENT '管理账号',
  `server_pas` varchar(50) DEFAULT NULL COMMENT '管理密码',
  `shadu_soft` varchar(500) DEFAULT NULL COMMENT '杀毒软件及安装位置',
  `begin_config` varchar(500) DEFAULT NULL COMMENT '系统初始配置',
  `server_content` varchar(1000) DEFAULT NULL COMMENT '备注相关信息',
  `management_port` varchar(100) DEFAULT NULL COMMENT '管理口',
  `user_id` bigint(20) DEFAULT NULL COMMENT '运维用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '运维用户名',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '应用系统创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '应用系统修改时间',
  PRIMARY KEY (`server_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='服务器管理';

-- ----------------------------
-- 应用系统表
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
  `user_id` bigint(20) DEFAULT NULL COMMENT '运维用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '运维用户名',
  `server_id` varchar(100) DEFAULT NULL COMMENT '服务器id',
  `server_name` varchar(255) DEFAULT NULL COMMENT '服务器名',
  `db_id` varchar(100) DEFAULT NULL COMMENT '数据库id',
  `db_name` varchar(255) DEFAULT NULL COMMENT '数据库名称',
  `middleware_id` varchar(100) DEFAULT NULL COMMENT '中间件id',
  `middleware_name` varchar(255) DEFAULT NULL COMMENT '中间件名',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '应用系统创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '应用系统修改时间',
  PRIMARY KEY (`system_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='应用系统管理';

-- ----------------------------
-- 数据库管理
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
  `user_id` bigint(20) DEFAULT NULL COMMENT '运维用户id',
  `user_name` varchar(50) NOT NULL COMMENT '运维用户名',
  `server_id` varchar(50) DEFAULT NULL COMMENT '服务器id',
  `server_name` varchar(255) DEFAULT NULL COMMENT '服务器名',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '数据库创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '数据库修改时间',
  PRIMARY KEY (`db_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据库管理';

-- ----------------------------
-- 中间件表
-- ----------------------------
DROP TABLE IF EXISTS `sa_middleware`;
CREATE TABLE `sa_middleware` (
  `middleware_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `middleware_name` varchar(50) DEFAULT NULL COMMENT '中间件名称',
  `middleware_edition` varchar(50) DEFAULT NULL COMMENT '中间件版本',
  `middleware_url` varchar(50) DEFAULT NULL COMMENT '中间件管理地址',
  `middleware_install_url` varchar(255) DEFAULT NULL COMMENT'中间件安装地址',
  `middleware_admin` varchar(50) DEFAULT NULL COMMENT '中间件管理账号',
  `middleware_pas` varchar(50) DEFAULT NULL COMMENT '中间件管理密码',
  `middleware_medium` varchar(50) DEFAULT NULL COMMENT '中间件介质位置',
  `middleware_content` varchar(50) DEFAULT NULL COMMENT '中间件备注',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `server_id` varchar(50) DEFAULT NULL COMMENT '服务器id',
  `server_name` varchar(255) DEFAULT NULL COMMENT '服务器名',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创造者id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '数据库创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '数据库修改时间',
  PRIMARY KEY (`middleware_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='中间件管理';

-- ----------------------------
-- 文件信息表
-- ----------------------------
DROP TABLE IF EXISTS `sa_parses`;
CREATE TABLE `sa_parses` (
  `par_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_id` bigint(20) DEFAULT NULL COMMENT '数据的id',
  `file_classify` varchar(50) DEFAULT NULL COMMENT '来自哪里 serer 服务器 sys 应用系统 data 数据库 midd 中间件',
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `url_site` varchar(500) DEFAULT NULL COMMENT '文件存储路径',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更改时间',
  PRIMARY KEY (`par_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='文件信息';