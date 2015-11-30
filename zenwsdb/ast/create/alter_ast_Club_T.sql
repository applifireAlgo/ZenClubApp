

ALTER TABLE `ast_Club_T` ADD CONSTRAINT FOREIGN KEY (`cityId`) REFERENCES `ast_City_M`(`cityId`);



ALTER TABLE `ast_Club_T` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_Club_T` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);

