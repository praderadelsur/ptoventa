-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `01tblusers`
--

DROP TABLE IF EXISTS `01tblusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `01tblusers` (
  `strUserIde` varchar(10) DEFAULT NULL,
  `strUserPass` varchar(10) DEFAULT NULL,
  `strUserName` varchar(50) DEFAULT NULL,
  `strRoleName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `01tblusers`
--

LOCK TABLES `01tblusers` WRITE;
/*!40000 ALTER TABLE `01tblusers` DISABLE KEYS */;
INSERT INTO `01tblusers` VALUES ('jorge','software','pradera','administra'),('mao','olmedo','marco','usuario'),('test','test','asdfas','supervisor'),('User01','olmedo','User 01 Nombre','2primeros'),('User02','olmedo','User 02','2primeros');
/*!40000 ALTER TABLE `01tblusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `02tblprocesos`
--

DROP TABLE IF EXISTS `02tblprocesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `02tblprocesos` (
  `strProcesoIde` varchar(10) DEFAULT NULL,
  `strProcesoNom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de procesos que contiene el sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `02tblprocesos`
--

LOCK TABLES `02tblprocesos` WRITE;
/*!40000 ALTER TABLE `02tblprocesos` DISABLE KEYS */;
INSERT INTO `02tblprocesos` VALUES ('sis-pro-01','SISTEMA PROCESOS'),('sis-usu-01','SISTEMA USUARIOS'),('sis-par-01','SISTEMA PARAMETROS'),('cat-pro-01','CATALOGOS-PRODUCTOS'),('pro-inv-01','INVENTARIO'),('pro-inv-02','VENTAS'),('rep-usu-01','REPORTE USUARIOS'),('rep-pro-01','REPORTE PROCESOS'),('rep-vta-01','REPORTE FORMAS DE PAGO'),('rep-vta-02','REPORTE VENTAS'),('rep-bit-01','REPORTE BITACORA'),('uti-res-01','RESPALDAR INFORMACION');
/*!40000 ALTER TABLE `02tblprocesos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `03tblrolprocesos`
--

DROP TABLE IF EXISTS `03tblrolprocesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `03tblrolprocesos` (
  `strRoleName` varchar(10) DEFAULT NULL,
  `strProcesoIde` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de roles y sus procesos\r\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `03tblrolprocesos`
--

LOCK TABLES `03tblrolprocesos` WRITE;
/*!40000 ALTER TABLE `03tblrolprocesos` DISABLE KEYS */;
INSERT INTO `03tblrolprocesos` VALUES ('otrorole','sis-pro-01'),('supervisor','sis-pro-01'),('supervisor','sis-par-01'),('usuario','sis-pro-01'),('usuario','cat-pro-01'),('administra','sis-pro-01'),('administra','sis-usu-01'),('administra','sis-par-01'),('administra','cat-pro-01'),('administra','pro-inv-01'),('administra','pro-inv-02'),('administra','rep-usu-01'),('administra','rep-pro-01'),('administra','rep-vta-01'),('administra','rep-vta-02'),('administra','rep-bit-01'),('administra','uti-res-01'),('2primeros','cat-pro-01'),('2primeros','pro-inv-02'),('2primeros','rep-vta-01'),('2primeros','rep-vta-02');
/*!40000 ALTER TABLE `03tblrolprocesos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `04tblproductos`
--

DROP TABLE IF EXISTS `04tblproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `04tblproductos` (
  `strProductoCodigo` varchar(15) NOT NULL,
  `strProductoNombre` varchar(50) NOT NULL,
  `strProductoDescripcion` varchar(50) DEFAULT NULL,
  `decProductoPrecio1` decimal(10,2) NOT NULL,
  `decProductoPrecio2` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio3` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio4` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio5` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio6` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio7` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio8` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio9` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio10` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Productos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `04tblproductos`
--

LOCK TABLES `04tblproductos` WRITE;
/*!40000 ALTER TABLE `04tblproductos` DISABLE KEYS */;
INSERT INTO `04tblproductos` VALUES ('1','PECHO DE CERDO',' PECHO DE CERDO',130.00,130.00,130.00,130.00,120.00,157.30,130.00,130.00,130.00,120.00),('2','LOMO DE CERDO','LOMO DE CERDO',130.00,130.00,130.00,130.00,120.00,157.30,130.00,130.00,130.00,120.00),('3','BONDIOLA DE CERDO','BONDIOLA DE CERDO',193.20,150.00,150.00,155.00,145.00,233.77,150.00,150.00,155.00,145.00),('4','CHURRASCO DE CERDO','CHURRASCO DE CERDO',170.00,170.00,170.00,170.00,170.00,205.70,170.00,170.00,170.00,170.00),('5','FRESCA DE CERDO','FRESCA DE CERDO',102.00,112.00,112.00,125.00,110.00,123.42,112.00,112.00,125.00,110.00),('6','CHORIZO MARSHALA','CHORIZO MARSHALA',89.00,95.00,95.00,105.00,93.00,107.69,95.00,95.00,105.00,93.00),('7','CHORIZO DE MORRON','CHORIZO DE MORRON',92.00,98.00,98.00,105.00,96.00,111.32,98.00,98.00,105.00,96.00),('8','CHORIZO DE CERDO','CHORIZO DE CERDO',92.00,98.00,98.00,110.00,94.00,111.32,98.00,98.00,110.00,94.00),('9','MORCILLA ROSCA','MORCILLA ROSCA',54.00,54.00,54.00,65.00,54.00,65.34,54.00,54.00,65.00,54.00),('10','FRESCA ATADA DE CERDO','FRESCA ATADA DE CERDO',105.00,115.00,115.00,125.00,113.00,127.05,115.00,115.00,125.00,113.00),('11','MORCILLA VASCA','MORCILLA VASCA',63.00,63.00,63.00,72.00,63.00,76.23,63.00,63.00,72.00,63.00),('12','FRESCA COMUN','FRESCA COMUN',49.00,49.00,52.00,60.00,0.00,59.29,49.00,52.00,60.00,0.00),('13','SALCHICHA VIENA','SALCHICHA VIENA',120.00,130.00,130.00,130.00,130.00,145.20,130.00,130.00,130.00,130.00),('14','COPETIN DE CERDO','COPETIN DE CERDO',136.00,146.00,146.00,146.00,146.00,164.56,146.00,146.00,146.00,146.00),('15','SALAMIN','SALAMIN',182.00,192.00,192.00,192.00,190.00,220.22,192.00,192.00,192.00,190.00),('16','BASTON','BASTON',192.00,202.00,202.00,202.00,200.00,232.32,202.00,202.00,202.00,200.00),('17','CHORIZO CRIOLLO','CHORIZO CRIOLLO',86.00,92.00,92.00,100.00,90.00,104.06,92.00,92.00,100.00,90.00),('18','PANCETA AHUMADA','PANCETA AHUMADA',250.00,260.00,260.00,270.00,260.00,0.00,260.00,260.00,270.00,260.00),('19','PANCETA SALADA','PANCETA SALADA',110.00,145.00,145.00,145.00,145.00,133.10,145.00,145.00,145.00,145.00),('20','CHORIZO COLORADO','CHORIZO COLORADO',95.00,140.00,140.00,140.00,140.00,114.95,140.00,140.00,140.00,140.00),('21','BONDIOLA SECA','BONDIOLA SECA',174.98,170.00,175.00,180.00,170.00,211.73,170.00,175.00,180.00,170.00),('22','PATA','PATA',0.00,0.00,0.00,0.00,14.00,0.00,0.00,0.00,0.00,14.00),('24','JAMON','JAMON',0.00,0.00,0.00,0.00,65.00,0.00,0.00,0.00,0.00,65.00),('25','TRIPA CHINESCA','TRIPA CHINESCA',0.00,0.00,0.00,0.00,500.00,0.00,0.00,0.00,0.00,500.00),('26','GRASA','GRASA',0.00,0.00,0.00,0.00,15.00,0.00,0.00,0.00,0.00,15.00),('27','CHORIZO BOMBON DE CERDO','CHORIZO BOMBON DE CERDO',95.00,105.00,105.00,110.00,101.00,114.95,105.00,105.00,110.00,101.00),('28','MORCILLA BOMBON','MORCILLA BOMBON',57.76,57.00,57.00,68.00,57.00,69.89,57.00,57.00,68.00,57.00),('29','MATAMBRE DE POLLO','MATAMBRE DE POLLO',0.00,0.00,0.00,115.00,0.00,0.00,0.00,0.00,115.00,0.00),('30','MATAMBRE DE CERDO','MATAMBRE DE CERDO',0.00,0.00,0.00,120.00,0.00,0.00,0.00,0.00,120.00,0.00),('31','MATAMBRE DE CARNE','MATAMBRE DE CARNE',0.00,0.00,0.00,125.00,0.00,0.00,0.00,0.00,125.00,0.00);
/*!40000 ALTER TABLE `04tblproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `05tblfolios`
--

DROP TABLE IF EXISTS `05tblfolios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `05tblfolios` (
  `intFolioInventario` int(10) NOT NULL,
  `intFolioVenta` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `05tblfolios`
--

LOCK TABLES `05tblfolios` WRITE;
/*!40000 ALTER TABLE `05tblfolios` DISABLE KEYS */;
INSERT INTO `05tblfolios` VALUES (36,14);
/*!40000 ALTER TABLE `05tblfolios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `06tblinventario`
--

DROP TABLE IF EXISTS `06tblinventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `06tblinventario` (
  `intInvFolio` int(10) NOT NULL,
  `strInvMovimiento` varchar(10) NOT NULL,
  `datInvFecha` datetime NOT NULL,
  `intInvCantidad` int(11) NOT NULL,
  `strProductoCodigo` varchar(15) NOT NULL,
  `intVentaFolio` int(10) NOT NULL,
  `txtInvDescripcion` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `06tblinventario`
--

LOCK TABLES `06tblinventario` WRITE;
/*!40000 ALTER TABLE `06tblinventario` DISABLE KEYS */;
INSERT INTO `06tblinventario` VALUES (1,'Salida','2012-03-22 10:59:49',1,'2',1,'Salida por Venta'),(2,'Salida','2012-03-22 10:59:49',1,'1',1,'Salida por Venta'),(3,'Salida','2012-03-22 11:22:40',2,'4',2,'Salida por Venta'),(4,'Salida','2012-03-22 11:22:40',2,'3',2,'Salida por Venta'),(5,'Entrada','2012-03-22 11:22:40',2,'4',2,'Entrada por Cancelación de Venta'),(6,'Entrada','2012-03-22 11:22:40',2,'3',2,'Entrada por Cancelación de Venta'),(7,'Salida','2012-03-22 11:37:12',2,'4',3,'Salida por Venta'),(8,'Salida','2012-03-22 11:37:12',2,'3',3,'Salida por Venta'),(9,'Entrada','2012-03-22 11:37:12',2,'4',3,'Entrada por Cancelación de Venta'),(10,'Entrada','2012-03-22 11:37:12',2,'3',3,'Entrada por Cancelación de Venta'),(11,'Salida','2012-03-23 10:31:16',5,'5',0,'Prueba de sistemas'),(12,'Salida','2012-05-18 05:00:45',1,'778665443333',4,'Salida por Venta'),(13,'Salida','2012-05-18 05:10:14',1,'778665443333',5,'Salida por Venta'),(14,'Salida','2012-05-18 05:10:14',1,'12345678901237',5,'Salida por Venta'),(15,'Salida','2012-05-22 07:03:36',5,'123456789018',6,'Salida por Venta'),(16,'Salida','2012-07-14 05:45:29',1,'123456789012345',7,'Salida por Venta'),(17,'Salida','2019-08-29 09:48:45',1,'1',8,'Salida por Venta'),(18,'Salida','2019-08-29 09:48:45',1,'5',8,'Salida por Venta'),(19,'Salida','2019-08-29 09:48:45',1,'4',8,'Salida por Venta'),(20,'Salida','2019-08-29 09:48:45',1,'3',8,'Salida por Venta'),(21,'Salida','2019-08-29 09:48:45',1,'2',8,'Salida por Venta'),(22,'Salida','2019-08-30 01:01:59',1,'7',9,'Salida por Venta'),(23,'Salida','2019-08-30 01:01:59',1,'6',9,'Salida por Venta'),(24,'Salida','2019-08-30 01:01:59',1,'5',9,'Salida por Venta'),(25,'Salida','2019-08-30 01:01:59',1,'4',9,'Salida por Venta'),(26,'Salida','2019-08-30 01:01:59',1,'3',9,'Salida por Venta'),(27,'Salida','2019-08-30 01:01:59',1,'2',9,'Salida por Venta'),(28,'Salida','2019-08-30 01:01:59',1,'1',9,'Salida por Venta'),(29,'Salida','2019-08-30 01:12:42',13,'11',10,'Salida por Venta'),(30,'Salida','2019-08-30 01:12:42',1,'6',10,'Salida por Venta'),(31,'Salida','2019-08-30 01:12:42',11,'5',10,'Salida por Venta'),(32,'Salida','2019-08-30 01:12:42',21,'12',10,'Salida por Venta'),(33,'Salida','2019-08-30 01:12:42',17,'4',10,'Salida por Venta'),(34,'Salida','2019-08-30 01:12:42',10,'3',10,'Salida por Venta'),(35,'Salida','2019-08-30 01:12:42',6,'2',10,'Salida por Venta');
/*!40000 ALTER TABLE `06tblinventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `07tblparametros`
--

DROP TABLE IF EXISTS `07tblparametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `07tblparametros` (
  `intMensajesExito` tinyint(1) unsigned NOT NULL,
  `intAgruparProductos` tinyint(1) unsigned NOT NULL,
  `intBitacoraActiva` tinyint(1) unsigned NOT NULL,
  `intVerificarExistencias` tinyint(1) unsigned NOT NULL,
  `strTicketInfoFinal` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `07tblparametros`
--

LOCK TABLES `07tblparametros` WRITE;
/*!40000 ALTER TABLE `07tblparametros` DISABLE KEYS */;
INSERT INTO `07tblparametros` VALUES (1,1,1,0,'Praderas del Sur');
/*!40000 ALTER TABLE `07tblparametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `08tblventas`
--

DROP TABLE IF EXISTS `08tblventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `08tblventas` (
  `intVentaFolio` int(10) unsigned NOT NULL,
  `dateVentaFecha` datetime NOT NULL,
  `intVentaProductos` int(10) unsigned NOT NULL,
  `decVentaImporte` decimal(10,2) unsigned NOT NULL,
  `decVentaUtilidad` decimal(10,2) unsigned NOT NULL,
  `strVentaFormaPago` varchar(20) NOT NULL,
  `strVentaCancelada` varchar(50) DEFAULT NULL,
  `strVentaReferencia` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `08tblventas`
--

LOCK TABLES `08tblventas` WRITE;
/*!40000 ALTER TABLE `08tblventas` DISABLE KEYS */;
INSERT INTO `08tblventas` VALUES (1,'2012-03-22 10:59:49',2,40.00,6.00,'Efectivo','',''),(2,'2012-03-22 11:22:40',4,90.00,46.00,'Tarjeta','PRUEBA DE SISTEMAS','IFE-12312312312'),(3,'2012-03-22 11:37:12',4,90.00,46.00,'Efectivo','CANCELACION PRUEBA DE SISTEMAS',''),(4,'2012-05-18 05:00:45',1,35.00,15.00,'Efectivo','',''),(5,'2012-05-18 05:10:14',2,65.00,30.00,'Efectivo','',''),(6,'2012-05-22 07:03:36',5,20.00,10.00,'Efectivo','',''),(7,'2012-07-14 05:45:29',1,20.00,0.00,'Efectivo','',''),(8,'2019-08-29 09:48:45',5,105.00,39.00,'Efectivo','',''),(9,'2019-08-30 01:01:59',7,7629.00,3038.00,'Efectivo','',''),(10,'2019-08-30 01:12:42',79,84027.50,33707.50,'Efectivo','',''),(1,'2019-11-13 02:57:52',1,12000.00,1.00,'Efectivo','',''),(1,'2019-11-13 09:20:43',2,72000.00,1.00,'Efectivo','',''),(1,'2019-11-29 02:23:08',2,25527.94,1.00,'Efectivo','','');
/*!40000 ALTER TABLE `08tblventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `09tblventasdetalle`
--

DROP TABLE IF EXISTS `09tblventasdetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `09tblventasdetalle` (
  `intVentaFolio` int(10) unsigned NOT NULL,
  `strProductoCodigo` varchar(15) NOT NULL,
  `strProductoNombre` varchar(20) NOT NULL,
  `intVentaCantidad` tinyint(3) unsigned NOT NULL,
  `decProductoPrecio` decimal(10,2) unsigned NOT NULL,
  `decProductoCosto` decimal(10,2) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `09tblventasdetalle`
--

LOCK TABLES `09tblventasdetalle` WRITE;
/*!40000 ALTER TABLE `09tblventasdetalle` DISABLE KEYS */;
INSERT INTO `09tblventasdetalle` VALUES (1,'2','Producto 2',1,7.50,4.00),(1,'1','uno',1,32.50,30.00),(2,'4','PRO 4',2,25.00,12.00),(2,'3','Producto 3',2,20.00,10.00),(3,'4','PRO 4',2,25.00,12.00),(3,'3','Producto 3',2,20.00,10.00),(4,'778665443333','LAPIZ MIRADO 2B',1,35.00,20.00),(5,'778665443333','LAPIZ MIRADO 2B',1,35.00,20.00),(5,'12345678901237','CD-W SONY 700 MB',1,30.00,15.00),(6,'123456789018','GOMA MIGAJON ',5,4.00,2.00),(7,'123456789012345','CD-R SONY 700 MB',1,20.00,20.00),(8,'1','uno',1,32.50,30.00),(8,'5','pro5',1,20.00,10.00),(8,'4','PRO 4',1,25.00,12.00),(8,'3','Producto 3',1,20.00,10.00),(8,'2','Producto 2',1,7.50,4.00),(9,'7','CARRE',1,7.50,4.00),(9,'6','SALAMIN',1,32.50,30.00),(9,'5','PERNIL CERDO',1,7500.00,4500.00),(9,'4','CHULETA DE CERDO',1,35.00,20.00),(9,'3','LOMO DE CERDO ',1,4.00,2.00),(9,'2','BONDIOLA',1,30.00,15.00),(9,'1','CHORIZO PURO CERDO',1,20.00,20.00),(10,'11','MATAMBRITO',13,20.00,10.00),(10,'6','SALAMIN',1,32.50,30.00),(10,'5','PERNIL CERDO',11,7500.00,4500.00),(10,'12','TRIPA',21,20.00,10.00),(10,'4','CHULETA DE CERDO',17,35.00,20.00),(10,'3','LOMO DE CERDO ',10,4.00,2.00),(10,'2','BONDIOLA',6,30.00,15.00),(1,'1','CHORIZO PURO CERDO',40,150.00,6000.00),(1,'5','PERNIL CERDO',6,1000.00,6000.00),(1,'1','CHORIZO PURO CERDO',200,150.00,30000.00),(1,'5','FRESCA DE CERDO',24,102.00,2417.40),(1,'1','PECHO DE CERDO',80,130.00,10346.57);
/*!40000 ALTER TABLE `09tblventasdetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `10tblempresa`
--

DROP TABLE IF EXISTS `10tblempresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `10tblempresa` (
  `strEmpresaNombre` varchar(40) DEFAULT NULL,
  `strEmpresaSucursal` varchar(40) DEFAULT NULL,
  `strEmpresaDireccion1` varchar(40) DEFAULT NULL,
  `strEmpresaDireccion2` varchar(40) DEFAULT NULL,
  `strEmpresaTelefonos` varchar(40) DEFAULT NULL,
  `strEmpresaRfc` varchar(13) DEFAULT NULL,
  `strEmpresaRegistro` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `10tblempresa`
--

LOCK TABLES `10tblempresa` WRITE;
/*!40000 ALTER TABLE `10tblempresa` DISABLE KEYS */;
INSERT INTO `10tblempresa` VALUES ('Pradera del Sur SRL','Berazategui','Domicilio Conocido','Buenos Aires','01112345678','0000','Demo');
/*!40000 ALTER TABLE `10tblempresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `11tblbitacora`
--

DROP TABLE IF EXISTS `11tblbitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `11tblbitacora` (
  `nick` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `dia` varchar(12) DEFAULT NULL,
  `hora` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `11tblbitacora`
--

LOCK TABLES `11tblbitacora` WRITE;
/*!40000 ALTER TABLE `11tblbitacora` DISABLE KEYS */;
INSERT INTO `11tblbitacora` VALUES ('jaor','Ingreso Sistema Procesos','2019-08-29','10:20:58'),('jaor','Reporte de Procesos','2019-08-29','09:43:50'),('jaor','Reporte de Bitácora','2019-08-28','07:36:14'),('jaor','Ingreso Sistema Procesos','2019-08-29','10:20:51'),('jaor','Ingreso al Sistema','2019-08-29','10:20:46'),('jaor','Ingreso al Sistema','2019-08-29','10:07:27'),('jaor','Ingreso Proceso de Inventarios','2019-08-29','09:56:50'),('jaor','Ingreso Proceso de Ventas','2019-08-29','09:44:16'),('jaor','Ingreso al Sistema','2019-08-28','12:14:06'),('jaor','Ingreso a Sistema Parámetros','2019-08-28','12:14:24'),('jaor','Ingreso Sistema Procesos','2019-08-28','12:14:50'),('jaor','Ingreso a Sistema Parámetros','2019-08-28','12:14:56'),('jaor','Ingreso Sistema Procesos','2019-08-28','12:16:01'),('jaor','Ingreso Sistema Usuarios','2019-08-28','12:16:24'),('jaor','Ingreso a Sistema Parámetros','2019-08-28','12:16:32'),('jaor','Ingreso Sistema Procesos','2019-08-28','12:16:37'),('jaor','Ingreso Sistema Procesos','2019-08-28','12:17:24'),('jaor','Ingreso Sistema Usuarios','2019-08-28','12:17:33'),('jaor','Ingreso Sistema Usuarios','2019-08-28','12:18:36'),('User01','Ingreso al Sistema','2019-08-28','12:20:22'),('jaor','Ingreso al Sistema','2019-08-28','02:07:42'),('jaor','Ingreso Catálogo de Productos','2019-08-28','02:07:47'),('jaor','Ingreso Sistema Usuarios','2019-08-28','02:08:39'),('jaor','Ingreso Sistema Procesos','2019-08-28','02:13:09'),('jaor','Ingreso Catálogo de Productos','2019-08-28','02:13:30'),('jaor','Salida del Sistema','2019-08-28','02:13:53'),('User02','Ingreso al Sistema','2019-08-28','02:16:50'),('User02','Ingreso Sistema Usuarios','2019-08-28','02:25:42'),('jaor','Ingreso al Sistema','2019-08-28','02:26:53'),('jaor','Ingreso Proceso de Inventarios','2019-08-28','02:26:55'),('jaor','Ingreso al Sistema','2019-08-28','02:31:41'),('jaor','Salida del Sistema','2019-08-28','02:32:10'),('User02','Ingreso al Sistema','2019-08-28','02:32:40'),('User02','Ingreso Sistema Procesos','2019-08-28','02:32:49'),('User02','Ingreso a Sistema Parámetros','2019-08-28','02:32:58'),('User02','Ingreso Sistema Usuarios','2019-08-28','02:33:05'),('User02','Salida del Sistema','2019-08-28','02:35:37'),('jaor','Ingreso al Sistema','2019-08-28','02:35:48'),('jaor','Reporte de Procesos','2019-08-28','02:36:26'),('jaor','Ingreso Proceso de Ventas','2019-08-28','02:37:31'),('jaor','Ingreso al Sistema','2019-08-28','02:44:07'),('jaor','Reporte de Procesos','2019-08-28','02:44:19'),('jaor','Ingreso al Sistema','2019-08-28','02:45:20'),('jaor','Reporte de Procesos','2019-08-28','02:45:23'),('jaor','Ingreso al Sistema','2019-08-28','02:46:10'),('jaor','Reporte de Procesos','2019-08-28','02:46:13'),('jaor','Ingreso al Sistema','2019-08-28','02:55:52'),('jaor','Reporte de Procesos','2019-08-28','02:55:58'),('jaor','Ingreso al Sistema','2019-08-28','03:02:44'),('jaor','Reporte de Procesos','2019-08-28','03:02:47'),('jaor','Ingreso al Sistema','2019-08-28','03:06:26'),('jaor','Reporte de Procesos','2019-08-28','03:06:28'),('jaor','Ingreso al Sistema','2019-08-28','03:11:47'),('jaor','Reporte de Procesos','2019-08-28','03:11:49'),('jaor','Ingreso al Sistema','2019-08-28','03:16:29'),('jaor','Reporte de Procesos','2019-08-28','03:16:32'),('jaor','Ingreso al Sistema','2019-08-28','03:18:25'),('jaor','Reporte de Procesos','2019-08-28','03:18:27'),('jaor','Ingreso al Sistema','2019-08-28','03:19:31'),('jaor','Reporte de Procesos','2019-08-28','03:19:33'),('jaor','Ingreso al Sistema','2019-08-28','03:40:09'),('jaor','Reporte de Procesos','2019-08-28','03:40:13'),('jaor','Ingreso al Sistema','2019-08-28','03:45:55'),('jaor','Reporte de Procesos','2019-08-28','03:46:00'),('jaor','Ingreso al Sistema','2019-08-28','03:51:54'),('jaor','Reporte de Procesos','2019-08-28','03:51:56'),('jaor','Ingreso al Sistema','2019-08-28','03:55:10'),('jaor','Reporte de Procesos','2019-08-28','03:55:13'),('jaor','Ingreso al Sistema','2019-08-28','03:57:58'),('jaor','Reporte de Procesos','2019-08-28','03:58:01'),('jaor','Ingreso al Sistema','2019-08-28','05:10:48'),('jaor','Reporte de Procesos','2019-08-28','05:10:50'),('jaor','Ingreso al Sistema','2019-08-28','05:14:40'),('jaor','Reporte de Procesos','2019-08-28','05:14:47'),('jaor','Ingreso al Sistema','2019-08-28','05:16:15'),('jaor','Reporte de Procesos','2019-08-28','05:16:43'),('jaor','Ingreso al Sistema','2019-08-28','05:46:22'),('jaor','Reporte de Procesos','2019-08-28','05:46:30'),('jaor','Ingreso al Sistema','2019-08-28','05:50:23'),('jaor','Reporte de Procesos','2019-08-28','05:50:31'),('jaor','Ingreso al Sistema','2019-08-28','06:02:25'),('jaor','Reporte de Procesos','2019-08-28','06:02:28'),('jaor','Ingreso al Sistema','2019-08-28','06:12:51'),('jaor','Reporte de Procesos','2019-08-28','06:13:08'),('jaor','Ingreso al Sistema','2019-08-28','06:18:54'),('jaor','Reporte de Procesos','2019-08-28','06:18:59'),('jaor','Ingreso al Sistema','2019-08-28','06:26:01'),('jaor','Reporte de Procesos','2019-08-28','06:26:05'),('jaor','Ingreso al Sistema','2019-08-28','06:28:41'),('jaor','Reporte de Procesos','2019-08-28','06:29:05'),('jaor','Ingreso al Sistema','2019-08-28','06:32:28'),('jaor','Reporte de Procesos','2019-08-28','06:32:31'),('jaor','Ingreso al Sistema','2019-08-28','06:35:21'),('jaor','Reporte de Procesos','2019-08-28','06:35:24'),('jaor','Ingreso al Sistema','2019-08-28','06:40:48'),('jaor','Reporte de Procesos','2019-08-28','06:40:53'),('jaor','Ingreso Catálogo de Productos','2019-08-28','06:41:37'),('jaor','Reporte de Usuarios','2019-08-28','06:43:13'),('jaor','Ingreso al Sistema','2019-08-28','06:56:43'),('jaor','Reporte de Usuarios','2019-08-28','06:56:52'),('jaor','Reporte de Ventas por Forma de Pago','2019-08-28','06:57:27'),('jaor','Reporte de Usuarios','2019-08-28','06:58:39'),('jaor','Reporte de Usuarios','2019-08-28','06:59:04'),('jaor','Ingreso al Sistema','2019-08-28','07:03:23'),('jaor','Reporte de Bitácora','2019-08-28','07:03:30'),('jaor','Ingreso al Sistema','2019-08-28','07:08:48'),('jaor','Reporte de Bitácora','2019-08-28','07:08:54'),('jaor','Ingreso al Sistema','2019-08-28','07:10:09'),('jaor','Reporte de Bitácora','2019-08-28','07:10:20'),('jaor','Ingreso al Sistema','2019-08-28','07:15:00'),('jaor','Reporte de Bitácora','2019-08-28','07:15:03'),('jaor','Ingreso al Sistema','2019-08-28','07:21:43'),('jaor','Reporte de Bitácora','2019-08-28','07:21:48'),('jaor','Ingreso al Sistema','2019-08-28','07:23:29'),('jaor','Reporte de Bitácora','2019-08-28','07:23:44'),('jaor','Ingreso al Sistema','2019-08-28','07:32:07'),('jaor','Reporte de Bitácora','2019-08-28','07:32:10'),('jaor','Ingreso al Sistema','2019-08-28','07:34:14'),('jaor','Reporte de Bitácora','2019-08-28','07:34:19'),('jaor','Ingreso Proceso de Ventas','2019-08-29','10:21:20'),('jaor','Ingreso al Sistema','2019-08-29','11:08:14'),('jaor','Reporte de Procesos','2019-08-29','11:08:26'),('jaor','Ingreso al Sistema','2019-08-29','11:27:52'),('jaor','Reporte de Procesos','2019-08-29','11:27:57'),('jaor','Ingreso al Sistema','2019-08-29','11:32:19'),('jaor','Ingreso al Sistema','2019-08-29','11:33:00'),('jaor','Ingreso al Sistema','2019-08-29','11:35:17'),('jaor','Reporte de Procesos','2019-08-29','11:35:20'),('jaor','Ingreso al Sistema','2019-08-29','11:38:39'),('jaor','Ingreso al Sistema','2019-08-30','12:05:33'),('jaor','Ingreso al Sistema','2019-08-30','12:07:49'),('jaor','Ingreso Proceso de Ventas','2019-08-30','12:07:55'),('jaor','Ingreso al Sistema','2019-08-30','12:12:54'),('jaor','Reporte de Bitácora','2019-08-30','12:13:04'),('jaor','Ingreso al Sistema','2019-08-30','12:24:54'),('jaor','Reporte de Procesos','2019-08-30','12:24:57'),('jaor','Reporte de Bitácora','2019-08-30','12:25:44'),('jaor','Ingreso al Sistema','2019-08-30','12:28:12'),('jaor','Reporte de Bitácora','2019-08-30','12:28:15'),('jaor','Ingreso al Sistema','2019-08-30','12:59:39'),('jaor','Ingreso Catálogo de Productos','2019-08-30','12:59:42'),('jaor','Ingreso Catálogo de Productos','2019-08-30','01:00:45'),('jaor','Reporte de Ventas','2019-08-30','01:01:02'),('jaor','Ingreso Proceso de Ventas','2019-08-30','01:01:27'),('jaor','Ingreso al Sistema','2019-08-30','01:09:08'),('jaor','Ingreso Proceso de Ventas','2019-08-30','01:09:14'),('jaor','Ingreso al Sistema','2019-08-30','01:11:00'),('jaor','Ingreso Proceso de Ventas','2019-08-30','01:11:02'),('jaor','Ingreso al Sistema','2019-08-30','01:17:28'),('jaor','Ingreso Proceso de Ventas','2019-08-30','01:17:30'),('jaor','Ingreso al Sistema','2019-10-29','10:05:42'),('jaor','Ingreso Proceso de Ventas','2019-10-29','10:05:55'),('jaor','Ingreso al Sistema','2019-11-05','12:01:58'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:02:01'),('jaor','Ingreso al Sistema','2019-11-05','12:05:27'),('jaor','Ingreso Sistema Procesos','2019-11-05','12:05:32'),('jaor','Ingreso al Sistema','2019-11-05','12:09:45'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:09:49'),('jaor','Ingreso al Sistema','2019-11-05','12:32:34'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:32:36'),('jaor','Ingreso al Sistema','2019-11-05','12:45:41'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:45:44'),('jaor','Ingreso al Sistema','2019-11-05','12:50:26'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:50:34'),('jaor','Ingreso al Sistema','2019-11-05','12:57:40'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:57:43'),('jaor','Ingreso al Sistema','2019-11-05','12:58:34'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','12:58:36'),('jaor','Ingreso al Sistema','2019-11-05','10:27:44'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','10:27:47'),('jaor','Ingreso al Sistema','2019-11-05','10:57:21'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','10:57:24'),('jaor','Ingreso al Sistema','2019-11-05','11:16:43'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','11:17:04'),('jaor','Ingreso al Sistema','2019-11-05','11:29:01'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','11:29:46'),('jaor','Ingreso al Sistema','2019-11-05','11:49:28'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-05','11:49:31'),('jaor','Ingreso al Sistema','2019-11-06','12:06:46'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:06:49'),('jaor','Ingreso al Sistema','2019-11-06','12:13:05'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:13:07'),('jaor','Ingreso al Sistema','2019-11-06','12:17:30'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:17:36'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:18:02'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:19:05'),('jaor','Ingreso al Sistema','2019-11-06','12:20:40'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:20:43'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:22:52'),('jaor','Ingreso al Sistema','2019-11-06','12:26:29'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:26:33'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-06','12:28:06'),('jaor','Ingreso al Sistema','2019-11-07','11:07:04'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:07:08'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:21:28'),('jaor','Ingreso al Sistema','2019-11-07','11:28:20'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:28:23'),('jaor','Ingreso al Sistema','2019-11-07','11:37:17'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:37:20'),('jaor','Ingreso al Sistema','2019-11-07','11:42:21'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:42:24'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:42:28'),('jaor','Ingreso al Sistema','2019-11-07','11:46:33'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:46:36'),('jaor','Ingreso al Sistema','2019-11-07','11:48:43'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:48:45'),('jaor','Ingreso al Sistema','2019-11-07','11:56:33'),('jaor','Ingreso Catálogo de Productos','2019-11-07','11:56:37'),('jaor','Ingreso al Sistema','2019-11-08','11:24:31'),('jaor','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-08','11:24:40'),('jaor','Ingreso Catálogo de Productos','2019-11-08','11:25:37'),('jaor','Ingreso Proceso de Ventas','2019-11-08','11:25:46'),('jaor','Ingreso al Sistema','2019-11-08','11:29:16'),('jaor','Ingreso Proceso de Ventas','2019-11-08','11:29:28'),('jaor','Ingreso al Sistema','2019-11-08','11:34:27'),('jaor','Ingreso Proceso de Ventas','2019-11-08','11:35:05'),('jaor','Ingreso Proceso de Ventas','2019-11-08','11:35:53'),('jaor','Ingreso Proceso de Ventas','2019-11-08','11:36:57'),('jaor','Ingreso al Sistema','2019-11-08','11:40:06'),('jaor','Ingreso Proceso de Ventas','2019-11-08','11:40:13'),('jorge','Ingreso al Sistema','2019-11-08','11:44:15'),('jorge','Ingreso Proceso de Ventas','2019-11-08','11:44:34'),('jorge','Ingreso Proceso de Ventas','2019-11-08','11:45:55'),('jorge','Ingreso Proceso de Ventas','2019-11-08','11:46:25'),('jorge','Ingreso al Sistema','2019-11-10','10:01:19'),('jorge','Ingreso Proceso de Ventas','2019-11-10','10:01:28'),('jorge','Ingreso Proceso de Ventas','2019-11-10','10:02:35'),('jorge','Ingreso al Sistema','2019-11-10','10:12:36'),('jorge','Ingreso Proceso de Ventas','2019-11-10','10:12:40'),('jorge','Ingreso al Sistema','2019-11-10','10:18:32'),('jorge','Ingreso Proceso de Ventas','2019-11-10','10:18:35'),('jorge','Ingreso al Sistema','2019-11-10','10:53:44'),('jorge','Ingreso Proceso de Ventas','2019-11-10','10:53:55'),('jorge','Ingreso al Sistema','2019-11-10','11:14:19'),('jorge','Ingreso Proceso de Ventas','2019-11-10','11:14:21'),('jorge','Ingreso Proceso de Ventas','2019-11-10','11:14:24'),('jorge','Ingreso al Sistema','2019-11-10','11:21:56'),('jorge','Ingreso Proceso de Ventas','2019-11-10','11:22:00'),('jorge','Ingreso Catálogo de Productos','2019-11-10','11:25:34'),('jorge','Ingreso al Sistema','2019-11-10','11:29:22'),('jorge','Ingreso Catálogo de Productos','2019-11-10','11:29:27'),('jorge','Ingreso al Sistema','2019-11-10','11:30:21'),('jorge','Ingreso Catálogo de Productos','2019-11-10','11:30:25'),('jorge','Ingreso al Sistema','2019-11-10','11:33:45'),('jorge','Ingreso Catálogo de Productos','2019-11-10','11:33:49'),('jorge','Ingreso al Sistema','2019-11-10','11:35:46'),('jorge','Ingreso Catálogo de Productos','2019-11-10','11:35:48'),('jorge','Ingreso al Sistema','2019-11-10','11:54:59'),('jorge','Reporte de Procesos','2019-11-10','11:55:02'),('jorge','Ingreso Sistema Procesos','2019-11-10','11:55:29'),('jorge','Ingreso Catálogo de Productos','2019-11-10','11:55:43'),('jorge','Ingreso al Sistema','2019-11-10','11:56:33'),('jorge','Ingreso Proceso de Ventas','2019-11-10','11:56:35'),('jorge','Ingreso al Sistema','2019-11-11','12:22:02'),('jorge','Ingreso Proceso de Ventas','2019-11-11','12:22:05'),('jorge','Ingreso al Sistema','2019-11-11','12:23:05'),('jorge','Ingreso Proceso de Ventas','2019-11-11','12:23:08'),('jorge','Ingreso al Sistema','2019-11-11','12:24:33'),('jorge','Ingreso Proceso de Ventas','2019-11-11','12:24:35'),('jorge','Ingreso al Sistema','2019-11-11','12:48:19'),('jorge','Ingreso Proceso de Ventas','2019-11-11','12:48:25'),('jorge','Ingreso al Sistema','2019-11-11','09:54:13'),('jorge','Ingreso Proceso de Ventas','2019-11-11','09:54:16'),('jorge','Ingreso al Sistema','2019-11-11','09:59:42'),('jorge','Ingreso Proceso de Ventas','2019-11-11','09:59:55'),('jorge','Ingreso al Sistema','2019-11-11','10:02:06'),('jorge','Ingreso Proceso de Ventas','2019-11-11','10:02:08'),('jorge','Ingreso al Sistema','2019-11-11','10:24:42'),('jorge','Ingreso Proceso de Ventas','2019-11-11','10:24:50'),('jorge','Ingreso al Sistema','2019-11-11','11:34:09'),('jorge','Ingreso Proceso de Ventas','2019-11-11','11:34:22'),('jorge','Ingreso Proceso de Ventas','2019-11-11','11:35:52'),('jorge','Ingreso al Sistema','2019-11-12','12:43:40'),('jorge','Ingreso Proceso de Ventas','2019-11-12','12:43:50'),('jorge','Ingreso al Sistema','2019-11-12','12:44:53'),('jorge','Ingreso Proceso de Ventas','2019-11-12','12:44:56'),('jorge','Ingreso al Sistema','2019-11-12','12:45:34'),('jorge','Ingreso Proceso de Ventas','2019-11-12','12:45:39'),('jorge','Ingreso al Sistema','2019-11-12','12:48:10'),('jorge','Ingreso Proceso de Ventas','2019-11-12','12:48:13'),('jorge','Ingreso al Sistema','2019-11-12','01:01:02'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:01:07'),('jorge','Ingreso al Sistema','2019-11-12','01:02:41'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:02:43'),('jorge','Ingreso al Sistema','2019-11-12','01:32:27'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:32:30'),('jorge','Ingreso al Sistema','2019-11-12','01:34:45'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:34:48'),('jorge','Ingreso al Sistema','2019-11-12','01:39:47'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:39:49'),('jorge','Ingreso al Sistema','2019-11-12','01:44:01'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:44:05'),('jorge','Ingreso al Sistema','2019-11-12','01:47:07'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:47:13'),('jorge','Ingreso al Sistema','2019-11-12','01:50:54'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:50:57'),('jorge','Ingreso al Sistema','2019-11-12','01:58:44'),('jorge','Ingreso Proceso de Ventas','2019-11-12','01:58:47'),('jorge','Ingreso al Sistema','2019-11-12','08:44:37'),('jorge','Ingreso Proceso de Ventas','2019-11-12','08:44:40'),('jorge','Ingreso Proceso de Ventas','2019-11-12','08:47:04'),('jorge','Ingreso al Sistema','2019-11-12','08:49:56'),('jorge','Ingreso Proceso de Ventas','2019-11-12','08:49:59'),('jorge','Ingreso al Sistema','2019-11-12','10:41:47'),('jorge','Ingreso Proceso de Ventas','2019-11-12','10:41:56'),('jorge','Ingreso al Sistema','2019-11-12','10:43:38'),('jorge','Ingreso Proceso de Ventas','2019-11-12','10:43:44'),('jorge','Ingreso al Sistema','2019-11-12','10:47:54'),('jorge','Ingreso Proceso de Ventas','2019-11-12','10:47:57'),('jorge','Ingreso al Sistema','2019-11-12','11:03:53'),('jorge','Ingreso Proceso de Ventas','2019-11-12','11:03:56'),('jorge','Ingreso al Sistema','2019-11-12','11:09:43'),('jorge','Ingreso Proceso de Ventas','2019-11-12','11:10:01'),('jorge','Ingreso al Sistema','2019-11-12','11:16:15'),('jorge','Ingreso Proceso de Ventas','2019-11-12','11:16:20'),('jorge','Ingreso al Sistema','2019-11-12','11:25:33'),('jorge','Ingreso Proceso de Ventas','2019-11-12','11:25:35'),('jorge','Ingreso al Sistema','2019-11-12','11:46:46'),('jorge','Ingreso Proceso de Ventas','2019-11-12','11:46:48'),('jorge','Ingreso Proceso de Ventas','2019-11-12','11:51:28'),('jorge','Ingreso al Sistema','2019-11-13','12:10:04'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:10:06'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:10:09'),('jorge','Ingreso al Sistema','2019-11-13','12:12:03'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:12:06'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:12:13'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:12:15'),('jorge','Ingreso al Sistema','2019-11-13','12:12:28'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:12:30'),('jorge','Ingreso al Sistema','2019-11-13','12:13:01'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:13:04'),('jorge','Ingreso al Sistema','2019-11-13','12:20:55'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:21:02'),('jorge','Ingreso al Sistema','2019-11-13','12:33:14'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:33:16'),('jorge','Ingreso al Sistema','2019-11-13','12:36:09'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:36:12'),('jorge','Ingreso al Sistema','2019-11-13','12:43:22'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:43:27'),('jorge','Ingreso al Sistema','2019-11-13','12:46:33'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:46:35'),('jorge','Ingreso al Sistema','2019-11-13','12:49:06'),('jorge','Ingreso Proceso de Ventas','2019-11-13','12:49:10'),('jorge','Ingreso al Sistema','2019-11-13','01:02:38'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:02:40'),('jorge','Ingreso al Sistema','2019-11-13','01:06:45'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:06:47'),('jorge','Ingreso al Sistema','2019-11-13','01:16:00'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:16:03'),('jorge','Ingreso al Sistema','2019-11-13','01:27:42'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:27:45'),('jorge','Ingreso al Sistema','2019-11-13','01:31:37'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:31:38'),('jorge','Ingreso al Sistema','2019-11-13','01:38:06'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:38:07'),('jorge','Ingreso al Sistema','2019-11-13','01:40:01'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:40:03'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:41:04'),('jorge','Ingreso al Sistema','2019-11-13','01:43:47'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:43:50'),('jorge','Ingreso al Sistema','2019-11-13','01:52:18'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:52:21'),('jorge','Ingreso al Sistema','2019-11-13','01:53:25'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:53:27'),('jorge','Ingreso al Sistema','2019-11-13','01:57:56'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:57:58'),('jorge','Ingreso al Sistema','2019-11-13','01:58:48'),('jorge','Ingreso Proceso de Ventas','2019-11-13','01:58:50'),('jorge','Ingreso al Sistema','2019-11-13','02:02:32'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:02:34'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:07:39'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:10:22'),('jorge','Ingreso al Sistema','2019-11-13','02:15:27'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:15:29'),('jorge','Ingreso al Sistema','2019-11-13','02:33:56'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:33:59'),('jorge','Ingreso al Sistema','2019-11-13','02:36:30'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:36:32'),('jorge','Ingreso Catálogo de Productos','2019-11-13','02:39:17'),('jorge','Ingreso al Sistema','2019-11-13','02:43:21'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:43:25'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:44:53'),('jorge','Ingreso al Sistema','2019-11-13','02:49:34'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:49:36'),('jorge','Ingreso al Sistema','2019-11-13','02:53:24'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:53:25'),('jorge','Ingreso al Sistema','2019-11-13','02:56:17'),('jorge','Ingreso Proceso de Ventas','2019-11-13','02:56:20'),('jorge','Ingreso al Sistema','2019-11-13','09:01:26'),('jorge','Ingreso Proceso de Ventas','2019-11-13','09:01:29'),('jorge','Ingreso al Sistema','2019-11-13','09:03:16'),('jorge','Ingreso Proceso de Ventas','2019-11-13','09:03:21'),('jorge','Ingreso a la Calculadora de Costos de Elaboracion','2019-11-13','09:11:33'),('jorge','Ingreso Catálogo de Productos','2019-11-13','09:17:07'),('jorge','Ingreso Proceso de Ventas','2019-11-13','09:18:49'),('jorge','Ingreso Proceso de Ventas','2019-11-13','09:19:50'),('jorge','Ingreso al Sistema','2019-11-23','05:57:46'),('jorge','Reporte de Procesos','2019-11-23','05:58:15'),('jorge','Ingreso Sistema Usuarios','2019-11-23','05:58:53'),('jorge','Ingreso al Sistema','2019-11-23','06:03:24'),('jorge','Ingreso a Sistema Parámetros','2019-11-23','06:04:25'),('jorge','Ingreso Sistema Procesos','2019-11-23','06:06:52'),('jorge','Ingreso al Sistema','2019-11-23','10:04:31'),('jorge','Ingreso a la configuracion de Envio de Mail','2019-11-23','10:04:37'),('jorge','Ingreso a la configuracion de Envio de Mail','2019-11-23','10:15:26'),('jorge','Ingreso Proceso de Ventas','2019-11-23','10:15:35'),('jorge','Ingreso al Sistema','2019-11-24','02:18:39'),('jorge','Ingreso Catálogo de Productos','2019-11-24','02:18:43'),('jorge','Ingreso a la configuracion de Envio de Mail','2019-11-24','02:23:45'),('jorge','Ingreso al Sistema','2019-11-24','02:26:43'),('jorge','Ingreso a la configuracion de Envio de Mail','2019-11-24','02:26:46'),('jorge','Ingreso Catálogo de Productos','2019-11-24','02:27:05'),('jorge','Ingreso Catálogo de Productos','2019-11-24','02:27:23'),('jorge','Ingreso a Ventas','2019-11-24','02:27:27'),('jorge','Ingreso al Sistema','2019-11-24','02:28:59'),('jorge','Ingreso al Sistema','2019-11-24','02:30:39'),('jorge','Ingreso al Sistema','2019-11-24','02:33:35'),('jorge','Ingreso al Sistema','2019-11-24','02:33:57'),('jorge','Ingreso al Sistema','2019-11-24','02:41:22'),('jorge','Ingreso al Sistema','2019-11-24','02:42:42'),('jorge','Ingreso al Sistema','2019-11-24','02:46:42'),('jorge','Ingreso al Sistema','2019-11-24','03:09:59'),('jorge','Ingreso al Sistema','2019-11-24','03:20:48'),('jorge','Ingreso al Sistema','2019-11-25','12:17:54'),('jorge','Ingreso a la configuracion de Clientes','2019-11-25','12:17:59'),('jorge','Salida del Sistema','2019-11-25','12:18:30'),('jorge','Ingreso al Sistema','2019-11-26','01:42:21'),('jorge','Ingreso a Ventas','2019-11-26','01:42:25'),('jorge','Salida del Sistema','2019-11-26','01:44:03'),('jorge','Ingreso al Sistema','2019-11-26','01:47:01'),('jorge','Ingreso a Ventas','2019-11-26','01:47:35'),('jorge','Ingreso al Sistema','2019-11-26','01:57:05'),('jorge','Ingreso a Ventas','2019-11-26','01:57:08'),('jorge','Ingreso al Sistema','2019-11-26','01:57:58'),('jorge','Ingreso a Ventas','2019-11-26','01:58:00'),('jorge','Salida del Sistema','2019-11-26','02:00:20'),('jorge','Ingreso al Sistema','2019-11-26','09:47:15'),('jorge','Ingreso a Ventas','2019-11-26','09:47:21'),('jorge','Ingreso al Sistema','2019-11-29','12:55:23'),('jorge','Ingreso a Ventas','2019-11-29','12:55:26'),('jorge','Salida del Sistema','2019-11-29','12:56:09'),('jorge','Ingreso al Sistema','2019-11-29','01:04:31'),('jorge','Ingreso a Ventas','2019-11-29','01:04:34'),('jorge','Salida del Sistema','2019-11-29','01:04:51'),('jorge','Ingreso al Sistema','2019-11-29','01:11:17'),('jorge','Ingreso a Ventas','2019-11-29','01:11:21'),('jorge','Ingreso al Sistema','2019-11-29','01:22:03'),('jorge','Ingreso a Ventas','2019-11-29','01:22:06'),('jorge','Ingreso al Sistema','2019-11-29','01:24:42'),('jorge','Ingreso a Ventas','2019-11-29','01:24:44'),('jorge','Ingreso al Sistema','2019-11-29','01:29:52'),('jorge','Ingreso a Ventas','2019-11-29','01:29:54'),('jorge','Ingreso al Sistema','2019-11-29','01:35:48'),('jorge','Ingreso a Ventas','2019-11-29','01:35:53'),('jorge','Ingreso al Sistema','2019-11-29','01:46:54'),('jorge','Ingreso a Ventas','2019-11-29','01:53:07'),('jorge','Ingreso al Sistema','2019-11-29','02:07:28'),('jorge','Ingreso a Ventas','2019-11-29','02:07:30'),('jorge','Ingreso al Sistema','2019-11-29','02:11:21'),('jorge','Ingreso a Ventas','2019-11-29','02:11:23'),('jorge','Ingreso al Sistema','2019-11-29','02:17:37'),('jorge','Ingreso a Ventas','2019-11-29','02:17:40'),('jorge','Ingreso al Sistema','2019-11-29','02:20:22'),('jorge','Ingreso a Ventas','2019-11-29','02:20:26'),('jorge','Ingreso al Sistema','2019-11-29','02:45:46'),('jorge','Ingreso a la Configuracion de Puertos','2019-11-29','02:45:49');
/*!40000 ALTER TABLE `11tblbitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `12tblclientes`
--

DROP TABLE IF EXISTS `12tblclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `12tblclientes` (
  `intClienteCodigo` int(10) NOT NULL,
  `strClienteNombre` varchar(20) NOT NULL,
  `strClienteApellido` varchar(50) NOT NULL,
  `strClienteDomicilio` varchar(50) DEFAULT NULL,
  `strClienteLocalidad` varchar(50) DEFAULT NULL,
  `strCodigoPostal` varchar(50) DEFAULT NULL,
  `strClienteTelefono` varchar(50) DEFAULT NULL,
  `intCodigoCuentaCorriente` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Clientes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `12tblclientes`
--

LOCK TABLES `12tblclientes` WRITE;
/*!40000 ALTER TABLE `12tblclientes` DISABLE KEYS */;
INSERT INTO `12tblclientes` VALUES (1,'MARTIN COLO','REGUE','CALLE 1234','QUILMES','1223-456','1878',1),(2,'VASCO','VASCO','CALLE 4444','BERAZATEGUI','1223-456','1879',2),(3,'CARLOS','CARLOS','CALLE 567','LA PLATA','1223-456','1890',3),(4,'CARMEN','CARMEN','CARMEN 3456','FCIO. VARELA','1223-456','1789',4);
/*!40000 ALTER TABLE `12tblclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `13tbldetallectacte`
--

DROP TABLE IF EXISTS `13tbldetallectacte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `13tbldetallectacte` (
  `intCtaCteCodigo` int(10) NOT NULL,
  `intClienteCodigo` int(10) NOT NULL,
  `decDebe` decimal(12,2) DEFAULT NULL,
  `decHaber` decimal(12,2) DEFAULT NULL,
  `decAFavor` decimal(12,2) DEFAULT NULL,
  `datFecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Estado de Cuenta Clientes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `13tbldetallectacte`
--

LOCK TABLES `13tbldetallectacte` WRITE;
/*!40000 ALTER TABLE `13tbldetallectacte` DISABLE KEYS */;
INSERT INTO `13tbldetallectacte` VALUES (1,1,190.00,0.00,50.00,'2019-11-23 10:59:49'),(2,2,130.00,0.00,10.00,'2019-11-23 10:59:50'),(3,3,150.00,0.00,25.00,'2019-11-23 10:59:51'),(4,4,180.00,0.00,30.00,'2019-11-23 10:59:52');
/*!40000 ALTER TABLE `13tbldetallectacte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `14tblconfigmail`
--

DROP TABLE IF EXISTS `14tblconfigmail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `14tblconfigmail` (
  `strRemitente` varchar(50) NOT NULL,
  `strDestinatario` varchar(50) NOT NULL,
  `strCopia` varchar(50) DEFAULT NULL,
  `strCopiaOculta` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Conf de Envio de Mail';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `14tblconfigmail`
--

LOCK TABLES `14tblconfigmail` WRITE;
/*!40000 ALTER TABLE `14tblconfigmail` DISABLE KEYS */;
INSERT INTO `14tblconfigmail` VALUES ('infopraderadelsur@gmail.com','claudiogomezcaballero@gmail.com','','');
/*!40000 ALTER TABLE `14tblconfigmail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `15tblconfigpuertoserial`
--


DROP TABLE IF EXISTS `15tblconfigpuertoserial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `15tblconfigpuertoserial` (
  `strPuerto` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Conf de Puerto Serie';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `15tblconfigpuertoserial`
--

LOCK TABLES `15tblconfigpuertoserial` WRITE;
/*!40000 ALTER TABLE `15tblconfigpuertoserial` DISABLE KEYS */;
INSERT INTO `15tblconfigpuertoserial` VALUES ('COM5');
/*!40000 ALTER TABLE `15tblconfigpuertoserial` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `16tblconfigarchivoimportar`
--


DROP TABLE IF EXISTS `16tblconfigarchivoimportar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `16tblconfigarchivoimportar` (
  `strRuta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Conf de Archivo de Listado de Art.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `16tblconfigarchivoimportar`
--

LOCK TABLES `16tblconfigarchivoimportar` WRITE;
/*!40000 ALTER TABLE `15tblconfigpuertoserial` DISABLE KEYS */;
INSERT INTO `16tblconfigarchivoimportar` VALUES ('c:\\productos_imp.csv');
/*!40000 ALTER TABLE `15tblconfigpuertoserial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'test'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-29  3:01:03
