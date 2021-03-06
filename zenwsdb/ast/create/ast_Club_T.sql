DROP TABLE IF EXISTS `ast_Club_T`;

CREATE TABLE `ast_Club_T` ( `clubId` VARCHAR(256) NOT NULL, `clubName` VARCHAR(256) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `cityId` VARCHAR(64) NOT NULL, `addressLine` VARCHAR(256) NOT NULL, `addressLine2` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`clubId`));

