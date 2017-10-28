-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema supersightings
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `supersightings` ;
-- -----------------------------------------------------
-- Schema supersightings
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supersightings` DEFAULT CHARACTER SET utf8 ;
USE `supersightings` ;
-- -----------------------------------------------------
-- Table `supersightings`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`Address` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(50) NOT NULL,
  `City` VARCHAR(50) NOT NULL,
  `State` VARCHAR(2) NOT NULL,
  `Zipcode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`Location` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`Location` (
  `LocationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Latitude` VARCHAR(15) NOT NULL,
  `Longitude` VARCHAR(15) NOT NULL,
  `AddressId` INT NOT NULL,
  PRIMARY KEY (`LocationId`),
  INDEX `fk_Location_Address1_idx` (`AddressId` ASC),
  CONSTRAINT `fk_Location_Address`
    FOREIGN KEY (`AddressId`)
    REFERENCES `supersightings`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`Sighting` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `LocationId` INT NOT NULL,
  `Description` TEXT NULL,
  PRIMARY KEY (`SightingId`),
  INDEX `fk_Sighting_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Sighting_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `supersightings`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`SuperPerson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`SuperPerson` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `isGood` TINYINT(1) NULL,
  PRIMARY KEY (`SuperPersonId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`Organization` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`Organization` (
  `OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Phone` VARCHAR(15) NOT NULL,
  `isGood` TINYINT(1) NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`OrganizationId`),
  INDEX `fk_Organization_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Organization_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `supersightings`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`Power` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`Power` (
  `PowerId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`SuperPerson_Organization` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`),
  INDEX `fk_SuperPerson_Organization_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Organization_Organization1_idx` (`OrganizationId` ASC),
  UNIQUE INDEX `index4` (`SuperPersonId` ASC, `OrganizationId` ASC),
  CONSTRAINT `fk_SuperPerson_Organization_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `supersightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Organization_Organization1`
    FOREIGN KEY (`OrganizationId`)
    REFERENCES `supersightings`.`Organization` (`OrganizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`SuperPerson_Power` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`),
  INDEX `fk_SuperPerson_Power_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Power_Power1_idx` (`PowerId` ASC),
  UNIQUE INDEX `index4` (`SuperPersonId` ASC, `PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `supersightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Power_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `supersightings`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `supersightings`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supersightings`.`SuperPerson_Sighting` ;
CREATE TABLE IF NOT EXISTS `supersightings`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`),
  INDEX `fk_SuperPerson_Sighting_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Sighting_Sighting1_idx` (`SightingId` ASC),
  UNIQUE INDEX `index4` (`SuperPersonId` ASC, `SightingId` ASC),
  CONSTRAINT `fk_SuperPerson_Sighting_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `supersightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Sighting_Sighting1`
    FOREIGN KEY (`SightingId`)
    REFERENCES `supersightings`.`Sighting` (`SightingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SuperSighting
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SuperSighting` ;

-- -----------------------------------------------------
-- Schema SuperSighting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SuperSighting` DEFAULT CHARACTER SET utf8 ;
USE `SuperSighting` ;

-- -----------------------------------------------------
-- Table `SuperSighting`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`Address` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Zipcode` VARCHAR(45) NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;





-- -----------------------------------------------------
-- Table `SuperSighting`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`Location` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`Location` (
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
    REFERENCES `SuperSighting`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATETIME NOT NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`SightingId`),
  INDEX `fk_Sighting_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Sighting_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSighting`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`Power` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`Power` (
  `PowerId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`SuperPerson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`SuperPerson` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Reputation` TINYINT(1) NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPersonId`),
  INDEX `fk_SuperPerson_Power1_idx` (`PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSighting`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`Organization` (
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
    REFERENCES `SuperSighting`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`SuperPerson_Organization` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`),
  INDEX `fk_SuperPerson_Organization_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Organization_Organization1_idx` (`OrganizationId` ASC),
  CONSTRAINT `fk_SuperPerson_Organization_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSighting`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Organization_Organization1`
    FOREIGN KEY (`OrganizationId`)
    REFERENCES `SuperSighting`.`Organization` (`OrganizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`SuperPerson_Power` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`),
  INDEX `fk_SuperPerson_Power_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Power_Power1_idx` (`PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSighting`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Power_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSighting`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SuperSighting`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSighting`.`SuperPerson_Sighting` ;

CREATE TABLE IF NOT EXISTS `SuperSighting`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`),
  INDEX `fk_SuperPerson_Sighting_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Sighting_Sighting1_idx` (`SightingId` ASC),
  CONSTRAINT `fk_SuperPerson_Sighting_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSighting`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAIN-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema SuperSightings
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SuperSightings` ;
-- -----------------------------------------------------
-- Schema SuperSightings
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SuperSightings` DEFAULT CHARACTER SET utf8 ;
USE `SuperSightings` ;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Address` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Zipcode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Location` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Location` (
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
    REFERENCES `SuperSightings`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Sighting` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `LocationId` INT NOT NULL,
  `Description` TEXT NULL,
  PRIMARY KEY (`SightingId`),
  INDEX `fk_Sighting_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Sighting_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSightings`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `isGood` TINYINT(1) NULL,
  PRIMARY KEY (`SuperPersonId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Organization` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Organization` (
  `OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Phone` VARCHAR(10) NOT NULL,
  `isGood` TINYINT(1) NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`OrganizationId`),
  INDEX `fk_Organization_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Organization_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSightings`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Power` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Power` (
  `PowerId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson_Organization` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`),
  INDEX `fk_SuperPerson_Organization_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Organization_Organization1_idx` (`OrganizationId` ASC),
  CONSTRAINT `fk_SuperPerson_Organization_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Organization_Organization1`
    FOREIGN KEY (`OrganizationId`)
    REFERENCES `SuperSightings`.`Organization` (`OrganizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson_Power` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`),
  INDEX `fk_SuperPerson_Power_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Power_Power1_idx` (`PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Power_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSightings`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson_Sighting` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`),
  INDEX `fk_SuperPerson_Sighting_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Sighting_Sighting1_idx` (`SightingId` ASC),
  CONSTRAINT `fk_SuperPerson_Sighting_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Sighting_Sighting1`
    FOREIGN KEY (`SightingId`)
    REFERENCES `SuperSightings`.`Sighting` (`SightingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema SuperSightings
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SuperSightings` ;
-- -----------------------------------------------------
-- Schema SuperSightings
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SuperSightings` DEFAULT CHARACTER SET utf8 ;
USE `SuperSightings` ;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Address` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Zipcode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AddressId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Location` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Location` (
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
    REFERENCES `SuperSightings`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Sighting` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Sighting` (
  `SightingId` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `LocationId` INT NOT NULL,
  `Description` TEXT NULL,
  PRIMARY KEY (`SightingId`),
  INDEX `fk_Sighting_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Sighting_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSightings`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson` (
  `SuperPersonId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `isGood` TINYINT(1) NULL,
  PRIMARY KEY (`SuperPersonId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Organization` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Organization` (
  `OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Description` TEXT NULL,
  `Phone` VARCHAR(10) NOT NULL,
  `isGood` TINYINT(1) NULL,
  `LocationId` INT NOT NULL,
  PRIMARY KEY (`OrganizationId`),
  INDEX `fk_Organization_Location1_idx` (`LocationId` ASC),
  CONSTRAINT `fk_Organization_Location1`
    FOREIGN KEY (`LocationId`)
    REFERENCES `SuperSightings`.`Location` (`LocationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`Power` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`Power` (
  `PowerId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`PowerId`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson_Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson_Organization` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson_Organization` (
  `SuperPerson_OrganizationId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `OrganizationId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_OrganizationId`),
  INDEX `fk_SuperPerson_Organization_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Organization_Organization1_idx` (`OrganizationId` ASC),
  CONSTRAINT `fk_SuperPerson_Organization_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Organization_Organization1`
    FOREIGN KEY (`OrganizationId`)
    REFERENCES `SuperSightings`.`Organization` (`OrganizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson_Power`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson_Power` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson_Power` (
  `SuperPerson_PowerId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `PowerId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_PowerId`),
  INDEX `fk_SuperPerson_Power_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Power_Power1_idx` (`PowerId` ASC),
  CONSTRAINT `fk_SuperPerson_Power_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Power_Power1`
    FOREIGN KEY (`PowerId`)
    REFERENCES `SuperSightings`.`Power` (`PowerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `SuperSightings`.`SuperPerson_Sighting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SuperSightings`.`SuperPerson_Sighting` ;
CREATE TABLE IF NOT EXISTS `SuperSightings`.`SuperPerson_Sighting` (
  `SuperPerson_SightingId` INT NOT NULL AUTO_INCREMENT,
  `SuperPersonId` INT NOT NULL,
  `SightingId` INT NOT NULL,
  PRIMARY KEY (`SuperPerson_SightingId`),
  INDEX `fk_SuperPerson_Sighting_SuperPerson1_idx` (`SuperPersonId` ASC),
  INDEX `fk_SuperPerson_Sighting_Sighting1_idx` (`SightingId` ASC),
  CONSTRAINT `fk_SuperPerson_Sighting_SuperPerson1`
    FOREIGN KEY (`SuperPersonId`)
    REFERENCES `SuperSightings`.`SuperPerson` (`SuperPersonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SuperPerson_Sighting_Sighting1`
    FOREIGN KEY (`SightingId`)
    REFERENCES `SuperSightings`.`Sighting` (`SightingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;T `fk_SuperPerson_Sighting_Sighting1`
    FOREIGN KEY (`SightingId`)
    REFERENCES `SuperSighting`.`Sighting` (`SightingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
