Ext.define('BudgetMS.view.invo.invoTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.invoTbarForm',
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
			name : 'invoId',
			fieldLabel : '发票编号'
		}, {
			xtype : 'textfield',
			name : 'invoCompany',
			fieldLabel : '公司'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findInvo',
			action : 'invo/getInvo.do'
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
			action : 'invo/deleteInvo.do'
		} , {
			xtype : 'doTransferBtn',
			text : '移交',
			name : 'transferInvo',
			action : 'invo/transferInvo.do'
		}]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'invoAmt',
			fieldLabel : '发票金额',
			vtype : 'money'
		} ,{
            xtype : 'datefield',
            name : 'transDate',
            fieldLabel : '移交日期',
            editable: true,
            emptyText: "--请选择--",
            format: "Y-m-d"
        } ]
	}, {
		flex : 1,
		border : false,
		items : []
	} ]
});