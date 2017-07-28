Ext.define('BudgetMS.store.proStore', {
	name : 'pro',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.project',
	proxy : {
		type : 'ajax',
		url : 'pro/findProByPage.do',
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
