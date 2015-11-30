Ext.define('Zenws.view.databrowsercalendar.DBCalendar', {
	extend : 'Zenws.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Zenws.view.databrowsercalendar.DBCalendarController',
	             'Zenws.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
