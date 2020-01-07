-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: BUSINESSCHAINSYSTEM
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

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

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `employee` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,'manager1','$2a$10$Qcmlp3AyK5AMG4Mgdy7FR.a4E66KY2iB/yIVPYDO9Xnsp.2Y6oF4e',2,1),(3,'manager2','$2a$10$7WM.qEsdwRFax94hAH7j5.A5ynevWBHoQ2zQrctzSM6SLwjE4p0le',3,1),(4,'manager3','$2a$10$YE9xW2YvgXSfdj3mlUkWk.cKOZOJhSVsshgNc0E9nD5ypjspHvtp6',4,1),(5,'manager4','$2a$10$aou.5lwLOy8hGapkzuPehe9rm9SG1Ga/xyEalJbCoEmmQBnjDdc26',5,1),(6,'manager5','$2a$10$cCf1uk9DKOF6h3q7a63ajuXy3j8OIFkHVqcbWt5zfdmAPJ/AFiHz6',6,1),(7,'manager6','$2a$10$U.8yMsDd.0d0L1LZzJMDIOs.LStkb...Ws5PwhAsBpTL1Qm6Og6wy',7,1),(8,'manager7','$2a$10$2s/SdSNm4skBNh6Qr/z4uOyv/vU6YHgbRht6c38aFcnw0VIDb85dC',8,1),(9,'manager8','$2a$10$rxOYxMTdWymao0pBoUHEIeSqJAQdggSBvqBPDjHCvGNkZ.pyJ2Yl.',9,1),(10,'manager9','$2a$10$UkPjwfgo58NKOs/MtMD6nueAqny3jow4JLTWdK8AU4nUwlBNA0eq2',10,1),(11,'manager10','$2a$10$loQTfAp0k8qJeaazsqPMJ.SNBl27YLnpTfq62kBPmTp9V6WBPlw/2',11,1),(12,'business','$2a$10$ebPa3tts9Z5eAkLr0AJKeeyqTcFfwTicos8nj0ZdmIEZYe/8GVWVG',12,1),(13,'accountant','$2a$10$kWA2ujuHbBvohuhJUOZ52.nPBRTsIZ..7UdSEi8OLDne3aELW7Bfi',13,1),(14,'EMPLOYEE000021','$2a$10$lNSFVj1YzFgzjLuZcb65eOcCg.sXM5w230ryZZjCay1Mi0KSjnZuS',21,1),(15,'EMPLOYEE000018','$2a$10$ukeaXZUbgcZZMQ9EmdxDXOpHdq2jwM4ObWVosVYuVOl7tfqeyFBV.',18,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemMenu` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `total` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,1,'10000','10000','2019-12-31 00:03:00',2,2),(2,3,3,'10000','30000','2019-12-31 00:03:01',2,2),(3,7,1,'10000','10000','2019-12-31 00:03:01',2,2),(4,8,1,'10000','10000','2019-12-31 00:03:01',2,2),(5,4,4,'10000','40000','2019-12-31 00:03:03',2,2),(6,6,1,'10000','10000','2019-12-31 00:03:03',2,2),(7,2,1,'10000','10000','2019-12-31 00:03:03',2,2),(8,4,1,'10000','10000','2019-12-31 00:03:15',2,2),(9,8,1,'10000','10000','2019-12-31 00:03:15',2,2),(10,7,1,'10000','10000','2019-12-31 00:03:16',2,2),(11,3,1,'10000','10000','2019-12-31 00:03:16',2,2),(12,2,1,'10000','10000','2019-12-31 00:03:16',2,2),(13,5,1,'10000','10000','2019-12-31 00:03:26',2,2),(14,1,1,'10000','10000','2019-12-31 00:03:26',2,2),(15,6,1,'10000','10000','2019-12-31 00:03:27',2,2),(16,9,1,'10000','10000','2019-12-31 00:03:27',2,2),(17,2,1,'10000','10000','2019-12-31 00:03:27',2,2),(18,8,1,'10000','10000','2019-12-31 00:03:27',2,2),(19,7,1,'10000','10000','2019-12-31 00:03:27',2,2),(20,8,1,'10000','10000','2019-12-31 00:03:39',2,2),(21,4,1,'10000','10000','2019-12-31 00:03:40',2,2),(22,3,2,'10000','20000','2019-12-31 00:03:40',2,2),(23,8,1,'10000','10000','2019-12-31 00:07:52',3,3),(24,4,1,'10000','10000','2019-12-31 00:07:52',3,3),(25,3,2,'10000','20000','2019-12-31 00:07:53',3,3),(26,12,1,'10000','10000','2019-12-31 00:07:54',3,3),(27,13,1,'10000','10000','2019-12-31 00:07:54',3,3),(28,14,1,'10000','10000','2019-12-31 00:07:54',3,3),(29,18,1,'10000','10000','2019-12-31 00:07:55',3,3),(30,17,1,'10000','10000','2019-12-31 00:07:55',3,3),(31,16,1,'10000','10000','2019-12-31 00:07:56',3,3),(32,8,1,'10000','10000','2019-12-31 00:08:03',3,3),(33,4,1,'10000','10000','2019-12-31 00:08:03',3,3),(34,3,2,'10000','20000','2019-12-31 00:08:03',3,3),(35,12,2,'10000','20000','2019-12-31 00:08:04',3,3),(36,13,2,'10000','20000','2019-12-31 00:08:04',3,3),(37,14,1,'10000','10000','2019-12-31 00:08:04',3,3),(38,18,1,'10000','10000','2019-12-31 00:08:05',3,3),(39,17,2,'10000','20000','2019-12-31 00:08:06',3,3),(40,16,2,'10000','20000','2019-12-31 00:08:06',3,3),(41,11,1,'10000','10000','2019-12-31 00:08:07',3,3),(42,8,1,'10000','10000','2019-12-31 00:08:18',3,3),(43,4,1,'10000','10000','2019-12-31 00:08:18',3,3),(44,3,2,'10000','20000','2019-12-31 00:08:18',3,3),(45,12,3,'10000','30000','2019-12-31 00:08:19',3,3),(46,13,2,'10000','20000','2019-12-31 00:08:19',3,3),(47,14,1,'10000','10000','2019-12-31 00:08:19',3,3),(48,18,1,'10000','10000','2019-12-31 00:08:20',3,3),(49,17,6,'10000','60000','2019-12-31 00:08:20',3,3),(50,16,3,'10000','30000','2019-12-31 00:08:21',3,3),(51,11,1,'10000','10000','2019-12-31 00:08:21',3,3),(52,8,1,'10000','10000','2019-12-31 00:08:28',3,3),(53,4,1,'10000','10000','2019-12-31 00:08:28',3,3),(54,3,2,'10000','20000','2019-12-31 00:08:28',3,3),(55,12,4,'10000','40000','2019-12-31 00:08:28',3,3),(56,13,3,'10000','30000','2019-12-31 00:08:28',3,3),(57,14,2,'10000','20000','2019-12-31 00:08:28',3,3),(58,18,2,'10000','20000','2019-12-31 00:08:28',3,3),(59,17,7,'10000','70000','2019-12-31 00:08:29',3,3),(60,16,3,'10000','30000','2019-12-31 00:08:29',3,3),(61,11,1,'10000','10000','2019-12-31 00:08:29',3,3),(62,1,134,'13000','1742000','2019-12-31 00:00:00',3,3),(63,1,134,'13000','1742000','2019-12-31 00:03:00',4,4),(64,1,134,'13000','1742000','2019-12-31 00:03:00',5,5),(65,1,134,'13000','1742000','2019-12-31 00:03:00',6,6),(66,1,134,'13000','1742000','2019-12-31 00:03:00',7,7),(67,1,134,'13000','1742000','2019-12-31 00:03:00',8,8),(68,1,134,'13000','1742000','2019-12-31 00:03:00',9,9),(69,1,134,'13000','1742000','2019-12-31 00:03:00',10,10),(70,1,134,'13000','1742000','2019-12-31 00:03:00',2,2),(71,1,134,'13000','1742000','2019-12-31 00:03:00',3,3),(72,1,134,'13000','1742000','2019-12-31 00:03:00',11,11),(73,1,134,'13000','1742000','2019-12-31 00:03:00',11,11),(74,1,134,'13000','1742000','2019-12-25 00:03:00',11,11),(75,1,134,'13000','1742000','2019-12-25 00:03:00',10,10),(76,1,134,'13000','1742000','2019-12-25 00:03:00',10,10),(77,1,134,'13000','1742000','2019-12-25 00:03:00',10,10),(78,1,134,'13000','1742000','2019-12-25 00:03:00',9,9),(79,1,134,'13000','1742000','2019-12-25 00:03:00',9,9),(80,1,134,'13000','1742000','2019-12-25 00:03:00',9,9),(81,1,134,'13000','1742000','2019-12-25 00:03:00',9,9),(82,1,134,'13000','1742000','2019-12-25 00:03:00',9,9),(83,1,134,'13000','1742000','2019-12-25 00:03:00',8,8),(84,1,134,'13000','1742000','2019-12-25 00:03:00',8,8),(85,1,134,'13000','1742000','2019-12-25 00:03:00',7,7),(86,1,134,'13000','1742000','2019-12-25 00:03:00',7,7),(87,1,134,'13000','1742000','2019-12-25 00:03:00',7,7),(88,1,134,'13000','1742000','2019-12-25 00:03:00',7,7),(89,1,134,'13000','1742000','2019-12-25 00:03:00',6,6),(90,1,134,'13000','1742000','2019-12-25 00:03:00',6,6),(91,1,134,'13000','1742000','2019-12-25 00:03:00',6,6),(92,1,134,'13000','1742000','2019-12-25 00:03:00',6,6),(93,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(94,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(95,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(96,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(97,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(98,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(99,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(100,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(101,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(102,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(103,1,134,'13000','1742000','2019-12-25 00:03:00',5,5),(104,1,134,'13000','1742000','2019-12-25 00:03:00',4,4),(105,1,134,'13000','1742000','2019-12-25 00:03:00',4,4),(106,1,134,'13000','1742000','2019-12-25 00:03:00',3,3),(107,1,134,'13000','1742000','2019-12-25 00:03:00',3,3),(108,1,134,'13000','1742000','2019-12-25 00:03:00',3,3),(109,1,134,'13000','1742000','2019-12-25 00:03:00',2,2),(110,1,134,'13000','1742000','2019-12-25 00:03:00',2,2),(111,1,13444,'13000','174772000','2019-12-25 00:03:00',1,1),(112,1,134,'130000','17420000','2019-12-25 00:03:00',2,2),(113,1,134,'13000','1742000','2019-12-25 00:03:00',2,2),(114,1,134,'130000','17420000','2019-12-25 00:03:00',3,3),(115,1,1,'10000','10000','2020-01-07 22:14:44',2,2),(116,2,1,'10000','10000','2020-01-07 22:14:45',2,2),(117,3,1,'10000','10000','2020-01-07 22:14:45',2,2),(118,4,1,'10000','10000','2020-01-07 22:14:45',2,2),(119,8,1,'10000','10000','2020-01-07 22:14:45',2,2),(120,7,1,'10000','10000','2020-01-07 22:14:45',2,2),(121,6,1,'10000','10000','2020-01-07 22:14:45',2,2),(122,5,1,'10000','10000','2020-01-07 22:14:45',2,2),(123,9,1,'10000','10000','2020-01-07 22:14:45',2,2);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `manager` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `openDay` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Cơ sở chính','Quận 7, HCM',2,1,'2019-12-30'),(2,'Cơ sở 1','Quận 1, HCM',3,1,'2019-12-30'),(3,'Cơ sở 2','Quận 2, HCM',4,1,'2019-12-30'),(4,'Cơ sở 3','Quận 3, HCM',5,1,'2019-12-30'),(5,'Cơ sở 4','Quận 4, HCM',6,1,'2019-12-30'),(6,'Cơ sở 5','Quận 1, HCM',7,1,'2019-12-30'),(7,'Cơ sở 6','Phú Nhuận, HCM',8,1,'2019-12-30'),(8,'Cơ sở 7','Tân Bình, HCM',9,1,'2019-12-30'),(9,'Cơ sở 8','Bình Thạnh, HCM',10,1,'2019-12-30'),(10,'Cơ sở 9','Tan Phu, HCM',11,1,'2019-12-30'),(11,'Cơ sở 10','Quận 8, HCM',12,1,'2019-12-30');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classID` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `teacher` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  `fromDate` date DEFAULT NULL,
  `toDate` date DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (4,'CLASS000001',16,1,2,'2020-01-01','2020-03-01',NULL,NULL,NULL,NULL),(5,'CLASS000002',17,1,2,'2020-01-01','2020-03-01',NULL,NULL,NULL,NULL),(6,'CLASS000003',18,1,2,'2020-01-01','2020-03-01',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeID` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cardID` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthDay` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phoneNumber` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `salary` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'EMPLOYEE000002','Nguyễn Văn An','215438985','1998-06-04',1,'Tan Binh, Ho Chi Minh, VN','0978301442','annguyen@gmail.com',2,1,'4000000',NULL,0,'2019-12-30 18:43:10',12),(3,'EMPLOYEE000003','Thành Đạt','215438985','1998-06-04',1,'Tan Binh, Ho Chi Minh, VN','0134651651','datthanh@gmail.com',3,1,'4000000',NULL,0,'2019-12-30 18:43:41',12),(4,'EMPLOYEE000004','Hoàn Luân','215438985','1998-06-04',1,'Tan Binh, Ho Chi Minh, VN','0168165165','tannguyenduy98@gmail.com',4,1,'4000000',NULL,0,'2019-12-30 18:44:08',12),(5,'EMPLOYEE000005','Thị Nở','215438985','1998-06-04',0,'Tan Binh, Ho Chi Minh, VN','0977782714','nothi@gmail.com',5,1,'4000000',NULL,0,'2019-12-30 18:44:40',12),(6,'EMPLOYEE000006','Hà Thu','215438985','1998-06-19',0,'Tan Binh, Ho Chi Minh, VN','0977782714','thuha@gmail.com',6,1,'4000000',NULL,0,'2019-12-30 18:45:05',12),(7,'EMPLOYEE000007','An Đạt','215438985','1998-06-04',0,'Tan Binh, Ho Chi Minh, VN','0366879264','datan@gmail.com',7,1,'4000000',NULL,0,'2019-12-30 18:45:31',12),(8,'EMPLOYEE000008','Minh Thị','215438985','1998-06-04',0,'Tan Binh, Ho Chi Minh, VN','0978301442','tannguyenduy98@gmail.com',8,1,'4000000',NULL,0,'2019-12-30 18:45:41',12),(9,'EMPLOYEE000009','Nguyễn Hà An','215438985','1998-06-04',0,'Tan Binh, Ho Chi Minh, VN','0978301442','annguyen@gmail.com',9,1,'4000000',NULL,0,'2019-12-30 18:45:58',12),(10,'EMPLOYEE000010','Hà Tiên','215438985','1998-06-04',0,'Tan Binh, Ho Chi Minh, VN','0978301442','tannguyenduy98@gmail.com',10,1,'4000000',NULL,0,'2019-12-30 18:46:08',12),(11,'EMPLOYEE000011','Thanh Minh','215438985','1998-06-04',1,'Tan Binh, Ho Chi Minh, VN','0978301442','tannguyenduy98@gmail.com',11,1,'4000000',NULL,0,'2019-12-30 18:46:22',12),(12,'EMPLOYEE000012','Nguyễn Hoàng','215444324','1998-06-12',1,'Tan Binh, Ho Chi Minh, VN','0978301442','tannguyenduy98@gmail.com',1,1,'50000000',NULL,0,'2019-12-30 18:48:03',12),(13,'EMPLOYEE000013','Trần Bùi Bình Chi','215438985','1999-06-04',0,'Tan Binh, Ho Chi Minh, VN','0168479561','chitran@gmail.com',1,1,'4000000',NULL,0,'2019-12-30 18:49:34',12),(14,'EMPLOYEE000014','Nguyễn Thị Yên','244612357','1997-12-02',0,'Tan Binh, Ho Chi Minh, VN','0165165165','annguyen@gmail.com',2,1,'1000000','2019-12-30 18:50:59',12,NULL,0),(15,'EMPLOYEE000015','Nguyễn Nhật Hà','215624896','1997-12-12',1,'Tan Binh, Ho Chi Minh, VN','0977586742','annguyen@gmail.com',2,1,'1000000','2019-12-30 18:52:24',12,NULL,0),(16,'EMPLOYEE000016','Nguyễn Thị Anh','214526398','1997-12-06',0,'Tan Binh, Ho Chi Minh, VN','0977782714','default@gmail.com',2,1,'8000000','2019-12-30 18:53:26',12,NULL,0),(17,'EMPLOYEE000017','Hà Thiên Thu','266345864','1997-11-14',0,'Tan Binh, Ho Chi Minh, VN','0977782714','default@gmail.com',2,1,'8000000','2019-12-30 18:54:28',12,NULL,0),(18,'EMPLOYEE000018','Nguyễn Nhật Nam','216875684','1997-11-24',1,'Tan Binh, Ho Chi Minh, VN','0977586742','default@gmail.com',2,1,'8000000','2019-12-30 18:55:21',12,'2019-12-30 19:27:56',12),(19,'EMPLOYEE000019','An Nhật Nam','244789654','1997-01-01',1,'HCM','0165165165','default@gmail.com',3,1,'1000000','2019-12-30 18:57:29',12,NULL,0),(20,'EMPLOYEE000020','Nguyễn Hạ Thiên','244568795','1997-01-01',1,'HCM','0168165165','datan@gmail.com',3,1,'10000000','2019-12-30 18:58:18',12,NULL,0),(21,'EMPLOYEE000021','Đinh Văn An','0978555412','1997-01-01',1,'Tan Binh, Ho Chi Minh, VN','0165165165','default@gmail.com',3,1,'1000000','2019-12-30 18:58:58',12,'2019-12-30 18:59:11',12),(22,'EMPLOYEE000022','Thiên Thị Tha','244568795','1997-01-01',0,'Tan Binh, Ho Chi Minh, VN','0168165165','default@gmail.com',3,1,'8000000','2019-12-30 19:00:09',12,NULL,0),(23,'EMPLOYEE000023','Thái Thu Thanh','214568795','2019-12-12',0,'Tan Binh, Ho Chi Minh, VN','0165165165','default@gmail.com',3,1,'8000000','2019-12-30 19:00:52',12,NULL,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_role`
--

DROP TABLE IF EXISTS `employee_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_role`
--

LOCK TABLES `employee_role` WRITE;
/*!40000 ALTER TABLE `employee_role` DISABLE KEYS */;
INSERT INTO `employee_role` VALUES (2,2,4),(3,3,4),(4,4,4),(5,5,4),(6,6,4),(7,7,4),(8,8,4),(9,9,4),(10,10,4),(11,11,4),(12,12,6),(13,13,5),(14,14,2),(15,15,2),(16,16,3),(17,17,3),(18,18,3),(19,19,2),(20,20,2),(21,21,3),(22,22,3),(23,23,3);
/*!40000 ALTER TABLE `employee_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipmentID` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `price` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'EQT2019-12-31000041003','Bộ bàn ghế',1,'900000',2),(2,'EQT2019-12-31000041014','Máy chiếu HDI',1,'1500000',2),(3,'EQT2019-12-31000041038','Máy say sinh tố',1,'400000',1),(4,'EQT2019-12-31000041050','Máy pha cafe',1,'500000',1),(5,'EQT2019-12-31000041059','Tủ lạnh IIFT',1,'5000000',1);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import`
--

DROP TABLE IF EXISTS `import`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `import` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resourceID` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalMoney` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import`
--

LOCK TABLES `import` WRITE;
/*!40000 ALTER TABLE `import` DISABLE KEYS */;
INSERT INTO `import` VALUES (1,'MTL2019-12-31000038039',150,'15000','2250000','2019-12-31 00:44:59',12),(2,'MTL2019-12-31000038054',200,'2000','400000','2019-12-31 00:44:59',12),(3,'EQT2019-12-31000041014',1,'1500000','1500000','2019-12-31 00:44:59',12),(4,'EQT2019-12-31000041059',1,'5000000','5000000','2019-12-31 00:44:59',12),(5,'EQT2019-12-31000041050',1,'500000','500000','2019-12-31 00:44:59',12),(6,'EQT2019-12-31000041038',1,'400000','400000','2019-12-31 00:44:59',12),(7,'EQT2019-12-31000041003',1,'900000','900000','2019-12-31 00:44:59',12),(8,'MTL2019-12-31000040040',150,'5000','750000','2019-12-31 00:44:59',12),(9,'MTL2019-12-31000039040',100,'10000','1000000','2019-12-31 00:44:59',12),(10,'MTL2019-12-31000039014',100,'4000','400000','2019-12-31 00:44:59',12),(11,'MTL2019-12-31000039003',100,'8000','800000','2019-12-31 00:44:59',12),(12,'MTL2019-12-31000040019',20,'5000','100000','2019-12-31 00:44:59',12);
/*!40000 ALTER TABLE `import` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger add_import after insert
on import
for each row
begin
	if( NEW.resourceID like 'MTL%') then
		
        update material_branch mb 
        set count = count + NEW.count
        where mb.branch = 1 
        and exists(select * from material m where m.materialID = NEW.resourceID and m.id = mb.material);
		
        update material m 
        set count = count + NEW.count, price = new.price
        where m.materialID = NEW.resourceID;        
	else
    
		update equipment e 
        set status = 1, price = new.price
        where e.equipmentID = new.resourceID;
	end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materialID` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'MTL2019-12-31000038039','Bột Net Cafe',150,'15000'),(2,'MTL2019-12-31000038054','Sữa tươi Milo',200,'2000'),(3,'MTL2019-12-31000039003','Trà Lipton',100,'8000'),(4,'MTL2019-12-31000039014','Cafe trung nguyên',100,'4000'),(5,'MTL2019-12-31000039027','Trái cây',0,'0'),(6,'MTL2019-12-31000039040','Đường',100,'10000'),(7,'MTL2019-12-31000040019','Kem tươi',20,'5000'),(8,'MTL2019-12-31000040040','Sữa đặc',150,'5000');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger add_material after insert
on material
for each row
begin
	insert material_branch(material,branch,count) values (
		new.id,
        1,
        0
    );
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `material_branch`
--

DROP TABLE IF EXISTS `material_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_branch`
--

LOCK TABLES `material_branch` WRITE;
/*!40000 ALTER TABLE `material_branch` DISABLE KEYS */;
INSERT INTO `material_branch` VALUES (1,1,1,114),(2,2,1,200),(3,3,1,49),(4,4,1,100),(5,5,1,0),(6,6,1,100),(7,7,1,5),(8,8,1,150),(9,7,2,15),(10,1,2,36),(11,3,2,51);
/*!40000 ALTER TABLE `material_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `employee` int(11) DEFAULT NULL,
  `salary` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `absent` int(11) DEFAULT NULL,
  `other` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contentOther` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalMoney` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES (24,12,2019,1,'10000000',0,'1000000','Thưởng thêm dịp tết','11000000','2019-12-30 21:53:29',13),(25,12,2019,2,'4000000',2,'1000000','Thưởng thêm dịp tết','4733334','2019-12-30 21:53:29',13),(26,12,2019,3,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(27,12,2019,4,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(28,12,2019,5,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(29,12,2019,6,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(30,12,2019,7,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(31,12,2019,8,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(32,12,2019,9,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(33,12,2019,10,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(34,12,2019,11,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(35,12,2019,12,'50000000',0,'0',NULL,'50000000','2019-12-30 21:53:29',13),(36,12,2019,13,'4000000',0,'0',NULL,'4000000','2019-12-30 21:53:29',13),(37,12,2019,14,'1000000',2,'0',NULL,'933334','2019-12-30 21:53:29',13),(38,12,2019,15,'1000000',1,'0',NULL,'966667','2019-12-30 21:53:29',13),(39,12,2019,16,'8000000',1,'0',NULL,'7733334','2019-12-30 21:53:29',13),(40,12,2019,17,'8000000',1,'0',NULL,'7733334','2019-12-30 21:53:29',13),(41,12,2019,18,'8000000',1,'0',NULL,'7733334','2019-12-30 21:53:29',13),(42,12,2019,19,'1000000',0,'0',NULL,'1000000','2019-12-30 21:53:29',13),(43,12,2019,20,'10000000',0,'0',NULL,'10000000','2019-12-30 21:53:29',13),(44,12,2019,21,'1000000',0,'0',NULL,'1000000','2019-12-30 21:53:29',13),(45,12,2019,22,'8000000',0,'0',NULL,'8000000','2019-12-30 21:53:29',13),(46,12,2019,23,'8000000',0,'0',NULL,'8000000','2019-12-30 21:53:29',13);
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'STAFF'),(3,'TEACHER'),(4,'BRANCHMANAGER'),(5,'ACCOUNTANT'),(6,'BUSINESSMANAGER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `value` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (1,'CHOCOLATE','10000',0,2),(2,'ESPRESSO','10000',0,2),(3,'CAPPUCCINO','10000',0,2),(4,'MACCHIATO','10000',0,2),(5,'LATTE','10000',0,2),(6,'AMERICANO','10000',0,2),(7,'ARIGATO','10000',0,2),(8,'MOCHA','10000',0,2),(9,'FLAT_WHITE','10000',0,2),(10,'Số lượng nhân viên tối đa','5',1,2),(11,'CHOCOLATE','10000',0,3),(12,'ESPRESSO','10000',0,3),(13,'CAPPUCCINO','10000',0,3),(14,'MACCHIATO','10000',0,3),(15,'LATTE','10000',0,3),(16,'AMERICANO','10000',0,3),(17,'ARIGATO','10000',0,3),(18,'MOCHA','10000',0,3),(19,'FLAT_WHITE','10000',0,3),(20,'Số lượng nhân viên tối đa','5',1,3),(21,'CHOCOLATE','10000',0,4),(22,'ESPRESSO','10000',0,4),(23,'CAPPUCCINO','10000',0,4),(24,'MACCHIATO','10000',0,4),(25,'LATTE','10000',0,4),(26,'AMERICANO','10000',0,4),(27,'ARIGATO','10000',0,4),(28,'MOCHA','10000',0,4),(29,'FLAT_WHITE','10000',0,4),(30,'Số lượng nhân viên tối đa','5',1,4),(31,'CHOCOLATE','10000',0,5),(32,'ESPRESSO','10000',0,5),(33,'CAPPUCCINO','10000',0,5),(34,'MACCHIATO','10000',0,5),(35,'LATTE','10000',0,5),(36,'AMERICANO','10000',0,5),(37,'ARIGATO','10000',0,5),(38,'MOCHA','10000',0,5),(39,'FLAT_WHITE','10000',0,5),(40,'Số lượng nhân viên tối đa','5',1,5),(41,'CHOCOLATE','10000',0,6),(42,'ESPRESSO','10000',0,6),(43,'CAPPUCCINO','10000',0,6),(44,'MACCHIATO','10000',0,6),(45,'LATTE','10000',0,6),(46,'AMERICANO','10000',0,6),(47,'ARIGATO','10000',0,6),(48,'MOCHA','10000',0,6),(49,'FLAT_WHITE','10000',0,6),(50,'Số lượng nhân viên tối đa','5',1,6),(51,'CHOCOLATE','10000',0,7),(52,'ESPRESSO','10000',0,7),(53,'CAPPUCCINO','10000',0,7),(54,'MACCHIATO','10000',0,7),(55,'LATTE','10000',0,7),(56,'AMERICANO','10000',0,7),(57,'ARIGATO','10000',0,7),(58,'MOCHA','10000',0,7),(59,'FLAT_WHITE','10000',0,7),(60,'Số lượng nhân viên tối đa','5',1,7),(61,'CHOCOLATE','10000',0,8),(62,'ESPRESSO','10000',0,8),(63,'CAPPUCCINO','10000',0,8),(64,'MACCHIATO','10000',0,8),(65,'LATTE','10000',0,8),(66,'AMERICANO','10000',0,8),(67,'ARIGATO','10000',0,8),(68,'MOCHA','10000',0,8),(69,'FLAT_WHITE','10000',0,8),(70,'Số lượng nhân viên tối đa','5',1,8),(71,'CHOCOLATE','10000',0,9),(72,'ESPRESSO','10000',0,9),(73,'CAPPUCCINO','10000',0,9),(74,'MACCHIATO','10000',0,9),(75,'LATTE','10000',0,9),(76,'AMERICANO','10000',0,9),(77,'ARIGATO','10000',0,9),(78,'MOCHA','10000',0,9),(79,'FLAT_WHITE','10000',0,9),(80,'Số lượng nhân viên tối đa','5',1,9),(81,'CHOCOLATE','10000',0,10),(82,'ESPRESSO','10000',0,10),(83,'CAPPUCCINO','10000',0,10),(84,'MACCHIATO','10000',0,10),(85,'LATTE','10000',0,10),(86,'AMERICANO','10000',0,10),(87,'ARIGATO','10000',0,10),(88,'MOCHA','10000',0,10),(89,'FLAT_WHITE','10000',0,10),(90,'Số lượng nhân viên tối đa','5',1,10),(91,'CHOCOLATE','10000',0,11),(92,'ESPRESSO','10000',0,11),(93,'CAPPUCCINO','10000',0,11),(94,'MACCHIATO','10000',0,11),(95,'LATTE','10000',0,11),(96,'AMERICANO','10000',0,11),(97,'ARIGATO','10000',0,11),(98,'MOCHA','10000',0,11),(99,'FLAT_WHITE','10000',0,11),(100,'Số lượng nhân viên tối đa','5',1,11);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) DEFAULT NULL,
  `shift` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,1,1),(2,1,6),(4,2,3),(5,2,7),(6,2,11),(7,3,4),(8,3,6),(9,3,14),(11,1,9),(12,4,1),(13,4,4),(14,4,7),(15,5,6),(16,5,8),(17,5,10),(18,6,1),(19,6,5),(20,6,10);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift`
--

DROP TABLE IF EXISTS `shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shift` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift`
--

LOCK TABLES `shift` WRITE;
/*!40000 ALTER TABLE `shift` DISABLE KEYS */;
INSERT INTO `shift` VALUES (1,'Thứ 2','Ca 1'),(2,'Thứ 2','Ca 2'),(3,'Thứ 3','Ca 1'),(4,'Thứ 3','Ca 2'),(5,'Thứ 4','Ca 1'),(6,'Thứ 4','Ca 2'),(7,'Thứ 5','Ca 1'),(8,'Thứ 5','Ca 2'),(9,'Thứ 6','Ca 1'),(10,'Thứ 6','Ca 2'),(11,'Thứ 7','Ca 1'),(12,'Thứ 7','Ca 2'),(13,'Chủ nhật','Ca 1'),(14,'Chủ nhật','Ca 2');
/*!40000 ALTER TABLE `shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipway`
--

DROP TABLE IF EXISTS `shipway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipway` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromBranch` int(11) DEFAULT NULL,
  `toBranch` int(11) DEFAULT NULL,
  `resourceID` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalMoney` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipway`
--

LOCK TABLES `shipway` WRITE;
/*!40000 ALTER TABLE `shipway` DISABLE KEYS */;
INSERT INTO `shipway` VALUES (1,1,2,'MTL2019-12-31000040019',15,'5000','75000','2019-12-31',12),(2,1,2,'EQT2019-12-31000041014',1,'1500000','1500000','2019-12-31',12),(3,1,2,'EQT2019-12-31000041003',1,'900000','900000','2019-12-31',12),(4,1,2,'MTL2019-12-31000038039',36,'15000','540000','2019-12-31',12),(5,1,2,'MTL2019-12-31000039003',51,'8000','408000','2019-12-31',12);
/*!40000 ALTER TABLE `shipway` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger add_shipway after insert
on shipway
for each row
begin
	if( NEW.resourceID like 'MTL%') then
		if((select count(*) from material_branch mb 
			where mb.branch = NEW.toBranch 
			and exists(select * from material m where m.materialID = NEW.resourceID and m.id = mb.material)
            ) = 0 )then 
            insert material_branch(material,branch,count) values (
				(select id from material where materialID = new.resourceID),
                new.toBranch,
                new.count
			);
		else
			update material_branch mb set count = count + NEW.count
			where mb.branch = NEW.toBranch 
			and exists(select * from material m where m.materialID = NEW.resourceID and m.id = mb.material);
		end if;
        
        update material_branch mb set count = count - NEW.count
        where mb.branch = NEW.fromBranch 
        and exists(select * from material m where m.materialID = NEW.resourceID and m.id = mb.material);        
	else
    
		update equipment e set branch = new.toBranch
        where e.equipmentID = new.resourceID;
	end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `spend`
--

DROP TABLE IF EXISTS `spend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalMoney` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spend`
--

LOCK TABLES `spend` WRITE;
/*!40000 ALTER TABLE `spend` DISABLE KEYS */;
/*!40000 ALTER TABLE `spend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cardID` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthDay` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phoneNumber` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'STUDENT000001','Phan Văn Lim','244896548','2000-12-12',1,'Quận 7, Hồ Chí Minh','0983333174','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(2,'STUDENT000002','Nguyễn Văn Lỗi','268957842','1999-12-12',1,'Quận 7, Hồ Chí Minh','0366245687','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(3,'STUDENT000003','Phạm Hà Thu','215864759','2000-12-12',0,'Quận 7, Hồ Chí Minh','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(4,'STUDENT000004','Nguyễn Văn Trỗi','244786135','1997-11-08',1,'Tan Binh, Ho Chi Minh, VN','0165165165','datan@gmail.com',2,1,NULL,NULL,NULL,NULL),(5,'STUDENT000005','Hà Thị Thúy','245311475','1996-01-01',0,'Quận 7, Hồ Chí Minh','0134651651','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(6,'STUDENT000006','Trần Thị Hường','25579456','1996-03-03',0,'Quận 7, Hồ Chí Minh','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(7,'STUDENT000007','Phạm Thị Bưởi','255412689','1998-12-12',0,'Quận 7, Hồ Chí Minh','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(8,'STUDENT000008','Nguyễn Văn Ngọ','225928103','1999-04-04',1,'Tan Binh, Ho Chi Minh, VN','0165165165','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(9,'STUDENT000009','Nguyễn Văn Cảnh','245687956','1997-06-06',1,'Tan Binh, Ho Chi Minh, VN','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(10,'STUDENT000010','Trần Thúy Lan','259786426','1999-03-03',0,'Tan Binh, Ho Chi Minh, VN','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(11,'STUDENT000011','Nguyễn Công Hậu','244157894','1998-05-05',1,'Tan Binh, Ho Chi Minh, VN','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(12,'STUDENT000012','Bùi Thái Thăng','248659786','1998-07-07',1,'Quận 7, Hồ Chí Minh','0168456789','tannguyenduy98@gmail.com',2,1,NULL,NULL,NULL,NULL),(13,'STUDENT000013','Nguyễn Ấn','245789654','1998-06-06',0,'Tan Binh, Ho Chi Minh, VN','0165165165','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(14,'STUDENT000014','Nguyen Van B','25579456','1998-12-14',1,'Quận 7, Hồ Chí Minh','0165165165','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(15,'STUDENT000015','Phạm Thị Nghè','214578963','1999-12-12',0,'Tan Binh, Ho Chi Minh, VN','0977782714','default@gmail.com',2,1,NULL,NULL,NULL,NULL),(16,'STUDENT000016','Nguyễn Kết','219654789','1999-12-12',1,'Tan Binh, Ho Chi Minh, VN','0165165165','default@gmail.com',2,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_class`
--

DROP TABLE IF EXISTS `student_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` int(11) DEFAULT NULL,
  `class` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusTuition` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class`
--

LOCK TABLES `student_class` WRITE;
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES (41,1,4,1,1),(42,2,4,1,1),(43,3,4,1,1),(44,4,4,1,1),(45,5,4,1,1),(46,6,5,1,1),(47,7,5,1,0),(48,8,5,1,0),(49,9,5,1,0),(50,10,5,1,0),(51,11,6,1,0),(52,12,6,1,0),(53,13,6,1,0),(54,14,6,1,0),(55,15,6,1,0);
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timework`
--

DROP TABLE IF EXISTS `timework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `employee` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=484 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timework`
--

LOCK TABLES `timework` WRITE;
/*!40000 ALTER TABLE `timework` DISABLE KEYS */;
INSERT INTO `timework` VALUES (1,'2019-12-30',1,1,1),(2,'2019-12-30',12,1,1),(3,'2019-12-30',13,1,1),(4,'2019-12-30',2,2,0),(5,'2019-12-30',14,2,0),(6,'2019-12-30',15,2,1),(7,'2019-12-30',16,2,1),(8,'2019-12-30',17,2,1),(9,'2019-12-30',18,2,1),(10,'2019-12-29',2,2,0),(11,'2019-12-29',14,2,0),(12,'2019-12-29',15,2,0),(13,'2019-12-29',16,2,0),(14,'2019-12-29',17,2,0),(15,'2019-12-29',18,2,0),(16,'2019-12-28',2,2,1),(17,'2019-12-28',14,2,1),(18,'2019-12-28',15,2,1),(19,'2019-12-28',16,2,1),(20,'2019-12-28',17,2,1),(21,'2019-12-28',18,2,1),(22,'2019-12-27',2,2,1),(23,'2019-12-27',14,2,1),(24,'2019-12-27',15,2,1),(25,'2019-12-27',16,2,1),(26,'2019-12-27',17,2,1),(27,'2019-12-27',18,2,1),(28,'2019-12-26',2,2,1),(29,'2019-12-26',14,2,1),(30,'2019-12-26',15,2,1),(31,'2019-12-26',16,2,1),(32,'2019-12-26',17,2,1),(33,'2019-12-26',18,2,1),(34,'2019-12-25',2,2,1),(35,'2019-12-25',14,2,1),(36,'2019-12-25',15,2,1),(37,'2019-12-25',16,2,1),(38,'2019-12-25',17,2,1),(39,'2019-12-25',18,2,1),(40,'2019-12-24',2,2,1),(41,'2019-12-24',14,2,1),(42,'2019-12-24',15,2,1),(43,'2019-12-24',16,2,1),(44,'2019-12-24',17,2,1),(45,'2019-12-24',18,2,1),(46,'2019-12-23',2,2,1),(47,'2019-12-23',14,2,1),(48,'2019-12-23',15,2,1),(49,'2019-12-23',16,2,1),(50,'2019-12-23',17,2,1),(51,'2019-12-23',18,2,1),(52,'2019-12-22',2,2,1),(53,'2019-12-22',14,2,1),(54,'2019-12-22',15,2,1),(55,'2019-12-22',16,2,1),(56,'2019-12-22',17,2,1),(57,'2019-12-22',18,2,1),(58,'2019-12-21',2,2,1),(59,'2019-12-21',14,2,1),(60,'2019-12-21',15,2,1),(61,'2019-12-21',16,2,1),(62,'2019-12-21',17,2,1),(63,'2019-12-21',18,2,1),(64,'2019-12-20',2,2,1),(65,'2019-12-20',14,2,1),(66,'2019-12-20',15,2,1),(67,'2019-12-20',16,2,1),(68,'2019-12-20',17,2,1),(69,'2019-12-20',18,2,1),(70,'2019-12-19',2,2,1),(71,'2019-12-19',14,2,1),(72,'2019-12-19',15,2,1),(73,'2019-12-19',16,2,1),(74,'2019-12-19',17,2,1),(75,'2019-12-19',18,2,1),(76,'2019-12-18',2,2,1),(77,'2019-12-18',14,2,1),(78,'2019-12-18',15,2,1),(79,'2019-12-18',16,2,1),(80,'2019-12-18',17,2,1),(81,'2019-12-18',18,2,1),(82,'2019-12-17',2,2,1),(83,'2019-12-17',14,2,1),(84,'2019-12-17',15,2,1),(85,'2019-12-17',16,2,1),(86,'2019-12-17',17,2,1),(87,'2019-12-17',18,2,1),(88,'2019-12-16',2,2,1),(89,'2019-12-16',14,2,1),(90,'2019-12-16',15,2,1),(91,'2019-12-16',16,2,1),(92,'2019-12-16',17,2,1),(93,'2019-12-16',18,2,1),(94,'2019-12-15',2,2,1),(95,'2019-12-15',14,2,1),(96,'2019-12-15',15,2,1),(97,'2019-12-15',16,2,1),(98,'2019-12-15',17,2,1),(99,'2019-12-15',18,2,1),(100,'2019-12-14',2,2,1),(101,'2019-12-14',14,2,1),(102,'2019-12-14',15,2,1),(103,'2019-12-14',16,2,1),(104,'2019-12-14',17,2,1),(105,'2019-12-14',18,2,1),(106,'2019-12-13',2,2,1),(107,'2019-12-13',14,2,1),(108,'2019-12-13',15,2,1),(109,'2019-12-13',16,2,1),(110,'2019-12-13',17,2,1),(111,'2019-12-13',18,2,1),(112,'2019-12-12',2,2,1),(113,'2019-12-12',14,2,1),(114,'2019-12-12',15,2,1),(115,'2019-12-12',16,2,1),(116,'2019-12-12',17,2,1),(117,'2019-12-12',18,2,1),(118,'2019-12-11',2,2,1),(119,'2019-12-11',14,2,1),(120,'2019-12-11',15,2,1),(121,'2019-12-11',16,2,1),(122,'2019-12-11',17,2,1),(123,'2019-12-11',18,2,1),(124,'2019-12-10',2,2,1),(125,'2019-12-10',14,2,1),(126,'2019-12-10',15,2,1),(127,'2019-12-10',16,2,1),(128,'2019-12-10',17,2,1),(129,'2019-12-10',18,2,1),(130,'2019-12-09',2,2,1),(131,'2019-12-09',14,2,1),(132,'2019-12-09',15,2,1),(133,'2019-12-09',16,2,1),(134,'2019-12-09',17,2,1),(135,'2019-12-09',18,2,1),(136,'2019-12-08',2,2,1),(137,'2019-12-08',14,2,1),(138,'2019-12-08',15,2,1),(139,'2019-12-08',16,2,1),(140,'2019-12-08',17,2,1),(141,'2019-12-08',18,2,1),(142,'2019-12-07',2,2,1),(143,'2019-12-07',14,2,1),(144,'2019-12-07',15,2,1),(145,'2019-12-07',16,2,1),(146,'2019-12-07',17,2,1),(147,'2019-12-07',18,2,1),(148,'2019-12-06',2,2,1),(149,'2019-12-06',14,2,1),(150,'2019-12-06',15,2,1),(151,'2019-12-06',16,2,1),(152,'2019-12-06',17,2,1),(153,'2019-12-06',18,2,1),(154,'2019-12-05',2,2,1),(155,'2019-12-05',14,2,1),(156,'2019-12-05',15,2,1),(157,'2019-12-05',16,2,1),(158,'2019-12-05',17,2,1),(159,'2019-12-05',18,2,1),(160,'2019-12-04',2,2,1),(161,'2019-12-04',14,2,1),(162,'2019-12-04',15,2,1),(163,'2019-12-04',16,2,1),(164,'2019-12-04',17,2,1),(165,'2019-12-04',18,2,1),(166,'2019-12-03',2,2,1),(167,'2019-12-03',14,2,1),(168,'2019-12-03',15,2,1),(169,'2019-12-03',16,2,1),(170,'2019-12-03',17,2,1),(171,'2019-12-03',18,2,1),(172,'2019-12-02',2,2,1),(173,'2019-12-02',14,2,1),(174,'2019-12-02',15,2,1),(175,'2019-12-02',16,2,1),(176,'2019-12-02',17,2,1),(177,'2019-12-02',18,2,1),(178,'2019-12-01',2,2,1),(179,'2019-12-01',14,2,1),(180,'2019-12-01',15,2,1),(181,'2019-12-01',16,2,1),(182,'2019-12-01',17,2,1),(183,'2019-12-01',18,2,1),(184,'2020-01-01',2,2,1),(185,'2020-01-01',14,2,1),(186,'2020-01-01',15,2,1),(187,'2020-01-01',16,2,1),(188,'2020-01-01',17,2,1),(189,'2020-01-01',18,2,1),(190,'2020-01-02',2,2,1),(191,'2020-01-02',14,2,1),(192,'2020-01-02',15,2,1),(193,'2020-01-02',16,2,1),(194,'2020-01-02',17,2,1),(195,'2020-01-02',18,2,1),(196,'2020-01-03',2,2,1),(197,'2020-01-03',14,2,1),(198,'2020-01-03',15,2,1),(199,'2020-01-03',16,2,1),(200,'2020-01-03',17,2,1),(201,'2020-01-03',18,2,1),(202,'2020-01-04',2,2,1),(203,'2020-01-04',14,2,1),(204,'2020-01-04',15,2,1),(205,'2020-01-04',16,2,1),(206,'2020-01-04',17,2,1),(207,'2020-01-04',18,2,1),(208,'2020-01-05',2,2,1),(209,'2020-01-05',14,2,1),(210,'2020-01-05',15,2,1),(211,'2020-01-05',16,2,1),(212,'2020-01-05',17,2,1),(213,'2020-01-05',18,2,1),(214,'2020-01-06',2,2,1),(215,'2020-01-06',14,2,1),(216,'2020-01-06',15,2,1),(217,'2020-01-06',16,2,1),(218,'2020-01-06',17,2,1),(219,'2020-01-06',18,2,1),(220,'2020-01-07',2,2,1),(221,'2020-01-07',14,2,1),(222,'2020-01-07',15,2,1),(223,'2020-01-07',16,2,1),(224,'2020-01-07',17,2,1),(225,'2020-01-07',18,2,1),(226,'2019-12-01',3,3,1),(227,'2019-12-01',19,3,1),(228,'2019-12-01',20,3,1),(229,'2019-12-01',21,3,1),(230,'2019-12-01',22,3,1),(231,'2019-12-01',23,3,1),(232,'2019-12-02',3,3,1),(233,'2019-12-02',19,3,1),(234,'2019-12-02',20,3,1),(235,'2019-12-02',21,3,1),(236,'2019-12-02',22,3,1),(237,'2019-12-02',23,3,1),(238,'2019-12-03',3,3,1),(239,'2019-12-03',19,3,1),(240,'2019-12-03',20,3,1),(241,'2019-12-03',21,3,1),(242,'2019-12-03',22,3,1),(243,'2019-12-03',23,3,1),(244,'2019-12-04',3,3,1),(245,'2019-12-04',19,3,1),(246,'2019-12-04',20,3,1),(247,'2019-12-04',21,3,1),(248,'2019-12-04',22,3,1),(249,'2019-12-04',23,3,1),(250,'2019-12-05',3,3,1),(251,'2019-12-05',19,3,1),(252,'2019-12-05',20,3,1),(253,'2019-12-05',21,3,1),(254,'2019-12-05',22,3,1),(255,'2019-12-05',23,3,1),(256,'2019-12-06',3,3,1),(257,'2019-12-06',19,3,1),(258,'2019-12-06',20,3,1),(259,'2019-12-06',21,3,1),(260,'2019-12-06',22,3,1),(261,'2019-12-06',23,3,1),(262,'2019-12-07',3,3,1),(263,'2019-12-07',19,3,1),(264,'2019-12-07',20,3,1),(265,'2019-12-07',21,3,1),(266,'2019-12-07',22,3,1),(267,'2019-12-07',23,3,1),(268,'2019-12-08',3,3,1),(269,'2019-12-08',19,3,1),(270,'2019-12-08',20,3,1),(271,'2019-12-08',21,3,1),(272,'2019-12-08',22,3,1),(273,'2019-12-08',23,3,1),(274,'2019-12-09',3,3,1),(275,'2019-12-09',19,3,1),(276,'2019-12-09',20,3,1),(277,'2019-12-09',21,3,1),(278,'2019-12-09',22,3,1),(279,'2019-12-09',23,3,1),(280,'2019-12-10',3,3,1),(281,'2019-12-10',19,3,1),(282,'2019-12-10',20,3,1),(283,'2019-12-10',21,3,1),(284,'2019-12-10',22,3,1),(285,'2019-12-10',23,3,1),(286,'2019-12-11',3,3,1),(287,'2019-12-11',19,3,1),(288,'2019-12-11',20,3,1),(289,'2019-12-11',21,3,1),(290,'2019-12-11',22,3,1),(291,'2019-12-11',23,3,1),(292,'2019-12-12',3,3,1),(293,'2019-12-12',19,3,1),(294,'2019-12-12',20,3,1),(295,'2019-12-12',21,3,1),(296,'2019-12-12',22,3,1),(297,'2019-12-12',23,3,1),(298,'2019-12-13',3,3,1),(299,'2019-12-13',19,3,1),(300,'2019-12-13',20,3,1),(301,'2019-12-13',21,3,1),(302,'2019-12-13',22,3,1),(303,'2019-12-13',23,3,1),(304,'2019-12-14',3,3,1),(305,'2019-12-14',19,3,1),(306,'2019-12-14',20,3,1),(307,'2019-12-14',21,3,1),(308,'2019-12-14',22,3,1),(309,'2019-12-14',23,3,1),(310,'2019-12-15',3,3,1),(311,'2019-12-15',19,3,1),(312,'2019-12-15',20,3,1),(313,'2019-12-15',21,3,1),(314,'2019-12-15',22,3,1),(315,'2019-12-15',23,3,1),(316,'2019-12-16',3,3,1),(317,'2019-12-16',19,3,1),(318,'2019-12-16',20,3,1),(319,'2019-12-16',21,3,1),(320,'2019-12-16',22,3,1),(321,'2019-12-16',23,3,1),(322,'2019-12-17',3,3,1),(323,'2019-12-17',19,3,1),(324,'2019-12-17',20,3,1),(325,'2019-12-17',21,3,1),(326,'2019-12-17',22,3,1),(327,'2019-12-17',23,3,1),(328,'2019-12-18',3,3,1),(329,'2019-12-18',19,3,1),(330,'2019-12-18',20,3,1),(331,'2019-12-18',21,3,1),(332,'2019-12-18',22,3,1),(333,'2019-12-18',23,3,1),(334,'2019-12-19',3,3,1),(335,'2019-12-19',19,3,1),(336,'2019-12-19',20,3,1),(337,'2019-12-19',21,3,1),(338,'2019-12-19',22,3,1),(339,'2019-12-19',23,3,1),(340,'2019-12-20',3,3,1),(341,'2019-12-20',19,3,1),(342,'2019-12-20',20,3,1),(343,'2019-12-20',21,3,1),(344,'2019-12-20',22,3,1),(345,'2019-12-20',23,3,1),(346,'2019-12-21',3,3,1),(347,'2019-12-21',19,3,1),(348,'2019-12-21',20,3,1),(349,'2019-12-21',21,3,1),(350,'2019-12-21',22,3,1),(351,'2019-12-21',23,3,1),(352,'2019-12-22',3,3,1),(353,'2019-12-22',19,3,1),(354,'2019-12-22',20,3,1),(355,'2019-12-22',21,3,1),(356,'2019-12-22',22,3,1),(357,'2019-12-22',23,3,1),(358,'2019-12-23',3,3,1),(359,'2019-12-23',19,3,1),(360,'2019-12-23',20,3,1),(361,'2019-12-23',21,3,1),(362,'2019-12-23',22,3,1),(363,'2019-12-23',23,3,1),(364,'2019-12-24',3,3,1),(365,'2019-12-24',19,3,1),(366,'2019-12-24',20,3,1),(367,'2019-12-24',21,3,1),(368,'2019-12-24',22,3,1),(369,'2019-12-24',23,3,1),(370,'2019-12-25',3,3,1),(371,'2019-12-25',19,3,1),(372,'2019-12-25',20,3,1),(373,'2019-12-25',21,3,1),(374,'2019-12-25',22,3,1),(375,'2019-12-25',23,3,1),(376,'2019-12-26',3,3,1),(377,'2019-12-26',19,3,1),(378,'2019-12-26',20,3,1),(379,'2019-12-26',21,3,1),(380,'2019-12-26',22,3,1),(381,'2019-12-26',23,3,1),(382,'2019-12-27',3,3,1),(383,'2019-12-27',19,3,1),(384,'2019-12-27',20,3,1),(385,'2019-12-27',21,3,1),(386,'2019-12-27',22,3,1),(387,'2019-12-27',23,3,1),(388,'2019-12-28',3,3,1),(389,'2019-12-28',19,3,1),(390,'2019-12-28',20,3,1),(391,'2019-12-28',21,3,1),(392,'2019-12-28',22,3,1),(393,'2019-12-28',23,3,1),(394,'2019-12-29',3,3,1),(395,'2019-12-29',19,3,1),(396,'2019-12-29',20,3,1),(397,'2019-12-29',21,3,1),(398,'2019-12-29',22,3,1),(399,'2019-12-29',23,3,1),(400,'2019-11-30',3,3,1),(401,'2019-11-30',19,3,1),(402,'2019-11-30',20,3,1),(403,'2019-11-30',21,3,1),(404,'2019-11-30',22,3,1),(405,'2019-11-30',23,3,1),(406,'2019-12-31',3,3,1),(407,'2019-12-31',19,3,1),(408,'2019-12-31',20,3,1),(409,'2019-12-31',21,3,1),(410,'2019-12-31',22,3,1),(411,'2019-12-31',23,3,1),(412,'2020-01-01',3,3,1),(413,'2020-01-01',19,3,1),(414,'2020-01-01',20,3,1),(415,'2020-01-01',21,3,1),(416,'2020-01-01',22,3,1),(417,'2020-01-01',23,3,1),(418,'2019-12-31',3,3,1),(419,'2019-12-31',19,3,1),(420,'2019-12-31',20,3,1),(421,'2019-12-31',21,3,1),(422,'2019-12-31',22,3,1),(423,'2019-12-31',23,3,1),(424,'2019-12-30',3,3,1),(425,'2019-12-30',19,3,1),(426,'2019-12-30',20,3,1),(427,'2019-12-30',21,3,1),(428,'2019-12-30',22,3,1),(429,'2019-12-30',23,3,1),(430,'2019-12-31',3,3,1),(431,'2019-12-31',19,3,1),(432,'2019-12-31',20,3,1),(433,'2019-12-31',21,3,1),(434,'2019-12-31',22,3,1),(435,'2019-12-31',23,3,1),(436,'2020-01-01',3,3,1),(437,'2020-01-01',19,3,1),(438,'2020-01-01',20,3,1),(439,'2020-01-01',21,3,1),(440,'2020-01-01',22,3,1),(441,'2020-01-01',23,3,1),(442,'2020-01-02',3,3,1),(443,'2020-01-02',19,3,1),(444,'2020-01-02',20,3,1),(445,'2020-01-02',21,3,1),(446,'2020-01-02',22,3,1),(447,'2020-01-02',23,3,1),(448,'2020-01-03',3,3,1),(449,'2020-01-03',19,3,1),(450,'2020-01-03',20,3,1),(451,'2020-01-03',21,3,1),(452,'2020-01-03',22,3,1),(453,'2020-01-03',23,3,1),(454,'2020-01-04',3,3,1),(455,'2020-01-04',19,3,1),(456,'2020-01-04',20,3,1),(457,'2020-01-04',21,3,1),(458,'2020-01-04',22,3,1),(459,'2020-01-04',23,3,1),(460,'2020-01-05',3,3,1),(461,'2020-01-05',19,3,1),(462,'2020-01-05',20,3,1),(463,'2020-01-05',21,3,1),(464,'2020-01-05',22,3,1),(465,'2020-01-05',23,3,1),(466,'2020-01-06',3,3,1),(467,'2020-01-06',19,3,1),(468,'2020-01-06',20,3,1),(469,'2020-01-06',21,3,1),(470,'2020-01-06',22,3,1),(471,'2020-01-06',23,3,1),(472,'2020-01-07',3,3,1),(473,'2020-01-07',19,3,1),(474,'2020-01-07',20,3,1),(475,'2020-01-07',21,3,1),(476,'2020-01-07',22,3,1),(477,'2020-01-07',23,3,1),(478,'2019-12-31',2,2,1),(479,'2019-12-31',14,2,1),(480,'2019-12-31',15,2,1),(481,'2019-12-31',16,2,1),(482,'2019-12-31',17,2,1),(483,'2019-12-31',18,2,1);
/*!40000 ALTER TABLE `timework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuition`
--

DROP TABLE IF EXISTS `tuition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentClass` int(11) DEFAULT NULL,
  `totalMoney` mediumtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuition`
--

LOCK TABLES `tuition` WRITE;
/*!40000 ALTER TABLE `tuition` DISABLE KEYS */;
INSERT INTO `tuition` VALUES (1,41,'1400000','2019-12-30 23:52:41',2,2),(2,42,'1400000','2019-12-30 23:53:51',2,2),(3,43,'1400000','2019-12-30 23:54:20',2,2),(4,44,'1500000','2019-12-30 23:55:52',2,2),(5,45,'1500000','2019-12-30 23:56:10',2,2),(6,46,'1000000','2020-01-07 22:15:00',2,2);
/*!40000 ALTER TABLE `tuition` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-07 22:17:28
