Use SuperSightings_Test;

#1 getAllSuperPersonsBySightingLocation

SELECT `superperson`.`name` as `Super Person`, `location`.`name` as `Location`
FROM `superperson`
inner join `superperson_sighting` on `superperson`.`SuperPersonId` = `superperson_sighting`.`SuperPersonId`
inner join `sighting` on `superperson_sighting`.`SightingId` = `sighting`.`SightingId`
Inner join `location` on `sighting`.`LocationId` = `location`.`LocationId`
where `location`.`LocationId` = 1;

#2 getAllSuperPersonsByOrganization

SELECT `superperson`.`name` as `Super Person`, `organization`.`name` as `Organization`
from `superperson`
inner join `superperson_organization` 
on `superperson`.`superpersonId` = `superperson_organization`.`superpersonId`
inner join `organization` 
on `superperson_organization`.`OrganizationId` = `organization`.`OrganizationId`
where `organization`.`organizationId` = 1;

#3 getAllSuperPersonsBySighting

SELECT `superperson`.`name` as `Person Name`, `sighting`.`sightingid`, `sighting`.`date` 
from `superperson`
inner join `superperson_sighting` 
on `superperson`.`SuperPersonId` = `superperson_sighting`.`SuperPersonId`
inner join `sighting` 
on `superperson_sighting`.`SightingId` = `sighting`.`SightingId`
where `sighting`.`sightingId` = 1;

#4 getAllSightingsByDate

SELECT `sighting`.`sightingid`, `sighting`.`Description`, `sighting`.`date` 
FROM `sighting`
WHERE `date`=20170515;


#5 getAllLocationsBySuperPerson

SELECT `superperson`.`Name` AS `Super Person`, `location`.`Name` AS `Location`
FROM `location`
INNER JOIN `sighting`
ON `location`.`LocationId` = `sighting`.`LocationId`
INNER JOIN `superperson_sighting`
ON `superperson_sighting`.`SightingId` = `sighting`.`SightingId`
INNER JOIN `superperson`
ON `superperson_sighting`.`SuperpersonId` = `superperson`.`SuperPersonId`
WHERE `superperson`.`SuperPersonId` = 5;


#6 getAllOrganizationsBySuperPerson

SELECT `organization`.`name` , `superperson`.`name` FROM `organization`
inner join `superperson_organization` on `organization`.`organizationId` = `superperson_organization`.`organizationId`
inner join `superperson` on `superperson_organization`.`superpersonId` = `superperson`.`superpersonId`
where `superperson`.`superpersonid` = 1;