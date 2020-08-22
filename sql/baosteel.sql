/*
 Navicat Premium Data Transfer

 Source Server         : docker-mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3307
 Source Schema         : baosteel

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 22/08/2020 08:59:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for after_monitor_ten_images
-- ----------------------------
DROP TABLE IF EXISTS `after_monitor_ten_images`;
CREATE TABLE `after_monitor_ten_images` (
  `after_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键idz自增',
  `after_image_name` varchar(20) NOT NULL COMMENT '关联表 monitor_ten_pre_images',
  `after_monitor_number` int NOT NULL COMMENT '关联表 monitor_ten_pre_images',
  `after_image_file` varchar(200) NOT NULL COMMENT '识别程序存放的文件地址',
  `after_image_url` varchar(200) NOT NULL COMMENT '识别程序后的图片网址',
  `after_is_warnning` int NOT NULL COMMENT '是否报警',
  `after_warnning_info` varchar(200) DEFAULT NULL COMMENT '具体的报警信息',
  `after_warnning_coord` varchar(200) DEFAULT NULL COMMENT '报警信息的具体坐标',
  `after_detection_image` datetime NOT NULL COMMENT '识别程序的写入时间',
  PRIMARY KEY (`after_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of after_monitor_ten_images
-- ----------------------------
BEGIN;
INSERT INTO `after_monitor_ten_images` VALUES (1, '4852.jpg', 10, '/Users/homewang/Documents/JavaCode/JavaEECode/baosteel/ImageUploadService/img/10/after\n', 'http://image.baosteel.com/img/10/after/4852.jpg', 0, NULL, NULL, '2020-08-20 11:34:36');
INSERT INTO `after_monitor_ten_images` VALUES (2, '4853.jpg', 10, '/Users/homewang/Documents/JavaCode/JavaEECode/baosteel/ImageUploadService/img/10/after\n', 'http://image.baosteel.com/img/10/after/4853.jpg', 0, NULL, NULL, '2020-08-20 11:35:36');
INSERT INTO `after_monitor_ten_images` VALUES (3, '4854.jpg', 10, '/Users/homewang/Documents/JavaCode/JavaEECode/baosteel/ImageUploadService/img/10/after\n', 'http://image.baosteel.com/img/10/after/4854.jpg', 0, NULL, NULL, '2020-08-21 11:35:36');
COMMIT;

-- ----------------------------
-- Table structure for bs_menus
-- ----------------------------
DROP TABLE IF EXISTS `bs_menus`;
CREATE TABLE `bs_menus` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `authName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `path` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问路径',
  `order` int DEFAULT NULL COMMENT '菜单顺序',
  `pid` int DEFAULT NULL COMMENT '父级id',
  `level` int DEFAULT NULL COMMENT '菜单等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_menus
-- ----------------------------
BEGIN;
INSERT INTO `bs_menus` VALUES (100, '监控管理', 'monitor', 1, 0, 0);
INSERT INTO `bs_menus` VALUES (101, '监控管理1', 'monitor1', 2, 0, 0);
INSERT INTO `bs_menus` VALUES (102, '监控管理2', 'monitor2', 3, 0, 0);
INSERT INTO `bs_menus` VALUES (103, '监控管理3', 'monitor3', 4, 0, 0);
INSERT INTO `bs_menus` VALUES (104, '监控管理4', 'monitor4', 5, 0, 0);
INSERT INTO `bs_menus` VALUES (200, '10号口监控', 'monitor-10', 1, 100, 1);
INSERT INTO `bs_menus` VALUES (201, '11号口监控', 'monitor-11', 2, 100, 1);
INSERT INTO `bs_menus` VALUES (202, '12号口监控', 'monitor-12', 3, 100, 1);
INSERT INTO `bs_menus` VALUES (203, '监控管理11', 'monitor-21', 1, 101, 1);
INSERT INTO `bs_menus` VALUES (204, '监控管理12', 'monitor-22', 2, 101, 1);
COMMIT;

-- ----------------------------
-- Table structure for pre_monitor_ten_images
-- ----------------------------
DROP TABLE IF EXISTS `pre_monitor_ten_images`;
CREATE TABLE `pre_monitor_ten_images` (
  `pre_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pre_monitor_number` int NOT NULL COMMENT '监控摄像头编号',
  `pre_image_name` varchar(50) NOT NULL COMMENT '从本地上传到服务器的图片名称',
  `pre_image_file` varchar(100) NOT NULL COMMENT '服务器文件存储位置',
  `pre_image_url` varchar(200) NOT NULL COMMENT '静态资源url路径',
  `pre_create_time` datetime NOT NULL COMMENT '图像文件的上传时间',
  PRIMARY KEY (`pre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_monitor_ten_images
-- ----------------------------
BEGIN;
INSERT INTO `pre_monitor_ten_images` VALUES (1, 10, '4852.jpg', '/Users/homewang/Documents/JavaCode/JavaEECode/baosteel/ImageUploadService/img/10/pre', 'http://image.baosteel.com/img/10/pre/4852.jpg', '2020-08-20 11:34:32');
INSERT INTO `pre_monitor_ten_images` VALUES (2, 10, '4853.jpg', '/Users/homewang/Documents/JavaCode/JavaEECode/baosteel/ImageUploadService/img/10/pre', 'http://image.baosteel.com/img/10/pre/4853.jpg', '2020-08-20 11:35:32');
INSERT INTO `pre_monitor_ten_images` VALUES (3, 10, '4854.jpg', '/Users/homewang/Documents/JavaCode/JavaEECode/baosteel/ImageUploadService/img/10/pre', 'http://image.baosteel.com/img/10/pre/4854.jpg', '2020-08-21 11:35:32');
COMMIT;

-- ----------------------------
-- Table structure for user_manager
-- ----------------------------
DROP TABLE IF EXISTS `user_manager`;
CREATE TABLE `user_manager` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册手机号',
  `created` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user_manager
-- ----------------------------
BEGIN;
INSERT INTO `user_manager` VALUES (28, 'admin', '123456', '11012013011', '2020-08-12 21:18:23');
INSERT INTO `user_manager` VALUES (29, 'test', '123456', '11122233344', '2020-08-12 20:57:30');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
