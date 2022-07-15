/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : hiwms

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 15/07/2022 23:02:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goods_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_size` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_value` double NOT NULL,
  `goods_number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (127, '汤圆', '2', '2', 20, 2);
INSERT INTO `goods` VALUES (128, '薯片', '2', '4', 10, 2);
INSERT INTO `goods` VALUES (130, '纸巾', '8', '4', 2, 21);
INSERT INTO `goods` VALUES (133, '龙眼', '10', '4', 10, NULL);
INSERT INTO `goods` VALUES (134, '茄子', '10', '4', 2, NULL);
INSERT INTO `goods` VALUES (138, '飞天茅台', '6', '10', 3000, NULL);
INSERT INTO `goods` VALUES (140, '洗发水', '3', '500ml', 98, NULL);
INSERT INTO `goods` VALUES (141, '湿巾', '5', '10pics', 10, NULL);
INSERT INTO `goods` VALUES (142, '吹风机', '7', '1200w', 598, NULL);

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goods_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`inventory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 136 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES (126, '榴莲', '52', '果蔬1');
INSERT INTO `inventory` VALUES (127, '汤圆', '43', '零食1');
INSERT INTO `inventory` VALUES (128, '薯片', '40', '零食1');
INSERT INTO `inventory` VALUES (130, '苹果', '37', '果蔬3');
INSERT INTO `inventory` VALUES (131, '纸巾', '60', '电器1');
INSERT INTO `inventory` VALUES (133, '矿泉水', '35', '电器2');
INSERT INTO `inventory` VALUES (134, '火龙果', '27', '冷冻2');
INSERT INTO `inventory` VALUES (135, '茄子', '35', '果蔬2');

