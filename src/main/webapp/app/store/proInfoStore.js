Ext.define('BudgetMS.store.proInfoStore', {
	name : 'proInfo',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.proInfo',
	proxy : {
		type : 'ajax',
		url : 'pro/findProInfoByPage.do',
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
