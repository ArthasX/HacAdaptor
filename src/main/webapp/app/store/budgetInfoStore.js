Ext.define('BudgetMS.store.budgetInfoStore', {
	name : 'budgetInfo',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.budgetInfo',
	proxy : {
		type : 'ajax',
		url : 'budget/findBudgetInfoByPage.do',
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
