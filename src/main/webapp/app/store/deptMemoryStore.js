Ext.define('BudgetMS.store.deptMemoryStore', {
	name : 'dept',
	extend : 'Ext.data.Store',
	model : 'BudgetMS.model.dept',
	proxy : {
		type : 'memory',
		reader : {
			type : 'json'
		}
	},
	// autoLoad : true,
	listeners : {
		'load' : function(store) {
			debugger;

		},
		'beforeload' : function() {
			debugger;
		}
	},

});
