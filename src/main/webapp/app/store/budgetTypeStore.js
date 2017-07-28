Ext.define('BudgetMS.store.budgetTypeStore', {
	name : 'budgetType',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.budgetType',
	proxy : {
		type : 'ajax',
		url : 'budget/findBudgetTypeByPage.do',
		reader : {
			type : 'json',
			root:'record',
			totalProperty:'total'
		}
	},
	autoLoad : {
		start : 0,
		limit : 99
	},
	pageSize: 99
});

// fields:'',
