/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : drf

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-27 11:00:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(100) NOT NULL,
  `menuname` varchar(100) NOT NULL,
  `pid` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('028495d9297a40b699dc08e8df1eafd6', '用户列表', '1', 'user/list');
INSERT INTO `menu` VALUES ('0d1f1839f450460d8b3953e20ecb1315', '删除用户', '1', 'user/delete');
INSERT INTO `menu` VALUES ('1', '用户管理', '0', 'user');
INSERT INTO `menu` VALUES ('2f383f896a084fcea139be2a74af3d02', '修改用户', '1', 'user/update');
INSERT INTO `menu` VALUES ('427f3dbcb06347cdb1ec6c26b25edd47', '添加用户', '1', 'user/add');
INSERT INTO `menu` VALUES ('564128256fe64c70860507cfa0c3b855', '修改角色', 'b1dd4a57891f4fc2b4936a94b961bb81', 'role/update');
INSERT INTO `menu` VALUES ('59cd4b2b12ec465aade099d05bc7f9b2', '用户角色分配', 'f0cc106045914915a68a289e88d2ab2c', 'userRole/update');
INSERT INTO `menu` VALUES ('5a9086f484234226a5014e1a7bfe5e3f', '添加权限', 'a25898e9cce94a36922254ce71bbb423', 'menu/add');
INSERT INTO `menu` VALUES ('6c059653dc7e4bffa2f13b9ce2824f60', '角色权限分配', 'b9c7562ef9654361b6b5a83d4fa0fb78', 'roleMenu/update');
INSERT INTO `menu` VALUES ('89b105fd83a34d23a18fb0184fb827b7', '删除角色', 'b1dd4a57891f4fc2b4936a94b961bb81', 'role/delete');
INSERT INTO `menu` VALUES ('89e84292f0c84a689d2a1e642ab6aee3', '角色列表', 'b1dd4a57891f4fc2b4936a94b961bb81', 'role/list');
INSERT INTO `menu` VALUES ('9538549cd2a84a04ac45de250f011eff', '用户角色列表', 'f0cc106045914915a68a289e88d2ab2c', 'userRole/list');
INSERT INTO `menu` VALUES ('993793c63b4e435ab1801f9d93e49e02', '修改权限', 'a25898e9cce94a36922254ce71bbb423', 'menu/update');
INSERT INTO `menu` VALUES ('9a6c50d8e4c9416fa6e28b43fd8bab33', '权限列表', 'a25898e9cce94a36922254ce71bbb423', 'menu/list');
INSERT INTO `menu` VALUES ('a25898e9cce94a36922254ce71bbb423', '权限管理', '0', 'menu');
INSERT INTO `menu` VALUES ('b1dd4a57891f4fc2b4936a94b961bb81', '角色管理', '0', 'role');
INSERT INTO `menu` VALUES ('b6f4f6f842bf49749aae864083890444', '删除权限', 'a25898e9cce94a36922254ce71bbb423', 'menu/delete');
INSERT INTO `menu` VALUES ('b9c7562ef9654361b6b5a83d4fa0fb78', '权限分配', '0', 'roleMenu');
INSERT INTO `menu` VALUES ('f0cc106045914915a68a289e88d2ab2c', '角色分配', '0', 'userRole');
INSERT INTO `menu` VALUES ('f335a62912e34c7f8283a2bde51a764e', '角色权限列表', 'b9c7562ef9654361b6b5a83d4fa0fb78', 'roleMenu/list');
INSERT INTO `menu` VALUES ('f37ad7d173a049dfbf53d4c3825bed4d', '添加角色', 'b1dd4a57891f4fc2b4936a94b961bb81', 'role/add');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(100) NOT NULL,
  `rolename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('437dc6a5f31045ff978b673c395c4fd1', '普通用户');
INSERT INTO `role` VALUES ('582c48fc3e9747b3ac5fee065e21837b', '超级管理员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` varchar(100) NOT NULL,
  `menid` varchar(100) NOT NULL,
  `roleid` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menid` (`menid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `role_menu_ibfk_1` FOREIGN KEY (`menid`) REFERENCES `menu` (`id`),
  CONSTRAINT `role_menu_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('025de6b196114b82a3b4721caf9c78b8', 'b6f4f6f842bf49749aae864083890444', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('094df563be3e438fafae066473c07640', '9a6c50d8e4c9416fa6e28b43fd8bab33', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('0eb34ed0fcae4e409a100f2045d7f55a', 'f37ad7d173a049dfbf53d4c3825bed4d', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('284f08b5632344ae9e0096b280f6201c', '9a6c50d8e4c9416fa6e28b43fd8bab33', '1');
INSERT INTO `role_menu` VALUES ('2bb3fddc912844a8b9d96ec750d157ee', 'f335a62912e34c7f8283a2bde51a764e', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('39cb7e1f4fb74e67ab34ac70f426d980', '1', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('41b855ff88884755a9eb610779e57068', '89e84292f0c84a689d2a1e642ab6aee3', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('48e186d59d8740fc9e00e4e6d2cedd78', '1', '1');
INSERT INTO `role_menu` VALUES ('5335a986b1334c619af0a77179b46ad7', '2f383f896a084fcea139be2a74af3d02', '1');
INSERT INTO `role_menu` VALUES ('54000a6bc22649f4a536692c15ef8d0c', '9538549cd2a84a04ac45de250f011eff', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('6409d43261d64097a9af94ab30f983b6', '5a9086f484234226a5014e1a7bfe5e3f', '1');
INSERT INTO `role_menu` VALUES ('69657412cb144ddbbf1da960565b74ba', '0d1f1839f450460d8b3953e20ecb1315', '1');
INSERT INTO `role_menu` VALUES ('6ee3cfcf23304781bb70e89556e48367', 'b1dd4a57891f4fc2b4936a94b961bb81', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('6fefd3cb78a547d8885d8e073ff62bcf', 'a25898e9cce94a36922254ce71bbb423', '1');
INSERT INTO `role_menu` VALUES ('718df2f114504eb5a31218b92c1719d0', 'a25898e9cce94a36922254ce71bbb423', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('75527fede5c14dd6bd2856a1c08548c3', '028495d9297a40b699dc08e8df1eafd6', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('7fe909d6720746c09522f47ed7c156c4', '6c059653dc7e4bffa2f13b9ce2824f60', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('822c66442f504adda545ee16ccb728cb', 'b9c7562ef9654361b6b5a83d4fa0fb78', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('8e82c71c4c8b42b784902a162269d460', '2f383f896a084fcea139be2a74af3d02', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('93145e131f204c39afd85a32d58dae8d', '5a9086f484234226a5014e1a7bfe5e3f', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('a334371eb9e64ee0b9111dd3aa02244b', '59cd4b2b12ec465aade099d05bc7f9b2', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('bf47cfd7e7dc4a249dd3e0f9a62c67aa', '89b105fd83a34d23a18fb0184fb827b7', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('d07c8f9acd2c4073a61dc84ae2b139ff', '564128256fe64c70860507cfa0c3b855', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('d3606abc18bf47b391f32954f8a3f341', '993793c63b4e435ab1801f9d93e49e02', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('d8066134cfe449578fef1361ac002476', '028495d9297a40b699dc08e8df1eafd6', '1');
INSERT INTO `role_menu` VALUES ('d9cea80eeeb34585b6f1e6c4ffb30db0', '427f3dbcb06347cdb1ec6c26b25edd47', '1');
INSERT INTO `role_menu` VALUES ('db3a4dcb5502418a8e8ef9d389885770', 'f0cc106045914915a68a289e88d2ab2c', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('dff8027209ee44ef962c30edbd9bc519', '0d1f1839f450460d8b3953e20ecb1315', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `role_menu` VALUES ('ebab6abe7b75411ab4d83bc827a004de', '427f3dbcb06347cdb1ec6c26b25edd47', '582c48fc3e9747b3ac5fee065e21837b');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('094311fd9eb2458b8fe22e9e22e212f8', '111111', '123456789');
INSERT INTO `user` VALUES ('1', 'test', 'test');
INSERT INTO `user` VALUES ('24e04b01fdf842949d0c2f270c68ee07', 'admin', '123456');
INSERT INTO `user` VALUES ('55b7682cc2c749c09912b2fd2aa35112', 'hello', '123456');
INSERT INTO `user` VALUES ('84f0629918ac45ad98076e5db8184d2f', 'test3', 'test');
INSERT INTO `user` VALUES ('bb5baa64725f4245ae7a16bd99d977fc', 'test00', '1');
INSERT INTO `user` VALUES ('c95f36f6abde4556a4bd926125fbe4e3', 'test2', 'test');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(100) NOT NULL,
  `userid` varchar(100) NOT NULL,
  `roleid` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('267c0a60e898490f972a1785c8d95436', '24e04b01fdf842949d0c2f270c68ee07', '582c48fc3e9747b3ac5fee065e21837b');
INSERT INTO `user_role` VALUES ('3dce4f370ccf465db20d25f5627213a4', '55b7682cc2c749c09912b2fd2aa35112', '437dc6a5f31045ff978b673c395c4fd1');
INSERT INTO `user_role` VALUES ('5f137db9af074ceb90c4c7c47dac081d', '094311fd9eb2458b8fe22e9e22e212f8', '1');
INSERT INTO `user_role` VALUES ('ab24c614f928401db8a0e0c1592226b8', '84f0629918ac45ad98076e5db8184d2f', '1');
INSERT INTO `user_role` VALUES ('ec5ed811fbab44fcb3ed89c994301e11', '55b7682cc2c749c09912b2fd2aa35112', '582c48fc3e9747b3ac5fee065e21837b');
