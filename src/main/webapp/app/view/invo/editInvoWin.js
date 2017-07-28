Ext.define('BudgetMS.view.invo.editInvoWin', {
	extend : 'BudgetMS.view.invo.baseInvoWin',
	alias : 'widget.invoEdit',
	title : '发票修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateInvo',
			action : 'invo/updateInvo.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		this.down('form').getForm().findField('invoId').readOnly = true;
	}
});