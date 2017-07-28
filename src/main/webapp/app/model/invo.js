Ext.define("BudgetMS.model.invo", {
	extend : "Ext.data.Model",
	fields : [ {
		name : "invoId",
		type : "auto"
	}, {
		name : 'contPaymentId',
		type : 'auto'
	}, {
		name : 'invoAmt',
		type : 'auto'
	}, {
		name : 'invoCompany',
		type : 'auto'
	}, {
		name : 'transDate',
		type : 'auto'
	}, {
		name : 'transfered',
		type : 'auto',
	}, {
		name : 'optDate',
		type : 'auto'
	}, {
		name : 'optUser',
		type : 'auto'
	}, {
		name : 'remark',
		type : 'auto'
	} ]
});