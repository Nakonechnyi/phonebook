CREATE SCHEMA `phonebook` ;

CREATE TABLE `phonebook`.`users` (
  `id` MEDIUMINT(18) NOT NULL AUTO_INCREMENT,
  `pib` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `phonebook`.`contacts` (
  `id` MEDIUMINT(18) NOT NULL AUTO_INCREMENT,
  `owner` MEDIUMINT(18) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `home_phone` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `owner_idx` (`owner` ASC),
  CONSTRAINT `owner`
    FOREIGN KEY (`owner`)
    REFERENCES `phonebook`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);