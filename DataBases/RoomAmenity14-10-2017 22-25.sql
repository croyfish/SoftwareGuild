#
# TABLE STRUCTURE FOR: RoomAmenity
#

DROP TABLE IF EXISTS RoomAmenity;

CREATE TABLE `RoomAmenity` (
  `RoomAmenityID` int(11) NOT NULL AUTO_INCREMENT,
  `StartDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  `RoomAmenityName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Quantity` int(11) NOT NULL,
  `RoomAmenityTypeID` int(11) NOT NULL,
  PRIMARY KEY (`RoomAmenityID`),
  KEY `fk_roomamenity_roomamenitytype` (`RoomAmenityTypeID`),
  CONSTRAINT `fk_roomamenity_roomamenitytype` FOREIGN KEY (`RoomAmenityTypeID`) REFERENCES `RoomAmenityType` (`RoomAmenityTypeID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (61, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'blanditiis', 4, 8);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (62, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'sunt', 9, 4);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (63, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'aperiam', 6, 4);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (64, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'ab', 10, 7);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (65, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'aperiam', 8, 7);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (66, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'rerum', 1, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (67, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'autem', 10, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (68, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'nesciunt', 9, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (69, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'harum', 8, 2);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (70, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'esse', 4, 5);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (71, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'unde', 8, 7);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (72, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'repellendus', 1, 6);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (73, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'natus', 2, 7);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (74, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'voluptate', 9, 6);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (75, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'odit', 6, 8);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (76, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'sint', 3, 8);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (77, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'pariatur', 5, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (78, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'soluta', 2, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (79, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'non', 3, 4);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (80, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'in', 4, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (81, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'aperiam', 3, 1);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (82, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'provident', 3, 5);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (83, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'placeat', 4, 7);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (84, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'consequatur', 2, 4);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (85, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'ipsum', 6, 6);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (86, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'eaque', 8, 8);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (87, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'dolorem', 3, 2);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (88, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'quo', 5, 4);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (89, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'dolor', 2, 3);
INSERT INTO RoomAmenity (`RoomAmenityID`, `StartDate`, `EndDate`, `RoomAmenityName`, `Quantity`, `RoomAmenityTypeID`) VALUES (90, '2015-01-01 00:00:00', '2018-01-01 00:00:00', 'quia', 2, 2);


