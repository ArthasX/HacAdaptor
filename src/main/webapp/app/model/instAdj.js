var instAdjFields = [ {
	name:'instAdjId',
	type:'auto'
},{
	name:'instId',
	type:'auto'
},{
	name:'instDivideId',
	type:'auto'
},{
	name:'instAdjAmt',
	type:'auto'
},{
	name:'remark',
	type:'auto'
} ];

Ext.define("BudgetMS.model.instAdj", {
	extend : "Ext.data.Model",
	fields : instAdjFields
});
