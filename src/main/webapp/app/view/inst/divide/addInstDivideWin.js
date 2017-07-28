Ext.define('BudgetMS.view.inst.divide.addInstDivideWin', {
	extend : 'BudgetMS.view.inst.divide.baseInstDivideWin',
	alias : 'widget.instDivideAdd',
	title : '请示拆分新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertInstDivide',
			action : 'inst/insertInstDivide.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form=this.down('form'); 
		if(form)
			form.getForm().findField('instDivideId').disabled=true;
	}
});
