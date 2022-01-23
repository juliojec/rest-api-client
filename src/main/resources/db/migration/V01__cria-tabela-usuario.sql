CREATE TABLE user (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
    age int(11) NOT NULL,
	date_created TIMESTAMP NOT NULL,
	active SMALLINT(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `jc`.`user` (`name`, `age`, `date_created`, `active`) VALUES ('Maria Almeida', '27', '2021-08-08 12:16:34', true);
INSERT INTO `jc`.`user` (`name`, `age`, `date_created`, `active`) VALUES ('João de Oliveira', '23', '2021-08-08 12:16:34', true);
INSERT INTO `jc`.`user` (`name`, `age`, `date_created`, `active`) VALUES ('Carol Pires', '19', '2021-08-08 12:16:34', true);