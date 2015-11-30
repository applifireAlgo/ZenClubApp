

ALTER TABLE `ast_ClubMembers_T` ADD CONSTRAINT FOREIGN KEY (`clubId`) REFERENCES `ast_Club_T`(`clubId`);



ALTER TABLE `ast_ClubMembers_T` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);

