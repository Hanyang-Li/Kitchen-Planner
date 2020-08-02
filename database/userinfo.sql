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

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`username`,`pass`,`phone`,`email`,`sex`) values (1,'Xin','oC31d70420B3d2/7A#d31*oCB56#0466','15745212036','1365dcsdf@163.com',NULL),(2,'caonima','*4o1A44d5C70/#605CdB04#*56124d/C','13598245023','dasdasda@163.com',NULL),(3,'dnmd','oCB6CC2B/C*7oBdAo/#5/10dAo#2*534','13498245023','adsqwdqw@qq.com',NULL),(4,'ustamu','0244d5o00/0A1763A7341o5A3o2A20#A','15784210235','adsadas@tamu.edu',NULL),(5,'laoba','13CCA15*BB5A#do/3034AB2B0340o#d7','15682374012','dasdasdas@hust.cn.edu',NULL),(6,'dawang','426A5257206C4o60B5d/70A5d16o/C1o','15927681023','111111@163.com',NULL),(7,'zhangsan','BdC*41710724o/6511Cd*#2C52416AA1','15826781023','sdsads@qq.com',NULL),(8,'lisi','1d53Bd60601dB3444130A04BCB526#7*','13485641023','dwrer@126.com',NULL),(9,'zhaoliu','112#536C5061405*d34dBC5ddo42024C','13547810234','sdfsdfsdf@163.com',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
