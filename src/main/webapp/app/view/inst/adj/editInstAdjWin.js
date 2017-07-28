Ext.define('BudgetMS.view.inst.adj.editInstAdjWin', {
	extend : 'BudgetMS.view.inst.adj.baseInstAdjWin',
	alias : 'widget.instAdjEdit',
	title : '请示调整修改',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doUpdBtn',
			text : '更新',
			name : 'updateInstAdj',
			action : 'inst/updateInstAdj.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ]
		this.callParent(arguments);
		var form=this.down('form');
		if(form)
			form.getForm().findField('instId').readOnly = true;
	}
});