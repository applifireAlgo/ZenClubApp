/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Zenws',

    extend: 'Zenws.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Zenws.view.mainleftmenutree.MainPanel':'Zenws.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Zenws.view.login.LoginPage':'Zenws.view.mobileview.login.LoginPage',//'Zenws.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Zenws.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
