Ext.define('BudgetMS.store.instStore', {
	name : 'inst',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.inst',
	proxy : {
		type : 'ajax',
		url : 'inst/findInstByProperty.do',
		reader : {
			type : 'json',
			root : 'record',
			totalProperty : 'total'
		}
	},
	autoLoad : {
		start : 0,
		limit : PAGE_SIZE
	}
});

// fields:'',
