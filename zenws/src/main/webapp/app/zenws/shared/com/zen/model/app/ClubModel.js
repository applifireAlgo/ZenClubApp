Ext.define('Zenws.zenws.shared.com.zen.model.app.ClubModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "clubId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "clubName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "countryid",
          "reference": "Country",
          "defaultValue": ""
     }, {
          "name": "stateid",
          "reference": "State",
          "defaultValue": ""
     }, {
          "name": "cityid",
          "reference": "City",
          "defaultValue": ""
     }, {
          "name": "addressLine",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressLine2",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});