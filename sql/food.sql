/*
Navicat MySQL Data Transfer

Source Server         : mysql001
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : wx

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `foodid` varchar(10) NOT NULL,
  `foodname` varchar(10) DEFAULT NULL,
  `foodprice` double DEFAULT NULL,
  `fooddesc` varchar(20) DEFAULT NULL,
  `foodicon` varchar(50) DEFAULT NULL,
  `foodimage` varchar(50) DEFAULT NULL,
  `foodtypeid` int(11) DEFAULT NULL,
  `foodstatus` int(11) DEFAULT NULL,
  `foodcount` int(11) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('f101', '馒头', '11', '好吃', null, null, '2', '1', '100', '2019-07-03', '2019-07-08 11:33:47');
INSERT INTO `food` VALUES ('f102', '包子', '22', '好吃', null, null, '2', '1', '100', '2019-07-09', '2019-07-08 11:33:50');
INSERT INTO `food` VALUES ('f103', '蛋糕', '44', '好吃', null, null, '3', '1', '100', '2019-07-09', '2019-07-08 11:33:58');
INSERT INTO `food` VALUES ('f104', '布丁', '33', '好吃', null, null, '1', '1', '100', '2019-07-02', '2019-07-08 11:33:54');

-- ----------------------------
-- Table structure for `foodtype`
-- ----------------------------
DROP TABLE IF EXISTS `foodtype`;
CREATE TABLE `foodtype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(10) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of foodtype
-- ----------------------------
INSERT INTO `foodtype` VALUES ('1', '甜食', '2019-07-08', '2019-07-08 11:29:40');
INSERT INTO `foodtype` VALUES ('2', '主食', '2019-07-08', '2019-07-08 11:29:40');
INSERT INTO `foodtype` VALUES ('3', '零食', '2019-07-08', '2019-07-08 11:29:40');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `detailid` varchar(20) NOT NULL,
  `orderid` varchar(30) DEFAULT NULL,
  `productid` varchar(10) DEFAULT NULL,
  `productcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`detailid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', 'order101', 'f101', '10');
INSERT INTO `orderdetail` VALUES ('2', 'order101', 'f102', '10');
INSERT INTO `orderdetail` VALUES ('3', 'order101', 'f103', '20');
INSERT INTO `orderdetail` VALUES ('4', 'order102', 'f101', '30');
INSERT INTO `orderdetail` VALUES ('5', 'order102', 'f104', '40');
INSERT INTO `orderdetail` VALUES ('6', 'order103', 'f102', '50');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` varchar(30) NOT NULL,
  `openid` varchar(20) DEFAULT NULL,
  `buyerName` varchar(20) DEFAULT NULL,
  `buyerPhone` varchar(11) DEFAULT NULL,
  `buyerAddress` varchar(50) DEFAULT NULL,
  `orderAmount` double DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `payStatus` int(11) DEFAULT NULL,
  `orderdesc` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('order101', 'wx110', '谢旭', '137...', '北科', '200', '1', '1', '不加辣', '2019-07-15 11:46:45', '2019-07-08 11:46:47');
INSERT INTO `orders` VALUES ('order102', 'wx120', '刘蒋杰', '182....', '北科', '100', '2', '1', '不加辣', '2019-07-08 11:46:48', '2019-07-08 11:46:50');
INSERT INTO `orders` VALUES ('order103', 'wx110', '陈辉', '180....', '北科', '50', '3', '2', '不加辣', '2019-07-11 11:46:51', '2019-07-08 11:46:53');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(5) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '张三', '110', 'wx110', '北京');
INSERT INTO `users` VALUES ('2', '李四', '120', 'wx120', '上海');
INSERT INTO `users` VALUES ('3', '王五', '119', 'wx119', '广州');
INSERT INTO `users` VALUES ('4', '赵柳', '911', 'wx911', '南京');
