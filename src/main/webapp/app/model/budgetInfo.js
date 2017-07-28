Ext.define("BudgetMS.model.budgetInfo", {
	extend : "Ext.data.Model",
	fields : [ {
		name : "budgetInfoId",
		type : "auto"
	}, {
		name : 'budgetType',
		type : 'auto'
	}, {
		name : 'budgetAmt',
		type : 'auto'
	}, {
		name : 'year',
		type : 'auto'
	}, {
		name : 'remark',
		type : 'auto',
	} ]
});
