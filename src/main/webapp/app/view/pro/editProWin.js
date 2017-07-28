Ext.define('BudgetMS.view.pro.editProWin', {
	extend : 'BudgetMS.view.pro.baseProWin',
	alias : 'widget.proEdit',
	title : '项目修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updatePro',
			action : 'pro/updatePro.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		var form=this.down('form');
		if(form)
			form.getForm().findField('proId').readOnly = true;
	}
});