Ext.define('BudgetMS.store.contAdjStore', {
	name : 'contAdj',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.contAdj',
	proxy : {
		type : 'ajax',
		url : 'cont/findContAdjByPage.do',
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
