Ext.define('BudgetMS.view.inst.divide.editInstDivideWin', {
	extend : 'BudgetMS.view.inst.divide.baseInstDivideWin',
	alias : 'widget.instDivideEdit',
	title : '请示拆分修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateInstDivide',
			action : 'inst/updateInstDivide.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		var form=this.down('form');
		if(form)
			form.getForm().findField('instDivideId').readOnly = true;
	}
});