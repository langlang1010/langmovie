/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : langmovie

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-04-10 20:57:55
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of form
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '三个和尚', null, null, null, '2019-04-10 20:56:47', '2019-04-10 20:56:47');

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
  CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`pk_actorid`) REFERENCES `movie` (`pk_movieid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_actor
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_post
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of screen
-- ----------------------------

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
INSERT INTO `user` VALUES ('1', null, null, null, '2019-04-10 17:31:54', '2019-04-10 19:18:11', null, '98.5');
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
INSERT INTO `user_info` VALUES ('3', null, null, null, null, null, null, null, '2019-04-10 20:27:43', '2019-04-10 20:27:43');
INSERT INTO `user_info` VALUES ('5', null, null, null, null, null, null, null, '2019-04-10 20:28:13', '2019-04-10 20:28:13');
INSERT INTO `user_info` VALUES ('6', null, null, null, null, null, null, null, '2019-04-10 20:28:29', '2019-04-10 20:28:33');
INSERT INTO `user_info` VALUES ('7', null, null, null, null, null, null, null, '2019-04-10 20:28:43', '2019-04-10 20:28:38');
INSERT INTO `user_info` VALUES ('8', null, null, null, null, null, null, null, '2019-04-10 20:28:54', '2019-04-10 20:28:58');
