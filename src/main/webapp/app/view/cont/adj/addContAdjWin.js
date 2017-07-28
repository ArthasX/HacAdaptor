Ext.define('BudgetMS.view.cont.adj.addContAdjWin', {
	extend : 'BudgetMS.view.cont.adj.baseContAdjWin',
	alias : 'widget.contAdjAdd',
	title : '合同分期付款新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertContAdj',
			action : 'cont/insertContAdj.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		this.down('form').getForm().findField('contAdjId').disabled=true;
	}
});
