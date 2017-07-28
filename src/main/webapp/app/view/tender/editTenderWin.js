Ext.define('BudgetMS.view.tender.editTenderWin', {
	extend : 'BudgetMS.view.tender.baseTenderWin',
	alias : 'widget.tenderEdit',
	title : '招标修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateTender',
			action : 'tender/updateTender.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		this.down('form').getForm().findField('tenderId').readOnly = true;
	}
});