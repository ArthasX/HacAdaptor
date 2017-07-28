Ext.define('BudgetMS.controller.contCtrl', {
	extend : 'BudgetMS.controller.baseController',
	stores : [ 'contStore','contPaymentStore' ,'contAdjStore'],
	views : [ 'cont.list', 'cont.editContWin', 'cont.addContWin', 'cont.contTbarForm',
	          'cont.cp.list', 'cont.cp.editContPaymentWin', 'cont.cp.addContPaymentWin', 'cont.cp.contPaymentTbarForm',
	          'cont.adj.list', 'cont.adj.editContAdjWin', 'cont.adj.addContAdjWin', 'cont.adj.contAdjTbarForm'],
	models : [ 'cont','contPayment' ,'contAdj'],
	init : function() {
		this.control({
			//.....
		});
	},
	
});
