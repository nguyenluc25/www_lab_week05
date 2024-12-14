-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.4.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for works
CREATE DATABASE IF NOT EXISTS `works` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `works`;

-- Dumping structure for table works.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` enum('CANDIDATE','COMPANY') DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKgex1lmaqpg0ir5g1f5eftyaa1` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.account: ~10 rows (approximately)
DELETE FROM `account`;
INSERT INTO `account` (`id`, `type`, `password`, `username`) VALUES
	(1, 'CANDIDATE', '123', 'candidate1'),
	(2, 'CANDIDATE', '123', 'candidate2'),
	(3, 'CANDIDATE', 'password123', 'candidate3'),
	(4, 'CANDIDATE', 'password123', 'candidate4'),
	(5, 'CANDIDATE', 'password123', 'candidate5'),
	(6, 'COMPANY', '123', 'company1'),
	(7, 'COMPANY', 'password123', 'company2'),
	(8, 'COMPANY', 'password123', 'company3'),
	(9, 'COMPANY', 'password123', 'company4'),
	(10, 'COMPANY', '123', 'company5');

-- Dumping structure for table works.address
CREATE TABLE IF NOT EXISTS `address` (
  `add_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) DEFAULT NULL,
  `country` smallint(6) DEFAULT NULL CHECK (`country` between 0 and 271),
  `number` varchar(20) DEFAULT NULL,
  `street` varchar(150) DEFAULT NULL,
  `zipcode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.address: ~10 rows (approximately)
DELETE FROM `address`;
INSERT INTO `address` (`add_id`, `city`, `country`, `number`, `street`, `zipcode`) VALUES
	(1, 'New York', 1, '123', 'Main St', '10001'),
	(2, 'Los Angeles', 1, '456', 'Sunset Blvd', '90001'),
	(3, 'Chicago', 1, '789', 'North Ave', '60007'),
	(4, 'Houston', 1, '101', 'Pine St', '77001'),
	(5, 'Phoenix', 1, '202', 'Oak St', '85001'),
	(6, 'San Francisco', 1, '303', 'Market St', '94101'),
	(7, 'Miami', 1, '404', 'Ocean Dr', '33101'),
	(8, 'Dallas', 1, '505', 'Elm St', '75201'),
	(9, 'Atlanta', 1, '606', 'Peachtree St', '30301'),
	(10, 'Seattle', 1, '707', 'Broadway', '98101');

-- Dumping structure for table works.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `can_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `address` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`can_id`),
  UNIQUE KEY `UKqfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  UNIQUE KEY `UKr09ojuqppptb5tf8f640kim17` (`account_id`),
  UNIQUE KEY `UKm8qhlm4wu215gr34dhxp0dour` (`address`),
  CONSTRAINT `FKa8gnyyhbb2qnhp94grci1n0o9` FOREIGN KEY (`address`) REFERENCES `address` (`add_id`),
  CONSTRAINT `FKj4889h0mbv3h6rbbxuuyoyame` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate: ~10 rows (approximately)
DELETE FROM `candidate`;
INSERT INTO `candidate` (`can_id`, `dob`, `email`, `full_name`, `phone`, `account_id`, `address`) VALUES
	(1, '1990-01-01', 'candidate1@example.com', 'John Doe', '123-456-7890', 1, 1),
	(2, '1992-02-02', 'candidate2@example.com', 'Jane Smith', '123-456-7891', 2, 2),
	(3, '1994-03-03', 'candidate3@example.com', 'Sam Brown', '123-456-7892', 3, 3),
	(4, '1996-04-04', 'candidate4@example.com', 'Emma Johnson', '123-456-7893', 4, 4),
	(5, '1998-05-05', 'candidate5@example.com', 'Oliver Williams', '123-456-7894', 5, 5),
	(6, '1990-06-06', 'candidate6@example.com', 'Sophia Taylor', '123-456-7895', 6, 6),
	(7, '1992-07-07', 'candidate7@example.com', 'Liam Lee', '123-456-7896', 7, 7),
	(8, '1994-08-08', 'candidate8@example.com', 'Mia Harris', '123-456-7897', 8, 8),
	(9, '1996-09-09', 'candidate9@example.com', 'Noah Clark', '123-456-7898', 9, 9),
	(10, '1998-10-10', 'candidate10@example.com', 'Ava Lewis', '123-456-7899', 10, 10);

-- Dumping structure for table works.candidate_skill
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `candidate_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) DEFAULT NULL CHECK (`skill_level` between 0 and 4),
  PRIMARY KEY (`candidate_id`,`skill_id`),
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`),
  CONSTRAINT `FKijjf42p0sh2c2na28g5aalx2p` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`can_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate_skill: ~21 rows (approximately)
DELETE FROM `candidate_skill`;
INSERT INTO `candidate_skill` (`candidate_id`, `skill_id`, `more_infos`, `skill_level`) VALUES
	(1, 6, NULL, 4),
	(1, 8, NULL, 4),
	(2, 4, NULL, 4),
	(2, 5, NULL, 4),
	(3, 1, NULL, 4),
	(3, 8, NULL, 4),
	(4, 1, NULL, 4),
	(4, 10, NULL, 4),
	(5, 4, NULL, 4),
	(5, 9, NULL, 4),
	(6, 3, NULL, 4),
	(6, 9, NULL, 4),
	(7, 5, NULL, 4),
	(7, 6, NULL, 4),
	(8, 3, NULL, 4),
	(8, 7, NULL, 4),
	(8, 10, NULL, NULL),
	(9, 2, NULL, 4),
	(9, 7, NULL, 4),
	(10, 2, NULL, 4),
	(10, 10, NULL, 4);

-- Dumping structure for table works.company
CREATE TABLE IF NOT EXISTS `company` (
  `com_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` varchar(2000) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `comp_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `address` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`com_id`),
  UNIQUE KEY `UKtq5kr7wfeog5tjjr1eqtww5oh` (`account_id`),
  UNIQUE KEY `UKrvp2hunsq4sgmpxe3a7i1ym3m` (`address`),
  CONSTRAINT `FK75jxrkyqa7rjrx2sv72j7mnrf` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKd5occp4cjwihejbxdbpvkp5tv` FOREIGN KEY (`address`) REFERENCES `address` (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.company: ~5 rows (approximately)
DELETE FROM `company`;
INSERT INTO `company` (`com_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `account_id`, `address`) VALUES
	(1, 'Tech company focused on software development', 'company1@example.com', 'TechCorp', '123-456-7890', 'www.techcorp.com', 6, 1),
	(2, 'E-commerce platform specializing in electronics', 'company2@example.com', 'E-Shop', '123-456-7891', 'www.eshop.com', 7, 2),
	(3, 'Consulting firm providing business solutions', 'company3@example.com', 'ConsultCo', '123-456-7892', 'www.consultco.com', 8, 3),
	(4, 'Financial services and advisory', 'company4@example.com', 'FinAdvisors', '123-456-7893', 'www.finadvisors.com', 9, 4),
	(5, 'Digital marketing agency', 'company5@example.com', 'MarketerPro', '123-456-7894', 'www.marketerpro.com', 10, 5);

