CREATE DATABASE  IF NOT EXISTS `proyecto_final` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyecto_final`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto_final
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

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
-- Table structure for table `moto`
--

DROP TABLE IF EXISTS `moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) NOT NULL,
  `modelo` varchar(255) NOT NULL,
  `cilindrada` int NOT NULL,
  `caballos` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moto`
--

LOCK TABLES `moto` WRITE;
/*!40000 ALTER TABLE `moto` DISABLE KEYS */;
INSERT INTO `moto` VALUES (153,'Yamaha','R1',998,200),(154,'Honda','CBR600RR',599,120),(155,'Suzuki','GSX-R750',750,150),(156,'Kawasaki','ZX-10R',998,203),(157,'Ducati','Panigale V2',955,155),(158,'BMW','S1000RR',999,207),(159,'Aprilia','RSV4',1099,217),(160,'KTM','RC 8C',889,135),(161,'MV Agusta','F3 800',798,148),(162,'Triumph','Daytona 765',765,130),(163,'Yamaha','MT-09',890,115),(164,'Honda','CB500F',471,47),(165,'Kawasaki','Ninja 400',399,49),(166,'Suzuki','SV650',645,75),(167,'Ducati','Monster 937',937,111),(168,'BMW','R nineT',1170,109),(169,'Aprilia','Tuono 660',659,95),(170,'KTM','Duke 690',690,73),(171,'MV Agusta','Brutale 800',798,140),(172,'Triumph','Speed Triple 1200',1160,180);
/*!40000 ALTER TABLE `moto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moto_SEQ`
--

DROP TABLE IF EXISTS `moto_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moto_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moto_SEQ`
--

LOCK TABLES `moto_SEQ` WRITE;
/*!40000 ALTER TABLE `moto_SEQ` DISABLE KEYS */;
INSERT INTO `moto_SEQ` VALUES (251);
/*!40000 ALTER TABLE `moto_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piloto`
--

DROP TABLE IF EXISTS `piloto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piloto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `edad` int NOT NULL,
  `nacionalidad` varchar(255) NOT NULL,
  `escuderia` varchar(255) NOT NULL,
  `tiempo_vuelta` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piloto`
--

LOCK TABLES `piloto` WRITE;
/*!40000 ALTER TABLE `piloto` DISABLE KEYS */;
INSERT INTO `piloto` VALUES (3,'Marc Márquez',31,'España','Repsol Honda',91.25),(4,'Fabio Quartararo',25,'Francia','Monster Yamaha',90.87),(5,'Pecco Bagnaia',28,'Italia','Ducati Lenovo',90.1),(6,'Joan Mir',27,'España','Repsol Honda',91.5),(7,'Maverick Viñales',29,'España','Aprilia Racing',91.12),(8,'Enea Bastianini',26,'Italia','Ducati Lenovo',90.95),(9,'Aleix Espargaró',35,'España','Aprilia Racing',91.75),(10,'Jorge Martín',27,'España','Pramac Racing',90.2),(11,'Brad Binder',28,'Sudáfrica','Red Bull KTM',91),(12,'Jack Miller',30,'Australia','Red Bull KTM',90.8),(13,'Franco Morbidelli',29,'Italia','Monster Yamaha',91.4),(14,'Álex Rins',28,'España','LCR Honda',91.6),(15,'Johann Zarco',34,'Francia','LCR Honda',91.33),(16,'Takaaki Nakagami',33,'Japón','LCR Honda',91.9),(17,'Pol Espargaró',33,'España','Tech3 GasGas',91.7),(18,'Raúl Fernández',24,'España','Trackhouse Racing',91.55),(19,'Remy Gardner',26,'Australia','Yamaha RNF',92.1),(20,'Luca Marini',27,'Italia','Repsol Honda',91.15),(21,'Álex Márquez',29,'España','Gresini Ducati',91.05),(22,'Miguel Oliveira',30,'Portugal','Trackhouse Racing',90.85);
/*!40000 ALTER TABLE `piloto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piloto_SEQ`
--

DROP TABLE IF EXISTS `piloto_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piloto_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piloto_SEQ`
--

LOCK TABLES `piloto_SEQ` WRITE;
/*!40000 ALTER TABLE `piloto_SEQ` DISABLE KEYS */;
INSERT INTO `piloto_SEQ` VALUES (101);
/*!40000 ALTER TABLE `piloto_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piloto_moto`
--

DROP TABLE IF EXISTS `piloto_moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piloto_moto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_piloto` int NOT NULL,
  `id_moto` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_piloto` (`id_piloto`),
  KEY `id_moto` (`id_moto`),
  CONSTRAINT `piloto_moto_ibfk_1` FOREIGN KEY (`id_piloto`) REFERENCES `piloto` (`id`),
  CONSTRAINT `piloto_moto_ibfk_2` FOREIGN KEY (`id_moto`) REFERENCES `moto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piloto_moto`
--

LOCK TABLES `piloto_moto` WRITE;
/*!40000 ALTER TABLE `piloto_moto` DISABLE KEYS */;
INSERT INTO `piloto_moto` VALUES (27,3,153,'2024-01-01'),(28,4,154,'2024-01-02'),(29,5,155,'2024-01-03'),(30,6,156,'2024-01-04'),(31,7,157,'2024-01-05'),(32,8,158,'2024-01-06'),(33,9,159,'2024-01-07'),(34,10,160,'2024-01-08'),(35,11,161,'2024-01-09'),(36,12,162,'2024-01-10'),(37,13,163,'2024-01-11'),(38,14,164,'2024-01-12'),(39,15,165,'2024-01-13'),(40,16,166,'2024-01-14'),(41,17,167,'2024-01-15'),(42,18,168,'2024-01-16'),(43,19,169,'2024-01-17'),(44,20,170,'2024-01-18'),(45,21,171,'2024-01-19'),(46,22,172,'2024-01-20');
/*!40000 ALTER TABLE `piloto_moto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-05 23:31:57
