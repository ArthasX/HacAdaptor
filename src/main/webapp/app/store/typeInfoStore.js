Ext.define('BudgetMS.store.typeInfoStore', {
	name : 'typeInfo',
	extend : 'BudgetMS.store.baseStore',
	model : 'BudgetMS.model.typeInfo',
	proxy : {
		type : 'ajax',
		url : 'typeInfo/getAllTypeInfo.do',
		reader : {
			type : 'json'
		}
	},
	//autoLoad : true,
	filterOnLoad : true,

});
