DROP DATABASE IF EXISTS `BlogDatabaseTest`;
CREATE DATABASE IF NOT EXISTS `BlogDatabaseTest`;
USE `BlogDatabaseTest`;

CREATE TABLE IF NOT EXISTS `Categories`	
(
	`categoryId` INT NOT NULL AUTO_INCREMENT,
    `categoryName` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`categoryId`)
);

CREATE TABLE IF NOT EXISTS `Hashtags`
(
	`hashtagId` INT NOT NULL AUTO_INCREMENT,
    `tagName` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`hashtagId`)
);

CREATE TABLE IF NOT EXISTS `Images` 
(
	`imageId` INT NOT NULL AUTO_INCREMENT,
	`image` BLOB,
	PRIMARY KEY (`imageId`)
);

CREATE TABLE IF NOT EXISTS `Posts`
(
	`postId` INT NOT NULL AUTO_INCREMENT,
	`userId` INT NOT NULL,
    `startDate` DATETIME NOT NULL,
	`endDate` DATETIME NULL,
    `createDate` DATETIME NOT NULL,
    `approvalDate` DATETIME NULL,
	`approval` BOOL NULL,
    `postTitle` TEXT NOT NULL,
    `postContent` TEXT NOT NULL,
    `categoryId` INT NOT NULL,    
    PRIMARY KEY (`postId`)
);

CREATE TABLE IF NOT EXISTS `PostsHashtags`
(
	`postHashtagId` INT NOT NULL AUTO_INCREMENT,
    `postId` INT NOT NULL,
    `hashtagId` INT NOT NULL,
    PRIMARY KEY (`postHashtagId`)
);

CREATE TABLE IF NOT EXISTS `Roles`
(
	`roleId` INT NOT NULL AUTO_INCREMENT,
    `roleName` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`roleId`)
);

CREATE TABLE IF NOT EXISTS `StaticPages`
(
	`staticPageId` INT NOT NULL AUTO_INCREMENT,
    `staticPageTitle` VARCHAR(30) NOT NULL,
    `staticPageContent` TEXT NOT NULL,
    PRIMARY KEY (`staticPageId`)
);

CREATE TABLE IF NOT EXISTS `Users`
(
	`userId` INT NOT NULL AUTO_INCREMENT,
    `userName` VARCHAR(30) NOT NULL,
    `userPassword` VARCHAR(30) NOT NULL,
    `userEmail` VARCHAR(50) NOT NULL,
    `roleId` INT NOT NULL,
    PRIMARY KEY (`userId`)
);

CREATE TABLE IF NOT EXISTS Images 

(
	`imageId` INT NOT NULL AUTO_INCREMENT,
	`image` longblob not null,
	`imageDescription` varchar(200), 
	PRIMARY KEY (`imageId`)

);


-- Posts Foreign Keys:
ALTER TABLE `Posts` ADD CONSTRAINT `fk_posts_user` FOREIGN KEY (`userId`) REFERENCES `Users` (`userId`) ON DELETE NO ACTION;
ALTER TABLE `Posts` ADD CONSTRAINT `fk_posts_category` FOREIGN KEY (`categoryId`) REFERENCES `Categories` (`categoryId`) ON DELETE NO ACTION;

-- PostsHashtags Foreign Keys:
ALTER TABLE `PostsHashtags` ADD CONSTRAINT `fk_postshashtags_post` FOREIGN KEY (`postId`) REFERENCES `Posts` (`postId`) ON DELETE NO ACTION;
ALTER TABLE `PostsHashtags` ADD CONSTRAINT `fk_postshashtags_hashtag` FOREIGN KEY (`hashtagId`) REFERENCES `Hashtags` (`hashtagId`) ON DELETE NO ACTION;

-- Users Foreign Keys:
ALTER TABLE `Users` ADD CONSTRAINT `fk_users_role` FOREIGN KEY (`roleId`) REFERENCES `Roles` (`roleId`) ON DELETE NO ACTION;












	
