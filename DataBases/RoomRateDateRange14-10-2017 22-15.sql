#
# TABLE STRUCTURE FOR: RoomRateDateRange
#

DROP TABLE IF EXISTS RoomRateDateRange;

CREATE TABLE `RoomRateDateRange` (
  `RoomRateDateRangeID` int(11) NOT NULL AUTO_INCREMENT,
  `Price` decimal(10,0) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  PRIMARY KEY (`RoomRateDateRangeID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (1, '158', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (2, '241', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (3, '216', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (4, '260', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (5, '97', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (6, '267', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (7, '204', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (8, '177', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (9, '298', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (10, '80', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (11, '198', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (12, '90', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (13, '165', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (14, '226', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (15, '250', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (16, '213', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (17, '86', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (18, '214', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (19, '257', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (20, '238', '2015-01-01', '2018-01-01');


