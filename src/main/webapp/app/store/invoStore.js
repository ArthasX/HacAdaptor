Ext.define('BudgetMS.store.invoStore', {
	name : 'invo',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.invo',
	proxy : {
		type : 'ajax',
		url : 'invo/getInvo.do',
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
