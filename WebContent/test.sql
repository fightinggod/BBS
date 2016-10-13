/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2016-03-14 23:52:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) DEFAULT NULL,
  `Sex` char(2) DEFAULT NULL,
  `BirthDay` date DEFAULT NULL,
  `Interest` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1001', '小明', '男', '1989-02-26', '读书');
