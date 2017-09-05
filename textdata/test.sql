/*
Navicat MySQL Data Transfer

Source Server         : spark001
Source Server Version : 50173
Source Host           : spark001:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-12-02 15:03:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `good_student_infos`
-- ----------------------------
DROP TABLE IF EXISTS `good_student_infos`;
CREATE TABLE `good_student_infos` (
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good_student_infos
-- ----------------------------
INSERT INTO `good_student_infos` VALUES ('yasaka', '18', '88');
INSERT INTO `good_student_infos` VALUES ('annie', '17', '99');
INSERT INTO `good_student_infos` VALUES ('yasaka', '18', '88');
INSERT INTO `good_student_infos` VALUES ('annie', '17', '99');
INSERT INTO `good_student_infos` VALUES ('yasaka', '18', '88');
INSERT INTO `good_student_infos` VALUES ('annie', '17', '99');
INSERT INTO `good_student_infos` VALUES ('yasaka', '18', '88');
INSERT INTO `good_student_infos` VALUES ('annie', '17', '99');
INSERT INTO `good_student_infos` VALUES ('yasaka', '18', '88');
INSERT INTO `good_student_infos` VALUES ('annie', '17', '99');

-- ----------------------------
-- Table structure for `student_infos`
-- ----------------------------
DROP TABLE IF EXISTS `student_infos`;
CREATE TABLE `student_infos` (
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student_infos
-- ----------------------------
INSERT INTO `student_infos` VALUES ('yasaka', '18');
INSERT INTO `student_infos` VALUES ('annie', '17');
INSERT INTO `student_infos` VALUES ('april', '19');

-- ----------------------------
-- Table structure for `student_scores`
-- ----------------------------
DROP TABLE IF EXISTS `student_scores`;
CREATE TABLE `student_scores` (
  `name` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student_scores
-- ----------------------------
INSERT INTO `student_scores` VALUES ('yasaka', '88');
INSERT INTO `student_scores` VALUES ('annie', '99');
INSERT INTO `student_scores` VALUES ('april', '70');

-- ----------------------------
-- Table structure for `wordcount`
-- ----------------------------
DROP TABLE IF EXISTS `wordcount`;
CREATE TABLE `wordcount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `word` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=535 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of wordcount
-- ----------------------------
INSERT INTO `wordcount` VALUES ('1', '2016-04-21 02:09:35', 'hello', '1');
INSERT INTO `wordcount` VALUES ('2', '2016-04-21 02:09:35', 'world', '1');
INSERT INTO `wordcount` VALUES ('3', '2016-04-21 02:09:40', 'hello', '1');
INSERT INTO `wordcount` VALUES ('4', '2016-04-21 02:09:40', 'world', '1');
INSERT INTO `wordcount` VALUES ('5', '2016-04-21 02:09:45', 'hello', '1');
INSERT INTO `wordcount` VALUES ('6', '2016-04-21 02:09:45', 'world', '1');
INSERT INTO `wordcount` VALUES ('7', '2016-04-21 02:09:50', 'hello', '3');
INSERT INTO `wordcount` VALUES ('8', '2016-04-21 02:09:50', 'me', '1');
INSERT INTO `wordcount` VALUES ('9', '2016-04-21 02:09:50', 'world', '1');
INSERT INTO `wordcount` VALUES ('10', '2016-04-21 02:09:50', 'you', '1');
INSERT INTO `wordcount` VALUES ('11', '2016-04-21 02:09:55', 'shit', '1');
INSERT INTO `wordcount` VALUES ('12', '2016-04-21 02:09:55', 'hello', '4');
INSERT INTO `wordcount` VALUES ('13', '2016-04-21 02:09:55', 'me', '1');
INSERT INTO `wordcount` VALUES ('14', '2016-04-21 02:09:55', 'world', '1');
INSERT INTO `wordcount` VALUES ('15', '2016-04-21 02:09:55', 'you', '1');
INSERT INTO `wordcount` VALUES ('16', '2016-04-21 02:10:00', 'shit', '1');
INSERT INTO `wordcount` VALUES ('17', '2016-04-21 02:10:00', 'hello', '5');
INSERT INTO `wordcount` VALUES ('18', '2016-04-21 02:10:00', 'me', '1');
INSERT INTO `wordcount` VALUES ('19', '2016-04-21 02:10:00', 'world', '1');
INSERT INTO `wordcount` VALUES ('20', '2016-04-21 02:10:00', 'you', '1');
INSERT INTO `wordcount` VALUES ('21', '2016-04-21 02:10:05', 'shit', '1');
INSERT INTO `wordcount` VALUES ('22', '2016-04-21 02:10:05', 'hello', '5');
INSERT INTO `wordcount` VALUES ('23', '2016-04-21 02:10:05', 'me', '1');
INSERT INTO `wordcount` VALUES ('24', '2016-04-21 02:10:05', 'world', '1');
INSERT INTO `wordcount` VALUES ('25', '2016-04-21 02:10:05', 'you', '1');
INSERT INTO `wordcount` VALUES ('26', '2016-04-21 02:10:10', 'shit', '1');
INSERT INTO `wordcount` VALUES ('27', '2016-04-21 02:10:10', 'hello', '5');
INSERT INTO `wordcount` VALUES ('28', '2016-04-21 02:10:10', 'me', '1');
INSERT INTO `wordcount` VALUES ('29', '2016-04-21 02:10:10', 'world', '1');
INSERT INTO `wordcount` VALUES ('30', '2016-04-21 02:10:10', 'you', '1');
INSERT INTO `wordcount` VALUES ('31', '2016-04-21 02:10:15', 'shit', '1');
INSERT INTO `wordcount` VALUES ('32', '2016-04-21 02:10:15', 'hello', '5');
INSERT INTO `wordcount` VALUES ('33', '2016-04-21 02:10:15', 'me', '1');
INSERT INTO `wordcount` VALUES ('34', '2016-04-21 02:10:15', 'world', '1');
INSERT INTO `wordcount` VALUES ('35', '2016-04-21 02:10:15', 'you', '1');
INSERT INTO `wordcount` VALUES ('36', '2016-04-21 02:10:20', 'shit', '1');
INSERT INTO `wordcount` VALUES ('37', '2016-04-21 02:10:20', 'hello', '5');
INSERT INTO `wordcount` VALUES ('38', '2016-04-21 02:10:20', 'me', '1');
INSERT INTO `wordcount` VALUES ('39', '2016-04-21 02:10:20', 'world', '1');
INSERT INTO `wordcount` VALUES ('40', '2016-04-21 02:10:20', 'you', '1');
INSERT INTO `wordcount` VALUES ('41', '2016-04-21 02:10:25', 'shit', '1');
INSERT INTO `wordcount` VALUES ('42', '2016-04-21 02:10:25', 'hello', '5');
INSERT INTO `wordcount` VALUES ('43', '2016-04-21 02:10:25', 'me', '1');
INSERT INTO `wordcount` VALUES ('44', '2016-04-21 02:10:25', 'world', '1');
INSERT INTO `wordcount` VALUES ('45', '2016-04-21 02:10:25', 'you', '1');
INSERT INTO `wordcount` VALUES ('46', '2016-04-21 02:10:30', 'shit', '1');
INSERT INTO `wordcount` VALUES ('47', '2016-04-21 02:10:30', 'hello', '5');
INSERT INTO `wordcount` VALUES ('48', '2016-04-21 02:10:30', 'me', '1');
INSERT INTO `wordcount` VALUES ('49', '2016-04-21 02:10:30', 'world', '1');
INSERT INTO `wordcount` VALUES ('50', '2016-04-21 02:10:30', 'you', '1');
INSERT INTO `wordcount` VALUES ('51', '2016-04-21 02:10:35', 'shit', '1');
INSERT INTO `wordcount` VALUES ('52', '2016-04-21 02:10:35', 'hello', '5');
INSERT INTO `wordcount` VALUES ('53', '2016-04-21 02:10:35', 'me', '1');
INSERT INTO `wordcount` VALUES ('54', '2016-04-21 02:10:35', 'world', '1');
INSERT INTO `wordcount` VALUES ('55', '2016-04-21 02:10:35', 'you', '1');
INSERT INTO `wordcount` VALUES ('56', '2016-04-21 02:10:40', 'shit', '1');
INSERT INTO `wordcount` VALUES ('57', '2016-04-21 02:10:40', 'hello', '5');
INSERT INTO `wordcount` VALUES ('58', '2016-04-21 02:10:40', 'me', '1');
INSERT INTO `wordcount` VALUES ('59', '2016-04-21 02:10:40', 'world', '1');
INSERT INTO `wordcount` VALUES ('60', '2016-04-21 02:10:40', 'you', '1');
INSERT INTO `wordcount` VALUES ('61', '2016-04-21 02:10:45', 'shit', '1');
INSERT INTO `wordcount` VALUES ('62', '2016-04-21 02:10:45', 'hello', '5');
INSERT INTO `wordcount` VALUES ('63', '2016-04-21 02:10:45', 'me', '1');
INSERT INTO `wordcount` VALUES ('64', '2016-04-21 02:10:45', 'world', '1');
INSERT INTO `wordcount` VALUES ('65', '2016-04-21 02:10:45', 'you', '1');
INSERT INTO `wordcount` VALUES ('66', '2016-04-21 02:10:50', 'shit', '1');
INSERT INTO `wordcount` VALUES ('67', '2016-04-21 02:10:50', 'hello', '5');
INSERT INTO `wordcount` VALUES ('68', '2016-04-21 02:10:50', 'me', '1');
INSERT INTO `wordcount` VALUES ('69', '2016-04-21 02:10:50', 'world', '1');
INSERT INTO `wordcount` VALUES ('70', '2016-04-21 02:10:50', 'you', '1');
INSERT INTO `wordcount` VALUES ('71', '2016-04-21 02:10:55', 'shit', '1');
INSERT INTO `wordcount` VALUES ('72', '2016-04-21 02:10:55', 'hello', '5');
INSERT INTO `wordcount` VALUES ('73', '2016-04-21 02:10:55', 'me', '1');
INSERT INTO `wordcount` VALUES ('74', '2016-04-21 02:10:55', 'world', '1');
INSERT INTO `wordcount` VALUES ('75', '2016-04-21 02:10:55', 'you', '1');
INSERT INTO `wordcount` VALUES ('76', '2016-04-21 02:11:00', 'shit', '1');
INSERT INTO `wordcount` VALUES ('77', '2016-04-21 02:11:00', 'hello', '5');
INSERT INTO `wordcount` VALUES ('78', '2016-04-21 02:11:00', 'me', '1');
INSERT INTO `wordcount` VALUES ('79', '2016-04-21 02:11:00', 'world', '1');
INSERT INTO `wordcount` VALUES ('80', '2016-04-21 02:11:00', 'you', '1');
INSERT INTO `wordcount` VALUES ('81', '2016-04-21 02:11:05', 'shit', '1');
INSERT INTO `wordcount` VALUES ('82', '2016-04-21 02:11:05', 'hello', '5');
INSERT INTO `wordcount` VALUES ('83', '2016-04-21 02:11:05', 'me', '1');
INSERT INTO `wordcount` VALUES ('84', '2016-04-21 02:11:05', 'world', '1');
INSERT INTO `wordcount` VALUES ('85', '2016-04-21 02:11:05', 'you', '1');
INSERT INTO `wordcount` VALUES ('86', '2016-04-21 02:11:10', 'shit', '1');
INSERT INTO `wordcount` VALUES ('87', '2016-04-21 02:11:10', 'hello', '5');
INSERT INTO `wordcount` VALUES ('88', '2016-04-21 02:11:10', 'me', '1');
INSERT INTO `wordcount` VALUES ('89', '2016-04-21 02:11:10', 'world', '1');
INSERT INTO `wordcount` VALUES ('90', '2016-04-21 02:11:10', 'you', '1');
INSERT INTO `wordcount` VALUES ('91', '2016-04-21 02:11:15', 'shit', '1');
INSERT INTO `wordcount` VALUES ('92', '2016-04-21 02:11:15', 'hello', '5');
INSERT INTO `wordcount` VALUES ('93', '2016-04-21 02:11:15', 'me', '1');
INSERT INTO `wordcount` VALUES ('94', '2016-04-21 02:11:15', 'world', '1');
INSERT INTO `wordcount` VALUES ('95', '2016-04-21 02:11:15', 'you', '1');
INSERT INTO `wordcount` VALUES ('96', '2016-04-21 02:11:20', 'shit', '1');
INSERT INTO `wordcount` VALUES ('97', '2016-04-21 02:11:20', 'hello', '5');
INSERT INTO `wordcount` VALUES ('98', '2016-04-21 02:11:20', 'me', '1');
INSERT INTO `wordcount` VALUES ('99', '2016-04-21 02:11:20', 'world', '1');
INSERT INTO `wordcount` VALUES ('100', '2016-04-21 02:11:20', 'you', '1');
INSERT INTO `wordcount` VALUES ('101', '2016-04-21 02:11:25', 'shit', '1');
INSERT INTO `wordcount` VALUES ('102', '2016-04-21 02:11:25', 'hello', '5');
INSERT INTO `wordcount` VALUES ('103', '2016-04-21 02:11:25', 'me', '1');
INSERT INTO `wordcount` VALUES ('104', '2016-04-21 02:11:25', 'world', '1');
INSERT INTO `wordcount` VALUES ('105', '2016-04-21 02:11:25', 'you', '1');
INSERT INTO `wordcount` VALUES ('106', '2016-04-23 15:02:57', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('107', '2016-04-23 15:02:57', 'i', '1');
INSERT INTO `wordcount` VALUES ('108', '2016-04-23 15:02:57', 'marry', '1');
INSERT INTO `wordcount` VALUES ('109', '2016-04-23 15:03:02', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('110', '2016-04-23 15:03:02', 'i', '1');
INSERT INTO `wordcount` VALUES ('111', '2016-04-23 15:03:02', 'marry', '1');
INSERT INTO `wordcount` VALUES ('112', '2016-04-23 15:03:07', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('113', '2016-04-23 15:03:07', 'i', '1');
INSERT INTO `wordcount` VALUES ('114', '2016-04-23 15:03:07', 'marry', '1');
INSERT INTO `wordcount` VALUES ('115', '2016-04-23 15:03:12', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('116', '2016-04-23 15:03:12', 'i', '1');
INSERT INTO `wordcount` VALUES ('117', '2016-04-23 15:03:12', 'marry', '1');
INSERT INTO `wordcount` VALUES ('118', '2016-04-23 15:03:17', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('119', '2016-04-23 15:03:17', 'i', '1');
INSERT INTO `wordcount` VALUES ('120', '2016-04-23 15:03:17', 'marry', '1');
INSERT INTO `wordcount` VALUES ('121', '2016-04-23 15:03:22', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('122', '2016-04-23 15:03:22', 'i', '1');
INSERT INTO `wordcount` VALUES ('123', '2016-04-23 15:03:22', 'marry', '1');
INSERT INTO `wordcount` VALUES ('124', '2016-04-23 15:03:27', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('125', '2016-04-23 15:03:27', 'i', '1');
INSERT INTO `wordcount` VALUES ('126', '2016-04-23 15:03:27', 'marry', '1');
INSERT INTO `wordcount` VALUES ('127', '2016-04-23 15:03:32', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('128', '2016-04-23 15:03:32', 'i', '1');
INSERT INTO `wordcount` VALUES ('129', '2016-04-23 15:03:32', 'marry', '1');
INSERT INTO `wordcount` VALUES ('130', '2016-04-23 15:03:37', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('131', '2016-04-23 15:03:37', 'i', '1');
INSERT INTO `wordcount` VALUES ('132', '2016-04-23 15:03:37', 'marry', '1');
INSERT INTO `wordcount` VALUES ('133', '2016-04-23 15:03:42', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('134', '2016-04-23 15:03:42', 'i', '1');
INSERT INTO `wordcount` VALUES ('135', '2016-04-23 15:03:42', 'marry', '1');
INSERT INTO `wordcount` VALUES ('136', '2016-04-23 15:03:47', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('137', '2016-04-23 15:03:47', 'i', '1');
INSERT INTO `wordcount` VALUES ('138', '2016-04-23 15:03:47', 'marry', '1');
INSERT INTO `wordcount` VALUES ('139', '2016-04-23 15:03:52', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('140', '2016-04-23 15:03:52', 'i', '1');
INSERT INTO `wordcount` VALUES ('141', '2016-04-23 15:03:52', 'marry', '1');
INSERT INTO `wordcount` VALUES ('142', '2016-04-23 15:03:58', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('143', '2016-04-23 15:03:58', 'i', '1');
INSERT INTO `wordcount` VALUES ('144', '2016-04-23 15:03:58', 'marry', '1');
INSERT INTO `wordcount` VALUES ('145', '2016-04-23 15:04:02', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('146', '2016-04-23 15:04:02', 'i', '1');
INSERT INTO `wordcount` VALUES ('147', '2016-04-23 15:04:02', 'marry', '1');
INSERT INTO `wordcount` VALUES ('148', '2016-04-23 15:04:07', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('149', '2016-04-23 15:04:07', 'i', '1');
INSERT INTO `wordcount` VALUES ('150', '2016-04-23 15:04:07', 'marry', '1');
INSERT INTO `wordcount` VALUES ('151', '2016-04-23 15:04:12', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('152', '2016-04-23 15:04:12', 'i', '1');
INSERT INTO `wordcount` VALUES ('153', '2016-04-23 15:04:12', 'marry', '1');
INSERT INTO `wordcount` VALUES ('154', '2016-04-23 15:04:17', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('155', '2016-04-23 15:04:17', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('156', '2016-04-23 15:04:17', 'i', '2');
INSERT INTO `wordcount` VALUES ('157', '2016-04-23 15:04:17', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('158', '2016-04-23 15:04:17', 'marry', '1');
INSERT INTO `wordcount` VALUES ('159', '2016-04-23 15:04:22', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('160', '2016-04-23 15:04:22', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('161', '2016-04-23 15:04:22', 'i', '2');
INSERT INTO `wordcount` VALUES ('162', '2016-04-23 15:04:22', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('163', '2016-04-23 15:04:22', 'marry', '1');
INSERT INTO `wordcount` VALUES ('164', '2016-04-23 15:04:27', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('165', '2016-04-23 15:04:27', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('166', '2016-04-23 15:04:27', 'i', '2');
INSERT INTO `wordcount` VALUES ('167', '2016-04-23 15:04:27', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('168', '2016-04-23 15:04:27', 'marry', '1');
INSERT INTO `wordcount` VALUES ('169', '2016-04-23 15:04:32', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('170', '2016-04-23 15:04:32', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('171', '2016-04-23 15:04:32', 'i', '2');
INSERT INTO `wordcount` VALUES ('172', '2016-04-23 15:04:32', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('173', '2016-04-23 15:04:32', 'marry', '1');
INSERT INTO `wordcount` VALUES ('174', '2016-04-23 15:04:37', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('175', '2016-04-23 15:04:37', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('176', '2016-04-23 15:04:37', 'i', '2');
INSERT INTO `wordcount` VALUES ('177', '2016-04-23 15:04:37', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('178', '2016-04-23 15:04:37', 'marry', '1');
INSERT INTO `wordcount` VALUES ('179', '2016-04-23 15:04:42', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('180', '2016-04-23 15:04:42', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('181', '2016-04-23 15:04:42', 'i', '2');
INSERT INTO `wordcount` VALUES ('182', '2016-04-23 15:04:42', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('183', '2016-04-23 15:04:42', 'marry', '1');
INSERT INTO `wordcount` VALUES ('184', '2016-04-23 15:04:47', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('185', '2016-04-23 15:04:47', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('186', '2016-04-23 15:04:47', 'i', '2');
INSERT INTO `wordcount` VALUES ('187', '2016-04-23 15:04:47', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('188', '2016-04-23 15:04:47', 'marry', '1');
INSERT INTO `wordcount` VALUES ('189', '2016-04-23 15:04:52', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('190', '2016-04-23 15:04:52', 'xuruyu', '1');
INSERT INTO `wordcount` VALUES ('191', '2016-04-23 15:04:52', 'i', '2');
INSERT INTO `wordcount` VALUES ('192', '2016-04-23 15:04:52', 'mrayr', '1');
INSERT INTO `wordcount` VALUES ('193', '2016-04-23 15:04:52', 'marry', '1');
INSERT INTO `wordcount` VALUES ('194', '2016-05-09 11:56:32', 'xuruyun', '2');
INSERT INTO `wordcount` VALUES ('195', '2016-05-09 11:56:32', 'love', '2');
INSERT INTO `wordcount` VALUES ('196', '2016-05-09 11:56:32', 'i', '2');
INSERT INTO `wordcount` VALUES ('197', '2016-05-09 11:56:37', 'xuruyun', '2');
INSERT INTO `wordcount` VALUES ('198', '2016-05-09 11:56:37', 'love', '2');
INSERT INTO `wordcount` VALUES ('199', '2016-05-09 11:56:37', 'i', '2');
INSERT INTO `wordcount` VALUES ('200', '2016-05-09 11:56:42', 'xuruyun', '2');
INSERT INTO `wordcount` VALUES ('201', '2016-05-09 11:56:42', 'love', '2');
INSERT INTO `wordcount` VALUES ('202', '2016-05-09 11:56:42', 'i', '2');
INSERT INTO `wordcount` VALUES ('203', '2016-05-09 11:56:47', 'xuruyun', '2');
INSERT INTO `wordcount` VALUES ('204', '2016-05-09 11:56:47', 'love', '2');
INSERT INTO `wordcount` VALUES ('205', '2016-05-09 11:56:47', 'i', '2');
INSERT INTO `wordcount` VALUES ('206', '2016-05-09 11:56:52', 'xuruyun', '2');
INSERT INTO `wordcount` VALUES ('207', '2016-05-09 11:56:52', 'love', '2');
INSERT INTO `wordcount` VALUES ('208', '2016-05-09 11:56:52', 'i', '2');
INSERT INTO `wordcount` VALUES ('209', '2016-05-09 11:56:57', 'xuruyun', '2');
INSERT INTO `wordcount` VALUES ('210', '2016-05-09 11:56:57', 'love', '2');
INSERT INTO `wordcount` VALUES ('211', '2016-05-09 11:56:57', 'i', '2');
INSERT INTO `wordcount` VALUES ('212', '2016-06-17 10:57:15', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('213', '2016-06-17 10:57:15', 'over', '1');
INSERT INTO `wordcount` VALUES ('214', '2016-06-17 10:57:15', 'old', '1');
INSERT INTO `wordcount` VALUES ('215', '2016-06-17 10:57:20', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('216', '2016-06-17 10:57:20', 'over', '1');
INSERT INTO `wordcount` VALUES ('217', '2016-06-17 10:57:20', 'old', '1');
INSERT INTO `wordcount` VALUES ('218', '2016-06-17 10:57:25', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('219', '2016-06-17 10:57:25', 'over', '1');
INSERT INTO `wordcount` VALUES ('220', '2016-06-17 10:57:25', 'old', '1');
INSERT INTO `wordcount` VALUES ('221', '2016-06-17 10:57:30', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('222', '2016-06-17 10:57:30', 'over', '1');
INSERT INTO `wordcount` VALUES ('223', '2016-06-17 10:57:30', 'old', '1');
INSERT INTO `wordcount` VALUES ('224', '2016-06-17 10:57:35', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('225', '2016-06-17 10:57:35', 'over', '1');
INSERT INTO `wordcount` VALUES ('226', '2016-06-17 10:57:35', 'old', '1');
INSERT INTO `wordcount` VALUES ('227', '2016-06-17 10:57:40', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('228', '2016-06-17 10:57:40', 'over', '1');
INSERT INTO `wordcount` VALUES ('229', '2016-06-17 10:57:40', 'old', '1');
INSERT INTO `wordcount` VALUES ('230', '2016-06-17 10:57:45', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('231', '2016-06-17 10:57:45', 'over', '1');
INSERT INTO `wordcount` VALUES ('232', '2016-06-17 10:57:45', 'old', '1');
INSERT INTO `wordcount` VALUES ('233', '2016-06-17 10:57:50', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('234', '2016-06-17 10:57:50', 'over', '1');
INSERT INTO `wordcount` VALUES ('235', '2016-06-17 10:57:50', 'old', '1');
INSERT INTO `wordcount` VALUES ('236', '2016-06-17 10:57:55', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('237', '2016-06-17 10:57:55', 'over', '1');
INSERT INTO `wordcount` VALUES ('238', '2016-06-17 10:57:55', 'old', '1');
INSERT INTO `wordcount` VALUES ('239', '2016-06-17 10:58:00', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('240', '2016-06-17 10:58:00', 'over', '1');
INSERT INTO `wordcount` VALUES ('241', '2016-06-17 10:58:00', 'old', '1');
INSERT INTO `wordcount` VALUES ('242', '2016-06-17 10:58:05', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('243', '2016-06-17 10:58:05', 'over', '1');
INSERT INTO `wordcount` VALUES ('244', '2016-06-17 10:58:05', 'old', '1');
INSERT INTO `wordcount` VALUES ('245', '2016-06-17 10:58:10', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('246', '2016-06-17 10:58:10', 'over', '1');
INSERT INTO `wordcount` VALUES ('247', '2016-06-17 10:58:10', 'old', '1');
INSERT INTO `wordcount` VALUES ('248', '2016-06-17 10:58:15', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('249', '2016-06-17 10:58:15', 'over', '1');
INSERT INTO `wordcount` VALUES ('250', '2016-06-17 10:58:15', 'old', '1');
INSERT INTO `wordcount` VALUES ('251', '2016-06-17 10:58:20', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('252', '2016-06-17 10:58:20', 'over', '1');
INSERT INTO `wordcount` VALUES ('253', '2016-06-17 10:58:20', 'old', '1');
INSERT INTO `wordcount` VALUES ('254', '2016-06-17 10:58:25', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('255', '2016-06-17 10:58:25', 'over', '1');
INSERT INTO `wordcount` VALUES ('256', '2016-06-17 10:58:25', 'old', '1');
INSERT INTO `wordcount` VALUES ('257', '2016-06-17 10:58:30', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('258', '2016-06-17 10:58:30', 'over', '1');
INSERT INTO `wordcount` VALUES ('259', '2016-06-17 10:58:30', 'old', '1');
INSERT INTO `wordcount` VALUES ('260', '2016-06-17 10:58:35', 'wowan', '1');
INSERT INTO `wordcount` VALUES ('261', '2016-06-17 10:58:35', 'over', '1');
INSERT INTO `wordcount` VALUES ('262', '2016-06-17 10:58:35', 'old', '1');
INSERT INTO `wordcount` VALUES ('263', '2016-06-17 10:58:40', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('264', '2016-06-17 10:58:40', 'over', '2');
INSERT INTO `wordcount` VALUES ('265', '2016-06-17 10:58:40', 'old', '2');
INSERT INTO `wordcount` VALUES ('266', '2016-06-17 10:58:45', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('267', '2016-06-17 10:58:45', 'over', '2');
INSERT INTO `wordcount` VALUES ('268', '2016-06-17 10:58:45', 'old', '2');
INSERT INTO `wordcount` VALUES ('269', '2016-06-17 10:58:50', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('270', '2016-06-17 10:58:50', 'over', '2');
INSERT INTO `wordcount` VALUES ('271', '2016-06-17 10:58:50', 'old', '2');
INSERT INTO `wordcount` VALUES ('272', '2016-06-17 10:58:55', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('273', '2016-06-17 10:58:55', 'over', '2');
INSERT INTO `wordcount` VALUES ('274', '2016-06-17 10:58:55', 'old', '2');
INSERT INTO `wordcount` VALUES ('275', '2016-06-17 10:59:00', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('276', '2016-06-17 10:59:00', 'over', '2');
INSERT INTO `wordcount` VALUES ('277', '2016-06-17 10:59:00', 'old', '2');
INSERT INTO `wordcount` VALUES ('278', '2016-06-17 10:59:05', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('279', '2016-06-17 10:59:05', 'over', '2');
INSERT INTO `wordcount` VALUES ('280', '2016-06-17 10:59:05', 'old', '2');
INSERT INTO `wordcount` VALUES ('281', '2016-06-17 10:59:10', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('282', '2016-06-17 10:59:10', 'over', '2');
INSERT INTO `wordcount` VALUES ('283', '2016-06-17 10:59:10', 'old', '2');
INSERT INTO `wordcount` VALUES ('284', '2016-06-17 10:59:15', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('285', '2016-06-17 10:59:15', 'over', '2');
INSERT INTO `wordcount` VALUES ('286', '2016-06-17 10:59:15', 'old', '2');
INSERT INTO `wordcount` VALUES ('287', '2016-06-17 10:59:20', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('288', '2016-06-17 10:59:20', 'over', '2');
INSERT INTO `wordcount` VALUES ('289', '2016-06-17 10:59:20', 'old', '2');
INSERT INTO `wordcount` VALUES ('290', '2016-06-17 10:59:25', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('291', '2016-06-17 10:59:25', 'over', '2');
INSERT INTO `wordcount` VALUES ('292', '2016-06-17 10:59:25', 'old', '2');
INSERT INTO `wordcount` VALUES ('293', '2016-06-17 10:59:30', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('294', '2016-06-17 10:59:30', 'over', '2');
INSERT INTO `wordcount` VALUES ('295', '2016-06-17 10:59:30', 'old', '2');
INSERT INTO `wordcount` VALUES ('296', '2016-06-17 10:59:35', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('297', '2016-06-17 10:59:35', 'over', '2');
INSERT INTO `wordcount` VALUES ('298', '2016-06-17 10:59:35', 'old', '2');
INSERT INTO `wordcount` VALUES ('299', '2016-06-17 10:59:40', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('300', '2016-06-17 10:59:40', 'over', '2');
INSERT INTO `wordcount` VALUES ('301', '2016-06-17 10:59:40', 'old', '2');
INSERT INTO `wordcount` VALUES ('302', '2016-06-17 10:59:45', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('303', '2016-06-17 10:59:45', 'over', '2');
INSERT INTO `wordcount` VALUES ('304', '2016-06-17 10:59:45', 'old', '2');
INSERT INTO `wordcount` VALUES ('305', '2016-06-17 10:59:50', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('306', '2016-06-17 10:59:50', 'over', '2');
INSERT INTO `wordcount` VALUES ('307', '2016-06-17 10:59:50', 'old', '2');
INSERT INTO `wordcount` VALUES ('308', '2016-06-17 10:59:55', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('309', '2016-06-17 10:59:55', 'over', '2');
INSERT INTO `wordcount` VALUES ('310', '2016-06-17 10:59:55', 'old', '2');
INSERT INTO `wordcount` VALUES ('311', '2016-06-17 11:00:00', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('312', '2016-06-17 11:00:00', 'over', '2');
INSERT INTO `wordcount` VALUES ('313', '2016-06-17 11:00:00', 'old', '2');
INSERT INTO `wordcount` VALUES ('314', '2016-06-17 11:00:05', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('315', '2016-06-17 11:00:05', 'over', '2');
INSERT INTO `wordcount` VALUES ('316', '2016-06-17 11:00:05', 'old', '2');
INSERT INTO `wordcount` VALUES ('317', '2016-06-17 11:00:10', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('318', '2016-06-17 11:00:10', 'over', '2');
INSERT INTO `wordcount` VALUES ('319', '2016-06-17 11:00:10', 'old', '2');
INSERT INTO `wordcount` VALUES ('320', '2016-06-17 11:00:15', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('321', '2016-06-17 11:00:15', 'over', '2');
INSERT INTO `wordcount` VALUES ('322', '2016-06-17 11:00:15', 'old', '2');
INSERT INTO `wordcount` VALUES ('323', '2016-06-17 11:00:20', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('324', '2016-06-17 11:00:20', 'over', '2');
INSERT INTO `wordcount` VALUES ('325', '2016-06-17 11:00:20', 'old', '2');
INSERT INTO `wordcount` VALUES ('326', '2016-06-17 11:00:25', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('327', '2016-06-17 11:00:25', 'over', '2');
INSERT INTO `wordcount` VALUES ('328', '2016-06-17 11:00:25', 'old', '2');
INSERT INTO `wordcount` VALUES ('329', '2016-06-17 11:00:30', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('330', '2016-06-17 11:00:30', 'over', '2');
INSERT INTO `wordcount` VALUES ('331', '2016-06-17 11:00:30', 'old', '2');
INSERT INTO `wordcount` VALUES ('332', '2016-06-17 11:00:35', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('333', '2016-06-17 11:00:35', 'over', '2');
INSERT INTO `wordcount` VALUES ('334', '2016-06-17 11:00:35', 'old', '2');
INSERT INTO `wordcount` VALUES ('335', '2016-06-17 11:00:40', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('336', '2016-06-17 11:00:40', 'over', '2');
INSERT INTO `wordcount` VALUES ('337', '2016-06-17 11:00:40', 'old', '2');
INSERT INTO `wordcount` VALUES ('338', '2016-06-17 11:00:45', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('339', '2016-06-17 11:00:45', 'over', '2');
INSERT INTO `wordcount` VALUES ('340', '2016-06-17 11:00:45', 'old', '2');
INSERT INTO `wordcount` VALUES ('341', '2016-06-17 11:00:50', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('342', '2016-06-17 11:00:50', 'over', '2');
INSERT INTO `wordcount` VALUES ('343', '2016-06-17 11:00:50', 'old', '2');
INSERT INTO `wordcount` VALUES ('344', '2016-06-17 11:00:55', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('345', '2016-06-17 11:00:55', 'over', '2');
INSERT INTO `wordcount` VALUES ('346', '2016-06-17 11:00:55', 'old', '2');
INSERT INTO `wordcount` VALUES ('347', '2016-06-17 11:01:00', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('348', '2016-06-17 11:01:00', 'over', '2');
INSERT INTO `wordcount` VALUES ('349', '2016-06-17 11:01:00', 'old', '2');
INSERT INTO `wordcount` VALUES ('350', '2016-06-17 11:01:05', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('351', '2016-06-17 11:01:05', 'over', '2');
INSERT INTO `wordcount` VALUES ('352', '2016-06-17 11:01:05', 'old', '2');
INSERT INTO `wordcount` VALUES ('353', '2016-06-17 11:01:10', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('354', '2016-06-17 11:01:10', 'over', '2');
INSERT INTO `wordcount` VALUES ('355', '2016-06-17 11:01:10', 'old', '2');
INSERT INTO `wordcount` VALUES ('356', '2016-06-17 11:01:15', 'wowan', '2');
INSERT INTO `wordcount` VALUES ('357', '2016-06-17 11:01:15', 'over', '2');
INSERT INTO `wordcount` VALUES ('358', '2016-06-17 11:01:15', 'old', '2');
INSERT INTO `wordcount` VALUES ('359', '2016-07-25 15:56:40', 'kill', '1');
INSERT INTO `wordcount` VALUES ('360', '2016-07-25 15:56:40', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('361', '2016-07-25 15:56:40', 'people', '1');
INSERT INTO `wordcount` VALUES ('362', '2016-07-25 15:56:45', 'kill', '1');
INSERT INTO `wordcount` VALUES ('363', '2016-07-25 15:56:45', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('364', '2016-07-25 15:56:45', 'people', '1');
INSERT INTO `wordcount` VALUES ('365', '2016-07-25 15:56:50', 'kill', '1');
INSERT INTO `wordcount` VALUES ('366', '2016-07-25 15:56:50', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('367', '2016-07-25 15:56:50', 'people', '1');
INSERT INTO `wordcount` VALUES ('368', '2016-07-25 15:56:55', 'kill', '1');
INSERT INTO `wordcount` VALUES ('369', '2016-07-25 15:56:55', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('370', '2016-07-25 15:56:55', 'people', '1');
INSERT INTO `wordcount` VALUES ('371', '2016-07-25 15:57:00', 'kill', '1');
INSERT INTO `wordcount` VALUES ('372', '2016-07-25 15:57:00', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('373', '2016-07-25 15:57:00', 'people', '1');
INSERT INTO `wordcount` VALUES ('374', '2016-07-25 15:57:05', 'kill', '1');
INSERT INTO `wordcount` VALUES ('375', '2016-07-25 15:57:05', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('376', '2016-07-25 15:57:05', 'people', '1');
INSERT INTO `wordcount` VALUES ('377', '2016-07-25 15:57:10', 'kill', '2');
INSERT INTO `wordcount` VALUES ('378', '2016-07-25 15:57:10', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('379', '2016-07-25 15:57:10', 'people', '1');
INSERT INTO `wordcount` VALUES ('380', '2016-07-25 15:57:10', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('381', '2016-07-25 15:57:15', 'kill', '2');
INSERT INTO `wordcount` VALUES ('382', '2016-07-25 15:57:15', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('383', '2016-07-25 15:57:15', 'people', '1');
INSERT INTO `wordcount` VALUES ('384', '2016-07-25 15:57:15', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('385', '2016-07-25 15:57:20', 'kill', '2');
INSERT INTO `wordcount` VALUES ('386', '2016-07-25 15:57:20', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('387', '2016-07-25 15:57:20', 'people', '1');
INSERT INTO `wordcount` VALUES ('388', '2016-07-25 15:57:20', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('389', '2016-07-25 15:57:25', 'kill', '2');
INSERT INTO `wordcount` VALUES ('390', '2016-07-25 15:57:25', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('391', '2016-07-25 15:57:25', 'people', '1');
INSERT INTO `wordcount` VALUES ('392', '2016-07-25 15:57:25', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('393', '2016-07-25 15:57:30', 'kill', '2');
INSERT INTO `wordcount` VALUES ('394', '2016-07-25 15:57:30', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('395', '2016-07-25 15:57:30', 'people', '1');
INSERT INTO `wordcount` VALUES ('396', '2016-07-25 15:57:30', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('397', '2016-07-25 15:57:35', 'kill', '2');
INSERT INTO `wordcount` VALUES ('398', '2016-07-25 15:57:35', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('399', '2016-07-25 15:57:35', 'people', '1');
INSERT INTO `wordcount` VALUES ('400', '2016-07-25 15:57:35', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('401', '2016-07-25 15:57:40', 'kill', '2');
INSERT INTO `wordcount` VALUES ('402', '2016-07-25 15:57:40', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('403', '2016-07-25 15:57:40', 'people', '1');
INSERT INTO `wordcount` VALUES ('404', '2016-07-25 15:57:40', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('405', '2016-07-25 15:57:45', 'kill', '2');
INSERT INTO `wordcount` VALUES ('406', '2016-07-25 15:57:45', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('407', '2016-07-25 15:57:45', 'people', '1');
INSERT INTO `wordcount` VALUES ('408', '2016-07-25 15:57:45', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('409', '2016-07-25 15:57:50', 'kill', '2');
INSERT INTO `wordcount` VALUES ('410', '2016-07-25 15:57:50', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('411', '2016-07-25 15:57:50', 'people', '1');
INSERT INTO `wordcount` VALUES ('412', '2016-07-25 15:57:50', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('413', '2016-07-25 15:57:55', 'kill', '2');
INSERT INTO `wordcount` VALUES ('414', '2016-07-25 15:57:55', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('415', '2016-07-25 15:57:55', 'people', '1');
INSERT INTO `wordcount` VALUES ('416', '2016-07-25 15:57:55', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('417', '2016-07-25 15:58:00', 'kill', '2');
INSERT INTO `wordcount` VALUES ('418', '2016-07-25 15:58:00', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('419', '2016-07-25 15:58:00', 'people', '1');
INSERT INTO `wordcount` VALUES ('420', '2016-07-25 15:58:00', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('421', '2016-07-25 15:58:05', 'kill', '2');
INSERT INTO `wordcount` VALUES ('422', '2016-07-25 15:58:05', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('423', '2016-07-25 15:58:05', 'people', '1');
INSERT INTO `wordcount` VALUES ('424', '2016-07-25 15:58:05', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('425', '2016-07-25 15:58:10', 'kill', '2');
INSERT INTO `wordcount` VALUES ('426', '2016-07-25 15:58:10', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('427', '2016-07-25 15:58:10', 'people', '1');
INSERT INTO `wordcount` VALUES ('428', '2016-07-25 15:58:10', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('429', '2016-07-25 15:58:15', 'kill', '2');
INSERT INTO `wordcount` VALUES ('430', '2016-07-25 15:58:15', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('431', '2016-07-25 15:58:15', 'people', '1');
INSERT INTO `wordcount` VALUES ('432', '2016-07-25 15:58:15', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('433', '2016-07-25 15:58:20', 'kill', '2');
INSERT INTO `wordcount` VALUES ('434', '2016-07-25 15:58:20', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('435', '2016-07-25 15:58:20', 'people', '1');
INSERT INTO `wordcount` VALUES ('436', '2016-07-25 15:58:20', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('437', '2016-07-25 15:58:25', 'kill', '2');
INSERT INTO `wordcount` VALUES ('438', '2016-07-25 15:58:25', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('439', '2016-07-25 15:58:25', 'people', '1');
INSERT INTO `wordcount` VALUES ('440', '2016-07-25 15:58:25', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('441', '2016-07-25 15:58:30', 'kill', '2');
INSERT INTO `wordcount` VALUES ('442', '2016-07-25 15:58:30', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('443', '2016-07-25 15:58:30', 'people', '1');
INSERT INTO `wordcount` VALUES ('444', '2016-07-25 15:58:30', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('445', '2016-07-25 15:58:35', 'kill', '2');
INSERT INTO `wordcount` VALUES ('446', '2016-07-25 15:58:35', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('447', '2016-07-25 15:58:35', 'people', '1');
INSERT INTO `wordcount` VALUES ('448', '2016-07-25 15:58:35', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('449', '2016-07-25 15:58:40', 'kill', '2');
INSERT INTO `wordcount` VALUES ('450', '2016-07-25 15:58:40', 'tiger', '2');
INSERT INTO `wordcount` VALUES ('451', '2016-07-25 15:58:40', 'people', '1');
INSERT INTO `wordcount` VALUES ('452', '2016-07-25 15:58:40', 'lilei', '1');
INSERT INTO `wordcount` VALUES ('453', '2016-07-25 16:06:35', '[A', '1');
INSERT INTO `wordcount` VALUES ('454', '2016-07-25 16:06:40', '[A', '2');
INSERT INTO `wordcount` VALUES ('455', '2016-07-25 16:06:45', '[A', '2');
INSERT INTO `wordcount` VALUES ('456', '2016-07-25 16:06:50', '[A', '2');
INSERT INTO `wordcount` VALUES ('457', '2016-07-25 16:06:55', '[A', '2');
INSERT INTO `wordcount` VALUES ('458', '2016-07-25 16:07:00', '[A', '2');
INSERT INTO `wordcount` VALUES ('459', '2016-07-25 16:07:05', '[A', '2');
INSERT INTO `wordcount` VALUES ('460', '2016-07-25 16:07:10', '[A', '2');
INSERT INTO `wordcount` VALUES ('461', '2016-07-25 16:07:15', '[A', '2');
INSERT INTO `wordcount` VALUES ('462', '2016-07-25 16:07:20', '[A', '2');
INSERT INTO `wordcount` VALUES ('463', '2016-07-25 16:07:25', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('464', '2016-07-25 16:07:25', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('465', '2016-07-25 16:07:25', 'i', '1');
INSERT INTO `wordcount` VALUES ('466', '2016-07-25 16:07:25', '[A', '2');
INSERT INTO `wordcount` VALUES ('467', '2016-07-25 16:07:30', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('468', '2016-07-25 16:07:30', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('469', '2016-07-25 16:07:30', 'i', '1');
INSERT INTO `wordcount` VALUES ('470', '2016-07-25 16:07:30', '[A', '2');
INSERT INTO `wordcount` VALUES ('471', '2016-07-25 16:07:35', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('472', '2016-07-25 16:07:35', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('473', '2016-07-25 16:07:35', 'i', '1');
INSERT INTO `wordcount` VALUES ('474', '2016-07-25 16:07:35', '[A', '2');
INSERT INTO `wordcount` VALUES ('475', '2016-07-25 16:07:40', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('476', '2016-07-25 16:07:40', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('477', '2016-07-25 16:07:40', 'i', '1');
INSERT INTO `wordcount` VALUES ('478', '2016-07-25 16:07:40', '[A', '2');
INSERT INTO `wordcount` VALUES ('479', '2016-07-25 16:07:45', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('480', '2016-07-25 16:07:45', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('481', '2016-07-25 16:07:45', 'i', '1');
INSERT INTO `wordcount` VALUES ('482', '2016-07-25 16:07:45', '[A', '2');
INSERT INTO `wordcount` VALUES ('483', '2016-07-25 16:07:50', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('484', '2016-07-25 16:07:50', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('485', '2016-07-25 16:07:50', 'i', '1');
INSERT INTO `wordcount` VALUES ('486', '2016-07-25 16:07:50', '[A', '2');
INSERT INTO `wordcount` VALUES ('487', '2016-07-25 16:07:55', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('488', '2016-07-25 16:07:55', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('489', '2016-07-25 16:07:55', 'i', '1');
INSERT INTO `wordcount` VALUES ('490', '2016-07-25 16:07:55', '[A', '2');
INSERT INTO `wordcount` VALUES ('491', '2016-07-25 16:08:00', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('492', '2016-07-25 16:08:00', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('493', '2016-07-25 16:08:00', 'i', '1');
INSERT INTO `wordcount` VALUES ('494', '2016-07-25 16:08:00', '[A', '2');
INSERT INTO `wordcount` VALUES ('495', '2016-07-25 16:08:05', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('496', '2016-07-25 16:08:05', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('497', '2016-07-25 16:08:05', 'i', '1');
INSERT INTO `wordcount` VALUES ('498', '2016-07-25 16:08:05', '[A', '2');
INSERT INTO `wordcount` VALUES ('499', '2016-07-25 16:08:10', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('500', '2016-07-25 16:08:10', 'kill', '1');
INSERT INTO `wordcount` VALUES ('501', '2016-07-25 16:08:10', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('502', '2016-07-25 16:08:10', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('503', '2016-07-25 16:08:10', 'people', '1');
INSERT INTO `wordcount` VALUES ('504', '2016-07-25 16:08:10', 'i', '1');
INSERT INTO `wordcount` VALUES ('505', '2016-07-25 16:08:10', '[A', '2');
INSERT INTO `wordcount` VALUES ('506', '2016-07-25 16:08:15', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('507', '2016-07-25 16:08:15', 'kill', '1');
INSERT INTO `wordcount` VALUES ('508', '2016-07-25 16:08:15', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('509', '2016-07-25 16:08:15', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('510', '2016-07-25 16:08:15', 'people', '1');
INSERT INTO `wordcount` VALUES ('511', '2016-07-25 16:08:15', 'i', '1');
INSERT INTO `wordcount` VALUES ('512', '2016-07-25 16:08:15', '[A', '2');
INSERT INTO `wordcount` VALUES ('513', '2016-07-25 16:08:20', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('514', '2016-07-25 16:08:20', 'kill', '1');
INSERT INTO `wordcount` VALUES ('515', '2016-07-25 16:08:20', 'lvoe', '1');
INSERT INTO `wordcount` VALUES ('516', '2016-07-25 16:08:20', 'tiger', '1');
INSERT INTO `wordcount` VALUES ('517', '2016-07-25 16:08:20', 'people', '1');
INSERT INTO `wordcount` VALUES ('518', '2016-07-25 16:08:20', 'i', '1');
INSERT INTO `wordcount` VALUES ('519', '2016-07-25 16:08:20', '[A', '2');
INSERT INTO `wordcount` VALUES ('520', '2016-08-10 21:29:51', 'tangyan', '1');
INSERT INTO `wordcount` VALUES ('521', '2016-08-10 21:29:51', '101', '1');
INSERT INTO `wordcount` VALUES ('522', '2016-08-10 21:29:51', '98', '1');
INSERT INTO `wordcount` VALUES ('523', '2016-08-10 21:29:51', 'yasaka', '1');
INSERT INTO `wordcount` VALUES ('524', '2016-08-10 21:29:51', '100', '3');
INSERT INTO `wordcount` VALUES ('525', '2016-08-10 21:29:51', 'xuruyun', '1');
INSERT INTO `wordcount` VALUES ('526', '2016-08-10 21:29:51', 'liangyongqi', '1');
INSERT INTO `wordcount` VALUES ('527', '2016-08-10 21:29:51', 'april', '1');
INSERT INTO `wordcount` VALUES ('528', '2016-08-10 21:29:51', '', '5');
INSERT INTO `wordcount` VALUES ('529', '2016-08-10 21:29:51', 'annie', '1');
INSERT INTO `wordcount` VALUES ('530', '2016-08-10 21:29:51', '111', '1');
INSERT INTO `wordcount` VALUES ('531', '2016-08-10 21:29:51', '99', '4');
INSERT INTO `wordcount` VALUES ('532', '2016-08-10 21:29:51', '1', '1');
INSERT INTO `wordcount` VALUES ('533', '2016-08-10 21:29:51', '10', '3');
INSERT INTO `wordcount` VALUES ('534', '2016-08-10 21:29:51', 'wangfei', '1');
