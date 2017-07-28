Ext.define('BudgetMS.store.tenderStore', {
	name : 'pro',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.tender',
	proxy : {
		type : 'ajax',
		url : 'tender/findTenderByPage.do',
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
