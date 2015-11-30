Ext.define('Zenws.view.mobileview.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Zenws.view.mobileview.reportui.datachart.DataChartTController',
			'Zenws.view.mobileview.reportui.datachart.datagrid.DataGridView','Zenws.view.mobileview.reportui.datachart.chart.ChartTabView','Zenws.view.mobileview.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	initComponent : function() {
		/*this.items */

		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});