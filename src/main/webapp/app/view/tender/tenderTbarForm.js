Ext.define('BudgetMS.view.tender.tenderTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.tenderTbarForm',
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
			name : 'tenderId',
			fieldLabel : '招标编号'
		}, {
			xtype : 'textfield',
			name : 'company',
			fieldLabel : '中标公司'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findInvo',
			action : 'tender/findTenderByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddInvo'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateInvo'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteInvo',
			action : 'tender/deleteTender.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'tenderAmt',
			fieldLabel : '中标金额',
			vtype : 'money'
		} , {
			xtype : 'textfield',
			name : 'tenderName',
			fieldLabel : '项目名称' 
		} ]
	}, {
		flex : 1,
		border : false,
		items : []
	} ]
});