Ext.define('BudgetMS.view.budget.type.editBudgetTypeWin', {
	extend : 'BudgetMS.view.budget.type.baseBudgetTypeWin',
	alias : 'widget.budgetTypeEdit',
	title : '预算类型修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateBudgetType',
			action : 'budget/updateBudgetType.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]

		this.callParent(arguments);
		this.down('form').getForm().findField('budgetTypeId').readOnly = true;
	}
});