Ext.define('BudgetMS.controller.invoCtrl', {
	
	extend : 'BudgetMS.controller.baseController',
	stores : [ 'invoStore' ],
	views : [ 'invo.list', 'invo.editInvoWin', 'invo.addInvoWin', 'invo.invoTbarForm' ],
	models : [ 'invo' ],
	init : function() {
		this.control({
//..
		});
	},
	
});
