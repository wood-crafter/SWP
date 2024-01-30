-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: oof_badminton
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `banners`
--

LOCK TABLES `banners` WRITE;
/*!40000 ALTER TABLE `banners` DISABLE KEYS */;
INSERT INTO `banners` VALUES (1,NULL,NULL,NULL,NULL,'/api/image/1_banner.png'),(2,NULL,NULL,NULL,NULL,'/api/image/2_banner.png'),(3,NULL,NULL,NULL,NULL,'/api/image/3_banner.png'),(4,NULL,NULL,NULL,NULL,'/api/image/4_banner.png');
/*!40000 ALTER TABLE `banners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (23,NULL,2,1,2,'2023-11-10 04:24:43.049000',2,'2023-11-10 04:24:43.049000'),(24,NULL,2,1,2,'2023-11-10 04:24:48.460000',2,'2023-11-10 04:24:48.460000'),(25,NULL,2,1,2,'2023-11-10 04:24:52.975000',2,'2023-11-10 04:24:52.975000'),(26,NULL,2,2,2,'2023-11-10 04:24:57.800000',2,'2023-11-10 04:25:14.329000'),(27,NULL,2,1,2,'2023-11-10 04:25:01.681000',2,'2023-11-10 04:25:01.681000'),(28,NULL,2,2,2,'2023-11-10 04:25:09.648000',2,'2023-11-10 04:29:09.220000'),(29,NULL,2,1,2,'2023-11-10 04:25:19.077000',2,'2023-11-10 04:25:19.077000'),(30,NULL,2,1,2,'2023-11-10 04:25:22.783000',2,'2023-11-10 04:25:22.783000'),(31,NULL,2,1,2,'2023-11-10 04:25:25.538000',2,'2023-11-10 04:25:25.538000'),(32,NULL,2,1,2,'2023-11-10 04:25:28.569000',2,'2023-11-10 04:25:28.569000');
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Vợt cầu lông',NULL,NULL,NULL,NULL,'/api/image/1_Vợt cầu lông.png'),(2,'Giày cầu lông',NULL,NULL,NULL,NULL,'/api/image/2_Giày cầu lông.png'),(3,'Áo cầu lông',NULL,NULL,NULL,NULL,'/api/image/3_Áo cầu lông.png'),(4,'Quần cầu lông',NULL,NULL,NULL,NULL,'/api/image/4_Quần cầu lông.png'),(5,'Tất cầu lông',NULL,NULL,NULL,NULL,'/api/image/5_Tất cầu lông.png'),(6,'Bao vợt',NULL,NULL,NULL,NULL,'/api/image/6_Bao vợt.png');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (13,1,'2023-11-10 13:13:09.279000',1,'2023-11-10 13:13:09.279000','Hang chat luong tot','Do Duc Duong',4,45),(14,1,'2023-11-10 14:35:54.826000',1,'2023-11-10 14:35:54.826000','ádasd','Do Duc Duong',4,1),(15,1,'2023-11-10 14:35:54.825000',1,'2023-11-10 14:35:54.825000','ádasd','Do Duc Duong',4,1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (9,1,NULL,'4U5',10,NULL,1,'2023-10-29 14:09:33.911000',1,'2023-10-29 14:09:33.911000'),(10,1,NULL,'',10,NULL,1,'2023-10-29 14:09:33.913000',1,'2023-10-29 14:09:33.913000'),(11,1,NULL,'4U5',11,NULL,1,'2023-10-29 15:03:36.920000',1,'2023-10-29 15:03:36.920000'),(16,1,NULL,'4U5',16,NULL,1,'2023-11-08 02:45:35.887000',1,'2023-11-08 02:45:35.887000'),(17,35,NULL,NULL,18,NULL,1,'2023-11-10 00:24:33.216000',1,'2023-11-10 00:24:33.216000'),(18,3,NULL,NULL,18,NULL,1,'2023-11-10 00:24:33.248000',1,'2023-11-10 00:24:33.248000'),(19,8,NULL,NULL,19,NULL,1,'2023-11-10 00:26:06.812000',1,'2023-11-10 00:26:06.812000'),(20,6,NULL,NULL,20,NULL,1,'2023-11-10 00:26:26.302000',1,'2023-11-10 00:26:26.302000'),(21,1,NULL,NULL,21,NULL,1,'2023-11-10 00:30:04.697000',1,'2023-11-10 00:30:04.697000'),(22,2,NULL,NULL,21,NULL,1,'2023-11-10 00:30:04.698000',1,'2023-11-10 00:30:04.698000'),(23,2,3850000,NULL,22,NULL,1,'2023-11-10 00:32:41.025000',1,'2023-11-10 00:32:41.025000'),(24,1,2550000,NULL,23,NULL,1,'2023-11-10 00:45:40.513000',1,'2023-11-10 00:45:40.513000'),(25,1,3750000,NULL,23,NULL,1,'2023-11-10 00:45:40.514000',1,'2023-11-10 00:45:40.514000'),(26,3,3850000,NULL,24,NULL,1,'2023-11-10 00:52:24.605000',1,'2023-11-10 00:52:24.605000'),(27,1,2680000,NULL,24,NULL,1,'2023-11-10 00:52:24.606000',1,'2023-11-10 00:52:24.606000'),(28,1,240000,NULL,25,NULL,1,'2023-11-10 00:55:20.878000',1,'2023-11-10 00:55:20.878000'),(29,1,3700000,NULL,26,NULL,1,'2023-11-10 02:34:20.595000',1,'2023-11-10 02:34:20.595000'),(30,1,3850000,NULL,26,NULL,1,'2023-11-10 02:34:20.597000',1,'2023-11-10 02:34:20.597000'),(31,3,4150000,NULL,27,NULL,1,'2023-11-10 10:27:37.213000',1,'2023-11-10 10:27:37.213000'),(32,7,4330000,NULL,28,NULL,1,'2023-11-10 13:12:14.508000',1,'2023-11-10 13:12:14.508000'),(33,2,3850000,NULL,29,NULL,1,'2023-11-10 14:36:21.623000',1,'2023-11-10 14:36:21.623000'),(34,1,3850000,NULL,30,NULL,1,'2023-11-10 14:37:33.207000',1,'2023-11-10 14:37:33.207000');
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (10,0,1,1,'2023-10-29 14:09:33.909000',1,'2023-10-29 14:09:33.909000'),(11,1,1,1,'2023-10-29 15:03:36.892000',1,'2023-10-29 15:03:36.892000'),(16,1,1,1,'2023-11-08 02:45:35.810000',1,'2023-11-08 02:45:35.810000'),(18,1,1,1,'2023-11-10 00:24:33.184000',1,'2023-11-10 00:24:33.184000'),(19,1,1,1,'2023-11-10 00:26:06.809000',1,'2023-11-10 00:26:06.809000'),(20,1,1,1,'2023-11-10 00:26:26.300000',1,'2023-11-10 00:26:26.300000'),(21,1,1,1,'2023-11-10 00:30:04.694000',1,'2023-11-10 00:30:04.694000'),(22,0,1,1,'2023-11-10 00:32:40.995000',1,'2023-11-10 00:32:40.995000'),(23,0,1,1,'2023-11-10 00:45:40.511000',1,'2023-11-10 00:45:40.511000'),(24,0,1,1,'2023-11-10 00:52:24.603000',1,'2023-11-10 00:52:24.603000'),(25,0,1,1,'2023-11-10 00:55:20.877000',1,'2023-11-10 00:55:20.877000'),(26,0,1,1,'2023-11-10 02:34:20.589000',1,'2023-11-10 02:34:20.589000'),(27,0,1,1,'2023-11-10 10:27:37.208000',1,'2023-11-10 10:27:37.208000'),(28,0,1,1,'2023-11-10 13:12:14.502000',1,'2023-11-10 13:12:14.502000'),(29,0,1,1,'2023-11-10 14:36:21.622000',1,'2023-11-10 14:36:21.622000'),(30,0,1,1,'2023-11-10 14:37:33.205000',1,'2023-11-10 14:37:33.205000');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_size`
--

LOCK TABLES `product_size` WRITE;
/*!40000 ALTER TABLE `product_size` DISABLE KEYS */;
INSERT INTO `product_size` VALUES (1,14,1,NULL,NULL,NULL,NULL,NULL),(2,11,2,NULL,NULL,NULL,NULL,NULL),(3,10,3,NULL,NULL,NULL,NULL,NULL),(4,26,4,NULL,NULL,NULL,NULL,NULL),(5,14,5,NULL,NULL,NULL,NULL,NULL),(6,14,6,NULL,NULL,NULL,NULL,NULL),(7,12,7,NULL,NULL,NULL,NULL,NULL),(8,11,8,NULL,NULL,NULL,NULL,NULL),(9,8,9,NULL,NULL,NULL,NULL,NULL),(10,5,10,NULL,NULL,NULL,NULL,NULL),(11,5,11,12,NULL,NULL,NULL,NULL),(13,4,13,12,NULL,NULL,NULL,NULL),(14,6,14,12,NULL,NULL,NULL,NULL),(15,6,15,12,NULL,NULL,NULL,NULL),(16,2,12,12,NULL,NULL,NULL,NULL),(72,20,16,3,NULL,NULL,NULL,NULL),(73,20,17,3,NULL,NULL,NULL,NULL),(74,20,18,3,NULL,NULL,NULL,NULL),(75,20,19,3,NULL,NULL,NULL,NULL),(76,20,20,3,NULL,NULL,NULL,NULL),(77,20,21,3,NULL,NULL,NULL,NULL),(78,20,22,3,NULL,NULL,NULL,NULL),(79,20,23,3,NULL,NULL,NULL,NULL),(80,20,24,3,NULL,NULL,NULL,NULL),(81,20,25,3,NULL,NULL,NULL,NULL),(82,20,26,3,NULL,NULL,NULL,NULL),(83,20,27,3,NULL,NULL,NULL,NULL),(84,20,28,3,NULL,NULL,NULL,NULL),(85,20,29,3,NULL,NULL,NULL,NULL),(86,20,30,3,NULL,NULL,NULL,NULL),(87,20,31,3,NULL,NULL,NULL,NULL),(88,20,32,3,NULL,NULL,NULL,NULL),(89,20,33,3,NULL,NULL,NULL,NULL),(90,20,34,3,NULL,NULL,NULL,NULL),(91,20,35,3,NULL,NULL,NULL,NULL),(92,20,35,3,NULL,NULL,NULL,NULL),(93,20,37,3,NULL,NULL,NULL,NULL),(94,20,38,3,NULL,NULL,NULL,NULL),(95,20,39,3,NULL,NULL,NULL,NULL),(96,20,40,3,NULL,NULL,NULL,NULL),(97,20,41,3,NULL,NULL,NULL,NULL),(98,20,42,3,NULL,NULL,NULL,NULL),(99,20,43,3,NULL,NULL,NULL,NULL),(100,20,44,3,NULL,NULL,NULL,NULL),(101,10,12,13,NULL,NULL,NULL,NULL),(102,15,45,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_stocktaking`
--

LOCK TABLES `product_stocktaking` WRITE;
/*!40000 ALTER TABLE `product_stocktaking` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_stocktaking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Astrox 88D Pro',3850000,1,'/api/image/1_Astrox 88D Pro.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,1,NULL,NULL,1,'2023-11-10 14:37:33.209000'),(2,'Astrox 88D Game',2850000,1,'/api/image/2_Astrox 88D Game.png','- Điểm cân bằng: Khoảng 300mm (Nặng đầu)## ##- Độ Cứng: Cứng## ##- Màu sắc: Camel Gold - Vàng lạc đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + NANOMESH NEO## ##- Trọng lượng/ Chi vi cán vợt: 3U (Ave.88g)/G5 | 4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Chiều dài cán vợt: 205 mm (cán dài)## ##- Mức căng dây 4U: 20 - 28 lbs | 3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Game New 2021 được sản xuất tại Taiwan.',1,1,NULL,NULL,NULL,NULL),(3,'Astrox 100zz',4150000,1,'/api/image/3_Astrox 100zz.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,1,NULL,NULL,1,'2023-11-10 10:27:37.267000'),(4,'Astrox 77 Pro',3750000,1,'/api/image/4_Astrox 77 Pro.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,1,NULL,NULL,1,'2023-11-10 00:45:40.517000'),(5,'Astrox 77 xanh chuối',3250000,1,'/api/image/5_Astrox 77 xanh chuối.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,1,NULL,NULL,1,'2023-11-10 00:24:33.261000'),(6,'Halbertec 8000',3700000,1,'/api/image/6_Halbertec 8000.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,2,NULL,NULL,NULL,NULL),(7,'Lining Bladex 600',3750000,1,'/api/image/7_Lining Bladex 600.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,2,NULL,NULL,NULL,NULL),(8,'Victor Ryuga II',3700000,1,'/api/image/8_Victor Ryuga II.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,3,NULL,NULL,1,'2023-11-10 02:34:20.602000'),(9,'TK-Rabbit',800000,1,'/api/image/9_TK-Rabbit.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,3,NULL,NULL,NULL,NULL),(10,'Mizuno Speedflex 9.3',2680000,1,'/api/image/10_Mizuno Speedflex 9.3.png','- Điểm cân bằng: Khoảng 301mm (Nặng đầu)## ##- Độ Cứng: Siêu Cứng## ##- Màu sắc: Camel Gold - Vàng Lạc Đà## ##- Vật liệu khung: HM Graphite + VOLUME CUT RESIN + Tungsten## ##- Vật liệu trục: HM Graphite + Namd## ##- Trọng lượng/ Chu vi cán vợt: 3U (Ave.88g)/G5|4U (Ave.83g)/G5## ##- Chiều dài tổng thể: 675 mm## ##- Điểm swing: 84 - 86 kg/cm2## ##- Chiều dài cán vợt: 200mm## ##- Mức căng dây 4U: 20 - 28 lbs/3U: 21 - 29 lbs## ##- Cây vợt cầu lông Yonex Astrox 88D Pro New 2021 được sản xuất tại Nhật Bản.',1,4,NULL,NULL,1,'2023-11-10 00:52:24.608000'),(11,'65Z3 C-90 Wide',2650000,1,'/api/image/11_65Z3 C-90 Wide.png','- Thương hiệu: Yonex##- Mã sản phẩm: SHB65Z3WY##- Màu sắc: Kem (Be)##- Thân giày: Sợi tổng hợp + lưới mesh thoáng khí (Synthetic Fiber)##- Midsole: Nhựa tổng hợp, tấm đệm Power Cushion+ (Synthetic Resin)##- Outsole: Đế cao su##- Form giày: Wide dành cho người có bàn chân bè',2,1,NULL,NULL,NULL,NULL),(12,'65Z3 Kurenai',2950000,1,'/api/image/12_65Z3 Kurenai.png','- Upper: Sợi tổng hợp cao cấp\n\n- Midsole: Nhựa tổng hợp cao cấp\n\n- Outsole: Đế cao su mới siêu bám sân\n\n- Material: POWER CUSHION+, Radial Blade Sole, Lateral Shell, Feather Bounce Foam,…\n\n- Độ thoáng khí: 8/10\n\n- Độ êm ái: 9/10\n\n- Độ nhẹ nhàng: 9/10\n\n- Độ ổn định: 8/10\n\n- Size giày: 35 – 45',2,1,NULL,NULL,1,'2023-11-10 00:26:26.304000'),(13,'SC6 Lindan',2550000,1,'/api/image/13_SC6 Lindan.png','- Upper: Sợi tổng hợp cao cấp  - Midsole: Nhựa tổng hợp cao cấp  - Outsole: Đế cao su mới siêu bám sân  - Material: POWER CUSHION+, Radial Blade Sole, Lateral Shell, Feather Bounce Foam,…  - Độ thoáng khí: 8/10  - Độ êm ái: 9/10  - Độ nhẹ nhàng: 9/10  - Độ ổn định: 8/10  - Size giày: 35 – 45',2,1,NULL,NULL,1,'2023-11-10 00:45:40.516000'),(14,'Eclipsion Z3 Men - Xanh Navy',2600000,1,'/api/image/14_Eclipsion Z3 Men - Xanh Navy.png','- Upper: Sợi tổng hợp cao cấp  - Midsole: Nhựa tổng hợp cao cấp  - Outsole: Đế cao su mới siêu bám sân  - Material: POWER CUSHION+, Radial Blade Sole, Lateral Shell, Feather Bounce Foam,…  - Độ thoáng khí: 8/10  - Độ êm ái: 9/10  - Độ nhẹ nhàng: 9/10  - Độ ổn định: 8/10  - Size giày: 35 – 45',2,1,NULL,NULL,NULL,NULL),(15,'AYTT003-3',1400000,1,'/api/image/15_AYTT003-3.png','- Upper: Sợi tổng hợp cao cấp  - Midsole: Nhựa tổng hợp cao cấp  - Outsole: Đế cao su mới siêu bám sân  - Material: POWER CUSHION+, Radial Blade Sole, Lateral Shell, Feather Bounce Foam,…  - Độ thoáng khí: 8/10  - Độ êm ái: 9/10  - Độ nhẹ nhàng: 9/10  - Độ ổn định: 8/10  - Size giày: 35 – 45',2,2,NULL,NULL,NULL,NULL),(16,'T-0001',150000,1,'/api/image/16_T-0001.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,1,'2023-11-10 00:24:33.258000'),(17,'T-0002',150000,1,'/api/image/17_T-0002.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(18,'T-0003',150000,1,'/api/image/18_T-0003.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(19,'T-0004',150000,1,'/api/image/19_T-0004.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(20,'T-0005',150000,1,'/api/image/20_T-0005.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(21,'T-0006',150000,1,'/api/image/21_T-0006.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(22,'T-0007',150000,1,'/api/image/22_T-0007.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(23,'T-0008',150000,1,'/api/image/23_T-0008.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(24,'T-0009',150000,1,'/api/image/24_T-0009.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(25,'T-0010',150000,1,'/api/image/25_T-0010.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(26,'T-0011',150000,1,'/api/image/26_T-0011.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(27,'T-0012',150000,1,'/api/image/27_T-0012.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(28,'T-0013',150000,1,'/api/image/28_T-0013.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',3,1,NULL,NULL,NULL,NULL),(29,'S-0001',100000,1,'/api/image/29_S-0001.png','',4,1,NULL,NULL,NULL,NULL),(30,'S-0002',100000,1,'/api/image/30_S-0002.png',' ',4,1,NULL,NULL,1,'2023-11-10 00:55:20.880000'),(31,'S-0003',100000,1,'/api/image/31_S-0003.png','',4,1,NULL,NULL,NULL,NULL),(32,'S-0004',100000,1,'/api/image/32_S-0004.png','',4,1,NULL,NULL,NULL,NULL),(33,'S-0005',100000,1,'/api/image/33_S-0005.png','',4,1,NULL,NULL,NULL,NULL),(34,'S-0006',100000,1,'/api/image/34_S-0006.png','',4,1,NULL,NULL,NULL,NULL),(35,'S-0007',100000,1,'/api/image/35_S-0007.png','',4,1,NULL,NULL,NULL,NULL),(36,'S-0008',100000,1,'/api/image/36_S-0008.png','',4,1,NULL,NULL,NULL,NULL),(37,'SO-0001',70000,1,'/api/image/37_SO-0001.png','',5,1,NULL,NULL,NULL,NULL),(38,'SO-0002',70000,1,'/api/image/38_SO-0002.png','',5,1,NULL,NULL,NULL,NULL),(39,'SO-0003',70000,1,'/api/image/39_SO-0003.png','',5,1,NULL,NULL,NULL,NULL),(40,'SO-0004',70000,1,'/api/image/40_SO-0004.png','',5,1,NULL,NULL,NULL,NULL),(41,'B-0001',850000,1,'/api/image/41_B-0001.png','',6,1,NULL,NULL,NULL,NULL),(42,'B-0002',850000,1,'/api/image/42_B-0002.png','',6,1,NULL,NULL,NULL,NULL),(43,'B-0003',850000,1,'/api/image/43_B-0003.png','',6,1,NULL,NULL,1,'2023-11-10 00:30:04.701000'),(44,'B-0004',850000,1,'/api/image/44_B-0004.png','',6,1,NULL,NULL,NULL,NULL),(45,'Nanoflare 1000Z',4330000,NULL,'/api/image/45_Nanoflare 1000Z.png','- Loại áo: Áo chuyển nhiệt##- Chất liệu: Vải tổng hợp cao cấp##- Tính năng:##    + Thấm hút mồ hôi tốt.##    + Khô nhanh.##    + Làm mát nhanh.##    + Chống nhăn.##    + Siêu bền bỉ.',1,1,NULL,NULL,1,'2023-11-10 13:12:14.514000');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN',NULL,NULL,NULL,NULL),(2,'CUSTOMER',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (1,'36',NULL,NULL,NULL,NULL),(3,'L',NULL,NULL,NULL,NULL),(5,'M',NULL,NULL,NULL,NULL),(7,'S',NULL,NULL,NULL,NULL),(8,'37',NULL,NULL,NULL,NULL),(9,'38',NULL,NULL,NULL,NULL),(10,'39',NULL,NULL,NULL,NULL),(11,'40',NULL,NULL,NULL,NULL),(12,'41',NULL,NULL,NULL,NULL),(13,'42',NULL,NULL,NULL,NULL),(14,'43',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Yonex',NULL,NULL,NULL,NULL),(2,'Lining',NULL,NULL,NULL,NULL),(3,'Victor',NULL,NULL,NULL,NULL),(4,'Mizuno',NULL,NULL,NULL,NULL),(5,'Kumpoo',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1','Do Duc Duong',_binary '','2000-11-14 07:00:00.000000',NULL,'user1@gmail.com','0999999999','$2a$10$nQ2eLYKGXftfvtKEa9df3.eaY5aRBbC8uX8rfDOxUMKtu6ysRP6C2',2,NULL,'2023-10-17 10:04:40.336000',NULL,'2023-10-17 10:04:40.336000','/api/image/avatar.png'),(2,'admin1','Admin 1',_binary '','2000-11-14 07:00:00.000000',NULL,'admin1@gmail.com','0888888888','$2a$10$nQ2eLYKGXftfvtKEa9df3.eaY5aRBbC8uX8rfDOxUMKtu6ysRP6C2',1,NULL,NULL,NULL,NULL,'/api/image/avatar.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-30 13:08:20
