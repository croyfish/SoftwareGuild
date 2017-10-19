#
# TABLE STRUCTURE FOR: RoomAddOnRateDateRange
#

DROP TABLE IF EXISTS RoomAddOnRateDateRange;

CREATE TABLE `RoomAddOnRateDateRange` (
  `RoomAddOnRateDateRangeID` int(11) NOT NULL AUTO_INCREMENT,
  `RoomAddOnRateDateRangeName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `StartDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`RoomAddOnRateDateRangeID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (1, 'voluptate', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '34');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (2, 'nesciunt', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '46');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (3, 'aut', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '36');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (4, 'tempore', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '26');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (5, 'in', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '37');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (6, 'eaque', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '29');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (7, 'omnis', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '43');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (8, 'nesciunt', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '28');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (9, 'deserunt', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '15');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (10, 'ea', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '11');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (11, 'eum', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '23');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (12, 'et', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '30');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (13, 'animi', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '19');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (14, 'in', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '29');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (15, 'in', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '21');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (16, 'sit', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '34');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (17, 'aut', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '29');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (18, 'asperiores', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '15');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (19, 'hic', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '21');
INSERT INTO RoomAddOnRateDateRange (`RoomAddOnRateDateRangeID`, `RoomAddOnRateDateRangeName`, `StartDate`, `EndDate`, `Price`) VALUES (20, 'amet', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '16');


