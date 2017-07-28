Ext.define("BudgetMS.model.cont", {
	extend : "Ext.data.Model",
	fields : [ {
		name : "contId",
		type : "auto"
	}, {
		name : 'instDivideId',
		type : 'auto'
	}, {
		name : 'contName',
		type : 'auto'
	}, {
		name : 'contCompany',
		type : 'auto'
	}, {
		name : 'contAmt',
		type : 'auto'
	}, {
		name : 'contType',
		type : 'auto'
	}, {
		name : 'signedDate',
		type : 'auto',
	}, {
		name : 'signedPerson',
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
	}, {
        name : 'tenderId',
        type : 'auto'
    } ]
});
