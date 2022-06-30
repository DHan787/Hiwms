CREATE TABLE `goods`  (
  `good_id` int(11) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `good_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `good_size` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `good_value` double NOT NULL,
  PRIMARY KEY (`good_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `goods` VALUES (2, '水杯','日用', '33*20', 20);

