Ext.define("BudgetMS.model.contPayment", {
	extend : "Ext.data.Model",
	fields : [ {
		name : "contPaymentId",
		type : "auto"
	}, {
		name : 'contId',
		type : 'auto'
	}, {
		name : 'period',
		type : 'auto'
	}, {
		name : 'payAmt',
		type : 'auto'
	}, {
		name : 'expectPayDate',
		type : 'auto'
	}, {
		name : 'isPaid',
		type : 'auto'
	}, {
		name : 'remark',
		type : 'auto',
	}]
});
