CREATE DATABASE  IF NOT EXISTS `booking-v3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `booking-v3`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: booking-v3
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `idimage` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `url` varchar(252) NOT NULL,
  `description` text,
  `product_idproduct` int NOT NULL,
  PRIMARY KEY (`idimage`),
  KEY `fk_image_product1_idx` (`product_idproduct`),
  CONSTRAINT `fk_image_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'Novotel Buenos Aires','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/1-Habitacion+NOVOTEL.jpg','Hermosa habitacion',1),(2,'Novotel Buenos Aires','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/1-Hotel+NOVOTEL.jpg','Imagen del hotel',1),(3,'Novotel Buenos Aires','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/1-Desayuno+NOVOTEL.jpg','Imagen del desayuno',1),(4,'Novotel Buenos Aires','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/1-Pileta+NOVOTEL.jpg','Imagen de la pileta',1),(5,'Novotel Buenos Aires','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/1-Ba%C3%B1o+NOVOTEL.jpg','Imagen del baño',1),(6,'Nido del Cóndor Hotel & Spa','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/2-Habitacion+NIDO.jpg','Imagen del hotel',2),(7,'Nido del Cóndor Hotel & Spa','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/2-Hotel+NIDO.jpg','Imagen del hotel',2),(8,'Nido del Cóndor Hotel & Spa','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/2-Desayuno+NIDO.jpg','Imagen del hotel',2),(9,'Nido del Cóndor Hotel & Spa','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/2-Pileta+NIDO.jpg','Imagen del hotel',2),(10,'Nido del Cóndor Hotel & Spa','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/2-Ba%C3%B1o+NIDO.jpg','Imagen del hotel',2),(11,'Hostel Carlos Gardel','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/3-Habitacion+HOSTEL.jpg','Imagen del hotel',3),(12,'Hostel Carlos Gardel','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/3-Hotel+HOSTEL.jpgg','Imagen del hotel',3),(13,'Hostel Carlos Gardel','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/3-Desayuno+HOSTEL.jpg','Imagen del hotel',3),(14,'Hostel Carlos Gardel','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/3-Pileta+HOSTEL.jpg','Imagen del hotel',3),(15,'Hostel Carlos Gardel','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/3-Ba%C3%B1o+HOSTEL.jpg','Imagen del hotel',3),(16,'KM SUN HOSTEL','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/4-Habitacion+KM+SUN.jpg','Imagen del hotel',4),(17,'KM SUN HOSTEL','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/4-Hotel+KM+SUN.jpg','Imagen del hotel',4),(18,'KM SUN HOSTEL','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/4-Desayuno+KM+SUN.jpg','Imagen del hotel',4),(19,'KM SUN HOSTEL','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/4-Pileta+KM+SUN.jpg','Imagen del hotel',4),(20,'KM SUN HOSTEL','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/4-Ba%C3%B1o+KM+SUN.jpgg','Imagen del hotel',4),(21,'CALCHAQUÍ 6','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/5-Habitacion+CALCHAQUI.jpg','Imagen del hotel',5),(22,'CALCHAQUÍ 6','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/5-Hotel+CALCHAQUI.jpg','Imagen del hotel',5),(23,'CALCHAQUÍ 6','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/5-Desayuno+CALCHAQUI.jpg','Imagen del hotel',5),(24,'CALCHAQUÍ 6','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/5-Pileta+CALCHAQUI.jpg','Imagen del hotel',5),(25,'CALCHAQUÍ 6','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/5-Ba%C3%B1o+CALCHAQUI.jpg','Imagen del hotel',5),(26,'El Porvenir Casa de Bodega','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/6-Habitacion+EL+PORVENIR.jpg','Imagen del hotel',6),(27,'El Porvenir Casa de Bodega','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/6-Hotel+EL+PORVENIR.jpg','Imagen del hotel',6),(28,'El Porvenir Casa de Bodega','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/6-Desayuno+EL+PORVENIR.jpg','Imagen del hotel',6),(29,'El Porvenir Casa de Bodega','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/6-Pileta+EL+PORVENIR.jpg','Imagen del hotel',6),(30,'El Porvenir Casa de Bodega','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/6-Ba%C3%B1o+EL+PORVENIR.jpg','Imagen del hotel',6),(31,'Posta de Purmamarca','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/7-Habitacion+POSTA+DE+PURMAMARCA.jpg','Imagen del hotel',7),(32,'Posta de Purmamarca','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/7-Hotel+POSTA+DE+PURMAMARCA.jpg','Imagen del hotel',7),(33,'Posta de Purmamarca','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/7-Desayuno+POSTA+DE+PURMAMARCA.jpg','Imagen del hotel',7),(34,'Posta de Purmamarca','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/7-Pileta+POSTA+DE+PURMAMARCA.jpg','Imagen del hotel',7),(35,'Posta de Purmamarca','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/7-Ba%C3%B1o+POSTA+DE+PURMAMARCA.jpg','Imagen del hotel',7),(36,'Tierra Virgen Apartments','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/habitacion/8-Habitacion+TIERRA.jpg','Imagen del hotel',8),(37,'Tierra Virgen Apartments','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/hotel/8-Hotel+TIERRA.jpg','Imagen del hotel',8),(38,'Tierra Virgen Apartments','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/desayuno/8-Desayuno+TIERRA.jpg','Imagen del hotel',8),(39,'Tierra Virgen Apartments','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/pileta/8-Pileta+TIERRA.jpg','Imagen del hotel',8),(40,'Tierra Virgen Apartments','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/ba%C3%B1o/8-Ba%C3%B1o+TIERRA.jpg','Imagen del hotel',8);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-24 18:52:36
