-- MySQL dump 10.13  Distrib 5.5.20, for Win32 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.20-log

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Usuarios del Sistema\r\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `01tblusers`
--

LOCK TABLES `01tblusers` WRITE;
/*!40000 ALTER TABLE `01tblusers` DISABLE KEYS */;
INSERT INTO `01tblusers` VALUES ('jaor','software','jaorsoftware','administra'),('mao','olmedo','marco','usuario'),('test','test','asdfas','supervisor'),('User01','olmedo','User 01 Nombre','2primeros'),('User02','olmedo','User 02','2primeros');
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
INSERT INTO `02tblprocesos` VALUES ('sis-pro-01','SISTEMA PROCESOS'),('sis-usu-01','SISTEMA USUARIOS'),('sis-par-01','SISTEMA PARAMETROS'),('cat-pro-01','CATALOGOS-PRODUCTOS');
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
INSERT INTO `03tblrolprocesos` VALUES ('otrorole','sis-pro-01'),('supervisor','sis-pro-01'),('supervisor','sis-par-01'),('usuario','sis-usu-01'),('usuario','sis-sal-01'),('administra','sis-pro-01'),('administra','sis-usu-01'),('administra','sis-par-01'),('administra','sis-sal-01'),('2primeros','sis-pro-01'),('2primeros','sis-usu-01');
/*!40000 ALTER TABLE `03tblrolprocesos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `04tblproductos`
--

DROP TABLE IF EXISTS `04tblproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `04tblproductos` (
  `strProductoCodigo` varchar(15) DEFAULT NULL,
  `strProductoNombre` varchar(20) DEFAULT NULL,
  `strProductoDescripcion` varchar(50) DEFAULT NULL,
  `strProductoMedida` varchar(5) DEFAULT NULL,
  `intProductoInicial` int(11) DEFAULT NULL,
  `intProductoEntradas` int(11) DEFAULT NULL,
  `intProductoSalidas` int(11) DEFAULT NULL,
  `intProductoActual` int(11) DEFAULT NULL,
  `decProductoCosto` decimal(10,2) DEFAULT NULL,
  `decProductoPrecio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de Productos a manejar Inventario';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `04tblproductos`
--

LOCK TABLES `04tblproductos` WRITE;
/*!40000 ALTER TABLE `04tblproductos` DISABLE KEYS */;
INSERT INTO `04tblproductos` VALUES ('123456789012345','CD-R SONY 700 MB','COMPACT DISC SONY 700','PZA',20,0,1,19,20.00,20.00),('12345678901237','CD-W SONY 700 MB','CD-W SONY 700 MB REGRABABLE','PZA',10,0,1,9,15.00,30.00),('123456789018','GOMA MIGAJON ','GOMA DE MIGAJON GRANDE MIRADO','UNID',10,0,5,5,2.00,4.00),('778665443333','LAPIZ MIRADO 2B','LAPIZ MARCA MIRADO 2B AMARILLO','PZA',30,0,2,28,20.00,35.00),('9999999999','TV SONY','TELEVISION SONY','PZA',10,0,0,10,4500.00,7500.00),('1','uno','producto uno','PZA',100,0,1,99,30.00,32.50),('2','Producto 2','Descripcion Producto 2','PZA',10,0,1,9,4.00,7.50),('3','Producto 3','Producto Numero 3','PZA',10,0,0,10,10.00,20.00),('4','PRO 4','PRODUCTO 4','UNID',10,0,0,10,12.00,25.00),('5','pro5','producto 5','PZA',5,0,5,0,10.00,20.00);
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
INSERT INTO `05tblfolios` VALUES (17,8);
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
INSERT INTO `06tblinventario` VALUES (1,'Salida','2012-03-22 10:59:49',1,'2',1,'Salida por Venta'),(2,'Salida','2012-03-22 10:59:49',1,'1',1,'Salida por Venta'),(3,'Salida','2012-03-22 11:22:40',2,'4',2,'Salida por Venta'),(4,'Salida','2012-03-22 11:22:40',2,'3',2,'Salida por Venta'),(5,'Entrada','2012-03-22 11:22:40',2,'4',2,'Entrada por Cancelación de Venta'),(6,'Entrada','2012-03-22 11:22:40',2,'3',2,'Entrada por Cancelación de Venta'),(7,'Salida','2012-03-22 11:37:12',2,'4',3,'Salida por Venta'),(8,'Salida','2012-03-22 11:37:12',2,'3',3,'Salida por Venta'),(9,'Entrada','2012-03-22 11:37:12',2,'4',3,'Entrada por Cancelación de Venta'),(10,'Entrada','2012-03-22 11:37:12',2,'3',3,'Entrada por Cancelación de Venta'),(11,'Salida','2012-03-23 10:31:16',5,'5',0,'Prueba de sistemas'),(12,'Salida','2012-05-18 05:00:45',1,'778665443333',4,'Salida por Venta'),(13,'Salida','2012-05-18 05:10:14',1,'778665443333',5,'Salida por Venta'),(14,'Salida','2012-05-18 05:10:14',1,'12345678901237',5,'Salida por Venta'),(15,'Salida','2012-05-22 07:03:36',5,'123456789018',6,'Salida por Venta'),(16,'Salida','2012-07-14 05:45:29',1,'123456789012345',7,'Salida por Venta');
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
  `intVerificarExistencias` tinyint(1) unsigned NOT NULL,
  `strTicketInfoFinal` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `07tblparametros`
