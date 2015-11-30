Ext.define('Zenws.zenws.web.com.zen.controller.app.AddClubMembersController', {
     extend: 'Zenws.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.AddClubMembersController',
     onsaveclick: function(me, e, eOpts) {
          var jsonData = this.getData(this.view);
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/ClubMembers/',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
                    scope.sender.reset();
               },
               failure: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               }
          }, scope);
     }
});