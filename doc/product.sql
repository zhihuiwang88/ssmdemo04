/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-12-26 16:59:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_amount` int(64) NOT NULL COMMENT '商品数量',
  `product_status` tinyint(5) NOT NULL COMMENT '商品状态默认0,1上架0下架',
  `product_price` decimal(10,3) NOT NULL COMMENT '单价',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_product_name` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('15', '葡萄4', '23', '0', '3.346', '2019-12-23 19:36:57', '2019-12-25 14:34:26');
INSERT INTO `product` VALUES ('16', '紅薯', '23', '0', '3.346', '2019-12-23 19:46:43', '2019-12-23 19:46:43');
INSERT INTO `product` VALUES ('17', '紅薯1', '23', '0', '3.346', '2019-12-23 19:47:51', '2019-12-23 19:47:51');
INSERT INTO `product` VALUES ('18', '紅薯2', '23', '0', '3.346', '2019-12-23 19:49:48', '2019-12-23 19:49:48');
INSERT INTO `product` VALUES ('19', '紅薯3', '23', '0', '3.346', '2019-12-23 19:51:06', '2019-12-23 19:51:06');
INSERT INTO `product` VALUES ('20', '紅薯4', '23', '0', '3.346', '2019-12-23 19:55:29', '2019-12-23 19:55:29');
INSERT INTO `product` VALUES ('21', '紅薯5', '23', '0', '3.346', '2019-12-23 19:56:04', '2019-12-23 19:56:04');
INSERT INTO `product` VALUES ('23', '大米', '23', '0', '3.346', '2019-12-23 19:58:20', '2019-12-23 19:58:20');
INSERT INTO `product` VALUES ('24', '大米1', '23', '0', '3.346', '2019-12-23 19:59:10', '2019-12-23 19:59:10');
INSERT INTO `product` VALUES ('25', '大米2', '23', '0', '3.346', '2019-12-23 19:59:32', '2019-12-23 19:59:32');
INSERT INTO `product` VALUES ('26', '大米3', '23', '0', '3.346', '2019-12-23 20:01:12', '2019-12-23 20:01:12');
INSERT INTO `product` VALUES ('27', '香蕉5', '100', '1', '5.555', '2019-12-23 20:02:05', '2019-12-25 15:38:43');
INSERT INTO `product` VALUES ('28', '大米5', '23', '0', '3.346', '2019-12-23 20:02:36', '2019-12-23 20:02:36');
INSERT INTO `product` VALUES ('29', '香蕉2', '100', '1', '5.555', '2019-12-23 20:10:00', '2019-12-25 15:26:39');
INSERT INTO `product` VALUES ('30', '香蕉3', '100', '0', '5.555', '2019-12-24 09:36:42', '2019-12-25 15:32:16');
INSERT INTO `product` VALUES ('60', '小米6', '4', '1', '3.301', '2019-12-24 16:23:58', '2019-12-24 16:23:58');
INSERT INTO `product` VALUES ('61', '小米7', '4', '1', '3.301', '2019-12-24 16:35:25', '2019-12-24 16:35:25');
INSERT INTO `product` VALUES ('62', '小米8', '4', '1', '3.301', '2019-12-24 16:40:34', '2019-12-24 16:40:34');
INSERT INTO `product` VALUES ('63', '小米9', '4', '0', '3.301', '2019-12-24 18:32:32', '2019-12-24 18:32:32');
INSERT INTO `product` VALUES ('64', '油条11', '100', '1', '100.230', '2019-12-24 18:33:40', '2019-12-24 19:16:55');
INSERT INTO `product` VALUES ('65', '油条10', '100', '1', '100.230', '2019-12-24 18:43:00', '2019-12-24 19:14:25');
INSERT INTO `product` VALUES ('66', '油条0', '100', '1', '100.230', '2019-12-24 18:51:14', '2019-12-24 19:10:23');
INSERT INTO `product` VALUES ('67', '油条4', '4', '0', '3.000', '2019-12-24 19:36:14', '2019-12-24 19:36:14');
INSERT INTO `product` VALUES ('68', '油条1', '4', '0', '33.000', '2019-12-24 19:36:46', '2019-12-24 19:36:46');
INSERT INTO `product` VALUES ('69', '油条2', '4', '0', '33.100', '2019-12-24 19:46:36', '2019-12-24 19:46:36');
INSERT INTO `product` VALUES ('70', '油条3', '4', '0', '55.060', '2019-12-24 19:51:47', '2019-12-24 19:51:47');
INSERT INTO `product` VALUES ('71', '油条5', '4', '1', '55.070', '2019-12-24 19:52:14', '2019-12-25 09:18:24');
INSERT INTO `product` VALUES ('72', '油条6', '4', '1', '0.030', '2019-12-24 19:53:53', '2019-12-25 09:17:13');
INSERT INTO `product` VALUES ('73', '好好6', '100', '0', '5.555', '2019-12-25 15:12:48', '2019-12-25 15:12:48');
INSERT INTO `product` VALUES ('74', '香蕉0', '100', '0', '5.555', '2019-12-25 15:21:09', '2019-12-25 15:21:09');
INSERT INTO `product` VALUES ('75', '香蕉4', '100', '0', '5.555', '2019-12-25 15:36:30', '2019-12-25 15:36:30');
INSERT INTO `product` VALUES ('76', '香梨1', '100', '0', '5.555', '2019-12-26 14:57:02', '2019-12-26 14:57:02');
INSERT INTO `product` VALUES ('77', '香蕉9', '20', '1', '5.555', '2019-12-26 15:51:39', '2019-12-26 16:43:01');
