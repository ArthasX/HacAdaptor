Ext.define('BudgetMS.view.pro.proInfoAdj.editProInfoAdjWin', {
	extend : 'BudgetMS.view.pro.proInfoAdj.baseProInfoAdjWin',
	alias : 'widget.proInfoAdjEdit',
	title : '项目信息调整修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateProInfoAdj',
			action : 'pro/updateProInfoAdj.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form = this.down('form');
		if (form)
			form.getForm().findField('proInfoAdjId').readOnly = true;
	}
});