/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50623
Source Host           : 127.0.0.1:12306
Source Database       : yb

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2018-01-02 23:24:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `_1`
-- ----------------------------
DROP TABLE IF EXISTS `_1`;
CREATE TABLE `_1` (
  `sex` int(11) NOT NULL,
  `id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '注册日期',
  `user_pass` varchar(64) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _1
-- ----------------------------

-- ----------------------------
-- Table structure for `_2`
-- ----------------------------
DROP TABLE IF EXISTS `_2`;
CREATE TABLE `_2` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _2
-- ----------------------------

-- ----------------------------
-- Table structure for `_4`
-- ----------------------------
DROP TABLE IF EXISTS `_4`;
CREATE TABLE `_4` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _4
-- ----------------------------

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
  `driverClass` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `user` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj
-- ----------------------------
INSERT INTO `gen_proj` VALUES ('1', '项目名称1', '项目描述1', '2017-06-06 10:29:31', 'net.abc', 'com.mysql.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/yb?useUnicode=true&characterEncoding=utf-8', 'root', 'password');
INSERT INTO `gen_proj` VALUES ('2', '项目名称2', '项目描述2', '2017-06-06 10:29:44', 'net.def', 'com.mysql.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/yb?useUnicode=true&characterEncoding=utf-8', 'root', 'password');

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
INSERT INTO `gen_proj_entity` VALUES ('1', '3', 'LoginUser', '登陆用户', '2017-12-19 11:51:46', 'v_login_user', 'SELECT \'\' role_desc, a.role_id, b.*, c.role_name FROM _4 a LEFT JOIN _1 b ON (a.user_id=b.id) LEFT JOIN _2 c ON (a.role_id=c.id) WHERE b.id IS NOT NULL AND c.id IS NOT NULL ORDER BY b.create_time');
INSERT INTO `gen_proj_entity` VALUES ('1', '4', 'UserRole', null, '2018-01-02 08:55:08', 's_user_role', null);

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
  `len_min` int(11) DEFAULT NULL,
  `len_max` int(11) DEFAULT NULL,
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
INSERT INTO `gen_proj_entity_prop` VALUES ('create_time', '注册日期', '2017-07-31 15:41:15', '1', 'date', '0', '5', '0', '55', '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('create_time', null, '2018-01-02 22:49:20', '3', 'date', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('id', '', '2017-12-27 17:37:40', '1', 'varchar', '32', '32', '', '', '1', '', '0', '1');
INSERT INTO `gen_proj_entity_prop` VALUES ('id', '', '2018-01-02 08:50:33', '2', 'varchar', '0', '32', '', '', '1', '', '0', '1');
INSERT INTO `gen_proj_entity_prop` VALUES ('id', null, '2018-01-02 22:49:20', '3', 'varchar', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('role_desc', '角色描述', '2017-07-26 16:22:55', '2', 'varchar', '32', '4', '0', '44', '1', null, '1', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('role_desc', null, '2018-01-02 22:49:20', '3', 'varchar', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('role_id', null, '2018-01-02 22:49:20', '3', 'varchar', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('role_id', '', '2018-01-02 08:56:55', '4', 'varchar', '0', '32', '', '', '1', '', '0', '1');
INSERT INTO `gen_proj_entity_prop` VALUES ('role_name', '角色名称', '2017-07-26 16:22:19', '2', 'varchar', '16', '64', '1', '33', '1', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('role_name', null, '2018-01-02 22:49:20', '3', 'varchar', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('sex', '', '2018-01-02 10:26:50', '1', 'number', '0', '1', '', '', '1', '', '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('sex', null, '2018-01-02 22:49:20', '3', 'number', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('user_id', '', '2018-01-02 08:56:34', '4', 'varchar', '0', '32', '', '', '1', '', '0', '1');
INSERT INTO `gen_proj_entity_prop` VALUES ('user_name', '用户名', '2017-06-06 10:29:31', '1', 'varchar', '32', '64', '1', '11', '1', '123', '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('user_name', null, '2018-01-02 22:49:20', '3', 'varchar', '0', '0', null, null, '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('user_pass', '密码', '2017-06-06 10:29:44', '1', 'varchar', '32', '64', '0', '22', '0', null, '0', '0');
INSERT INTO `gen_proj_entity_prop` VALUES ('user_pass', null, '2018-01-02 22:49:20', '3', 'varchar', '0', '0', null, null, '0', null, '0', '0');

-- ----------------------------
-- Table structure for `gen_proj_form`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_form`;
CREATE TABLE `gen_proj_form` (
  `proj_id` varchar(32) DEFAULT '',
  `id` varchar(64) NOT NULL DEFAULT '',
  `form_name` varchar(32) DEFAULT NULL,
  `form_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `form_type` int(1) DEFAULT NULL,
  `rela_entity_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_form
-- ----------------------------
INSERT INTO `gen_proj_form` VALUES ('1', '1', '添加用户', '用户', '2017-06-06 10:29:31', '1', '1');
INSERT INTO `gen_proj_form` VALUES ('1', '2', '删除角色', '角色', '2017-06-06 10:29:44', '2', '2');
INSERT INTO `gen_proj_form` VALUES ('1', '3', '修改登陆用户', '登陆用户', '2017-12-19 11:51:46', '3', '3');
INSERT INTO `gen_proj_form` VALUES ('1', '4', '查询用户角色', null, '2018-01-02 08:55:08', '4', '4');

-- ----------------------------
-- Table structure for `gen_proj_form_prop`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_form_prop`;
CREATE TABLE `gen_proj_form_prop` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `prop_desc` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `form_id` varchar(32) NOT NULL DEFAULT '',
  `sort` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`,`form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_form_prop
-- ----------------------------
INSERT INTO `gen_proj_form_prop` VALUES ('create_time', '注册日期', '2017-07-31 15:41:15', '1', '4');
INSERT INTO `gen_proj_form_prop` VALUES ('create_time', null, '2018-01-02 14:24:03', '3', '2');
INSERT INTO `gen_proj_form_prop` VALUES ('id', '', '2018-01-02 08:50:33', '2', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('id', null, '2018-01-02 14:24:03', '3', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('role_desc', null, '2018-01-02 14:24:03', '3', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('role_id', null, '2018-01-02 14:24:03', '3', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('role_id', '', '2018-01-02 08:56:55', '4', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('role_name', null, '2018-01-02 14:24:03', '3', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('sex', '性别', '2018-01-02 10:26:50', '1', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('sex', null, '2018-01-02 14:24:03', '3', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('user_id', '', '2018-01-02 08:56:34', '4', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('user_name', '用户名', '2017-06-06 10:29:31', '1', '1');
INSERT INTO `gen_proj_form_prop` VALUES ('user_name', null, '2018-01-02 14:24:03', '3', '3');
INSERT INTO `gen_proj_form_prop` VALUES ('user_pass', '密码', '2017-06-06 10:29:44', '1', '2');
INSERT INTO `gen_proj_form_prop` VALUES ('user_pass', null, '2018-01-02 14:24:03', '3', '3');

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

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '张三');
INSERT INTO `test` VALUES ('2', '李四');
