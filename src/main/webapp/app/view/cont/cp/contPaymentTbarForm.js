Ext.define('BudgetMS.view.cont.cp.contPaymentTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.contPaymentTbarForm',
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
			name : 'contId',
			fieldLabel : '合同编号'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findContPayment',
			action : 'cont/findContPaymentByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddContPayment'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateContPayment'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteContPayment',
			action : 'cont/deleteContPayment.do'
		} ]
	} ]
});