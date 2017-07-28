Ext.define('BudgetMS.view.cont.cp.editContPaymentWin', {
	extend : 'BudgetMS.view.cont.cp.baseContPaymentWin',
	alias : 'widget.contPaymentEdit',
	title : '合同分期付款修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateContPayment',
			action : 'cont/updateContPayment.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]

		this.callParent(arguments);
		this.down('form').getForm().findField('contPaymentId').readOnly = true;
	}
});