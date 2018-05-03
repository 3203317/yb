/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_win7
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : yb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-05-03 19:49:24
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
  `password` varchar(64) DEFAULT NULL,
  `user` varchar(64) DEFAULT NULL,
  `url` varchar(1024) DEFAULT NULL,
  `driverClass` varchar(256) DEFAULT NULL,
  `package_name` varchar(128) DEFAULT NULL COMMENT '包名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `proj_desc` varchar(256) DEFAULT NULL COMMENT '项目描述',
  `proj_name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `id` varchar(32) NOT NULL DEFAULT '',
  `proj_name_en` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj
-- ----------------------------
INSERT INTO `gen_proj` VALUES ('password', 'root', 'jdbc:mysql://127.0.0.1:12306/yb_1?useUnicode=true&characterEncoding=utf-8', 'com.mysql.jdbc.Driver', 'net.abc', '2017-06-06 10:29:31', '测试系统', '测试系统', '1', null);
INSERT INTO `gen_proj` VALUES ('password', 'root', 'jdbc:mysql://127.0.0.1:12306/yb_2?useUnicode=true&characterEncoding=utf-8', 'com.mysql.jdbc.Driver', 'net.abc.xxx', '2017-06-06 10:29:44', '系统原型', '系统原型', '2', null);

-- ----------------------------
-- Table structure for `gen_proj_entity`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_entity`;
CREATE TABLE `gen_proj_entity` (
  `sqls` varchar(2048) DEFAULT NULL COMMENT 'SQL语句',
  `db_tab_name` varchar(64) DEFAULT NULL COMMENT '表名',
  `proj_id` varchar(32) NOT NULL DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `entity_desc` varchar(256) DEFAULT NULL COMMENT '实体描述',
  `entity_name` varchar(32) DEFAULT NULL COMMENT '实体标签',
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '实体名称',
  PRIMARY KEY (`proj_id`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_entity
-- ----------------------------
INSERT INTO `gen_proj_entity` VALUES ('SELECT \'\' role_desc, a.role_id, b.*, c.role_name FROM s_user_role a LEFT JOIN s_user b ON (a.user_id=b.id) LEFT JOIN s_role c ON (a.role_id=c.id) WHERE b.id IS NOT NULL AND c.id IS NOT NULL ORDER BY b.create_time', 'v_login_user', '1', '2017-12-19 11:51:46', null, '登陆用户', 'LoginUser');
INSERT INTO `gen_proj_entity` VALUES (null, 's_role', '1', '2017-06-06 10:29:44', null, '角色', 'Role');
INSERT INTO `gen_proj_entity` VALUES (null, 's_user', '1', '2017-06-06 10:29:31', null, '用户', 'User');
INSERT INTO `gen_proj_entity` VALUES (null, 's_user_role', '1', '2018-01-02 08:55:08', null, null, 'UserRole');
INSERT INTO `gen_proj_entity` VALUES ('', 's_org', '2', '2018-01-06 10:42:41', null, '组织', 'Org');
INSERT INTO `gen_proj_entity` VALUES ('', 'gen_proj', '2', '2018-01-06 22:49:14', null, '项目', 'Proj');
INSERT INTO `gen_proj_entity` VALUES ('', 'gen_proj_entity', '2', '2018-01-06 22:30:07', null, '项目实体', 'ProjEntity');
INSERT INTO `gen_proj_entity` VALUES ('', 'gen_proj_entity_prop', '2', '2018-01-07 09:35:53', null, '项目实体属性', 'ProjEntityProp');
INSERT INTO `gen_proj_entity` VALUES ('', 'gen_proj_form', '2', '2018-01-08 14:16:10', 'ProjForm', '项目表单', 'ProjForm');
INSERT INTO `gen_proj_entity` VALUES ('', 'gen_proj_form_prop', '2', '2018-01-08 15:00:06', '', '项目表单属性', 'ProjFormProp');
INSERT INTO `gen_proj_entity` VALUES ('', 's_role', '2', '2018-01-06 10:41:51', null, '角色', 'Role');
INSERT INTO `gen_proj_entity` VALUES ('', 's_user', '2', '2018-01-06 10:32:33', null, '用户', 'User');
INSERT INTO `gen_proj_entity` VALUES ('', 's_user_role', '2', '2018-01-06 11:14:41', null, '用户角色', 'UserRole');

-- ----------------------------
-- Table structure for `gen_proj_entity_prop`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_entity_prop`;
CREATE TABLE `gen_proj_entity_prop` (
  `prop_name` varchar(32) DEFAULT NULL COMMENT '属性标签',
  `is_uuid` int(1) DEFAULT NULL COMMENT 'UUID',
  `is_pk` int(1) DEFAULT NULL COMMENT '主键',
  `is_transient` int(1) DEFAULT NULL COMMENT '排除',
  `regex` varchar(256) DEFAULT NULL COMMENT '正则',
  `allow_null` int(1) DEFAULT NULL COMMENT '允许空',
  `valid_msg` varchar(256) DEFAULT NULL COMMENT '验证消息',
  `def_val` varchar(256) DEFAULT NULL COMMENT '默认值',
  `len_max` int(11) DEFAULT NULL COMMENT '最大',
  `len_min` int(11) DEFAULT NULL COMMENT '最小',
  `prop_type` varchar(32) DEFAULT NULL COMMENT '数据类型',
  `create_time` datetime DEFAULT NULL,
  `prop_desc` varchar(256) DEFAULT NULL COMMENT '属性描述',
  `entity_id` varchar(32) NOT NULL DEFAULT '',
  `proj_id` varchar(32) NOT NULL DEFAULT '',
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '属性名称',
  PRIMARY KEY (`entity_id`,`proj_id`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_entity_prop
-- ----------------------------
INSERT INTO `gen_proj_entity_prop` VALUES ('角色Id', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:15:35', null, '050ea4f310274a4e8b8ccf89d2d4add7', '1', 'role_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('用户Id', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:15:11', null, '050ea4f310274a4e8b8ccf89d2d4add7', '1', 'user_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('创建时间', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-06 11:13:29', null, '0ed88389148f4bd9b37a3b53a8800973', '1', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('id', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:12:41', null, '0ed88389148f4bd9b37a3b53a8800973', '1', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('角色描述', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:13:13', null, '0ed88389148f4bd9b37a3b53a8800973', '1', 'role_desc');
INSERT INTO `gen_proj_entity_prop` VALUES ('角色名称', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:12:59', null, '0ed88389148f4bd9b37a3b53a8800973', '1', 'role_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('状态', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-06 11:13:50', null, '0ed88389148f4bd9b37a3b53a8800973', '1', 'status');
INSERT INTO `gen_proj_entity_prop` VALUES ('注册日期', '0', '0', '0', null, '0', '55', '0', '5', '0', 'date', '2017-07-31 15:41:15', null, '1', '1', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '32', 'varchar', '2017-12-27 17:37:40', null, '1', '1', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-02 10:26:50', null, '1', '1', 'sex');
INSERT INTO `gen_proj_entity_prop` VALUES ('用户名', '0', '0', '0', '123', '1', '11', '1', '64', '32', 'varchar', '2017-06-06 10:29:31', null, '1', '1', 'user_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('密码', '0', '0', '0', null, '0', '22', '0', '64', '32', 'varchar', '2017-06-06 10:29:44', null, '1', '1', 'user_pass');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-02 08:50:33', null, '2', '1', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('角色描述', '0', '0', '1', null, '1', '44', '0', '4', '32', 'varchar', '2017-07-26 16:22:55', null, '2', '1', 'role_desc');
INSERT INTO `gen_proj_entity_prop` VALUES ('角色名称', '0', '0', '0', null, '1', '33', '1', '64', '16', 'varchar', '2017-07-26 16:22:19', null, '2', '1', 'role_name');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'date', '2018-01-04 15:56:41', null, '3', '1', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'varchar', '2018-01-04 15:56:41', null, '3', '1', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'varchar', '2018-01-04 15:56:41', null, '3', '1', 'role_desc');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'varchar', '2018-01-04 15:56:41', null, '3', '1', 'role_id');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'varchar', '2018-01-04 15:56:41', null, '3', '1', 'role_name');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'number', '2018-01-04 15:56:41', null, '3', '1', 'sex');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'varchar', '2018-01-04 15:56:41', null, '3', '1', 'user_name');
INSERT INTO `gen_proj_entity_prop` VALUES (null, '0', '0', '0', null, '0', null, null, '0', '0', 'varchar', '2018-01-04 15:56:41', null, '3', '1', 'user_pass');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-02 08:56:55', null, '4', '1', 'role_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-02 08:56:34', null, '4', '1', 'user_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:47:03', null, '95b4a66b2d9f47809132fb35fdf8feb5', '1', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('组织名称', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:47:15', null, '95b4a66b2d9f47809132fb35fdf8feb5', '1', 'org_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('支付宝', '0', '0', '0', '', '1', '', '', '64', '0', 'varchar', '2018-01-06 10:55:34', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'alipay_account');
INSERT INTO `gen_proj_entity_prop` VALUES ('注册时间', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-06 10:53:48', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('电子邮箱', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-06 10:53:21', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'email');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 10:47:00', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('手机', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 10:52:09', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'mobile');
INSERT INTO `gen_proj_entity_prop` VALUES ('昵称', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 10:53:04', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'nickname');
INSERT INTO `gen_proj_entity_prop` VALUES ('推荐人', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 11:08:01', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'p_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('QQ', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 10:52:30', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'qq');
INSERT INTO `gen_proj_entity_prop` VALUES ('真实姓名', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 10:54:48', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'real_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('性别', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-06 10:51:44', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'sex');
INSERT INTO `gen_proj_entity_prop` VALUES ('状态', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-06 10:54:03', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'status');
INSERT INTO `gen_proj_entity_prop` VALUES ('用户名', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 10:48:51', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'user_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('密码', '0', '0', '0', '', '1', '', '', '64', '0', 'varchar', '2018-01-06 10:51:23', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'user_pass');
INSERT INTO `gen_proj_entity_prop` VALUES ('微信', '0', '0', '0', '', '1', '', '', '64', '0', 'varchar', '2018-01-06 11:06:53', null, '95e4e52ed0574a7c8ae334637b2e0e62', '1', 'weixin_account');
INSERT INTO `gen_proj_entity_prop` VALUES ('创建时间', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-06 22:50:41', null, 'Proj', '2', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-06 22:51:15', null, 'Proj', '2', 'driverClass');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '1', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 22:49:31', null, 'Proj', '2', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('包名', '0', '0', '0', '', '1', '', '', '128', '0', 'varchar', '2018-01-06 22:50:56', null, 'Proj', '2', 'package_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '64', '0', 'varchar', '2018-01-06 22:51:45', null, 'Proj', '2', 'password');
INSERT INTO `gen_proj_entity_prop` VALUES ('项目描述', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-06 22:50:27', null, 'Proj', '2', 'proj_desc');
INSERT INTO `gen_proj_entity_prop` VALUES ('项目名称', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 22:50:07', null, 'Proj', '2', 'proj_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '1024', '0', 'varchar', '2018-01-06 22:51:26', null, 'Proj', '2', 'url');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '64', '0', 'varchar', '2018-01-06 22:51:36', null, 'Proj', '2', 'user');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-06 22:31:13', null, 'ProjEntity', '2', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('表名', '0', '0', '0', '', '1', '', '', '64', '0', 'varchar', '2018-01-06 22:31:41', null, 'ProjEntity', '2', 'db_tab_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('实体描述', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-06 22:31:05', null, 'ProjEntity', '2', 'entity_desc');
INSERT INTO `gen_proj_entity_prop` VALUES ('实体标签', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 22:30:40', null, 'ProjEntity', '2', 'entity_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('实体名称', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 22:30:25', null, 'ProjEntity', '2', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-06 22:31:22', null, 'ProjEntity', '2', 'proj_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('SQL语句', '0', '0', '0', '', '1', '', '', '2048', '0', 'varchar', '2018-01-06 22:31:58', null, 'ProjEntity', '2', 'sqls');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-07 09:38:38', null, 'ProjEntityProp', '2', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('默认值', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-07 09:40:11', null, 'ProjEntityProp', '2', 'def_val');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-07 09:38:07', null, 'ProjEntityProp', '2', 'entity_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('属性名称', '0', '1', '0', '', '1', '属性名称不能为空', '', '32', '0', 'varchar', '2018-01-07 09:36:23', null, 'ProjEntityProp', '2', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('允许空', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-07 09:40:29', null, 'ProjEntityProp', '2', 'is_null');
INSERT INTO `gen_proj_entity_prop` VALUES ('主键', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-07 09:40:48', null, 'ProjEntityProp', '2', 'is_pk');
INSERT INTO `gen_proj_entity_prop` VALUES ('排除', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-07 09:40:42', null, 'ProjEntityProp', '2', 'is_transient');
INSERT INTO `gen_proj_entity_prop` VALUES ('UUID', '0', '0', '0', '', '1', '', '', '1', '0', 'number', '2018-01-07 10:17:30', null, 'ProjEntityProp', '2', 'is_uuid');
INSERT INTO `gen_proj_entity_prop` VALUES ('最大', '0', '0', '0', '', '1', '', '', '11', '0', 'number', '2018-01-07 09:39:52', null, 'ProjEntityProp', '2', 'len_max');
INSERT INTO `gen_proj_entity_prop` VALUES ('最小', '0', '0', '0', '', '1', '', '', '11', '0', 'number', '2018-01-07 09:39:38', null, 'ProjEntityProp', '2', 'len_min');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-07 09:37:42', null, 'ProjEntityProp', '2', 'proj_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('属性描述', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-07 09:38:28', null, 'ProjEntityProp', '2', 'prop_desc');
INSERT INTO `gen_proj_entity_prop` VALUES ('属性标签', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-09 08:56:44', null, 'ProjEntityProp', '2', 'prop_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('数据类型', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-07 09:38:55', null, 'ProjEntityProp', '2', 'prop_type');
INSERT INTO `gen_proj_entity_prop` VALUES ('正则', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-07 09:40:36', null, 'ProjEntityProp', '2', 'regex');
INSERT INTO `gen_proj_entity_prop` VALUES ('验证消息', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-07 09:40:21', null, 'ProjEntityProp', '2', 'valid_msg');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-08 14:33:18', null, 'ProjForm', '2', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '0', '', '', '32', '0', 'varchar', '2018-01-08 14:31:51', null, 'ProjForm', '2', 'entity_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('表单描述', '0', '0', '0', '', '1', '', '', '256', '0', 'varchar', '2018-01-08 14:32:57', null, 'ProjForm', '2', 'form_desc');
INSERT INTO `gen_proj_entity_prop` VALUES ('表单名称', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-08 14:32:34', null, 'ProjForm', '2', 'form_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('表单类型', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-08 14:33:39', null, 'ProjForm', '2', 'form_type');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '1', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-08 14:27:30', null, 'ProjForm', '2', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '0', '', '', '32', '0', 'varchar', '2018-01-08 14:31:03', null, 'ProjForm', '2', 'proj_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('控件类型', '0', '0', '0', '', '1', '', '', '2', '0', 'number', '2018-01-08 15:04:16', null, 'ProjFormProp', '2', 'control_type');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '0', '0', '', '1', '', '', '0', '0', 'date', '2018-01-08 15:03:24', null, 'ProjFormProp', '2', 'create_time');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-08 15:01:29', null, 'ProjFormProp', '2', 'form_id');
INSERT INTO `gen_proj_entity_prop` VALUES ('', '0', '1', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-08 15:01:14', null, 'ProjFormProp', '2', 'id');
INSERT INTO `gen_proj_entity_prop` VALUES ('is_pk', '0', '0', '1', null, '1', null, null, '0', '0', 'number', '2018-01-10 09:33:00', null, 'ProjFormProp', '2', 'is_pk');
INSERT INTO `gen_proj_entity_prop` VALUES ('属性名称', '0', '0', '0', '', '1', '', '', '32', '0', 'varchar', '2018-01-08 15:02:59', null, 'ProjFormProp', '2', 'prop_name');
INSERT INTO `gen_proj_entity_prop` VALUES ('prop_type', '0', '0', '1', '', '1', '', '', '0', '0', 'varchar', '2018-01-08 17:08:59', null, 'ProjFormProp', '2', 'prop_type');
INSERT INTO `gen_proj_entity_prop` VALUES ('排序', '0', '0', '0', '', '1', '', '', '4', '0', 'number', '2018-01-08 15:03:53', null, 'ProjFormProp', '2', 'sort');

-- ----------------------------
-- Table structure for `gen_proj_form`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_form`;
CREATE TABLE `gen_proj_form` (
  `form_type` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `form_desc` varchar(256) DEFAULT NULL,
  `form_name` varchar(32) DEFAULT NULL,
  `entity_id` varchar(32) NOT NULL DEFAULT '',
  `proj_id` varchar(32) NOT NULL DEFAULT '',
  `id` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_form
-- ----------------------------
INSERT INTO `gen_proj_form` VALUES ('1', '2017-06-06 10:29:31', '用户', '添加用户', 'User', '1', '1');
INSERT INTO `gen_proj_form` VALUES ('2', '2017-06-06 10:29:44', '角色', '删除角色', '2', '1', '2');
INSERT INTO `gen_proj_form` VALUES ('3', '2017-12-19 11:51:46', '登陆用户', '修改登陆用户', '3', '1', '3');
INSERT INTO `gen_proj_form` VALUES ('4', '2018-01-02 08:55:08', null, '查询用户角色', '4', '1', '4');
INSERT INTO `gen_proj_form` VALUES ('add', null, '项目', '添加项目实体', 'ProjEntity', '2', '5');
INSERT INTO `gen_proj_form` VALUES ('edit', null, null, '修改项目实体', 'ProjEntity', '2', '6');

-- ----------------------------
-- Table structure for `gen_proj_form_prop`
-- ----------------------------
DROP TABLE IF EXISTS `gen_proj_form_prop`;
CREATE TABLE `gen_proj_form_prop` (
  `control_type` int(2) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `prop_name` varchar(32) DEFAULT NULL,
  `form_id` varchar(32) NOT NULL DEFAULT '',
  `id` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`form_id`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_proj_form_prop
-- ----------------------------
INSERT INTO `gen_proj_form_prop` VALUES ('1', '4', '2017-07-31 15:41:15', '注册日期', '1', 'create_time');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 10:26:50', '性别', '1', 'sex');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '1', '2017-06-06 10:29:31', '用户名', '1', 'user_name');
INSERT INTO `gen_proj_form_prop` VALUES ('11', '2', '2017-06-06 10:29:44', '密码', '1', 'user_pass');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 08:50:33', '', '2', 'id');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '2', '2018-01-02 14:24:03', null, '3', 'create_time');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'id');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'role_desc');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'role_id');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'role_name');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'sex');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'user_name');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 14:24:03', null, '3', 'user_pass');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 08:56:55', '', '4', 'role_id');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', '2018-01-02 08:56:34', '', '4', 'user_id');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '4', null, '表名', '5', 'db_tab_name');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '3', null, '实体描述', '5', 'entity_desc');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '2', null, '实体标签', '5', 'entity_name');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '1', null, '实体名称', '5', 'id');
INSERT INTO `gen_proj_form_prop` VALUES ('14', '0', null, null, '5', 'proj_id');
INSERT INTO `gen_proj_form_prop` VALUES ('12', '5', null, 'SQL语句', '5', 'sqls');
INSERT INTO `gen_proj_form_prop` VALUES ('1', '1', null, '实体名称', '6', 'id');
INSERT INTO `gen_proj_form_prop` VALUES ('14', '0', null, null, '6', 'proj_id');

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
INSERT INTO `s_cfg` VALUES ('1', 'value_', '参数1', '2017-06-06 10:29:31', '描述1');
INSERT INTO `s_cfg` VALUES ('2', '456', '参数2', '2018-04-30 09:30:57', '描述2');

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
  `pid` varchar(255) DEFAULT NULL,
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
  `real_name` varchar(255) DEFAULT NULL,
  `alipay_account` varchar(255) DEFAULT NULL,
  `wx_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', null, 'hx', 'e10adc3949ba59abbe56e057f20f883e', '1', '123', '1231', '23123', '就不告诉你', '2017-06-07 15:58:16', '2017-06-07 15:58:16', '1', '阿德斯', null, null);
INSERT INTO `s_user` VALUES ('2', null, 'wy', '2017-06-06 10:29:44', '0', null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `s_user` VALUES ('22c14bc40b464618a7b1b4631e1e4b44', null, 'hxi', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, null, '2017-06-07 15:58:16', '1', null, null, null);

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
