Ext.define('Zenws.zenws.web.com.zen.view.app.AddClubMembers', {
     "xtype": "addClubMembers",
     "items": [{
          "xtype": "combo",
          "name": "clubId",
          "margin": 5,
          "bindable": "clubId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Club Name",
          "displayField": "clubName",
          "valueField": "clubId",
          "text": "Club Name",
          "fieldName": "clubId",
          "displayName": "Club Name",
          "widget": "combo",
          "min": "0",
          "max": "256",
          "isField": true,
          "itemId": "fkcdadi",
          "store": {
               "model": "Zenws.zenws.shared.com.zen.model.app.ClubModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "clubName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Club/findAll",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          },
          "bind": "{clubId}"
     }, {
          "xtype": "combo",
          "name": "contactId",
          "margin": 5,
          "bindable": "contactId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Contact",
          "displayField": "firstName",
          "valueField": "contactId",
          "text": "Contact",
          "fieldName": "contactId",
          "displayName": "Contact",
          "widget": "combo",
          "min": "0",
          "max": "64",
          "isField": true,
          "itemId": "fegapci",
          "store": {
               "model": "Zenws.zenws.shared.com.zen.model.contacts.CoreContactsModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "firstName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/CoreContacts/findAll",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          },
          "bind": "{contactId}"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "kbjcehi",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "button",
               "text": "Save",
               "isSubmitBtn": true,
               "margin": 5,
               "name": "save",
               "itemId": "ikgmbii",
               "listeners": {
                    "click": "onsaveclick"
               }
          }],
          "itemId": "oabegdi",
          "dockedItems": []
     }],
     "requires": ["Zenws.zenws.shared.com.zen.model.app.ClubModel", "Zenws.zenws.shared.com.zen.model.contacts.CoreContactsModel", "Zenws.zenws.web.com.zen.controller.app.AddClubMembersController", "Zenws.zenws.shared.com.zen.viewmodel.app.AddClubMembersViewModel", "Zenws.zenws.shared.com.zen.model.app.AddClubMembersModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "AddClubMembersViewModel",
     "controller": "AddClubMembersController"
});