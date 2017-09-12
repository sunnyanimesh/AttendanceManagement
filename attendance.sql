-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: attendance
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) NOT NULL,
  `admin_username` varchar(20) NOT NULL,
  `admin_password` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_username` (`admin_username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'mr.x','xisthebest','hello');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assigment`
--

DROP TABLE IF EXISTS `assigment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assigment` (
  `assigment_id` int(11) NOT NULL AUTO_INCREMENT,
  `assigment_name` varchar(15) NOT NULL,
  `assigment_date` date NOT NULL,
  `faculty_id` varchar(12) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `assigment_ques1` varchar(300) DEFAULT NULL,
  `assigment_ques2` varchar(300) DEFAULT NULL,
  `assigment_ques3` varchar(300) DEFAULT NULL,
  `assigment_ques4` varchar(300) DEFAULT NULL,
  `assigment_ques5` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`assigment_id`),
  KEY `subject_id` (`subject_id`),
  KEY `faculty_id` (`faculty_id`),
  CONSTRAINT `assigment_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `assigment_ibfk_2` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assigment`
--

LOCK TABLES `assigment` WRITE;
/*!40000 ALTER TABLE `assigment` DISABLE KEYS */;
INSERT INTO `assigment` VALUES (1,'fsadf','2017-07-11','f123',2,'df','df','df','df','df'),(2,'NEW DAA','2017-07-11','f123',1,'hey','hey','hey','hey','hey'),(3,'Abhishek','2017-07-13','f456',3,'ques1','ques2','ques3','ques4','ques5'),(4,'new Assignment','2017-07-14','f123',3,'what is data structure?','explain graph?','rb tree','bhag yha se','ch nikal');
/*!40000 ALTER TABLE `assigment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(10) NOT NULL,
  `branch_hod` varchar(20) NOT NULL,
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `branch_hod` (`branch_hod`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'CSE','XYZ'),(2,'ECE','XYZ1');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_table`
--

DROP TABLE IF EXISTS `chat_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_userid` int(11) DEFAULT NULL,
  `reciever_userid` int(11) DEFAULT NULL,
  `message` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sender_userid` (`sender_userid`),
  KEY `reciever_userid` (`reciever_userid`),
  CONSTRAINT `chat_table_ibfk_1` FOREIGN KEY (`sender_userid`) REFERENCES `user` (`user_id`),
  CONSTRAINT `chat_table_ibfk_2` FOREIGN KEY (`reciever_userid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_table`
--

LOCK TABLES `chat_table` WRITE;
/*!40000 ALTER TABLE `chat_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chattable`
--

DROP TABLE IF EXISTS `chattable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chattable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_userid` int(11) DEFAULT NULL,
  `reciever_userid` int(11) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sender_userid` (`sender_userid`),
  KEY `reciever_userid` (`reciever_userid`),
  CONSTRAINT `chattable_ibfk_1` FOREIGN KEY (`sender_userid`) REFERENCES `user` (`user_id`),
  CONSTRAINT `chattable_ibfk_2` FOREIGN KEY (`reciever_userid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chattable`
--

LOCK TABLES `chattable` WRITE;
/*!40000 ALTER TABLE `chattable` DISABLE KEYS */;
INSERT INTO `chattable` VALUES (1,1,3,'animesh->hey'),(2,1,3,'animesh->hey ya hhjnk'),(3,3,1,'mayank->hey animesh');
/*!40000 ALTER TABLE `chattable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datewiseattendance`
--

DROP TABLE IF EXISTS `datewiseattendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datewiseattendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_admno` varchar(12) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `faculty_id` varchar(12) NOT NULL,
  `adate` date NOT NULL,
  `attendance` varchar(1) DEFAULT NULL,
  `day` varchar(10) NOT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `subject_id` (`subject_id`),
  KEY `student_admno` (`student_admno`),
  KEY `faculty_id` (`faculty_id`),
  CONSTRAINT `datewiseattendance_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `datewiseattendance_ibfk_2` FOREIGN KEY (`student_admno`) REFERENCES `student` (`student_admno`),
  CONSTRAINT `datewiseattendance_ibfk_3` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datewiseattendance`
--

LOCK TABLES `datewiseattendance` WRITE;
/*!40000 ALTER TABLE `datewiseattendance` DISABLE KEYS */;
INSERT INTO `datewiseattendance` VALUES (14,'2014bcs2013',1,'f123','2017-07-11','E','Tuesday'),(15,'2014bcs2013',1,'f123','2017-07-11','P','Tuesday'),(16,'2014bcs2013',1,'f123','2017-07-11','P','Tuesday'),(17,'2014bcs2013',1,'f123','2017-07-11','P','Tuesday'),(18,'2014bcs2013',1,'f123','2017-07-12','P','Wednesday'),(19,'2014bcs2013',1,'f123','2017-07-12','P','Wednesday'),(20,'2014bcs2013',2,'f456','2017-07-12','A','Wednesday'),(21,'2014bcs2013',1,'f123','2017-07-12','A','Wednesday'),(22,'2014bcs2013',1,'f123','2017-07-12','P','Wednesday'),(23,'2014bcs2013',1,'f123','2017-07-13','A','Thursday'),(24,'2014bcs2013',1,'f123','2017-07-13','P','Thursday'),(25,'2014bcs2013',1,'f123','2017-07-13','P','Thursday'),(26,'2014bcs2013',1,'f123','2017-07-13','P','Thursday'),(27,'2014bcs2013',2,'f456','2017-07-13','P','Thursday'),(28,'2014bcs2013',2,'f456','2017-07-13','P','Thursday'),(29,'2014bcs2013',2,'f456','2017-07-13','P','Thursday'),(30,'2014bcs2013',2,'f456','2017-07-13','P','Thursday'),(31,'2014bcs2013',2,'f456','2017-07-13','P','Thursday'),(32,'2014bcs2013',1,'f123','2017-07-14','P','Friday');
/*!40000 ALTER TABLE `datewiseattendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `faculty_id` varchar(12) NOT NULL,
  `faculty_name` varchar(20) NOT NULL,
  `faculty_address` varchar(30) NOT NULL,
  `faculty_dob` date NOT NULL,
  `faculty_mobile` bigint(20) NOT NULL,
  `faculty_gender` varchar(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`faculty_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES ('f123','dharmendra','mumbai','1996-09-30',8860949147,'m',4),('f456','hema malini','mumbai','1996-09-30',8860949147,'f',5);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent` (
  `parent_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_name` varchar(20) NOT NULL,
  `parent_address` varchar(30) NOT NULL,
  `parent_dob` date NOT NULL,
  `parent_mobile` bigint(20) NOT NULL,
  `parent_occupation` varchar(15) NOT NULL,
  `parent_salary` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`parent_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `parent_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES (1,'parentname','naveen park','1996-09-30',8860949147,'dfjsdbjdsbnjs',465656,6),(2,'parentname2','naveesadn park','1996-09-25',8860949147,'dfjsdbjdsbnjds',465656,7);
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parentof`
--

DROP TABLE IF EXISTS `parentof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parentof` (
  `parent_id` int(11) NOT NULL,
  `student_admno` varchar(12) NOT NULL,
  KEY `student_admno` (`student_admno`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `parentof_ibfk_1` FOREIGN KEY (`student_admno`) REFERENCES `student` (`student_admno`),
  CONSTRAINT `parentof_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parentof`
--

LOCK TABLES `parentof` WRITE;
/*!40000 ALTER TABLE `parentof` DISABLE KEYS */;
INSERT INTO `parentof` VALUES (1,'2014bcs2013'),(2,'2014bcs2051');
/*!40000 ALTER TABLE `parentof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_admno` varchar(12) NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `student_address` varchar(30) NOT NULL,
  `student_dob` date NOT NULL,
  `student_mobile` bigint(20) NOT NULL,
  `student_gender` varchar(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`student_admno`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('2014bcs2013','animesh','42NaveenPark','1996-09-30',8860949147,'m',1),('2014bcs2025','mayank','42NaveenPark','1996-09-30',8860949147,'m',3),('2014bcs2051','alok','42NaveenPark','1996-09-30',8860949147,'m',2);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentbranch`
--

DROP TABLE IF EXISTS `studentbranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentbranch` (
  `student_admno` varchar(12) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  KEY `student_admno` (`student_admno`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `studentbranch_ibfk_1` FOREIGN KEY (`student_admno`) REFERENCES `student` (`student_admno`),
  CONSTRAINT `studentbranch_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentbranch`
--

LOCK TABLES `studentbranch` WRITE;
/*!40000 ALTER TABLE `studentbranch` DISABLE KEYS */;
INSERT INTO `studentbranch` VALUES ('2014bcs2013',1,7),('2014bcs2051',2,7),('2014bcs2025',1,7);
/*!40000 ALTER TABLE `studentbranch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentsubject`
--

DROP TABLE IF EXISTS `studentsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentsubject` (
  `student_admno` varchar(12) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `faculty_id` varchar(12) NOT NULL,
  `attendance` int(11) NOT NULL,
  `totalattendance` int(11) NOT NULL,
  KEY `student_admno` (`student_admno`),
  KEY `subject_id` (`subject_id`),
  KEY `faculty_id` (`faculty_id`),
  CONSTRAINT `studentsubject_ibfk_1` FOREIGN KEY (`student_admno`) REFERENCES `student` (`student_admno`),
  CONSTRAINT `studentsubject_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `studentsubject_ibfk_3` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentsubject`
--

LOCK TABLES `studentsubject` WRITE;
/*!40000 ALTER TABLE `studentsubject` DISABLE KEYS */;
INSERT INTO `studentsubject` VALUES ('2014bcs2013',1,'f123',10,12),('2014bcs2013',2,'f456',5,6);
/*!40000 ALTER TABLE `studentsubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(10) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'DAA'),(2,'DBMS'),(3,'DS'),(4,'PA'),(5,'SC'),(6,'SE'),(7,'Automata'),(8,'Os');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submitassigment`
--

DROP TABLE IF EXISTS `submitassigment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submitassigment` (
  `student_admno` varchar(12) NOT NULL,
  `assigment_id` int(11) NOT NULL,
  `assigment_ques1` varchar(700) DEFAULT NULL,
  `assigment_ques2` varchar(700) DEFAULT NULL,
  `assigment_ques3` varchar(700) DEFAULT NULL,
  `assigment_ques4` varchar(700) DEFAULT NULL,
  `assigment_ques5` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`assigment_id`),
  KEY `student_admno` (`student_admno`),
  CONSTRAINT `submitassigment_ibfk_1` FOREIGN KEY (`student_admno`) REFERENCES `student` (`student_admno`),
  CONSTRAINT `submitassigment_ibfk_2` FOREIGN KEY (`assigment_id`) REFERENCES `assigment` (`assigment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submitassigment`
--

LOCK TABLES `submitassigment` WRITE;
/*!40000 ALTER TABLE `submitassigment` DISABLE KEYS */;
INSERT INTO `submitassigment` VALUES ('2014bcs2013',1,'hoooo	','haaaa','heheheh','lalalal','dsf'),('2014bcs2013',3,'hey	','hohi','hii','hahah','hhehe');
/*!40000 ALTER TABLE `submitassigment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(20) NOT NULL,
  `user_passsword` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`),
  UNIQUE KEY `user_passsword` (`user_passsword`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'animesh.14bcs2013','animesh'),(2,'alok.14bcs2051','alok'),(3,'mayank.14bcs2025','mayank'),(4,'teacher.1','teacher1'),(5,'teacher.2','teacher2'),(6,'parent.1','parent1'),(7,'parent.2','parent2');
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

-- Dump completed on 2017-07-14 10:48:14
