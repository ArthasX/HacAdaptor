Ext.define('BudgetMS.view.cont.cp.addContPaymentWin', {
	extend : 'BudgetMS.view.cont.cp.baseContPaymentWin',
	alias : 'widget.contPaymentAdd',
	title : '合同分期付款新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertContPayment',
			action : 'cont/insertContPayment.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		this.down('form').getForm().findField('contPaymentId').disabled=true;
	}
});