--

LOCK TABLES `07tblparametros` WRITE;
/*!40000 ALTER TABLE `07tblparametros` DISABLE KEYS */;
INSERT INTO `07tblparametros` VALUES (1,1,0,'OVCars Vehículos Ecológicos');
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
  `strVentaFormaPago` varchar(8) NOT NULL,
  `strVentaCancelada` varchar(50) DEFAULT NULL,
  `strVentaReferencia` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `08tblventas`
--

LOCK TABLES `08tblventas` WRITE;
/*!40000 ALTER TABLE `08tblventas` DISABLE KEYS */;
INSERT INTO `08tblventas` VALUES (1,'2012-03-22 10:59:49',2,40.00,6.00,'Efectivo','',''),(2,'2012-03-22 11:22:40',4,90.00,46.00,'Tarjeta','PRUEBA DE SISTEMAS','IFE-12312312312'),(3,'2012-03-22 11:37:12',4,90.00,46.00,'Efectivo','CANCELACION PRUEBA DE SISTEMAS',''),(4,'2012-05-18 05:00:45',1,35.00,15.00,'Efectivo','',''),(5,'2012-05-18 05:10:14',2,65.00,30.00,'Efectivo','',''),(6,'2012-05-22 07:03:36',5,20.00,10.00,'Efectivo','',''),(7,'2012-07-14 05:45:29',1,20.00,0.00,'Efectivo','','');
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
INSERT INTO `09tblventasdetalle` VALUES (1,'2','Producto 2',1,7.50,4.00),(1,'1','uno',1,32.50,30.00),(2,'4','PRO 4',2,25.00,12.00),(2,'3','Producto 3',2,20.00,10.00),(3,'4','PRO 4',2,25.00,12.00),(3,'3','Producto 3',2,20.00,10.00),(4,'778665443333','LAPIZ MIRADO 2B',1,35.00,20.00),(5,'778665443333','LAPIZ MIRADO 2B',1,35.00,20.00),(5,'12345678901237','CD-W SONY 700 MB',1,30.00,15.00),(6,'123456789018','GOMA MIGAJON ',5,4.00,2.00),(7,'123456789012345','CD-R SONY 700 MB',1,20.00,20.00);
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
INSERT INTO `10tblempresa` VALUES ('OVCars S.A. de C.V.','Puebla','Domicilio Conocido','México, D.F.','01-800-12341234','OVCS18052012P','Demo');
/*!40000 ALTER TABLE `10tblempresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacora` (
  `nick` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `dia` varchar(12) DEFAULT NULL,
  `hora` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
INSERT INTO `bitacora` VALUES ('jaorsoftware','127.0.0.1','13.Feb.2012','12:58:39'),('jaor','127.0.0.1','29.Mar.2012','23:08:46'),('jaor','127.0.0.1','26.Apr.2012','13:54:51'),('jaorsoftware','127.0.0.1','13.Jun.2012','19:42:09'),('jaorsoftware','127.0.0.1','13.Jun.2012','19:59:02'),('jaorsoftware','127.0.0.1','07.Jul.2012','19:44:00'),('jaorsoftware','127.0.0.1','07.Jul.2012','22:19:35'),('jaorsoftware','127.0.0.1','09.Jul.2012','04:47:40'),('jaorsoftware','127.0.0.1','09.Jul.2012','05:22:50'),('jaorsoftware','127.0.0.1','14.Jul.2012','01:23:25'),('jaorsoftware','127.0.0.1','16.Jul.2012','00:26:38'),('jaorsoftware','127.0.0.1','16.Jul.2012','02:34:50'),('jaorsoftware','127.0.0.1','18.Jul.2012','01:54:44');
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

