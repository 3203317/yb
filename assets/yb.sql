/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50623
Source Host           : 127.0.0.1:12306
Source Database       : yb

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-12-26 18:02:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gen_lang`
-- ----------------------------
DROP TABLE IF EXISTS `gen_lang`;
CREATE TABLE `gen_lang` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `lang_name` varchar(32) DEFAULT NULL,
  `lang_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_lang
-- ----------------------------
INSERT INTO `gen_lang` VALUES ('1', 'java', 'java', '2017-06-06 10:29:31');
INSERT INTO `gen_lang` VALUES ('2', 'php', 'php', '2017-06-06 10:29:44');
INSERT INTO `gen_lang` VALUES ('3', 'asp.net', 'asp.net', '2017-07-25 16:14:00');

-- ----------------------------
-- Table structure for `gen_lang_field`
-- ----------------------------
DROP TABLE IF EXISTS `gen_lang_field`;
CREATE TABLE `gen_lang_field` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `data_type` varchar(64) DEFAULT NULL,
  `field_name` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `lang_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_lang_field
-- ----------------------------
INSERT INTO `gen_lang_field` VALUES ('1', 'varchar', 'varchar', '2017-06-06 10:29:31', '1');
INSERT INTO `gen_lang_field` VALUES ('2', 'number', 'number', '2017-06-06 10:29:44', '1');
INSERT INTO `gen_lang_field` VALUES ('3', 'date', 'date', null, '1');

-- ----------------------------
-- Table structure for `gen_proj`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj`;
CREATE TABLE `gen_proj` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `proj_name` varchar(32) DEFAULT NULL,
  `proj_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj
-- ----------------------------
INSERT INTO `gen_proj` VALUES ('1', '项目名称1', '项目描述1', '2017-06-06 10:29:31', 'net.abc');
INSERT INTO `gen_proj` VALUES ('2', '项目名称2', '项目描述2', '2017-06-06 10:29:44', 'net.def');

-- ----------------------------
-- Table structure for `gen_proj_entity`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_entity`;
CREATE TABLE `gen_proj_entity` (
  `proj_id` varchar(32) DEFAULT '',
  `id` varchar(64) NOT NULL DEFAULT '',
  `entity_name` varchar(32) DEFAULT NULL,
  `entity_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `db_name` varchar(64) DEFAULT NULL,
  `sqls` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_entity
-- ----------------------------
INSERT INTO `gen_proj_entity` VALUES ('1', '1', 'User', '用户', '2017-06-06 10:29:31', 's_user', null);
INSERT INTO `gen_proj_entity` VALUES ('1', '2', 'Role', '角色', '2017-06-06 10:29:44', 's_role', null);
INSERT INTO `gen_proj_entity` VALUES ('1', '3', 'LoginUser', '登陆用户', '2017-12-19 11:51:46', 'v_login_user', '1');

-- ----------------------------
-- Table structure for `gen_proj_entity_prop`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_entity_prop`;
CREATE TABLE `gen_proj_entity_prop` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `prop_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `entity_id` varchar(32) NOT NULL DEFAULT '',
  `prop_type` varchar(255) DEFAULT NULL,
  `prop_min` int(11) DEFAULT NULL,
  `prop_max` int(11) DEFAULT NULL,
  `def_val` varchar(255) DEFAULT NULL COMMENT '是否生成UUID',
  `valid_msg` varchar(64) DEFAULT NULL,
  `is_null` int(1) DEFAULT NULL,
  `regex` varchar(255) DEFAULT NULL,
  `is_transient` int(1) DEFAULT NULL,
  `is_pk` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`,`entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_entity_prop
-- ----------------------------
INSERT INTO `gen_proj_entity_prop` VALUES ('create_time', '注册日期', '2017-07-31 15:41:15', '1', 'date', '0', '5', '0', '55', null, null, '0', null);
INSERT INTO `gen_proj_entity_prop` VALUES ('role_desc', '角色描述', '2017-07-26 16:22:55', '2', 'varchar', '32', '4', '0', '44', null, null, '0', null);
INSERT INTO `gen_proj_entity_prop` VALUES ('role_name', '角色名称', '2017-07-26 16:22:19', '2', 'varchar', '16', '3', '1', '33', null, null, '0', null);
INSERT INTO `gen_proj_entity_prop` VALUES ('user_name', '用户名', '2017-06-06 10:29:31', '1', 'varchar', '32', '1', '1', '11', null, null, '0', null);
INSERT INTO `gen_proj_entity_prop` VALUES ('user_pass', '密码', '2017-06-06 10:29:44', '1', 'number', '32', '2', '0', '22', null, null, '0', null);

-- ----------------------------
-- Table structure for `gen_type_db`
-- ----------------------------
DROP TABLE IF EXISTS `gen_type_db`;
CREATE TABLE `gen_type_db` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `type_name` varchar(32) DEFAULT NULL,
  `type_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_type_db
-- ----------------------------
INSERT INTO `gen_type_db` VALUES ('1', 'mysql5', 'mysql5', '2017-06-06 10:29:31');
INSERT INTO `gen_type_db` VALUES ('2', 'oracle11', 'oracle11', '2017-06-06 10:29:44');
INSERT INTO `gen_type_db` VALUES ('3', 'oracle13', 'oracle11', '2017-07-25 16:42:46');

-- ----------------------------
-- Table structure for `gen_type_db_field`
-- ----------------------------
DROP TABLE IF EXISTS `gen_type_db_field`;
CREATE TABLE `gen_type_db_field` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `relation_prop` varchar(64) DEFAULT NULL,
  `type_name` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `db_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_type_db_field
-- ----------------------------
INSERT INTO `gen_type_db_field` VALUES ('1', 'varchar', 'varchar', '2017-06-06 10:29:31', '1');
INSERT INTO `gen_type_db_field` VALUES ('2', 'number', 'number', '2017-06-06 10:29:44', '1');

-- ----------------------------
-- Table structure for `s_cfg`
-- ----------------------------
DROP TABLE IF EXISTS `s_cfg`;
CREATE TABLE `s_cfg` (
  `key_` varchar(32) NOT NULL DEFAULT '',
  `value_` varchar(32) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`key_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_cfg
-- ----------------------------
INSERT INTO `s_cfg` VALUES ('1', '123', 'XX描述', '2017-06-06 10:29:31', '共和国建国和监管环境');

-- ----------------------------
-- Table structure for `s_group`
-- ----------------------------
DROP TABLE IF EXISTS `s_group`;
CREATE TABLE `s_group` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `group_name` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_group
-- ----------------------------
INSERT INTO `s_group` VALUES ('1', 'superman', '2017-06-06 10:29:31', '1');
INSERT INTO `s_group` VALUES ('2', 'guest', '2017-06-06 10:29:44', '0');
INSERT INTO `s_group` VALUES ('77ba18ee94404d1a9e37c1425f920197', 'Thu Jun 08 15:53:04 CST 2017', '2017-06-08 15:53:05', null);

-- ----------------------------
-- Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', 'superman', '超级管理员', '2017-06-06 10:29:31', '1');
INSERT INTO `s_role` VALUES ('2', 'guest', '游客', '2017-06-06 10:29:44', '0');

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `user_name` varchar(64) DEFAULT NULL,
  `user_pass` varchar(64) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `mobile` varchar(64) DEFAULT NULL,
  `qq` varchar(64) DEFAULT NULL,
  `weixin` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `device_code` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `alipay_account` varchar(255) DEFAULT NULL,
  `wx_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'hx', 'e10adc3949ba59abbe56e057f20f883e', '1', '123', '1231', '23123', '就不告诉你', '2017-06-07 15:58:16', '2017-06-07 15:58:16', '1', null, null, '阿德斯', null, null);
INSERT INTO `s_user` VALUES ('2', 'wy', '2017-06-06 10:29:44', '0', null, null, null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `s_user` VALUES ('22c14bc40b464618a7b1b4631e1e4b44', 'hxi', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, '2017-06-07 15:58:16', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for `s_user_friends`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_friends`;
CREATE TABLE `s_user_friends` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `friend_a` varchar(32) DEFAULT NULL,
  `friend_b` varchar(64) DEFAULT NULL,
  `friend_a_alias` varchar(64) DEFAULT NULL,
  `friend_b_alias` varchar(64) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `apply_content` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_friends
-- ----------------------------
INSERT INTO `s_user_friends` VALUES ('f8910bf315d647e089445b19d80b1237', 'hx', 'wy', null, null, '1', '2017-06-07 14:51:35', 'i want', null);
