CREATE DATABASE  IF NOT EXISTS `peliculasactoresdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `peliculasactoresdb`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: peliculasactoresdb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `actores`
--

DROP TABLE IF EXISTS `actores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actores` (
  `idActor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `fechaNac` date NOT NULL,
  `paisNac` varchar(50) NOT NULL,
  `imagen` varchar(2083) NOT NULL,
  PRIMARY KEY (`idActor`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actores`
--

LOCK TABLES `actores` WRITE;
/*!40000 ALTER TABLE `actores` DISABLE KEYS */;
INSERT INTO `actores` VALUES (7,'Marlon Brando','1924-04-03','Estados Unidos','cfd1e2d0-e693-476e-baaf-83d4fd905fce_marlon_brando-144076213368411-nm_200.jpg'),(8,'Johnny Depp','1963-06-09','Estados Unidos','deaf93cc-cdcb-408e-a05e-700493422110_johnny_depp-180860288211125-nm_200.jpg'),(9,'John Travolta','1954-02-18','Estados Unidos','290156ef-cf4b-4580-9760-a7e4fa7a85a8_john_travolta-215026180777265-nm_200.jpg'),(10,'Emma Stone','1988-11-06','Estados Unidos','138050af-f9e4-44fb-aaee-f8ae8bb99d2a_emma_stone-249115701217027-nm_200.jpg'),(11,'Penélope Cruz','1974-04-28','España','c51061b4-b734-4698-b2ac-0ee579d522e3_penelope_cruz-133582653784038-nm_200.jpg'),(12,'Eva Green','1980-06-06','Rusia','80f406be-8b84-4681-a133-fe033ff61612_eva_green-161779533420466-nm_200.jpg'),(13,'Keanu Reeves','1964-09-20','China','6ce77408-1b15-473b-a411-00293b1116f0_keanu_reeves-249385740937163-nm_200.jpg'),(14,'Scarlett Johansson','1984-11-22','Estados Unidos','96b3ce1c-b559-44e3-96db-8cdfa8d5936a_scarlett_johansson-224638006892363-nm_200.jpg'),(15,'Brad Pitt','1963-12-18','Estados Unidos','16a68f32-afca-41e4-8ab1-926342cf5269_brad_pitt-180902992984558-nm_200.jpg'),(16,'Song Kang-ho','1967-01-17','Corea del Sur','f8e0c9ba-2cc7-4331-bf0c-a99810b6ba68_song_kang_ho-246840977926356-nm_200.jpg'),(17,'Joaquin Phoenix','1974-10-28','Estados Unidos','00876092-4b58-4409-8820-38ca49093047_joaquin_phoenix-131606730545658-nm_200.jpg'),(18,'Jennifer Lawrence','1990-08-15','Estados Unidos','108d5601-8a57-4a2b-aa0e-2e812d89485b_jennifer_lawrence-075541662792943-nm_200.jpg'),(19,'Emma Watson','1990-04-15','Reino Unido','36a3b555-c889-442d-a9eb-bf812611b9c7_emma_watson-012891562313215-nm_200.jpg'),(20,'Megan Fox','1986-05-16','Estados Unidos','799e678a-47d6-495e-a50b-ec139081be4c_megan_fox-034251896202650-nm_200.jpg');
/*!40000 ALTER TABLE `actores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas` (
  `idPelicula` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `anio` int NOT NULL,
  `duracion` int NOT NULL,
  `pais` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `sinopsis` varchar(1000) NOT NULL,
  `imagen` varchar(2083) NOT NULL,
  PRIMARY KEY (`idPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (17,'El Padrino',1972,175,'Estados Unidos','Francis Ford Coppola','Suspense','América, años 40. Don Vito Corleone (Marlon Brando) es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: Connie (Talia Shire), el impulsivo Sonny (James Caan), el pusilánime Fredo (John Cazale) y Michael (Al Pacino), que no quiere saber nada de los negocios de su padre. Cuando Corleone, en contra de los consejos de \'Il consigliere\' Tom Hagen (Robert Duvall), se niega a participar en el negocio de las drogas, el jefe de otra banda ordena su asesinato. Empieza entonces una violenta y cruenta guerra entre las familias mafiosas.','7a87d4b0-d521-4be6-b11d-534099138d6c_the_godfather-488102675-mmed.jpg'),(18,'Pulp Fiction',1994,153,'Estados Unidos','Quentin Tarantino','Thriller','Jules y Vincent, dos asesinos a sueldo con no demasiadas luces, trabajan para el gángster Marsellus Wallace. Vincent le confiesa a Jules que Marsellus le ha pedido que cuide de Mia, su atractiva mujer. Jules le recomienda prudencia porque es muy peligroso sobrepasarse con la novia del jefe. Cuando llega la hora de trabajar, ambos deben ponerse \"manos a la obra\". Su misión: recuperar un misterioso maletín.','1a9fc9c9-0f6a-44ad-a0bb-d826f553fb1c_pulp_fiction-210382116-mmed.jpg'),(19,'El resplandor',1980,146,'India','Stanley Kubrick','Terror','Jack Torrance se traslada con su mujer y su hijo de siete años al impresionante hotel Overlook, en Colorado, para encargarse del mantenimiento de las instalaciones durante la temporada invernal, época en la que permanece cerrado y aislado por la nieve. Su objetivo es encontrar paz y sosiego para escribir una novela. Sin embargo, poco después de su llegada al hotel, al mismo tiempo que Jack empieza a padecer inquietantes trastornos de personalidad, se suceden extraños y espeluznantes fenómenos paranormales.','52e1e372-73cb-455b-bb6d-b27b2486022d_the_shining-453129380-mmed.jpg'),(20,'Blade Runner',1982,117,'Estados Unidos','Ridley Scott','Ciencia Ficción','Noviembre de 2019. A principios del siglo XXI, la poderosa Tyrell Corporation creó, gracias a los avances de la ingeniería genética, un robot llamado Nexus 6, un ser virtualmente idéntico al hombre pero superior a él en fuerza y agilidad, al que se dio el nombre de Replicante. Estos robots trabajaban como esclavos en las colonias exteriores de la Tierra. Después de la sangrienta rebelión de un equipo de Nexus-6, los Replicantes fueron desterrados de la Tierra. Brigadas especiales de policía, los Blade Runners, tenían órdenes de matar a todos los que no hubieran acatado la condena. Pero a esto no se le llamaba ejecución, se le llamaba \"retiro\". Tras un grave incidente, el ex Blade Runner Rick Deckard es llamado de nuevo al servicio para encontrar y \"retirar\" a unos replicantes rebeldes.','1f60f915-8ad4-4da1-8e35-8273b1722aa7_blade_runner-351607743-mmed.jpg'),(21,'Matrix',1999,131,'Estados Unidos','Lilly Wachowski','Ciencia Ficción','Thomas Anderson es un brillante programador de una respetable compañía de software. Pero fuera del trabajo es Neo, un hacker que un día recibe una misteriosa visita...','40441787-81c5-4bd4-b969-3fa1eef2b062_the_matrix-155050517-mmed.jpg'),(22,'Gladiator',2000,150,'China','Ridley Scott','Acción','En el año 180, el Imperio Romano domina todo el mundo conocido. Tras una gran victoria sobre los bárbaros del norte, el anciano emperador Marco Aurelio (Richard Harris) decide transferir el poder a Máximo (Russell Crowe), bravo general de sus ejércitos y hombre de inquebrantable lealtad al imperio. Pero su hijo Cómodo (Joaquin Phoenix), que aspiraba al trono, no lo acepta y trata de asesinar a Máximo.','0d901f36-c1a4-4950-972f-2d7e4dc91cb1_gladiator-564554218-mmed.jpg'),(23,'Interstellar',2014,169,'Rusia','Christopher Nolan','Ciencia Ficción','Al ver que la vida en la Tierra está llegando a su fin, un grupo de exploradores dirigidos por el piloto Cooper (McConaughey) y la científica Amelia (Hathaway) emprende una misión que puede ser la más importante de la historia de la humanidad: viajar más allá de nuestra galaxia para descubrir algún planeta en otra que pueda garantizar el futuro de la raza humana.','fd88bc22-4ef4-4113-98f0-db0f69cd982d_interstellar-366875261-mmed.jpg'),(24,'Oppenheimer',2023,180,'Estados Unidos','Christopher Nolan','Drama','En tiempos de guerra, el brillante físico estadounidense Julius Robert Oppenheimer (Cillian Murphy), al frente del \"Proyecto Manhattan\", lidera los ensayos nucleares para construir la bomba atómica para su país. Impactado por su poder destructivo, Oppenheimer se cuestiona las consecuencias morales de su creación. Desde entonces y el resto de su vida, se opondría firmemente al uso de armas nucleares.','d0869ec7-7de7-4b1e-95fe-6f0af0fb7028_oppenheimer-828933592-mmed.jpg'),(25,'Gran Torino',2008,119,'Estados Unidos','Clint Eastwood','Drama','Walt Kowalski (Clint Eastwood), un veterano de la guerra de Corea (1950-1953), es un obrero jubilado del sector del automóvil que ha enviudado recientemente. Su máxima pasión es cuidar de su más preciado tesoro: un coche Gran Torino de 1972. Es un hombre inflexible y cascarrabias, al que le cuesta trabajo asimilar los cambios que se producen a su alrededor, especialmente la llegada de multitud de inmigrantes asiáticos a su barrio. Sin embargo, las circustancias harán que se vea obligado a replantearse sus ideas.','a592fa11-5f66-4d52-b59c-8554be520dcf_gran_torino-278262332-mmed.jpg'),(26,'El viaje de Chihiro',2001,124,'Japón','Hayao Miyazaki','Animación','Chihiro es una niña de diez años que viaja en coche con sus padres. Después de atravesar un túnel, llegan a un mundo fantástico, en el que no hay lugar para los seres humanos, sólo para los dioses de primera y segunda clase. Cuando descubre que sus padres han sido convertidos en cerdos, Chihiro se siente muy sola y asustada.','04f9eee0-cb61-43f6-8961-6f1fe54b1a9d_sen_to_chihiro_no_kamikakushi-348587850-mmed.jpg'),(27,'Intocable',2011,109,'Francia','Olivier Nakache','Comedia','Philippe, un aristócrata millonario que se ha quedado tetrapléjico a causa de un accidente de parapente, contrata como cuidador a domicilio a Driss, un inmigrante de un barrio marginal recién salido de la cárcel. Aunque, a primera vista, no parece la persona más indicada, los dos acaban logrando que convivan Vivaldi y Earth Wind and Fire, la elocuencia y la hilaridad, los trajes de etiqueta y el chándal. Dos mundos enfrentados que, poco a poco, congenian hasta forjar una amistad tan disparatada, divertida y sólida como inesperada, una relación única en su especie de la que saltan chispas.','3a580fb0-1911-4dcd-963e-e4b01c135bd8_intouchables-218166359-mmed (1).jpg'),(28,'Coco',2017,109,'Estados Unidos','Lee Unkrich','Animación','Miguel es un joven con el sueño de convertirse en leyenda de la música a pesar de la prohibición de su familia. Su ídolo es Ernesto de la Cruz, el músico y cantante más famoso de México. La pasión de Miguel le llevará a adentrarse en la \"Tierra de los Muertos\", donde conocerá su verdadero legado familiar.','68ef3a83-0e54-4ff2-9032-3f9ab79fee3a_coco-155051069-mmed.jpg'),(29,'Joker',2019,121,'Estados Unidos','Todd Phillips','Thriller','Arthur Fleck (Phoenix) vive en Gotham con su madre, y su única motivación en la vida es hacer reír a la gente. Actúa haciendo de payaso en pequeños trabajos, pero tiene problemas mentales que hacen que la gente le vea como un bicho raro. Su gran sueño es actuar como cómico delante del público, pero una serie de trágicos acontecimientos le hará ir incrementando su ira contra una sociedad que le ignora.','c9dea704-6fdb-4f1b-804b-4642c472426b_joker-790658206-mmed.jpg'),(30,'Parásitos',2019,132,'Corea del Sur','Bong Joon-ho','Drama','Tanto Gi Taek (Song Kang-ho) como su familia están sin trabajo. Cuando su hijo mayor, Gi Woo (Choi Woo-sik), empieza a dar clases particulares en casa de Park (Lee Seon-gyun), las dos familias, que tienen mucho en común pese a pertenecer a dos mundos totalmente distintos, comienzan una interrelación de resultados imprevisibles.','a6802976-fd3b-462e-a666-af52bf84e08c_gisaengchung-432616131-mmed.jpg'),(31,'El laberinto del fauno',2006,112,'España','Guillermo del Toro','Fantasía','Año 1944, posguerra española. Ofelia (Ivana Baquero) y su madre, Carmen (Ariadna Gil), que está embarazada, se trasladan a un pequeño pueblo al que ha sido destinado el nuevo marido de Carmen, Vidal (Sergi López), un cruel capitán del ejército franquista por el que la niña no siente ningún afecto. La misión de Vidal es acabar con los últimos miembros de la resistencia republicana que permanecen escondidos en los montes de la zona. En la zona viven Mercedes (Maribel Verdú), el ama de llaves, y el médico (Álex Angulo) que se hace cargo del delicado estado de salud de Carmen. Una noche, Ofelia descubre las ruinas de un laberinto, y allí se encuentra con un fauno (Doug Jones), una extraña criatura que le hace una sorprendente revelación: ella es en realidad una princesa, la última de su estirpe, y los suyos la esperan desde hace mucho tiempo. Para poder regresar a su mágico reino, la niña deberá enfrentarse a tres pruebas. ','d0b74f9d-c818-484c-b4d5-caf6b0eec896_el_laberinto_del_fauno-222302534-mmed.jpg'),(32,'Verónica',2017,105,'España','Paco Plaza','Terror','Inspirada en una historia real sucedida en el madrileño barrio de Vallecas en los años 90. Tras hacer una ouija con unas amigas, una adolescente es asediada por aterradoras presencias sobrenaturales que amenazan con hacer daño a toda su familia.','501f4b40-da17-4c52-910f-9422ef8f9099_veronica-266321457-mmed.jpg'),(33,'Up',2009,96,'Estados Unidos','Pete Docter','Animación','Carl Fredricksen es un viudo vendedor de globos de 78 años que, finalmente, consigue llevar a cabo el sueño de su vida: enganchar miles de globos a su casa y salir volando rumbo a América del Sur. Pero ya estando en el aire y sin posibilidad de retornar Carl descubre que viaja acompañado de Russell, un explorador que tiene ocho años y un optimismo a prueba de bomba.','12891151-c48e-4fe2-aa73-d7e887a716fc_up-672315222-mmed.jpg'),(35,'Million Dollar Baby',2004,132,'Estados Unidos','Clint Eastwood','Acción','Después de haber entrenado y representado a los mejores púgiles, Frankie Dunn (Eastwood) regenta un gimnasio con la ayuda de Scrap (Freeman), un ex-boxeador que es además su único amigo. Frankie es un hombre solitario y adusto que se refugia desde hace años en la religión buscando una redención que no llega. Un día, entra en su gimnasio Maggie Fitzgerald (Swank), una voluntariosa chica que quiere boxear y que está dispuesta a luchar denodadamente para conseguirlo. Frankie la rechaza alegando que él no entrena chicas y que, además, es demasiado mayor. Pero Maggie no se rinde y se machaca cada día en el gimnasio, con el único apoyo de Scrap','2b03c227-0fb2-4925-8e31-4f7aa2cc5989_million_dollar_baby-342154413-mmed.jpg');
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas_has_actores`
--

DROP TABLE IF EXISTS `peliculas_has_actores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas_has_actores` (
  `idPeliculas` int NOT NULL,
  `idActores` int NOT NULL,
  PRIMARY KEY (`idPeliculas`,`idActores`),
  KEY `idActores_idx` (`idActores`),
  CONSTRAINT `idActores` FOREIGN KEY (`idActores`) REFERENCES `actores` (`idActor`),
  CONSTRAINT `idPelicula` FOREIGN KEY (`idPeliculas`) REFERENCES `peliculas` (`idPelicula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas_has_actores`
--

LOCK TABLES `peliculas_has_actores` WRITE;
/*!40000 ALTER TABLE `peliculas_has_actores` DISABLE KEYS */;
INSERT INTO `peliculas_has_actores` VALUES (17,7),(20,7),(24,7),(27,7),(31,7),(19,8),(21,8),(22,8),(24,8),(28,8),(33,8),(35,8),(18,9),(20,9),(22,9),(29,9),(17,10),(22,10),(23,10),(24,10),(29,10),(35,10),(18,11),(20,11),(23,11),(33,11),(19,12),(23,12),(24,12),(27,12),(32,12),(20,13),(21,13),(23,13),(28,13),(17,14),(20,14),(21,14),(27,14),(32,14),(35,14),(25,15),(27,15),(31,15),(33,15),(26,16),(30,16),(17,17),(25,17),(27,17),(29,17),(30,17),(35,17),(26,18),(30,18),(31,18),(32,18),(25,19),(26,19),(29,19),(32,19),(26,20),(29,20),(31,20),(32,20);
/*!40000 ALTER TABLE `peliculas_has_actores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-22 18:28:50
CREATE DATABASE  IF NOT EXISTS `usuariosfilmdbsec` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `usuariosfilmdbsec`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: usuariosfilmdbsec
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criticas`
--

DROP TABLE IF EXISTS `criticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criticas` (
  `idCritica` int NOT NULL AUTO_INCREMENT,
  `peliculaId` int NOT NULL,
  `valoracion` varchar(1000) NOT NULL,
  `nota` int NOT NULL,
  `fecha` date NOT NULL,
  `Users_idUsuario` int NOT NULL,
  PRIMARY KEY (`idCritica`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criticas`
--

LOCK TABLES `criticas` WRITE;
/*!40000 ALTER TABLE `criticas` DISABLE KEYS */;
INSERT INTO `criticas` VALUES (1,17,'me ha gustado la pelicula, esto es una critica de prueba',8,'2024-12-06',2),(2,17,'CRITICA POST, esto es una critica de prueba',5,'2024-12-07',3),(3,17,'Critica pruebnasdfñlkjadsflñkdsajfñlasdjf',2,'2023-12-13',2),(5,29,'jejeGod',8,'2023-12-13',2),(6,17,'asdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfj',10,'2023-12-14',2),(7,17,'asdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfj',4,'2023-12-14',2),(8,17,'asdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfjasdlkfj asldkfj a dsklfj',6,'2023-12-14',2),(9,18,'Valoracion pulp sdaf sdfsad asd f asdlkfjsdklfjsdlkjf',7,'2023-12-16',2),(10,19,'Critica probando la autenticacion',6,'2023-12-28',2),(11,19,'Critica probando la autenticacion',6,'2023-12-28',2),(12,24,'Critica Autent',3,'2023-12-28',2),(13,31,'asdf  adsfsadf sadf adsf asdf ',3,'2023-12-28',1),(14,33,'Muy buena jejejejejejejej',3,'2023-12-28',1),(15,17,'Muy buena Goddddd',10,'2023-12-29',1),(16,17,'SIUUUUUUUUUUU',1,'2023-12-29',1),(17,26,'Muy buena animación',9,'2023-12-29',1),(22,33,'Muy buena',10,'2024-01-24',1),(23,17,'me ha gustado mucho',9,'2024-01-24',1),(24,22,'Muy buena',7,'2024-01-24',7);
/*!40000 ALTER TABLE `criticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','admin.uno@uah.es',1),(2,'usuario','usuario','usuario@uah.es',1),(3,'usuarioPost','usuarioPost','usuario.post@uah.es',1),(5,'PruebaRoles','pruebaroles','roles@mail.me',0),(6,'Javier','javier','javier@javier.com',1),(7,'javi','javi','javi@javi.com',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_has_authorities`
--

DROP TABLE IF EXISTS `users_has_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_has_authorities` (
  `Users_idUsuario` int NOT NULL,
  `Authorities_idRol` int NOT NULL,
  PRIMARY KEY (`Users_idUsuario`,`Authorities_idRol`),
  KEY `fk_Users_has_Authorities_Authorities1_idx` (`Authorities_idRol`),
  KEY `fk_Users_has_Authorities_Users1_idx` (`Users_idUsuario`),
  CONSTRAINT `fk_Users_has_Authorities_Authorities1` FOREIGN KEY (`Authorities_idRol`) REFERENCES `authorities` (`idRol`),
  CONSTRAINT `fk_Users_has_Authorities_Users1` FOREIGN KEY (`Users_idUsuario`) REFERENCES `users` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_has_authorities`
--

LOCK TABLES `users_has_authorities` WRITE;
/*!40000 ALTER TABLE `users_has_authorities` DISABLE KEYS */;
INSERT INTO `users_has_authorities` VALUES (1,1),(5,1),(2,2),(3,2),(5,2),(6,2),(7,2);
/*!40000 ALTER TABLE `users_has_authorities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-22 18:28:50
