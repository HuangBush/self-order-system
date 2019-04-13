/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : food

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-04-13 17:03:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(20) DEFAULT NULL,
  `a_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`a_id`),
  KEY `index_a_id` (`a_id`) USING BTREE,
  KEY `index_a_name` (`a_name`),
  KEY `index_a_num` (`a_id`,`a_name`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('100', 'lily', '123456');
INSERT INTO `admin` VALUES ('101', 'admin', '123456');

-- ----------------------------
-- Table structure for `desk`
-- ----------------------------
DROP TABLE IF EXISTS `desk`;
CREATE TABLE `desk` (
  `d_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_password` varchar(20) DEFAULT '123456',
  `d_name` varchar(20) DEFAULT NULL,
  `d_type` varchar(20) DEFAULT NULL,
  `d_place` varchar(20) DEFAULT NULL,
  `d_position` bigint(20) DEFAULT '0',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of desk
-- ----------------------------
INSERT INTO `desk` VALUES ('1000', '123456', '一号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1001', '123456', '二号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1002', '123456', '三号桌', '四人桌', '一楼大厅', '1');
INSERT INTO `desk` VALUES ('1003', '123456', '四号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1004', '123456', '五号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1005', '123456', '六号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1006', '123456', '七号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1007', '123456', '八号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1008', '123456', '九号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1009', '123456', '十号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1010', '123456', '十一号桌', '四人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1011', '123456', '十二号桌', '八人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1012', '123456', '十三号桌', '八人桌', '一楼大厅', '0');
INSERT INTO `desk` VALUES ('1013', '123456', '十四号桌', '八人桌', '二楼包间', '0');
INSERT INTO `desk` VALUES ('1014', '123456', '十五号桌', '八人桌', '二楼包间', '0');
INSERT INTO `desk` VALUES ('1015', '123456', '十六号桌', '八人桌', '二楼包间', '0');
INSERT INTO `desk` VALUES ('1016', '123456', '十七号桌', '八人桌', '二楼包间', '3');
INSERT INTO `desk` VALUES ('1017', '123456', '十八号桌', '八人桌', '二楼包间', '3');
INSERT INTO `desk` VALUES ('1018', '123456', '十九号桌', '四人桌', '大厅', '3');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `e_name` varchar(20) DEFAULT NULL,
  `e_tel` bigint(20) DEFAULT NULL,
  `e_password` varchar(20) DEFAULT NULL,
  `e_address` varchar(20) DEFAULT NULL,
  `e_regdate` date DEFAULT NULL,
  `e_job` varchar(20) DEFAULT NULL,
  `e_salary` float(20,2) DEFAULT '0.00',
  `e_position` bigint(20) DEFAULT '0',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1024 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1000', '小黄', '15073134890', '123456', '湖南常德', '2019-02-25', '服务员', '5000.00', '0');
INSERT INTO `employee` VALUES ('1001', '小超3', '11012011915', '123456', '湖南衡阳市', '2019-02-25', '领班', '4000.00', '1');
INSERT INTO `employee` VALUES ('1002', '小洋3', '16547898526', '123456', '广东广州', '2019-02-28', '服务员', '3000.00', '0');
INSERT INTO `employee` VALUES ('1003', '小刘', '14452632563', '123456', '广东深圳', '2019-03-02', '厨师', '5000.00', '0');
INSERT INTO `employee` VALUES ('1004', '小张', '15847859632', '123456', '湖南长沙', '2019-03-05', '服务员', '3000.00', '0');
INSERT INTO `employee` VALUES ('1005', '大峰', '18273360815', '123456', '湖南常德', '2019-03-16', '经理', '8000.00', '1');
INSERT INTO `employee` VALUES ('1006', '陈姐', '15542365623', '123456', '长沙', '2019-03-16', '店长', '20000.00', '1');
INSERT INTO `employee` VALUES ('1007', '大峰', '15585569653', '123456', '湖南长沙', '2019-03-16', '领班', '10000.00', '0');
INSERT INTO `employee` VALUES ('1008', '大理', '15545632563', '123456', '湖南长沙', '2019-03-16', '领班', '12345.00', '1');
INSERT INTO `employee` VALUES ('1009', '小李', '15562365236', '123456', '长春', '2019-03-15', '水台工', '2000.00', '1');
INSERT INTO `employee` VALUES ('1010', '小王', '15236524589', '123456', '长沙', '2019-03-14', '传菜员', '3000.00', '0');
INSERT INTO `employee` VALUES ('1011', '小王', '15896322369', '123456', '常德', '2019-03-13', '服务员', '1238.00', '0');
INSERT INTO `employee` VALUES ('1012', '小敏', '13564384688', '123456', '今年放假撒', '2019-03-16', '店长', '3000.00', '0');
INSERT INTO `employee` VALUES ('1013', '撒', '12333333333', '123456', '非官方', '2019-03-04', '厨师', '3444.00', '0');
INSERT INTO `employee` VALUES ('1014', '放地瓜', '13344444444', '343434', '爱上对方的', '2019-03-03', '店长', '4444.00', '0');
INSERT INTO `employee` VALUES ('1015', '士大夫', '19555555555', '333333', '士大夫', '2019-03-05', '厨师', '4555.00', '1');
INSERT INTO `employee` VALUES ('1016', '的双方各', '15555555555', '1333344', '阿什顿飞', '2019-03-03', '厨师', '4444.00', '1');
INSERT INTO `employee` VALUES ('1017', '反攻倒算', '16666666666', '133333', '士大夫', '2019-03-04', '厨师', '5555.00', '0');
INSERT INTO `employee` VALUES ('1018', null, null, null, null, null, null, null, '1');
INSERT INTO `employee` VALUES ('1019', null, '222222222222222', '22222222222', '222222', '2019-03-05', '22', '22222222.00', '1');
INSERT INTO `employee` VALUES ('1020', '小小', '123456789', '123456', '湖南长沙', '2019-03-19', '小小', '500.00', '1');
INSERT INTO `employee` VALUES ('1021', '大哥', '147258369', '123456789', '川商所', '2019-03-31', '大哥', '5000.00', '1');
INSERT INTO `employee` VALUES ('1022', '小弟', '123456789', '123456789', '花生壳', '2019-03-26', '小弟', '2000.00', '1');
INSERT INTO `employee` VALUES ('1023', '34444', '444444444444', '4444444444444', '44444444444', '2019-04-12', '34444', '444444.00', '1');

-- ----------------------------
-- Table structure for `expense`
-- ----------------------------
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense` (
  `ex_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ex_name` varchar(20) DEFAULT NULL,
  `ex_price` float(20,2) DEFAULT NULL,
  `ex_other` varchar(50) DEFAULT NULL,
  `ex_regtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10019 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of expense
-- ----------------------------
INSERT INTO `expense` VALUES ('10002', '黄瓜', '50.00', '共20斤', '2019-03-16 00:00:00');
INSERT INTO `expense` VALUES ('10003', '羊肉', '300.00', '20斤', '2019-03-16 00:00:00');
INSERT INTO `expense` VALUES ('10004', '牛肉', '300.00', '30斤', '2019-03-16 00:00:00');
INSERT INTO `expense` VALUES ('10006', '萝卜', '200.00', '100斤', '2019-03-16 00:00:00');
INSERT INTO `expense` VALUES ('10007', '黄瓜', '10.00', '一元一斤', '2019-03-16 00:00:00');
INSERT INTO `expense` VALUES ('10009', '11111111', '111111110656.00', '111111111', '2019-03-23 00:00:00');
INSERT INTO `expense` VALUES ('10018', '333', '333.00', '333', '2019-03-20 00:00:00');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `m_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(20) DEFAULT NULL,
  `m_img` varchar(200) DEFAULT NULL,
  `m_price` float(20,2) DEFAULT NULL,
  `m_num` bigint(20) DEFAULT '0',
  `m_type` varchar(20) DEFAULT NULL,
  `m_position` bigint(20) DEFAULT '0',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10053 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('10000', '辣椒炒肉por', '/upload/2019-03-31/1554031671329农家一碗香.jpg', '32.00', '121', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10001', '金针菇肉沫汤', '/jpg/金针菇肉沫汤.jpg', '28.00', '112', '营养靓汤', '0');
INSERT INTO `menu` VALUES ('10002', '湘之味鱼头', '/jpg/湘之味鱼头.png', '58.00', '82', '美味大餐', '0');
INSERT INTO `menu` VALUES ('10003', '绝味鸭', '/jpg/绝味鸭.jpg', '68.00', '80', '美味大餐', '0');
INSERT INTO `menu` VALUES ('10004', '水煮活鱼', '/jpg/水煮活鱼.jpg', '68.00', '76', '美味大餐', '0');
INSERT INTO `menu` VALUES ('10005', '香辣猪蹄', '/jpg/香辣猪蹄.jpg', '68.00', '100', '美味大餐', '2');
INSERT INTO `menu` VALUES ('10006', '木耳炖鸡', '/jpg/木耳炖鸡.jpg', '68.00', '94', '美味大餐', '2');
INSERT INTO `menu` VALUES ('10007', '梅菜扣肉', '/jpg/梅菜扣肉.jpg', '48.00', '130', '美味大餐', '2');
INSERT INTO `menu` VALUES ('10008', '粉蒸排骨', '/jpg/粉蒸排骨.png', '48.00', '113', '美味大餐', '3');
INSERT INTO `menu` VALUES ('10009', '红烧肉', '/jpg/红烧肉.png', '48.00', '100', '美味大餐', '0');
INSERT INTO `menu` VALUES ('10010', '茄子豆角', '/jpg/茄子豆角.jpg', '22.00', '220', '精致小炒', '2');
INSERT INTO `menu` VALUES ('10011', '韭菜煎蛋', '/jpg/韭菜煎蛋.jpg', '22.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10012', '清炒莴笋', '/jpg/清炒莴笋.jpg', '22.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10013', '家常豆腐', '/jpg/家常豆腐.jpg', '22.00', '14', '精致小炒', '2');
INSERT INTO `menu` VALUES ('10014', '四季豆炒肉', '/jpg/四季豆炒肉.jpg', '32.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10015', '麻辣藕片', '/jpg/麻辣藕片.jpg', '22.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10016', '香干炒肉', '/jpg/香干炒肉.jpg', '32.00', '14', '精致小炒', '2');
INSERT INTO `menu` VALUES ('10017', '黄瓜炒火腿肠', '/jpg/黄瓜炒火腿.jpg', '22.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10018', '农家一碗香', '/jpg/农家一碗香.jpg', '32.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10019', '肉炒肉', '/jpg/肉炒肉.jpg', '32.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10020', '宫爆鸡丁', '/jpg/宫爆鸡丁.jpg', '38.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10021', '手撕包菜', '/jpg/手撕包菜.jpg', '22.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10022', '时令素菜', '/jpg/时令素菜.jpg', '22.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10023', '紫菜蛋汤', '/jpg/紫菜蛋汤.jpg', '22.00', '5', '营养靓汤', '0');
INSERT INTO `menu` VALUES ('10024', '西红柿蛋汤', '/jpg/西红柿蛋汤.jpg', '22.00', '2', '营养靓汤', '0');
INSERT INTO `menu` VALUES ('10025', '鱼头豆腐汤', '/jpg/鱼头豆腐汤.jpg', '32.00', '2', '营养靓汤', '0');
INSERT INTO `menu` VALUES ('10026', '萝卜排骨汤', '/jpg/萝卜排骨汤.jpg', '38.00', '0', '营养靓汤', '0');
INSERT INTO `menu` VALUES ('10027', '老姜肉丝汤', '/jpg/老姜肉丝汤.jpg', '28.00', '0', '营养靓汤', '0');
INSERT INTO `menu` VALUES ('10028', '干锅牛肉', '/jpg/干锅牛肉.jpg', '68.00', '4', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10029', '干锅羊肉', '/jpg/干锅羊肉.jpeg', '68.00', '3', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10030', '干锅黄鱼', '/jpg/干锅黄鱼.jpg', '58.00', '3', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10031', '干锅鸭肉', '/jpg/干锅鸭肉.jpg', '58.00', '1', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10032', '干锅鸡肉', '/jpg/干锅鸡肉.jpg', '58.00', '0', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10033', '干锅回锅肉', '/jpg/干锅回锅肉.jpg', '58.00', '0', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10034', '干锅肥肠', '/jpg/干锅肥肠.jpg', '58.00', '1', '招牌干锅', '0');
INSERT INTO `menu` VALUES ('10035', '灌装王老吉', '/jpg/王老吉.jpg', '6.00', '5', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10036', '椰子（大瓶）', '/jpg/椰汁（大）.jpeg', '12.00', '7', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10037', '灌装旺仔', '/jpg/旺仔.jpg', '8.00', '6', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10038', '1L雪碧', '/jpg/雪碧.jpg', '8.00', '0', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10039', '1L可乐', '/jpg/可乐.jpg', '8.00', '0', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10040', '农夫山泉', '/jpg/农夫山泉.jpg', '2.00', '0', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10041', '百威', '/jpg/百威.jpg', '10.00', '4', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10042', '哈啤', '/jpg/哈啤.png', '6.00', '0', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10043', '江小白', '/jpg/江小白.jpg', '20.00', '2', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10044', '郎酒', '/jpg/郎酒.jpg', '10.00', '1', '酒水饮料', '0');
INSERT INTO `menu` VALUES ('10045', '拍黄瓜', '/upload/2019-03-16/1552700737757黄瓜炒火腿.jpg', '12.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10046', '臭豆腐', '/upload/2019-03-16/1552703096985百威.jpg', '20.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10047', '小白菜', '/upload/2019-03-23/1553349863096农夫山泉.jpg', '20.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10048', '回锅肉', '/upload/2019-03-31/1554032726771红烧肉.png', '33.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10049', '111', null, '11.00', '0', '精致小炒', '0');
INSERT INTO `menu` VALUES ('10050', '111', null, '11.00', '0', '精致小炒', '3');
INSERT INTO `menu` VALUES ('10051', '111', null, '11.00', '0', '精致小炒', '3');
INSERT INTO `menu` VALUES ('10052', '222', null, '22.00', '0', '精致小炒', '0');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `oi_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `os_id` bigint(20) DEFAULT NULL,
  `m_id` bigint(20) DEFAULT NULL,
  `oi_num` bigint(20) DEFAULT '0',
  `oi_price` float(20,2) DEFAULT NULL,
  `oi_regtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `oi_position` bigint(20) DEFAULT '0',
  PRIMARY KEY (`oi_id`),
  KEY `os_id` (`os_id`),
  KEY `m_id` (`m_id`),
  CONSTRAINT `m_id` FOREIGN KEY (`m_id`) REFERENCES `menu` (`m_id`),
  CONSTRAINT `os_id` FOREIGN KEY (`os_id`) REFERENCES `orderitems` (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100572 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('100064', '10018', '10000', '2', '64.00', '2019-02-27 23:00:49', '3');
INSERT INTO `orderitem` VALUES ('100065', '10018', '10002', '2', '116.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100066', '10018', '10005', '1', '68.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100067', '10018', '10001', '2', '56.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100068', '10018', '10006', '1', '68.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100069', '10018', '10007', '1', '48.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100070', '10018', '10010', '1', '22.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100071', '10018', '10013', '1', '22.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100072', '10018', '10016', '1', '32.00', '2019-02-27 23:00:50', '3');
INSERT INTO `orderitem` VALUES ('100073', '10019', '10000', '1', '32.00', '2019-02-28 14:41:47', '3');
INSERT INTO `orderitem` VALUES ('100074', '10019', '10001', '2', '56.00', '2019-02-28 14:41:48', '3');
INSERT INTO `orderitem` VALUES ('100075', '10019', '10002', '1', '58.00', '2019-02-28 14:41:48', '3');
INSERT INTO `orderitem` VALUES ('100076', '10019', '10005', '1', '68.00', '2019-02-28 14:41:48', '3');
INSERT INTO `orderitem` VALUES ('100077', '10019', '10006', '2', '136.00', '2019-02-28 14:41:48', '3');
INSERT INTO `orderitem` VALUES ('100078', '10020', '10000', '1', '32.00', '2019-02-28 14:46:35', '3');
INSERT INTO `orderitem` VALUES ('100079', '10021', '10002', '1', '58.00', '2019-02-28 15:13:16', '3');
INSERT INTO `orderitem` VALUES ('100080', '10022', '10000', '1', '32.00', '2019-02-28 15:15:39', '3');
INSERT INTO `orderitem` VALUES ('100081', '10023', '10001', '1', '28.00', '2019-02-28 15:17:35', '3');
INSERT INTO `orderitem` VALUES ('100082', '10024', '10002', '1', '58.00', '2019-02-28 15:19:43', '3');
INSERT INTO `orderitem` VALUES ('100083', '10025', '10002', '1', '58.00', '2019-02-28 15:22:12', '3');
INSERT INTO `orderitem` VALUES ('100084', '10026', '10005', '1', '68.00', '2019-02-28 16:23:26', '3');
INSERT INTO `orderitem` VALUES ('100085', '10026', '10000', '1', '32.00', '2019-02-28 16:23:27', '3');
INSERT INTO `orderitem` VALUES ('100086', '10027', '10000', '1', '32.00', '2019-02-28 16:30:31', '3');
INSERT INTO `orderitem` VALUES ('100087', '10028', '10001', '1', '28.00', '2019-02-28 16:33:57', '3');
INSERT INTO `orderitem` VALUES ('100088', '10029', '10000', '1', '32.00', '2019-02-28 16:45:54', '3');
INSERT INTO `orderitem` VALUES ('100089', '10030', '10000', '1', '32.00', '2019-02-28 17:13:24', '3');
INSERT INTO `orderitem` VALUES ('100090', '10031', '10005', '1', '68.00', '2019-02-28 17:14:00', '1');
INSERT INTO `orderitem` VALUES ('100091', '10032', '10000', '1', '32.00', '2019-02-28 17:48:10', '1');
INSERT INTO `orderitem` VALUES ('100092', '10032', '10001', '1', '28.00', '2019-02-28 17:48:10', '1');
INSERT INTO `orderitem` VALUES ('100093', '10032', '10002', '1', '58.00', '2019-02-28 17:48:10', '1');
INSERT INTO `orderitem` VALUES ('100094', '10032', '10005', '1', '68.00', '2019-02-28 17:48:10', '1');
INSERT INTO `orderitem` VALUES ('100095', '10032', '10006', '1', '68.00', '2019-02-28 17:48:10', '1');
INSERT INTO `orderitem` VALUES ('100096', '10032', '10007', '1', '48.00', '2019-02-28 17:48:10', '1');
INSERT INTO `orderitem` VALUES ('100097', '10033', '10016', '2', '64.00', '2019-03-01 09:58:30', '3');
INSERT INTO `orderitem` VALUES ('100098', '10033', '10000', '1', '32.00', '2019-03-01 09:58:30', '3');
INSERT INTO `orderitem` VALUES ('100099', '10033', '10002', '1', '58.00', '2019-03-01 09:58:30', '3');
INSERT INTO `orderitem` VALUES ('100100', '10034', '10000', '1', '32.00', '2019-03-01 10:00:02', '3');
INSERT INTO `orderitem` VALUES ('100101', '10034', '10001', '1', '28.00', '2019-03-01 10:00:02', '3');
INSERT INTO `orderitem` VALUES ('100102', '10035', '10001', '1', '28.00', '2019-03-01 10:03:36', '3');
INSERT INTO `orderitem` VALUES ('100103', '10035', '10000', '1', '32.00', '2019-03-01 10:03:36', '3');
INSERT INTO `orderitem` VALUES ('100104', '10036', '10000', '2', '64.00', '2019-03-01 10:04:26', '3');
INSERT INTO `orderitem` VALUES ('100105', '10036', '10002', '1', '58.00', '2019-03-01 10:04:26', '3');
INSERT INTO `orderitem` VALUES ('100106', '10036', '10005', '1', '68.00', '2019-03-01 10:04:26', '3');
INSERT INTO `orderitem` VALUES ('100107', '10037', '10000', '2', '64.00', '2019-03-01 10:18:50', '3');
INSERT INTO `orderitem` VALUES ('100108', '10038', '10002', '1', '58.00', '2019-03-01 10:27:30', '3');
INSERT INTO `orderitem` VALUES ('100109', '10038', '10016', '1', '32.00', '2019-03-01 10:27:30', '3');
INSERT INTO `orderitem` VALUES ('100110', '10039', '10016', '2', '64.00', '2019-03-01 10:31:03', '3');
INSERT INTO `orderitem` VALUES ('100111', '10040', '10000', '1', '32.00', '2019-03-01 10:33:53', '3');
INSERT INTO `orderitem` VALUES ('100112', '10040', '10016', '2', '64.00', '2019-03-01 10:33:53', '3');
INSERT INTO `orderitem` VALUES ('100113', '10041', '10016', '2', '64.00', '2019-03-01 10:36:15', '3');
INSERT INTO `orderitem` VALUES ('100114', '10041', '10000', '1', '32.00', '2019-03-01 10:36:15', '3');
INSERT INTO `orderitem` VALUES ('100115', '10042', '10000', '1', '32.00', '2019-03-01 10:38:07', '3');
INSERT INTO `orderitem` VALUES ('100116', '10042', '10016', '2', '64.00', '2019-03-01 10:38:07', '3');
INSERT INTO `orderitem` VALUES ('100117', '10043', '10000', '1', '32.00', '2019-03-01 10:38:36', '1');
INSERT INTO `orderitem` VALUES ('100118', '10043', '10016', '2', '64.00', '2019-03-01 10:38:36', '1');
INSERT INTO `orderitem` VALUES ('100119', '10044', '10001', '1', '28.00', '2019-03-01 10:52:28', '3');
INSERT INTO `orderitem` VALUES ('100120', '10044', '10013', '1', '22.00', '2019-03-01 10:52:28', '3');
INSERT INTO `orderitem` VALUES ('100121', '10045', '10000', '1', '32.00', '2019-03-01 10:52:34', '0');
INSERT INTO `orderitem` VALUES ('100122', '10045', '10013', '1', '22.00', '2019-03-01 10:52:36', '0');
INSERT INTO `orderitem` VALUES ('100125', '10046', '10000', '1', '32.00', '2019-03-01 11:38:41', '0');
INSERT INTO `orderitem` VALUES ('100126', '10046', '10016', '2', '96.00', '2019-03-01 11:39:17', '0');
INSERT INTO `orderitem` VALUES ('100127', '10047', '10013', '1', '22.00', '2019-03-01 17:19:58', '3');
INSERT INTO `orderitem` VALUES ('100128', '10047', '10010', '1', '22.00', '2019-03-01 17:19:58', '3');
INSERT INTO `orderitem` VALUES ('100129', '10047', '10016', '1', '32.00', '2019-03-01 17:19:59', '3');
INSERT INTO `orderitem` VALUES ('100130', '10048', '10000', '1', '32.00', '2019-03-01 17:20:55', '1');
INSERT INTO `orderitem` VALUES ('100131', '10048', '10001', '1', '28.00', '2019-03-01 17:20:55', '1');
INSERT INTO `orderitem` VALUES ('100132', '10048', '10002', '1', '58.00', '2019-03-01 17:20:55', '1');
INSERT INTO `orderitem` VALUES ('100133', '10049', '10000', '0', '0.00', '2019-03-01 17:24:36', '1');
INSERT INTO `orderitem` VALUES ('100134', '10049', '10001', '0', '0.00', '2019-03-01 17:24:36', '1');
INSERT INTO `orderitem` VALUES ('100135', '10049', '10005', '1', '68.00', '2019-03-01 17:24:36', '1');
INSERT INTO `orderitem` VALUES ('100136', '10049', '10006', '1', '68.00', '2019-03-01 17:24:36', '1');
INSERT INTO `orderitem` VALUES ('100137', '10050', '10006', '2', '136.00', '2019-03-01 17:34:12', '1');
INSERT INTO `orderitem` VALUES ('100138', '10051', '10013', '2', '44.00', '2019-03-01 18:01:11', '1');
INSERT INTO `orderitem` VALUES ('100139', '10052', '10013', '2', '44.00', '2019-03-01 18:08:50', '1');
INSERT INTO `orderitem` VALUES ('100140', '10053', '10013', '2', '44.00', '2019-03-01 18:12:16', '1');
INSERT INTO `orderitem` VALUES ('100141', '10053', '10002', '2', '116.00', '2019-03-01 18:20:50', '1');
INSERT INTO `orderitem` VALUES ('100142', '10053', '10005', '1', '68.00', '2019-03-01 18:32:25', '1');
INSERT INTO `orderitem` VALUES ('100143', '10053', '10006', '1', '68.00', '2019-03-01 18:32:25', '1');
INSERT INTO `orderitem` VALUES ('100144', '10053', '10013', '1', '22.00', '2019-03-01 18:48:54', '1');
INSERT INTO `orderitem` VALUES ('100145', '10053', '10010', '1', '22.00', '2019-03-01 18:48:54', '1');
INSERT INTO `orderitem` VALUES ('100146', '10053', '10013', '1', '22.00', '2019-03-02 10:47:29', '1');
INSERT INTO `orderitem` VALUES ('100147', '10053', '10007', '1', '48.00', '2019-03-02 10:47:29', '1');
INSERT INTO `orderitem` VALUES ('100148', '10058', '10013', '1', '22.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100149', '10058', '10010', '1', '22.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100150', '10058', '10016', '1', '32.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100151', '10058', '10000', '1', '32.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100152', '10058', '10001', '1', '28.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100153', '10058', '10005', '1', '68.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100154', '10058', '10002', '1', '58.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100155', '10058', '10007', '1', '48.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100156', '10058', '10006', '1', '68.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100157', '10058', '10007', '1', '48.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100158', '10058', '10001', '1', '28.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100159', '10058', '10013', '1', '22.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100160', '10058', '10000', '1', '32.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100161', '10058', '10000', '1', '32.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100162', '10058', '10001', '1', '28.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100163', '10058', '10002', '1', '58.00', '2019-03-02 14:27:25', '2');
INSERT INTO `orderitem` VALUES ('100164', '10069', '10000', '1', '32.00', '2019-03-02 14:53:31', '2');
INSERT INTO `orderitem` VALUES ('100165', '10069', '10001', '1', '28.00', '2019-03-02 14:53:32', '2');
INSERT INTO `orderitem` VALUES ('100166', '10069', '10002', '1', '58.00', '2019-03-02 14:53:32', '2');
INSERT INTO `orderitem` VALUES ('100167', '10069', '10016', '0', '0.00', '2019-03-02 14:53:33', '2');
INSERT INTO `orderitem` VALUES ('100168', '10069', '10013', '1', '22.00', '2019-03-02 14:53:33', '2');
INSERT INTO `orderitem` VALUES ('100169', '10070', '10000', '1', '32.00', '2019-03-02 14:54:53', '2');
INSERT INTO `orderitem` VALUES ('100170', '10070', '10006', '1', '68.00', '2019-03-02 14:54:54', '2');
INSERT INTO `orderitem` VALUES ('100171', '10070', '10002', '1', '58.00', '2019-03-02 14:54:54', '2');
INSERT INTO `orderitem` VALUES ('100172', '10071', '10000', '1', '32.00', '2019-03-02 14:57:08', '2');
INSERT INTO `orderitem` VALUES ('100173', '10071', '10001', '1', '28.00', '2019-03-02 14:57:08', '2');
INSERT INTO `orderitem` VALUES ('100174', '10072', '10002', '1', '58.00', '2019-03-02 14:58:16', '2');
INSERT INTO `orderitem` VALUES ('100175', '10073', '10000', '1', '32.00', '2019-03-02 15:11:32', '2');
INSERT INTO `orderitem` VALUES ('100176', '10073', '10001', '1', '28.00', '2019-03-02 15:11:32', '2');
INSERT INTO `orderitem` VALUES ('100177', '10074', '10000', '1', '32.00', '2019-03-02 15:12:33', '2');
INSERT INTO `orderitem` VALUES ('100178', '10074', '10001', '1', '28.00', '2019-03-02 15:12:33', '2');
INSERT INTO `orderitem` VALUES ('100179', '10075', '10000', '1', '32.00', '2019-03-02 17:07:48', '3');
INSERT INTO `orderitem` VALUES ('100180', '10076', '10001', '1', '28.00', '2019-03-02 17:17:29', '3');
INSERT INTO `orderitem` VALUES ('100181', '10077', '10000', '1', '32.00', '2019-03-02 19:15:13', '3');
INSERT INTO `orderitem` VALUES ('100182', '10078', '10000', '1', '32.00', '2019-03-02 18:07:35', '3');
INSERT INTO `orderitem` VALUES ('100183', '10079', '10000', '1', '32.00', '2019-03-02 18:07:46', '3');
INSERT INTO `orderitem` VALUES ('100184', '10080', '10000', '1', '32.00', '2019-03-02 18:10:23', '3');
INSERT INTO `orderitem` VALUES ('100185', '10081', '10000', '1', '32.00', '2019-03-02 18:10:30', '3');
INSERT INTO `orderitem` VALUES ('100186', '10081', '10001', '1', '28.00', '2019-03-02 18:10:31', '3');
INSERT INTO `orderitem` VALUES ('100187', '10082', '10000', '1', '32.00', '2019-03-02 18:14:59', '3');
INSERT INTO `orderitem` VALUES ('100188', '10082', '10001', '1', '28.00', '2019-03-02 18:15:00', '3');
INSERT INTO `orderitem` VALUES ('100189', '10082', '10002', '3', '174.00', '2019-03-02 18:15:00', '3');
INSERT INTO `orderitem` VALUES ('100190', '10082', '10005', '3', '204.00', '2019-03-02 18:15:00', '3');
INSERT INTO `orderitem` VALUES ('100191', '10082', '10006', '3', '204.00', '2019-03-02 18:15:00', '3');
INSERT INTO `orderitem` VALUES ('100192', '10082', '10007', '1', '48.00', '2019-03-02 18:15:00', '3');
INSERT INTO `orderitem` VALUES ('100193', '10083', '10000', '1', '32.00', '2019-03-02 18:19:46', '3');
INSERT INTO `orderitem` VALUES ('100200', '10088', '10001', '1', '28.00', '2019-03-02 18:28:41', '3');
INSERT INTO `orderitem` VALUES ('100201', '10089', '10001', '2', '56.00', '2019-03-02 18:29:41', '3');
INSERT INTO `orderitem` VALUES ('100202', '10089', '10002', '1', '58.00', '2019-03-02 18:29:41', '3');
INSERT INTO `orderitem` VALUES ('100204', '10091', '10000', '10', '320.00', '2019-03-02 18:31:54', '3');
INSERT INTO `orderitem` VALUES ('100206', '10093', '10000', '1', '32.00', '2019-03-02 18:34:08', '3');
INSERT INTO `orderitem` VALUES ('100207', '10094', '10000', '1', '32.00', '2019-03-02 18:34:24', '3');
INSERT INTO `orderitem` VALUES ('100208', '10095', '10000', '1', '32.00', '2019-03-02 18:35:38', '3');
INSERT INTO `orderitem` VALUES ('100210', '10097', '10002', '1', '58.00', '2019-03-02 19:04:14', '3');
INSERT INTO `orderitem` VALUES ('100211', '10097', '10000', '1', '32.00', '2019-03-02 19:04:14', '3');
INSERT INTO `orderitem` VALUES ('100212', '10098', '10000', '2', '64.00', '2019-03-02 19:06:44', '3');
INSERT INTO `orderitem` VALUES ('100213', '10099', '10000', '1', '32.00', '2019-03-02 19:09:21', '3');
INSERT INTO `orderitem` VALUES ('100214', '10099', '10005', '1', '68.00', '2019-03-02 19:09:21', '3');
INSERT INTO `orderitem` VALUES ('100215', '10100', '10000', '2', '64.00', '2019-03-02 19:11:14', '3');
INSERT INTO `orderitem` VALUES ('100216', '10101', '10000', '10', '320.00', '2019-03-02 19:12:52', '3');
INSERT INTO `orderitem` VALUES ('100217', '10101', '10001', '8', '224.00', '2019-03-02 19:12:52', '3');
INSERT INTO `orderitem` VALUES ('100226', '10102', '10006', '6', '408.00', '2019-03-02 19:13:45', '3');
INSERT INTO `orderitem` VALUES ('100228', '10103', '10001', '2', '56.00', '2019-03-02 19:14:30', '3');
INSERT INTO `orderitem` VALUES ('100232', '10105', '10000', '1', '32.00', '2019-03-03 14:26:09', '3');
INSERT INTO `orderitem` VALUES ('100233', '10105', '10001', '1', '28.00', '2019-03-03 14:26:09', '3');
INSERT INTO `orderitem` VALUES ('100234', '10105', '10002', '1', '58.00', '2019-03-03 14:26:09', '3');
INSERT INTO `orderitem` VALUES ('100235', '10106', '10000', '10', '320.00', '2019-03-03 09:55:33', '3');
INSERT INTO `orderitem` VALUES ('100236', '10106', '10001', '10', '280.00', '2019-03-03 09:55:33', '3');
INSERT INTO `orderitem` VALUES ('100237', '10106', '10002', '10', '580.00', '2019-03-03 09:55:33', '3');
INSERT INTO `orderitem` VALUES ('100238', '10106', '10005', '10', '680.00', '2019-03-03 09:55:34', '3');
INSERT INTO `orderitem` VALUES ('100239', '10106', '10006', '10', '680.00', '2019-03-03 09:55:34', '3');
INSERT INTO `orderitem` VALUES ('100240', '10106', '10007', '10', '480.00', '2019-03-03 09:55:34', '3');
INSERT INTO `orderitem` VALUES ('100241', '10106', '10010', '10', '220.00', '2019-03-03 09:55:34', '3');
INSERT INTO `orderitem` VALUES ('100242', '10106', '10013', '10', '220.00', '2019-03-03 09:55:34', '3');
INSERT INTO `orderitem` VALUES ('100243', '10106', '10016', '10', '320.00', '2019-03-03 09:55:34', '3');
INSERT INTO `orderitem` VALUES ('100253', '10109', '10000', '0', '0.00', '2019-03-03 10:44:21', '3');
INSERT INTO `orderitem` VALUES ('100254', '10109', '10001', '0', '0.00', '2019-03-03 10:44:21', '3');
INSERT INTO `orderitem` VALUES ('100255', '10110', '10000', '0', '0.00', '2019-03-03 10:45:20', '3');
INSERT INTO `orderitem` VALUES ('100256', '10111', '10000', '0', '0.00', '2019-03-03 10:47:03', '3');
INSERT INTO `orderitem` VALUES ('100276', '10114', '10001', '1', '28.00', '2019-03-03 11:07:10', '3');
INSERT INTO `orderitem` VALUES ('100278', '10115', '10000', '1', '32.00', '2019-03-03 11:11:37', '3');
INSERT INTO `orderitem` VALUES ('100279', '10116', '10005', '1', '68.00', '2019-03-03 11:19:35', '3');
INSERT INTO `orderitem` VALUES ('100281', '10117', '10001', '2', '56.00', '2019-03-03 11:19:59', '3');
INSERT INTO `orderitem` VALUES ('100291', '10121', '10000', '4', '128.00', '2019-03-03 11:22:33', '3');
INSERT INTO `orderitem` VALUES ('100292', '10122', '10013', '3', '66.00', '2019-03-03 11:22:48', '3');
INSERT INTO `orderitem` VALUES ('100293', '10123', '10013', '3', '66.00', '2019-03-03 11:25:53', '3');
INSERT INTO `orderitem` VALUES ('100294', '10124', '10000', '3', '96.00', '2019-03-03 11:32:45', '3');
INSERT INTO `orderitem` VALUES ('100295', '10125', '10000', '3', '96.00', '2019-03-03 11:34:17', '3');
INSERT INTO `orderitem` VALUES ('100296', '10126', '10000', '3', '96.00', '2019-03-03 11:34:41', '3');
INSERT INTO `orderitem` VALUES ('100297', '10127', '10000', '3', '96.00', '2019-03-03 11:36:56', '3');
INSERT INTO `orderitem` VALUES ('100298', '10128', '10000', '3', '96.00', '2019-03-03 11:37:56', '3');
INSERT INTO `orderitem` VALUES ('100299', '10129', '10000', '2', '64.00', '2019-03-03 11:39:01', '3');
INSERT INTO `orderitem` VALUES ('100309', '10132', '10000', '1', '32.00', '2019-03-03 12:48:48', '3');
INSERT INTO `orderitem` VALUES ('100310', '10132', '10005', '2', '136.00', '2019-03-03 12:48:48', '3');
INSERT INTO `orderitem` VALUES ('100311', '10132', '10037', '2', '16.00', '2019-03-03 12:48:48', '3');
INSERT INTO `orderitem` VALUES ('100312', '10133', '10010', '1', '22.00', '2019-03-03 12:50:23', '3');
INSERT INTO `orderitem` VALUES ('100313', '10133', '10004', '1', '68.00', '2019-03-03 12:50:23', '3');
INSERT INTO `orderitem` VALUES ('100314', '10133', '10029', '1', '68.00', '2019-03-03 12:50:23', '3');
INSERT INTO `orderitem` VALUES ('100315', '10133', '10025', '1', '32.00', '2019-03-03 12:50:23', '3');
INSERT INTO `orderitem` VALUES ('100316', '10133', '10036', '1', '12.00', '2019-03-03 12:50:23', '3');
INSERT INTO `orderitem` VALUES ('100317', '10134', '10000', '1', '32.00', '2019-03-03 12:52:30', '3');
INSERT INTO `orderitem` VALUES ('100318', '10134', '10001', '1', '28.00', '2019-03-03 12:52:30', '3');
INSERT INTO `orderitem` VALUES ('100319', '10134', '10004', '1', '68.00', '2019-03-03 12:52:30', '3');
INSERT INTO `orderitem` VALUES ('100320', '10134', '10005', '1', '68.00', '2019-03-03 12:52:30', '3');
INSERT INTO `orderitem` VALUES ('100322', '10134', '10025', '1', '32.00', '2019-03-03 12:52:30', '3');
INSERT INTO `orderitem` VALUES ('100323', '10134', '10036', '1', '12.00', '2019-03-03 12:52:30', '3');
INSERT INTO `orderitem` VALUES ('100324', '10135', '10000', '1', '32.00', '2019-03-03 20:40:16', '3');
INSERT INTO `orderitem` VALUES ('100326', '10135', '10002', '1', '58.00', '2019-03-03 20:40:16', '3');
INSERT INTO `orderitem` VALUES ('100328', '10135', '10006', '1', '68.00', '2019-03-03 20:40:16', '3');
INSERT INTO `orderitem` VALUES ('100352', '10136', '10000', '1', '32.00', '2019-03-03 21:54:08', '3');
INSERT INTO `orderitem` VALUES ('100355', '10136', '10012', '1', '22.00', '2019-03-03 21:54:08', '3');
INSERT INTO `orderitem` VALUES ('100357', '10136', '10014', '1', '32.00', '2019-03-03 21:54:08', '3');
INSERT INTO `orderitem` VALUES ('100358', '10136', '10015', '1', '22.00', '2019-03-03 21:54:08', '3');
INSERT INTO `orderitem` VALUES ('100360', '10136', '10017', '1', '22.00', '2019-03-03 21:54:08', '3');
INSERT INTO `orderitem` VALUES ('100361', '10136', '10018', '1', '32.00', '2019-03-03 21:54:08', '3');
INSERT INTO `orderitem` VALUES ('100363', '10137', '10000', '1', '32.00', '2019-03-03 22:08:39', '3');
INSERT INTO `orderitem` VALUES ('100364', '10138', '10000', '1', '32.00', '2019-03-03 22:26:30', '3');
INSERT INTO `orderitem` VALUES ('100365', '10138', '10001', '1', '28.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100366', '10138', '10002', '1', '58.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100367', '10138', '10005', '1', '68.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100368', '10138', '10006', '1', '68.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100369', '10138', '10007', '1', '48.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100371', '10138', '10024', '1', '22.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100372', '10138', '10041', '11', '110.00', '2019-03-03 22:26:31', '3');
INSERT INTO `orderitem` VALUES ('100373', '10139', '10000', '1', '32.00', '2019-03-03 22:40:26', '3');
INSERT INTO `orderitem` VALUES ('100374', '10139', '10010', '1', '22.00', '2019-03-03 22:40:26', '3');
INSERT INTO `orderitem` VALUES ('100375', '10139', '10012', '1', '22.00', '2019-03-03 22:40:26', '3');
INSERT INTO `orderitem` VALUES ('100376', '10139', '10036', '1', '12.00', '2019-03-03 22:40:26', '3');
INSERT INTO `orderitem` VALUES ('100377', '10139', '10041', '1', '10.00', '2019-03-03 22:40:26', '3');
INSERT INTO `orderitem` VALUES ('100378', '10140', '10001', '1', '28.00', '2019-03-03 22:41:53', '3');
INSERT INTO `orderitem` VALUES ('100379', '10140', '10002', '1', '58.00', '2019-03-03 22:41:53', '3');
INSERT INTO `orderitem` VALUES ('100380', '10140', '10005', '1', '68.00', '2019-03-03 22:41:53', '3');
INSERT INTO `orderitem` VALUES ('100381', '10141', '10000', '1', '32.00', '2019-03-03 22:43:19', '3');
INSERT INTO `orderitem` VALUES ('100382', '10141', '10001', '1', '28.00', '2019-03-03 22:43:19', '3');
INSERT INTO `orderitem` VALUES ('100383', '10141', '10002', '1', '58.00', '2019-03-03 22:43:19', '3');
INSERT INTO `orderitem` VALUES ('100384', '10141', '10005', '1', '68.00', '2019-03-03 22:43:19', '3');
INSERT INTO `orderitem` VALUES ('100385', '10141', '10036', '1', '12.00', '2019-03-03 22:43:19', '3');
INSERT INTO `orderitem` VALUES ('100386', '10141', '10029', '1', '68.00', '2019-03-03 22:43:20', '3');
INSERT INTO `orderitem` VALUES ('100387', '10142', '10011', '1', '22.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100388', '10142', '10013', '1', '22.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100389', '10142', '10004', '1', '68.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100390', '10142', '10006', '1', '68.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100391', '10142', '10029', '1', '68.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100392', '10142', '10025', '1', '32.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100393', '10142', '10036', '1', '12.00', '2019-03-04 20:44:34', '3');
INSERT INTO `orderitem` VALUES ('100394', '10143', '10000', '1', '32.00', '2019-03-04 13:36:26', '3');
INSERT INTO `orderitem` VALUES ('100395', '10144', '10000', '1', '32.00', '2019-03-04 13:48:37', '3');
INSERT INTO `orderitem` VALUES ('100396', '10145', '10016', '1', '32.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100397', '10145', '10018', '1', '32.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100398', '10145', '10004', '1', '68.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100399', '10145', '10006', '1', '68.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100400', '10145', '10029', '1', '68.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100401', '10145', '10025', '1', '32.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100402', '10145', '10036', '1', '12.00', '2019-03-04 14:52:49', '3');
INSERT INTO `orderitem` VALUES ('100403', '10146', '10000', '1', '32.00', '2019-03-04 20:42:09', '3');
INSERT INTO `orderitem` VALUES ('100404', '10147', '10000', '1', '32.00', '2019-03-04 20:45:26', '3');
INSERT INTO `orderitem` VALUES ('100405', '10148', '10000', '1', '32.00', '2019-03-04 20:45:38', '3');
INSERT INTO `orderitem` VALUES ('100407', '10149', '10002', '1', '58.00', '2019-03-04 20:46:17', '3');
INSERT INTO `orderitem` VALUES ('100410', '10150', '10035', '1', '6.00', '2019-03-13 15:41:06', '3');
INSERT INTO `orderitem` VALUES ('100413', '10152', '10002', '1', '58.00', '2019-03-14 17:18:18', '3');
INSERT INTO `orderitem` VALUES ('100414', '10152', '10001', '3', '84.00', '2019-03-14 17:18:18', '3');
INSERT INTO `orderitem` VALUES ('100415', '10152', '10005', '1', '68.00', '2019-03-14 17:18:18', '3');
INSERT INTO `orderitem` VALUES ('100417', '10152', '10024', '1', '22.00', '2019-03-14 17:18:19', '3');
INSERT INTO `orderitem` VALUES ('100418', '10152', '10025', '1', '32.00', '2019-03-14 17:18:19', '3');
INSERT INTO `orderitem` VALUES ('100419', '10153', '10023', '1', '22.00', '2019-03-14 17:19:28', '3');
INSERT INTO `orderitem` VALUES ('100420', '10154', '10005', '2', '136.00', '2019-03-14 23:14:25', '3');
INSERT INTO `orderitem` VALUES ('100421', '10154', '10036', '1', '12.00', '2019-03-14 23:14:26', '3');
INSERT INTO `orderitem` VALUES ('100422', '10154', '10030', '1', '58.00', '2019-03-14 23:14:28', '3');
INSERT INTO `orderitem` VALUES ('100427', '10157', '10000', '1', '32.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100428', '10157', '10002', '1', '58.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100429', '10157', '10005', '1', '68.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100430', '10157', '10006', '1', '68.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100431', '10157', '10010', '1', '22.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100432', '10157', '10013', '1', '22.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100433', '10157', '10023', '1', '22.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100434', '10157', '10003', '1', '68.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100435', '10157', '10008', '1', '48.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100436', '10157', '10028', '1', '68.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100437', '10157', '10034', '1', '58.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100438', '10157', '10036', '1', '12.00', '2019-03-15 15:55:24', '1');
INSERT INTO `orderitem` VALUES ('100439', '10157', '10041', '2', '20.00', '2019-03-15 15:57:04', '1');
INSERT INTO `orderitem` VALUES ('100440', '10157', '10001', '1', '28.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100441', '10157', '10002', '1', '58.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100442', '10157', '10005', '1', '68.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100443', '10157', '10007', '1', '48.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100444', '10157', '10029', '1', '68.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100445', '10157', '10036', '1', '12.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100446', '10157', '10037', '2', '16.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100447', '10157', '10028', '1', '68.00', '2019-03-15 16:01:04', '1');
INSERT INTO `orderitem` VALUES ('100448', '10160', '10028', '1', '68.00', '2019-03-15 16:05:11', '1');
INSERT INTO `orderitem` VALUES ('100449', '10156', '10036', '1', '12.00', '2019-03-15 16:10:01', '3');
INSERT INTO `orderitem` VALUES ('100450', '10160', '10002', '1', '58.00', '2019-03-15 16:11:15', '1');
INSERT INTO `orderitem` VALUES ('100451', '10160', '10005', '1', '68.00', '2019-03-15 16:11:15', '1');
INSERT INTO `orderitem` VALUES ('100452', '10160', '10025', '1', '32.00', '2019-03-15 16:11:15', '1');
INSERT INTO `orderitem` VALUES ('100453', '10161', '10000', '1', '32.00', '2019-03-15 18:14:50', '3');
INSERT INTO `orderitem` VALUES ('100454', '10162', '10001', '1', '28.00', '2019-03-15 18:15:55', '3');
INSERT INTO `orderitem` VALUES ('100455', '10163', '10000', '1', '32.00', '2019-03-15 18:17:16', '3');
INSERT INTO `orderitem` VALUES ('100456', '10164', '10035', '1', '6.00', '2019-03-15 18:19:59', '3');
INSERT INTO `orderitem` VALUES ('100457', '10164', '10036', '1', '12.00', '2019-03-15 18:20:00', '3');
INSERT INTO `orderitem` VALUES ('100458', '10165', '10002', '1', '58.00', '2019-03-15 18:21:53', '3');
INSERT INTO `orderitem` VALUES ('100459', '10166', '10000', '1', '32.00', '2019-03-15 18:27:20', '3');
INSERT INTO `orderitem` VALUES ('100460', '10167', '10029', '1', '68.00', '2019-03-16 09:32:25', '1');
INSERT INTO `orderitem` VALUES ('100461', '10168', '10002', '1', '58.00', '2019-03-16 09:08:20', '3');
INSERT INTO `orderitem` VALUES ('100462', '10155', '10002', '1', '58.00', '2019-03-16 10:36:51', '3');
INSERT INTO `orderitem` VALUES ('100463', '10169', '10010', '1', '22.00', '2019-03-16 09:22:06', '1');
INSERT INTO `orderitem` VALUES ('100464', '10170', '10001', '1', '28.00', '2019-03-16 09:25:58', '2');
INSERT INTO `orderitem` VALUES ('100465', '10170', '10002', '1', '58.00', '2019-03-16 09:25:58', '2');
INSERT INTO `orderitem` VALUES ('100466', '10172', '10002', '1', '58.00', '2019-03-16 09:42:50', '1');
INSERT INTO `orderitem` VALUES ('100468', '10173', '10000', '5', '160.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100469', '10173', '10004', '1', '68.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100470', '10173', '10003', '1', '68.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100471', '10173', '10005', '1', '68.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100472', '10173', '10006', '1', '68.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100473', '10173', '10007', '1', '48.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100474', '10173', '10008', '1', '48.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100475', '10173', '10028', '1', '68.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100476', '10173', '10029', '1', '68.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100477', '10173', '10030', '1', '58.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100478', '10173', '10031', '1', '58.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100479', '10173', '10023', '1', '22.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100480', '10173', '10024', '1', '22.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100481', '10173', '10025', '1', '32.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100482', '10173', '10041', '2', '20.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100483', '10173', '10044', '1', '10.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100484', '10173', '10043', '2', '40.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100485', '10174', '10037', '1', '8.00', '2019-03-16 10:13:13', '3');
INSERT INTO `orderitem` VALUES ('100486', '10173', '10036', '1', '12.00', '2019-03-16 10:16:09', '2');
INSERT INTO `orderitem` VALUES ('100487', '10173', '10023', '1', '22.00', '2019-03-16 10:16:10', '2');
INSERT INTO `orderitem` VALUES ('100488', '10177', '10002', '1', '58.00', '2019-03-16 10:18:56', '1');
INSERT INTO `orderitem` VALUES ('100490', '10179', '10002', '1', '58.00', '2019-03-16 11:01:53', '2');
INSERT INTO `orderitem` VALUES ('100491', '10179', '10005', '1', '68.00', '2019-03-16 11:01:53', '2');
INSERT INTO `orderitem` VALUES ('100493', '10179', '10037', '1', '8.00', '2019-03-16 11:01:53', '2');
INSERT INTO `orderitem` VALUES ('100494', '10179', '10010', '1', '22.00', '2019-03-16 11:01:53', '2');
INSERT INTO `orderitem` VALUES ('100495', '10181', '10005', '1', '68.00', '2019-04-03 23:39:48', '2');
INSERT INTO `orderitem` VALUES ('100496', '10181', '10007', '1', '48.00', '2019-04-03 23:39:48', '2');
INSERT INTO `orderitem` VALUES ('100497', '10181', '10010', '1', '22.00', '2019-04-03 23:39:49', '2');
INSERT INTO `orderitem` VALUES ('100498', '10181', '10036', '1', '12.00', '2019-04-03 23:39:49', '2');
INSERT INTO `orderitem` VALUES ('100499', '10181', '10023', '1', '22.00', '2019-04-03 23:39:49', '2');
INSERT INTO `orderitem` VALUES ('100500', '10182', '10005', '1', '68.00', '2019-04-03 23:39:58', '2');
INSERT INTO `orderitem` VALUES ('100501', '10183', '10001', '1', '28.00', '2019-04-03 23:39:50', '2');
INSERT INTO `orderitem` VALUES ('100502', '10184', '10006', '1', '68.00', '2019-04-03 23:39:50', '2');
INSERT INTO `orderitem` VALUES ('100503', '10185', '10005', '1', '68.00', '2019-04-03 23:39:50', '2');
INSERT INTO `orderitem` VALUES ('100504', null, '10006', '1', '68.00', '2019-04-03 23:39:59', '2');
INSERT INTO `orderitem` VALUES ('100505', null, '10007', '1', '48.00', '2019-04-03 23:39:51', '2');
INSERT INTO `orderitem` VALUES ('100506', null, '10005', '1', '68.00', '2019-04-03 23:39:53', '2');
INSERT INTO `orderitem` VALUES ('100507', null, '10005', '1', '68.00', '2019-04-03 23:40:00', '2');
INSERT INTO `orderitem` VALUES ('100508', null, '10005', '1', '68.00', '2019-04-03 23:39:53', '2');
INSERT INTO `orderitem` VALUES ('100509', '10186', '10005', '4', '272.00', '2019-04-03 23:39:54', '2');
INSERT INTO `orderitem` VALUES ('100510', null, '10005', '1', '68.00', '2019-04-03 23:40:01', '2');
INSERT INTO `orderitem` VALUES ('100512', '10188', '10005', '3', '204.00', '2019-04-03 23:39:54', '2');
INSERT INTO `orderitem` VALUES ('100513', '10188', '10007', '5', '240.00', '2019-04-03 17:30:24', '3');
INSERT INTO `orderitem` VALUES ('100514', '10188', '10002', '6', '348.00', '2019-04-03 17:30:24', '3');
INSERT INTO `orderitem` VALUES ('100515', '10189', '10005', '2', '136.00', '2019-04-03 17:31:12', '3');
INSERT INTO `orderitem` VALUES ('100516', '10189', '10006', '2', '136.00', '2019-04-03 17:31:12', '3');
INSERT INTO `orderitem` VALUES ('100517', '10189', '10010', '1', '22.00', '2019-04-03 17:31:12', '3');
INSERT INTO `orderitem` VALUES ('100518', '10190', '10005', '1', '68.00', '2019-04-03 17:33:05', '3');
INSERT INTO `orderitem` VALUES ('100519', '10190', '10006', '1', '68.00', '2019-04-03 17:33:05', '3');
INSERT INTO `orderitem` VALUES ('100520', '10191', '10005', '2', '136.00', '2019-04-03 23:39:42', '2');
INSERT INTO `orderitem` VALUES ('100521', '10191', '10000', '1', '32.00', '2019-04-03 23:39:43', '2');
INSERT INTO `orderitem` VALUES ('100522', '10192', '10005', '6', '408.00', '2019-04-03 23:39:43', '2');
INSERT INTO `orderitem` VALUES ('100523', '10193', '10006', '1', '68.00', '2019-04-03 18:08:14', '3');
INSERT INTO `orderitem` VALUES ('100524', '10193', '10007', '1', '48.00', '2019-04-03 18:08:14', '3');
INSERT INTO `orderitem` VALUES ('100525', '10193', '10010', '2', '44.00', '2019-04-03 18:08:14', '3');
INSERT INTO `orderitem` VALUES ('100526', '10194', '10035', '1', '6.00', '2019-04-03 18:26:48', '3');
INSERT INTO `orderitem` VALUES ('100527', '10194', '10028', '4', '272.00', '2019-04-03 18:26:48', '3');
INSERT INTO `orderitem` VALUES ('100528', '10194', '10002', '3', '174.00', '2019-04-03 18:26:48', '3');
INSERT INTO `orderitem` VALUES ('100529', '10195', '10010', '2', '44.00', '2019-04-03 23:39:36', '2');
INSERT INTO `orderitem` VALUES ('100530', '10196', '10005', '2', '136.00', '2019-04-03 23:39:38', '2');
INSERT INTO `orderitem` VALUES ('100531', '10196', '10006', '2', '136.00', '2019-04-03 23:39:35', '2');
INSERT INTO `orderitem` VALUES ('100532', '10197', '10035', '1', '6.00', '2019-04-03 23:39:34', '2');
INSERT INTO `orderitem` VALUES ('100533', '10198', '10006', '1', '68.00', '2019-04-03 23:39:38', '2');
INSERT INTO `orderitem` VALUES ('100534', '10199', '10005', '1', '68.00', '2019-04-03 20:33:28', '3');
INSERT INTO `orderitem` VALUES ('100535', '10200', '10005', '1', '68.00', '2019-04-03 20:34:48', '3');
INSERT INTO `orderitem` VALUES ('100536', '10201', '10006', '1', '68.00', '2019-04-03 20:37:15', '3');
INSERT INTO `orderitem` VALUES ('100537', '10202', '10007', '1', '48.00', '2019-04-03 20:40:06', '3');
INSERT INTO `orderitem` VALUES ('100538', '10203', '10006', '1', '68.00', '2019-04-03 23:39:27', '2');
INSERT INTO `orderitem` VALUES ('100539', '10204', '10006', '1', '68.00', '2019-04-03 23:39:27', '2');
INSERT INTO `orderitem` VALUES ('100540', '10205', '10025', '1', '32.00', '2019-04-03 20:48:24', '3');
INSERT INTO `orderitem` VALUES ('100541', '10206', '10006', '1', '68.00', '2019-04-03 20:53:57', '3');
INSERT INTO `orderitem` VALUES ('100542', '10207', '10006', '1', '68.00', '2019-04-03 20:58:42', '3');
INSERT INTO `orderitem` VALUES ('100543', '10208', '10007', '1', '48.00', '2019-04-03 21:15:20', '3');
INSERT INTO `orderitem` VALUES ('100544', '10209', '10006', '1', '68.00', '2019-04-03 21:17:07', '3');
INSERT INTO `orderitem` VALUES ('100545', '10210', '10007', '1', '48.00', '2019-04-03 22:48:44', '3');
INSERT INTO `orderitem` VALUES ('100546', '10211', '10006', '1', '68.00', '2019-04-03 22:56:11', '3');
INSERT INTO `orderitem` VALUES ('100547', '10212', '10037', '1', '8.00', '2019-04-03 23:03:08', '2');
INSERT INTO `orderitem` VALUES ('100548', '10213', '10035', '1', '6.00', '2019-04-03 22:59:49', '1');
INSERT INTO `orderitem` VALUES ('100549', '10214', '10036', '1', '12.00', '2019-04-03 23:03:01', '1');
INSERT INTO `orderitem` VALUES ('100550', '10215', '10007', '1', '48.00', '2019-04-03 23:07:59', '1');
INSERT INTO `orderitem` VALUES ('100552', '10216', '10036', '1', '12.00', '2019-04-03 23:08:26', '1');
INSERT INTO `orderitem` VALUES ('100553', '10217', '10006', '1', '68.00', '2019-04-10 23:02:24', '2');
INSERT INTO `orderitem` VALUES ('100554', '10218', '10035', '1', '6.00', '2019-04-03 23:41:43', '1');
INSERT INTO `orderitem` VALUES ('100555', '10219', '10001', '1', '28.00', '2019-04-03 23:44:11', '1');
INSERT INTO `orderitem` VALUES ('100556', '10217', '10035', '1', '6.00', '2019-04-10 23:02:24', '2');
INSERT INTO `orderitem` VALUES ('100557', '10221', '10006', '1', '68.00', '2019-04-10 23:02:15', '2');
INSERT INTO `orderitem` VALUES ('100558', '10221', '10037', '1', '8.00', '2019-04-10 23:02:15', '2');
INSERT INTO `orderitem` VALUES ('100559', '10223', '10023', '1', '22.00', '2019-04-04 00:35:11', '2');
INSERT INTO `orderitem` VALUES ('100560', '10223', '10001', '1', '28.00', '2019-04-04 00:35:11', '2');
INSERT INTO `orderitem` VALUES ('100562', '10225', '10003', '1', '68.00', '2019-04-04 00:31:50', '3');
INSERT INTO `orderitem` VALUES ('100563', '10225', '10024', '1', '22.00', '2019-04-04 00:31:50', '3');
INSERT INTO `orderitem` VALUES ('100564', '10223', '10037', '1', '8.00', '2019-04-04 00:35:11', '2');
INSERT INTO `orderitem` VALUES ('100567', '10223', '10024', '1', '22.00', '2019-04-04 00:35:11', '2');
INSERT INTO `orderitem` VALUES ('100568', '10228', '10030', '1', '58.00', '2019-04-10 23:00:36', '2');
INSERT INTO `orderitem` VALUES ('100569', '10229', '10005', '1', '68.00', '2019-04-12 23:35:35', '1');
INSERT INTO `orderitem` VALUES ('100570', '10229', '10006', '1', '68.00', '2019-04-12 23:35:35', '1');
INSERT INTO `orderitem` VALUES ('100571', '10229', '10035', '1', '6.00', '2019-04-12 23:51:42', '1');

-- ----------------------------
-- Table structure for `orderitems`
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `os_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `d_id` bigint(20) DEFAULT NULL,
  `os_allprice` float(20,2) DEFAULT '0.00',
  `os_position` bigint(20) DEFAULT '0',
  `os_regtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`os_id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `d_id` FOREIGN KEY (`d_id`) REFERENCES `desk` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10230 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderitems
-- ----------------------------
INSERT INTO `orderitems` VALUES ('10018', '1000', '64.00', '3', '2019-03-01 09:46:23');
INSERT INTO `orderitems` VALUES ('10019', '1000', '0.00', '3', '2019-03-01 09:52:27');
INSERT INTO `orderitems` VALUES ('10020', '1000', '0.00', '3', '2019-03-01 09:48:26');
INSERT INTO `orderitems` VALUES ('10021', '1000', '0.00', '3', '2019-03-01 09:48:26');
INSERT INTO `orderitems` VALUES ('10022', '1000', '0.00', '3', '2019-03-01 09:48:27');
INSERT INTO `orderitems` VALUES ('10023', '1000', '0.00', '3', '2019-03-01 09:48:28');
INSERT INTO `orderitems` VALUES ('10024', '1000', '0.00', '3', '2019-03-01 09:48:28');
INSERT INTO `orderitems` VALUES ('10025', '1000', '0.00', '3', '2019-03-01 09:48:29');
INSERT INTO `orderitems` VALUES ('10026', '1000', '0.00', '3', '2019-03-01 09:48:30');
INSERT INTO `orderitems` VALUES ('10027', '1000', '0.00', '3', '2019-03-01 09:48:30');
INSERT INTO `orderitems` VALUES ('10028', '1000', '0.00', '3', '2019-03-01 09:48:31');
INSERT INTO `orderitems` VALUES ('10029', '1000', '0.00', '3', '2019-03-01 09:48:32');
INSERT INTO `orderitems` VALUES ('10030', '1000', '0.00', '3', '2019-03-01 09:48:32');
INSERT INTO `orderitems` VALUES ('10031', '1000', '0.00', '2', '2019-03-02 10:27:13');
INSERT INTO `orderitems` VALUES ('10032', '1000', '0.00', '2', '2019-03-02 10:27:14');
INSERT INTO `orderitems` VALUES ('10033', '1000', '0.00', '3', '2019-03-01 09:58:30');
INSERT INTO `orderitems` VALUES ('10034', '1000', '0.00', '3', '2019-03-01 10:00:02');
INSERT INTO `orderitems` VALUES ('10035', '1000', '0.00', '3', '2019-03-01 10:03:36');
INSERT INTO `orderitems` VALUES ('10036', '1000', '190.00', '3', '2019-03-01 10:04:26');
INSERT INTO `orderitems` VALUES ('10037', '1000', '64.00', '3', '2019-03-01 10:18:50');
INSERT INTO `orderitems` VALUES ('10038', '1000', '90.00', '3', '2019-03-01 10:27:30');
INSERT INTO `orderitems` VALUES ('10039', '1000', '64.00', '3', '2019-03-01 10:31:03');
INSERT INTO `orderitems` VALUES ('10040', '1000', '96.00', '3', '2019-03-01 10:33:53');
INSERT INTO `orderitems` VALUES ('10041', '1000', '96.00', '3', '2019-03-01 10:36:15');
INSERT INTO `orderitems` VALUES ('10042', '1000', '96.00', '3', '2019-03-01 10:38:07');
INSERT INTO `orderitems` VALUES ('10043', '1000', '96.00', '3', '2019-04-01 12:55:22');
INSERT INTO `orderitems` VALUES ('10044', '1000', '50.00', '3', '2019-03-01 10:52:28');
INSERT INTO `orderitems` VALUES ('10045', '1000', '54.00', '2', '2019-03-02 10:27:18');
INSERT INTO `orderitems` VALUES ('10046', '1001', '96.00', '2', '2019-03-02 10:27:20');
INSERT INTO `orderitems` VALUES ('10047', '1001', '76.00', '3', '2019-03-01 17:19:59');
INSERT INTO `orderitems` VALUES ('10048', '1001', '118.00', '2', '2019-03-02 10:27:21');
INSERT INTO `orderitems` VALUES ('10049', '1001', '136.00', '2', '2019-03-02 10:27:23');
INSERT INTO `orderitems` VALUES ('10050', '1001', '136.00', '2', '2019-03-02 10:27:24');
INSERT INTO `orderitems` VALUES ('10051', '1001', '44.00', '2', '2019-03-02 10:27:24');
INSERT INTO `orderitems` VALUES ('10052', '1001', '44.00', '3', '2019-04-01 12:55:11');
INSERT INTO `orderitems` VALUES ('10053', '1001', '158.00', '2', '2019-03-02 11:48:22');
INSERT INTO `orderitems` VALUES ('10056', '1001', '44.00', '2', '2019-03-02 10:40:39');
INSERT INTO `orderitems` VALUES ('10058', '1000', '626.00', '2', '2019-03-02 14:27:24');
INSERT INTO `orderitems` VALUES ('10069', '1000', '140.00', '2', '2019-03-02 14:53:52');
INSERT INTO `orderitems` VALUES ('10070', '1000', '158.00', '2', '2019-03-02 14:54:53');
INSERT INTO `orderitems` VALUES ('10071', '1000', '60.00', '2', '2019-03-02 14:57:08');
INSERT INTO `orderitems` VALUES ('10072', '1000', '58.00', '2', '2019-03-02 14:58:16');
INSERT INTO `orderitems` VALUES ('10073', '1000', '60.00', '2', '2019-03-02 15:11:31');
INSERT INTO `orderitems` VALUES ('10074', '1000', '60.00', '2', '2019-03-02 15:12:33');
INSERT INTO `orderitems` VALUES ('10075', '1000', '32.00', '3', '2019-03-02 17:07:48');
INSERT INTO `orderitems` VALUES ('10076', '1000', '28.00', '3', '2019-03-02 17:17:29');
INSERT INTO `orderitems` VALUES ('10077', '1001', '32.00', '3', '2019-03-02 19:15:13');
INSERT INTO `orderitems` VALUES ('10078', '1000', '32.00', '3', '2019-03-02 18:07:35');
INSERT INTO `orderitems` VALUES ('10079', '1000', '32.00', '3', '2019-03-02 18:07:46');
INSERT INTO `orderitems` VALUES ('10080', '1000', '32.00', '3', '2019-03-02 18:10:23');
INSERT INTO `orderitems` VALUES ('10081', '1000', '60.00', '3', '2019-03-02 18:10:31');
INSERT INTO `orderitems` VALUES ('10082', '1000', '884.00', '3', '2019-03-02 18:15:00');
INSERT INTO `orderitems` VALUES ('10083', '1000', '32.00', '3', '2019-03-02 18:19:46');
INSERT INTO `orderitems` VALUES ('10084', '1000', '32.00', '3', '2019-03-02 18:25:29');
INSERT INTO `orderitems` VALUES ('10085', '1000', '32.00', '3', '2019-03-02 18:26:41');
INSERT INTO `orderitems` VALUES ('10086', '1000', '28.00', '3', '2019-03-02 18:27:16');
INSERT INTO `orderitems` VALUES ('10087', '1000', '92.00', '3', '2019-03-02 18:27:36');
INSERT INTO `orderitems` VALUES ('10088', '1000', '28.00', '3', '2019-03-02 18:28:41');
INSERT INTO `orderitems` VALUES ('10089', '1000', '114.00', '3', '2019-03-02 18:29:41');
INSERT INTO `orderitems` VALUES ('10090', '1000', '28.00', '3', '2019-03-02 18:31:31');
INSERT INTO `orderitems` VALUES ('10091', '1000', '1472.00', '3', '2019-03-02 18:31:54');
INSERT INTO `orderitems` VALUES ('10092', '1000', '0.00', '3', '2019-03-02 18:34:00');
INSERT INTO `orderitems` VALUES ('10093', '1000', '32.00', '3', '2019-03-02 18:34:08');
INSERT INTO `orderitems` VALUES ('10094', '1000', '32.00', '3', '2019-03-02 18:34:24');
INSERT INTO `orderitems` VALUES ('10095', '1000', '32.00', '3', '2019-03-02 18:35:38');
INSERT INTO `orderitems` VALUES ('10096', '1000', '32.00', '3', '2019-03-02 18:40:35');
INSERT INTO `orderitems` VALUES ('10097', '1000', '90.00', '3', '2019-03-02 19:04:15');
INSERT INTO `orderitems` VALUES ('10098', '1000', '64.00', '3', '2019-03-02 19:06:44');
INSERT INTO `orderitems` VALUES ('10099', '1000', '100.00', '3', '2019-03-02 19:09:21');
INSERT INTO `orderitems` VALUES ('10100', '1000', '64.00', '3', '2019-03-02 19:11:14');
INSERT INTO `orderitems` VALUES ('10101', '1000', '2284.00', '3', '2019-03-02 19:12:52');
INSERT INTO `orderitems` VALUES ('10102', '1000', '1160.00', '3', '2019-03-02 19:13:45');
INSERT INTO `orderitems` VALUES ('10103', '1000', '60.00', '3', '2019-03-02 19:14:30');
INSERT INTO `orderitems` VALUES ('10104', '1000', '-140.00', '3', '2019-03-02 23:07:02');
INSERT INTO `orderitems` VALUES ('10105', '1001', '54.00', '3', '2019-03-03 14:26:09');
INSERT INTO `orderitems` VALUES ('10106', '1000', '17388.00', '3', '2019-03-03 09:55:34');
INSERT INTO `orderitems` VALUES ('10107', '1000', '64.00', '3', '2019-03-03 10:29:00');
INSERT INTO `orderitems` VALUES ('10108', '1000', '128.00', '3', '2019-03-03 10:38:07');
INSERT INTO `orderitems` VALUES ('10109', '1000', '-32.00', '3', '2019-03-03 10:44:21');
INSERT INTO `orderitems` VALUES ('10110', '1000', '0.00', '3', '2019-03-03 10:45:20');
INSERT INTO `orderitems` VALUES ('10111', '1000', '0.00', '3', '2019-03-03 10:47:04');
INSERT INTO `orderitems` VALUES ('10112', '1000', '-60.00', '3', '2019-03-03 11:02:22');
INSERT INTO `orderitems` VALUES ('10113', '1000', '-28.00', '3', '2019-03-03 11:03:47');
INSERT INTO `orderitems` VALUES ('10114', '1000', '-64.00', '3', '2019-03-03 11:07:10');
INSERT INTO `orderitems` VALUES ('10115', '1000', '0.00', '3', '2019-03-03 11:11:37');
INSERT INTO `orderitems` VALUES ('10116', '1000', '128.00', '3', '2019-03-03 11:30:34');
INSERT INTO `orderitems` VALUES ('10117', '1000', '56.00', '3', '2019-03-03 11:19:59');
INSERT INTO `orderitems` VALUES ('10118', '1000', '58.00', '3', '2019-03-03 11:20:57');
INSERT INTO `orderitems` VALUES ('10119', '1000', '192.00', '3', '2019-03-03 11:21:29');
INSERT INTO `orderitems` VALUES ('10120', '1000', '192.00', '3', '2019-03-03 11:21:55');
INSERT INTO `orderitems` VALUES ('10121', '1000', '224.00', '3', '2019-03-03 11:22:33');
INSERT INTO `orderitems` VALUES ('10122', '1000', '88.00', '3', '2019-03-03 11:22:48');
INSERT INTO `orderitems` VALUES ('10123', '1000', '88.00', '3', '2019-03-03 11:25:53');
INSERT INTO `orderitems` VALUES ('10124', '1000', '128.00', '3', '2019-03-03 11:32:46');
INSERT INTO `orderitems` VALUES ('10125', '1000', '128.00', '3', '2019-03-03 11:34:17');
INSERT INTO `orderitems` VALUES ('10126', '1000', '128.00', '3', '2019-03-03 11:34:41');
INSERT INTO `orderitems` VALUES ('10127', '1000', '128.00', '3', '2019-03-03 11:36:56');
INSERT INTO `orderitems` VALUES ('10128', '1000', '262.00', '3', '2019-03-03 11:37:56');
INSERT INTO `orderitems` VALUES ('10129', '1000', '147.00', '3', '2019-03-03 11:39:01');
INSERT INTO `orderitems` VALUES ('10130', '1000', '192.00', '3', '2019-03-03 11:39:36');
INSERT INTO `orderitems` VALUES ('10131', '1000', '0.00', '3', '2019-03-03 12:33:02');
INSERT INTO `orderitems` VALUES ('10132', '1000', '184.00', '3', '2019-03-03 12:48:48');
INSERT INTO `orderitems` VALUES ('10133', '1000', '202.00', '3', '2019-03-03 12:50:23');
INSERT INTO `orderitems` VALUES ('10134', '1000', '240.00', '3', '2019-03-03 12:52:30');
INSERT INTO `orderitems` VALUES ('10135', '1001', '158.00', '3', '2019-03-03 20:40:16');
INSERT INTO `orderitems` VALUES ('10136', '1001', '162.00', '3', '2019-03-03 21:54:08');
INSERT INTO `orderitems` VALUES ('10137', '1001', '32.00', '3', '2019-03-03 22:08:39');
INSERT INTO `orderitems` VALUES ('10138', '1001', '434.00', '3', '2019-03-03 22:26:31');
INSERT INTO `orderitems` VALUES ('10139', '1001', '98.00', '3', '2019-03-03 22:40:26');
INSERT INTO `orderitems` VALUES ('10140', '1001', '154.00', '3', '2019-03-03 22:41:53');
INSERT INTO `orderitems` VALUES ('10141', '1001', '266.00', '3', '2019-03-03 22:43:20');
INSERT INTO `orderitems` VALUES ('10142', '1000', '292.00', '3', '2019-03-04 20:44:34');
INSERT INTO `orderitems` VALUES ('10143', '1001', '32.00', '3', '2019-03-04 13:36:26');
INSERT INTO `orderitems` VALUES ('10144', '1001', '32.00', '3', '2019-03-04 13:48:37');
INSERT INTO `orderitems` VALUES ('10145', '1001', '312.00', '3', '2019-03-04 14:52:49');
INSERT INTO `orderitems` VALUES ('10146', '1001', '32.00', '3', '2019-03-04 20:42:09');
INSERT INTO `orderitems` VALUES ('10147', '1001', '32.00', '3', '2019-03-04 20:45:26');
INSERT INTO `orderitems` VALUES ('10148', '1001', '32.00', '3', '2019-03-04 20:45:38');
INSERT INTO `orderitems` VALUES ('10149', '1001', '58.00', '3', '2019-03-04 20:46:18');
INSERT INTO `orderitems` VALUES ('10150', '1000', '6.00', '3', '2019-03-13 15:41:06');
INSERT INTO `orderitems` VALUES ('10151', '1000', '0.00', '3', '2019-03-14 23:14:01');
INSERT INTO `orderitems` VALUES ('10152', '1001', '264.00', '3', '2019-03-14 17:18:19');
INSERT INTO `orderitems` VALUES ('10153', '1001', '22.00', '3', '2019-03-14 17:19:28');
INSERT INTO `orderitems` VALUES ('10154', '1001', '206.00', '3', '2019-03-14 23:14:04');
INSERT INTO `orderitems` VALUES ('10155', '1000', '58.00', '3', '2019-03-16 10:36:51');
INSERT INTO `orderitems` VALUES ('10156', '1002', '12.00', '3', '2019-03-15 16:10:01');
INSERT INTO `orderitems` VALUES ('10157', '1017', '968.00', '2', '2019-03-15 16:13:22');
INSERT INTO `orderitems` VALUES ('10160', '1001', '226.00', '2', '2019-03-15 16:11:15');
INSERT INTO `orderitems` VALUES ('10161', '1001', '32.00', '3', '2019-03-15 18:14:50');
INSERT INTO `orderitems` VALUES ('10162', '1001', '28.00', '3', '2019-03-15 18:15:55');
INSERT INTO `orderitems` VALUES ('10163', '1001', '32.00', '3', '2019-03-15 18:17:16');
INSERT INTO `orderitems` VALUES ('10164', '1001', '18.00', '3', '2019-03-15 18:20:00');
INSERT INTO `orderitems` VALUES ('10165', '1001', '58.00', '3', '2019-03-15 18:21:53');
INSERT INTO `orderitems` VALUES ('10166', '1001', '32.00', '3', '2019-03-15 18:27:20');
INSERT INTO `orderitems` VALUES ('10167', '1001', '68.00', '2', '2019-03-16 09:41:48');
INSERT INTO `orderitems` VALUES ('10168', '1009', '58.00', '3', '2019-03-16 09:08:21');
INSERT INTO `orderitems` VALUES ('10169', '1002', '22.00', '2', '2019-03-16 09:22:59');
INSERT INTO `orderitems` VALUES ('10170', '1002', '86.00', '2', '2019-03-16 09:25:58');
INSERT INTO `orderitems` VALUES ('10172', '1008', '58.00', '2', '2019-03-16 09:48:36');
INSERT INTO `orderitems` VALUES ('10173', '1015', '960.00', '2', '2019-03-16 10:16:09');
INSERT INTO `orderitems` VALUES ('10174', '1015', '8.00', '3', '2019-03-16 10:13:13');
INSERT INTO `orderitems` VALUES ('10177', '1014', '58.00', '2', '2019-03-16 10:19:28');
INSERT INTO `orderitems` VALUES ('10178', '1014', '0.00', '2', '2019-04-03 23:38:42');
INSERT INTO `orderitems` VALUES ('10179', '1007', '156.00', '2', '2019-03-16 11:01:53');
INSERT INTO `orderitems` VALUES ('10181', '1007', '172.00', '3', '2019-04-03 09:48:33');
INSERT INTO `orderitems` VALUES ('10182', '1002', '68.00', '3', '2019-04-03 09:48:33');
INSERT INTO `orderitems` VALUES ('10183', '1003', '28.00', '3', '2019-04-03 09:48:33');
INSERT INTO `orderitems` VALUES ('10184', '1001', '68.00', '2', '2019-04-03 23:38:48');
INSERT INTO `orderitems` VALUES ('10185', '1003', '0.00', '3', '2019-04-03 20:30:33');
INSERT INTO `orderitems` VALUES ('10186', '1005', '0.00', '3', '2019-04-03 20:45:25');
INSERT INTO `orderitems` VALUES ('10187', '1006', '0.00', '2', '2019-04-03 23:38:46');
INSERT INTO `orderitems` VALUES ('10188', '1007', '0.00', '3', '2019-04-03 17:30:24');
INSERT INTO `orderitems` VALUES ('10189', '1007', '294.00', '3', '2019-04-03 17:31:12');
INSERT INTO `orderitems` VALUES ('10190', '1007', '136.00', '3', '2019-04-03 17:33:05');
INSERT INTO `orderitems` VALUES ('10191', '1007', '168.00', '2', '2019-04-03 23:38:51');
INSERT INTO `orderitems` VALUES ('10192', '1008', '408.00', '2', '2019-04-03 23:38:53');
INSERT INTO `orderitems` VALUES ('10193', '1009', '160.00', '2', '2019-04-03 23:38:52');
INSERT INTO `orderitems` VALUES ('10194', '1009', '452.00', '3', '2019-04-03 18:26:48');
INSERT INTO `orderitems` VALUES ('10195', '1009', '44.00', '3', '2019-04-03 18:44:12');
INSERT INTO `orderitems` VALUES ('10196', '1011', '272.00', '2', '2019-04-03 23:38:54');
INSERT INTO `orderitems` VALUES ('10197', '1001', '6.00', '2', '2019-04-03 23:38:56');
INSERT INTO `orderitems` VALUES ('10198', '1002', '68.00', '2', '2019-04-03 23:38:57');
INSERT INTO `orderitems` VALUES ('10199', '1003', '68.00', '3', '2019-04-03 20:33:28');
INSERT INTO `orderitems` VALUES ('10200', '1003', '68.00', '3', '2019-04-03 20:34:48');
INSERT INTO `orderitems` VALUES ('10201', '1003', '68.00', '3', '2019-04-03 20:37:15');
INSERT INTO `orderitems` VALUES ('10202', '1003', '48.00', '3', '2019-04-03 20:40:06');
INSERT INTO `orderitems` VALUES ('10203', '1003', '68.00', '2', '2019-04-03 23:38:59');
INSERT INTO `orderitems` VALUES ('10204', '1004', '68.00', '2', '2019-04-03 23:39:00');
INSERT INTO `orderitems` VALUES ('10205', '1005', '32.00', '3', '2019-04-03 20:48:24');
INSERT INTO `orderitems` VALUES ('10206', '1005', '68.00', '3', '2019-04-03 20:53:57');
INSERT INTO `orderitems` VALUES ('10207', '1005', '68.00', '3', '2019-04-03 20:58:42');
INSERT INTO `orderitems` VALUES ('10208', '1005', '48.00', '3', '2019-04-03 21:15:21');
INSERT INTO `orderitems` VALUES ('10209', '1005', '68.00', '3', '2019-04-03 21:17:07');
INSERT INTO `orderitems` VALUES ('10210', '1005', '48.00', '3', '2019-04-03 22:48:44');
INSERT INTO `orderitems` VALUES ('10211', '1005', '68.00', '3', '2019-04-03 22:56:11');
INSERT INTO `orderitems` VALUES ('10212', '1005', '8.00', '2', '2019-04-03 23:03:08');
INSERT INTO `orderitems` VALUES ('10213', '1005', '6.00', '2', '2019-04-03 23:39:05');
INSERT INTO `orderitems` VALUES ('10214', '1005', '12.00', '2', '2019-04-03 23:39:06');
INSERT INTO `orderitems` VALUES ('10215', '1005', '48.00', '2', '2019-04-03 23:39:07');
INSERT INTO `orderitems` VALUES ('10216', '1005', '12.00', '2', '2019-04-03 23:39:08');
INSERT INTO `orderitems` VALUES ('10217', '1006', '74.00', '2', '2019-04-10 23:02:24');
INSERT INTO `orderitems` VALUES ('10218', '1006', '6.00', '1', '2019-04-03 23:41:43');
INSERT INTO `orderitems` VALUES ('10219', '1006', '28.00', '1', '2019-04-03 23:44:12');
INSERT INTO `orderitems` VALUES ('10221', '1007', '76.00', '2', '2019-04-10 23:02:15');
INSERT INTO `orderitems` VALUES ('10223', '1008', '80.00', '2', '2019-04-04 00:35:11');
INSERT INTO `orderitems` VALUES ('10225', '1008', '90.00', '3', '2019-04-04 00:31:50');
INSERT INTO `orderitems` VALUES ('10228', '1008', '58.00', '2', '2019-04-10 23:00:36');
INSERT INTO `orderitems` VALUES ('10229', '1002', '142.00', '1', '2019-04-12 23:51:42');
