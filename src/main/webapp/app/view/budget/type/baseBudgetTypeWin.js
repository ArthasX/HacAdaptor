Ext.define('BudgetMS.view.budget.type.baseBudgetTypeWin', {
	extend : 'Ext.window.Window',
	// layout : {
	// type : 'hbox',
	// align : 'stretch'
	// },
	// autoShow : true,
	// height : 500,
	// width : 800,
	initComponent : function() {
		this.items = budgetTypeFormItems;
		this.callParent(arguments);
		// this.down('form').getForm().findField('contId').setValue(genBudgetTypeId());
	}
});

var budgetTypeFormItems = [ {
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'budgetTypeId',
		fieldLabel : '预算类型编号',
	}, {
		xtype : 'textfield',
		name : 'budgetType',
		fieldLabel : '预算类型',
	}, {
		xtype : 'textfield',
		name : 'budgetName',
		fieldLabel : '预算名称',
	} , {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注',
	} ]
} ];
