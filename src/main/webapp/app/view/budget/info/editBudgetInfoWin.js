Ext.define('BudgetMS.view.budget.info.editBudgetInfoWin', {
	extend : 'BudgetMS.view.budget.info.baseBudgetInfoWin',
	alias : 'widget.budgetInfoEdit',
	title : '预算信息修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateBudgetInfo',
			action : 'budget/updateBudgetInfo.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]

		this.callParent(arguments);
		this.down('form').getForm().findField('budgetInfoId').readOnly = true;
	}
});