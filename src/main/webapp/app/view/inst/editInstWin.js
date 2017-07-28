Ext.define('BudgetMS.view.inst.editInstWin', {
	extend : 'BudgetMS.view.inst.baseInstWin',
	alias : 'widget.instEdit',
	title : '请示修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateInst',
			action : 'inst/updateInst.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		var form=this.down('form');
		if(form)
			form.getForm().findField('instId').readOnly = true;
	}
});