/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-01-10 21:15:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_server_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_server_info`;
CREATE TABLE `t_server_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(36) NOT NULL DEFAULT '' COMMENT '主机地址',
  `port` int(5) NOT NULL DEFAULT '0' COMMENT '端口号',
  `config_path` varchar(128) NOT NULL DEFAULT '' COMMENT '配置文件路径',
  `remark` varchar(256) DEFAULT '' COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_server_info
-- ----------------------------
INSERT INTO `t_server_info` VALUES ('1', '127.0.0.1', '2181', 'E:\\zookeeper-3.4.9\\conf\\zoo1.cfg', '');
INSERT INTO `t_server_info` VALUES ('2', '127.0.0.1', '2182', 'E:\\zookeeper-3.4.9\\conf\\zoo2.cfg', '');
INSERT INTO `t_server_info` VALUES ('3', '127.0.0.1', '2183', 'E:\\zookeeper-3.4.9\\conf\\zoo3.cfg', '');
