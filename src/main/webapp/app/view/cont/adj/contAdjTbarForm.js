Ext.define('BudgetMS.view.cont.adj.contAdjTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.contAdjTbarForm',
	layout : {
		type : 'hbox',
		align : 'stretch'
	},
	border : false,
	items : [ {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'contPaymentId',
			fieldLabel : '合同付款编号'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findContAdj',
			action : 'cont/findContAdjByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddContAdj'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateContAdj'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteContAdj',
			action : 'cont/deleteContAdj.do'
		} ]
	} ]
});