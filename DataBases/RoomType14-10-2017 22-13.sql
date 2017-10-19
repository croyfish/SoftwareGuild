#
# TABLE STRUCTURE FOR: RoomType
#

DROP TABLE IF EXISTS RoomType;

CREATE TABLE `RoomType` (
  `RoomTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `RoomTypeName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Occupancy` tinyint(4) DEFAULT NULL,
  `StartTime` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  PRIMARY KEY (`RoomTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (1, 'saepe', 2, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (2, 'velit', 2, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (3, 'omnis', 3, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (4, 'omnis', 4, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (5, 'ut', 2, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (6, 'mollitia', 3, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (7, 'et', 4, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (8, 'commodi', 4, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (9, 'magnam', 2, '2015-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO RoomType (`RoomTypeID`, `RoomTypeName`, `Occupancy`, `StartTime`, `EndDate`) VALUES (10, 'voluptatibus', 1, '2015-01-01 00:00:00', '2018-01-01 00:00:00');


