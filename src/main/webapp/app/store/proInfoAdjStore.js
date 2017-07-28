Ext.define('BudgetMS.store.proInfoAdjStore', {
	name : 'proInfoAdj',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.proInfoAdj',
	proxy : {
		type : 'ajax',
		url : 'pro/findProInfoAdjByPage.do',
		reader : {
			type : 'json',
			root:'record',
			totalProInfoAdjperty:'total'
		}
	},
	autoLoad : {
		start : 0,
		limit : PAGE_SIZE
	}
});

// fields:'',
