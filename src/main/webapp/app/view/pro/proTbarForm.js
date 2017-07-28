Ext.define('BudgetMS.view.pro.proTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.proTbarForm',
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
			name : 'proName',
			fieldLabel : '项目名称'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findPro',
			action : 'pro/findProByProperty.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddPro'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdatePro'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deletePro',
			action : 'pro/deletePro.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'combo',
			name : 'proType',
			fieldLabel : '项目类型',
			valueField : 'typeId',
			displayField : 'typeName',
			emptyText : "请选择...",
			allowBlank:true,
			store : {
				fields : [ 'typeId', 'typeName' ],
				data : [ {
					"typeId" : "项目建设",
					"typeName" : "项目建设"
				}, {
					"typeId" : "全行维保",
					"typeName" : "全行维保"
				}, {
					"typeId" : "基础运营",
					"typeName" : "基础运营"
				} ]
			}
		} ]
	} ]
});