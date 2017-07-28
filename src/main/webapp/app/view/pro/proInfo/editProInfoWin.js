Ext.define('BudgetMS.view.pro.proInfo.editProInfoWin', {
	extend : 'BudgetMS.view.pro.proInfo.baseProInfoWin',
	alias : 'widget.proInfoEdit',
	title : '项目信息修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateProInfo',
			action : 'pro/updateProInfo.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		var form=this.down('form');
		if(form)
			form.getForm().findField('proInfoId').readOnly = true;
	}
});