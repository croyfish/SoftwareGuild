-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SuperSighting_Test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SuperSighting_Test` ;

-- -----------------------------------------------------
-- Schema SuperSighting_Test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SuperSighting_Test` DEFAULT CHARACTER SET utf8 ;
USE `SuperSighting_Test` ;

-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`Address` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Zipcode` VARCHAR(45) NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;

INSERT INTO `address` Values
(1, '123 Fake Street', 'Akron', 'OH', '44311'),
(2, '234 Fake Street', 'Akron', 'OH', '44311'),
(3, '345 Fake Street', 'Akron', 'OH', '44311'),
(4, '456 Fake Street', 'Akron', 'OH', '44311'),
(5, '567 Fake Street', 'Akron', 'OH', '44311');
 


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`Location` Matt
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`Location` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`Location` (
  `LocationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` TEXT NULL,
  `Latitude` VARCHAR(45) NOT NULL,
  `Longitude` VARCHAR(45) NOT NULL,
  `AddressId` INT NOT NULL,
  PRIMARY KEY (`LocationId`),
  INDEX `fk_Location_Address1_idx` (`AddressId` ASC),
  CONSTRAINT `fk_Location_Address`
    FOREIGN KEY (`AddressId`)
    REFERENCES `SuperSighting_Test`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`Sighting` James
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATETIME NOT NULL,
  `Description` TEXT NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`SightingId`),
  INDEX `fk_Sighting_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Sighting_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSighting_Test`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`Power` Jeff
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`Power` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`Power` (
  `PowerId` INT NOT NULL,
  `Name` VARCHAR(50) NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`SuperPerson` Albert
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`SuperPerson` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Reputation` TINYINT(1) NULL,
  PRIMARY KEY (`SuperPersonId`),
  CONSTRAINT `fk_SuperPerson_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSighting_Test`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`Organization` Lucas
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`Organization` (
  `OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Phone` VARCHAR(10) NULL,
  `Reputation` TINYINT(1) NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`OrganizationId`),
  INDEX `fk_Organization_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Organization_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSighting_Test`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`SuperPerson_Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`),
  INDEX `fk_SuperPerson_Organization_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Organization_Organization1_idx` (`OrganizationId` ASC),
  CONSTRAINT `fk_SuperPerson_Organization_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSighting_Test`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Organization_Organization1`
    FOREIGN KEY (`OrganizationId`)
    REFERENCES `SuperSighting_Test`.`Organization` (`OrganizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`SuperPerson_Power` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`),
  INDEX `fk_SuperPerson_Power_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Power_Power1_idx` (`PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSighting_Test`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Power_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSighting_Test`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting_Test`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting_Test`.`SuperPerson_Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSighting_Test`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`),
  INDEX `fk_SuperPerson_Sighting_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Sighting_Sighting1_idx` (`SightingId` ASC),
  CONSTRAINT `fk_SuperPerson_Sighting_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSighting_Test`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Sighting_Sighting1`
    FOREIGN KEY (`SightingId`)
    REFERENCES `SuperSighting_Test`.`Sighting` (`SightingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;