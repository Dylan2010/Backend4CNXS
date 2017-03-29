-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
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

CREATE DATABASE `cnxs`;

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
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (2,'数舟数据与中国新闻出版传媒集','Events','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 10:58:21',NULL,0),(3,'依托大数据，在文化高原探索高峰','Events','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 10:59:47',NULL,0),(4,'大数据，网络文学的寻龙诀','Events','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 11:00:05',NULL,0),(5,'谭建龙','Experts','中国科学院信息工程研究所，研究员',NULL,NULL,'2017-03-27 11:00:37',NULL,0),(6,'章毅','Experts','四川大学计算机学院院长、四川大学机器智能实验室创始人、教授，博导',NULL,NULL,'2017-03-27 11:00:50',NULL,0),(7,'陈文斌','Experts','复旦大学数学科学学院教授',NULL,NULL,'2017-03-27 11:01:08',NULL,0),(8,'行业资讯1','Info','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 11:01:33',NULL,0),(9,'行业资讯2','Info','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 11:01:36',NULL,0),(10,'行业资讯3','Info','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-27 11:01:43','2017-03-28 16:18:20',0),(11,'行业资讯3<;select a from b222 ;>','Info','数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',NULL,NULL,'2017-03-29 02:31:28','2017-03-29 00:00:00',1);
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

-- Dump completed on 2017-03-29 11:25:50
