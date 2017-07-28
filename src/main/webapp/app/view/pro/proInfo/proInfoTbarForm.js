Ext.define('BudgetMS.view.pro.proInfo.proInfoTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.proInfoTbarForm',
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
			name : 'proId',
			fieldLabel : '项目编号'
		}, {
			xtype : 'textfield',
			name : 'year',
			fieldLabel : '年度'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findProInfo',
			action : 'pro/findProInfoByProInfoperty.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddProInfo'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateProInfo'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteProInfo',
			action : 'pro/deleteProInfo.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'combo',
			name : 'proStatus',
			fieldLabel : '项目状态',
			valueField : 'typeId',
			displayField : 'typeName',
			emptyText : "请选择...",
			allowBlank : true,
			store : {
				fields : [ 'typeId', 'typeName' ],
				data : [ {
					"typeId" : "正常",
					"typeName" : "正常"
				}, {
					"typeId" : "取消",
					"typeName" : "取消"
				} ]
			}
		}, {
			xtype : 'textfield',
			name : 'proAmt',
			fieldLabel : '项目金额'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'proInfoId',
			fieldLabel : '项目信息编号'
		} ]
	} ]
});