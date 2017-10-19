#
# TABLE STRUCTURE FOR: RoomAmenityType
#

DROP TABLE IF EXISTS RoomAmenityType;

CREATE TABLE `RoomAmenityType` (
  `RoomAmenityTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `RoomAmenityTypeName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`RoomAmenityTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (1, 'ea');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (2, 'nihil');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (3, 'maiores');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (4, 'quam');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (5, 'architecto');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (6, 'vero');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (7, 'totam');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (8, 'laboriosam');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (9, 'nulla');
INSERT INTO RoomAmenityType (`RoomAmenityTypeID`, `RoomAmenityTypeName`) VALUES (10, 'officiis');