-- ----------------------------
-- Table structure for low_warning
-- ----------------------------
DROP TABLE IF EXISTS `low_warning`;
CREATE TABLE `low_warning`  (
  `goods_id` int(11) NOT NULL,
  `min_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of low_warning
-- ----------------------------
INSERT INTO `low_warning` VALUES (126, 30);
INSERT INTO `low_warning` VALUES (127, 30);
INSERT INTO `low_warning` VALUES (128, 30);
INSERT INTO `low_warning` VALUES (130, 30);
INSERT INTO `low_warning` VALUES (131, 30);
INSERT INTO `low_warning` VALUES (133, 30);

-- ----------------------------
-- Table structure for msgs
-- ----------------------------
DROP TABLE IF EXISTS `msgs`;
CREATE TABLE `msgs`  (
  `msgs_id` int(11) NOT NULL AUTO_INCREMENT,
  `msgs_cont` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`msgs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msgs
-- ----------------------------
INSERT INTO `msgs` VALUES (1, '有新的入库申请了', 0, NULL);
INSERT INTO `msgs` VALUES (2, '有新的入库申请了', 0, NULL);
INSERT INTO `msgs` VALUES (3, '有新的入库申请了', 0, NULL);
INSERT INTO `msgs` VALUES (4, '有新的入库申请了', 0, NULL);
INSERT INTO `msgs` VALUES (5, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (6, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (7, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (8, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (9, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (10, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (11, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (12, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (13, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (14, '有新的出库申请', 0, NULL);
INSERT INTO `msgs` VALUES (15, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (16, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (17, '申请已完成', 0, NULL);
INSERT INTO `msgs` VALUES (18, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (19, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (20, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (21, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (22, '申请已完成', 0, NULL);
INSERT INTO `msgs` VALUES (23, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (24, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (25, '申请已完成', 0, NULL);
INSERT INTO `msgs` VALUES (26, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (27, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (28, '申请已完成', 0, NULL);
INSERT INTO `msgs` VALUES (29, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (30, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (31, '申请已完成', 0, NULL);
INSERT INTO `msgs` VALUES (32, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (33, '有新的待处理操作', 0, NULL);
INSERT INTO `msgs` VALUES (34, '有新的入库申请', 0, 1164);
INSERT INTO `msgs` VALUES (35, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (36, '有新的入库申请', 0, 1166);
INSERT INTO `msgs` VALUES (37, '有新的待处理操作', 0, 241);
INSERT INTO `msgs` VALUES (38, '有新的待处理操作', 0, 240);
INSERT INTO `msgs` VALUES (39, '申请已完成', 0, 240);
INSERT INTO `msgs` VALUES (40, '申请已完成', 0, 189);
INSERT INTO `msgs` VALUES (41, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (42, '有新的出库申请', 0, NULL);
INSERT INTO `msgs` VALUES (43, '有新的入库申请', 0, 251);
INSERT INTO `msgs` VALUES (44, '有新的入库申请', 0, 252);
INSERT INTO `msgs` VALUES (45, '有新的入库申请', 0, 253);
INSERT INTO `msgs` VALUES (46, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (47, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (48, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (49, '有新的入库申请', 0, NULL);
INSERT INTO `msgs` VALUES (50, '有新的入库申请', 0, 1175);
INSERT INTO `msgs` VALUES (51, '有新的入库申请', 0, 1176);
INSERT INTO `msgs` VALUES (52, '有新的出库申请', 0, 20080);
INSERT INTO `msgs` VALUES (53, '申请已完成', 0, 241);
INSERT INTO `msgs` VALUES (54, '申请已完成', 0, 202);
INSERT INTO `msgs` VALUES (55, '有新的待处理操作', 0, 201);
INSERT INTO `msgs` VALUES (56, '有新的待处理操作', 0, 209);
INSERT INTO `msgs` VALUES (57, '有新的待处理操作', 0, 210);
INSERT INTO `msgs` VALUES (58, '有新的待处理操作', 0, 215);
INSERT INTO `msgs` VALUES (59, '申请已完成', 0, 201);
INSERT INTO `msgs` VALUES (60, '申请已完成', 0, 215);
INSERT INTO `msgs` VALUES (61, '有新的入库申请', 0, 1177);
INSERT INTO `msgs` VALUES (62, '有新的出库申请', 0, 20081);
INSERT INTO `msgs` VALUES (63, '有新的出库申请', 0, 268);
INSERT INTO `msgs` VALUES (64, '有新的入库申请', 0, 269);
INSERT INTO `msgs` VALUES (65, '有新的待处理操作', 0, 206);
INSERT INTO `msgs` VALUES (66, '有新的待处理操作', 0, 207);
INSERT INTO `msgs` VALUES (67, '有新的入库申请', 0, 1179);
INSERT INTO `msgs` VALUES (68, '有新的出库申请', 0, 20083);
INSERT INTO `msgs` VALUES (69, '有新的入库申请', 0, 272);
INSERT INTO `msgs` VALUES (70, '有新的出库申请', 0, 273);
INSERT INTO `msgs` VALUES (71, '有新的待处理操作', 0, 221);
INSERT INTO `msgs` VALUES (72, '有新的入库申请', 0, 274);
INSERT INTO `msgs` VALUES (73, '有新的入库申请', 0, 275);
INSERT INTO `msgs` VALUES (74, '有新的入库申请', 0, 276);
INSERT INTO `msgs` VALUES (75, '有新的出库申请', 0, 277);
INSERT INTO `msgs` VALUES (76, '申请已完成', 0, 207);
INSERT INTO `msgs` VALUES (77, '有新的入库申请', 0, 278);
INSERT INTO `msgs` VALUES (78, '有新的待处理操作', 0, 278);
INSERT INTO `msgs` VALUES (79, '有新的入库申请', 0, 279);
INSERT INTO `msgs` VALUES (80, '有新的待处理操作', 0, 279);
INSERT INTO `msgs` VALUES (81, '申请已完成', 3, 279);
INSERT INTO `msgs` VALUES (82, '有新的待处理操作', 2, 267);
INSERT INTO `msgs` VALUES (83, '有新的出库申请', 0, 280);
INSERT INTO `msgs` VALUES (84, '有新的入库申请', 0, 281);
INSERT INTO `msgs` VALUES (85, '有新的待处理操作', 0, 281);
INSERT INTO `msgs` VALUES (86, '申请已完成', 3, 281);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_type` int(2) NULL DEFAULT NULL,
  `order_start_time` datetime(0) NULL DEFAULT NULL,
  `order_end_time` datetime(0) NULL DEFAULT NULL,
  `order_status` int(2) NULL DEFAULT NULL,
  `order_init` int(255) NULL DEFAULT NULL,
  `order_operator` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 282 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (116, 1, '2022-07-02 10:41:02', '2022-07-07 05:55:28', 12, 11, 34);
INSERT INTO `orders` VALUES (117, 2, '2022-07-02 10:41:09', '2022-07-07 03:55:22', 22, 11, 4);
INSERT INTO `orders` VALUES (168, 1, '2022-07-02 08:35:19', '2022-07-11 08:09:58', 12, 11, 4);
INSERT INTO `orders` VALUES (180, 1, '2022-07-02 04:05:12', '2022-07-12 09:48:44', 12, 11, 4);
INSERT INTO `orders` VALUES (189, 1, '2022-07-02 11:29:50', '2022-07-13 05:03:43', 12, 11, 4);
INSERT INTO `orders` VALUES (201, 1, '2022-07-02 05:57:24', '2022-07-13 08:16:03', 12, 11, 4);
INSERT INTO `orders` VALUES (202, 2, '2022-07-02 06:59:53', '2022-07-13 07:21:13', 22, 11, 4);
INSERT INTO `orders` VALUES (206, 1, '2022-07-02 10:00:13', NULL, 11, 11, 4);
INSERT INTO `orders` VALUES (207, 1, '2022-07-03 10:00:13', '2022-07-14 05:55:05', 12, 11, 4);
INSERT INTO `orders` VALUES (213, 1, '2022-07-04 04:36:31', '2022-07-12 04:37:59', 12, 11, 34);
INSERT INTO `orders` VALUES (214, 1, '2022-07-05 09:00:57', '2022-07-12 09:03:31', 12, 11, 4);
INSERT INTO `orders` VALUES (215, 1, '2022-07-05 03:17:14', '2022-07-13 08:16:15', 12, 11, 4);
INSERT INTO `orders` VALUES (224, 1, '2022-07-09 03:52:53', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (225, 1, '2022-07-09 03:54:53', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (226, 1, '2022-07-09 03:55:46', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (227, 1, '2022-07-09 03:58:36', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (228, 1, '2022-07-09 03:59:23', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (229, 1, '2022-07-09 04:06:07', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (230, 1, '2022-07-09 04:06:12', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (231, 1, '2022-07-10 04:12:13', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (232, 1, '2022-07-10 04:15:32', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (233, 1, '2022-07-10 04:16:08', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (234, 1, '2022-07-10 04:17:15', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (235, 1, '2022-07-10 04:19:02', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (236, 1, '2022-07-11 04:19:42', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (237, 1, '2022-07-11 04:21:35', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (238, 1, '2022-07-11 04:35:28', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (239, 1, '2022-07-12 04:46:54', NULL, 10, 11, NULL);
INSERT INTO `orders` VALUES (240, 1, '2022-07-12 05:01:31', '2022-07-13 05:03:40', 12, 4, 4);
INSERT INTO `orders` VALUES (241, 1, '2022-07-12 05:02:48', '2022-07-13 07:21:08', 12, 11, 4);
INSERT INTO `orders` VALUES (244, 1, '2022-07-13 05:31:57', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (245, 2, '2022-07-13 05:32:05', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (251, 1, '2022-07-13 06:03:17', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (252, 1, '2022-07-13 06:14:17', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (263, 1, '2022-07-13 07:15:53', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (264, 1, '2022-07-13 07:16:40', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (265, 2, '2022-07-13 07:19:42', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (266, 1, '2022-07-14 09:31:52', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (267, 2, '2022-07-14 09:31:59', NULL, 21, 104, 84);
INSERT INTO `orders` VALUES (268, 2, '2022-07-14 09:33:32', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (269, 1, '2022-07-14 09:33:39', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (270, 1, '2022-07-14 10:41:49', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (271, 2, '2022-07-14 10:41:56', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (272, 1, '2022-07-14 10:41:55', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (273, 2, '2022-07-14 10:42:29', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (274, 1, '2022-07-14 11:52:17', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (275, 1, '2022-07-14 11:52:17', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (276, 1, '2022-07-14 05:51:46', NULL, 10, 104, NULL);
INSERT INTO `orders` VALUES (277, 2, '2022-07-14 05:51:54', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (278, 1, '2022-07-14 08:50:38', NULL, 11, 104, 78);
INSERT INTO `orders` VALUES (279, 1, '2022-07-14 09:17:23', '2022-07-14 09:18:39', 12, 104, 78);
INSERT INTO `orders` VALUES (280, 2, '2022-07-15 10:03:12', NULL, 20, 104, NULL);
INSERT INTO `orders` VALUES (281, 1, '2022-07-15 11:52:56', '2022-07-15 11:54:34', 12, 112, 106);

-- ----------------------------
-- Table structure for stockin
-- ----------------------------
DROP TABLE IF EXISTS `stockin`;
CREATE TABLE `stockin`  (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_number` int(11) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`stock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1187 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stockin
-- ----------------------------
INSERT INTO `stockin` VALUES (1075, '薯片', 2, 116);
INSERT INTO `stockin` VALUES (1077, '汤圆', 2, 121);
INSERT INTO `stockin` VALUES (1078, '榴莲', 4, 122);
INSERT INTO `stockin` VALUES (1079, '纸巾', 21, 123);
INSERT INTO `stockin` VALUES (1080, '薯片', 2, 124);
INSERT INTO `stockin` VALUES (1081, '汤圆', 2, 125);
INSERT INTO `stockin` VALUES (1082, '薯片', 2, 126);
INSERT INTO `stockin` VALUES (1083, '榴莲', 4, 127);
INSERT INTO `stockin` VALUES (1084, '纸巾', 21, 128);
INSERT INTO `stockin` VALUES (1085, '榴莲', 4, 129);
INSERT INTO `stockin` VALUES (1086, '汤圆', 2, 130);
INSERT INTO `stockin` VALUES (1087, '榴莲', 4, 131);
INSERT INTO `stockin` VALUES (1088, '榴莲', 4, 132);
INSERT INTO `stockin` VALUES (1092, '龙眼', 10, 143);
INSERT INTO `stockin` VALUES (1093, '龙眼', NULL, 144);
INSERT INTO `stockin` VALUES (1094, '薯片', 2, 145);
INSERT INTO `stockin` VALUES (1095, '龙眼', NULL, 146);
INSERT INTO `stockin` VALUES (1096, '薯片', 2, 147);
INSERT INTO `stockin` VALUES (1097, '龙眼', NULL, 148);
INSERT INTO `stockin` VALUES (1098, '薯片', 2, 149);
INSERT INTO `stockin` VALUES (1099, '龙眼', NULL, 150);
INSERT INTO `stockin` VALUES (1100, '薯片', 2, 151);
INSERT INTO `stockin` VALUES (1101, '薯片', 2, 152);
INSERT INTO `stockin` VALUES (1102, '龙眼', NULL, 153);
INSERT INTO `stockin` VALUES (1103, '薯片', 2, 154);
INSERT INTO `stockin` VALUES (1104, '龙眼', NULL, 155);
INSERT INTO `stockin` VALUES (1105, '龙眼', NULL, 156);
INSERT INTO `stockin` VALUES (1106, '薯片', 2, 157);
INSERT INTO `stockin` VALUES (1107, '榴莲', 4, 158);
INSERT INTO `stockin` VALUES (1108, '榴莲', 4, 159);
INSERT INTO `stockin` VALUES (1109, '汤圆', 2, 161);
INSERT INTO `stockin` VALUES (1110, '汤圆', 2, 162);
INSERT INTO `stockin` VALUES (1111, '汤圆', 2, 163);
INSERT INTO `stockin` VALUES (1112, '汤圆', 4, 168);
INSERT INTO `stockin` VALUES (1113, '薯片', 1, 171);
INSERT INTO `stockin` VALUES (1114, '纸巾', 1, 173);
INSERT INTO `stockin` VALUES (1115, '纸巾', 2, 175);
INSERT INTO `stockin` VALUES (1116, '龙眼', 3, 176);
INSERT INTO `stockin` VALUES (1117, '纸巾', 2, 177);
INSERT INTO `stockin` VALUES (1118, '纸巾', 2, 179);
INSERT INTO `stockin` VALUES (1119, '苹果', 2, 180);
INSERT INTO `stockin` VALUES (1120, '苹果', 3, 181);
INSERT INTO `stockin` VALUES (1121, '纸巾', 2, 182);
INSERT INTO `stockin` VALUES (1122, '苹果', 4, 183);
INSERT INTO `stockin` VALUES (1123, '纸巾', 2, 184);
INSERT INTO `stockin` VALUES (1124, '苹果', 2, 185);
INSERT INTO `stockin` VALUES (1125, '纸巾', 4, 186);
INSERT INTO `stockin` VALUES (1126, '汤圆', 3, 187);
INSERT INTO `stockin` VALUES (1127, '薯片', 4, 188);
INSERT INTO `stockin` VALUES (1128, '薯片', 4, 189);
INSERT INTO `stockin` VALUES (1129, '汤圆', 2, 190);
INSERT INTO `stockin` VALUES (1130, '汤圆', 2, 191);
INSERT INTO `stockin` VALUES (1131, '榴莲', 3, 192);
INSERT INTO `stockin` VALUES (1132, '薯片', 20, 193);
INSERT INTO `stockin` VALUES (1133, '榴莲', 20, 194);
INSERT INTO `stockin` VALUES (1134, '薯片', 10, 195);
INSERT INTO `stockin` VALUES (1135, '汤圆', 10, 197);
INSERT INTO `stockin` VALUES (1136, '榴莲', 5, 196);
INSERT INTO `stockin` VALUES (1137, '薯片', 5, 198);
INSERT INTO `stockin` VALUES (1138, '榴莲', 2, 199);
INSERT INTO `stockin` VALUES (1139, '汤圆', 1, 200);
INSERT INTO `stockin` VALUES (1140, '榴莲', 2, 201);
INSERT INTO `stockin` VALUES (1141, '纸巾', 8, 205);
INSERT INTO `stockin` VALUES (1142, '苹果', 5, 204);
INSERT INTO `stockin` VALUES (1143, '火龙果', 10, 203);
INSERT INTO `stockin` VALUES (1144, '榴莲', 5, 206);
INSERT INTO `stockin` VALUES (1145, '汤圆', 5, 207);
INSERT INTO `stockin` VALUES (1146, '汤圆', 10, 213);
INSERT INTO `stockin` VALUES (1147, '汤圆', 20, 214);
INSERT INTO `stockin` VALUES (1148, '薯片', 10, 215);
INSERT INTO `stockin` VALUES (1149, '薯片', 1, 224);
INSERT INTO `stockin` VALUES (1150, '薯片', 2, 225);
INSERT INTO `stockin` VALUES (1151, '薯片', 4, 226);
INSERT INTO `stockin` VALUES (1152, '薯片', 10, 227);
INSERT INTO `stockin` VALUES (1153, '薯片', 10, 228);
INSERT INTO `stockin` VALUES (1154, '薯片', 10, 229);
INSERT INTO `stockin` VALUES (1155, '薯片', 10, 230);
INSERT INTO `stockin` VALUES (1156, '薯片', 10, 231);
INSERT INTO `stockin` VALUES (1157, '薯片', 10, 232);
INSERT INTO `stockin` VALUES (1158, '薯片', 10, 233);
INSERT INTO `stockin` VALUES (1159, '薯片', 10, 234);
INSERT INTO `stockin` VALUES (1160, '薯片', 10, 235);
INSERT INTO `stockin` VALUES (1161, '薯片', 10, 236);
INSERT INTO `stockin` VALUES (1162, '薯片', 10, 237);
INSERT INTO `stockin` VALUES (1163, '汤圆', 2, 238);
INSERT INTO `stockin` VALUES (1164, '汤圆', 2, 239);
INSERT INTO `stockin` VALUES (1165, '薯片', 1, 240);
INSERT INTO `stockin` VALUES (1166, '汤圆', 2, 241);
INSERT INTO `stockin` VALUES (1167, '汤圆', 11, 244);
INSERT INTO `stockin` VALUES (1168, '榴莲', 2, 251);
INSERT INTO `stockin` VALUES (1169, '苹果', 5, 252);
INSERT INTO `stockin` VALUES (1170, '汤圆', 7, 253);
INSERT INTO `stockin` VALUES (1171, '榴莲', 7, 254);
INSERT INTO `stockin` VALUES (1172, '薯片', 9, 255);
INSERT INTO `stockin` VALUES (1173, '榴莲', 1, 256);
INSERT INTO `stockin` VALUES (1174, '榴莲', 3, 257);
INSERT INTO `stockin` VALUES (1175, '汤圆', 4, 263);
INSERT INTO `stockin` VALUES (1176, '汤圆', 4, 264);
INSERT INTO `stockin` VALUES (1177, '汤圆', 20, 266);
INSERT INTO `stockin` VALUES (1178, '苹果', 6, 269);
INSERT INTO `stockin` VALUES (1179, '榴莲', 1, 270);
INSERT INTO `stockin` VALUES (1180, '汤圆', 6, 272);
INSERT INTO `stockin` VALUES (1181, '苹果', 10, 275);
INSERT INTO `stockin` VALUES (1182, '茄子', 8, 274);
INSERT INTO `stockin` VALUES (1183, '榴莲', 1, 276);
INSERT INTO `stockin` VALUES (1184, '薯片', 2, 278);
INSERT INTO `stockin` VALUES (1185, '汤圆', 11, 279);
INSERT INTO `stockin` VALUES (1186, '汤圆', 10, 281);

-- ----------------------------
-- Table structure for stockout
-- ----------------------------
DROP TABLE IF EXISTS `stockout`;
CREATE TABLE `stockout`  (
  `stock_Id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_number` int(11) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`stock_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20087 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stockout
-- ----------------------------
INSERT INTO `stockout` VALUES (20059, '汤圆', 20, 119);
INSERT INTO `stockout` VALUES (20060, '苹果', 1, 120);
INSERT INTO `stockout` VALUES (20061, '薯片', 10, 133);
INSERT INTO `stockout` VALUES (20062, '苹果', 3, 134);
INSERT INTO `stockout` VALUES (20063, '纸巾', 5, 135);
INSERT INTO `stockout` VALUES (20064, '薯片', 1, 136);
INSERT INTO `stockout` VALUES (20065, '薯片', 20, 137);
INSERT INTO `stockout` VALUES (20066, '汤圆', 2, 139);
INSERT INTO `stockout` VALUES (20067, '矿泉水', 10, 138);
INSERT INTO `stockout` VALUES (20068, '汤圆', 2, 160);
INSERT INTO `stockout` VALUES (20069, '火龙果', 3, 164);
INSERT INTO `stockout` VALUES (20070, '薯片', 10, 165);
INSERT INTO `stockout` VALUES (20071, '薯片', 10, 165);
INSERT INTO `stockout` VALUES (20072, '薯片', 10, 167);
INSERT INTO `stockout` VALUES (20073, '薯片', 2, 169);
INSERT INTO `stockout` VALUES (20074, '汤圆', 1, 170);
INSERT INTO `stockout` VALUES (20075, '汤圆', 2, 172);
INSERT INTO `stockout` VALUES (20076, '汤圆', 10, 174);
INSERT INTO `stockout` VALUES (20077, '薯片', 2, 178);
INSERT INTO `stockout` VALUES (20078, '汤圆', 20, 202);
INSERT INTO `stockout` VALUES (20079, '汤圆', 11, 245);
INSERT INTO `stockout` VALUES (20080, '汤圆', 2, 265);
INSERT INTO `stockout` VALUES (20081, '汤圆', 10, 267);
INSERT INTO `stockout` VALUES (20082, '汤圆', 8, 268);
INSERT INTO `stockout` VALUES (20083, '榴莲', 1, 271);
INSERT INTO `stockout` VALUES (20084, '薯片', 5, 273);
INSERT INTO `stockout` VALUES (20085, '榴莲', 1, 277);
INSERT INTO `stockout` VALUES (20086, '火龙果', 3, 280);

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件实际名称',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `primary_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件主名',
  `extension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件扩展名',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放路径',
  `size` bigint(100) NULL DEFAULT NULL COMMENT '大小',
  `uploader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of upload_file
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_role` int(255) NOT NULL DEFAULT 2,
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, NULL);
INSERT INTO `users` VALUES (4, 'ana', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (11, 'nick', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, NULL);
INSERT INTO `users` VALUES (77, '操作员5号', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (78, 'Chris', '7c4a8d09ca3762af61e59520943dc26494f8941b', 3, NULL);
INSERT INTO `users` VALUES (82, 'MrLiu', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (83, '货物员n号', '7c4a8d09ca3762af61e59520943dc26494f8941b', 3, NULL);
INSERT INTO `users` VALUES (84, 'ymm', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (88, 'bob', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (103, 'hxy', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (104, '货物员', '7c4a8d09ca3762af61e59520943dc26494f8941b', 3, NULL);
INSERT INTO `users` VALUES (106, '操作员', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (109, '操作员1号', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (110, '操作员2号', '7c4a8d09ca3762af61e59520943dc26494f8941b', 2, NULL);
INSERT INTO `users` VALUES (111, '货物员1号', '7c4a8d09ca3762af61e59520943dc26494f8941b', 3, NULL);
INSERT INTO `users` VALUES (112, '货物员1', '7c4a8d09ca3762af61e59520943dc26494f8941b', 3, NULL);

-- ----------------------------
-- Table structure for users_info
-- ----------------------------
DROP TABLE IF EXISTS `users_info`;
CREATE TABLE `users_info`  (
  `users_info_id` bigint(255) NOT NULL,
  `user_tele` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_retailer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_info_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_alt_time` bigint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`users_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_info
-- ----------------------------
INSERT INTO `users_info` VALUES (16567325429722, '15881674300', '北碚天生路002', '重庆互联网学院', '货物员', 1656732542972);
INSERT INTO `users_info` VALUES (16569868141331, '13206015544', '重庆市', '123', '管理员', 1656986814133);
INSERT INTO `users_info` VALUES (165673254297211, '15228455954', '重庆北碚天生路001', '西南大学', '货物员', 1656732542972);
INSERT INTO `users_info` VALUES (165776946845277, '13612342344', '123', '12345', '操作员', 1657769468452);
INSERT INTO `users_info` VALUES (165779110622878, '15228455966', '四川', '永辉', '货物员', 1657791106228);
INSERT INTO `users_info` VALUES (165779201208982, '13337644952', '重庆市西南大学', '计算机与信息科学学院', '操作员', 1657792012089);
INSERT INTO `users_info` VALUES (165779238245083, '13612341234', '123', '123', '货物员', 1657792382450);
INSERT INTO `users_info` VALUES (165779242637684, '15228455966', '重庆市西南大学', 'sw', '操作员', 1657792426376);
INSERT INTO `users_info` VALUES (165779903233188, '13215689654', '撒啥的', '阿达', '操作员', 1657799032331);
INSERT INTO `users_info` VALUES (1657799323730103, '13924059616', '西南大学橘园2舍', 'SWU', '操作员', 1657799323730);
INSERT INTO `users_info` VALUES (1657804310168104, '13206015544', '重庆市', 'jhbgv', '货物员', 1657804310168);
INSERT INTO `users_info` VALUES (1657804873758105, '13612341234', '123456', '123', '操作员', 1657804873758);
INSERT INTO `users_info` VALUES (1657804956113106, NULL, NULL, NULL, '操作员', 1657804956113);
INSERT INTO `users_info` VALUES (1657805148007107, '13612341234', '123', '123', '操作员', 1657805148007);
INSERT INTO `users_info` VALUES (1657805300095108, NULL, NULL, NULL, '操作员', 1657805300095);
INSERT INTO `users_info` VALUES (1657805592230109, NULL, NULL, NULL, '操作员', 1657805592230);
INSERT INTO `users_info` VALUES (1657805674776110, '15228455966', '123456', '123', '操作员', 1657805674776);
INSERT INTO `users_info` VALUES (1657805736654111, '15228455966', '123', '123', '货物员', 1657805736654);
INSERT INTO `users_info` VALUES (1657857113012112, '13924059616', '重庆市西南大学', 'swu', '货物员', 1657857113012);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `warehouse_location` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `warehouse_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_size` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 122 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (110, '冷冻2', '沙坪坝区', '3', 120);
INSERT INTO `warehouse` VALUES (113, '果蔬1', '江北区', '2', 120);
INSERT INTO `warehouse` VALUES (115, '果蔬3', '北碚区', '2', 200);
INSERT INTO `warehouse` VALUES (118, '零食1', '渝北区', '1', 120);
INSERT INTO `warehouse` VALUES (120, '冷冻3', '重庆市', '3', 100);
INSERT INTO `warehouse` VALUES (121, '果蔬2', '重庆市', '2', 110);

SET FOREIGN_KEY_CHECKS = 1;
