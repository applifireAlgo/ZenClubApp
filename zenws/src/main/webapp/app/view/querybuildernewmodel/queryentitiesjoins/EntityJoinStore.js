Ext.define('Zenws.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Zenws.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Zenws.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
