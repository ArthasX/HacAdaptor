Ext.define('BudgetMS.view.cont.addContWin', {
	extend : 'BudgetMS.view.cont.baseContWin',
	alias : 'widget.contAdd',
	title : '合同新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertCont',
			action : 'cont/insertCont.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		this.down('form').getForm().findField('contId').setValue(genContId());
	}
});
