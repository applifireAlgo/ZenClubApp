Ext.define('Zenws.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Zenws.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Zenws.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
