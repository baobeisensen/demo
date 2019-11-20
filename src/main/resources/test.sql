-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.62-log - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table test.sys
CREATE TABLE IF NOT EXISTS `sys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '上传文件的最大限制',
  `value` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统配置文件';

-- Dumping data for table test.sys: ~2 rows (大约)
/*!40000 ALTER TABLE `sys` DISABLE KEYS */;
INSERT INTO `sys` (`id`, `name`, `value`) VALUES
	(1, 'maxupload', '1024'),
	(2, 'Uplock', '123');
/*!40000 ALTER TABLE `sys` ENABLE KEYS */;

-- Dumping structure for table test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '真实姓名',
  `age` int(11) DEFAULT NULL,
  `pwd` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `perms` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `head_img` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '头像地址',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table test.user: ~1 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `real_name`, `age`, `pwd`, `perms`, `phone`, `head_img`, `remarks`) VALUES
	(1, '123', '小强', 11, '1234', NULL, NULL, NULL, '小强小强小强小强小强小强');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table test.visit
CREATE TABLE IF NOT EXISTS `visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '访问用户的IP地址',
  `create_time` datetime NOT NULL COMMENT '访问的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户访问记录';

-- Dumping data for table test.visit: ~6 rows (大约)
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` (`id`, `ip`, `create_time`) VALUES
	(1, '0:0:0:0:0:0:0:1', '2019-10-10 19:55:45'),
	(2, '221.0.144.165', '2019-10-14 15:26:16'),
	(3, '221.0.144.165', '2019-10-14 15:26:47'),
	(4, '118.138.30.14', '2019-10-14 15:27:16'),
	(5, '118.138.30.14', '2019-10-14 15:27:42'),
	(6, '0:0:0:0:0:0:0:1', '2019-11-18 14:41:40'),
	(7, '0:0:0:0:0:0:0:1', '2019-11-19 16:38:11');
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
