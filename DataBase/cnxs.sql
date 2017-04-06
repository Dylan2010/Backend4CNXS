-- MySQL dump 10.13  Distrib 5.7.17, for osx10.12 (x86_64)
--
-- Host: localhost    Database: cnxs
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Create database
DROP DATABASE IF EXISTS `cnxs`;

CREATE DATABASE `cnxs`  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE `cnxs`;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  `summary` text NOT NULL,
  `content` longtext,
  `imageinfo` text,
  `creationtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `eventdate` timestamp NULL DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `_ARTICLE_UNIQUE_TITLE_TYPE_` (`title`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (2,'著名编剧兰晓龙会议现场发言','Events','',NULL,'{\"1\":\"http://101.37.39.51:8011/1490795084608.jpg\"}','2017-03-27 10:58:21','2016-12-17 00:00:00',0),(3,'依托IP大数据，在文化高原探索高峰','Events','',NULL,'{\"1\":\"http://101.37.39.51:8011/1490794640897.jpg\"}','2017-03-27 10:59:47','2016-12-02 00:00:00',0),(4,'大数据，网络文学的寻龙诀','Events','大数据，网络文学的寻龙诀','（北京讯）1月13日，北京，朗朗读书声不仅敲响了2017的新年钟声，还拉开了数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何成为大IP》主题访谈会的序幕。此次访谈会是“全民阅读‘红沙发’系列访谈”的重要组成部分，也是数舟（上海）数据信息服务有限公司首度加盟该系列的重要标志。全民阅读“红沙发”系列访谈由中国新闻出版传媒集团有限公司主办，该系列访谈创办于2012年，以主持人对话嘉宾的形式向公众全方位展现阅读的魅力与风采。','{\"1\":\"http://101.37.39.51:8011/1490793635306.jpg\",\"2\":\"http://101.37.39.51:8011/1490793671498.jpg\",\"3\":\"http://101.37.39.51:8011/1490793683798.jpg\",\"4\":\"http://101.37.39.51:8011/1490793691609.jpg\"}','2017-03-27 11:00:05','2017-03-29 00:00:00',0),(5,'谭建龙','Experts','中国科学院信息工程研究所，研究员','《面向业务、多元互动、智能评估、公信交易--------网络IP价值评估大数据平台建设》','{\"1\":\"http://101.37.39.51:8011/1490795788166.jpg\"}','2017-03-27 11:00:37',NULL,0),(6,'章毅','Experts','四川大学计算机学院院长、四川大学机器智能实验室创始人、教授，博导','IP大数据价值评估的神经网络方法》','{\"1\":\"http://101.37.39.51:8011/1490798170994.jpg\"}','2017-03-27 11:00:50',NULL,0),(7,'陈文斌','Experts','复旦大学数学科学学院教授','《IP估值数量模型探讨》','{\"1\":\"http://101.37.39.51:8011/1490797173500.jpg\"}','2017-03-27 11:01:08',NULL,0),(8,'大数据，网络文学的寻龙诀。','Info','数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何炼成大IP》主题访谈会','（北京讯）1月13日，北京，郎朗读书声不仅敲响了2017的新年钟声，还拉开了数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何炼成大IP》主题访谈会的序幕','{\"1\":\"http://101.37.39.51:8011/1490798459686.jpg\"}','2017-03-27 11:01:33',NULL,0),(9,'依托IP大数据，在文化高原探索高峰','Info','2016首届中国网络IP大数据发展研讨会”在京拉开帷幕','12月2日，由中国新闻出版传媒集团有限公司、中国全民阅读媒体联盟主办，浙江升华拜克生物股份有限公司联合主办、数舟（上海）数据信息服务有限公司承办的“2016首届中国网络IP大数据发展研讨会”在京拉开帷幕。','{\"1\":\"http://101.37.39.51:8011/1490798566146.jpg\"}','2017-03-27 11:01:36',NULL,0),(10,'行业资讯3','Info','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 11:01:43','2017-03-28 16:18:20',1),(11,'行业资讯3<;select a from b222 ;>','Info','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-29 02:31:28','2017-03-29 00:00:00',1),(12,'中国新闻出版传媒集团有限公司总经理李忠发表讲话','Events','',NULL,'{\"1\":\"http://101.37.39.51:8011/1490794932707.jpg\"}','2017-03-29 13:49:58','2016-12-15 00:00:00',0),(13,'国家新闻出版广电总局数字出版司程晓龙发言','Events','',NULL,'{\"1\":\"http://101.37.39.51:8011/1490795450573.jpg\"}','2017-03-29 13:51:14','2016-12-17 00:00:00',0),(14,'数舟（上海）数据信息服务有限公司董事长翁天雄在会议现场','Events','',NULL,'{\"1\":\"http://101.37.39.51:8011/1490795513438.jpg\"}','2017-03-29 13:52:04','2016-12-17 00:00:00',0),(15,'汤祈岑','Experts','网络文学大IP改编影视剧的新锐代表','《我经历的那些大IP》','{\"1\":\"http://101.37.39.51:8011/1490795892431.jpg\"}','2017-03-29 13:58:23',NULL,0),(16,'王永恩','Experts','中国传媒大学研究院博士，北京师范大学、上海戏剧学院博士后','《经典作品价值与网络IP估值的思索》','{\"1\":\"http://101.37.39.51:8011/1490796330048.jpg\"}','2017-03-29 14:05:42',NULL,0),(17,'史可扬','Experts','北京师范大学艺术与传媒学院教授，博士生导师','《IP电影热下的冷思考》','{\"1\":\"http://101.37.39.51:8011/1490796495525.jpg\"}','2017-03-29 14:08:27',NULL,0),(18,'高歌','Experts','编剧、制作人、制片人、柒羽文化CEO','《影视剧制作与IP估值的良性关系》','{\"1\":\"http://101.37.39.51:8011/1490796555041.jpg\"}','2017-03-29 14:09:29',NULL,0),(19,'兰晓龙','Experts','著名编剧','《IP时代下剧本编剧的创新》','{\"1\":\"http://101.37.39.51:8011/1490796618486.jpg\"}','2017-03-29 14:10:37',NULL,0),(20,'谈瀛洲','Experts','博士生导师，复旦大学中澳创意写作中心主任，上海作家协会会员，传记文学研究会理事','《传统文学，网络文学与IP》','{\"1\":\"http://101.37.39.51:8011/1490796735796.jpg\"}','2017-03-29 14:12:26',NULL,0),(21,'邵燕君','Experts','北京大学中文系副教授，中国作协网络委员会委员、中国网络文学研究专家','《全球媒介革命视野下的中国网络文学——中国网络文学的域外传播》','{\"1\":\"http://101.37.39.51:8011/1490796814824.jpg\"}','2017-03-29 14:13:48',NULL,0),(22,'陈村','Experts','上海作家协会副主席，上海网络作家协会会长','《在一个个错误中前行》','{\"1\":\"http://101.37.39.51:8011/1490796888343.jpg\"}','2017-03-29 14:15:16',NULL,0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `creationtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'initialAccount','$2a$10$oRHxGSa.ZPJk7iU7NZVM8u/QP6tvo5ehZCnShJqadMiBC8F5IyWLG',NULL,'2017-03-27 02:49:53',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-29 23:15:38
