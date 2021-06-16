-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: deco
-- ------------------------------------------------------
-- Server version	5.7.33-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_num` int(11) NOT NULL AUTO_INCREMENT COMMENT 'USER_NUM',
  `email` varchar(45) NOT NULL COMMENT 'EMAIL(UK)',
  `pw` varchar(45) NOT NULL COMMENT 'PW',
  `pre_pw` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL COMMENT 'NAME',
  `nickname` varchar(45) NOT NULL COMMENT 'NICKNAME',
  `addr` varchar(45) NOT NULL COMMENT 'ADDR',
  `phone` varchar(45) NOT NULL COMMENT 'PHONE',
  `major` varchar(45) NOT NULL COMMENT 'MAJOR',
  `inter` varchar(45) DEFAULT NULL COMMENT 'INTER',
  `create_at` date NOT NULL COMMENT 'CreateAt',
  `last_login` date NOT NULL COMMENT 'LASTLOGIN',
  `change_pw` date DEFAULT NULL,
  `private_user` int(11) NOT NULL COMMENT 'private_user',
  `point` int(11) DEFAULT NULL COMMENT 'Point',
  `admin_auth` int(11) DEFAULT NULL COMMENT 'admin',
  PRIMARY KEY (`user_num`),
  UNIQUE KEY `user_email_uk` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'rnrudxo','123','2020-04-12','koo','koo','1234','124','koo','213','2020-04-12','2020-04-12','2020-04-12',1,123,1),(2,'2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12','2020-04-12',2,412,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'deco'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-15 23:32:23
