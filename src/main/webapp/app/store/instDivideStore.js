Ext.define('BudgetMS.store.instDivideStore', {
	name : 'instDivide',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.instDivide',
	proxy : {
		type : 'ajax',
		url : 'inst/findInstDivideByPage.do',
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
