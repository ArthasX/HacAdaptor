Ext.define('BudgetMS.view.invo.addInvoWin', {
	extend : 'BudgetMS.view.invo.baseInvoWin',
	alias : 'widget.invoAdd',
	title : '发票新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertInvo',
			action : 'invo/insertInvo.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		//this.down('form').getForm().findField('invoId').setValue(genInvoId());
	}
});
