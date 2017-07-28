var proInfoAdjFields = [ {
	name : 'proInfoAdjId',
	type : 'auto'
}, {
	name : 'proInfoId',
	type : 'auto'
}, {
	name : 'adjType',
	type : 'auto'
}, {
	name : 'adjAmt',
	type : 'auto'
}, {
	name : 'remark',
	type : 'auto'
} ];

Ext.define("BudgetMS.model.proInfoAdj", {
	extend : "Ext.data.Model",
	fields : proInfoAdjFields
});