-- Dumping structure for table works.experience
CREATE TABLE IF NOT EXISTS `experience` (
  `exp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(120) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `work_desc` varchar(400) DEFAULT NULL,
  `candidate_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `FKsmv65lqovssalk12ti3cqkpjf` (`candidate_id`),
  CONSTRAINT `FKsmv65lqovssalk12ti3cqkpjf` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`can_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.experience: ~10 rows (approximately)
DELETE FROM `experience`;
INSERT INTO `experience` (`exp_id`, `company_name`, `from_date`, `role`, `to_date`, `work_desc`, `candidate_id`) VALUES
	(1, 'TechCorp', '2020-01-01', 'Software Developer', '2022-01-01', 'Developed software solutions.', 1),
	(2, 'E-Shop', '2021-02-02', 'E-commerce Manager', '2023-02-02', 'Managed online store operations.', 2),
	(3, 'ConsultCo', '2019-03-03', 'Business Analyst', '2022-03-03', 'Provided business insights.', 3),
	(4, 'FinAdvisors', '2020-04-04', 'Financial Analyst', '2023-04-04', 'Analyzed financial data.', 4),
	(5, 'MarketerPro', '2021-05-05', 'Marketing Specialist', '2023-05-05', 'Created digital marketing strategies.', 5),
	(6, 'TechCorp', '2022-06-06', 'Junior Developer', '2023-06-06', 'Worked on software applications.', 6),
	(7, 'E-Shop', '2020-07-07', 'Sales Manager', '2022-07-07', 'Led the sales team.', 7),
	(8, 'ConsultCo', '2019-08-08', 'Consultant', '2022-08-08', 'Provided consulting services to clients.', 8),
	(9, 'FinAdvisors', '2021-09-09', 'Tax Advisor', '2023-09-09', 'Advised clients on tax matters.', 9),
	(10, 'MarketerPro', '2022-10-10', 'Social Media Manager', '2023-10-10', 'Managed social media campaigns.', 10);

-- Dumping structure for table works.job
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_desc` varchar(2000) DEFAULT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FK5q04favsasq8y70bsei7wv8fc` (`company_id`),
  CONSTRAINT `FK5q04favsasq8y70bsei7wv8fc` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job: ~10 rows (approximately)
DELETE FROM `job`;
INSERT INTO `job` (`job_id`, `job_desc`, `job_name`, `company_id`) VALUES
	(1, 'Software development and system design', 'Software Developer', 1),
	(2, 'Manage customer relationships and sales', 'Sales Manager', 2),
	(3, 'Provide strategic business advice', 'Business Consultant', 3),
	(4, 'Analyze financial statements and reports', 'Financial Analyst', 4),
	(5, 'Lead digital marketing campaigns', 'Marketing Manager', 5),
	(6, 'Design and implement web applications', 'Web Developer', 1),
	(7, 'Conduct market research and analysis', 'Market Analyst', 2),
	(8, 'Lead data analysis for decision making', 'Data Analyst', 3),
	(9, 'Oversee financial operations of the company', 'Finance Manager', 4),
	(10, 'Manage marketing projects and teams', 'Project Manager', 5),
	(11, '123', 'HEHE', 1),
	(12, 'bbbbbbbbbbbbbbbbbbbb', 'bbbbbbbbbbb', 5),
	(13, 'ccccccccccccccc', 'cccccccccccc', 1);

-- Dumping structure for table works.job_skill
CREATE TABLE IF NOT EXISTS `job_skill` (
  `job_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) DEFAULT NULL CHECK (`skill_level` between 0 and 4),
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job_skill: ~21 rows (approximately)
DELETE FROM `job_skill`;
INSERT INTO `job_skill` (`job_id`, `skill_id`, `more_infos`, `skill_level`) VALUES
	(1, 5, NULL, 4),
	(1, 8, NULL, 4),
	(2, 7, NULL, 4),
	(2, 9, NULL, 4),
	(3, 6, NULL, 4),
	(3, 10, NULL, 4),
	(4, 6, NULL, 4),
	(4, 7, NULL, 4),
	(5, 2, NULL, 4),
	(5, 9, NULL, 4),
	(6, 2, NULL, 4),
	(6, 3, NULL, 4),
	(7, 1, NULL, 4),
	(7, 4, NULL, 4),
	(8, 3, NULL, 4),
	(8, 10, NULL, 4),
	(9, 5, NULL, 4),
	(9, 6, NULL, 4),
	(9, 8, NULL, 4),
	(10, 1, NULL, 4),
	(10, 4, NULL, 4),
	(11, 4, '', 4),
	(11, 5, '', 4),
	(12, 7, '', 1),
	(12, 8, '', 1),
	(13, 1, '', 3),
	(13, 2, '', 3);

-- Dumping structure for table works.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_desc` varchar(300) DEFAULT NULL,
  `skill_name` varchar(150) DEFAULT NULL,
  `skill_type` tinyint(4) DEFAULT NULL CHECK (`skill_type` between 0 and 2),
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.skill: ~10 rows (approximately)
DELETE FROM `skill`;
INSERT INTO `skill` (`skill_id`, `skill_desc`, `skill_name`, `skill_type`) VALUES
	(1, 'Proficient in Java programming', 'Java', 0),
	(2, 'Expert in data analysis and modeling', 'Data Analysis', 0),
	(3, 'Experience with project management methodologies', 'Project Management', 1),
	(4, 'Advanced knowledge of financial markets', 'Finance', 2),
	(5, 'Expert in marketing strategy', 'Marketing', 1),
	(6, 'Experience in HTML, CSS, and JavaScript', 'Web Development', 0),
	(7, 'Knowledge of Python programming', 'Python', 0),
	(8, 'Advanced knowledge of SQL', 'SQL', 0),
	(9, 'Experience in social media management', 'Social Media', 1),
	(10, 'Expert in digital marketing campaigns', 'Digital Marketing', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
