Ext.define('BudgetMS.view.inst.adj.instAdjTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.instAdjTbarForm',
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
			name : 'instAdjId',
			fieldLabel : '请示调整编号'
		}, {
			xtype : 'textfield',
			name : 'instId',
			fieldLabel : '请示编号'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findInstAdj',
			action : 'inst/findInstAdjByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddInstAdj'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateInstAdj'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteInstAdj',
			action : 'inst/deleteInstAdj.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'instAdjAmt',
			fieldLabel : '请示调整金额',
			vtype : 'money'
		} ]
	} ]
});