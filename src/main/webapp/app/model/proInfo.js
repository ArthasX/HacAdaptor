var proInfoFields = [ {
	name:'proInfoId',
	type:'auto'
},{
	name:'proAmt',
	type:'auto'
},{
	name:'proStatus',
	type:'auto'
},{
	name:'proId',
	type:'auto'
},{
	name:'year',
	type:'auto'
},{
	name:'remark',
	type:'auto'
} ];

Ext.define("BudgetMS.model.proInfo", {
	extend : "Ext.data.Model",
	fields : proInfoFields
});
