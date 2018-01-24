-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: mproducts
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `category` varchar(45) NOT NULL,
  `price` decimal(10,2) DEFAULT '0.00',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `currentStock` int(11) DEFAULT '0',
  `enable` varchar(45) DEFAULT '1' COMMENT '1 is true',
  `uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=ucs2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Pizza G','Main',13.00,'2017-07-03 14:44:43','2017-07-05 12:30:59',12,'1','dfdfd2323dds'),(2,'Cheese Burger','Main',7.00,'2017-07-03 14:46:30','2017-07-03 18:34:11',0,'1','fdfdfdffsf23232'),(3,'Family Pizza','Main',13.00,'2017-07-03 14:46:57','2017-07-06 04:41:38',0,'0','bddsds32'),(4,'Hot dog','Lunch',2.50,'2017-07-04 04:46:14','2017-07-04 04:46:14',1,'1','xcxcx2323'),(5,'Fish burger','Lunch',9.90,'2017-07-04 04:48:30','2017-07-04 04:48:30',10,'1','vcvcvxcww'),(6,'Beer A','Drinks',10.90,'2017-07-05 10:54:54','2017-07-06 07:14:33',12,'1','jhdskjhj8989'),(7,'Burger OP','Burger',10.90,'2017-07-05 10:58:07','2017-07-06 04:41:57',12,'1','vxvxcvcx'),(8,'Beer H','Drinks',10.90,'2017-07-05 11:00:07','2017-07-06 04:41:19',12,'1','bcvsdfv323'),(9,'Hot dog ','Break',10.90,'2017-07-05 11:01:42','2017-07-05 11:01:42',9023,'1','vdfsfdsfdf2323'),(10,'Burger KL','Burger',10.90,'2017-07-05 11:03:09','2017-07-05 11:03:09',12,'1','xfsfsfsdffs2323'),(11,'Burger KL','Burger',10.90,'2017-07-05 11:07:48','2017-07-05 12:47:32',12,'0','sjhajshajs223'),(12,'Burger FD','Burger',12.00,'2017-07-05 14:01:37','2017-07-05 14:01:37',45,'0','0fda33b0d7d24571ad1a750181a0b40a'),(13,'Hot dog TY','Hot dog',12.00,'2017-07-06 04:07:04','2017-07-06 04:07:04',10,'0','2c2ed1137c854ee6a558f9ed42456f1e');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-18 12:09:46
