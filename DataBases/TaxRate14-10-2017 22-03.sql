#
# TABLE STRUCTURE FOR: TaxRate
#

DROP TABLE IF EXISTS TaxRate;

CREATE TABLE `TaxRate` (
  `TaxRateId` int(11) NOT NULL AUTO_INCREMENT,
  `TaxRateName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  PRIMARY KEY (`TaxRateId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO TaxRate (`TaxRateId`, `TaxRateName`, `StartDate`, `EndDate`) VALUES (1, 'dolorum', '2015-01-01', '2018-01-01');
INSERT INTO TaxRate (`TaxRateId`, `TaxRateName`, `StartDate`, `EndDate`) VALUES (2, 'saepe', '2015-01-01', '2018-01-01');
INSERT INTO TaxRate (`TaxRateId`, `TaxRateName`, `StartDate`, `EndDate`) VALUES (3, 'laborum', '2015-01-01', '2018-01-01');


