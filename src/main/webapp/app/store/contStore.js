Ext.define('BudgetMS.store.contStore', {
	name : 'cont',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.cont',
	proxy : {
		type : 'ajax',
		url : 'cont/findContByProperty.do',
		reader : {
			type : 'json',
			root:'record',
			totalProperty:'total'
		}
	},
	autoLoad : {
		start : 0,
		limit : PAGE_SIZE
	}
});

// fields:'',
