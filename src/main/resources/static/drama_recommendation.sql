/*
 Navicat Premium Data Transfer

 Source Server         : local2
 Source Server Type    : MySQL
 Source Server Version : 90300 (9.3.0)
 Source Host           : localhost:3306
 Source Schema         : drama_recommendation

 Target Server Type    : MySQL
 Target Server Version : 90300 (9.3.0)
 File Encoding         : 65001

 Date: 24/05/2025 15:23:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `name` varchar(50) NOT NULL COMMENT '管理员账号',
  `password` varchar(64) NOT NULL COMMENT '管理员密码（明文或加密，根据代码）',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`name`, `password`) VALUES ('admin', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `likeId` int NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `userId` int NOT NULL COMMENT '用户id',
  `songId` int NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`likeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏表';

-- ----------------------------
-- Records of collect
-- ----------------------------
BEGIN;
INSERT INTO `collect` (`likeId`, `userId`, `songId`) VALUES (1, 3, 2);
INSERT INTO `collect` (`likeId`, `userId`, `songId`) VALUES (2, 3, 1);
INSERT INTO `collect` (`likeId`, `userId`, `songId`) VALUES (3, 3, 20);
INSERT INTO `collect` (`likeId`, `userId`, `songId`) VALUES (4, 3, 59);
INSERT INTO `collect` (`likeId`, `userId`, `songId`) VALUES (5, 3, 10);
COMMIT;

-- ----------------------------
-- Table structure for Download
-- ----------------------------
DROP TABLE IF EXISTS `Download`;
CREATE TABLE `Download` (
  `downloadId` int NOT NULL AUTO_INCREMENT COMMENT '下载id',
  `userId` int NOT NULL COMMENT '用户id',
  `songId` int NOT NULL COMMENT '歌曲id',
  `downloadTime` datetime NOT NULL COMMENT '下载时间',
  PRIMARY KEY (`downloadId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='下载记录表';

-- ----------------------------
-- Records of Download
-- ----------------------------
BEGIN;
INSERT INTO `Download` (`downloadId`, `userId`, `songId`, `downloadTime`) VALUES (1, 3, 2, '2025-05-24 01:10:34');
INSERT INTO `Download` (`downloadId`, `userId`, `songId`, `downloadTime`) VALUES (2, 3, 2, '2025-05-24 01:10:36');
INSERT INTO `Download` (`downloadId`, `userId`, `songId`, `downloadTime`) VALUES (3, 3, 2, '2025-05-24 01:10:41');
INSERT INTO `Download` (`downloadId`, `userId`, `songId`, `downloadTime`) VALUES (4, 3, 2, '2025-05-24 01:13:22');
COMMIT;

-- ----------------------------
-- Table structure for Play
-- ----------------------------
DROP TABLE IF EXISTS `Play`;
CREATE TABLE `Play` (
  `playId` int NOT NULL AUTO_INCREMENT COMMENT '播放id',
  `userId` int NOT NULL COMMENT '用户id',
  `songId` int NOT NULL COMMENT '歌曲id',
  `playTime` datetime NOT NULL COMMENT '播放时间',
  PRIMARY KEY (`playId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='播放记录表';

-- ----------------------------
-- Records of Play
-- ----------------------------
BEGIN;
INSERT INTO `Play` (`playId`, `userId`, `songId`, `playTime`) VALUES (1, 3, 10, '2025-05-24 01:40:29');
INSERT INTO `Play` (`playId`, `userId`, `songId`, `playTime`) VALUES (2, 3, 52, '2025-05-24 01:42:51');
COMMIT;

-- ----------------------------
-- Table structure for Reca
-- ----------------------------
DROP TABLE IF EXISTS `Reca`;
CREATE TABLE `Reca` (
  `recId` int NOT NULL AUTO_INCREMENT COMMENT '推荐id',
  `userId` int NOT NULL COMMENT '用户id',
  `songId` int NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`recId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='推荐A表';

-- ----------------------------
-- Records of Reca
-- ----------------------------
BEGIN;
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (1, 1, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (2, 1, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (3, 3, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (4, 3, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (5, 4, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (6, 4, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (7, 5, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (8, 5, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (9, 6, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (10, 6, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (11, 7, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (12, 7, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (13, 8, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (14, 8, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (15, 9, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (16, 9, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (17, 10, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (18, 10, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (19, 11, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (20, 11, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (21, 12, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (22, 12, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (23, 13, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (24, 13, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (25, 14, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (26, 14, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (27, 15, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (28, 15, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (29, 16, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (30, 16, 2);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (31, 17, 1);
INSERT INTO `Reca` (`recId`, `userId`, `songId`) VALUES (32, 17, 2);
COMMIT;

-- ----------------------------
-- Table structure for Recb
-- ----------------------------
DROP TABLE IF EXISTS `Recb`;
CREATE TABLE `Recb` (
  `recId` int NOT NULL AUTO_INCREMENT COMMENT '推荐id',
  `userId` int NOT NULL COMMENT '用户id',
  `songId` int NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`recId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='推荐B表';

-- ----------------------------
-- Records of Recb
-- ----------------------------
BEGIN;
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (1, 1, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (2, 1, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (3, 3, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (4, 3, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (5, 4, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (6, 4, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (7, 5, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (8, 5, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (9, 6, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (10, 6, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (11, 7, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (12, 7, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (13, 8, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (14, 8, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (15, 9, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (16, 9, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (17, 10, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (18, 10, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (19, 11, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (20, 11, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (21, 12, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (22, 12, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (23, 13, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (24, 13, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (25, 14, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (26, 14, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (27, 15, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (28, 15, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (29, 16, 1);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (30, 16, 2);
INSERT INTO `Recb` (`recId`, `userId`, `songId`) VALUES (31, 17, 1);
COMMIT;

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `songId` int NOT NULL AUTO_INCREMENT COMMENT '歌曲id',
  `songName` varchar(100) NOT NULL COMMENT '歌曲名称',
  `songAddress` varchar(200) NOT NULL COMMENT '歌曲地址',
  `songCoverAddress` varchar(200) DEFAULT NULL COMMENT '封面地址',
  `songType` varchar(50) NOT NULL COMMENT '歌曲类型',
  `songLength` int DEFAULT '0',
  `songartist` varchar(100) NOT NULL COMMENT '歌曲作者',
  `upTime` datetime NOT NULL COMMENT '上传时间',
  `trendingCoefficient` int DEFAULT '0' COMMENT '热度系数',
  `whetherCollected` tinyint(1) DEFAULT '0' COMMENT '是否已收藏',
  PRIMARY KEY (`songId`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='歌曲表';

-- ----------------------------
-- Records of song
-- ----------------------------
BEGIN;
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (1, '贵妃醉酒', 'images/1748016659303__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '梅兰芳', '2025-05-23 23:51:04', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (2, '霸王别姬', 'images/1748016659303__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '霸王', '2025-05-23 23:58:09', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (3, '空城计', 'images/1748016659303__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '诸葛亮', '2025-05-23 23:59:39', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (4, '穆桂英挂帅', 'images/1748016659303__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '无名', '2025-05-24 00:03:02', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (5, '红灯记', 'images/1748016659303__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '李玉和', '2025-05-24 00:10:59', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (6, '白蛇传', 'images/1748017176007__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748017176008_1748015342834.jpg', 'HY', 0, '无', '2025-05-24 00:19:36', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (10, '你是谁', 'images/1748016659303__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpeg', 'YG', 0, '哈哈', '2025-05-24 00:27:16', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (11, '贵妃醉酒', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpeg', 'HY', 0, '梅兰芳', '2023-01-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (12, '霸王别姬', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '程砚秋', '2023-01-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (13, '红灯记', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpg', 'HY', 0, '尚小云', '2023-01-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (14, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'HY', 0, '梅兰芳', '2023-01-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (15, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpeg', 'HY', 0, '程砚秋', '2023-01-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (16, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'HY', 0, '尚小云', '2023-01-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (17, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'HY', 0, '梅兰芳', '2023-01-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (18, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m1.jpeg', 'HY', 0, '程砚秋', '2023-01-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (19, '梁祝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'MY', 0, '越剧团', '2023-02-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (20, '红楼梦', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m12.jpg', 'MY', 0, '越剧', '2023-02-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (21, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m2.jpeg', 'MY', 0, '越剧名角', '2023-02-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (22, '红灯记', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'MY', 0, '越剧', '2023-02-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (23, '玉堂春', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m8.jpeg', 'MY', 0, '越剧团', '2023-02-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (24, '梁山伯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m1.jpeg', 'MY', 0, '越剧', '2023-02-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (25, '牡丹亭', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'MY', 0, '越剧名角', '2023-02-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (26, '红豆曲', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m5.jpeg', 'MY', 0, '越剧', '2023-02-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (27, '天仙配', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'DZ', 0, '黄梅戏剧团', '2023-03-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (28, '女驸马', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'DZ', 0, '黄梅戏', '2023-03-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (29, '夫妻观灯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpg', 'DZ', 0, '黄梅戏名角', '2023-03-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (30, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'DZ', 0, '黄梅戏', '2023-03-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (31, '春草闯堂', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'DZ', 0, '黄梅戏剧团', '2023-03-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (32, '夫妻观灯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'DZ', 0, '黄梅戏', '2023-03-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (33, '打谷场', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m12.jpg', 'DZ', 0, '黄梅戏', '2023-03-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (34, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m12.jpeg', 'DZ', 0, '黄梅戏名角', '2023-03-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (35, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpg', 'QYY', 0, '豫剧剧团', '2023-04-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (36, '朝阳沟', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpeg', 'QYY', 0, '豫剧', '2023-04-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (37, '花为媒', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m1.jpeg', 'QYY', 0, '豫剧名角', '2023-04-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (38, '杜鹃山', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m5.jpeg', 'QYY', 0, '豫剧', '2023-04-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (39, '赵氏孤儿', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'QYY', 0, '豫剧剧团', '2023-04-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (40, '沙家浜', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m7.jpeg', 'QYY', 0, '豫剧', '2023-04-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (41, '穆桂英挂帅', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'QYY', 0, '豫剧名角', '2023-04-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (42, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpg', 'QYY', 0, '豫剧', '2023-04-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (43, '变脸', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'YG', 0, '川剧团', '2023-05-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (44, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpg', 'YG', 0, '川剧', '2023-05-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (45, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpeg', 'YG', 0, '川剧演员', '2023-05-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (46, '杜鹃山', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m4.jpeg', 'YG', 0, '川剧团', '2023-05-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (47, '霸王别姬', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpg', 'YG', 0, '川剧', '2023-05-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (48, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'YG', 0, '川剧演员', '2023-05-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (49, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpeg', 'YG', 0, '川剧团', '2023-05-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (50, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m1.jpeg', 'YG', 0, '川剧', '2023-05-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (51, '白鹿原', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m4.jpeg', 'SC', 0, '秦腔剧团', '2023-06-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (52, '王宝钏', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'SC', 0, '秦腔', '2023-06-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (53, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpg', 'SC', 0, '秦腔名角', '2023-06-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (54, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m3.jpeg', 'SC', 0, '秦腔', '2023-06-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (55, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m3.jpeg', 'SC', 0, '秦腔剧团', '2023-06-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (56, '挑滑车', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'SC', 0, '秦腔', '2023-06-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (57, '打鼓山', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m2.jpeg', 'SC', 0, '秦腔名角', '2023-06-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (58, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpg', 'SC', 0, '秦腔', '2023-06-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (59, '帝女花', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m8.jpeg', 'JS', 0, '粤剧团', '2023-07-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (60, '牡丹亭', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m2.jpeg', 'JS', 0, '粤剧', '2023-07-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (61, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'JS', 0, '粤剧名角', '2023-07-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (62, '霸王别姬', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'JS', 0, '粤剧', '2023-07-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (63, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpg', 'JS', 0, '粤剧团', '2023-07-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (64, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpeg', 'JS', 0, '粤剧', '2023-07-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (65, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'JS', 0, '粤剧名角', '2023-07-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (66, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'JS', 0, '粤剧', '2023-07-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (67, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m2.jpeg', 'GF', 0, '淮剧团', '2023-08-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (68, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpeg', 'GF', 0, '淮剧', '2023-08-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (69, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpg', 'GF', 0, '淮剧名角', '2023-08-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (70, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'GF', 0, '淮剧', '2023-08-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (71, '红灯记', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpeg', 'GF', 0, '淮剧团', '2023-08-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (72, '春草闯堂', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpg', 'GF', 0, '淮剧', '2023-08-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (73, '夫妻观灯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m3.jpeg', 'GF', 0, '淮剧名角', '2023-08-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (74, '挑滑车', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m7.jpeg', 'GF', 0, '淮剧', '2023-08-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (75, '花为媒', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'RY', 0, '评剧团', '2023-09-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (76, '红灯记', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'RY', 0, '评剧', '2023-09-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (77, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpg', 'RY', 0, '评剧名角', '2023-09-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (78, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpeg', 'RY', 0, '评剧', '2023-09-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (79, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m7.jpeg', 'RY', 0, '评剧团', '2023-09-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (80, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'RY', 0, '评剧', '2023-09-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (81, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'RY', 0, '评剧名角', '2023-09-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (82, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'RY', 0, '评剧', '2023-09-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (83, '三堂会审', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpg', 'OM', 0, '莆仙戏团', '2023-10-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (84, '穆桂英挂帅', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m4.jpeg', 'OM', 0, '莆仙戏', '2023-10-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (85, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'OM', 0, '莆仙戏名角', '2023-10-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (86, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'OM', 0, '莆仙戏', '2023-10-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (87, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'OM', 0, '莆仙戏团', '2023-10-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (88, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpg', 'OM', 0, '莆仙戏', '2023-10-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (89, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpeg', 'OM', 0, '莆仙戏名角', '2023-10-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (90, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m5.jpeg', 'OM', 0, '莆仙戏', '2023-10-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (91, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'LD', 0, '但角戏团', '2023-11-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (92, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpg', 'LD', 0, '但角戏', '2023-11-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (93, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m12.jpeg', 'LD', 0, '但角戏名角', '2023-11-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (94, '红灯记', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpeg', 'LD', 0, '但角戏团', '2023-11-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (95, '挑滑车', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m6.jpeg', 'LD', 0, '但角戏', '2023-11-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (96, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'LD', 0, '但角戏名角', '2023-11-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (97, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'LD', 0, '但角戏', '2023-11-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (98, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpeg', 'LD', 0, '但角戏团', '2023-11-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (99, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'GZ', 0, '豫东大鼓团', '2023-12-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (100, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m9.jpeg', 'GZ', 0, '豫东大鼓', '2023-12-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (101, '红灯记', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m9.jpeg', 'GZ', 0, '豫东大鼓名角', '2023-12-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (102, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpg', 'GZ', 0, '豫东大鼓团', '2023-12-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (103, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpg', 'GZ', 0, '豫东大鼓', '2023-12-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (104, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m4.jpeg', 'GZ', 0, '豫东大鼓名角', '2023-12-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (105, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m7.jpeg', 'GZ', 0, '豫东大鼓团', '2023-12-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (106, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'GZ', 0, '豫东大鼓', '2023-12-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (107, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'XX', 0, '韩剧团', '2024-01-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (108, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m12.jpg', 'XX', 0, '韩剧', '2024-01-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (109, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m9.jpeg', 'XX', 0, '韩剧名角', '2024-01-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (110, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m14.jpg', 'XX', 0, '韩剧团', '2024-01-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (111, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m5.jpeg', 'XX', 0, '韩剧', '2024-01-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (112, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpeg', 'XX', 0, '韩剧名角', '2024-01-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (113, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'XX', 0, '韩剧团', '2024-01-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (114, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m9.jpeg', 'XX', 0, '韩剧', '2024-01-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (115, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'JC', 0, '绍剧团', '2024-02-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (116, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpg', 'JC', 0, '绍剧', '2024-02-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (117, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m11.jpeg', 'JC', 0, '绍剧名角', '2024-02-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (118, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m7.jpg', 'JC', 0, '绍剧团', '2024-02-04 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (119, '三岔口', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpeg', 'JC', 0, '绍剧', '2024-02-05 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (120, '拾玉镯', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m16.jpeg', 'JC', 0, '绍剧名角', '2024-02-06 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (121, '花木兰', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/1748016659303_1748015342834.jpg', 'JC', 0, '绍剧团', '2024-02-07 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (122, '白蛇传', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpeg', 'JC', 0, '绍剧', '2024-02-08 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (123, '锁麟囊', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m10.jpg', 'FC', 0, '晋剧团', '2024-03-01 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (124, '空城计', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m15.jpeg', 'FC', 0, '晋剧', '2024-03-02 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (125, '打金枝', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m13.jpeg', 'FC', 0, '晋剧名角', '2024-03-03 00:00:00', 0, 0);
INSERT INTO `song` (`songId`, `songName`, `songAddress`, `songCoverAddress`, `songType`, `songLength`, `songartist`, `upTime`, `trendingCoefficient`, `whetherCollected`) VALUES (126, '杨家将', 'images/1748017635625__贵妃醉酒_爱给网_aigei_com.mp3', 'images/m5.jpg', 'FC', 0, '晋剧团', '2024-03-04 00:00:00', 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码（MD5加密）',
  `email` varchar(100) NOT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (1, 'test', '202cb962ac59075b964b07152d234b70', '280962766@qq.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (3, 'test2', '202cb962ac59075b964b07152d234b70', 'test@qq.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (4, 'user001', 'e10adc3949ba59abbe56e057f20f883e', 'user001@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (5, 'user002', 'e10adc3949ba59abbe56e057f20f883e', 'user002@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (6, 'user003', 'e10adc3949ba59abbe56e057f20f883e', 'user003@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (7, 'user004', 'e10adc3949ba59abbe56e057f20f883e', 'user004@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (8, 'user005', 'e10adc3949ba59abbe56e057f20f883e', 'user005@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (9, 'user006', 'e10adc3949ba59abbe56e057f20f883e', 'user006@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (10, 'user007', 'e10adc3949ba59abbe56e057f20f883e', 'user007@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (11, 'user008', 'e10adc3949ba59abbe56e057f20f883e', 'user008@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (12, 'user009', 'e10adc3949ba59abbe56e057f20f883e', 'user009@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (13, 'user010', 'e10adc3949ba59abbe56e057f20f883e', 'user010@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (14, 'user011', 'e10adc3949ba59abbe56e057f20f883e', 'user011@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (15, 'user012', 'e10adc3949ba59abbe56e057f20f883e', 'user012@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (16, 'user013', 'e10adc3949ba59abbe56e057f20f883e', 'user013@example.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (17, 'user014', 'e10adc3949ba59abbe56e057f20f883e', 'user014@example.com');
COMMIT;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `videoname` varchar(100) NOT NULL COMMENT '视频名称',
  `songAddress` varchar(200) NOT NULL COMMENT '视频地址',
  `description` varchar(255) DEFAULT NULL COMMENT '视频描述',
  `date` datetime NOT NULL COMMENT '上传时间',
  `isrec` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否置顶头条',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='视频表';

-- ----------------------------
-- Records of video
-- ----------------------------
BEGIN;
INSERT INTO `video` (`id`, `videoname`, `songAddress`, `description`, `date`, `isrec`) VALUES (1, '11', 'images/istockphoto-1459767939-640_adpp_is.mp4', '111', '2025-05-24 01:28:03', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
