Ext.define('BudgetMS.view.budget.type.budgetTypeTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.budgetTypeTbarForm',
	layout : {
		type : 'hbox',
		align : 'stretch'
	},
	border : false,
	items : [ {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'budgetName',
			fieldLabel : '预算名称'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findBudgetType',
			action : 'budget/findBudgetTypeByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddBudgetType'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateBudgetType'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteBudgetType',
			action : 'budget/deleteBudgetType.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'budgetType',
			fieldLabel : '预算类型'
		} ]
	} ]
});