Ext.define('Zenws.zenws.web.com.zen.view.customers.AppCustomerTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AppCustomerTypeMainController",
     "restURL": "/AppCustomerType",
     "defaults": {
          "split": true
     },
     "requires": ["Zenws.zenws.shared.com.zen.model.customers.AppCustomerTypeModel", "Zenws.zenws.web.com.zen.controller.customers.AppCustomerTypeMainController", "Zenws.zenws.shared.com.zen.viewmodel.customers.AppCustomerTypeViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "AppCustomer Type",
               "name": "AppCustomerTypeTreeContainer",
               "itemId": "AppCustomerTypeTreeContainer",
               "restURL": "/AppCustomerType",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "AppCustomerTypeTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "customerType",
                         "itemId": "customerType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Customer Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Type",
                         "fieldId": "60E0BF8D-3A98-463E-B223-9A7B4EB39A50",
                         "minLength": "0",
                         "maxLength": "65535"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "AppCustomerTypeViewModel",
                    "xtype": "form",
                    "displayName": "AppCustomer Type",
                    "title": "AppCustomer Type",
                    "name": "AppCustomerType",
                    "itemId": "AppCustomerType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "appcustTypeId",
                         "itemId": "appcustTypeId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Appcustomer Type Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Appcustomer Type Id<font color='red'> *<\/font>",
                         "fieldId": "D6843EBE-B432-43E8-ACC1-0FAEBBFB1745",
                         "hidden": true,
                         "value": "",
                         "bindable": "appcustTypeId",
                         "bind": "{appcustTypeId}"
                    }, {
                         "name": "customerType",
                         "itemId": "customerType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Customer Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "60E0BF8D-3A98-463E-B223-9A7B4EB39A50",
                         "minLength": "0",
                         "maxLength": "65535",
                         "bindable": "customerType",
                         "bind": "{customerType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "defaults",
                         "itemId": "defaults",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Defaults",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Defaults",
                         "fieldId": "3116FEF2-F26A-4EFE-9652-BC7FDA694452",
                         "minValue": "0",
                         "maxValue": "1",
                         "bindable": "defaults",
                         "bind": "{defaults}",
                         "columnWidth": 0.5
                    }, {
                         "name": "sequenceId",
                         "itemId": "sequenceId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sequence",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sequence",
                         "fieldId": "695AF776-1C9B-465E-8EE9-18D1A66762D1",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "sequenceId",
                         "bind": "{sequenceId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "D48962C1-5B82-401F-988E-E7F7C930F9CA",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 507,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 507,
                              "customId": 761
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 507,
                              "customId": 762,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 507,
                              "customId": 763,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "AppCustomer Type",
                    "title": "Details Grid",
                    "name": "AppCustomerTypeGrid",
                    "itemId": "AppCustomerTypeGrid",
                    "restURL": "/AppCustomerType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Appcustomer Type Id",
                         "dataIndex": "appcustTypeId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Customer Type",
                         "dataIndex": "customerType",
                         "flex": 1
                    }, {
                         "header": "Defaults",
                         "dataIndex": "defaults",
                         "flex": 1
                    }, {
                         "header": "Sequence",
                         "dataIndex": "sequenceId",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "AppCustomerTypeViewModel",
               "xtype": "form",
               "displayName": "AppCustomer Type",
               "title": "AppCustomer Type",
               "name": "AppCustomerType",
               "itemId": "AppCustomerType",
               "bodyPadding": 10,
               "items": [{
                    "name": "appcustTypeId",
                    "itemId": "appcustTypeId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Appcustomer Type Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Appcustomer Type Id<font color='red'> *<\/font>",
                    "fieldId": "D6843EBE-B432-43E8-ACC1-0FAEBBFB1745",
                    "hidden": true,
                    "value": "",
                    "bindable": "appcustTypeId",
                    "bind": "{appcustTypeId}"
               }, {
                    "name": "customerType",
                    "itemId": "customerType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Customer Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "60E0BF8D-3A98-463E-B223-9A7B4EB39A50",
                    "minLength": "0",
                    "maxLength": "65535",
                    "bindable": "customerType",
                    "bind": "{customerType}",
                    "columnWidth": 0.5
               }, {
                    "name": "defaults",
                    "itemId": "defaults",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Defaults",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Defaults",
                    "fieldId": "3116FEF2-F26A-4EFE-9652-BC7FDA694452",
                    "minValue": "0",
                    "maxValue": "1",
                    "bindable": "defaults",
                    "bind": "{defaults}",
                    "columnWidth": 0.5
               }, {
                    "name": "sequenceId",
                    "itemId": "sequenceId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Sequence",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Sequence",
                    "fieldId": "695AF776-1C9B-465E-8EE9-18D1A66762D1",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "sequenceId",
                    "bind": "{sequenceId}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "D48962C1-5B82-401F-988E-E7F7C930F9CA",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 507,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 507,
                         "customId": 761
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 507,
                         "customId": 762,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 507,
                         "customId": 763,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});