var instFields=[ {
	name : "instId",
	type : "auto"
}, {
	name : 'instTitle',
	type : 'auto'
}, {
	name : 'instContent',
	type : 'auto'
}, {
	name : 'instType',
	type : 'auto'
}, {
	name : 'instStatus',
	type : 'auto'
},{
	name : 'applyDept',
	type : 'auto'
}, {
	name : 'instAmt',
	type : 'auto',
}, {
	name : 'softAmt',
	type : 'auto'
}, {
	name : 'hardAmt',
	type : 'auto'
}, {
	name : 'applyUser',
	type : 'auto'
}, {
	name : 'applyUserName',
	type : 'auto'
}, {
	name : 'optDate',
	type : 'auto'
}, {
	name : 'optUser',
	type : 'auto'
}, {
	name : 'remark',
	type : 'auto'
} ];


Ext.define("BudgetMS.model.inst", {
	extend : "Ext.data.Model",
	fields : instFields
});
