-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SuperSightings_Test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SuperSightings_Test` ;

-- -----------------------------------------------------
-- Schema SuperSightings_Test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SuperSightings_Test` DEFAULT CHARACTER SET utf8 ;
USE `SuperSightings_Test` ;

-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`Address` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Zipcode` VARCHAR(45) NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;





-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`Location` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`Location` (
  `LocationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NULL,
  `Latitude` VARCHAR(45) NOT NULL,
  `Longitude` VARCHAR(45) NOT NULL,
  `AddressId` INT NOT NULL,
  PRIMARY KEY (`LocationId`),
  INDEX `fk_Location_Address1_idx` (`AddressId` ASC),
  CONSTRAINT `fk_Location_Address`
    FOREIGN KEY (`AddressId`)
    REFERENCES `SuperSightings_Test`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATETIME NOT NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`SightingId`),
  INDEX `fk_Sighting_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Sighting_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSightings_Test`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`Power` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`Power` (
  `PowerId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`SuperPerson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`SuperPerson` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `IsGood` TINYINT(1) NULL,
  PRIMARY KEY (`SuperPersonId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`Organization` (
  `OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Phone` VARCHAR(10) NULL,
  `IsGood` TINYINT(1) NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`OrganizationId`),
  INDEX `fk_Organization_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Organization_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSightings_Test`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`SuperPerson_Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`),
  INDEX `fk_SuperPerson_Organization_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Organization_Organization1_idx` (`OrganizationId` ASC),
  CONSTRAINT `fk_SuperPerson_Organization_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings_Test`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Organization_Organization1`
    FOREIGN KEY (`OrganizationId`)
    REFERENCES `SuperSightings_Test`.`Organization` (`OrganizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`SuperPerson_Power` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`),
  INDEX `fk_SuperPerson_Power_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Power_Power1_idx` (`PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings_Test`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Power_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSightings_Test`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSightings_Test`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings_Test`.`SuperPerson_Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSightings_Test`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`),
  INDEX `fk_SuperPerson_Sighting_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Sighting_Sighting1_idx` (`SightingId` ASC),
  CONSTRAINT `fk_SuperPerson_Sighting_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings_Test`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Sighting_Sighting1`
    FOREIGN KEY (`SightingId`)
    REFERENCES `SuperSightings_Test`.`Sighting` (`SightingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;