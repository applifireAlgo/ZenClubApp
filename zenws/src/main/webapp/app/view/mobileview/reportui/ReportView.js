Ext.define('Zenws.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Zenws.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Zenws.view.mobileview.reportui.datachart.DataChartViewTab',
			'Zenws.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Zenws.view.mobileview.reportui.ReportViewController' ,
			'Zenws.view.mobileview.fw.DataPointPanel',
			'Zenws.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
