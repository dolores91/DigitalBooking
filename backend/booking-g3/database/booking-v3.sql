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
-- Table structure for table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attribute` (
  `idattribute` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `icon` varchar(45) NOT NULL,
  PRIMARY KEY (`idattribute`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute`
--

LOCK TABLES `attribute` WRITE;
/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` VALUES (1,'Estacionamiento','Instalaciones','faParking'),(2,'Wifi Gratis','Conectividad','faWifi'),(3,'Spa','Instalaciones','faSpa'),(4,'Restaurante','Gastronomia','faUtensils'),(5,'Bar','Gastronomia','faMartiniGlass'),(6,'Pileta','Deporte y Recreacion','faPersonSwimming'),(7,'Desayuno','Gastronomia','faMugSaucer'),(8,'Ubicado frente a la playa','Ubicacion','faUmbrellaBeach'),(9,'Televisor','Conectividad','faTv'),(10,'Acepta Mascotas','Amiguitos','faPaw');
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `idbooking` int NOT NULL AUTO_INCREMENT,
  `checkin_date` date NOT NULL,
  `checkout_date` date NOT NULL,
  `checkin_time` float NOT NULL,
  `product_idproduct` int NOT NULL,
  `user_iduser` int NOT NULL,
  PRIMARY KEY (`idbooking`),
  KEY `fk_booking_product1_idx` (`product_idproduct`),
  KEY `fk_booking_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_booking_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`),
  CONSTRAINT `fk_booking_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2022-10-23','2022-10-25',1.5,2,2),(2,'2022-10-23','2022-11-23',1.3,1,1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `idcategory` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` varchar(1024) NOT NULL,
  `url` varchar(252) NOT NULL,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Hotel','Alquiler de habitaciones con alojamiento y servicio de comedor.','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/img/hoteles.png'),(2,'Hostel','Alquiler de habitaciones y baños compartidos. Cocina compartida.','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/img/hostels.png'),(3,'Departamento','Amplios y privados que pueden albergar familias completas con comodidades como sala, comedor y cocina','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/img/depto.png'),(4,'Bed & Breakfast','Small place which offers overnight accommodation and breakfast but no other meals','https://imagenes-camada3-grupo3.s3.us-east-2.amazonaws.com/img/bb.png');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `idcity` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`idcity`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Buenos Aires','Argentina'),(2,'San Carlos de Bariloche','Argentina'),(3,'Cafayate','Argentina'),(4,'Purmamarca','Argentina'),(5,'Rio Cuarto','Argentina'),(6,'Pergamino','Argentina'),(7,'Santa Fe','Argentina'),(8,'Buchardo','Argentina'),(9,'Cordoba','Argentina');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite` (
  `idfavorite` int NOT NULL AUTO_INCREMENT,
  `user_iduser` int NOT NULL,
  `product_idproduct` int NOT NULL,
  PRIMARY KEY (`idfavorite`),
  KEY `fk_favorite_user1_idx` (`user_iduser`),
  KEY `fk_favorite_product1_idx` (`product_idproduct`),
  CONSTRAINT `fk_favorite_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`),
  CONSTRAINT `fk_favorite_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idproduct` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `year` varchar(4) NOT NULL,
  `descriptionA` text NOT NULL,
  `descriptionB` text NOT NULL,
  `descriptionC` text NOT NULL,
  `descriptionD` text NOT NULL,
  `address` varchar(512) NOT NULL,
  `location_detail` text NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `city_idcity` int NOT NULL,
  `category_idcategory` int NOT NULL,
  `rule_idrule` int NOT NULL,
  PRIMARY KEY (`idproduct`),
  KEY `fk_product_city1_idx` (`city_idcity`),
  KEY `fk_product_category1_idx` (`category_idcategory`),
  KEY `fk_product_rule1_idx` (`rule_idrule`),
  CONSTRAINT `fk_product_category1` FOREIGN KEY (`category_idcategory`) REFERENCES `category` (`idcategory`),
  CONSTRAINT `fk_product_city1` FOREIGN KEY (`city_idcity`) REFERENCES `city` (`idcity`),
  CONSTRAINT `fk_product_rule1` FOREIGN KEY (`rule_idrule`) REFERENCES `rule` (`idrule`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Alojate en el corazón de Buenos Aires','1993','El Novotel Buenos Aires está situado en la avenida Corrientes y ofrece habitaciones amplias con TV LCD. Las instalaciones incluyen pileta exterior, baño turco y centro de fitness. El Obelisco se encuentra a solo 2 calles.','Todas las habitaciones del Novotel Buenos Aires cuentan con minibar y escritorio.','El Novotel Buenos Aires también dispone de solárium.','El restaurante del hotel, el Patio #378, sirve platos mediterráneos sencillos y modernos. Es posible comer al aire libre en el patio.','Av Corrientes 1334, 1043 Buenos Aires, Argentina','Excelente Ubicacion',-34.6041,-58.3878,1,1,1),(2,'La mejor vista del lago','2004','El Nido del Cóndor Hotel & Spa permite disfrutar de la calidez de una casa de campo con todas las lujosas comodidades de un hotel de 5 estrellas y un personal atento que proporciona una atención personalizada. La estación de esquí de Cerro Catedral está a 11 km.','El Nido del Cóndor está frente al lago Nahuel Huapi y a solo 300 metros de la playa Bonita. Se encuentra a un corto trayecto en auto de la ciudad de Bariloche y de 2 estaciones de esquí internacionales.','El alojamiento ofrece lecciones de esquí y servicios de transfer de ida y vuelta a la estación de esquí, alquiler de material de esquí y guardaesquíes.','El Nido del Cóndor Hotel & Spa alberga piscinas cubiertas y al aire libre para niños y adultos, y un lujoso spa con vistas al lago equipado con sauna, duchas escocesas y baños finlandeses donde se ofrece un gran número de tratamientos corporales. También se ofrecen sesiones de masaje por un adicional.','Avenida Bustillo km 6,900, 8400 San Carlos de Bariloche, Argentina','Excelente Ubicacion',-34.62,-58.378,1,2,2),(3,'Alojate en el corazón de Buenos Aires','1820','El Hostel Carlos Gardel ocupa una pintoresca casa temática de Tango y ofrece conexión de wifi gratis en San Telmo. Se encuentra a solo 350 metros de la plaza Dorrego, donde todos los domingos se celebra una feria de antigüedades.','Las habitaciones del Carlos Gardel están decoradas en tonos vivos y cuentan con paredes de ladrillo visto.','Hay una cocina compartida totalmente equipada.','Los huéspedes podrán leer un libro de la biblioteca.','Carlos Calvo 579, San Telmo, 1102 Buenos Aires, Argentina','Excelente Ubicacion',-26.0684,-65.9745,3,3,3),(4,'Conectate con la naturaleza','2022','El KM SUN HOSTEL, situado en San Carlos de Bariloche, a 300 metros de Melipal, ofrece alojamiento con bar, estacionamiento privado gratuito, salón común y jardín. También cuenta con cocina compartida, consigna de equipaje y wifi gratis en todas las instalaciones. El hostel dispone de habitaciones familiares.','Todas las habitaciones del hostel tienen armario. Todos los alojamientos incluyen ropa de cama.','El KM SUN HOSTEL sirve un desayuno americano todos los días.','El alojamiento dispone de terraza.','Avenida Boock 199 Avenida Boock 199, 8400 San Carlos de Bariloche, Argentina –','Excelente Ubicacion',-41.1198,-71.3885,2,1,1),(5,'En el corazón de Cafayate','1972','El CALCHAQUÍ 6 en el corazón de Cafayate ofrece alojamiento en Cafayate, a 700 metros de la Bodega Nanni, a 1,1 km de la Bodega el Esteco y a 13 km de los viñedos de San Carlos. ','Ofrece acceso a un balcón y estacionamiento privado gratuito.','Departamento con aire acondicionado, 2 dormitorios, TV de pantalla plana y cocina.','El alojamiento dispone de terraza.','Intendente Brachieri 50 1º piso, Cafayate, Argentina','Excelente Ubicacion',-26.0747,-65.9693,3,4,1),(6,'En el corazón de Cafayate','1999','El Porvenir Vineyard Suite (Finca El Retiro) se encuentra en Cafayate, en la provincia de Salta, a 1,3 km de los viñedos de Cafayate, y ofrece pileta exterior de temporada y parrilla.','Todas las habitaciones disponen de TV y baño privado con bañera, bidet, artículos de aseo gratuitos y secador de pelo. El Porvenir Vineyard Suite también cuenta con wifi gratis.','Además, hay un salón común.','En los alrededores se puede disfrutar de varias actividades, como golf y montar a caballo.','Belgrano and Jujuy S/N, 4427 Cafayate, Argentina','Excelente Ubicacion',-41.1277,-71.3531,2,2,3),(7,'Conectate con la naturaleza','1972','El Posta de Purmamarca se encuentra a los pies de la montaña de los Siete Colores, en Purmamarca, y ofrece un desayuno continental gratuito y conexión de wifi gratis. Se encuentra a solo 4 calles de la plaza principal de Purmamarca y ofrece acceso directo al distrito histórico y a muchos lugares de interés turístico.','Las habitaciones son amplias y luminosas. Todas disponen de baño privado y calefacción central.','El Posta de Purmamarca alberga un jardín con cactus y una zona común con TV. Hay servicio de conserjería. Hay servicio de lavandería y consigna de equipaje.','La ciudad de San Salvador de Jujuy está a 65 km. El aeropuerto internacional Gobernador Horacio Guzmán de Jujuy se encuentra a 94 km del Posta de Purmamarca.','Santa Rosa s/n, 4618 Purmamarca, Argentina','Excelente Ubicacion',-23.7458,-65.5013,4,4,2),(8,'Conectate con la naturaleza','2014','El establecimiento Tierra Virgen se encuentra en Purmamarca, a 200 metros del cerro de los Siete Colores. Se ofrece WiFi gratuita.','Este alojamiento, que acepta mascotas, tiene aire acondicionado y cuenta con TV de pantalla plana. También hay cocina con horno, microondas, tostadora, heladera y hervidor. ','Se proporcionan toallas y ropa de cama.','El aeropuerto internacional Gobernador Horacio Guzmán está a 83 km.','Sarmiento esquina Lavalle 4, 4618 Purmamarca, Argentina –','Excelente Ubicacion',-23.7458,-65.5013,4,3,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attribute`
--

DROP TABLE IF EXISTS `product_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_attribute` (
  `idproduct_attribute` int NOT NULL AUTO_INCREMENT,
  `attribute_idattribute` int NOT NULL,
  `product_idproduct` int NOT NULL,
  PRIMARY KEY (`idproduct_attribute`),
  KEY `fk_product_attribute_attribute1_idx` (`attribute_idattribute`),
  KEY `fk_product_attribute_product1_idx` (`product_idproduct`),
  CONSTRAINT `fk_product_attribute_attribute1` FOREIGN KEY (`attribute_idattribute`) REFERENCES `attribute` (`idattribute`),
  CONSTRAINT `fk_product_attribute_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attribute`
--

LOCK TABLES `product_attribute` WRITE;
/*!40000 ALTER TABLE `product_attribute` DISABLE KEYS */;
INSERT INTO `product_attribute` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,2,1),(9,2,2),(10,2,3),(11,2,4),(12,2,5),(13,2,6),(14,2,7),(15,2,8),(16,3,1),(17,4,1),(18,4,2),(19,5,1),(20,5,2),(21,5,3),(22,5,4),(23,5,7),(24,6,1),(25,6,2),(26,6,6),(27,7,2),(28,7,4),(29,7,6),(30,7,7),(31,8,4),(32,9,5),(33,9,6),(34,9,7),(35,9,8),(36,10,5),(37,10,7),(38,10,8);
/*!40000 ALTER TABLE `product_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `idrole` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `active` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN','S'),(2,'ROLE_USER','S');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rule` (
  `idrule` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `fine` float DEFAULT NULL,
  PRIMARY KEY (`idrule`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (1,'Prohibido Fumar','No se puede fumar dentro de los limites del hotel ni siquiera en los patios internos',200),(2,'Prohibido ingresar Mascotas','No se pueden ingresar mascotas voladoras al hotel',555),(3,'Prohibido Aburrirse','El que se aburre pierde',5),(4,'check-OUT','el check-out es antes de las 15pm',NULL);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `idnumber` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `role_idrole` int NOT NULL,
  PRIMARY KEY (`iduser`),
  KEY `fk_user_role_idx` (`role_idrole`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_idrole`) REFERENCES `role` (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'30910402','lucs.rioiv@gmail.com','bienanda','Lucas','Garcia',1),(2,'30303030','doloresaleman@gmail.com','123456','Dolores','Aleman',1),(3,'33030303','guillermina@gmail.com','123456','Guillermina','Santia',2),(4,'33030303','silvia@gmail.com','123456','Silvia','Ratero',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-24 18:45:08
