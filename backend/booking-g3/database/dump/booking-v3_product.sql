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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-24 18:52:36
