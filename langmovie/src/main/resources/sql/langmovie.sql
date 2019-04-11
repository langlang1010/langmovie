/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : langmovie

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-04-11 15:45:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cinema`
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `pk_cinemaid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cinema_name` char(80) NOT NULL,
  `city` char(60) DEFAULT NULL,
  `province` char(60) DEFAULT NULL,
  `country` char(60) DEFAULT NULL,
  `location` varchar(80) DEFAULT NULL,
  `money` float NOT NULL DEFAULT '0',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_cinemaid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES ('1', '第一影院', null, null, null, null, '0', '2019-04-11 07:27:33', '2019-04-11 08:01:18');
INSERT INTO `cinema` VALUES ('2', '第一影院', null, null, null, null, '0', '2019-04-11 08:09:39', '2019-04-11 08:09:39');
INSERT INTO `cinema` VALUES ('3', '第一影院', null, null, null, null, '0', '2019-04-11 08:09:54', '2019-04-11 08:09:54');
INSERT INTO `cinema` VALUES ('4', '第一影院', null, null, null, null, '0', '2019-04-11 08:10:09', '2019-04-11 08:10:09');

-- ----------------------------
-- Table structure for `form`
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form` (
  `pk_formid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_screen` bigint(20) unsigned NOT NULL,
  `fk_user` bigint(20) unsigned NOT NULL,
  `seat_x` smallint(5) unsigned NOT NULL,
  `seat_y` smallint(5) unsigned NOT NULL,
  `code` char(50) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_formid`),
  KEY `fk_screen` (`fk_screen`),
  KEY `fk_user` (`fk_user`),
  CONSTRAINT `form_ibfk_1` FOREIGN KEY (`fk_screen`) REFERENCES `screen` (`pk_screenid`),
  CONSTRAINT `form_ibfk_2` FOREIGN KEY (`fk_user`) REFERENCES `user` (`pk_userid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of form
-- ----------------------------
INSERT INTO `form` VALUES ('2', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:12:54');
INSERT INTO `form` VALUES ('3', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:14:17', '2019-04-11 10:14:17');
INSERT INTO `form` VALUES ('4', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:14:17', '2019-04-11 10:14:17');
INSERT INTO `form` VALUES ('6', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:14:17', '2019-04-11 10:14:17');
INSERT INTO `form` VALUES ('7', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:14:17', '2019-04-11 10:14:17');
INSERT INTO `form` VALUES ('8', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:14:17', '2019-04-11 10:14:17');
INSERT INTO `form` VALUES ('9', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:28', '2019-04-11 10:36:28');
INSERT INTO `form` VALUES ('10', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:29', '2019-04-11 10:36:29');
INSERT INTO `form` VALUES ('11', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:29', '2019-04-11 10:36:29');
INSERT INTO `form` VALUES ('12', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:29', '2019-04-11 10:36:29');
INSERT INTO `form` VALUES ('13', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:29', '2019-04-11 10:36:29');
INSERT INTO `form` VALUES ('14', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:29', '2019-04-11 10:36:29');
INSERT INTO `form` VALUES ('15', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:47', '2019-04-11 10:36:47');
INSERT INTO `form` VALUES ('16', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:47', '2019-04-11 10:36:47');
INSERT INTO `form` VALUES ('17', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:47', '2019-04-11 10:36:47');
INSERT INTO `form` VALUES ('18', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:47', '2019-04-11 10:36:47');
INSERT INTO `form` VALUES ('19', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:47', '2019-04-11 10:36:47');
INSERT INTO `form` VALUES ('20', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:36:47', '2019-04-11 10:36:47');
INSERT INTO `form` VALUES ('21', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:37:57');
INSERT INTO `form` VALUES ('22', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:37:57');
INSERT INTO `form` VALUES ('23', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:37:57');
INSERT INTO `form` VALUES ('24', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:37:57');
INSERT INTO `form` VALUES ('25', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:37:57');
INSERT INTO `form` VALUES ('26', '2', '1', '1', '1', 'dgdgdhhh', '2019-04-11 10:37:57', '2019-04-11 10:37:57');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `fk_user` bigint(20) unsigned NOT NULL,
  `fk_cinema` bigint(20) unsigned NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`fk_user`,`fk_cinema`),
  KEY `fk_cinema` (`fk_cinema`),
  CONSTRAINT `manager_ibfk_2` FOREIGN KEY (`fk_cinema`) REFERENCES `cinema` (`pk_cinemaid`),
  CONSTRAINT `manager_ibfk_3` FOREIGN KEY (`fk_user`) REFERENCES `user` (`pk_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '1', '2019-04-11 15:22:33', '2019-04-11 15:22:33');
INSERT INTO `manager` VALUES ('1', '2', '2019-04-11 11:38:08', '2019-04-11 11:38:13');
INSERT INTO `manager` VALUES ('1', '3', '2019-04-11 12:11:52', '2019-04-11 12:11:54');
INSERT INTO `manager` VALUES ('3', '1', '2019-04-11 12:12:07', '2019-04-11 12:12:09');
INSERT INTO `manager` VALUES ('5', '1', '2019-04-11 12:20:02', '2019-04-11 12:20:05');
INSERT INTO `manager` VALUES ('6', '1', '2019-04-11 12:20:26', '2019-04-11 12:20:29');

-- ----------------------------
-- Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `pk_movieid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `movie_name` char(80) NOT NULL,
  `movie_release` datetime DEFAULT NULL,
  `introduction` varchar(200) DEFAULT NULL,
  `movie_type` char(20) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '三个和尚', null, null, null, '2019-04-10 21:30:16', '2019-04-10 21:30:16');
INSERT INTO `movie` VALUES ('2', '三个和尚', null, null, null, '2019-04-10 21:30:35', '2019-04-10 21:30:35');
INSERT INTO `movie` VALUES ('3', '三个和尚', null, null, null, '2019-04-10 21:32:43', '2019-04-10 21:32:43');
INSERT INTO `movie` VALUES ('4', '三个和尚', null, null, null, '2019-04-10 21:33:09', '2019-04-10 21:33:09');
INSERT INTO `movie` VALUES ('5', '三个和尚', null, null, null, '2019-04-10 21:33:37', '2019-04-10 21:33:37');
INSERT INTO `movie` VALUES ('6', '三个和尚', null, null, null, '2019-04-11 07:11:35', '2019-04-11 07:11:35');

-- ----------------------------
-- Table structure for `movie_actor`
-- ----------------------------
DROP TABLE IF EXISTS `movie_actor`;
CREATE TABLE `movie_actor` (
  `pk_actorid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_movieid` bigint(20) unsigned NOT NULL,
  `actor_url` varchar(150) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_actorid`),
  KEY `movie_actor_ibfk_1` (`fk_movieid`),
  CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`fk_movieid`) REFERENCES `movie` (`pk_movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_actor
-- ----------------------------
INSERT INTO `movie_actor` VALUES ('10', '1', 'sgg', '2019-04-11 15:21:51', '2019-04-11 15:21:51');
INSERT INTO `movie_actor` VALUES ('11', '1', 'sgg', '2019-04-11 15:21:52', '2019-04-11 15:21:52');
INSERT INTO `movie_actor` VALUES ('12', '1', 'sgg', '2019-04-11 15:21:52', '2019-04-11 15:21:52');
INSERT INTO `movie_actor` VALUES ('13', '1', 'sgg', '2019-04-11 15:21:52', '2019-04-11 15:21:52');
INSERT INTO `movie_actor` VALUES ('14', '1', 'sgg', '2019-04-11 15:21:52', '2019-04-11 15:21:52');
INSERT INTO `movie_actor` VALUES ('15', '1', 'sgg', '2019-04-11 15:21:52', '2019-04-11 15:21:52');

-- ----------------------------
-- Table structure for `movie_post`
-- ----------------------------
DROP TABLE IF EXISTS `movie_post`;
CREATE TABLE `movie_post` (
  `pk_postid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_movieid` bigint(20) unsigned NOT NULL,
  `post_url` varchar(200) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_postid`),
  KEY `fk_movieid` (`fk_movieid`),
  CONSTRAINT `movie_post_ibfk_1` FOREIGN KEY (`fk_movieid`) REFERENCES `movie` (`pk_movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_post
-- ----------------------------
INSERT INTO `movie_post` VALUES ('9', '2', 'dd', '2019-04-11 13:38:49', '2019-04-11 13:38:49');
INSERT INTO `movie_post` VALUES ('10', '1', 'dd', '2019-04-11 13:38:49', '2019-04-11 13:38:49');
INSERT INTO `movie_post` VALUES ('11', '1', 'dd', '2019-04-11 13:38:49', '2019-04-11 13:38:49');
INSERT INTO `movie_post` VALUES ('12', '1', 'dd', '2019-04-11 13:38:49', '2019-04-11 13:38:49');
INSERT INTO `movie_post` VALUES ('13', '1', 'dd', '2019-04-11 13:38:49', '2019-04-11 13:38:49');
INSERT INTO `movie_post` VALUES ('14', '1', 'dd', '2019-04-11 13:38:49', '2019-04-11 13:38:49');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `pk_roomid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_cinema` bigint(20) unsigned NOT NULL,
  `room_name` char(60) NOT NULL,
  `room_row` smallint(5) unsigned NOT NULL,
  `room_column` smallint(5) unsigned NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_roomid`),
  KEY `fk_cinema` (`fk_cinema`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`fk_cinema`) REFERENCES `cinema` (`pk_cinemaid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '1', '2', '10', '10', '2019-04-11 08:39:36', '2019-04-11 08:39:36');
INSERT INTO `room` VALUES ('2', '1', '2', '10', '10', '2019-04-11 09:11:42', '2019-04-11 09:11:42');

-- ----------------------------
-- Table structure for `screen`
-- ----------------------------
DROP TABLE IF EXISTS `screen`;
CREATE TABLE `screen` (
  `pk_screenid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_room` bigint(20) unsigned NOT NULL,
  `fk_movie` bigint(20) unsigned NOT NULL,
  `price` float NOT NULL,
  `begin_time` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`pk_screenid`),
  KEY `fk_room` (`fk_room`),
  KEY `fk_movie` (`fk_movie`),
  CONSTRAINT `screen_ibfk_1` FOREIGN KEY (`fk_room`) REFERENCES `room` (`pk_roomid`),
  CONSTRAINT `screen_ibfk_2` FOREIGN KEY (`fk_movie`) REFERENCES `movie` (`pk_movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of screen
-- ----------------------------
INSERT INTO `screen` VALUES ('2', '1', '1', '50', '2019-04-11 09:35:16', '2019-04-11 09:35:16', '2019-04-11 09:35:16', '2019-04-11 09:35:16');
INSERT INTO `screen` VALUES ('3', '1', '1', '50', '2019-04-11 09:51:30', '2019-04-11 09:51:30', '2019-04-11 09:51:30', '2019-04-11 09:51:30');
INSERT INTO `screen` VALUES ('4', '1', '1', '50', '2019-04-11 09:52:04', '2019-04-11 09:52:04', '2019-04-11 09:52:04', '2019-04-11 09:52:04');
INSERT INTO `screen` VALUES ('5', '1', '1', '50', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05');
INSERT INTO `screen` VALUES ('6', '1', '1', '50', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05');
INSERT INTO `screen` VALUES ('7', '1', '1', '50', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05');
INSERT INTO `screen` VALUES ('8', '1', '1', '50', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05');
INSERT INTO `screen` VALUES ('9', '1', '1', '50', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05', '2019-04-11 09:52:05');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `pk_userid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` char(50) DEFAULT NULL,
  `password` char(50) DEFAULT NULL,
  `uk_phone` char(15) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `role` char(10) DEFAULT NULL,
  `money` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_userid`),
  UNIQUE KEY `uk_phone` (`uk_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, '4', '2019-04-10 17:31:54', '2019-04-11 07:49:03', null, '95.5');
INSERT INTO `user` VALUES ('3', null, null, '3', '2019-04-10 18:37:23', '2019-04-10 18:37:23', null, '0');
INSERT INTO `user` VALUES ('5', null, null, null, '2019-04-10 18:39:29', '2019-04-10 18:39:29', null, '0');
INSERT INTO `user` VALUES ('6', null, null, null, '2019-04-10 18:40:00', '2019-04-10 18:40:00', null, '0');
INSERT INTO `user` VALUES ('7', null, null, null, '2019-04-10 18:44:44', '2019-04-10 18:44:44', null, '0');
INSERT INTO `user` VALUES ('8', null, null, null, '2019-04-10 18:45:26', '2019-04-10 18:45:26', null, '0');
INSERT INTO `user` VALUES ('9', null, null, null, '2019-04-10 18:47:38', '2019-04-10 18:47:38', null, '0');
INSERT INTO `user` VALUES ('10', null, null, null, '2019-04-10 18:49:33', '2019-04-10 18:49:33', null, '0');
INSERT INTO `user` VALUES ('11', null, null, null, '2019-04-10 18:52:15', '2019-04-10 18:52:15', null, '0');
INSERT INTO `user` VALUES ('12', null, null, null, '2019-04-10 18:54:25', '2019-04-10 18:54:25', null, '0');
INSERT INTO `user` VALUES ('13', null, null, null, '2019-04-10 18:57:34', '2019-04-10 18:57:34', null, '0');
INSERT INTO `user` VALUES ('14', null, null, null, '2019-04-10 18:58:59', '2019-04-10 18:58:59', null, '0');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `pk_userid` bigint(20) unsigned NOT NULL,
  `openid` char(50) DEFAULT NULL,
  `nickname` char(60) DEFAULT NULL,
  `gender` char(10) DEFAULT NULL,
  `city` char(60) DEFAULT NULL,
  `province` char(60) DEFAULT NULL,
  `country` char(60) DEFAULT NULL,
  `avatar_url` char(150) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`pk_userid`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`pk_userid`) REFERENCES `user` (`pk_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('3', null, null, null, null, null, null, null, '2019-04-11 07:53:42', '2019-04-11 07:53:42');
INSERT INTO `user_info` VALUES ('5', null, null, null, null, null, null, null, '2019-04-10 20:28:13', '2019-04-10 20:28:13');
INSERT INTO `user_info` VALUES ('6', null, null, null, null, null, null, null, '2019-04-10 20:28:29', '2019-04-10 20:28:33');
INSERT INTO `user_info` VALUES ('7', null, null, null, null, null, null, null, '2019-04-10 20:28:43', '2019-04-10 20:28:38');
INSERT INTO `user_info` VALUES ('8', null, null, null, null, null, null, null, '2019-04-10 20:28:54', '2019-04-10 20:28:58');
