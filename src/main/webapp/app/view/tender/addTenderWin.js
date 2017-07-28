Ext.define('BudgetMS.view.tender.addTenderWin', {
	extend : 'BudgetMS.view.tender.baseTenderWin',
	alias : 'widget.tenderAdd',
	title : '招标新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertTender',
			action : 'tender/insertTender.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		// this.down('form').getForm().findField('tenderId').disabled=true;
        this.down('form').getForm().findField('tenderId').setValue(genTenderId());
	}
});
