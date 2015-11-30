Ext.define('Zenws.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Zenws.view.reportui.querycriteria.QueryCriteriaView',
			'Zenws.view.reportui.datachart.DataChartViewTab',
			'Zenws.view.reportui.datachart.DataChartViewPanel',
			'Zenws.view.reportui.ReportViewController' ,
			'Zenws.view.fw.MainDataPointPanel',
			'Zenws.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
