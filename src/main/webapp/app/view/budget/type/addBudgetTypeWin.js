Ext.define('BudgetMS.view.budget.type.addBudgetTypeWin', {
	extend : 'BudgetMS.view.budget.type.baseBudgetTypeWin',
	alias : 'widget.budgetTypeAdd',
	title : '预算类型新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertBudgetType',
			action : 'budget/insertBudgetType.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		this.down('form').getForm().findField('budgetTypeId').disabled = true;
	}
});
