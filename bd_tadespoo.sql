-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bd_tadespoo
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_acompanhe`
--

CREATE DATABASE bd_tadespoo;

use bd_tadespoo;

DROP TABLE IF EXISTS `tb_acompanhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_acompanhe` (
  `id_acompanhe` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_acompanhe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_acompanhe`
--

LOCK TABLES `tb_acompanhe` WRITE;
/*!40000 ALTER TABLE `tb_acompanhe` DISABLE KEYS */;
INSERT INTO `tb_acompanhe` VALUES (1,'Pedido Pedendente','2020-06-01',1,NULL,NULL),(2,'Pedido Entregue','2020-06-01',1,NULL,NULL),(3,'Pedido Cancelado','2020-06-01',1,NULL,NULL),(4,'Pedido Aprovado','2020-06-01',1,NULL,NULL);
/*!40000 ALTER TABLE `tb_acompanhe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalhe_pedido`
--

DROP TABLE IF EXISTS `tb_detalhe_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalhe_pedido` (
  `id_detalhepedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `qtde` int(11) NOT NULL,
  `valor` decimal(15,2) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_detalhepedido`),
  KEY `detalhe_id_produtofk` (`id_produto`),
  KEY `acompanhe_id_pedido_fk` (`id_pedido`),
  CONSTRAINT `acompanhe_id_pedido_fk` FOREIGN KEY (`id_pedido`) REFERENCES `tb_pedido` (`id_pedido`),
  CONSTRAINT `detalhe_id_produtofk` FOREIGN KEY (`id_produto`) REFERENCES `tb_produto` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalhe_pedido`
--

LOCK TABLES `tb_detalhe_pedido` WRITE;
/*!40000 ALTER TABLE `tb_detalhe_pedido` DISABLE KEYS */;
INSERT INTO `tb_detalhe_pedido` VALUES (7,1,3,6,182.40,'2020-02-05',1,NULL,NULL),(8,1,2,3,121.50,'2020-02-05',1,NULL,NULL),(9,1,1,5,51.00,'2020-02-05',1,NULL,NULL),(10,2,3,1,30.40,'2020-02-05',1,NULL,NULL),(11,2,2,2,60.80,'2020-02-05',1,NULL,NULL),(12,2,1,3,91.20,'2020-02-05',1,NULL,NULL),(13,3,2,7,212.80,'2020-02-05',1,NULL,NULL),(14,3,2,8,243.20,'2020-02-05',1,NULL,NULL),(15,3,2,4,121.60,'2020-02-05',1,NULL,NULL),(17,5,1,2,52.65,'2020-06-05',3,NULL,NULL);
/*!40000 ALTER TABLE `tb_detalhe_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `rua` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `numero` varchar(7) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `usuario_endereco_fk` (`id_usuario`),
  CONSTRAINT `usuario_endereco_fk` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
INSERT INTO `tb_endereco` VALUES (1,1,'05780-392','SEM RUA','SEM BAIRRO','0','Casa',NULL,NULL),(2,3,'05750-320','Rua Pedro Gomes da Costa','Vila Praia','46','Casa',NULL,NULL);
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_filial`
--

DROP TABLE IF EXISTS `tb_filial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_filial` (
  `id_filial` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `Descricao` varchar(100) DEFAULT NULL,
  `cnpj` varchar(15) DEFAULT NULL,
  `telefone` bigint(20) NOT NULL,
  `cep` int(11) NOT NULL,
  `rua` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `numero` varchar(7) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_filial`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_filial`
--

LOCK TABLES `tb_filial` WRITE;
/*!40000 ALTER TABLE `tb_filial` DISABLE KEYS */;
INSERT INTO `tb_filial` VALUES (1,'Matriz','Matriz da loja','1565656',0,5780392,'Rua Pedro Alvares Cabral','Vera Cruz','168',NULL,NULL,NULL,NULL,NULL),(2,'Filial Jardim Sul','Loja no Jardim sul','17261661008158',11945652649,45698756,'Giovanni Gronchi','VilaAndrade','208','Prédio','2020-06-05',1,NULL,NULL),(3,'Filial Campinas','Filial em São Paulo','1010101000101',11945649854,45678913,'Avenida Mario Covas','Mariorinho','256','Prédio','2020-06-05',1,NULL,NULL);
/*!40000 ALTER TABLE `tb_filial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_item_venda`
--

DROP TABLE IF EXISTS `tb_item_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_item_venda` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id_item`),
  KEY `produto_item_venda_fk` (`id_produto`),
  KEY `venda_item_venda_fk` (`id_venda`),
  CONSTRAINT `produto_item_venda_fk` FOREIGN KEY (`id_produto`) REFERENCES `tb_produto` (`id_produto`),
  CONSTRAINT `venda_item_venda_fk` FOREIGN KEY (`id_venda`) REFERENCES `tb_venda` (`id_venda`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_item_venda`
--

LOCK TABLES `tb_item_venda` WRITE;
/*!40000 ALTER TABLE `tb_item_venda` DISABLE KEYS */;
INSERT INTO `tb_item_venda` VALUES (1,1,1,2,10.2),(2,4,1,2,245.69),(3,1,2,2,20.399999618530273);
/*!40000 ALTER TABLE `tb_item_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `pagina` varchar(50) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_filial` int(11) NOT NULL,
  `id_acompanhe` int(11) NOT NULL,
  `Valor` decimal(15,2) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `filial_id_filial_fk` (`id_filial`),
  KEY `acompanhe_id_acompanhe_fk` (`id_acompanhe`),
  CONSTRAINT `acompanhe_id_acompanhe_fk` FOREIGN KEY (`id_acompanhe`) REFERENCES `tb_acompanhe` (`id_acompanhe`),
  CONSTRAINT `filial_id_filial_fk` FOREIGN KEY (`id_filial`) REFERENCES `tb_filial` (`id_filial`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES (1,2,1,354.90,'2020-02-05',1,NULL,NULL),(2,2,3,182.40,'2020-02-05',1,NULL,NULL),(3,2,2,577.60,'2020-02-05',1,NULL,NULL),(4,3,1,NULL,'2020-06-05',3,NULL,NULL),(5,3,1,52.65,'2020-06-05',3,NULL,NULL);
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_perfil`
--

DROP TABLE IF EXISTS `tb_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(30) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perfil`
--

LOCK TABLES `tb_perfil` WRITE;
/*!40000 ALTER TABLE `tb_perfil` DISABLE KEYS */;
INSERT INTO `tb_perfil` VALUES (1,'Administrador','Usuario Administrador para teste','2020-06-04',1,NULL,NULL),(2,'Gerente','Usuario gerente para teste','2020-06-04',1,NULL,NULL),(3,'Cliente','Clientes do sistema','2020-06-05',1,NULL,NULL),(4,'Vendedor','Vendedor da Loja','2020-06-05',1,NULL,NULL);
/*!40000 ALTER TABLE `tb_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_permissao`
--

DROP TABLE IF EXISTS `tb_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_permissao` (
  `id_permissao` int(11) NOT NULL AUTO_INCREMENT,
  `id_perfil` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_permissao`),
  KEY `perfil_id_perfil_fk` (`id_perfil`),
  KEY `menu_id_menu_fk` (`id_menu`),
  CONSTRAINT `menu_id_menu_fk` FOREIGN KEY (`id_menu`) REFERENCES `tb_menu` (`id_menu`),
  CONSTRAINT `perfil_id_perfil_fk` FOREIGN KEY (`id_perfil`) REFERENCES `tb_perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_permissao`
--

LOCK TABLES `tb_permissao` WRITE;
/*!40000 ALTER TABLE `tb_permissao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produto`
--

DROP TABLE IF EXISTS `tb_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_filial` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `qtde` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` decimal(15,2) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `Filiais_produto_fk` (`id_filial`),
  KEY `usuario_produto_fk` (`id_usuario`),
  CONSTRAINT `Filiais_produto_fk` FOREIGN KEY (`id_filial`) REFERENCES `tb_filial` (`id_filial`),
  CONSTRAINT `usuario_produto_fk` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produto`
--

LOCK TABLES `tb_produto` WRITE;
/*!40000 ALTER TABLE `tb_produto` DISABLE KEYS */;
INSERT INTO `tb_produto` VALUES (1,1,1,'limpeza','Limpa vidro 30 ml',4,'limpador de vidro para automoveis',10.20,NULL,NULL),(2,1,1,'Rodas','Rodas aro 17',5,'Roda aro 17 importada',45.56,NULL,NULL),(3,1,1,'Painel automotivo','Painel Mercedes AMG',8,'Painel da mercedes amg r?plica 1 linha',30.40,'2020-06-05',1),(4,1,2,'Suspensão','Amortecedor - GM',10,'Amortecedor para Celta',245.69,NULL,NULL);
/*!40000 ALTER TABLE `tb_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_status_venda`
--

DROP TABLE IF EXISTS `tb_status_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_status_venda` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(30) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_status_venda`
--

LOCK TABLES `tb_status_venda` WRITE;
/*!40000 ALTER TABLE `tb_status_venda` DISABLE KEYS */;
INSERT INTO `tb_status_venda` VALUES (1,'Finalizada','Venda efetuada com sucesso',NULL,NULL,NULL,NULL),(2,'Cancelada','Venda Cancelada com sucesso',NULL,NULL,NULL,NULL),(3,'Inciada','Venda Inciada com sucesso',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_status_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_perfil` int(11) NOT NULL,
  `id_filial` int(11) NOT NULL,
  `cpf_cnpj` varchar(13) NOT NULL,
  `rg` varchar(9) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(250) NOT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `sexo` varchar(10) NOT NULL,
  `empresa` tinyint(1) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `Filiais_usuario_fk` (`id_filial`),
  KEY `perfil_usuario_fk` (`id_perfil`),
  CONSTRAINT `Filiais_usuario_fk` FOREIGN KEY (`id_filial`) REFERENCES `tb_filial` (`id_filial`),
  CONSTRAINT `perfil_usuario_fk` FOREIGN KEY (`id_perfil`) REFERENCES `tb_perfil` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,2,2,'58596986523','333355112','Administrador','admin@admin.com','161ebd7d45089b3446ee4e0d86dbcf92',11654987216,'masculino',1,'2020-06-04','2020-06-05',1,NULL,NULL),(2,1,1,'23579882','334355112','J?ssica groove','je.groove@gmail.com','e10adc3949ba59abbe56e057f20f883e',58133758,'indefinido',0,'2020-06-04','2020-06-04',NULL,NULL,NULL),(3,3,3,'40608550817','525160280','Gustavo Santos Nascimento','caous.g@gmail.com','e10adc3949ba59abbe56e057f20f883e',11942616650,'',1,'2000-04-05','2020-06-05',1,NULL,1);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_venda`
--

DROP TABLE IF EXISTS `tb_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `id_status` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_filial` int(11) NOT NULL,
  `cpf_cnpj` varchar(13) NOT NULL,
  `pagamento` tinyint(1) NOT NULL,
  `parcelas` int(11) NOT NULL,
  `total` decimal(15,2) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  `codigo_rastreio` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `Filiais_venda_fk` (`id_filial`),
  KEY `status_venda_venda_fk` (`id_status`),
  KEY `endereco_venda_fk` (`id_endereco`),
  CONSTRAINT `Filiais_venda_fk` FOREIGN KEY (`id_filial`) REFERENCES `tb_filial` (`id_filial`),
  CONSTRAINT `endereco_venda_fk` FOREIGN KEY (`id_endereco`) REFERENCES `tb_endereco` (`id_endereco`),
  CONSTRAINT `status_venda_venda_fk` FOREIGN KEY (`id_status`) REFERENCES `tb_status_venda` (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_venda`
--

LOCK TABLES `tb_venda` WRITE;
/*!40000 ALTER TABLE `tb_venda` DISABLE KEYS */;
INSERT INTO `tb_venda` VALUES (1,3,1,1,1,'40608550817',1,1,512.00,'2020-04-27',NULL,NULL,NULL),(2,3,1,1,2,'40608550817',3,0,20.00,'2020-06-05',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05 15:51:09
