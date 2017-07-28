var projectFields = [ {
	name:'proId',
	type:'auto'
},{
	name:'proName',
	type:'auto'
},{
	name:'proType',
	type:'auto'
},{
	name:'budgetInfoId',
	type:'auto'
},{
	name:'remark',
	type:'auto'
} ];

Ext.define("BudgetMS.model.project", {
	extend : "Ext.data.Model",
	fields : projectFields
});
