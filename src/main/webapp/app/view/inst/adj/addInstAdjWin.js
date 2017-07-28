Ext.define('BudgetMS.view.inst.adj.addInstAdjWin', {
	extend : 'BudgetMS.view.inst.adj.baseInstAdjWin',
	alias : 'widget.instAdjAdd',
	title : '请示调整新增',
	autoShow : true,
	initComponent : function() {
		this.buttons = [ {
			xtype : 'doAddBtn',
			text : '增加',
			name : 'insertInstAdj',
			action : 'inst/insertInstAdj.do'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
		var form=this.down('form'); 
		if(form)
			form.getForm().findField('instAdjId').disabled=true;
	}
});
