DROP DATABASE IF EXISTS dvd_library;
CREATE DATABASE IF NOT EXISTS dvd_library;

USE dvd_library;

DROP TABLE IF EXISTS dvd;
CREATE TABLE dvd (
	SKU INT(11) NOT NULL AUTO_INCREMENT,
	title VARCHAR (60),
    releaseDate DATE,
    MPAARating VARCHAR(10),
    director VARCHAR(45),
    studio VARCHAR(60),
    userNote VARCHAR(300),
    PRIMARY KEY (SKU)
);


DROP DATABASE IF EXISTS dvd_library_test;
CREATE DATABASE IF NOT EXISTS dvd_library_test;

USE dvd_library_test;

DROP TABLE IF EXISTS dvd;
DROP TABLE IF EXISTS dvd;
CREATE TABLE dvd (
	SKU INT(11) NOT NULL AUTO_INCREMENT,
	title VARCHAR (60),
    releaseDate DATE,
    MPAARating VARCHAR(10),
    director VARCHAR(45),
    studio VARCHAR(60),
    userNote VARCHAR(300),
    PRIMARY KEY (SKU)
);  
