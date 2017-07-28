Ext.define('BudgetMS.controller.budgetCtrl', {
	extend : 'BudgetMS.controller.baseController',
	stores : [ 'budgetInfoStore', 'budgetTypeStore' ],
	views : [ 'budget.info.list', 'budget.info.editBudgetInfoWin',
			'budget.info.addBudgetInfoWin', 'budget.info.budgetInfoTbarForm',
			'budget.type.list', 'budget.type.editBudgetTypeWin',
			'budget.type.addBudgetTypeWin', 'budget.type.budgetTypeTbarForm' ],
	models : [ 'budgetInfo', 'budgetType' ],
	init : function() {
		this.control({
		// .....
		});
	},

});
