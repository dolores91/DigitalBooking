-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema usertest
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema usertest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usertest` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema booking-v4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema booking-v4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booking-v4` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `usertest` ;

-- -----------------------------------------------------
-- Table `usertest`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usertest`.`role` (
  `idrole` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `active` VARCHAR(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`idrole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usertest`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usertest`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `idNumber` VARCHAR(45) NOT NULL,
  `email` VARCHAR(252) NOT NULL,
  `password` VARCHAR(252) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `role_idrole` INT NOT NULL,
  PRIMARY KEY (`iduser`),
  INDEX `fk_user_role_idx` (`role_idrole` ASC) VISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_idrole`)
    REFERENCES `usertest`.`role` (`idrole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `booking-v4` ;

-- -----------------------------------------------------
-- Table `booking-v4`.`attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`attribute` (
  `idattribute` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `icon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idattribute`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`category` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `description` VARCHAR(1024) NOT NULL,
  `url` VARCHAR(252) NOT NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`city` (
  `idcity` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcity`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `year` VARCHAR(4) NOT NULL,
  `descriptionA` TEXT NOT NULL,
  `descriptionB` TEXT NOT NULL,
  `descriptionC` TEXT NOT NULL,
  `descriptionD` TEXT NOT NULL,
  `address` VARCHAR(512) NOT NULL,
  `location_detail` TEXT NOT NULL,
  `latitude` FLOAT NOT NULL,
  `longitude` FLOAT NOT NULL,
  `city_idcity` INT NOT NULL,
  `category_idcategory` INT NOT NULL,
  PRIMARY KEY (`idproduct`),
  INDEX `fk_product_city1_idx` (`city_idcity` ASC) VISIBLE,
  INDEX `fk_product_category1_idx` (`category_idcategory` ASC) VISIBLE,
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_idcategory`)
    REFERENCES `booking-v4`.`category` (`idcategory`),
  CONSTRAINT `fk_product_city1`
    FOREIGN KEY (`city_idcity`)
    REFERENCES `booking-v4`.`city` (`idcity`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`role` (
  `idrole` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `active` VARCHAR(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`idrole`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `idnumber` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `role_idrole` INT NOT NULL,
  PRIMARY KEY (`iduser`),
  INDEX `fk_user_role_idx` (`role_idrole` ASC) INVISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_idrole`)
    REFERENCES `booking-v4`.`role` (`idrole`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`booking` (
  `idbooking` INT NOT NULL AUTO_INCREMENT,
  `checkin_date` DATE NOT NULL,
  `checkout_date` DATE NOT NULL,
  `checkin_time` TIME NOT NULL,
  `product_idproduct` INT NOT NULL,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idbooking`),
  INDEX `fk_booking_product1_idx` (`product_idproduct` ASC) VISIBLE,
  INDEX `fk_booking_user1_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_booking_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `booking-v4`.`product` (`idproduct`),
  CONSTRAINT `fk_booking_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `booking-v4`.`user` (`iduser`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`favorite` (
  `idfavorite` INT NOT NULL AUTO_INCREMENT,
  `user_iduser` INT NOT NULL,
  `product_idproduct` INT NOT NULL,
  PRIMARY KEY (`idfavorite`),
  INDEX `fk_favorite_user1_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_favorite_product1_idx` (`product_idproduct` ASC) VISIBLE,
  CONSTRAINT `fk_favorite_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `booking-v4`.`product` (`idproduct`),
  CONSTRAINT `fk_favorite_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `booking-v4`.`user` (`iduser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`image` (
  `idimage` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `url` VARCHAR(252) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `product_idproduct` INT NOT NULL,
  PRIMARY KEY (`idimage`),
  INDEX `fk_image_product1_idx` (`product_idproduct` ASC) VISIBLE,
  CONSTRAINT `fk_image_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `booking-v4`.`product` (`idproduct`))
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`product_attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`product_attribute` (
  `idproduct_attribute` INT NOT NULL AUTO_INCREMENT,
  `attribute_idattribute` INT NOT NULL,
  `product_idproduct` INT NOT NULL,
  PRIMARY KEY (`idproduct_attribute`),
  INDEX `fk_product_attribute_attribute1_idx` (`attribute_idattribute` ASC) VISIBLE,
  INDEX `fk_product_attribute_product1_idx` (`product_idproduct` ASC) VISIBLE,
  CONSTRAINT `fk_product_attribute_attribute1`
    FOREIGN KEY (`attribute_idattribute`)
    REFERENCES `booking-v4`.`attribute` (`idattribute`),
  CONSTRAINT `fk_product_attribute_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `booking-v4`.`product` (`idproduct`))
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`rule_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`rule_category` (
  `idrule_category` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `description` VARCHAR(1024) NOT NULL,
  PRIMARY KEY (`idrule_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `booking-v4`.`rule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`rule` (
  `idrule` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` TEXT NOT NULL,
  `fine` FLOAT NULL DEFAULT NULL,
  `rule_category_idrule_category` INT NOT NULL,
  PRIMARY KEY (`idrule`),
  INDEX `fk_rule_rule_category1_idx` (`rule_category_idrule_category` ASC) VISIBLE,
  CONSTRAINT `fk_rule_rule_category1`
    FOREIGN KEY (`rule_category_idrule_category`)
    REFERENCES `booking-v4`.`rule_category` (`idrule_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking-v4`.`rule_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking-v4`.`rule_product` (
  `rule_idrule` INT NOT NULL,
  `product_idproduct` INT NOT NULL,
  INDEX `fk_rule_product_rule1_idx` (`rule_idrule` ASC) VISIBLE,
  INDEX `fk_rule_product_product1_idx` (`product_idproduct` ASC) VISIBLE,
  CONSTRAINT `fk_rule_product_rule1`
    FOREIGN KEY (`rule_idrule`)
    REFERENCES `booking-v4`.`rule` (`idrule`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rule_product_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `booking-v4`.`product` (`idproduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
