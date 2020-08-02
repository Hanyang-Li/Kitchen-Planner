/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.21 : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `library`;

/*Table structure for table `menutotag` */

DROP TABLE IF EXISTS `menutotag`;

CREATE TABLE `menutotag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menuid` int DEFAULT NULL,
  `tagid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `menutotag` */

insert  into `menutotag`(`id`,`menuid`,`tagid`) values (1,1,1),(2,1,7),(3,2,1),(4,2,7),(5,3,2),(6,3,1),(7,4,4),(8,5,4),(9,5,6),(10,6,9),(11,7,1),(12,7,7),(13,8,1),(14,8,7),(15,9,1),(16,9,7),(17,10,1),(18,10,7),(19,11,7),(20,12,3),(21,12,5),(22,13,4),(23,13,6),(24,14,9),(25,14,6),(26,15,6),(27,15,9),(28,16,5),(29,16,3),(30,17,5),(31,17,3),(32,18,3),(33,18,4),(34,19,3),(35,19,5),(36,20,7),(37,20,5),(38,21,7),(39,21,1),(40,22,3),(41,22,1),(42,23,5),(43,24,2),(44,24,1),(45,25,1),(46,25,7),(47,26,1),(48,26,7),(49,27,3),(50,27,5),(51,28,2),(52,28,1),(53,29,2),(54,29,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
