Ext.define('BudgetMS.view.pro.proInfo.addProInfoWin', {
	extend : 'BudgetMS.view.pro.proInfo.baseProInfoWin',
	alias : 'widget.proInfoAdd',
	title : '项目信息新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertProInfo',
			action : 'pro/insertProInfo.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form=this.down('form'); 
		if(form)
			form.getForm().findField('proInfoId').disabled=true;
	}
});
