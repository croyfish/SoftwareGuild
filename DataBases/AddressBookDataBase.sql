DROP DATABASE IF EXISTS address_book;
CREATE DATABASE IF NOT EXISTS address_book;

USE address_book;

DROP TABLE IF EXISTS address;
CREATE TABLE address (
	AddressID INT(11) NOT NULL AUTO_INCREMENT,
	FirstName VARCHAR (30),
    LastName VARCHAR(30),
    StreetAddress VARCHAR(45),
    City VARCHAR(30),
    State VARCHAR(30),
    ZipCode INT(11),
    PRIMARY KEY (AddressID)
);


DROP DATABASE IF EXISTS address_book_test;
CREATE DATABASE IF NOT EXISTS address_book_test;

USE address_book_test;

DROP TABLE IF EXISTS address;
CREATE TABLE address (
	AddressID INT(11) NOT NULL AUTO_INCREMENT,
	FirstName VARCHAR (30),
    LastName VARCHAR(30),
    StreetAddress VARCHAR(45),
    City VARCHAR(30),
    State VARCHAR(30),
    ZipCode INT(11),
    PRIMARY KEY (AddressID)
);    

