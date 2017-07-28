Ext.define('BudgetMS.view.budget.info.baseBudgetInfoWin', {
	extend : 'Ext.window.Window',
	// layout : {
	// type : 'hbox',
	// align : 'stretch'
	// },
	// autoShow : true,
	// height : 500,
	// width : 800,
	initComponent : function() {
		this.items = budgetInfoFormItems;
		this.callParent(arguments);
		// this.down('form').getForm().findField('contId').setValue(genBudgetTypeId());
	}
});

var budgetInfoFormItems = [ {
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'budgetInfoId',
		fieldLabel : '预算信息编号',
	}, {
		xtype : 'budgetTypeCombo',
	}, {
		xtype : 'textfield',
		name : 'budgetAmt',
		fieldLabel : '预算金额',
		vtype : 'money'
	}, {
		xtype : 'textfield',
		name : 'year',
		fieldLabel : '年份',
	}, {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注',
	} ]
} ];
