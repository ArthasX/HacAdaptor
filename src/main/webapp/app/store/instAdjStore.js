Ext.define('BudgetMS.store.instAdjStore', {
	name : 'instAdj',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.instAdj',
	proxy : {
		type : 'ajax',
		url : 'inst/findInstAdjByPage.do',
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
