
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mdp`
--

-- --------------------------------------------------------



--
-- 表的结构 `message_templates`
--

CREATE TABLE IF NOT EXISTS `t_msg_templates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(40) NOT NULL,  ---模板的代码，是唯一的
  `name` VARCHAR(40) NOT NULL,   ---模板的名称
  `content` VARCHAR(2000) NOT NULL,  ---模板的内容
  `desc` VARCHAR(200),  ---模板描述
  `template_type` tinyint(4) NOT NULL,  ---模板类型
  `status` tinyint(4) NOT NULL DEFAULT 0,   ---模板的状态
  `version` int(20) NOT NULL DEFAULT 1,   ---乐观锁
  `created_by` VARCHAR(40) NOT NULL DEFAULT '',   ---创建者
  `created_at` DATETIME NOT NULL,    ---创建时间
  `updated_by` VARCHAR(40) NOT NULL DEFAULT '',  ---更新者
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  ---更新时间
  PRIMARY KEY (`id`),
  UNIQUE KEY `msg_temp_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

insert into `t_msg_templates` (`code`,`name`,`content`,`desc`,`template_type`,`created_at`) values ('sales-test','sales-test','Dear $userName: You will get $number RMB for the gift! Thanks!','sales-test',1,now());
insert into `t_msg_templates` (`code`,`name`,`content`,`desc`,`template_type`,`created_at`) values ('sales-test1','sales-test1','Dear $userName: You will get $number RMB for the gift! Thanks!','sales-test1',1,now());



--
-- 表的结构 `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_code` VARCHAR(40) NOT NULL,  ---模板的代码，是唯一的
  `reference_type` VARCHAR(100) NOT NULL,  ---消息引用者的类型
  `reference_id` bigint(20) NOT NULL,  ---消息引用者的id
  `paras` VARCHAR(2000) NOT NULL,  ---模板所含参数的值
  `status` tinyint(4) NOT NULL DEFAULT 0,   ---消息的状态
  `version` int(20) NOT NULL DEFAULT 1,   ---乐观锁
  `created_by` VARCHAR(40) NOT NULL DEFAULT '',   ---创建者
  `created_at` DATETIME NOT NULL,    ---创建时间
  `updated_by` VARCHAR(40) NOT NULL DEFAULT '',  ---更新者
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  ---更新时间
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

