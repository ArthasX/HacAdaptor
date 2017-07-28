Ext.define("BudgetMS.model.contAdj", {
	extend : "Ext.data.Model",
	fields : [{
		name : 'contAdjId',
		type : 'auto'
	},  {
		name : "contPaymentId",
		type : "auto"
	}, {
		name : 'adjType',
		type : 'auto'
	}, {
		name : 'adjDate',
		type : 'auto'
	}, {
		name : 'adjAmt',
		type : 'auto'
	},{
		name : 'remark',
		type : 'auto',
	}]
});
