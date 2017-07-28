Ext.define("BudgetMS.model.tender", {
	extend : "Ext.data.Model",
	fields : [ {
		name : "tenderId",
		type : "auto"
	} ,{
		name : 'instDivideId',
		type : 'auto'
	} ,{
		name : 'apprId',
		type : 'auto'
	} ,{
		name : 'tenderAmt',
		type : 'auto'
	} ,{
		name : 'company',
		type : 'auto'
	} ,{
		name : 'remark',
		type : 'auto'
	},{
		name:'tenderName',
		type:'auto'
	},{
		name:'type',
		type:'auto'
	},{
		name:'startDate',
		type:'auto'
	},{
		name:'endDate',
		type:'auto'
	},{
		name:'openDate',
		type:'auto'
	},{
		name:'negoDate',
		type:'auto'
	},{
		name:'approvalDate',
		type:'auto'
	},{
		name:'finalDate',
		type:'auto'
	},{
		name:'status',
		type:'auto'
	}]
});