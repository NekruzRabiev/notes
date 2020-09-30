CREATE DATABASE  IF NOT EXISTS `note_directory`;
USE `note_directory`;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;

CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `note`
--

INSERT INTO `note` VALUES 
	(1,'Что такое Lorem Ipsum?','Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне.'),
	(2,'Почему он используется?','Давно выяснено, что при оценке дизайна и композиции читаемый текст мешает сосредоточиться.'),
	(3,'Откуда он появился?','Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так.');
    
    