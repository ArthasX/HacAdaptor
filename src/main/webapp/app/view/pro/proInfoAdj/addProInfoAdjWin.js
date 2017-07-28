Ext.define('BudgetMS.view.pro.proInfoAdj.addProInfoAdjWin', {
	extend : 'BudgetMS.view.pro.proInfoAdj.baseProInfoAdjWin',
	alias : 'widget.proInfoAdjAdd',
	title : '项目信息调整新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertProInfoAdj',
			action : 'pro/insertProInfoAdj.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form = this.down('form');
		if (form)
			form.getForm().findField('proInfoAdjId').disabled = true;
	}
});
