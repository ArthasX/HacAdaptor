Ext.define('BudgetMS.controller.tenderCtrl', {
	
	extend : 'BudgetMS.controller.baseController',
	stores : [ 'tenderStore' ],
	views : [ 'tender.list', 'tender.editTenderWin', 'tender.addTenderWin', 'tender.tenderTbarForm' ],
	models : [ 'tender' ],
	init : function() {
		this.control({
//..
		});
	},
	
});
