Ext.define('BudgetMS.view.pro.addProWin', {
	extend : 'BudgetMS.view.pro.baseProWin',
	alias : 'widget.proAdd',
	title : '项目新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertPro',
			action : 'pro/insertPro.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form=this.down('form'); 
//		if(form)
//			form.getForm().findField('proId').setValue(genProId());
	}
});
