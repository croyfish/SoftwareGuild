#
# TABLE STRUCTURE FOR: PromotionCodeType
#

DROP TABLE IF EXISTS PromotionCodeType;

CREATE TABLE `PromotionCodeType` (
  `PromotionCodeTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `PromotionCodeName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PromotionCodeTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO PromotionCodeType (`PromotionCodeTypeID`, `PromotionCodeName`) VALUES (1, 'adipisci');
INSERT INTO PromotionCodeType (`PromotionCodeTypeID`, `PromotionCodeName`) VALUES (2, 'temporibus');


