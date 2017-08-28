/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2015-08-11 23:33:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_report_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_report_user`;
CREATE TABLE `t_report_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_reader` bit(1) DEFAULT NULL,
  `report_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_report_user
-- ----------------------------
