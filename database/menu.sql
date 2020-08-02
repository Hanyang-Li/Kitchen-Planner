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

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menuname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `authorid` int DEFAULT NULL,
  `jsonpath` varchar(100) DEFAULT NULL,
  `imgpath` varchar(100) DEFAULT NULL,
  `isad` int DEFAULT '0',
  `authorname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `menu` */

insert  into `menu`(`id`,`menuname`,`authorid`,`jsonpath`,`imgpath`,`isad`,`authorname`) values (1,'红烧牛肉',2,NULL,'1.png',1,'caonima'),(2,'青椒肉丝',3,NULL,'2.png',1,'dnmd'),(3,'红烧鲤鱼',2,NULL,'3.jpg',1,'caonima'),(4,'米酒',5,NULL,'4.jpg',1,'laoba'),(5,'燕窝粥',4,NULL,'5.jpg',1,'ustamu'),(6,'珍珠奶茶',6,NULL,'6.jpg',1,'dawang'),(7,'卤鸡腿',7,NULL,'7.jpg',1,'zhangsan'),(8,'卤肉',1,NULL,'8.jpg',1,'Xin'),(9,'炸鸡翅',3,NULL,'9.jpg',1,'dnmd'),(10,'夫妻肺片',8,NULL,'26.jpg',1,'lisi'),(11,'潮汕火锅',9,NULL,'033.jpg',1,'zhaoliu'),(12,'螺蛳粉',7,NULL,'124.png',1,'zhangsan'),(13,'白米粥',9,NULL,'138.png',1,'zhaoliu'),(14,'水果奶',6,NULL,'142.jpg',1,'dawang'),(15,'双皮奶',4,NULL,'152.png',1,'ustamu'),(16,'叉烧包',3,NULL,'IMG_0734.JPG',1,'dnmd'),(17,'小笼包',7,NULL,'IMG_1650.PNG',1,'zhangsan'),(18,'胡辣汤',2,NULL,'mcal1811-h.jpg',1,'caonima'),(19,'油条',5,NULL,'24.jpg',1,'laoba'),(20,'牛肉拉面',7,NULL,'mcal1811-h.jpg',1,'zhangsan'),(21,'猪肉粉条',5,NULL,'mcal1811-h.jpg',1,'laoba'),(22,'蒸苋菜',3,NULL,'mcal1811-h.jpg',1,'dnmd'),(23,'炒拉条',1,NULL,'mcal1811-h.jpg',1,'Xin'),(24,'油焖大虾',6,NULL,'mcal1811-h.jpg',1,'dawang'),(25,'糖醋排骨',7,NULL,'mcal1811-h.jpg',1,'zhangsan'),(26,'孜然羊肉',9,NULL,'mcal1811-h.jpg',1,'zhaoliu'),(27,'火烧馍',1,NULL,'mcal1811-h.jpg',1,'Xin'),(28,'炸鱿鱼',7,NULL,'mcal1811-h.jpg',1,'zhangsan'),(29,'大闸蟹',2,NULL,'mcal1811-h.jpg',1,'caonima');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
