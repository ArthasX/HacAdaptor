Ext.define('BudgetMS.view.cont.editContWin', {
	extend : 'BudgetMS.view.cont.baseContWin',
	alias : 'widget.contEdit',
	title : '合同修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateCont',
			action : 'cont/updateCont.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]

		this.callParent(arguments);
		this.down('form').getForm().findField('contId').readOnly = true;
	}
});