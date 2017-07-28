Ext.define('BudgetMS.view.inst.addInstWin', {
	extend : 'BudgetMS.view.inst.baseInstWin',
	alias : 'widget.instAdd',
	title : '请示新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertInst',
			action : 'inst/insertInst.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form=this.down('form'); 
		if(form)
			form.getForm().findField('instId').setValue(genInstId());
	}
});
