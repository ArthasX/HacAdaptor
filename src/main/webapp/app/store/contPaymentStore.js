Ext.define('BudgetMS.store.contPaymentStore', {
	name : 'contPayment',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.contPayment',
	proxy : {
		type : 'ajax',
		url : 'cont/findContPaymentByPage.do',
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
