-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_booking
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin@gmail.com','412301');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `position` varchar(100) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `hire_date` date NOT NULL,
  `address` text NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip_code` varchar(10) NOT NULL,
  `country` varchar(50) NOT NULL,
  `emergency_contact_name` varchar(100) DEFAULT NULL,
  `emergency_contact_phone` varchar(15) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'Amit','Sharma','amit.sharma@gmail.com','9876543211','1988-07-12','Male','Manager',55000.00,'2023-01-10','45 MG Road','Mumbai','Maharashtra','400001','India','Raj Sharma','9898989898','2025-03-11 11:56:36'),(2,'Priya','Mehta','priya.mehta@gmail.com','9876543212','1992-03-22','Female','Receptionist',32000.00,'2022-09-05','12 Green Street','Delhi','Delhi','110001','India','Sunita Mehta','9789789789','2025-03-11 11:56:36'),(3,'Rahul','Verma','rahul.verma@gmail.com','9876543213','1990-11-05','Male','Chef',40000.00,'2021-06-15','56 Sector 21','Bangalore','Karnataka','560001','India','Anil Verma','9679679679','2025-03-11 11:56:36'),(4,'Anjali','Kapoor','anjali.kapoor@gmail.com','9876543214','1995-05-19','Female','Housekeeping',25000.00,'2022-04-12','78 Whitefield','Kolkata','West Bengal','700001','India','Suman Kapoor','9569569569','2025-03-11 11:56:36'),(5,'Vikram','Singh','vikram.singh@gmail.com','9876543215','1985-09-30','Male','Security Guard',22000.00,'2023-02-18','33 Gandhi Nagar','Chennai','Tamil Nadu','600001','India','Suraj Singh','9459459459','2025-03-11 11:56:36'),(6,'Sakshi','Malhotra','sakshi.malhotra@gmail.com','9876543216','1993-12-11','Female','Front Desk Executive',33000.00,'2021-07-20','19 Indiranagar','Hyderabad','Telangana','500001','India','Rohit Malhotra','9349349349','2025-03-11 11:56:36'),(7,'Arjun','Reddy','arjun.reddy@gmail.com','9876543217','1987-01-25','Male','Bellboy',18000.00,'2023-06-10','50 Banjara Hills','Hyderabad','Telangana','500034','India','Ramesh Reddy','9239239239','2025-03-11 11:56:36'),(8,'Neha','Iyer','neha.iyer@gmail.com','9876543218','1991-08-15','Female','Waitress',28000.00,'2022-03-29','11 MG Road','Pune','Maharashtra','411001','India','Arvind Iyer','9129129129','2025-03-11 11:56:36'),(9,'Rohan','Gupta','rohan.gupta@gmail.com','9876543219','1994-06-02','Male','Bartender',30000.00,'2021-12-11','22 Park Street','Ahmedabad','Gujarat','380001','India','Deepak Gupta','9019019019','2025-03-11 11:56:36'),(10,'Pooja','Mishra','pooja.mishra@gmail.com','9876543220','1996-04-20','Female','Event Coordinator',37000.00,'2022-10-25','14 Race Course Road','Jaipur','Rajasthan','302001','India','Meera Mishra','8908908908','2025-03-11 11:56:36'),(11,'Kunal','Jain','kunal.jain@gmail.com','9876543221','1989-10-10','Male','Concierge',31000.00,'2023-01-15','76 Lal Kothi','Lucknow','Uttar Pradesh','226001','India','Amit Jain','8798798798','2025-03-11 11:56:36'),(12,'Simran','Arora','simran.arora@gmail.com','9876543222','1993-02-18','Female','Guest Relations Officer',35000.00,'2021-08-09','30 Lajpat Nagar','Chandigarh','Punjab','160001','India','Anjali Arora','8688688688','2025-03-11 11:56:36'),(13,'Manish','Chaudhary','manish.chaudhary@gmail.com','9876543223','1986-09-14','Male','Electrician',27000.00,'2022-05-07','23 Patel Chowk','Patna','Bihar','800001','India','Suresh Chaudhary','8578578578','2025-03-11 11:56:36'),(14,'Sneha','Nair','sneha.nair@gmail.com','9876543224','1995-07-08','Female','HR Manager',60000.00,'2020-11-19','15 MG Road','Thiruvananthapuram','Kerala','695001','India','Kavita Nair','8468468468','2025-03-11 11:56:36'),(15,'Siddharth','Bose','siddharth.bose@gmail.com','9876543225','1992-12-05','Male','IT Support',45000.00,'2021-06-30','40 Park Street','Kolkata','West Bengal','700016','India','Rina Bose','8358358358','2025-03-11 11:56:36'),(16,'Ritika','Deshmukh','ritika.deshmukh@gmail.com','9876543226','1994-01-17','Female','Accountant',38000.00,'2022-08-14','29 FC Road','Pune','Maharashtra','411004','India','Rajesh Deshmukh','8248248248','2025-03-11 11:56:36'),(17,'Akash','Trivedi','akash.trivedi@gmail.com','9876543227','1988-05-22','Male','Maintenance Supervisor',42000.00,'2023-03-21','10 Sadar Bazaar','Bhopal','Madhya Pradesh','462001','India','Sunil Trivedi','8138138138','2025-03-11 11:56:36'),(18,'Meera','Joshi','meera.joshi@gmail.com','9876543228','1991-09-29','Female','Laundry Supervisor',26000.00,'2022-07-12','5 Civil Lines','Shimla','Himachal Pradesh','171001','India','Vikas Joshi','8028028028','2025-03-11 11:56:36'),(19,'Rajesh','Patel','rajesh.patel@gmail.com','9876543229','1987-03-10','Male','General Manager',75000.00,'2019-12-05','88 Ring Road','Surat','Gujarat','395001','India','Neha Patel','7917917917','2025-03-11 11:56:36'),(21,'Tejas','Buddhivant','tejasbuddhivant6@gmail.com','01234565675','2025-03-01','Male','owner',9999999.00,'2025-03-28','asdfasewfqaewrfdsfsdvs','pune','mh','412301','India','none','1234567890','2025-03-12 05:26:50');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(100) NOT NULL,
  `room_rate` decimal(10,2) NOT NULL,
  `room_no` varchar(10) NOT NULL,
  `booked_by` varchar(100) DEFAULT NULL,
  `check_in_date` date DEFAULT NULL,
  `check_out_date` date DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  UNIQUE KEY `room_no` (`room_no`),
  KEY `booked_by` (`booked_by`),
  CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`booked_by`) REFERENCES `users` (`email`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (7,'Deluxe Room',100.00,'101',NULL,NULL,NULL),(8,'Deluxe Room',100.00,'102',NULL,NULL,NULL),(9,'Luxury Suite',200.00,'201','tejasbuddhivant@gmail.com','2025-03-11','2025-03-13'),(10,'Luxury Suite',200.00,'202',NULL,NULL,NULL),(11,'Executive Suite',300.00,'301',NULL,NULL,NULL),(12,'Presidential Suite',500.00,'401',NULL,NULL,NULL);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `aadhar` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mobile` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `aadhar` (`aadhar`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,'tejas','tejasbuddhivant@gmail.com','qrtwtytrhf','43216435','123',1234566789),(14,'Tejas','tejasbuddhivant6@gmail.com','ubuuhihoituyjbyu','78945612','456',999999999);
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

-- Dump completed on 2025-03-14 13:02:08
