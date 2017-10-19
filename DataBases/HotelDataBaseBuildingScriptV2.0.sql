Drop database If Exists Hotel;

Create database If Not Exists Hotel;  

use Hotel;  

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


#
# TABLE STRUCTURE FOR: Override
#

DROP TABLE IF EXISTS Override;

CREATE TABLE `Override` (
  `OverrideID` int(11) NOT NULL AUTO_INCREMENT,
  `OverrideReasonName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `OverrideReasonDescription` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`OverrideID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (1, 'maiores', 'Pariatur in omnis architecto enim aut quibusdam sed.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (2, 'ipsum', 'Et quam numquam ab eveniet eius pariatur.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (3, 'dicta', 'Aspernatur enim sapiente eos sequi voluptas.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (4, 'explicabo', 'Adipisci nihil esse illo fugit.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (5, 'minima', 'Facere soluta nostrum dolores magni.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (6, 'expedita', 'Velit veniam hic a.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (7, 'et', 'Eos magnam vitae natus maxime ut ratione dolor.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (8, 'voluptatibus', 'Iusto dolores vel maxime voluptates voluptatibus id a.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (9, 'aut', 'Accusantium deserunt veniam facere.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (10, 'necessitatibus', 'Doloribus dolores ipsa culpa doloribus rem suscipit voluptas.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (11, 'qui', 'Molestiae ducimus ut aut.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (12, 'omnis', 'Sit accusamus in sed et neque.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (13, 'temporibus', 'Quod eius debitis repudiandae quibusdam vitae.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (14, 'nemo', 'Rerum eligendi molestias dolores ut sed.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (15, 'eos', 'Accusamus sed ex occaecati ut pariatur non.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (16, 'aut', 'Qui quam ea sit sed.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (17, 'deleniti', 'Qui fugiat voluptatem porro sequi aut.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (18, 'minus', 'Excepturi totam magnam omnis voluptatibus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (19, 'aut', 'Sint sunt vero similique.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (20, 'omnis', 'Omnis a voluptatem in nihil eligendi praesentium.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (21, 'amet', 'Autem ut consequatur ipsam architecto cumque vel facilis.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (22, 'esse', 'Laborum aut eum quia maxime.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (23, 'esse', 'Enim sed est minima voluptatem provident et possimus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (24, 'sapiente', 'Quae hic dicta recusandae voluptatibus illo doloribus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (25, 'recusandae', 'Quo molestiae qui est nihil repellendus odio.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (26, 'in', 'Cumque iusto architecto et saepe quaerat aut et.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (27, 'dignissimos', 'Sit hic eveniet quo adipisci et dolor.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (28, 'vel', 'Quis velit reiciendis facere nostrum expedita nostrum qui.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (29, 'blanditiis', 'Ut dolor dolores ea et quibusdam.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (30, 'provident', 'Quo soluta animi sit velit eos voluptas et.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (31, 'quia', 'Error eveniet corrupti vitae dolores.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (32, 'distinctio', 'Eum aut omnis consequatur laudantium.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (33, 'eligendi', 'Quia quibusdam laborum temporibus animi sint dolore officia.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (34, 'dicta', 'Omnis nemo consequuntur dolor.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (35, 'veniam', 'Eaque dolores maiores commodi omnis itaque.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (36, 'dicta', 'Distinctio recusandae non explicabo ut exercitationem soluta.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (37, 'blanditiis', 'Mollitia ut nam id blanditiis et ipsum qui.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (38, 'aut', 'Magni natus est dolor deserunt ex non inventore.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (39, 'nobis', 'Est perspiciatis sapiente ut ut sapiente dolor.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (40, 'eveniet', 'Qui consectetur et asperiores debitis.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (41, 'architecto', 'Nesciunt totam optio esse commodi explicabo.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (42, 'qui', 'Rem tenetur tenetur rerum ipsum beatae quidem et.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (43, 'eum', 'Tenetur necessitatibus excepturi blanditiis quia placeat voluptas.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (44, 'ab', 'Sed et unde temporibus dolores.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (45, 'exercitationem', 'Nostrum et qui eum dolore quia praesentium et.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (46, 'voluptas', 'Sit molestiae sequi sint officiis repellendus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (47, 'nesciunt', 'Temporibus sit officiis porro laborum et cupiditate quaerat.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (48, 'cupiditate', 'Ut reiciendis commodi atque similique laborum.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (49, 'cupiditate', 'Ipsa et hic enim impedit.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (50, 'aut', 'Est debitis et at consectetur et minus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (51, 'ipsum', 'Dolor recusandae consectetur laudantium at id voluptatem.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (52, 'laborum', 'Ad enim autem voluptas vel cumque.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (53, 'in', 'In ex et alias assumenda dolor quod.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (54, 'quisquam', 'Quae consequatur maxime sit nisi.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (55, 'et', 'Similique ad neque facere architecto rerum reiciendis illo.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (56, 'eum', 'Qui explicabo aut ratione dignissimos sapiente.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (57, 'deleniti', 'Enim recusandae porro numquam aut sunt.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (58, 'sint', 'Molestiae minima nisi suscipit qui sunt et deserunt voluptatem.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (59, 'error', 'Beatae et dolor corrupti deleniti.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (60, 'exercitationem', 'Qui cum voluptatum sit minus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (61, 'consequatur', 'Est architecto possimus accusantium dolorum rerum nostrum ratione nemo.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (62, 'ea', 'Ea nostrum velit exercitationem nobis consequatur qui.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (63, 'esse', 'Dolor numquam et nihil qui optio eius minus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (64, 'reiciendis', 'Beatae sunt non recusandae ut dignissimos voluptatem et.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (65, 'qui', 'Porro veniam ipsam dolorum consectetur id porro quia.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (66, 'accusantium', 'Consequatur aut maiores tempore architecto.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (67, 'quam', 'Porro mollitia animi voluptatum numquam sit quia.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (68, 'qui', 'Sunt modi mollitia ipsum quia.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (69, 'perferendis', 'Et quia numquam consequatur ab incidunt rerum.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (70, 'placeat', 'Ut alias quae nostrum iure officia rem velit voluptatem.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (71, 'vel', 'Incidunt qui ea quidem quod.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (72, 'sunt', 'Aut nesciunt quia tempore odit blanditiis nulla.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (73, 'voluptas', 'Ipsum reiciendis qui qui.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (74, 'est', 'Similique et et molestias blanditiis.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (75, 'ut', 'Omnis voluptates blanditiis autem.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (76, 'cupiditate', 'Dolor magni reiciendis omnis quo voluptatum deserunt.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (77, 'vel', 'Esse quaerat repellendus inventore molestiae neque at.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (78, 'delectus', 'Est vitae eum ea quasi modi eaque.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (79, 'voluptas', 'Aut sed id placeat neque et et dolor.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (80, 'esse', 'Ea amet voluptatem voluptatem placeat sequi.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (81, 'aut', 'Cum nesciunt enim architecto nihil quis doloremque rerum ut.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (82, 'et', 'Expedita exercitationem ullam ducimus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (83, 'corrupti', 'Officia aut aut rem dolorem.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (84, 'facilis', 'Illum aliquam quae eius molestiae.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (85, 'accusantium', 'Reprehenderit ut et temporibus a tempore occaecati necessitatibus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (86, 'assumenda', 'Animi dolorem magnam numquam dolor rem.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (87, 'ut', 'Odit deserunt reprehenderit qui veniam.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (88, 'id', 'Dicta esse mollitia soluta.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (89, 'ullam', 'Fuga nesciunt nesciunt similique.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (90, 'placeat', 'Consequatur sed dolores sequi laborum.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (91, 'consequatur', 'Architecto explicabo quam soluta et amet inventore excepturi.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (92, 'ut', 'In porro aspernatur blanditiis.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (93, 'odit', 'Voluptatibus eum sit libero explicabo.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (94, 'nostrum', 'Odit molestiae non sint est sed qui voluptatum.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (95, 'officiis', 'Repudiandae maiores rerum quas voluptatem corporis.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (96, 'quia', 'Et voluptate et inventore.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (97, 'velit', 'Voluptas autem totam velit qui temporibus.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (98, 'id', 'Qui rem molestias porro aut quisquam.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (99, 'asperiores', 'Id aut sed laudantium.');
INSERT INTO Override (`OverrideID`, `OverrideReasonName`, `OverrideReasonDescription`) VALUES (100, 'dolor', 'Rerum voluptatum eveniet adipisci.');


#
# TABLE STRUCTURE FOR: Season
#

DROP TABLE IF EXISTS Season;

CREATE TABLE `Season` (
  `SeasonID` int(11) NOT NULL AUTO_INCREMENT,
  `SeasonName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SeasonID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (1, 'Spring');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (2, 'Summer');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (3, 'Fall');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (4, 'Winter');
INSERT INTO Season (`SeasonID`, `SeasonName`) VALUES (5, 'Smarch');


#
# TABLE STRUCTURE FOR: PromotionCodeType
#

DROP TABLE IF EXISTS PromotionCodeType;

CREATE TABLE `PromotionCodeType` (
  `PromotionCodeTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `PromotionCodeName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PromotionCodeTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO PromotionCodeType (`PromotionCodeTypeID`, `PromotionCodeName`) VALUES (1, 'percent');
INSERT INTO PromotionCodeType (`PromotionCodeTypeID`, `PromotionCodeName`) VALUES (2, 'flat discount');


#
# TABLE STRUCTURE FOR: Address
#

DROP TABLE IF EXISTS Address;

CREATE TABLE `Address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressNumber` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Street` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `State` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ZipCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (1, '6930', 'Bauch Forge', 'NH', '29067-3517');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (2, '49762', 'Carli Greens', 'ND', '91763');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (3, '0265', 'Bosco Point', 'WY', '84070');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (4, '1422', 'Hulda Landing', 'UT', '78412-6459');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (5, '6524', 'Swaniawski Lodge', 'CT', '01943-6675');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (6, '71537', 'Winona Brooks', 'ND', '51716-0546');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (7, '1794', 'Helene Parks', 'DC', '20794');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (8, '8723', 'Gardner Keys', 'OR', '27501');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (9, '037', 'Miles Bridge', 'MA', '83145');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (10, '11213', 'Boehm Plaza', 'PA', '44401-1888');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (11, '030', 'Enrico Stravenue', 'WI', '84859-6234');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (12, '575', 'Kreiger Radial', 'AL', '29340');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (13, '1620', 'Alize Wall', 'SC', '45023');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (14, '243', 'Goodwin Ramp', 'NH', '56310');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (15, '41104', 'Susanna Streets', 'OK', '92224');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (16, '8190', 'Dietrich Circles', 'MN', '55730-0421');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (17, '261', 'Ansel Fords', 'CA', '45138-9066');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (18, '6669', 'Jadyn Parkway', 'AR', '52623');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (19, '95342', 'Kihn Mountains', 'RI', '98835');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (20, '2991', 'Johathan Fall', 'NV', '50294');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (21, '009', 'Christiana Via', 'ME', '32937');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (22, '69327', 'Enrico Cliff', 'MI', '00493-9388');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (23, '055', 'Jast Bridge', 'ME', '87801');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (24, '7623', 'Lueilwitz Haven', 'AL', '69301-4818');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (25, '455', 'Noah Point', 'SD', '34855-0782');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (26, '7094', 'Wanda Tunnel', 'WV', '23151-8415');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (27, '75539', 'Metz Common', 'NM', '78768-4184');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (28, '6657', 'Mabel Ridge', 'TX', '23670');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (29, '53568', 'Daniella Way', 'MS', '81821');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (30, '264', 'Aurore Heights', 'TN', '45341');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (31, '88122', 'Marianna Trail', 'MS', '27527-9008');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (32, '41165', 'Colt Manor', 'NV', '60662-7123');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (33, '8247', 'Schowalter Forges', 'AL', '08849-6775');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (34, '131', 'Elena Union', 'AL', '01778-1171');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (35, '9738', 'Vivianne Groves', 'SD', '27815-9564');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (36, '494', 'Imani Springs', 'WI', '91666');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (37, '354', 'Rebeca Plaza', 'ID', '36687-7611');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (38, '285', 'Hahn Cove', 'GA', '63718-4494');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (39, '9619', 'Gutkowski Centers', 'NY', '61021-9940');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (40, '7255', 'Bernhard Roads', 'OK', '30654');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (41, '54844', 'Amy Grove', 'MD', '43303-8560');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (42, '163', 'Kulas Locks', 'NE', '89943-6726');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (43, '4486', 'Toy Courts', 'CT', '43104');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (44, '324', 'Fadel Meadows', 'KS', '13855');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (45, '1813', 'Weissnat Springs', 'ME', '41050');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (46, '7122', 'Serena Forge', 'MA', '18493-9823');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (47, '7403', 'Carmen Knoll', 'TN', '09083-5016');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (48, '461', 'Bruen Harbors', 'ID', '90877-6710');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (49, '15844', 'Daugherty Mountains', 'NE', '04538');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (50, '19518', 'Juanita Springs', 'ID', '06552');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (51, '106', 'Marvin Fall', 'TN', '57598');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (52, '46100', 'Jerry Radial', 'NJ', '99973-4555');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (53, '678', 'Koepp Mission', 'NM', '11044-0599');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (54, '0359', 'Ansley Club', 'IL', '04002');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (55, '007', 'Parker Vista', 'KY', '36478-8409');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (56, '734', 'Kshlerin Prairie', 'HI', '87391-5846');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (57, '3699', 'Rupert Glens', 'GA', '79057');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (58, '1042', 'Nicolette Mountain', 'NC', '21095');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (59, '538', 'Lafayette Junction', 'WV', '01271');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (60, '8956', 'Rath Groves', 'NM', '23984');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (61, '438', 'Renner Fork', 'MI', '14971');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (62, '3496', 'Reyna Rapid', 'HI', '49891-5330');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (63, '041', 'Dino Green', 'RI', '46137');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (64, '2170', 'Luis Haven', 'MO', '71822-5027');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (65, '49280', 'Graham Green', 'ME', '79720');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (66, '076', 'Morissette Shoal', 'CO', '31162-2941');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (67, '03445', 'Kohler Brook', 'OR', '83195');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (68, '26406', 'Stehr Roads', 'NE', '32688');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (69, '7435', 'Altenwerth Cape', 'CA', '65766');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (70, '154', 'Maudie Knoll', 'ME', '27639');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (71, '1783', 'Grant Walk', 'NH', '16615');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (72, '23589', 'Reilly Village', 'MN', '57528');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (73, '528', 'Champlin Estates', 'ID', '52515');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (74, '51149', 'Stanford Light', 'AR', '82833-8276');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (75, '7318', 'Dooley Spur', 'MN', '05803');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (76, '16047', 'Odell Green', 'WA', '13458');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (77, '73630', 'Karolann Gardens', 'LA', '51299');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (78, '59965', 'Barton Fords', 'VT', '68557-8042');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (79, '12087', 'Vivienne Green', 'GA', '49558');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (80, '45336', 'Marge Corners', 'WV', '64539');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (81, '456', 'Witting Rapid', 'NH', '96216-8283');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (82, '6506', 'Rau Stravenue', 'ME', '50909');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (83, '2572', 'Kovacek Hollow', 'NM', '53970-5511');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (84, '0394', 'Tillman Stream', 'ND', '40091');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (85, '831', 'Parker Ramp', 'MN', '29091-3781');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (86, '368', 'Blair Mission', 'NV', '14339-5618');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (87, '957', 'Alice Falls', 'NV', '58236-4313');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (88, '10324', 'Giovani Harbor', 'NE', '00575');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (89, '23690', 'Lueilwitz Squares', 'OH', '67595-3423');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (90, '06461', 'Franecki Flats', 'WA', '55159-1938');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (91, '8376', 'Reinger Plains', 'WY', '94210');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (92, '75650', 'Boyle Course', 'OR', '49588-0213');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (93, '33625', 'Weissnat Parkway', 'MA', '04255');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (94, '03609', 'Shyann Burg', 'WI', '59255');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (95, '6176', 'Rory Port', 'AL', '05438');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (96, '466', 'Winifred Falls', 'AL', '14029-7608');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (97, '070', 'Elwin Islands', 'NY', '00166');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (98, '7413', 'Predovic Terrace', 'CO', '08911');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (99, '703', 'Greenholt Club', 'NC', '30672-8841');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (100, '13887', 'O\'Keefe Groves', 'MI', '52642');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (101, '7022', 'Schneider Greens', 'MD', '62334');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (102, '4415', 'Carlotta Flat', 'NM', '94455-1762');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (103, '440', 'Huels Gardens', 'RI', '38436-8509');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (104, '162', 'Anderson Courts', 'LA', '77314');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (105, '39254', 'Neal Islands', 'TN', '63219');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (106, '6298', 'Vicenta Lodge', 'NM', '12970');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (107, '98637', 'Kayley Bypass', 'TX', '83241-8313');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (108, '74413', 'Hodkiewicz Squares', 'AZ', '87665');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (109, '278', 'Cummings Forest', 'MS', '31927-1032');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (110, '7774', 'Tatum Glens', 'NE', '12827-1802');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (111, '938', 'Edgar Spur', 'IL', '57937-6269');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (112, '6182', 'Chelsey Falls', 'NJ', '81684-5474');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (113, '831', 'Hane Expressway', 'WA', '59793-7409');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (114, '307', 'Metz Rest', 'PA', '19272-3074');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (115, '60285', 'Alysson Landing', 'IA', '16327');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (116, '1961', 'Mraz Spur', 'ND', '70615-7404');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (117, '26224', 'Art Passage', 'FL', '78390-5344');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (118, '368', 'Eleazar Overpass', 'FL', '14469');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (119, '45606', 'Bergnaum Motorway', 'FL', '21021');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (120, '4514', 'Devan Plaza', 'AL', '48919-5900');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (121, '08741', 'Kling Trail', 'NH', '50485');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (122, '587', 'Ritchie Summit', 'OK', '03856-9411');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (123, '38298', 'Tanya Centers', 'DC', '32736-8205');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (124, '329', 'Frami Springs', 'AR', '74991');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (125, '916', 'Samson Stravenue', 'FL', '05621-2051');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (126, '3244', 'Maia Ways', 'UT', '28922');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (127, '2982', 'Ozella Lakes', 'MD', '04047');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (128, '9004', 'Maximilian Radial', 'WV', '84965-0686');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (129, '04684', 'Geovany Haven', 'NC', '72673');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (130, '3642', 'Tobin Fork', 'SD', '25594');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (131, '915', 'Allen Spring', 'AL', '41547');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (132, '25278', 'Myah Estates', 'ME', '50120');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (133, '0107', 'Audra Stravenue', 'MD', '36794');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (134, '199', 'Lia Loaf', 'CT', '09628');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (135, '80378', 'Bayer Tunnel', 'HI', '82277-3861');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (136, '286', 'Rosenbaum Fields', 'VA', '90356');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (137, '30125', 'Orland Heights', 'NE', '64365-6197');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (138, '462', 'VonRueden Brooks', 'MI', '67962');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (139, '69277', 'Eichmann Valley', 'WA', '81067');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (140, '6658', 'Tristian Walk', 'MO', '93863');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (141, '7268', 'Aufderhar Corner', 'ND', '03129');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (142, '4345', 'Trantow Ranch', 'IN', '76884-6723');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (143, '9667', 'Sally Street', 'SD', '99361');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (144, '380', 'Rau Shoals', 'IA', '61183');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (145, '0689', 'Kiehn Courts', 'AZ', '56943');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (146, '9857', 'Raynor Ports', 'DC', '29418-3080');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (147, '370', 'Concepcion Walks', 'VA', '52752-5170');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (148, '9090', 'Osinski Roads', 'HI', '83247');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (149, '17710', 'Orion Radial', 'NC', '92959-0596');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (150, '187', 'Maia Ridges', 'PA', '06969-4279');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (151, '399', 'Leonor Drive', 'CO', '08890');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (152, '0848', 'Howard Wall', 'DE', '77413-6096');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (153, '916', 'Carolina Estates', 'MA', '98915');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (154, '560', 'Alessandro Heights', 'VA', '70168-2784');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (155, '480', 'Saige Ways', 'CO', '34744');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (156, '4511', 'Wilkinson Flats', 'OR', '06746');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (157, '317', 'Bianka Spring', 'IN', '48192');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (158, '79276', 'Blick Garden', 'MI', '09685-2893');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (159, '2307', 'Garrett Groves', 'NJ', '54478-0612');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (160, '2829', 'Emery Throughway', 'PA', '14817');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (161, '8949', 'Thompson Camp', 'VT', '67277');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (162, '03658', 'Hilpert Fall', 'AZ', '25717-5680');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (163, '57543', 'Kuphal Tunnel', 'NC', '97014-7124');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (164, '189', 'Velda Unions', 'DC', '46155-9790');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (165, '8457', 'Kertzmann Walks', 'DC', '63567');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (166, '90178', 'Kris Circle', 'KS', '94963-1406');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (167, '9811', 'Arielle Camp', 'WY', '77559');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (168, '328', 'Cortney Turnpike', 'AZ', '80529-4954');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (169, '2699', 'Delfina Knoll', 'PA', '76252');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (170, '20297', 'Langosh Gardens', 'AR', '91049-3056');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (171, '417', 'Macejkovic Underpass', 'NJ', '13473');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (172, '64836', 'Lesch Spring', 'RI', '31073');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (173, '9744', 'Birdie Lakes', 'MN', '20328');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (174, '1814', 'Sally Center', 'WI', '79283');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (175, '1244', 'Ferry Center', 'ND', '40240');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (176, '75259', 'Emard Wells', 'SC', '20896');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (177, '22135', 'Heathcote Ford', 'WY', '23880-3458');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (178, '91010', 'Eve Drive', 'MI', '58787');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (179, '8824', 'Strosin Ford', 'RI', '32578-9680');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (180, '6252', 'Tom Coves', 'OH', '22143-4691');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (181, '3330', 'Schiller Well', 'MD', '51506-2640');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (182, '4913', 'Lorenza Bridge', 'MA', '53338-7837');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (183, '727', 'Stehr Shores', 'OK', '76204');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (184, '29306', 'Nitzsche Cliffs', 'CT', '33593');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (185, '912', 'Uriel Hills', 'IN', '56654');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (186, '69757', 'O\'Conner Manor', 'NC', '70248');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (187, '739', 'Beatty Streets', 'MT', '04088');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (188, '2728', 'Camila Passage', 'NY', '70134-8419');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (189, '8967', 'Russel Pass', 'NM', '86622');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (190, '9890', 'Schuster Point', 'PA', '82235');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (191, '04634', 'Onie Causeway', 'NM', '73724');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (192, '870', 'Dedrick Crest', 'KY', '82275');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (193, '2255', 'Collins Summit', 'AZ', '33023-5955');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (194, '57901', 'West Forks', 'MS', '45120');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (195, '64130', 'Raymundo Gardens', 'OR', '86111-4635');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (196, '77844', 'Kunde Run', 'MT', '14795-6876');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (197, '87270', 'Brianne Forest', 'WV', '85706');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (198, '17574', 'Hirthe Rapids', 'WI', '35878');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (199, '4499', 'Cassidy Villages', 'AK', '84679');
INSERT INTO Address (`AddressID`, `AddressNumber`, `Street`, `State`, `ZipCode`) VALUES (200, '3652', 'Lou Squares', 'MI', '68871');




#
# TABLE STRUCTURE FOR: RoomType
#

DROP TABLE IF EXISTS RoomType;

CREATE TABLE `RoomType` (
  `RoomTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `RoomTypeName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Occupancy` tinyint(4) DEFAULT NULL,
  `StartDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  PRIMARY KEY (`RoomTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomType VALUES
(1, 'Double', 2, '2015-01-01 00:00:00', NULL),
(2, 'Single', 1, '2015-01-01 00:00:00', NULL),
(3, 'Defunct', 4, '2015-01-01 00:00:00', '2015-01-02 00:00:00');



#
# TABLE STRUCTURE FOR: RoomAmenityType
#

DROP TABLE IF EXISTS RoomAmenityType;

CREATE TABLE `RoomAmenityType` (
  `RoomAmenityTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `RoomAmenityTypeName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`RoomAmenityTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomAmenityType VALUES 
(1, 'appliance'),
(2, 'miscellaneous');





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

INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (1, '200', '2015-01-01', '2018-01-01');
INSERT INTO RoomRateDateRange (`RoomRateDateRangeID`, `Price`, `StartDate`, `EndDate`) VALUES (2, '150', '2015-01-01', '2018-01-01');
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




#
# TABLE STRUCTURE FOR: RoomAmenity
#

DROP TABLE IF EXISTS RoomAmenity;

CREATE TABLE `RoomAmenity` (
  `RoomAmenityID` int(11) NOT NULL AUTO_INCREMENT,
  `StartDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  `RoomAmenityName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  #`Quantity` int(11) NOT NULL,
  `RoomAmenityTypeID` int(11) NOT NULL,
  PRIMARY KEY (`RoomAmenityID`),
  KEY `fk_roomamenity_roomamenitytype` (`RoomAmenityTypeID`),
  CONSTRAINT `fk_roomamenity_roomamenitytype` FOREIGN KEY (`RoomAmenityTypeID`) REFERENCES `RoomAmenityType` (`RoomAmenityTypeID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO RoomAmenity VALUES 
(1, '2015-01-01 00:00:00', NULL, 'refrigerator', 1),
(2, '2015-01-01 00:00:00', NULL, 'television', 1),
(3, '2015-01-01 00:00:00', NULL, 'lock box', 2);




#good
create table if not exists Branch(
BranchID int not null auto_increment, 
TaxRateID int not null,
AddressID int not null,
primary key(BranchID),
constraint fk_Branch_TaxRate Foreign Key(TaxRateID) REFERENCES TaxRate(TaxRateID) on delete no action, #good
constraint fk_Branch_Address Foreign Key(AddressID) REFERENCES Address(AddressID) on delete no action #good
); 

INSERT INTO Branch VALUES 
(1, 1, 1),
(2, 2, 2);


#good
create table if not exists Person(
PersonID int not null auto_increment, 
FirstName varchar(30),
LastName varchar(30), 
PhoneNumber varchar(20),
Birthday DATE, 
Email varchar(30),
AddressID int,
BranchID int, 
primary key(PersonID), 
constraint fk_person_address Foreign Key(AddressID) REFERENCES Address(AddressID) on delete no action, #good
constraint fk_person_Branch Foreign Key(BranchID) REFERENCES Branch(BranchID) on delete no action #good
);

INSERT INTO Person (`PersonID`, `FirstName`, `LastName`, `PhoneNumber`, `Birthday`, `Email`, `AddressID`, `BranchID`) VALUES (1, 'John', 'Smith', '5551234', '1980-01-01', 'bob@dole.com', NULL, NULL);
INSERT INTO Person (`PersonID`, `FirstName`, `LastName`, `PhoneNumber`, `Birthday`, `Email`, `AddressID`, `BranchID`) VALUES (2, 'Jane', 'Smith', '5551233', '1980-01-02', 'jane@dole.com', NULL, NULL);

#good
create table if not exists Customer(
CustomerID int not null auto_increment, 
RegistrationDate DATETIME, 
PersonID int not null, 
primary key(CustomerID),
constraint fk_customer_person Foreign Key(PersonID) REFERENCES Person(PersonID) on delete no action #good
); 

INSERT INTO Customer (`CustomerID`, `RegistrationDate`, `PersonID`) Values (1, '2015-01-01', 1);
INSERT INTO Customer (`CustomerID`, `RegistrationDate`, `PersonID`) Values (2, '2015-02-01', 2);

#good
create table if not exists Reservation(

ReservationID int not null auto_increment, 
StartDate DATETIME,
EndDate DATETIME, 
CustomerID int not null, 
primary key(ReservationID),
constraint fk_reservation_customer Foreign Key(CustomerID) REFERENCES Customer(CustomerID) on delete no action #good
); 

INSERT INTO Reservation (`ReservationID`, `StartDate`, `EndDate`, `CustomerID`) VALUES (1, '2016-01-01', '2016-01-04', 1);
INSERT INTO Reservation (`ReservationID`, `StartDate`, `EndDate`, `CustomerID`) VALUES (2, '2016-01-02', '2016-01-04', 2);


#good
create table if not exists Bill(
BillID int not null auto_increment, 
GrandTotal DECIMAL,
TotalTax DECIMAL,
BillingDate DATETIME,
ReservationID int not null,
CustomerID int not null,
primary key(BillID),
constraint fk_bill_reservation Foreign Key(ReservationID) REFERENCES Reservation(ReservationID) on delete no action, #good
constraint fk_bill_customer Foreign Key(CustomerID) REFERENCES Customer(CustomerID) on delete no action #good
); 

INSERT INTO Bill VALUES (1, 598.50, 25, '2016-01-04', 1, 1);
INSERT INTO Bill VALUES (2, 470, 20, '2016-01-04', 2, 2);

#good SwitchedPlaces
create table if not exists BillDetailType(
BillDetailTypeID int not null auto_increment,
BillDetailTypeName varchar(30),
primary key(BillDetailTypeID)
); 

INSERT INTO BillDetailType VALUES (1, 'Room Charge');
INSERT INTO BillDetailType VALUES (2, 'Room AddOn Charge');


#good
create table if not exists BillDetail(
#Please check this over again
BillDetailID int not null auto_increment,
BillDetailTypeID int not null,
BillDetailName varchar(40),
Charge DECIMAL,
OverrideID int null, 
BillID int not null,
primary key(BillDetailID), 
constraint fk_billdetail_override Foreign Key(OverrideID) REFERENCES Override(OverrideID) on delete no action, #good
constraint fk_billdetail_bill Foreign Key(BillID) REFERENCES Bill(BillID) on delete no action, #good
constraint fk_billdetail_type Foreign Key(BillDetailTypeID) REFERENCES BillDetailType(BillDetailTypeID) on delete no action #good
); 

INSERT INTO BillDetail VALUES (1, 1, 'Room Charge', 200, NULL, 1);
INSERT INTO BillDetail VALUES (2, 1, 'Room Charge', 200, NULL, 1);
INSERT INTO BillDetail VALUES (3, 2, 'Room AddOn Charge', 10, NULL, 1);
INSERT INTO BillDetail VALUES (4, 1, 'Room Charge', 200, NULL, 1);
INSERT INTO BillDetail VALUES (5, 2, 'Room AddOn Charge', 15, NULL, 1);
INSERT INTO BillDetail VALUES (6, 1, 'Room Charge', 200, NULL, 1);
INSERT INTO BillDetail VALUES (7, 1, 'Room Charge', 150, NULL, 2);
INSERT INTO BillDetail VALUES (8, 1, 'Room Charge', 150, NULL, 2);
INSERT INTO BillDetail VALUES (9, 1, 'Room Charge', 150, NULL, 2);


#good
create table if not exists SpecialEvent(
SpecialEventID int not null auto_increment,
StartDate DATETIME,
EndDate DATETIME, 
BranchID int not null, 
primary key(SpecialEventID), 
constraint fk_SpecialEvent_Branch Foreign Key(BranchID) REFERENCES Branch(BranchID) on delete no action
);

###2 constraints

#good
create table if not exists Room(
RoomID int not null auto_increment, 
RoomTypeID int, #not null,
StartDate DATETIME,
EndDate DATETIME,
RoomNumber varchar(30),
Floor char(3),
BranchID int, #not null,
primary key(RoomID), 
constraint fk_room_roomtype Foreign Key(RoomTypeID) REFERENCES RoomType(RoomTypeID) on delete no action, 
constraint fk_room_branch Foreign Key(BranchID) REFERENCES Branch(BranchID) on delete no action #good

); 

INSERT INTO Room VALUES 
(1, 2, '2015-01-01', NULL, '101', '1st', 1),
(2, 1, '2015-01-01', NULL, '102', '1st', 1),
(3, 2, '2015-01-01', NULL, '103', '1st', 2),
(4, 3, '2015-01-01', '2015-01-02', '104', '1st', 2),
(5, 1, '2015-01-02', NULL, '104', '1st', 2);

#good
create table if not exists RoomType_RoomAmenity(

 
RoomTypeID int not null, 
RoomAmenityID int not null,
Quantity int not null,
constraint fk_a Foreign Key(RoomTypeID) REFERENCES RoomType(RoomTypeID) on delete no action, 
constraint fk_b Foreign Key(RoomAmenityID) REFERENCES RoomAmenity(RoomAmenityID) on delete no action,
primary key(RoomTypeID, RoomAmenityID)
); 

INSERT INTO RoomType_RoomAmenity VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 2),
(2, 2, 1);





#good
create table if not exists Room_Reservation(
Room_ReservationID int not null auto_increment,
CheckInDate DATETIME,
CheckOutDate DATETIME,
Cancelled Bool not null, 
RoomID int not null,
ReservationID int not null, 
primary key(Room_ReservationID),
constraint fk_room_reservation_room Foreign Key(RoomID) REFERENCES Room(RoomID) on delete no action, #good
constraint fk_room_reservation_reservation Foreign Key(ReservationID) REFERENCES Reservation(ReservationID) on delete no action #good
); 

INSERT INTO Room_Reservation (`Room_ReservationID`, `CheckInDate`, `CheckOutDate`, `Cancelled`, `RoomID`, `ReservationID`) VALUES (1,'2016-01-01','2016-01-04', false, 1, 1);
INSERT INTO Room_Reservation (`Room_ReservationID`, `CheckInDate`, `CheckOutDate`, `Cancelled`, `RoomID`, `ReservationID`) VALUES (2,'2016-01-02','2016-01-04', false, 2, 2);
INSERT INTO Room_Reservation (`Room_ReservationID`, `CheckInDate`, `CheckOutDate`, `Cancelled`, `RoomID`, `ReservationID`) VALUES (3,'2016-01-01','2016-01-03', false, 3, 1);

#good
create table if not exists Guest(
GuestID int not null auto_increment,  
PersonID int not null, 
ReservationID int not null, 
primary key(GuestID), 
constraint fk_guest_reservation Foreign Key(ReservationID ) REFERENCES Reservation(ReservationID) on delete no action,
constraint fk_guest_person Foreign Key(PersonID) REFERENCES Person(PersonID) on delete no action
);
#good
create table if not exists Employee(
#check again
EmployeeID int not null auto_increment, 
PersonID int not null,
BranchID int null, 
primary key(EmployeeID),
constraint fk_employee_person Foreign Key(PersonID ) REFERENCES Person(PersonID) on delete no action,
constraint fk_employee_branch Foreign Key(BranchID) REFERENCES Branch(BranchID) on delete no action
);


#good
create table if not exists RoomRate(
#Special event null?
RoomRateID int not null auto_increment, 
Rate DECIMAL,
StartDate datetime,
EndDate Datetime,
Weekend bool,
RoomTypeID int not null,
RoomRateDateRangeID int not null,
SpecialEventID int null, 
SeasonID int not null,
BranchID int not null, 
primary key(RoomRateID),
constraint fk_roomrate_roomtype Foreign Key(RoomTypeID) REFERENCES RoomType(RoomTypeID) on delete no action, #good
constraint fk_roomrate_specialevent Foreign Key(SpecialEventID) REFERENCES SpecialEvent(SpecialEventID) on delete no action, #good
constraint fk_roomrate_season Foreign Key(SeasonID) REFERENCES Season(SeasonID) on delete no action, #good
constraint fk_roomrate_branch Foreign Key(BranchID ) REFERENCES Branch(BranchID ) on delete no action, #good
constraint fk_roomrate_roomratedaterange Foreign Key(RoomRateDateRangeID) REFERENCES RoomRateDateRange(RoomRateDateRangeID) on delete no action #good
); 

INSERT INTO RoomRate (`RoomRateID`, `Rate`, `StartDate`, `EndDate`, `Weekend`, `RoomTypeID`,
`RoomRateDateRangeID`, `SpecialEventID`, `SeasonID`, `BranchID`) 
VALUES (1, 200, '2015-01-01', NULL, true, 1, 1, NULL, 1, 1);
INSERT INTO RoomRate (`RoomRateID`, `Rate`, `StartDate`, `EndDate`, `Weekend`, `RoomTypeID`,
`RoomRateDateRangeID`, `SpecialEventID`, `SeasonID`, `BranchID`) 
VALUES (2, 150, '2015-01-01', NULL, true, 2, 1, NULL, 1, 1);

#good
create table if not exists PromotionCode(
PromotionCodeID int not null auto_increment,
PromotionCodeTypeID int not null,
PromotionCodeName varchar(30), 
PromotionCodeIsPercent BOOL, 
BranchID int not null,
Percent Decimal NULL,
DollarsOff Decimal Null,
StartDate Datetime not null,
EndDate datetime null,
primary key(PromotionCodeID),
constraint fk_PromotionCode_branch Foreign Key(BranchID) REFERENCES Branch(BranchID) on delete no action, #good
constraint fk_PromotionCode_PromotionCodeType Foreign Key(PromotionCodeTypeID) REFERENCES PromotionCodeType(PromotionCodeTypeID) on delete no action, #good
Check(Percent IS Null XOR DollarsOff Is Null)
);

INSERT INTO PromotionCode (`PromotionCodeID`, `PromotionCodeTypeID`, `PromotionCodeName`, `PromotionCodeIsPercent`, `BranchID`, `Percent`, 
`DollarsOff`, `StartDate`, `EndDate`) VALUES (1, 1, 'Dollar Days', false, 1, NULL, 20, '2017-01-01', NULL);
INSERT INTO PromotionCode (`PromotionCodeID`, `PromotionCodeTypeID`, `PromotionCodeName`, `PromotionCodeIsPercent`, `BranchID`, `Percent`, 
`DollarsOff`, `StartDate`, `EndDate`) VALUES (2, 2, 'Percent Days', true, 1, 5, Null, '2017-01-01', NULL);

#good
create table if not exists PromotionCode_Reservation(
PromotionCode_ReservationID int not null auto_increment,
PromotionCodeID int not null,
ReservationID int not null,
primary key(PromotionCode_ReservationID),
constraint fk_Reservation_promotioncode Foreign Key(PromotionCodeID) REFERENCES PromotionCode(PromotionCodeID) on delete no action, #good
constraint fk_Reservation_Reservation Foreign Key(ReservationID) REFERENCES Reservation(ReservationID) on delete no action #good
); 

INSERT INTO PromotionCode_Reservation (`PromotionCode_ReservationID`, `PromotionCodeID`, `ReservationID`) VALUES (1, 1, 1);
INSERT INTO PromotionCode_Reservation (`PromotionCode_ReservationID`, `PromotionCodeID`, `ReservationID`) VALUES (2, 2, 1);

#good
create table if not exists RoomCharge(
RoomChargeID int not null auto_increment,
Charge DECIMAL,
RoomRateID int not null,
BillDetailID int not null,
primary key(RoomChargeID),
constraint fk_RoomCharge_RoomRate Foreign Key(RoomRateID ) REFERENCES RoomRate(RoomRateID) on delete no action, 
constraint fk_RoomCharge_roomcharge Foreign Key(BillDetailID) REFERENCES BillDetail(BillDetailID) on delete no action
); 

INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (1, 200, 1, 1);
INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (2, 200, 1, 2);
INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (3, 200, 1, 4);
INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (4, 200, 1, 6);
INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (5, 150, 2, 7);
INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (6, 150, 2, 8);
INSERT INTO RoomCharge (`RoomChargeID`, `Charge`, `RoomRateID`, `BillDetailID`) VALUES (7, 150, 2, 9);

create table if not exists RoomAddOn(
RoomAddOnId int not null auto_increment,
RoomAddOnName varchar(30), 
RoomAddOnRateDateRangeID int not null,
RoomAddOnTypeID int not null,
Room_ReservationID int not null,
DateOrdered Date not null,
primary key(RoomAddOnId),
constraint fk_RoomAddOn_RoomAddOnRateDateRange Foreign Key(RoomAddOnRateDateRangeID) REFERENCES RoomAddOnRateDateRange(RoomAddOnRateDateRangeID) on delete no action,
constraint fk_RoomAddOn_RoomAddOnType Foreign Key(RoomAddOnTypeID) REFERENCES RoomAddOnType(RoomAddOnTypeID) on delete no action,
constraint fk_RoomAddOn_Room_Reservation Foreign Key(Room_ReservationID) REFERENCES Room_Reservation(Room_ReservationID) on delete no action
); 

INSERT INTO RoomAddOn (`RoomAddOnId`, `RoomAddOnName`, `RoomAddOnRateDateRangeID`, `RoomAddOnTypeID`, `Room_ReservationID`, `DateOrdered`) 
VALUES (1, 'Hamburger', 1, 1, 1, '2016-01-02');
INSERT INTO RoomAddOn (`RoomAddOnId`, `RoomAddOnName`, `RoomAddOnRateDateRangeID`, `RoomAddOnTypeID`, `Room_ReservationID`, `DateOrdered`) 
VALUES (2, 'Cheeseburger', 2, 1, 1, '2016-01-03');


create table if not exists RoomCharge_RoomAddOn(
RoomCharge_RoomAddOnID int not null auto_increment,
RoomChargeID int not null,
RoomAddOnID int not null,
primary key(RoomCharge_RoomAddOnID),
constraint fk_RoomCharge_RoomAddOn_roomcharge Foreign Key(RoomChargeID) REFERENCES RoomCharge(RoomChargeID ) on delete no action,
constraint fk_RoomCharge_RoomAddOn_roomaddon Foreign Key(RoomAddOnID) REFERENCES RoomAddOn(RoomAddOnID) on delete no action
); 

INSERT INTO RoomCharge_RoomAddOn (`RoomCharge_RoomAddOnID`, `RoomChargeID`, `RoomAddOnID`) VALUES (1, 1, 1);
INSERT INTO RoomCharge_RoomAddOn (`RoomCharge_RoomAddOnID`, `RoomChargeID`, `RoomAddOnID`) VALUES (2, 1, 2);