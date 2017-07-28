Ext.define('BudgetMS.view.inst.divide.instDivideTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.instDivideTbarForm',
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
			name : 'instId',
			fieldLabel : '请示编号'
		}, {
			xtype : 'textfield',
			name : 'divideAmt',
			fieldLabel : '拆分金额',
			vtype : 'money'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findInstDivide',
			action : 'inst/findInstDivideByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddInstDivide'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateInstDivide'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteInstDivide',
			action : 'inst/deleteInstDivide.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'instDivideId',
			fieldLabel : '拆分编号'
		} ]
	} ]
});