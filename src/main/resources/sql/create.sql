CREATE SCHEMA `phonebook` ;

CREATE TABLE `phonebook`.`users` (
  `id` MEDIUMINT(18) NOT NULL AUTO_INCREMENT,
  `pib` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
