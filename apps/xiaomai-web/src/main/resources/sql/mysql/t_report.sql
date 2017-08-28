/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2015-08-11 23:33:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_report`
-- ----------------------------
DROP TABLE IF EXISTS `t_report`;
CREATE TABLE `t_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comments_num` int(11) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `content` longtext,
  `create_date` datetime DEFAULT NULL,
  `dep_id` bigint(20) DEFAULT NULL,
  `loc_lat` double DEFAULT NULL,
  `loc_lng` double DEFAULT NULL,
  `loc_str` varchar(200) DEFAULT NULL,
  `reading_num` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `userimage` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_report
-- ----------------------------
