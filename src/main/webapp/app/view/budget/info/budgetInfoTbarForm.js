Ext.define('BudgetMS.view.budget.info.budgetInfoTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.budgetInfoTbarForm',
	layout : {
		type : 'hbox',
		align : 'stretch'
	},
	border : false,
	items : [ {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'budgetTypeCombo',
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findBudgetInfo',
			action : 'budget/findBudgetInfoByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddBudgetInfo'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateBudgetInfo'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteBudgetInfo',
			action : 'budget/deleteBudgetInfo.do'
		} ]
	}, {
		flex : 1,border:false,
		items : [ {
			xtype : 'textfield',
			name : 'year',
			fieldLabel : '年份'
		} ]
	} ]
});