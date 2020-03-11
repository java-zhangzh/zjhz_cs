/*
SQLyog Ultimate v9.20 
MySQL - 5.7.17-log : Database - zjhz_cs_platform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zjhz_cs_platform` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

/*Table structure for table `zjhz_base_airport` */

DROP TABLE IF EXISTS `zjhz_base_airport`;

CREATE TABLE `zjhz_base_airport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lon` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lat` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `of_add` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `size` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `regional` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_enable` int(11) DEFAULT '1',
  `is_deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_base_airport` */

insert  into `zjhz_base_airport`(`id`,`cname`,`ename`,`area`,`lon`,`lat`,`address`,`of_add`,`size`,`regional`,`description`,`create_user`,`create_date`,`update_user`,`update_date`,`is_enable`,`is_deleted`) values (1,'长沙黄花国际机场','cshhgjjc','20','113.234025','28.19213','长沙市长沙县黄花镇机场大道','湖南省长沙市','28','12','长沙黄花国际机场',1,'2019-12-25 22:00:17',1,'2019-12-25 22:00:22',1,0);

/*Table structure for table `zjhz_base_bus_station` */

DROP TABLE IF EXISTS `zjhz_base_bus_station`;

CREATE TABLE `zjhz_base_bus_station` (
  `id` int(11) NOT NULL,
  `cname` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ename` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lon` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lat` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `of_add` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `size` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `regional` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_enable` int(11) DEFAULT '1',
  `is_deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_base_bus_station` */

/*Table structure for table `zjhz_base_entrepot` */

DROP TABLE IF EXISTS `zjhz_base_entrepot`;

CREATE TABLE `zjhz_base_entrepot` (
  `id` int(11) NOT NULL,
  `cname` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ename` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lon` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lat` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `of_add` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `size` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `regional` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_enable` int(11) DEFAULT '1',
  `is_deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_base_entrepot` */

/*Table structure for table `zjhz_base_roadnet_info` */

DROP TABLE IF EXISTS `zjhz_base_roadnet_info`;

CREATE TABLE `zjhz_base_roadnet_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `end_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curr_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `link_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roadnet_type_id` int(11) DEFAULT NULL,
  `region` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lenth` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direction` int(11) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_enabled` int(11) DEFAULT NULL,
  `is_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_base_roadnet_info` */

/*Table structure for table `zjhz_base_roadnet_type` */

DROP TABLE IF EXISTS `zjhz_base_roadnet_type`;

CREATE TABLE `zjhz_base_roadnet_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_enable` int(2) DEFAULT '1',
  `is_deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_base_roadnet_type` */

insert  into `zjhz_base_roadnet_type`(`id`,`name`,`description`,`create_user`,`create_date`,`update_user`,`update_date`,`is_enable`,`is_deleted`) values (1,'高速公路','高速公路',1,'2019-12-06 16:48:21','1','2019-12-06 16:48:21',1,0),(2,'国省干道','国省干道',1,'2019-12-06 16:48:21','1','2019-12-06 16:48:21',1,0),(3,'通景公路','通景公路',1,'2019-12-06 16:48:21','1','2019-12-06 16:48:21',1,0);

/*Table structure for table `zjhz_base_train` */

DROP TABLE IF EXISTS `zjhz_base_train`;

CREATE TABLE `zjhz_base_train` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `cn_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '火车站中文名',
  `en_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '火车站英文名',
  `lon` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '精度',
  `lat` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '纬度',
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `create_user` int(6) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` int(6) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_base_train` */

insert  into `zjhz_base_train`(`id`,`cn_name`,`en_name`,`lon`,`lat`,`address`,`description`,`create_user`,`create_date`,`update_user`,`update_date`,`is_deleted`) values (1,'上沙南站','changshasrouthstation','113.070174','28.152390','湖南省长沙市长沙南站','长沙南站',1,'2019-12-03 10:09:53',1,'2019-12-03 10:10:00',0),(2,'湘潭北站','xiangtanbeizhan','112.951166','27.969801','湖南省长沙市湘潭北站','湘潭北站',1,'2019-12-03 10:09:53',1,'2019-12-03 10:10:00',0),(3,'长沙西站','csxz','112.833884','28.267494','湖南省长沙市长沙西站','长沙西站',1,'2019-12-03 10:09:53',1,'2019-12-03 10:10:00',0);

/*Table structure for table `zjhz_sys_role` */

DROP TABLE IF EXISTS `zjhz_sys_role`;

CREATE TABLE `zjhz_sys_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色描述',
  `create_user` int(8) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` int(8) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_sys_role` */

/*Table structure for table `zjhz_sys_user` */

DROP TABLE IF EXISTS `zjhz_sys_user`;

CREATE TABLE `zjhz_sys_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '盐',
  `nick_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` int(2) DEFAULT '0' COMMENT '性别：0：男，1：女',
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `user_logo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像',
  `create_user` int(8) DEFAULT NULL COMMENT '创建renId',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` int(8) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否删除 0：否 1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_sys_user` */

insert  into `zjhz_sys_user`(`id`,`user_name`,`password`,`salt`,`nick_name`,`sex`,`phone`,`user_logo`,`create_user`,`create_date`,`update_user`,`update_date`,`is_deleted`) values (1,'zzh','2dd231443b373e4c9506906edd32041a','123456','张忠豪',0,'15510372203','http://test.png',NULL,NULL,NULL,NULL,0);

/*Table structure for table `zjhz_sys_user_role` */

DROP TABLE IF EXISTS `zjhz_sys_user_role`;

CREATE TABLE `zjhz_sys_user_role` (
  `user_id` int(8) DEFAULT NULL COMMENT '用户id',
  `role_id` int(8) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zjhz_sys_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
