Ext.define('BudgetMS.store.deptStore', {
	name : 'dept',
	extend : 'Ext.data.Store',
	model : 'BudgetMS.model.dept',
	proxy : {
		type : 'ajax',
		url : 'dept/getAllDept.do',
		reader : {
			type : 'json'
		}
	},
	autoLoad : true
});
