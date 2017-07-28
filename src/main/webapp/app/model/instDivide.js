var instDivideFields=[ {
	name:'instDivideId',
	type:'auto'
},{
	name:'instId',
	type:'auto'
} ,{
	name:'divideNo',
	type:'auto'
} ,{name:'divideStatus',
	type:'auto'
},{
	name:'divideAmt',
	type:'auto'
} ,{
	name:'proInfoId',
	type:'auto'
} ,{
	name:'remark',
	type:'auto'
} ];


Ext.define("BudgetMS.model.instDivide", {
	extend : "Ext.data.Model",
	fields : instDivideFields
});
