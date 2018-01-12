/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50712
Source Host           : localhost:3309
Source Database       : ngkj-shopping

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-06-12 14:07:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '资源名称',
  `url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '资源路径',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `resource_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '权限管理', '', '系统管理', 'icon-company', null, '0', '0', '0', '2016-12-15 10:54:47');
INSERT INTO `resource` VALUES ('48', '资源管理', '/resource/manager', '资源管理', 'menu_icon_datadeal', '1', '0', '0', '0', '2016-12-15 11:47:21');
INSERT INTO `resource` VALUES ('49', '角色管理', '/role/manager', '角色管理', 'menu_icon_datadeal', '1', '0', '0', '0', '2016-12-15 11:47:40');
INSERT INTO `resource` VALUES ('50', '用户管理', '/user/manager', '用户管理', 'menu_icon_datadeal', '1', '0', '0', '0', '2016-12-15 11:48:12');
INSERT INTO `resource` VALUES ('51', '列表', '/resource/treeGrid', '资源列表', 'icon-list', '48', '0', '0', '0', '2016-12-15 15:44:36');
INSERT INTO `resource` VALUES ('52', '添加', '/resource/add', '资源添加', 'icon-add', '48', '0', '0', '1', '2016-12-15 15:44:47');
INSERT INTO `resource` VALUES ('53', '编辑', '/resource/edit', '资源编辑', 'icon-edit', '48', '0', '0', '1', '2016-12-15 15:44:58');
INSERT INTO `resource` VALUES ('54', '删除', '/resource/delete', '资源删除', 'icon-del', '48', '0', '0', '1', '2016-12-15 15:45:05');
INSERT INTO `resource` VALUES ('55', '列表', '/role/dataGrid', '角色列表', 'icon-list', '49', '0', '0', '0', '2016-12-15 15:53:27');
INSERT INTO `resource` VALUES ('56', '添加', '/role/add', '角色添加', 'icon-add', '49', '0', '0', '1', '2016-12-15 15:44:47');
INSERT INTO `resource` VALUES ('57', '编辑', '/role/edit', '角色编辑', 'icon-edit', '49', '0', '0', '1', '2016-12-15 15:44:58');
INSERT INTO `resource` VALUES ('58', '删除', '/role/delete', '角色删除', 'icon-del', '49', '0', '0', '1', '2016-12-15 15:45:05');
INSERT INTO `resource` VALUES ('59', '授权', '/role/grant', '角色授权', 'icon-ok', '49', '0', '0', '1', '2016-12-15 15:54:30');
INSERT INTO `resource` VALUES ('60', '添加', '/user/add', '用户添加', 'icon-add', '50', '0', '0', '1', '2016-12-18 19:46:12');
INSERT INTO `resource` VALUES ('61', '编辑', '/user/edit', null, 'icon-edit', '50', '0', '0', '1', '2017-06-12 12:02:45');
INSERT INTO `resource` VALUES ('62', '删除', '/user/delete', null, 'icon-del', '50', '0', '0', '1', '2017-06-12 12:09:51');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0', '超级管理员', '0');
INSERT INTO `role` VALUES ('2', '普通管理员', '0', '', '0');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=957 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('907', '2', '1');
INSERT INTO `role_resource` VALUES ('908', '2', '50');
INSERT INTO `role_resource` VALUES ('909', '2', '60');
INSERT INTO `role_resource` VALUES ('940', '1', '1');
INSERT INTO `role_resource` VALUES ('941', '1', '48');
INSERT INTO `role_resource` VALUES ('942', '1', '52');
INSERT INTO `role_resource` VALUES ('943', '1', '53');
INSERT INTO `role_resource` VALUES ('944', '1', '54');
INSERT INTO `role_resource` VALUES ('945', '1', '49');
INSERT INTO `role_resource` VALUES ('946', '1', '56');
INSERT INTO `role_resource` VALUES ('947', '1', '57');
INSERT INTO `role_resource` VALUES ('948', '1', '58');
INSERT INTO `role_resource` VALUES ('949', '1', '59');
INSERT INTO `role_resource` VALUES ('950', '1', '50');
INSERT INTO `role_resource` VALUES ('951', '1', '60');
INSERT INTO `role_resource` VALUES ('952', '1', '61');
INSERT INTO `role_resource` VALUES ('953', '1', '62');
INSERT INTO `role_resource` VALUES ('954', '1', '8');
INSERT INTO `role_resource` VALUES ('955', '1', '63');
INSERT INTO `role_resource` VALUES ('956', '1', '64');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名',
  `opt_content` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '内容',
  `client_ip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆名',
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `sex` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` tinyint(2) DEFAULT '0' COMMENT '年龄',
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `user_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户类别',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `outtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', '23', '15727760344', '0', '0', '2017-01-03 19:18:51', '2017-06-12 13:56:42');
INSERT INTO `user` VALUES ('6', 'user', 'user', 'e10adc3949ba59abbe56e057f20f883e', '0', '18', '15728166555', '0', '0', '2017-06-12 11:57:07', '2017-06-12 12:08:46');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(19) NOT NULL COMMENT '用户id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('3', '3', '4');
INSERT INTO `user_role` VALUES ('8', '2', '3');
INSERT INTO `user_role` VALUES ('10', '5', '4');
INSERT INTO `user_role` VALUES ('17', '6', '2');
INSERT INTO `user_role` VALUES ('18', '1', '1');
