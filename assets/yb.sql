/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50623
Source Host           : 127.0.0.1:22306
Source Database       : yb

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-01-26 20:05:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_cfg`
-- ----------------------------
DROP TABLE IF EXISTS `s_cfg`;
CREATE TABLE `s_cfg` (
  `key_` varchar(255) NOT NULL DEFAULT '',
  `value_` varchar(255) DEFAULT '',
  `title` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`key_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全局参数表';

-- ----------------------------
-- Records of s_cfg
-- ----------------------------
INSERT INTO `s_cfg` VALUES ('0101', '30', '更新频率（秒）', '系统参数更新间隔时间', '2016-05-08 11:28:31');
INSERT INTO `s_cfg` VALUES ('0102', '0.001', '参数2', '描述2', '2016-05-08 11:28:37');
INSERT INTO `s_cfg` VALUES ('0104', '0.231', '参数3', '描述3', '2016-05-08 11:28:43');

-- ----------------------------
-- Table structure for `s_m`
-- ----------------------------
DROP TABLE IF EXISTS `s_m`;
CREATE TABLE `s_m` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_pass` varchar(32) DEFAULT NULL COMMENT '登陆密码',
  `nickname` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1启用 0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_m
-- ----------------------------
INSERT INTO `s_m` VALUES ('admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '18530000000@qq.com', '2016-05-27 04:33:45', '1');

-- ----------------------------
-- Table structure for `s_menu`
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `PID` varchar(32) DEFAULT NULL,
  `PATH` varchar(512) DEFAULT NULL,
  `MENU_NAME` varchar(32) DEFAULT NULL,
  `MENU_URL` varchar(128) DEFAULT NULL,
  `SORT` int(2) DEFAULT NULL,
  `IS_PARENT` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1', '0', 'null', '后台', '', '1', '1');
INSERT INTO `s_menu` VALUES ('10', '8', '0,1,4', '角色权限设置', '', '2', '0');
INSERT INTO `s_menu` VALUES ('11', '4', '0,1', '用户管理', '', '3', '1');
INSERT INTO `s_menu` VALUES ('12', '11', '0,1,4', '用户信息维护', 'user/', '1', '0');
INSERT INTO `s_menu` VALUES ('13', '11', '0,1,4', '用户角色设置', '', '2', '0');
INSERT INTO `s_menu` VALUES ('14', '4', '0,1', '动作管理', '', '4', '1');
INSERT INTO `s_menu` VALUES ('15', '14', '0,1,4', '动作信息维护', 'action/', '1', '0');
INSERT INTO `s_menu` VALUES ('16', '4', '0,1', '数据权限', '', '5', '1');
INSERT INTO `s_menu` VALUES ('17', '16', '0,1,4', '数据规则设置', '', '1', '0');
INSERT INTO `s_menu` VALUES ('18', '1', 'null', '网站管理', '', '3', '1');
INSERT INTO `s_menu` VALUES ('19', '18', '0,1', '评论管理', '', '1', '1');
INSERT INTO `s_menu` VALUES ('2', '4', '0,1', '基本设置', '', '1', '1');
INSERT INTO `s_menu` VALUES ('20', '19', '0,1,18', '评论信息维护', 'comment/', '1', '0');
INSERT INTO `s_menu` VALUES ('21', '0', 'null', '前台', '', '4', '1');
INSERT INTO `s_menu` VALUES ('22', '18', '0,1', '客户管理', '', '1', '1');
INSERT INTO `s_menu` VALUES ('23', '22', '0,1,18', '客户信息维护', 'customer/', '1', '0');
INSERT INTO `s_menu` VALUES ('24', '22', '0,21', '用户信息维护', 'tenantuser/index', '4', '0');
INSERT INTO `s_menu` VALUES ('25', '22', '0,21', '服务订单维护', 'softserviceorder/index', '2', '0');
INSERT INTO `s_menu` VALUES ('26', '22', '0,21', '组织机构维护', 'tenantorg/index', '3', '0');
INSERT INTO `s_menu` VALUES ('27', '1', 'null', '日志管理', '', '5', '1');
INSERT INTO `s_menu` VALUES ('28', '18', '0,1', '房产频道', '', '3', '1');
INSERT INTO `s_menu` VALUES ('29', '28', '0,1,18', '项目管理', 'house/project/', '2', '0');
INSERT INTO `s_menu` VALUES ('3', '2', '0,1,4', '参数设置', '', '1', '0');
INSERT INTO `s_menu` VALUES ('4', '1', 'null', '系统管理', '', '2', '1');
INSERT INTO `s_menu` VALUES ('5', '4', '0,1', '菜单管理', '', '1', '1');
INSERT INTO `s_menu` VALUES ('564d39b03da3e6cc1bd6fd81', '28', '0,1,18', '房企信息', 'house/corp/', '1', '0');
INSERT INTO `s_menu` VALUES ('56542c5d06f244d8113de620', '22', '0,1,18', '企业信息维护', 'corp/', '2', '0');
INSERT INTO `s_menu` VALUES ('565bb013a1f747241c0f1ed1', '28', '0,1,18', '报名电话', 'house/project/apply/', '3', '0');
INSERT INTO `s_menu` VALUES ('6', '5', '0,1,4', '菜单信息维护', 'menu/', '1', '0');
INSERT INTO `s_menu` VALUES ('7', '5', '0,1,4', '菜单操作注册', '', '2', '0');
INSERT INTO `s_menu` VALUES ('8', '4', '0,1', '角色管理', '', '2', '1');
INSERT INTO `s_menu` VALUES ('9', '8', '0,1,4', '角色信息维护', 'role/', '1', '0');

-- ----------------------------
-- Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(32) DEFAULT NULL COMMENT '登陆密码',
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1启用 0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('08151306', '超级管理员', '超级管理员', '2016-05-09 14:53:14', '1');
INSERT INTO `s_role` VALUES ('2ffef549a1994cbd931e84295a1e2c59', 'role_name', '123456', '2017-01-25 00:17:23', '0');
INSERT INTO `s_role` VALUES ('sdfdf', '游客', '游客', '2016-07-20 10:44:32', '0');

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` varchar(32) NOT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_pass` varchar(32) DEFAULT NULL COMMENT '登陆密码',
  `real_name` varchar(32) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `alipay_account` varchar(32) DEFAULT NULL,
  `wx_account` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1启用 0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('08151306', null, 'halo', 'c4ca4238a0b923820dcc509a6f75849b', '哈喽', '13837100001', 'halo', '13837100001@qq.com', '13837100001', '说了你也不懂', '2016-05-09 14:53:14', '1');
INSERT INTO `s_user` VALUES ('4055aff157a345c49ba34b5ca79b1e5a', null, 'asdasd1', 'a8f5f167f44f4964e6c998dee827110c', 'asdasd', 'asdasd11', 'asdasddf', 'asdasd11', 'asdasd', 'asdasd', '2016-07-24 15:17:51', '1');
INSERT INTO `s_user` VALUES ('f88647d11de44a289b7f35ce534bf3ba', null, 'aadd', 'e10adc3949ba59abbe56e057f20f883e', 'asdasd', 'as', 'asd', 's', null, null, '2016-07-23 15:57:08', '1');
INSERT INTO `s_user` VALUES ('f88fd75b6c2d4e24a7a7e83e619c0d00', null, 'asdasd', 'e10adc3949ba59abbe56e057f20f883e', 'asdasd', 'asdasd', 'asdasd', 'asdasd', null, null, '2016-07-23 16:00:55', '1');
INSERT INTO `s_user` VALUES ('id', '08151306', 'user_name', 'c4ca4238a0b923820dcc509a6f75849b', '2', 'mobile', 'nickname', 'email', '1', '3', '2016-09-28 16:28:01', '1');

-- ----------------------------
-- Table structure for `w_notice`
-- ----------------------------
DROP TABLE IF EXISTS `w_notice`;
CREATE TABLE `w_notice` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  `content` longtext,
  `view_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_notice
-- ----------------------------
INSERT INTO `w_notice` VALUES ('d575c5a7788e4650927a04580fc4b34a', 'user_id', '2017-01-25 20:25:19', 'title', 'content', '6');
