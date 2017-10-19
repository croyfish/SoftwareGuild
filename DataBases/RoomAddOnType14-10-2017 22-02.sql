#
# TABLE STRUCTURE FOR: RoomAddOnType
#

DROP TABLE IF EXISTS RoomAddOnType;

CREATE TABLE `RoomAddOnType` (
  `RoomAddOnTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `RoomAddOnTypeName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`RoomAddOnTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (1, 'et');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (2, 'error');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (3, 'blanditiis');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (4, 'molestias');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (5, 'porro');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (6, 'ea');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (7, 'possimus');
INSERT INTO RoomAddOnType (`RoomAddOnTypeID`, `RoomAddOnTypeName`) VALUES (8, 'necessitatibus');


