Ext.define('Zenws.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Zenws.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Zenws.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
