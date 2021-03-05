-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: qlsv
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `sinhvien`
--
DROP DATABASE IF EXISTS `qlsv`;
create database qlsv;
use qlsv;

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `MaSV` int NOT NULL,
  `Ten` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Ngaysinh` date NOT NULL,
  `Quequan` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Hokhau` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DiemTB` float NOT NULL,
  `Khoa` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Gioitinh` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaSV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AVG_ROW_LENGTH=2340;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (102180238,'Huỳnh Đức Anh','2000-01-01','Da Nang','Da Nang',9,'CNTT','Nam'),(102180243,'Nguyễn Thanh Dũng','2000-03-02','Hue','Thua Thien Hue',8,'Môi trường','Nam'),(102180265,'Phạm Thị Quỳnh Như','2000-06-01','Thanh Hoa','Da Nang',9,'Kiến trúc','Nữ'),(102180266,'Lê Cảnh Kiều Oanh','2000-12-10','Quang Tri','Dong Ha',8,'Hóa','Nữ'),(102180269,'Phạm Văn Tánh','2000-02-01','Hue','Da Nang',9,'CNTT','Nam'),(102180281,'Hoàng Thị Xoan','2000-06-12','Nghe An','Da Nang',8,'Điện tử viễn thông','Nữ'),(102180282,'Lê Thùy Như Ý','2000-02-12','Da Nang','Da Nang',9,'Hóa','Nữ');
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlsv'
--

--
-- Dumping routines for database 'qlsv'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-16 18:26:01
