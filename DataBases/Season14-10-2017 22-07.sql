#
# TABLE STRUCTURE FOR: Season
#

DROP TABLE IF EXISTS Season;

CREATE TABLE `Season` (
  `SeasonID` int(11) NOT NULL AUTO_INCREMENT,
  `SeasonName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SeasonID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (1, 'possimus');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (2, 'ea');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (3, 'possimus');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (4, 'officia');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (5, 'beatae');


