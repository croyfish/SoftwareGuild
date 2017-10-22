-- MySQL Workbench Forward Engineering


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SuperSighting-test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SuperSighting-test` ;

-- -----------------------------------------------------
-- Schema SuperSighting-test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SuperSighting-test` DEFAULT CHARACTER SET utf8 ;
USE `SuperSighting-test` ;



-- -----------------------------------------------------
-- Table `SuperSighting-test`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`Address` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Zipcode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `SuperSighting-test`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`Location` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`Location` (
  `LocationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` TEXT NULL,
  `Latitude` VARCHAR(45) NOT NULL,
  `Longitude` VARCHAR(45) NOT NULL,
  `AddressId` INT NOT NULL,
  PRIMARY KEY (`LocationId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSighting-test`.`Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `LocationId` INT NOT NULL,
  `Description` TEXT NULL,
  PRIMARY KEY (`SightingId`))
ENGINE = InnoDB;


select * from Sighting;
-- -----------------------------------------------------
-- Table `SuperSighting-test`.`SuperPerson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`SuperPerson` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `isGood` TINYINT(1) NULL,
  PRIMARY KEY (`SuperPersonId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting-test`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`Organization` (
  `OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Phone` VARCHAR(10) NOT NULL,
  `isGood` TINYINT(1) NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`OrganizationId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting-test`.`Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`Power` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`Power` (
  `PowerId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `SuperSighting-test`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`SuperPerson_Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting-test`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`SuperPerson_Power` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `SuperSighting-test`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting-test`.`SuperPerson_Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSighting-test`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET FOREIGN_KEY_CHECKS=0;