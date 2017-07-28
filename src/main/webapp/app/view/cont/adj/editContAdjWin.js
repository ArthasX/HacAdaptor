Ext.define('BudgetMS.view.cont.adj.editContAdjWin', {
	extend : 'BudgetMS.view.cont.adj.baseContAdjWin',
	alias : 'widget.contAdjEdit',
	title : '合同分期付款修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateContAdj',
			action : 'cont/updateContAdj.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]

		this.callParent(arguments);
		this.down('form').getForm().findField('contAdjId').readOnly = true;
	}
});